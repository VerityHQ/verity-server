package io.swagger.api;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Content;
import io.swagger.model.Organization;
import io.swagger.model.Person;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.IContentService;
import io.swagger.persistence.service.IOrganizationService;
import io.swagger.persistence.service.IPersonService;
import site.verity.web.util.RestPreconditions;

@CrossOrigin(maxAge = 3600)  //origins = "localhost", to limit to a domain
@Controller
public class PersonApiController implements PersonApi {
	@Autowired
	private IPersonService personService;

	@Autowired
	private IAgentService agentService;
	
	@Autowired
	private IOrganizationService organizationService;
	
	@Autowired
	private IContentService contentService;
	

	/*
	 * UUIDs - allow caller to create UUIDs or let Verity generate them. If UUID
	 * is passed on creation, look up existing, if found throw error else create
	 * new object using caller UUID. If no UUID is passed, generate a new one
	 * (simulate blockchain or IPFS, etc.)
	 * 
	 * @see io.swagger.api.PersonApi#createPerson(io.swagger.model.Person)
	 */
	
	//TODO: fill out person dto with validation annotations
	public ResponseEntity<Person> createPerson(@ApiParam(value = "") @RequestBody @Valid Person body) {
		Assert.notNull(body);
		
		// Person is an agent + identity (has claims) + multi-key holder, 
		// but we would like person to be globally unique in Verity namespace as Identity.Organization
		// and also be sybil resistant. Upon creation we have no way to know
		// if our pseudo-person is controlled by an entity that is controlling 
		// multiple person identities (sybils)
		// so we will need other means to eliminate or weaken sybil accounts.
		// We could enforce some claims be attested to, or bonded links be created as well.
		
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertRequestElementProvided(body.getNickName(),
				"Nickname or screen name is required and must be unique");
		RestPreconditions.assertRequestElementProvided(body.getAgent());
		RestPreconditions.assertRequestElementProvided(body.getAgent().getUuid(),
				body.getClass().getSimpleName() + "-Agent UUID is required. Either set the UUID or send an empty string to create a new uuid.");		

		//ensure we have an existing organization
		RestPreconditions.assertRequestElementProvided(body.getOrganizationId());
		Organization organization = organizationService.findByUuid(body.getOrganizationId());
		RestPreconditions.assertSemanticsValid(organization != null,
				"Could not find an existing Organization using the organizationId provided");

		if (body.getUuid().isEmpty()) {
			// if caller did not provide UUID
			// simulate blockchain contract and create new UUID
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided		
			RestPreconditions.assertNoConflict(personService.findByUuid(body.getUuid()),
					"Connot create " + body.getClass().getSimpleName() + ": uuid exists allready.");
		}
		
		if (body.getAgent().getUuid().isEmpty()) {
			body.getAgent().setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided is unique (TODO: we may later allow for multiple agent-personas)
			RestPreconditions.assertNoConflict(agentService.findByUuid(body.getAgent().getUuid()),
			"Connot create " + body.getClass().getSimpleName() + "-Agent: uuid exists allready.");
		}
		
		agentService.create(body.getAgent());
		personService.create(body);
		organization.addIdentitiesItem(body.getUuid());
		organizationService.update(organization);
		return new ResponseEntity<Person>(body, HttpStatus.CREATED);
	}

	public ResponseEntity<Person> getPerson(
			@ApiParam(value = "multi-hash id of person record on the blockchain", required = true) 
			@PathVariable("uuid") String uuid) {
		
		Person person = personService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	public ResponseEntity<Void> updatePerson(@ApiParam(value = "") @RequestBody Person body) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required.");
		Person person = personService.findByUuid(body.getUuid());
		RestPreconditions.assertResourceFound(person);

		// notes on dealing with db ids - we are using UUIDs now for everything,
		// but this was not easy to understand and figure out so leaving it here.
		// see 3.3 Merge at
		// http://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
		// body is a transient instance of person. AbstractHibernateDao.update
		// will do a merge. Because we are using db ids in the background 
		// and our JSON from our API has no db id field, we need to 
		// fill it in before we do the update, or else hibernate merge
		// will try to create a new person

		//TODO: some fields should not be updatable
		
		personService.update(body);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //OK
	}

	@Override
	public ResponseEntity<BigDecimal> gETPersonUuidReputationCommunityidValuetypeidReputationtype(String uuid,
			String communityid, String valuetypeid, String reputationtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Content>> getPersonContent(String personUuid, String startDate, String endDate,
			Integer pageNumber, Integer pageSize) {
		//paging and date range are optional query parameters
		
		Person person = personService.findByUuid(personUuid);
		RestPreconditions.assertResourceFound(person);
		
		List<Content> content = contentService.findAllByAuthor(personUuid);
		
		return new ResponseEntity<List<Content>>(content, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Person>> getPersonByQueryParameters(String firstname, String lastname, String nickname) {
		Pageable p = new PageRequest(0, 1000);
		List<Person> persons = personService.findAllLike("nickname", nickname, p);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
}

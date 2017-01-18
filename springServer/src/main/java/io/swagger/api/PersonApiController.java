package io.swagger.api;

import io.swagger.model.Person;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.IPersonService;
import site.verity.web.exception.ResourceNotFoundException;
import site.verity.web.exception.UnprocessableEntityException;
import site.verity.web.util.RestPreconditions;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T20:12:14.806-08:00")

@Controller
public class PersonApiController implements PersonApi {

	@Autowired
	private IPersonService personService;

	@Autowired
	private IAgentService agentService;

	/*
	 * UUIDs - allow caller to create UUIDs or let Verity generate them. If UUID
	 * is passed on creation, look up existing, if found throw error else create
	 * new object using caller UUID If no UUID is passed, generate a new one
	 * (simulate blockchain of IPFS, etc.)
	 * 
	 * @see io.swagger.api.PersonApi#createPerson(io.swagger.model.Person)
	 */

	public ResponseEntity<Person> createPerson(@ApiParam(value = "") @RequestBody Person body) {

		RestPreconditions.assertRequestElementNotNull(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertRequestElementNotNull(body.getNickName(),
				"Nickname or screen name is required and must be unique");
		RestPreconditions.assertRequestElementNotNull(body.getAgent());
		RestPreconditions.assertSemanticsValid(personService.findByUuid(body.getUuid())==null,
				"Connot create. uuid not unique / exists allready.");
		RestPreconditions.assertRequestElementNotNull(body.getAgent().getUuid(),
				"Person-Agent UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		
		// TODO: need to decide if same agent can have multiple 'personas' (1:Many)
		// or one-to-one relationship.
		// for now person-agent is 1:1 relation so agent must be not exists on create
		RestPreconditions.assertSemanticsValid(agentService.findByUuid(body.getAgent().getUuid())==null, 
				"Person-Agent allready exists. At this time multiple personas per agent are not allowed.");
		
		// simulate blockchain contract and create new UUID
		body.getAgent().setUuid(java.util.UUID.randomUUID().toString());

		if (body.getUuid().isEmpty()) {
			// simulate blockchain contract and create new UUID
			body.setUuid(java.util.UUID.randomUUID().toString());
		} else {
			// do nothing, let caller manage creation of UUID
		}
		personService.create(body);
		return new ResponseEntity<Person>(body, HttpStatus.OK);
	}

	public ResponseEntity<Person> getPerson(
			@ApiParam(value = "multi-hash id of person record on the blockchain", required = true) 
			@PathVariable("uuid") String uuid) {
		
		Person person = personService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	public ResponseEntity<Void> updatePerson(@ApiParam(value = "") @RequestBody Person body) {
		
		Person person = personService.findByUuid(body.getUuid());
		RestPreconditions.assertResourceFound(person);

		// notes on dealing with db ids - we are using UUIDs now for everything,
		// but this was not easy to understand and figure out so leaving it here.
		// see 3.3 Merge at
		// http://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
		// body is a transient instance of person, AbstractHibernateDao.update
		// will do a merge. Because we are using db ids in the background 
		// and our JSON from our API has no db id field, we need to 
		// fill it in before we do the update, or else hibernate merge
		// will try to create a new person

		personService.update(body);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //OK
	}
}

package io.swagger.api;

import io.swagger.model.Agent;
import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.Person;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.IPersonService;
import io.swagger.annotations.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T20:12:14.806-08:00")

@Controller
public class PersonApiController implements PersonApi {

	@Autowired
	private IPersonService personService;
	
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Autowired
//	private IAgentService agentService;
//
//	private Session session;

	public ResponseEntity<String> createPerson(@ApiParam(value = "") @RequestBody Person body) {
		if(personService.findByUuid(body.getAgent().getUuid())!=null){
			//https://stackoverflow.com/questions/3825990/http-response-code-for-post-when-resource-already-exists?rq=1
			return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		//create the UUID if it has not been provided (our blockchain contract will do this, and we will pass it along)
		if(body.getUuid()==null){
			body.setUuid(java.util.UUID.randomUUID().toString());
		}
		personService.create(body);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public ResponseEntity<Person> getPerson(
			@ApiParam(value = "multi-hash id of person record on the blockchain", required = true) 
			@PathVariable("uuid") String uuid) {

		//session = sessionFactory.openSession();
		//Agent agent = agentService.findByUuid(uuid);
		
		Person person = personService.findByUuid(uuid);
		//session.close();
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	public ResponseEntity<Void> updatePerson(@ApiParam(value = "") @RequestBody Person body) {
		Person person = personService.findByUuid(body.getUuid());
		if(person == null){
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		// notes on dealing with db ids - we are using UUIDs now for everything, but this was 
		// not easy to understand and figure out so leaving it here.
		// see 3.3 Merge at
		// http://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
		// body is a transient instance of person, AbstractHibernateDao.update will do a merge.
		// Because we are using db ids in the background and our JSON from our API
		// has no db id field, we need to fill it in before we do the update, or hibernate merge
		// will try to create a new person
		// body.setUuid(person.getUuid());
		
		personService.update(body);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //OK but not returning any body content
	}
}

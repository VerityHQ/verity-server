package io.swagger.api;

import io.swagger.model.Agent;
import io.swagger.model.Community;
import io.swagger.model.Organization;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.ICommunityService;
import io.swagger.persistence.service.IOrganizationService;
import site.verity.web.util.RestPreconditions;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T13:41:55.542-08:00")

@Controller
public class OrganizationApiController implements OrganizationApi {

	@Autowired
	private IOrganizationService organizationService;
	
	@Autowired
	private ICommunityService communityService;
	
	@Autowired
	private IAgentService agentService;

	public ResponseEntity<Organization> createOrganization(
				@ApiParam(value = "") 
				@RequestBody Organization body) {
		Assert.notNull(body);
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertNoConflict(organizationService.findByUuid(body.getUuid()), 
				"Cannot create " + body.getClass().getSimpleName() + " - UUID exists allready.");
		RestPreconditions.assertRequestElementProvided(body.getAgent());
		RestPreconditions.assertRequestElementProvided(body.getAgent().getUuid(),
				body.getClass().getSimpleName() + "-Agent UUID is required. Either set the UUID or send an empty string to create a new uuid.");		

		if (body.getUuid().isEmpty()) {
			// if caller did not provide UUID
			// simulate blockchain contract and create new UUID
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided		
			RestPreconditions.assertNoConflict(organizationService.findByUuid(body.getUuid()),
					"Connot create " + body.getClass().getSimpleName() + ": uuid exists allready.");
		}
		
		Community community = body.getCommunity();
		if (community.getUuid().isEmpty()) {
			community.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 		
			RestPreconditions.assertNoConflict(communityService.findByUuid(community.getUuid()),
					"Connot create " + community.getClass().getSimpleName() + ": uuid exists allready.");
		}
		
		Agent organizationAgent = body.getAgent();
		if (organizationAgent.getUuid().isEmpty()) {
			organizationAgent.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided (note: we may later allow for multiple agent-personas)
			RestPreconditions.assertNoConflict(agentService.findByUuid(organizationAgent.getUuid()),
			"Connot create " + body.getClass().getSimpleName() + "-Organization Agent: uuid exists allready.");
		}

		Agent communityAgent = body.getCommunity().getAgent();		
		if (communityAgent.getUuid().isEmpty()) {
			communityAgent.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided (note: we may later allow for multiple agent-personas)
			RestPreconditions.assertNoConflict(agentService.findByUuid(communityAgent.getUuid()),
			"Connot create " + body.getClass().getSimpleName() + "-Community Agent: uuid exists allready.");
		}
		
		agentService.create(organizationAgent);
		agentService.create(communityAgent);
		communityService.create(body.getCommunity());
		organizationService.create(body);
		return new ResponseEntity<Organization>(body, HttpStatus.OK);
	}

	public ResponseEntity<Organization> getOrganization(
			@ApiParam(value = "", required = true) 
			@PathVariable("uuid") String uuid) {
		
		Organization organization = organizationService.findByUuid(uuid);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateOrganization(
			@ApiParam(value = "") 
			@RequestBody Organization body) {
		
		if (organizationService.findByUuid(body.getUuid()) != null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		// TODO: is it appropriate to modify organization after is has been in
		// use? What fields should we not allow changes on? 
		// How to do that (with annotations? e.g. @ReadOnly)
		organizationService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

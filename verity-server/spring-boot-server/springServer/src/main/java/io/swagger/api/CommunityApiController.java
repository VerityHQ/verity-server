package io.swagger.api;

import io.swagger.model.Community;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.ICommunityService;
import site.verity.web.exception.UnprocessableEntityException;
import site.verity.web.util.RestPreconditions;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class CommunityApiController implements CommunityApi {

	@Autowired
	private ICommunityService communityService;
	
	@Autowired
	private IAgentService agentService;

	public ResponseEntity<Community> createCommunity(@ApiParam(value = "") @RequestBody Community body) {

		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertRequestElementProvided(body.getAgent(), "Community-Agent is reqired");
		RestPreconditions.assertRequestElementProvided(body.getAgent().getUuid(),
				body.getClass().getSimpleName() + "-Agent UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		
		if (body.getUuid().isEmpty()) {
			// if caller did not provide UUID
			// simulate blockchain contract and create new UUID
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided		
			RestPreconditions.assertNoConflict(communityService.findByUuid(body.getUuid()),
			"Connot create " + body.getClass().getSimpleName() + ": uuid exists allready.");
		}
		
		if (body.getAgent().getUuid().isEmpty()) {
			body.getAgent().setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//check UUID provided	
			RestPreconditions.assertNoConflict(agentService.findByUuid(body.getAgent().getUuid()),
			"Connot create " + body.getClass().getSimpleName() + "-Agent: uuid exists allready.");
		}
		
		communityService.create(body);
		return new ResponseEntity<Community>(body, HttpStatus.CREATED);
	}

	public ResponseEntity<Community> getCommunity(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
		Community community = communityService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(community);
		return new ResponseEntity<Community>(community, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateCommunity(@ApiParam(value = "") @RequestBody Community body) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required.");
		RestPreconditions.assertResourceFound(communityService.findByUuid(body.getUuid()));
		communityService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

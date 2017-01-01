package io.swagger.api;

import io.swagger.model.Community;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.ICommunityService;
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
		// create the UUID if it has not been provided (our blockchain contract
		// will do this, and we will pass it along)
		if (body.getUuid().isEmpty()) {
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//use UUID provided
			if (communityService.findByUuid(body.getUuid()) != null) {
				return new ResponseEntity<Community>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		
		if (body.getAgent().getUuid().isEmpty()) {
			body.getAgent().setUuid(java.util.UUID.randomUUID().toString());
		}else{ 
			//use UUID provided
			if (agentService.findByUuid(body.getAgent().getUuid()) != null) {
				return new ResponseEntity<Community>(HttpStatus.UNPROCESSABLE_ENTITY);
			}
		}
		
		communityService.create(body);
		return new ResponseEntity<Community>(body, HttpStatus.CREATED);
	}

	public ResponseEntity<Community> getCommunity(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
		Community community = communityService.findByUuid(uuid);
		return new ResponseEntity<Community>(community, HttpStatus.OK);

	}

	public ResponseEntity<Void> updateCommunity(@ApiParam(value = "") @RequestBody Community body) {
		if (communityService.findByUuid(body.getUuid()) != null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		communityService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

package io.swagger.api;

import site.verity.web.util.RestPreconditions;

import io.swagger.annotations.*;
import io.swagger.model.ActionType;
import io.swagger.persistence.service.IActionTypeService;
import io.swagger.persistence.service.ICommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class ActiontypeApiController implements ActiontypeApi {

	@Autowired
	private IActionTypeService actionTypeService;
	@Autowired
	private ICommunityService communityService;

	public ResponseEntity<ActionType> createActiontype(@ApiParam(value = "") @RequestBody ActionType body) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertRequestElementProvided(body.getCommunityId(), body.getClass().getSimpleName()
				+ "Community UUID is required.");
		
		if (body.getUuid().isEmpty()) {
			//if they don't provide the UUID we create one for them
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else{
			RestPreconditions.assertNoConflict(actionTypeService.findByUuid(body.getUuid()),
					"Connot create " + body.getClass().getSimpleName() + ": uuid exists allready.");
		}
		
		RestPreconditions.assertSemanticsValid(communityService.findByUuid(body.getCommunityId()) !=null,
					"Connot create " + body.getClass().getSimpleName() + ": Community not found.");
		
		actionTypeService.create(body);
		return new ResponseEntity<ActionType>(body, HttpStatus.OK);
	}

	public ResponseEntity<ActionType> getActiontype(
			@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
		ActionType actionType = actionTypeService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(actionType);
		return new ResponseEntity<ActionType>(actionType, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateActiontype(@ApiParam(value = "") @RequestBody ActionType body) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertResourceFound(actionTypeService.findByUuid(body.getUuid()));
		// TODO: is it appropriate to modify actionType after is has been in
		// use?
		actionTypeService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

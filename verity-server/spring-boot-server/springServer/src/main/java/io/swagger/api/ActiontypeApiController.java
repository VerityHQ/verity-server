package io.swagger.api;

import io.swagger.persistence.service.IActionTypeService;
import site.verity.web.util.RestPreconditions;
import io.swagger.model.ActionType;

import io.swagger.annotations.*;

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

	public ResponseEntity<ActionType> createActiontype(@ApiParam(value = "") @RequestBody ActionType body) {
		RestPreconditions.checkRequestElementNotNull(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.checkSemantics(actionTypeService.findByUuid(body.getUuid())==null,
				"Connot create. uuid not unique / exists allready.");
		
		if (body.getUuid().isEmpty()) {
			//if they don't provide the UUID we create one for them
			body.setUuid(java.util.UUID.randomUUID().toString());
		}
		actionTypeService.create(body);
		return new ResponseEntity<ActionType>(body, HttpStatus.OK);
	}

	public ResponseEntity<ActionType> getActiontype(
			@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
		ActionType actionType = actionTypeService.findByUuid(uuid);
		RestPreconditions.checkResourceFound(actionType != null);
		return new ResponseEntity<ActionType>(actionType, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateActiontype(@ApiParam(value = "") @RequestBody ActionType body) {
		if (actionTypeService.findByUuid(body.getUuid()) == null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		// TODO: is it appropriate to modify actionType after is has been in
		// use?
		actionTypeService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ActionType;
import io.swagger.model.Valueaction;
import io.swagger.persistence.service.IValueActionService;
import site.verity.web.util.RestPreconditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class ValueactionApiController implements ValueactionApi {

	@Autowired
	private IValueActionService valueActionService;

	public ResponseEntity<Valueaction> createValueAction(@ApiParam(value = "") @RequestBody Valueaction body) {
		RestPreconditions.checkRequestElementNotNull(body.getUuid(), body.getClass().getSimpleName()
				+ "UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.checkRequestElementNotNull(body.getActionTypeId(), body.getClass().getSimpleName()
				+ "actionTypeId is required and cannot be null");

		
		if (body.getUuid().isEmpty()) {
			// create the UUID if it has not been provided (our blockchain
			// contract will do this, and we will pass it along)
			body.setUuid(java.util.UUID.randomUUID().toString());
		} else if (valueActionService.findByUuid(body.getUuid()) != null) {
			return new ResponseEntity<Valueaction>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		valueActionService.create(body);
		// return ActionType with newly generated UUID.
		return new ResponseEntity<Valueaction>(body, HttpStatus.OK);
	}

	public ResponseEntity<Valueaction> getValueAction( @ApiParam(value = "", required = true) @PathVariable("uuid") String uuid ) {
		Valueaction valueAction = valueActionService.findByUuid(uuid);
		RestPreconditions.checkResourceFound(valueAction != null);
		return new ResponseEntity<Valueaction>(valueAction, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateValueAction( @ApiParam(value = "") @RequestBody Valueaction body ) {
		Valueaction valueAction = valueActionService.findByUuid(body.getUuid());

		if (valueAction == null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (valueAction.getArchived() == true) {
			// frozen, cannot update
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		valueActionService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> archiveValueAction( @ApiParam(value = "", required = true) @PathVariable("uuid") String uuid ) {
		Valueaction valueAction = valueActionService.findByUuid(uuid);

		if (valueAction == null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		valueAction.setArchived(true);
		valueActionService.update(valueAction);
		return null;
	}

}

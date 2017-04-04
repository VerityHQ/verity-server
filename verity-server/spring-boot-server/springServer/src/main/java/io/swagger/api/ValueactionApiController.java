package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.ValueAction;
import io.swagger.persistence.service.IValueActionService;
import site.verity.web.util.RestPreconditions;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class ValueactionApiController implements ValueactionApi {

	@Autowired
	private IValueActionService valueActionService;

	public ResponseEntity<ValueAction> createValueAction(@ApiParam(value = "") @RequestBody ValueAction body) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ " UUID is required. Either set the UUID or send an empty string to create a new uuid.");
		RestPreconditions.assertRequestElementProvided(body.getActionTypeId(), body.getClass().getSimpleName()
				+ " actionTypeId is required and cannot be null");

		if (body.getUuid().isEmpty()) {
			// create the UUID if it has not been provided (our blockchain
			// contract will do this, and we will pass it along)
			body.setUuid(java.util.UUID.randomUUID().toString());
		} else {
			RestPreconditions.assertNoConflict(valueActionService.findByUuid(body.getUuid()), 
					"Cannot create " + body.getClass().getSimpleName() + " - UUID exists allready.");
		}
		valueActionService.create(body);
		return new ResponseEntity<ValueAction>(body, HttpStatus.OK);
	}

	public ResponseEntity<ValueAction> getValueAction( @ApiParam(value = "", required = true) @PathVariable("uuid") String uuid ) {
		ValueAction valueAction = valueActionService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(valueAction != null);
		return new ResponseEntity<ValueAction>(valueAction, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateValueAction( @ApiParam(value = "") @RequestBody ValueAction body ) {
		RestPreconditions.assertRequestElementProvided(body.getUuid(), body.getClass().getSimpleName()
				+ " UUID is required");
		ValueAction valueAction = valueActionService.findByUuid(body.getUuid());
		RestPreconditions.assertResourceFound(valueAction);
		RestPreconditions.assertSemanticsValid(valueAction.getArchived() == false, 
				body.getClass().getSimpleName() + " is archived and cannot be changed");
		valueActionService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> archiveValueAction( @ApiParam(value = "", required = true) @PathVariable("uuid") String uuid ) {
		ValueAction valueAction = valueActionService.findByUuid(uuid);
		RestPreconditions.assertResourceFound(valueAction);

		valueAction.setArchived(true);
		valueActionService.update(valueAction);
		return null;
	}

}

package io.swagger.api;

import io.swagger.persistence.service.IActionTypeService;
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
		
		if (body.getUuid().isEmpty()) {
			//create the UUID if it has not been provided (our blockchain contract will do this, and we will pass it along)
			body.setUuid(java.util.UUID.randomUUID().toString());
		}else if(actionTypeService.findByUuid(body.getUuid())!=null){
			return new ResponseEntity<ActionType>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		actionTypeService.create(body);
		//return ActionType with newly generated UUID.
		return new ResponseEntity<ActionType>(body, HttpStatus.OK);
	}

	public ResponseEntity<ActionType> getActiontype(@ApiParam(value = "", required = true) @PathVariable("uuid") String uuid) {
		ActionType actionType = actionTypeService.findByUuid(uuid);
		return new ResponseEntity<ActionType>(actionType, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateActiontype(

			@ApiParam(value = "") @RequestBody ActionType body

	) {
		if(actionTypeService.findByUuid(body.getUuid())==null){
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		//TODO: is it appropriate to modify actionType after is has been in use?
		actionTypeService.update(body); 
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

package io.swagger.api;

import io.swagger.model.Valueaction;
import io.swagger.persistence.service.IValueActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class ValueactionApiController implements ValueactionApi {

	@Autowired
	private IValueActionService valueActionService;

	public ResponseEntity<Valueaction> createValueAction(Valueaction body) {
		if(valueActionService.findByUuid(body.getUuid())!=null){
			return new ResponseEntity<Valueaction>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		//create the UUID if it has not been provided (our blockchain contract will do this, and we will pass it along)
		if(body.getUuid()==null){
			body.setUuid(java.util.UUID.randomUUID().toString());
		}
		valueActionService.create(body);
		//return ActionType with newly generated UUID.
		return new ResponseEntity<Valueaction>(body, HttpStatus.OK);
	}

	public ResponseEntity<Valueaction> getValueAction(String uuid) {
		Valueaction valueAction = valueActionService.findByUuid(uuid);
		return new ResponseEntity<Valueaction>(valueAction, HttpStatus.OK);
	}


	public ResponseEntity<Void> updateValueAction(Valueaction body) {
		Valueaction valueAction = valueActionService.findByUuid(body.getUuid());
		
		if(valueAction == null){
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if(valueAction.getArchived() == true){
			//frozen, cannot update
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		valueActionService.update(body); 
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> archiveValueAction(String uuid) {
		Valueaction valueAction = valueActionService.findByUuid(uuid);
		
		if(valueAction == null){
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		valueAction.setArchived(true);
		valueActionService.update(valueAction);
		return null;
	}

}

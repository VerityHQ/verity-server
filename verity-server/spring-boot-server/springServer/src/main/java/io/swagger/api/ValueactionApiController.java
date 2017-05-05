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


public class ValueactionApiController extends  ValueactionApiControllerBase implements ValueactionApi {

	@Override
	public ResponseEntity<Void> archiveValueAction(String uuid) {
		// TODO Auto-generated method stub
		return super.archiveValueAction(uuid);
	}

	@Override
	public ResponseEntity<ValueAction> createValueAction(ValueAction body) {
		// TODO Auto-generated method stub
		return super.createValueAction(body);
	}

	@Override
	public ResponseEntity<ValueAction> getValueAction(String uuid) {
		// TODO Auto-generated method stub
		return super.getValueAction(uuid);
	}

	@Override
	public ResponseEntity<Void> updateValueAction(ValueAction body) {
		// TODO Auto-generated method stub
		return super.updateValueAction(body);
	}
}

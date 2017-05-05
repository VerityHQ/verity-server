package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.IOrganizationService;
import io.swagger.persistence.service.IPersonService;
import io.swagger.persistence.service.ITransactionService;
import io.swagger.persistence.service.IValueActionService;
import site.verity.web.util.RestPreconditions;
import io.swagger.annotations.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import javax.validation.Valid;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class TransactionApiController extends TransactionApiControllerBase implements TransactionApi {

	@Override
	public ResponseEntity<Transaction> createTransaction(
			@ApiParam(value = "") @Valid @RequestBody Transaction body) {

		return super.createTransaction(body);
	}
	
	@Override
	public ResponseEntity<List<Transaction>> getTransactionByTargetAgentId(
			@ApiParam(value = "", required = true) @PathVariable("targetAgentId") String targetAgentId) {
		
		return super.getTransactionByTargetAgentId(targetAgentId); 
	}

	@Override
	public ResponseEntity<Transaction> getTransaction(String uuid, Transaction body) {
		// TODO Auto-generated method stub
		return super.getTransaction(uuid, body);
	}

	@Override
	public ResponseEntity<List<Transaction>> getTransactions(String startDate, String endDate, Integer pageNumber,
			Integer pageSize, String sourceAgentId, String targetAgentId, String valueActionId) {
		// TODO Auto-generated method stub
		return super.getTransactions(startDate, endDate, pageNumber, pageSize, sourceAgentId, targetAgentId, valueActionId);
	}
}

package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Transaction;
import io.swagger.persistence.service.ITransactionService;
import io.swagger.persistence.service.IValueActionService;
import site.verity.web.util.RestPreconditions;

@Controller
public class TransactionApiController implements TransactionApi {

	private static final DateTimeZone gmtTimeZone = DateTimeZone.forOffsetHours(0);
	
	@Autowired
	private ITransactionService transactionService;	

	@Autowired
	private IValueActionService valueActionService;	

	@Override
	public ResponseEntity<Transaction> createTransaction(
			@ApiParam(value = "") @Valid @RequestBody Transaction body) {
		//check for required parameters
		//check for valid parameters
		//check for collisions
		RestPreconditions.assertRequestElementProvided(body.getSourceAgentId());
		RestPreconditions.assertRequestElementProvided(body.getTargetAgentId());
		RestPreconditions.assertRequestElementProvided(body.getValueActionId());
		
		
		RestPreconditions.assertSemanticsValid(valueActionService.findByUuid(body.getValueActionId())!=null,
				"Could not find the ValueAction using the ValueActionId provided");
		body.setUuid(java.util.UUID.randomUUID().toString());
		body.setTimeStamp(DateTime.now(gmtTimeZone)); //TODO: ensure this is global time and precise enough
		transactionService.create(body);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}
	
	public ResponseEntity<List<Transaction>> getTransactionByTargetAgentId(
			@ApiParam(value = "", required = true) @PathVariable("targetAgentId") String targetAgentId) {
		
		return new ResponseEntity<List<Transaction>>(HttpStatus.OK);
	}

	public ResponseEntity<Transaction> getTransaction(String uuid, Transaction body) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<List<Transaction>> getTransactions(String startDate, String endDate, Integer pageNumber,
			Integer pageSize, String sourceAgentId, String targetAgentId, String valueActionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Transaction>> getTransactionsByAgent(String agentId, Integer pageNumber,
			Integer pageSize, String startDate, String endDate, String direction) {
		// TODO Auto-generated method stub
		return null;
	}
}

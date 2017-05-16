package io.swagger.api;

import java.util.Date;
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
import io.swagger.model.Transaction.Direction;
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
	public ResponseEntity<Transaction> getTransaction(String uuid) {
		Transaction transaction = transactionService.findByUuid(uuid);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Transaction>> getTransactionsByAgent(String agentId, Integer pageNumber,
			Integer pageSize, String startDate, String endDate, String direction) {
		DateTime startAsDate = DateTime.parse(startDate);
		DateTime endAsDate = DateTime.parse(endDate);
		//TODO: check dates are valid and in order
		
		RestPreconditions.assertSemanticsValid(Direction.valueOf(direction) != Direction.SOURCE || Direction.valueOf(direction) != Direction.TARGET);
		Direction directionEnum = Direction.valueOf(direction);
		
		//TODO: dates don't work, either create specific API method without dates or add to service 
		List<Transaction> transactionList = transactionService.getTransactionsForAgentPaged(agentId, pageNumber, pageSize, 
				startAsDate.toDate(), endAsDate.toDate(), directionEnum);
		
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
	}

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
		body.setTimeStamp(DateTime.now(gmtTimeZone).toString()); //TODO: ensure this is global time and precise enough
		transactionService.create(body);
		return new ResponseEntity<Transaction>(HttpStatus.OK);
	}



}

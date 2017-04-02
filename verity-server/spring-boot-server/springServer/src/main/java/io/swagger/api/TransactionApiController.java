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
public class TransactionApiController implements TransactionApi {

//	@Autowired
//	private IPersonService personService;
//
//	@Autowired
//	private IAgentService agentService;
	
	private static final DateTimeZone gmtTimeZone = DateTimeZone.forOffsetHours(0);

	@Autowired
	private ITransactionService transactionService;	

	@Autowired
	private IValueActionService valueActionService;	
	
	
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

	public ResponseEntity<Void> getTransactionByTargetAgentIdByValueActionId(
			@ApiParam(value = "", required = true) @PathVariable("targetAgentId") String targetAgentId, 
			@ApiParam(value = "", required = true) @PathVariable("valueActionId") String valueActionId) {
		// do some magic!
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<List<Transaction>> getTransactionsByDates(
			@ApiParam(value = "", required = true) @PathVariable("targetAgentId") String targetAgentId ,
			@ApiParam(value = "", required = true) @PathVariable("fromdate") String fromdate, 
			@ApiParam(value = "", required = true) @PathVariable("todate") String todate) {
		// do some magic!
		return new ResponseEntity<List<Transaction>>(HttpStatus.OK);
	}

}

package io.swagger.api;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Transaction;
import io.swagger.model.Transaction.Direction;
import io.swagger.persistence.service.ITransactionService;
import io.swagger.persistence.service.IValueActionService;
import site.verity.web.util.RestPreconditions;

@Controller
public class TransactionApiController implements TransactionApi {

	private static final DateTimeZone gmtTimeZone = DateTimeZone.forOffsetHours(0);
	//private static final String infuraMainNet =  //TODO: get from properties file
	
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
		
		return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Transaction> createTransaction(
			@ApiParam(value = "") @Valid @RequestBody Transaction body) {
		//TODO: check for required parameters
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
		
		// now commit to blockchain and return hash / token for checking status
		// we will need an unlocked account with some ETH in it to provide the
		// gas for the transaction.
		//
		// Next step will be to take in our token as payment.
		// One way to do this would be to have a simple contract that takes in
		// our token in escrow and we debit api calls from their token at the 
		// market rate. Behind the scenes we pay the gas and keep additional percentage
		// for our services. This does not utilize any economic incentives in our system
		// just a simple metering scheme that makes our token more 'utility like'

		Web3j web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/5oq0H9jhe954YhlknbCn"));
		Web3ClientVersion web3ClientVersion = null;
		EthBlockNumber blockNumber = null;
		try {
			web3ClientVersion = web3.web3ClientVersion().send();
			blockNumber = web3.ethBlockNumber().sendAsync().get();
		} catch (IOException | InterruptedException | ExecutionException e) {
			//TODO: better exception handling and logging
			throw new RuntimeException(e);
		}
		System.out.println(web3ClientVersion.getWeb3ClientVersion());
		System.out.println(blockNumber.getResult());
		
		return new ResponseEntity<Transaction>(body, HttpStatus.CREATED);
	}



}

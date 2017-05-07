package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-06T07:17:52.900-07:00")

@Api(value = "transaction", description = "the transaction API")
public interface TransactionApi {

    @ApiOperation(value = "create transaction", notes = "", response = Transaction.class, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "hash - Ethereum address of the transaction. For demo / proof of concept this will be a db id or offchain hash.", response = Transaction.class),
        @ApiResponse(code = 401, message = "", response = Transaction.class),
        @ApiResponse(code = 403, message = "", response = Transaction.class),
        @ApiResponse(code = 404, message = "", response = Transaction.class),
        @ApiResponse(code = 409, message = "", response = Transaction.class),
        @ApiResponse(code = 422, message = "", response = Transaction.class),
        @ApiResponse(code = 500, message = "", response = Transaction.class) })
    @RequestMapping(value = "/transaction",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Transaction> createTransaction(

@ApiParam(value = ""  ) @RequestBody Transaction body

);


    @ApiOperation(value = "get transaction", notes = "Get a specific transaction by id", response = Transaction.class, tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Transaction.class),
        @ApiResponse(code = 401, message = "", response = Transaction.class),
        @ApiResponse(code = 403, message = "", response = Transaction.class),
        @ApiResponse(code = 404, message = "", response = Transaction.class),
        @ApiResponse(code = 409, message = "", response = Transaction.class),
        @ApiResponse(code = 422, message = "", response = Transaction.class),
        @ApiResponse(code = 500, message = "", response = Transaction.class) })
    @RequestMapping(value = "/transaction/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Transaction> getTransaction(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = ""  ) @RequestBody Transaction body

);


    @ApiOperation(value = "get Transactions by AgentId", notes = "Get all transaction for an agent. Use query parameters to limit results. Transactions will be returned where the agent is both the source or the target unless limited by the 'direction' parameter.", response = Transaction.class, responseContainer = "List", tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Transaction.class),
        @ApiResponse(code = 401, message = "", response = Transaction.class),
        @ApiResponse(code = 403, message = "", response = Transaction.class),
        @ApiResponse(code = 404, message = "", response = Transaction.class),
        @ApiResponse(code = 409, message = "", response = Transaction.class),
        @ApiResponse(code = 422, message = "", response = Transaction.class),
        @ApiResponse(code = 500, message = "", response = Transaction.class) })
    @RequestMapping(value = "/transaction/agent/{agentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactionsByAgent(
@ApiParam(value = "",required=true ) @PathVariable("agentId") String agentId


,@ApiParam(value = "starting page number. Must be > 0.", required = true) @RequestParam(value = "pageNumber", required = true) Integer pageNumber



,@ApiParam(value = "number of records to return per page.", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize



,@ApiParam(value = "", required = true) @RequestParam(value = "startDate", required = true) String startDate



,@ApiParam(value = "", required = true) @RequestParam(value = "endDate", required = true) String endDate



,@ApiParam(value = "limit by source or target, e.g. the the agent is sending or receving the transaction.", allowableValues = "{values=[source, target], enumVars=[{name=SOURCE, value=\"source\"}, {name=TARGET, value=\"target\"}]}") @RequestParam(value = "direction", required = false) String direction



);

}

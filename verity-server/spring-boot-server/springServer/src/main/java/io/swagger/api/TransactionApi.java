package io.swagger.api;

import io.swagger.model.Transaction;
import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-04-17T18:13:27.632-07:00")

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


    @ApiOperation(value = "get a single transaction by its UUID", notes = "", response = Transaction.class, tags={ "Transaction", })
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


    @ApiOperation(value = "", notes = "", response = Transaction.class, responseContainer = "List", tags={ "Transaction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Transaction.class),
        @ApiResponse(code = 401, message = "", response = Transaction.class),
        @ApiResponse(code = 403, message = "", response = Transaction.class),
        @ApiResponse(code = 404, message = "", response = Transaction.class),
        @ApiResponse(code = 409, message = "", response = Transaction.class),
        @ApiResponse(code = 422, message = "", response = Transaction.class),
        @ApiResponse(code = 500, message = "", response = Transaction.class) })
    @RequestMapping(value = "/transaction",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Transaction>> getTransactions(@ApiParam(value = "") @RequestParam(value = "startDate", required = false) String startDate



,@ApiParam(value = "") @RequestParam(value = "endDate", required = false) String endDate



,@ApiParam(value = "starting page number. Must be > 0.") @RequestParam(value = "pageNumber", required = false) Integer pageNumber



,@ApiParam(value = "number of records to return per page.") @RequestParam(value = "pageSize", required = false) Integer pageSize



,@ApiParam(value = "") @RequestParam(value = "sourceAgentId", required = false) String sourceAgentId



,@ApiParam(value = "") @RequestParam(value = "targetAgentId", required = false) String targetAgentId



,@ApiParam(value = "") @RequestParam(value = "valueActionId", required = false) String valueActionId



);

}

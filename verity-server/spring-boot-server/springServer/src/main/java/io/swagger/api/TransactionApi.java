package io.swagger.api;

import io.swagger.model.Transaction;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

@Api(value = "transaction", description = "the transaction API")
public interface TransactionApi {

    @ApiOperation(value = "give reputation", notes = "", response = String.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "hash - Ethereum address of the transaction. For demo / proof of concept this will be a db id or offchain hash.", response = String.class) })
    @RequestMapping(value = "/transaction",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> transactionPost(@ApiParam(value = ""  ) @RequestBody Transaction body);

}

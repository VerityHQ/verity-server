package io.swagger.api;

import io.swagger.model.InlineResponse403;
import io.swagger.model.Transaction;
import io.swagger.model.InlineResponse404;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class TransactionApiController implements TransactionApi {

    public ResponseEntity<Transaction> createTransaction(

@ApiParam(value = ""  ) @RequestBody Transaction body

) {
        // do some magic!
        return new ResponseEntity<Transaction>(HttpStatus.OK);
    }

    public ResponseEntity<List<Transaction>> getTransactionByTargetAgentId(
@ApiParam(value = "",required=true ) @PathVariable("targetAgentId") String targetAgentId


) {
        // do some magic!
        return new ResponseEntity<List<Transaction>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getTransactionByTargetAgentIdByValueActionId(
@ApiParam(value = "",required=true ) @PathVariable("targetAgentId") String targetAgentId


,
        
@ApiParam(value = "",required=true ) @PathVariable("valueActionId") String valueActionId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Transaction>> getTransactionsByDates(
@ApiParam(value = "",required=true ) @PathVariable("targetAgentId") String targetAgentId


,
        
@ApiParam(value = "",required=true ) @PathVariable("fromdate") String fromdate


,
        
@ApiParam(value = "",required=true ) @PathVariable("todate") String todate


) {
        // do some magic!
        return new ResponseEntity<List<Transaction>>(HttpStatus.OK);
    }

}

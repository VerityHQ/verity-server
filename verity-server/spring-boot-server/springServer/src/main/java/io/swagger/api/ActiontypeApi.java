package io.swagger.api;

import io.swagger.model.ActionType;

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

@Api(value = "actiontype", description = "the actiontype API")
public interface ActiontypeApi {

    @ApiOperation(value = "get an ActionType by id", notes = "", response = ActionType.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = ActionType.class) })
    @RequestMapping(value = "/actiontype",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ActionType> actiontypeGet(@ApiParam(value = "") @RequestParam(value = "id", required = false) String id);


    @ApiOperation(value = "create ActionType", notes = "", response = Void.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class) })
    @RequestMapping(value = "/actiontype",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> actiontypePost(@ApiParam(value = ""  ) @RequestBody ActionType body);


    @ApiOperation(value = "update ActionType", notes = "", response = Void.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class) })
    @RequestMapping(value = "/actiontype",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> actiontypePut(@ApiParam(value = ""  ) @RequestBody ActionType body);

}

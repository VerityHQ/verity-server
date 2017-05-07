package io.swagger.api;

import io.swagger.model.ActionType;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-06T07:17:52.900-07:00")

@Api(value = "actiontype", description = "the actiontype API")
public interface ActiontypeApi {

    @ApiOperation(value = "create ActionType", notes = "", response = ActionType.class, tags={ "ActionType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Status 200", response = ActionType.class),
        @ApiResponse(code = 401, message = "", response = ActionType.class),
        @ApiResponse(code = 403, message = "", response = ActionType.class),
        @ApiResponse(code = 404, message = "", response = ActionType.class),
        @ApiResponse(code = 409, message = "", response = ActionType.class),
        @ApiResponse(code = 422, message = "", response = ActionType.class),
        @ApiResponse(code = 500, message = "", response = ActionType.class) })
    @RequestMapping(value = "/actiontype",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ActionType> createActiontype(

@ApiParam(value = ""  ) @RequestBody ActionType body

);


    @ApiOperation(value = "get ActionType", notes = "", response = ActionType.class, tags={ "ActionType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = ActionType.class) })
    @RequestMapping(value = "/actiontype/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ActionType> getActiontype(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "update ActionType", notes = "", response = Void.class, tags={ "ActionType", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 409, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/actiontype",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateActiontype(

@ApiParam(value = ""  ) @RequestBody ActionType body

);

}

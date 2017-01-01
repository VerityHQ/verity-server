package io.swagger.api;

import io.swagger.model.Valueaction;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T13:41:55.542-08:00")

@Api(value = "valueaction", description = "the valueaction API")
public interface ValueactionApi {

    @ApiOperation(value = "archive ValueAction", notes = "", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/valueaction/{uuid}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> archiveValueAction(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "create ValueAction", notes = "", response = Valueaction.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "", response = Valueaction.class),
        @ApiResponse(code = 401, message = "", response = Valueaction.class),
        @ApiResponse(code = 403, message = "", response = Valueaction.class),
        @ApiResponse(code = 404, message = "", response = Valueaction.class),
        @ApiResponse(code = 422, message = "", response = Valueaction.class),
        @ApiResponse(code = 500, message = "", response = Valueaction.class) })
    @RequestMapping(value = "/valueaction",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Valueaction> createValueAction(

@ApiParam(value = ""  ) @RequestBody Valueaction body

);


    @ApiOperation(value = "get ValueAction", notes = "", response = Valueaction.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Valueaction.class) })
    @RequestMapping(value = "/valueaction/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Valueaction> getValueAction(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "update ValueAction", notes = "", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/valueaction",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateValueAction(

@ApiParam(value = ""  ) @RequestBody Valueaction body

);

}

package io.swagger.api;

import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.Valueaction;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-01T16:45:12.037-08:00")

@Api(value = "valueaction", description = "the valueaction API")
public interface ValueactionApi {

    @ApiOperation(value = "archive ValueAction", notes = "", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 409, message = "", response = Void.class),
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
        @ApiResponse(code = 409, message = "", response = Valueaction.class),
        @ApiResponse(code = 422, message = "", response = Valueaction.class),
        @ApiResponse(code = 500, message = "", response = Valueaction.class) })
    @RequestMapping(value = "/valueaction",
        produces = { "application/json" }, 
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


    @ApiOperation(value = "update ValueAction", notes = "Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 409, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/valueaction",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateValueAction(

@ApiParam(value = ""  ) @RequestBody Valueaction body

);

}

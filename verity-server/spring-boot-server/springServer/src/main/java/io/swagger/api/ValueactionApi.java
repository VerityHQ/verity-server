/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.ValueAction;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-27T15:39:32.532-07:00")

@Api(value = "valueaction", description = "the valueaction API")
public interface ValueactionApi {

    @ApiOperation(value = "archive ValueAction", notes = "", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Object.class),
        @ApiResponse(code = 403, message = "", response = InlineResponse403.class),
        @ApiResponse(code = 404, message = "", response = InlineResponse404.class),
        @ApiResponse(code = 409, message = "", response = Object.class),
        @ApiResponse(code = 422, message = "", response = Object.class),
        @ApiResponse(code = 500, message = "", response = Object.class) })
    
    @RequestMapping(value = "/valueaction/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> archiveValueAction(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid);


    @ApiOperation(value = "create ValueAction", notes = "", response = ValueAction.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "", response = ValueAction.class),
        @ApiResponse(code = 401, message = "", response = Object.class),
        @ApiResponse(code = 403, message = "", response = InlineResponse403.class),
        @ApiResponse(code = 404, message = "", response = InlineResponse404.class),
        @ApiResponse(code = 409, message = "", response = Object.class),
        @ApiResponse(code = 422, message = "", response = Object.class),
        @ApiResponse(code = 500, message = "", response = Object.class) })
    
    @RequestMapping(value = "/valueaction",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ValueAction> createValueAction(@ApiParam(value = ""  )  @Valid @RequestBody ValueAction body);


    @ApiOperation(value = "get ValueAction", notes = "", response = ValueAction.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = ValueAction.class) })
    
    @RequestMapping(value = "/valueaction/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ValueAction> getValueAction(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid);


    @ApiOperation(value = "update ValueAction", notes = "Updating the value of the ValueAction will cause any calculations in the future to use this new value, changing the rewards retroactivly. If you want to prohibit these types of retroactive changes, set the archived bit to true and create a new ValueAction and use it going forward.", response = Void.class, tags={ "ValueAction", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Object.class),
        @ApiResponse(code = 403, message = "", response = InlineResponse403.class),
        @ApiResponse(code = 404, message = "", response = InlineResponse404.class),
        @ApiResponse(code = 409, message = "", response = Object.class),
        @ApiResponse(code = 422, message = "", response = Object.class),
        @ApiResponse(code = 500, message = "", response = Object.class) })
    
    @RequestMapping(value = "/valueaction",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateValueAction(@ApiParam(value = ""  )  @Valid @RequestBody ValueAction body);

}

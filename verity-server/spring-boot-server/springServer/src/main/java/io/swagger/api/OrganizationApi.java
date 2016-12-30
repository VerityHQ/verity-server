package io.swagger.api;

import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.Organization;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Api(value = "organization", description = "the organization API")
public interface OrganizationApi {

    @ApiOperation(value = "create an Organization", notes = "", response = Object.class, tags={ "Organization", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "", response = Object.class),
        @ApiResponse(code = 401, message = "", response = Object.class),
        @ApiResponse(code = 403, message = "", response = Object.class),
        @ApiResponse(code = 404, message = "", response = Object.class),
        @ApiResponse(code = 422, message = "", response = Object.class),
        @ApiResponse(code = 500, message = "Status 500", response = Object.class) })
    @RequestMapping(value = "/organization",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Object> createOrganization(

@ApiParam(value = ""  ) @RequestBody Organization body

);


    @ApiOperation(value = "get organization", notes = "", response = Organization.class, tags={ "Organization", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Organization.class) })
    @RequestMapping(value = "/organization/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Organization> getOrganization(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "update Organization", notes = "", response = Void.class, tags={ "Organization", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/organization",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateOrganization(

@ApiParam(value = ""  ) @RequestBody String body

);

}

package io.swagger.api;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

@Api(value = "organization", description = "the organization API")
public interface OrganizationApi {

    @ApiOperation(value = "get an organization by id", notes = "", response = Organization.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Organization.class) })
    @RequestMapping(value = "/organization",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Organization> organizationGet(@ApiParam(value = "", required = true) @RequestParam(value = "id", required = true) String id);


    @ApiOperation(value = "create an Organization", notes = "", response = String.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = String.class),
        @ApiResponse(code = 500, message = "Status 500", response = String.class) })
    @RequestMapping(value = "/organization",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> organizationPost(@ApiParam(value = ""  ) @RequestBody Organization body);

}

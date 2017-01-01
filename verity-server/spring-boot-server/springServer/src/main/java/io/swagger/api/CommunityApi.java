package io.swagger.api;

import io.swagger.model.Community;
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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T18:38:33.176-08:00")

@Api(value = "community", description = "the community API")
public interface CommunityApi {

    @ApiOperation(value = "create a Community", notes = "", response = Community.class, tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "", response = Community.class),
        @ApiResponse(code = 401, message = "", response = Community.class),
        @ApiResponse(code = 403, message = "", response = Community.class),
        @ApiResponse(code = 404, message = "", response = Community.class),
        @ApiResponse(code = 409, message = "", response = Community.class),
        @ApiResponse(code = 422, message = "", response = Community.class),
        @ApiResponse(code = 500, message = "", response = Community.class) })
    @RequestMapping(value = "/community",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Community> createCommunity(

@ApiParam(value = ""  ) @RequestBody Community body

);


    @ApiOperation(value = "get community", notes = "", response = Community.class, tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Community.class) })
    @RequestMapping(value = "/community/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Community> getCommunity(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "update a community", notes = "", response = Void.class, tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 409, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/community",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCommunity(

@ApiParam(value = ""  ) @RequestBody Community body

);

}

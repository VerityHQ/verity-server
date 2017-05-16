package io.swagger.api;

import io.swagger.model.Community;
import io.swagger.model.Content;
import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.Person;

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
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-14T11:27:43.869-07:00")

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
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Community> createCommunity(@ApiParam(value = ""  ) @RequestBody Community body);


    @ApiOperation(value = "get community", notes = "", response = Community.class, tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Community.class) })
    @RequestMapping(value = "/community/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Community> getCommunity(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid);


    @ApiOperation(value = "get community content", notes = "", response = Content.class, responseContainer = "List", tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Content.class) })
    @RequestMapping(value = "/community/{uuid}/content",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Content>> getCommunityContent(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid);


    @ApiOperation(value = "get community members", notes = "", response = Person.class, responseContainer = "List", tags={ "Community", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = Person.class) })
    @RequestMapping(value = "/community/{uuid}/members",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Person>> getCommunityMembers(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid);


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
    ResponseEntity<Void> updateCommunity(@ApiParam(value = ""  ) @RequestBody Community body);

}

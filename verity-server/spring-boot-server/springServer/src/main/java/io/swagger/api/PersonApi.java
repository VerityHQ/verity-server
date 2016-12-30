package io.swagger.api;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Api(value = "person", description = "the person API")
public interface PersonApi {

    @ApiOperation(value = "create person", notes = "", response = String.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "muilti-hash blockchain id for the newly created person account", response = String.class),
        @ApiResponse(code = 401, message = "", response = String.class),
        @ApiResponse(code = 403, message = "", response = String.class),
        @ApiResponse(code = 404, message = "", response = String.class),
        @ApiResponse(code = 422, message = "", response = String.class),
        @ApiResponse(code = 500, message = "", response = String.class) })
    @RequestMapping(value = "/person",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> createPerson(

@ApiParam(value = ""  ) @RequestBody Person body

);


    @ApiOperation(value = "get Person", notes = "", response = Person.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Person.class) })
    @RequestMapping(value = "/person/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Person> getPerson(
@ApiParam(value = "multi-hash id of person record on the blockchain",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "update person", notes = "", response = Void.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/person",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePerson(

@ApiParam(value = ""  ) @RequestBody Person body

);

}

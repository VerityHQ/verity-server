package io.swagger.api;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

@Api(value = "person", description = "the person API")
public interface PersonApi {

    @ApiOperation(value = "get a person by id", notes = "", response = Person.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Person.class) })
    @RequestMapping(value = "/person",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Person> personGet(@ApiParam(value = "multi-hash id of person record on the blockchain", required = true) @RequestParam(value = "id", required = true) String id);


    @ApiOperation(value = "create person", notes = "", response = String.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "muilti-hash blockchain id for the newly created person account", response = String.class) })
    @RequestMapping(value = "/person",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<String> personPost(@ApiParam(value = ""  ) @RequestBody Person body);


    @ApiOperation(value = "update person", notes = "", response = Void.class, authorizations = {
        @Authorization(value = "Basic Auth")
    }, tags={ "Core Methods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class) })
    @RequestMapping(value = "/person",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> personPut(@ApiParam(value = ""  ) @RequestBody Person body);

}

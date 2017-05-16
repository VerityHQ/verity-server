package io.swagger.api;

import java.math.BigDecimal;
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

@Api(value = "person", description = "the person API")
public interface PersonApi {

    @ApiOperation(value = "create person", notes = "", response = Person.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "muilti-hash blockchain id for the newly created person account", response = Person.class),
        @ApiResponse(code = 401, message = "", response = Person.class),
        @ApiResponse(code = 403, message = "", response = Person.class),
        @ApiResponse(code = 404, message = "", response = Person.class),
        @ApiResponse(code = 409, message = "", response = Person.class),
        @ApiResponse(code = 422, message = "", response = Person.class),
        @ApiResponse(code = 500, message = "", response = Person.class) })
    @RequestMapping(value = "/person",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Person> createPerson(@ApiParam(value = ""  ) @RequestBody Person body);


    @ApiOperation(value = "get person reputation", notes = "Get the reputation as calculated by the algorithm requested in the reputationtype parameter.", response = BigDecimal.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "", response = BigDecimal.class) })
    @RequestMapping(value = "/person/{uuid}/reputation/{communityid}/{valuetypeid}/{reputationtype}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BigDecimal> gETPersonUuidReputationCommunityidValuetypeidReputationtype(@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid,
        @ApiParam(value = "",required=true ) @PathVariable("communityid") String communityid,
        @ApiParam(value = "",required=true ) @PathVariable("valuetypeid") String valuetypeid,
        @ApiParam(value = "",required=true ) @PathVariable("reputationtype") String reputationtype);


    @ApiOperation(value = "get Person", notes = "", response = Person.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Person.class) })
    @RequestMapping(value = "/person/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Person> getPerson(@ApiParam(value = "multi-hash id of person record on the blockchain",required=true ) @PathVariable("uuid") String uuid);


    @ApiOperation(value = "get Person Content", notes = "Get all the content this person has authored or co-authored", response = Content.class, responseContainer = "List", tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Content.class) })
    @RequestMapping(value = "/person/{uuid}/content",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Content>> getPersonContent(@ApiParam(value = "multi-hash id of person record on the blockchain",required=true ) @PathVariable("uuid") String uuid,
         @NotNull @ApiParam(value = "", required = true) @RequestParam(value = "startDate", required = true) String startDate,
         @NotNull @ApiParam(value = "", required = true) @RequestParam(value = "endDate", required = true) String endDate,
         @NotNull @Min(1) @ApiParam(value = "starting page number. Must be > 0.", required = true) @RequestParam(value = "pageNumber", required = true) Integer pageNumber,
         @NotNull @Min(1) @Max(1000) @ApiParam(value = "number of records to return per page.", required = true) @RequestParam(value = "pageSize", required = true) Integer pageSize);


    @ApiOperation(value = "update person", notes = "", response = Void.class, tags={ "Person", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Status 200", response = Void.class),
        @ApiResponse(code = 401, message = "", response = Void.class),
        @ApiResponse(code = 403, message = "", response = Void.class),
        @ApiResponse(code = 404, message = "", response = Void.class),
        @ApiResponse(code = 409, message = "", response = Void.class),
        @ApiResponse(code = 422, message = "", response = Void.class),
        @ApiResponse(code = 500, message = "", response = Void.class) })
    @RequestMapping(value = "/person",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePerson(@ApiParam(value = ""  ) @RequestBody Person body);

}

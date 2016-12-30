package io.swagger.api;

import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.Valueaction;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-28T16:27:10.767-08:00")

@Controller
public class ValueactionApiController implements ValueactionApi {

    public ResponseEntity<Void> archiveValueAction(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> createValueAction(

@ApiParam(value = ""  ) @RequestBody Valueaction body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Valueaction> getValueAction(
@ApiParam(value = "",required=true ) @PathVariable("uuid") String uuid


) {
        // do some magic!
        return new ResponseEntity<Valueaction>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateValueAction(

@ApiParam(value = ""  ) @RequestBody Valueaction body

) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

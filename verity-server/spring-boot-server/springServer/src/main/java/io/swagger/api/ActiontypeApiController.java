package io.swagger.api;

import io.swagger.model.ActionType;

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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-11-16T05:42:22.193Z")

@Controller
public class ActiontypeApiController implements ActiontypeApi {

    public ResponseEntity<ActionType> actiontypeGet(@ApiParam(value = "") @RequestParam(value = "id", required = false) String id) {
        // do some magic!
        return new ResponseEntity<ActionType>(HttpStatus.OK);
    }

    public ResponseEntity<Void> actiontypePost(@ApiParam(value = ""  ) @RequestBody ActionType body) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> actiontypePut(@ApiParam(value = ""  ) @RequestBody ActionType body) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

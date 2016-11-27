package io.swagger.api;

import io.swagger.model.Organization;

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
public class OrganizationApiController implements OrganizationApi {

    public ResponseEntity<Organization> organizationGet(@ApiParam(value = "", required = true) @RequestParam(value = "id", required = true) String id) {
        // do some magic!
        return new ResponseEntity<Organization>(HttpStatus.OK);
    }

    public ResponseEntity<String> organizationPost(@ApiParam(value = ""  ) @RequestBody Organization body) {
        // do some magic!
    	
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}

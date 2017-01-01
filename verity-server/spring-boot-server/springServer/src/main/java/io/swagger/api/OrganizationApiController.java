package io.swagger.api;

import io.swagger.model.Organization;
import io.swagger.persistence.service.IOrganizationService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T13:41:55.542-08:00")

@Controller
public class OrganizationApiController implements OrganizationApi {

	@Autowired
	private IOrganizationService organizationService;

	public ResponseEntity<Organization> createOrganization(
				@ApiParam(value = "") 
				@RequestBody Organization body) {
		
		if (organizationService.findByUuid(body.getUuid()) != null) {
			return new ResponseEntity<Organization>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		// create the UUID if it has not been provided (our blockchain contract
		// will do this, and we will pass it along)
		if (body.getUuid() == null) {
			body.setUuid(java.util.UUID.randomUUID().toString());
		}
		organizationService.create(body);
		return new ResponseEntity<Organization>(HttpStatus.OK);
	}

	public ResponseEntity<Organization> getOrganization(
			@ApiParam(value = "", required = true) 
			@PathVariable("uuid") String uuid) {
		
		Organization organization = organizationService.findByUuid(uuid);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}

	public ResponseEntity<Void> updateOrganization(
			@ApiParam(value = "") 
			@RequestBody Organization body) {
		
		if (organizationService.findByUuid(body.getUuid()) != null) {
			return new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		// TODO: is it appropriate to modify organization after is has been in
		// use? What fields should we not allow changes on? 
		// How to do that (with annotations? e.g. @ReadOnly)
		organizationService.update(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

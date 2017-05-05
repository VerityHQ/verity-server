package io.swagger.api;

import io.swagger.model.Person;
import io.swagger.model.ReputationCalculation;
import io.swagger.persistence.service.IAgentService;
import io.swagger.persistence.service.IOrganizationService;
import io.swagger.persistence.service.IPersonService;
import site.verity.web.exception.ResourceNotFoundException;
import site.verity.web.exception.UnprocessableEntityException;
import site.verity.web.util.RestPreconditions;
import io.swagger.annotations.*;

import java.math.BigDecimal;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-26T20:12:14.806-08:00")

public class PersonApiController extends PersonApiControllerBase implements PersonApi {

	@Override
	public ResponseEntity<Person> createPerson(Person body) {
		// TODO Auto-generated method stub
		return super.createPerson(body);
	}

	@Override
	public ResponseEntity<Person> getPerson(String uuid) {
		// TODO Auto-generated method stub
		return super.getPerson(uuid);
	}

	@Override
	public ResponseEntity<Void> updatePerson(Person body) {
		// TODO Auto-generated method stub
		return super.updatePerson(body);
	}

	@Override
	public ResponseEntity<BigDecimal> gETPersonUuidReputationCommunityidValuetypeidReputationtype(String uuid,
			String communityid, String valuetypeid, String reputationtype, ReputationCalculation body) {
		// TODO Auto-generated method stub
		return super.gETPersonUuidReputationCommunityidValuetypeidReputationtype(uuid, communityid, valuetypeid, reputationtype,
				body);
	}
	

}

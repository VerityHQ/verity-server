package io.swagger.persistence.service;

import site.verity.persistence.dao.common.IOperations;

import java.util.List;

import org.springframework.data.domain.Pageable;

import io.swagger.model.Person;

public interface IPersonService extends IOperations<Person>{

	Person findByNickname(String nickname);
	
	List<Person> findAllByOrganizationId(String uuid, Pageable pageable);

}

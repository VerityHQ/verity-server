package io.swagger.persistence.dao;

import site.verity.persistence.dao.common.IOperations;

import java.util.List;

import io.swagger.model.Person;

public interface IPersonDao extends IOperations<Person> {

	Person findByNickname(String nickname);

	List<Person> findAllByOrganizationId(String uuid, Integer pageNumber, Integer pageSize);
}

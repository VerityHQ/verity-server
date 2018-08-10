package io.swagger.persistence.service.impl;


import site.verity.persistence.dao.common.IOperations;
import site.verity.persistence.service.common.AbstractService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Person;
import io.swagger.persistence.dao.IPersonDao;
import io.swagger.persistence.service.IPersonService;

@Service
public class PersonService extends AbstractService<Person> implements IPersonService {

    @Autowired
    private IPersonDao dao;

    public PersonService() {
        super();
    }

    @Override
    protected IOperations<Person> getDao() {
        return dao;
    }

	@Override
	public Person findByNickname(String nickname) {
		return dao.findByNickname(nickname);
	}

	@Override
	public List<Person> findAllByOrganizationId(String uuid, Pageable pageable) {
		return dao.findAllByOrganizationId(uuid, pageable.getPageNumber(), pageable.getPageSize());
	}

}

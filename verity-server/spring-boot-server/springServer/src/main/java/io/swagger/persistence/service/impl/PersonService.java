package io.swagger.persistence.service.impl;


import org.baeldung.persistence.dao.common.IOperations;
import org.baeldung.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // API

    @Override
    protected IOperations<Person> getDao() {
        return dao;
    }

}

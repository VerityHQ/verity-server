package io.swagger.persistence.dao.impl;

import org.baeldung.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Person;
import io.swagger.persistence.dao.IPersonDao;

@Repository
public class PersonDao extends AbstractHibernateDao<Person> implements IPersonDao {

    public PersonDao() {
        super();

        setClazz(Person.class);
    }

    // API

}
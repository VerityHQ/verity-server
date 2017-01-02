package io.swagger.persistence.dao.impl;

import org.baeldung.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Valueaction;
import io.swagger.persistence.dao.IValueActionDao;

@Repository
public class ValueActionDao extends AbstractHibernateDao<Valueaction> implements IValueActionDao {

    public ValueActionDao() {
        super();

        setClazz(Valueaction.class);
    }

    // API

}
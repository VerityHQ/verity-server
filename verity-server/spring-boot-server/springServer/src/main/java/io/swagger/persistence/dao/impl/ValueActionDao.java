package io.swagger.persistence.dao.impl;

import org.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.ValueAction;
import io.swagger.persistence.dao.IValueActionDao;

@Repository
public class ValueActionDao extends AbstractHibernateDao<ValueAction> implements IValueActionDao {

    public ValueActionDao() {
        super();

        setClazz(ValueAction.class);
    }

    // API

}
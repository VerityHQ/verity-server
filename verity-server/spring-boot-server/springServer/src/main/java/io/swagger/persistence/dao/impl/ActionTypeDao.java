package io.swagger.persistence.dao.impl;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.ActionType;
import io.swagger.persistence.dao.IActionTypeDao;

@Repository
public class ActionTypeDao extends AbstractHibernateDao<ActionType> implements IActionTypeDao {

    public ActionTypeDao() {
        super();

        setClazz(ActionType.class);
    }

    // API

}
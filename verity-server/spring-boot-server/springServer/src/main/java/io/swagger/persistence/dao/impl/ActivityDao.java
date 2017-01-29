package io.swagger.persistence.dao.impl;

import org.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Activity;
import io.swagger.persistence.dao.IActivityDao;

@Repository
public class ActivityDao extends AbstractHibernateDao<Activity> implements IActivityDao {

    public ActivityDao() {
        super();

        setClazz(Activity.class);
    }

    // API

}
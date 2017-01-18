package io.swagger.persistence.dao.impl;

import org.baeldung.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Entity;
import io.swagger.persistence.dao.IEntityDao;

@Repository
public class EntityDao extends AbstractHibernateDao<Entity> implements IEntityDao {

    public EntityDao() {
        super();

        setClazz(Entity.class);
    }

    // API

}
package io.swagger.persistence.dao.impl;

import org.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Community;
import io.swagger.persistence.dao.ICommunityDao;

@Repository
public class CommunityDao extends AbstractHibernateDao<Community> implements ICommunityDao {

    public CommunityDao() {
        super();

        setClazz(Community.class);
    }

    // API

}
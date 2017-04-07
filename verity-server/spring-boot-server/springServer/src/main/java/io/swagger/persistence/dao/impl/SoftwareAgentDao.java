package io.swagger.persistence.dao.impl;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.SoftwareAgent;
import io.swagger.persistence.dao.ISoftwareAgentDao;

@Repository
public class SoftwareAgentDao extends AbstractHibernateDao<SoftwareAgent> implements ISoftwareAgentDao {

    public SoftwareAgentDao() {
        super();

        setClazz(SoftwareAgent.class);
    }

    // API

}
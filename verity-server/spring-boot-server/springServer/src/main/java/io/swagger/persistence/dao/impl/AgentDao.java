package io.swagger.persistence.dao.impl;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Agent;
import io.swagger.persistence.dao.IAgentDao;

@Repository
public class AgentDao extends AbstractHibernateDao<Agent> implements IAgentDao {

    public AgentDao() {
        super();

        setClazz(Agent.class);
    }

    // API

}
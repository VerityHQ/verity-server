package io.swagger.persistence.service.impl;


import site.verity.persistence.dao.common.IOperations;
import site.verity.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Agent;
import io.swagger.persistence.dao.IAgentDao;
import io.swagger.persistence.service.IAgentService;

@Service
public class AgentService extends AbstractService<Agent> implements IAgentService {

    @Autowired
    private IAgentDao dao;

    public AgentService() {
        super();
    }

    // API

    @Override
    protected IOperations<Agent> getDao() {
        return dao;
    }

}

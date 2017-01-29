package io.swagger.persistence.service.impl;


import org.verity.persistence.dao.common.IOperations;
import org.verity.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.SoftwareAgent;
import io.swagger.persistence.dao.ISoftwareAgentDao;
import io.swagger.persistence.service.ISoftwareAgentService;

@Service
public class SoftwareAgentService extends AbstractService<SoftwareAgent> implements ISoftwareAgentService {

    @Autowired
    private ISoftwareAgentDao dao;

    public SoftwareAgentService() {
        super();
    }

    // API

    @Override
    protected IOperations<SoftwareAgent> getDao() {
        return dao;
    }

}

package io.swagger.persistence.service.impl;


import org.baeldung.persistence.dao.common.IOperations;
import org.baeldung.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Organization;
import io.swagger.persistence.dao.IOrganizationDao;
import io.swagger.persistence.service.IOrganizationService;

@Service
public class OrganizationService extends AbstractService<Organization> implements IOrganizationService {

    @Autowired
    private IOrganizationDao dao;

    public OrganizationService() {
        super();
    }

    // API

    @Override
    protected IOperations<Organization> getDao() {
        return dao;
    }

}

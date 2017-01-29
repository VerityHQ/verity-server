package io.swagger.persistence.service.impl;


import org.verity.persistence.dao.common.IOperations;
import org.verity.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Entity;
import io.swagger.persistence.dao.IEntityDao;
import io.swagger.persistence.service.IEntityService;

@Service
public class EntityService extends AbstractService<Entity> implements IEntityService {

    @Autowired
    private IEntityDao dao;

    public EntityService() {
        super();
    }

    // API

    @Override
    protected IOperations<Entity> getDao() {
        return dao;
    }

}

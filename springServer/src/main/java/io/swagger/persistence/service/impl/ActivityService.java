package io.swagger.persistence.service.impl;


import org.baeldung.persistence.dao.common.IOperations;
import org.baeldung.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Activity;
import io.swagger.persistence.dao.IActivityDao;
import io.swagger.persistence.service.IActivityService;

@Service
public class ActivityService extends AbstractService<Activity> implements IActivityService {

    @Autowired
    private IActivityDao dao;

    public ActivityService() {
        super();
    }

    // API

    @Override
    protected IOperations<Activity> getDao() {
        return dao;
    }

}

package io.swagger.persistence.service.impl;


import org.verity.persistence.dao.common.IOperations;
import org.verity.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.ActionType;
import io.swagger.persistence.dao.IActionTypeDao;
import io.swagger.persistence.service.IActionTypeService;

@Service
public class ActionTypeService extends AbstractService<ActionType> implements IActionTypeService {

    @Autowired
    private IActionTypeDao dao;

    public ActionTypeService() {
        super();
    }

    // API

    @Override
    protected IOperations<ActionType> getDao() {
        return dao;
    }

}

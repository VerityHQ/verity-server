package io.swagger.persistence.service.impl;


import org.baeldung.persistence.dao.common.IOperations;
import org.baeldung.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Transaction;
import io.swagger.model.Valueaction;
import io.swagger.persistence.dao.ITransactionDao;
import io.swagger.persistence.dao.IValueActionDao;
import io.swagger.persistence.service.ITransactionService;
import io.swagger.persistence.service.IValueActionService;

@Service
public class ValueActionService extends AbstractService<Valueaction> implements IValueActionService {

    @Autowired
    private IValueActionDao dao;

    public ValueActionService() {
        super();
    }

    // API

    @Override
    protected IOperations<Valueaction> getDao() {
        return dao;
    }

	@Override
	public void setArchiveBit(String uuid) {
		//TODO: could be more efficient with a SQL update
		Valueaction v = this.findByUuid(uuid);
		if(v == null) throw new RuntimeException("ValueAction not found");
		v.setArchived(true);
		this.update(v);
	}

}

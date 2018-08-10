package io.swagger.persistence.service.impl;


import java.util.Date;
import java.util.List;

import site.verity.persistence.dao.common.IOperations;
import site.verity.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Transaction;
import io.swagger.model.Transaction.Direction;
import io.swagger.persistence.dao.ITransactionDao;
import io.swagger.persistence.service.ITransactionService;

@Service
public class TransactionService extends AbstractService<Transaction> implements ITransactionService {

    @Autowired
    private ITransactionDao dao;

    public TransactionService() {
        super();
    }

    // API

    @Override
    protected IOperations<Transaction> getDao() {
        return dao;
    }

//	@Override
//	public List<Transaction> getTransactionsForSourceAgentPaged(String agentUuid, int pageNumber, int pageSize) {
//		return dao.getTransactionsForSourceAgentPaged(agentUuid, pageNumber, pageSize);
//	}
//
//	@Override
//	public List<Transaction> getTransactionsForTargetAgentPaged(String agentUuid, int pageNumber, int pageSize) {
//		return dao.getTransactionsForTargetAgentPaged(agentUuid, pageNumber, pageSize);
//	}

	@Override
	public List<Transaction> getTransactionsForAgentPaged(String agentId, Integer pageNumber, Integer pageSize,
			Date startAsDate, Date endAsDate, Direction direction) {
		// TODO test
		return dao.getTransactionsForAgentPaged(agentId, pageNumber, pageSize, startAsDate, endAsDate, direction);
	}

	@Override
	public List<Transaction> getTransactionForContent(String contentId, String valueActionId) {
		return dao.getTransactionForContent(contentId, valueActionId);
	}

}

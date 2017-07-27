package io.swagger.persistence.dao;

import java.util.Date;
import java.util.List;

import site.verity.persistence.dao.common.IOperations;

import io.swagger.model.Transaction;
import io.swagger.model.Transaction.Direction;

public interface ITransactionDao extends IOperations<Transaction> {
	
//	//add custom intraface methods here that must be implemented in the Transaction dao class
//	//these methods are in addition to the IOperations methods which are general purpose across all daos
//	public List<Transaction> getTransactionsForSourceAgentPaged(String agentUuid, int pageNumber, int pageSize);
//
//	public List<Transaction> getTransactionsForTargetAgentPaged(String agentUuid, int pageNumber, int pageSize);
	
	public List<Transaction> getTransactionsForAgentPaged(String agentId, Integer pageNumber, Integer pageSize,
			Date startAsDate, Date endAsDate, Direction direction);
	
	public List<Transaction> getTransactionForContent(String contentId, String valueActionId);
	
}

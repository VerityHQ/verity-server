package io.swagger.persistence.dao.impl;

import java.util.List;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import io.swagger.model.Transaction;
import io.swagger.persistence.dao.ITransactionDao;

@Repository
public class TransactionDao extends AbstractHibernateDao<Transaction> implements ITransactionDao {

	public TransactionDao() {
        super();

        setClazz(Transaction.class);
    }

    // API
    @SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsForSourceAgentPaged(String agentUuid, int pageNumber, int pageSize){
    	final Query query = getCurrentSession().createQuery("from Transaction t where t.sourceAgentId = :agentUuid order by t.timeStamp");
    	query.setString("agentUuid", agentUuid);
		query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    // API
    @SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsForTargetAgentPaged(String agentUuid, int pageNumber, int pageSize){
    	final Query query = getCurrentSession().createQuery("from Transaction t where t.targetAgentId = :agentUuid order by t.timeStamp");
    	query.setString("agentUuid", agentUuid);
		query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }
    
    // TODO: need date range for all queries that return more than one record
    // should we pass in date range in the headers?
    
}
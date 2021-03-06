package io.swagger.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.Transaction;
import io.swagger.model.Transaction.Direction;
import io.swagger.persistence.dao.ITransactionDao;

@Repository
public class TransactionDao extends AbstractHibernateDao<Transaction> implements ITransactionDao {

	public TransactionDao() {
		super();

		setClazz(Transaction.class);
	}
	//
	// // API
	// @SuppressWarnings("unchecked")
	// public List<Transaction> getTransactionsForSourceAgentPaged(String
	// agentUuid, int pageNumber, int pageSize){
	// final Query query = getCurrentSession().createQuery("from Transaction t
	// where t.sourceAgentId = :agentUuid order by t.timeStamp");
	// query.setString("agentUuid", agentUuid);
	// query.setFirstResult((pageNumber - 1) * pageSize);
	// query.setMaxResults(pageSize);
	// return query.list();
	// }
	//
	// // API
	// @SuppressWarnings("unchecked")
	// public List<Transaction> getTransactionsForTargetAgentPaged(String
	// agentUuid, int pageNumber, int pageSize){
	// final Query query = getCurrentSession().createQuery("from Transaction t
	// where t.targetAgentId = :agentUuid order by t.timeStamp");
	// query.setString("agentUuid", agentUuid);
	// query.setFirstResult((pageNumber - 1) * pageSize);
	// query.setMaxResults(pageSize);
	// return query.list();
	// }

	//TODO: need unit tests, check for off by one, page size edge cases, etc.
	@SuppressWarnings("unchecked")
	public List<Transaction> getTransactionsForAgentPaged(String agentId, Integer pageNumber, Integer pageSize,
			Date startAsDate, Date endAsDate, Direction direction) {

		String agentWhere = "t.targetAgentId = :agentUuid";
		if (direction.equals(Direction.SOURCE)) {
			agentWhere = "t.sourceAgentId = :agentUuid";
		}

		final Query query = getCurrentSession().createQuery("from Transaction t where " + agentWhere
				+ " t.timeStamp between :startDate AND :endDate order by t.timeStamp");

		query.setString("agentUuid", agentId);
		query.setDate("startDate", startAsDate);
		query.setDate("endDate", endAsDate);

		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionForContent(String contentId, String valueActionId) {
		final Query query = getCurrentSession().createQuery("from Transaction t where "
				+ " t.targetAgentId = :targetAgentId AND t.value_action_id = :valueActionId");

		query.setString("targetAgentId", contentId);
		query.setString("valueActionId", valueActionId);

		return query.list();
	}

}
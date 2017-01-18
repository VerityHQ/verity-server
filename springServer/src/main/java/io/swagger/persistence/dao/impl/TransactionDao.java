package io.swagger.persistence.dao.impl;

import org.baeldung.persistence.dao.common.AbstractHibernateDao;
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

}
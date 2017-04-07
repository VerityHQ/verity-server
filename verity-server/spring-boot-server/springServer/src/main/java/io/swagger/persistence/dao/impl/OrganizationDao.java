package io.swagger.persistence.dao.impl;

import site.verity.persistence.dao.common.AbstractHibernateDao;
import org.springframework.stereotype.Repository;

import io.swagger.model.Organization;
import io.swagger.persistence.dao.IOrganizationDao;

@Repository
public class OrganizationDao extends AbstractHibernateDao<Organization> implements IOrganizationDao {

    public OrganizationDao() {
        super();

        setClazz(Organization.class);
    }

    // API

}
package io.swagger.persistence.dao.impl;

import site.verity.persistence.dao.common.AbstractHibernateDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.swagger.model.Person;
import io.swagger.persistence.dao.IPersonDao;

@Repository
public class PersonDao extends AbstractHibernateDao<Person> implements IPersonDao {

    public PersonDao() {
        super();

        setClazz(Person.class);
    }

    // Additional methods not covered by AbstractHibernateDao
	@Override
	public Person findByNickname(String nickname) {
		//TODO: this may need to be a combination of Org + nickname
		// we need to decide if there is a global namespace for all nicknames
		// or namespace based on org + nickname	
		return (Person) getCurrentSession().createQuery("from Person where nickname = :nickname")
				.setString("nickname", nickname).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllByOrganizationId(String uuid, Integer pageNumber, Integer pageSize) {
		return (List<Person>) getCurrentSession().createQuery("from Person where organizationId = :organizationId")
				.setString("organizationId", uuid).list();
	}

}
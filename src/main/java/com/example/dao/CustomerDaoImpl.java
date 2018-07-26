package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Customer;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao { 
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	
	@Override
	public void addCustomer(Customer customer) 
	{		
		entityManager.persist(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		String hql = "FROM Customer ";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addHib(Customer c) {
		Session session = entityManager.unwrap(Session.class);
        session.save(c);
		
	}

	@Override
	public List<Customer> getAllHib() {
		
		Session session = entityManager.unwrap(Session.class);//get session directly..
		SessionFactory sf = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		String hql = "FROM Customer";
		Session s = sf.openSession();//create new session from session factory
		return s.createQuery(hql).getResultList();
	}
	

}

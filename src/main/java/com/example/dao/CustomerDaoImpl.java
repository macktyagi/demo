package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	

}

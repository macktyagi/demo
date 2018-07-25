package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomerDao;
import com.example.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);		
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.getAllCustomer();
	}
	
	@Override
	public void addHib(Customer customer) {
		customerDao.addHib(customer);		
	}
	
	@Override
	public List<Customer> getAllHib() {
		
		return customerDao.getAllHib();
	}
	

}

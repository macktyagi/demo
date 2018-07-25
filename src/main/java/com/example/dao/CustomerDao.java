package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerDao {
	
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public void addHib(Customer customer);
	public List<Customer> getAllHib();

}

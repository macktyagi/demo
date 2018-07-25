package com.example.service;

import java.util.List;

import com.example.model.Customer;


public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public void addHib(Customer customer);
	public List<Customer> getAllHib();

}

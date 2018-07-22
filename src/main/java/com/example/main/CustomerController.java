package com.example.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {
	
	@RequestMapping(value="customer/{id}", method=RequestMethod.GET,headers = "Accept=application/json")
	public List<Customer> customerData(@PathVariable String id)
	{
		
		List<Customer> list = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setId("1000000001");
		customer1.setName("MACK");
		customer1.setMobile("9716347373");
		customer1.setCity("GZB");
		
		Customer customer2 = new Customer();
		customer2.setId("1000000002");
		customer2.setName("SHUBHAM");
		customer2.setMobile("9999999999");
		customer2.setCity("NOIDA");
		
		/*if(id.equalsIgnoreCase("1000000001"))
		{
			list.add(customer1);
		}
		else
		{
			list.add(customer2);
		}	*/	
		list.add(customer1);
		list.add(customer2);
		return list;	
	}
	
	@RequestMapping(value="customerBody", method=RequestMethod.POST,headers = "Accept=application/json")
	public String customerBody(@RequestBody String data)
	{		
		
		return data;	
	}
	
	
	//-----------------------------------database connectivity-----------------------------------------//
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="addCustomer", method=RequestMethod.POST,headers = "Accept=application/json")
	public void addCustomer(@RequestBody Customer customer, UriComponentsBuilder builder)
	{				
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(value="getAllCustomer", method=RequestMethod.GET,headers = "Accept=application/json")
	public List<Customer> getAllCustomer()
	{				
		return customerService.getAllCustomer();
	}
	
	

}

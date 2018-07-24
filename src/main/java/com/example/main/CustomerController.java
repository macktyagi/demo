package com.example.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController {
	
	@GetMapping(value="customer")
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
	
	@PostMapping(value="customerBody")
	public String customerBody(@RequestBody String data)
	{		
		
		return data;	
	}
	
	
	//-----------------------------------database connectivity-----------------------------------------//
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="addCustomer")
	public void addCustomer(@RequestBody String request)
	{		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Customer customer = mapper.readValue(request, Customer.class);
			customerService.addCustomer(customer);
		} catch (JsonParseException | JsonMappingException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
		 
			e.printStackTrace();
		} 
		
	}
	
	@PostMapping(value="addMultipleCustomer")
	public void addMultipleCustomer(@RequestBody String request)
	{		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Customer[] customer = mapper.readValue(request, Customer[].class);
			for(Customer c: customer)
			{	
				customerService.addCustomer(c);
			}
		} catch (JsonParseException | JsonMappingException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
		 
			e.printStackTrace();
		} 
		
	}
	
	@GetMapping(value="getAllCustomer")
	public List<Customer> getAllCustomer()
	{				
		return customerService.getAllCustomer();
	}
	
	
	//-------------------JPA CRUD------------------------------------------------//
	@Autowired 
	private CustomerRepository cr;
	@GetMapping(value="getAlldata")
	public List<Customer> getAlldata()
	{				
		return cr.findAll();
	}
	
	@PostMapping(value="add")
	public void add(@RequestBody String request)
	{		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Customer customer = mapper.readValue(request, Customer.class);
			cr.save(customer);
		} catch (JsonParseException | JsonMappingException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
		 
			e.printStackTrace();
		} 
		
	}
	

}

package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(value="user/{id}", method=RequestMethod.GET,headers = "Accept=application/json")
	public List<User> userData(@PathVariable String id)
	{
		
		List<User> list = new ArrayList<>();
		User user1 = new User();
		user1.setId("1000000001");
		user1.setName("MACK");
		user1.setMobile("9716347373");
		
		User user2 = new User();
		user2.setId("1000000001");
		user2.setName("SHUBHAM");
		user2.setMobile("9999999999");
		
		if(id.equalsIgnoreCase("1000000001"))
		{
			list.add(user1);
		}
		else
		{
			list.add(user2);
		}		
		
		return list;	
	}
	
	@RequestMapping(value="userBody", method=RequestMethod.POST,headers = "Accept=application/json")
	public String userBody(@RequestBody Map data)
	{
		
		return (String) data.get("id");	
	}

}

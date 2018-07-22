package com.example.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(value="user")
	public List<User> userData()
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
		
		list.add(user1);
		list.add(user2);
		
		return list;	
	}

}

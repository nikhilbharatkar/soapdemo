package com.app.springbootcontractfirstexample.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.spring_boot_soap_example.User;



@Service("userService")
public class UserService {

	private static final Map<String, User> users= new HashMap<>();
	
	@PostConstruct
	public void initialize() {
		User nikhil = new User();
		nikhil.setName("nikhil");
		nikhil.setEmpId(500);
		nikhil.setSalary(40000.00);
		
		User user2 = new User();
		user2.setName("Tony");
		user2.setEmpId(501);
		user2.setSalary(45000);
		
		User u3 = new User();
		u3.setName("Thanos");
		u3.setEmpId(503);
		u3.setSalary(50000);
				
		users.put(nikhil.getName(), nikhil);
		users.put(user2.getName(), user2);
		users.put(u3.getName(), u3);
	}
	
	public User getUsers(String Name) {
		
		return users.get(Name);
	}
	
}

package com.app.springbootsoapcontractfirstexample.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.spring_boot_soap_example.GetUserRequest;
import com.app.spring_boot_soap_example.GetUserResponse;
import com.app.springbootcontractfirstexample.service.UserService;

@Endpoint
public class UserEndPoint {
	
	@Autowired
	private UserService	userService;
	
	
	@PayloadRoot(namespace = "http://app.com/spring-boot-soap-example", localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(request.getName()));
		return response;
	}
}

package endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import com.app.spring_boot_soap_example.GetUserRequest;
import com.app.spring_boot_soap_example.GetUserResponse;

import service.UserService;

@Endpoint
public class UserEndPoint {
	
	
	@Autowired
	private UserService userService;
	
	
	@PayloadRoot(namespace = "http://app.com/spring_boot_soap_example", localPart = "getUserRequest")
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(request.getName()));
		return response;
	}
}

package imie.survey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import imie.survey.resources.UserResource;
import imie.survey.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	//private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserResource> getAllUsers() {		
		return userService.getAllUsers();
	}
}

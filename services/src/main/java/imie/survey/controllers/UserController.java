package imie.survey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.data.User;
import imie.survey.serialization.Views;
import imie.survey.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@JsonView(Views.User.class)
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {		
		return userService.getAllUsers();
	}
}

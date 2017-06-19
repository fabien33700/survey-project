package imie.survey.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import imie.survey.data.User;
import imie.survey.mapping.mappers.UserMapper;
import imie.survey.resources.UserResource;
import imie.survey.services.UserService;

@Controller
@RequestMapping("api/users")
public class UserController {
	
	
	@Autowired
	private UserMapper wrapper;
	
	@Autowired
	private UserService utilisateurService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserResource> getAllUsers() {
		List<User> users = utilisateurService.getAllUsers();
		
		return users.stream()
				   .map(wrapper::getDtoFromEntity)
				   .collect(Collectors.toList());
		
	}
}

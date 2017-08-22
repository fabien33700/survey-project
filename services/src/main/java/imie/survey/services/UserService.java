package imie.survey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.UserRepository;
import imie.survey.data.User;
import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.utils.ServiceUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User getUser(Long id) throws ResourceNotFoundException {
		return repository.findOne(id);
	}
	
	public List<User> getAllUsers() {
		return ServiceUtils.iterableToList(repository.findAll());
	}

}

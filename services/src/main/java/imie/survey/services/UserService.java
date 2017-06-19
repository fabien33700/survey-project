package imie.survey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.UserRepository;
import imie.survey.data.User;
import imie.survey.exceptions.errors.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository utilisateurRepository;
	
	public User getUtilisateurFromId(long id) throws ResourceNotFoundException {
		return utilisateurRepository.findOne(id);
	}
	
	public List<User> getAllUsers() {
		return (List<User>) utilisateurRepository.findAll();
	}

}

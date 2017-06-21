package imie.survey.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.UserRepository;
import imie.survey.data.User;
import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.mapping.UserMapper;
import imie.survey.resources.UserResource;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserRepository utilisateurRepository;
	
	public User getUtilisateurFromId(long id) throws ResourceNotFoundException {
		return utilisateurRepository.findOne(id);
	}
	
	public List<UserResource> getAllUsers() {
		Stream<User> users = StreamSupport.stream(
				utilisateurRepository.findAll().spliterator(), false);
		
		return users.map(mapper::getDtoFromEntity)
				.collect(Collectors.toList());
	}

}

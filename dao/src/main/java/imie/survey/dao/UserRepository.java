package imie.survey.dao;

import org.springframework.data.repository.CrudRepository;

import imie.survey.data.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByPseudo(String pseudo);

}

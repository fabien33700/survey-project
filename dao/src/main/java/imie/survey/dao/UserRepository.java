package imie.survey.dao;

import org.springframework.data.repository.CrudRepository;

import imie.survey.data.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
	
	Utilisateur findByPseudo(String pseudo);

}

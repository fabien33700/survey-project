package imie.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.UtilisateurRepository;
import imie.survey.data.Utilisateur;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Utilisateur getUtilisateurFromId(long id) {
		
		return utilisateurRepository.findOne(id);
	}

}

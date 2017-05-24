package imie.survey.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.PropositionReponseRepository;
import imie.survey.dao.SondageRepository;
import imie.survey.data.PropositionReponse;
import imie.survey.data.Sondage;
import imie.survey.data.Utilisateur;
import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.resources.PropositionReponseResource;
import imie.survey.resources.SondageResource;
import imie.survey.services.UtilisateurService;

/**
 * Controller Utils
 *
 */
@Service
public class Validator {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private SondageRepository surveyRepository;
	
	@Autowired
	private PropositionReponseRepository propositionRepository;
	
	/**
	 * Validate if user exists
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur validateUser(long id){
		
		Utilisateur user = utilisateurService.getUtilisateurFromId(id);
		
		if(user == null) {
			
			throw new ResourceNotFoundException("Utilisisateur inconnu");
		}
		
		return user;		
	}
	
	/**
	 * Validate if survey exists
	 * @param sondage
	 * @return
	 */
	public Sondage validateSondage(SondageResource sondageRes) {
		
		long sondageId = sondageRes.getId();
				
		Sondage sondage = surveyRepository.findOne(sondageId);
		
		if(sondage == null) {
			
			throw new ResourceNotFoundException("Sondage inconnu");
		}
		
		return sondage;
	}
	
	/**
	 * Validate if a proposition exists
	 * @param sondage
	 * @return
	 */
	public PropositionReponse validateProposition(PropositionReponseResource propReponseRes) {
		
		long propId = propReponseRes.getId();
				
		PropositionReponse proposition = propositionRepository.findOne(propId);
		
		if(proposition == null) {
			
			throw new ResourceNotFoundException("Sondage inconnu");
		}
		
		return proposition;
	}
	
}

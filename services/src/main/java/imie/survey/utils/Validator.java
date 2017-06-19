package imie.survey.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.ProposalRepository;
import imie.survey.dao.SondageRepository;
import imie.survey.data.Proposal;
import imie.survey.data.Survey;
import imie.survey.data.User;
import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.resources.ProposalResource;
import imie.survey.resources.SurveyResource;
import imie.survey.services.UserService;

/**
 * Controller Utils
 *
 */
@Service
public class Validator {
	
	@Autowired
	private UserService utilisateurService;
	
	@Autowired
	private SondageRepository surveyRepository;
	
	@Autowired
	private ProposalRepository propositionRepository;
	
	/**
	 * Validate if user exists
	 * @param utilisateur
	 * @return
	 */
	public User validateUser(long id){
		
		User user = utilisateurService.getUtilisateurFromId(id);
		
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
	public Survey validateSondage(SurveyResource sondageRes) {
		
		long sondageId = sondageRes.getId();
				
		Survey sondage = surveyRepository.findOne(sondageId);
		
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
	public Proposal validateProposition(ProposalResource propReponseRes) {
		
		long propId = propReponseRes.getId();
				
		Proposal proposition = propositionRepository.findOne(propId);
		
		if(proposition == null) {
			
			throw new ResourceNotFoundException("Sondage inconnu");
		}
		
		return proposition;
	}
	
}

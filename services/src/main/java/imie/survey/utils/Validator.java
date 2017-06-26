package imie.survey.utils;

import org.springframework.stereotype.Service;

/**
 * Controller Utils
 *
 */

@Service
public class Validator {
	
	/*@Autowired
	private UserService utilisateurService;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private ProposalRepository propositionRepository;*/
	
	/**
	 * Validate if user exists
	 * @param utilisateur
	 * @return
	 */
	/*public User validateUser(long id){
		
		User user = utilisateurService.getUtilisateurFromId(id);
		
		if(user == null) {
			
			throw new ResourceNotFoundException("Utilisisateur inconnu");
		}
		
		return user;		
	}*/
	
	/**
	 * Validate if survey exists
	 * @param sondage
	 * @return
	 */
	/*public Survey validateSondage(SurveyResource sondageRes) {
		
		long sondageId = sondageRes.getId();
				
		Survey sondage = surveyRepository.findOne(sondageId);
		
		if(sondage == null) {
			
			throw new ResourceNotFoundException("Sondage inconnu");
		}
		
		return sondage;
	}*/
	
	/**
	 * Validate if a proposition exists
	 * @param sondage
	 * @return
	 */
	/*public Proposal validateProposition(ProposalResource propReponseRes) {
		
		long propId = propReponseRes.getId();
				
		Proposal proposition = propositionRepository.findOne(propId);
		
		if(proposition == null) {
			
			throw new ResourceNotFoundException("Sondage inconnu");
		}
		
		return proposition;
	}*/
	
}

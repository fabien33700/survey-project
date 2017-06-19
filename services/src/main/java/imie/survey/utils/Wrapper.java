package imie.survey.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Answer;
import imie.survey.resources.AnswerResource;
import imie.survey.resources.SurveyResource;
import imie.survey.resources.UserResource;

//@Component
//public class Wrapper {
//	
//	
//	private final ModelMapper modelMapper;
//	
//	@Autowired
//	public Wrapper(ModelMapper modelMapper) {
//		this.modelMapper = modelMapper;
//	}
//	
//	/**
//	 * Convert Sondage to SondageResource
//	 * @param post
//	 * @return
//	 */
//	public SurveyResource convertSondageToDto(SurveyResource sondage) {
//	    
//		SurveyResource sondageResource = modelMapper.map(sondage, SurveyResource.class);
//	    
//		// Convertion des dates
//	    sondageResource.setDateDebutConverted(sondage.getDateStart());
//	    sondageResource.setDateFinConverted(sondage.getDateEnd());
//	    
//	    return sondageResource;
//	}
//	
//	/**
//	 * Convert SondageResource to Sondage
//	 * @param sondageResource
//	 * @return
//	 */
//	public SurveyResource convertSondageToEntity(SurveyResource sondageResource) {
//	    
//		SurveyResource sondage = modelMapper.map(sondageResource, SurveyResource.class);
//	    
//		// Convertion des dates
//	    sondage.setDateStart(sondageResource.getDateDebutConverted());
//	    sondage.setDateEnd(sondageResource.getDateFinConverted());
//	    
//	    // Set PropositionsReponse
//	    setPropositionsReponseSondage(sondage);
//	    
//	    return sondage;
//	}
//	
//	public Answer convertSurveyAnswerToEntity(AnswerResource repSondageRes) {
//		
//		Answer repSondage = modelMapper.map(repSondageRes, Answer.class);
//	    
//		// Convertion de la date
//		repSondage.setDateReponse(repSondageRes.getDateReponseConverted());
//	   
//	    // Set PropositionsReponse
//	    setPropositionsSurveyAnswers(repSondage);
//	    
//	    return repSondage;
//	}
//	
//	/**
//	 * Convert an user to userResource
//	 * @param user
//	 * @return
//	 */
//	public UserResource convertUserToDto(UserResource user) {
//		
//		UserResource utilisateurRes = modelMapper.map(user, UserResource.class);
//		return utilisateurRes;
//	}
//
//	/**
//	 * Set 
//	 * @param repSondage
//	 */
//	private void setPropositionsSurveyAnswers(Answer repSondage) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	/**
//	 * Set sondage property for the PropositionReponse Entity 
//	 * @param sondage
//	 */
//	private static void setPropositionsReponseSondage(SurveyResource sondage) {
//		sondage.getPropositionsReponse().stream().forEach(prop -> prop.setSurvey(sondage));
//	}
//}

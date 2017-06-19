package imie.survey.controllers;

import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import imie.survey.data.ReponseSondage;
import imie.survey.resources.ReponseSondageResource;
import imie.survey.services.SurveyAnswerService;
import imie.survey.utils.Validator;
import imie.survey.utils.Wrapper;

@RestController
@RequestMapping("api/surveysanswers")
public class SurveyAnswerController {
	
	@Autowired
	private SurveyAnswerService surveyAnswerService;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private Wrapper wrapper;
	
	/**
	 * Create a new survey answer
	 * @param userId
	 * @param input
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addSurveyAnswer(@RequestBody ReponseSondageResource reponseSondageRes) throws IllegalAccessException, InvocationTargetException {
		
		// Validation de l'utilisateur
		validator.validateUser(reponseSondageRes.getUtilisateur().getId());
		
		ReponseSondage sondageReponse = wrapper.convertSurveyAnswerToEntity(reponseSondageRes);
		
		surveyAnswerService.saveSuveyAnswer(sondageReponse);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}

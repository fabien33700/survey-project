package imie.survey.controllers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import imie.survey.data.Answer;
import imie.survey.mapping.AnswerMapper;
import imie.survey.resources.AnswerResource;
import imie.survey.services.SurveyAnswerService;
import imie.survey.utils.Validator;

@RestController
@RequestMapping("api/surveysanswers")
public class AnswerController {
	
	@Autowired
	private SurveyAnswerService surveyAnswerService;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private AnswerMapper wrapper;
	
	/**
	 * Create a new survey answer
	 * @param userId
	 * @param input
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addSurveyAnswer(@RequestBody AnswerResource reponseSondageRes) throws IllegalAccessException, InvocationTargetException {
		
		// Validation de l'utilisateur
		validator.validateUser(reponseSondageRes.getUser().getId());
		
		Answer sondageReponse = wrapper.getEntityFromDto(reponseSondageRes);
		
		surveyAnswerService.saveSuveyAnswer(sondageReponse);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}

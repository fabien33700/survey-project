package imie.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imie.survey.mapping.AnswerMapper;
import imie.survey.services.SurveyAnswerService;
import imie.survey.utils.Validator;

@RestController
@RequestMapping("api/surveysanswers")
public class AnswerController {
	
	@Autowired
	private SurveyAnswerService surveyAnswerService;
	
	/**
	 * Create a new survey answer
	 * @param userId
	 * @param input
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	/*@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addSurveyAnswer(@RequestBody AnswerResource reponseSondageRes) throws IllegalAccessException, InvocationTargetException {
		
		// Validation de l'utilisateur
		validator.validateUser(reponseSondageRes.getUser().getId());
		
		Answer sondageReponse = wrapper.getEntityFromDto(reponseSondageRes);
		
		surveyAnswerService.saveSuveyAnswer(sondageReponse);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}*/

}

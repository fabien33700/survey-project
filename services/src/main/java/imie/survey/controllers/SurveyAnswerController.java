package imie.survey.controllers;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import imie.survey.data.ReponseSondage;
import imie.survey.data.Sondage;
import imie.survey.resources.ReponseSondageResource;
import imie.survey.resources.SondageResource;
import imie.survey.services.SurveyAnswerService;
import imie.survey.utils.Validator;

@Controller
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
		
		ReponseSondage sondage = wrapper.convertSondageToEntity(sondageRes);

		sondageRepository.save(sondage);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sondage.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}

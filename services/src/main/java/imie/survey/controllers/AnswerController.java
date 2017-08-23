package imie.survey.controllers;

import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.data.Answer;
import imie.survey.resources.AnswerResource;
import imie.survey.serialization.Views;
import imie.survey.services.AnswerService;

@RestController
@RequestMapping("api/answers")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	/**
	 * Create a new survey answer
	 * @param userId
	 * @param input
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	@JsonView(Views.Id.class)
	public Answer addAnswer(@RequestBody @Valid AnswerResource resource) {
		return answerService.saveAnswer(resource);
	}
	

}

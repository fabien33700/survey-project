package imie.survey.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.data.Survey;
import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.resources.SurveyResource;
import imie.survey.serialization.Views;
import imie.survey.services.SurveyService;

@RestController
@RequestMapping("api/surveys")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;	
	
	/**
	 * Get a survey from its id
	 * @param surveyId
	 * @return
	 * @throws Exception 
	 */
	@JsonView(Views.Survey.class)
	@RequestMapping(value="/{surveyId}", method = RequestMethod.GET)
    public Survey getSurvey(@PathVariable long surveyId) {
		return surveyService.getSurvey(surveyId);		
    }
	
	/**
	 * Get all surveys
	 * @return
	 */
	@JsonView(Views.Survey.class)
	@RequestMapping(method = RequestMethod.GET)
    public List<Survey> allSurveys() {
		return surveyService.getAllSurveys();
    }
	
	/**
	 * Create a new survey
	 * @param userId
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SurveyResource resource) {
		
		Long created = surveyService.createSurvey(resource);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(created).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Delete a survey
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSurvey(@PathVariable("id") long id) {
		
		surveyService.deleteSurvey(
			Optional.ofNullable(surveyService.getSurvey(id))
				.orElseThrow(() -> 
					new ResourceNotFoundException("Le sondage " + id + " n'a pas été trouvé"))
			.getId());

        return new ResponseEntity<SurveyResource>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * Delete a survey from its Id
	 * @return
	 */
	public ResponseEntity<?> deleteAllSurveys() {
		surveyService.deleteAllSurveys();
		return new ResponseEntity<SurveyResource>(HttpStatus.NO_CONTENT);
	}
}

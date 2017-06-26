package imie.survey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import imie.survey.exceptions.errors.ResourceNotFoundException;
import imie.survey.resources.SurveyResource;
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
	@RequestMapping(value="/{surveyId}", method = RequestMethod.GET)
    public SurveyResource getSurvey(@PathVariable long surveyId) {
		return surveyService.getSurvey(surveyId);		
    }
	
	/**
	 * Get all surveys
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<SurveyResource> allSurveys() {
		return surveyService.getAllSurveys();
    }
	
	/**
	 * Create a new survey
	 * @param userId
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SurveyResource sondageRes) {
		
		// Validation de l'utilisateur
		validator.validateUser(sondageRes.getAuthor().getId());
		Survey sondage = surveyMapper.getEntityFromDto(sondageRes);

		sondageRepository.save(sondage);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sondage.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}*/
	
	/**
	 * Delete a survey
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSurvey(@PathVariable("id") long id) {
        
		SurveyResource survey = surveyService.getSurvey(id);
       
        if (survey == null) {
            throw new ResourceNotFoundException("Le sondage " + id + " n'a pas été trouvé");
        }
        
        surveyService.deleteSurvey(id);
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

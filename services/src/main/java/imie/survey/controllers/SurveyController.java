package imie.survey.controllers;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import imie.survey.dao.SondageRepository;
import imie.survey.data.Survey;
import imie.survey.mapping.mappers.SurveyMapper;
import imie.survey.resources.SurveyResource;
import imie.survey.services.SondageService;
import imie.survey.utils.Validator;

@RestController
@RequestMapping("api/surveys")
public class SurveyController {
	
	@Autowired
	private SondageRepository sondageRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Autowired
	private SondageService sondageService;
	
	
	/**
	 * Get a survey from its id
	 * @param surveyId
	 * @return
	 */
	@RequestMapping(value="/{surveyId}", method = RequestMethod.GET)
    public SurveyResource getSurvey(@PathVariable long surveyId) {
		Survey sondage = sondageService.getSondageFromId(surveyId);		
		return surveyMapper.getDtoFromEntity(sondage);		
    }
	
	/**
	 * Get all surveys
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<SurveyResource> allSurveys() {
		
		List<Survey> sondages = sondageService.getAllSondages();
		
		return sondages.stream()
					   .map(surveyMapper::getDtoFromEntity)
					   .collect(Collectors.toList());
    }
	
	/**
	 * Create a new survey
	 * @param userId
	 * @param input
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SurveyResource sondageRes) throws IllegalAccessException, InvocationTargetException {
		
		// Validation de l'utilisateur
		validator.validateUser(sondageRes.getAuthor().getId());
		Survey sondage = surveyMapper.getEntityFromDto(sondageRes);

		sondageRepository.save(sondage);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sondage.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * Delete a survey
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSurvey(@PathVariable("id") long id) {
        
		Survey sondage = sondageService.getSondageFromId(id);
       
        if (sondage == null) {
            return new ResponseEntity<SurveyResource>(HttpStatus.NOT_FOUND);
        }
        
        sondageService.deleteSondage(id);
        return new ResponseEntity<SurveyResource>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * Delete a survey from its Id
	 * @return
	 */
	public ResponseEntity<?> deleteAllSurveys() {
		sondageService.deleteAllSondages();
		return new ResponseEntity<SurveyResource>(HttpStatus.NO_CONTENT);
	}
}

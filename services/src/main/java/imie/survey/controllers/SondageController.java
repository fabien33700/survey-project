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
import imie.survey.data.Sondage;
import imie.survey.resources.SondageResource;
import imie.survey.services.SondageService;
import imie.survey.utils.Validator;
import imie.survey.utils.Wrapper;

@RestController
@RequestMapping("/surveys")
public class SondageController {
	
	@Autowired
	private SondageRepository sondageRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private Wrapper wrapper;
	
	@Autowired
	private SondageService sondageService;
	
	
	/**
	 * Get a survey from its id
	 * @param surveyId
	 * @return
	 */
	@RequestMapping(value="/{surveyId}", method = RequestMethod.GET)
    public SondageResource getSurvey(@PathVariable long surveyId) {
		Sondage sondage = sondageService.getSondageFromId(surveyId);		
		return wrapper.convertSondageToDto(sondage);		
    }
	
	/**
	 * Get all surveys
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<SondageResource> allSurveys() {
		List<Sondage> sondages = sondageService.getAllSondages();
		return sondages.stream()
					   .map(wrapper::convertSondageToDto)
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
	ResponseEntity<?> add(@RequestBody SondageResource sondageRes) throws IllegalAccessException, InvocationTargetException {
		
		// Validation de l'utilisateur
		validator.validateUser(sondageRes.getAuteur().getId());
		
		Sondage sondage = wrapper.convertSondageToEntity(sondageRes);

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
        Sondage sondage = sondageService.getSondageFromId(id);
       
        if (sondage == null) {
            return new ResponseEntity<SondageResource>(HttpStatus.NOT_FOUND);
        }
        
        sondageService.deleteSondage(id);
        return new ResponseEntity<SondageResource>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * Delete a survey from its Id
	 * @return
	 */
	public ResponseEntity<?> deleteAllSurveys() {
		sondageService.deleteAllSondages();
		return new ResponseEntity<SondageResource>(HttpStatus.NO_CONTENT);
	}
}

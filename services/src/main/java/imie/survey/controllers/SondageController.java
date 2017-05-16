package imie.survey.controllers;

import java.net.URI;
import java.util.List;

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
import imie.survey.dao.UtilisateurRepository;
import imie.survey.data.Sondage;
import imie.survey.data.Utilisateur;
import imie.survey.resources.SondageResource;
import imie.survey.resources.UtilisateurResource;

@RestController
@RequestMapping("/surveys")
public class SondageController {
	
	private final SondageRepository sondageRepository;
	private final UtilisateurRepository userRepository;
	
	@Autowired
	SondageController(SondageRepository sondageRepository,
			UtilisateurRepository userRepository) {
		this.sondageRepository = sondageRepository;
		this.userRepository = userRepository;
	}
	
	/**
	 * Get a survey from its id
	 * @param surveyId
	 * @return
	 */
	@RequestMapping(value="/{surveyId}", method = RequestMethod.GET)
    public Sondage getSurvey(@PathVariable long surveyId) {
		return this.sondageRepository.findOne(surveyId);
    }
	
	/**
	 * Get all surveys
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Sondage> allSurveys() {
		return (List<Sondage>) this.sondageRepository.findAll();
    }
	
	/**
	 * Create a new survey
	 * @param userId
	 * @param input
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody SondageResource input) {
		
		Sondage survey = new Sondage();
		survey.setId(input.getId());
		survey.setNom(input.getNom());
		survey.setDateDebut(input.getDateDebut());
		survey.setDateFin(input.getDateFin());
		
		UtilisateurResource userRes = input.getAuteur();
		
		Utilisateur user = new Utilisateur();
		user.setAge(userRes.getAge());
		user.setPseudo(userRes.getHashPass());
		
		survey.setAuteur(user);
		
		
		survey.setPropositionsReponse(input.getPropositionsReponse());
		
		sondageRepository.save(survey);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(survey.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	/**
	 * Delete a survey
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSurvey(@PathVariable("id") long id) {
        
        Sondage survey = sondageRepository.findOne(id);
        if (survey == null) {
            return new ResponseEntity<SondageResource>(HttpStatus.NOT_FOUND);
        }
        sondageRepository.delete(id);
        return new ResponseEntity<SondageResource>(HttpStatus.NO_CONTENT);
    }
	
	/**
	 * Delete a survey from its Id
	 * @return
	 */
	public ResponseEntity<?> deleteAllSurveys() {
		sondageRepository.deleteAll();
		return new ResponseEntity<SondageResource>(HttpStatus.NO_CONTENT);
	}	
}

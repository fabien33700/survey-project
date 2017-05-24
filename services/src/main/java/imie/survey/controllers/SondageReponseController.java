package imie.survey.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imie.survey.dao.ReponseSondageRepository;
import imie.survey.dao.UtilisateurRepository;

@RestController
@RequestMapping("surveyResponses")
public class SondageReponseController {
	
	@Autowired
	private final UtilisateurRepository userRepository;
	
	@Autowired
	private final ReponseSondageRepository responseRepository;
	
	@Autowired
	public SondageReponseController(UtilisateurRepository userRepository, ReponseSondageRepository responseRepository) {
		this.userRepository = userRepository;
		this.responseRepository = responseRepository;
	}
	
	/**
	 * Add a response to a survey
	 */
//	@RequestMapping(method = RequestMethod.POST)
//	ResponseEntity<?> add(@RequestBody SondageResource input) {
//		
//		Utilisateur user = this.userRepository.findOne(userId);
//		
//		if(user != null) {
//			
//			Sondage survey = new Sondage();
//			survey.setId(input.getId());
//			survey.setNom(input.getNom());
//			survey.setDateDebut(input.getDateDebut());
//			survey.setDateFin(input.getDateFin());
//			survey.setAuteur(user);
//			survey.setPropositionsReponse(input.getPropositionsReponse());
//			
//			sondageRepository.save(survey);
//			
//			URI location = ServletUriComponentsBuilder
//					.fromCurrentRequest().path("/{id}")
//					.buildAndExpand(survey.getId()).toUri();
//
//			return ResponseEntity.created(location).build();
//			
//		}
//		
//		return ResponseEntity.noContent().build();
//	}

}

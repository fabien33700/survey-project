package imie.survey.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.SondageRepository;
import imie.survey.data.Sondage;

@Service
// @Secured("ROLE_USER")
public class SondageService {
	
	@Autowired
	private SondageRepository sondageRepository;

	/**
	 * Get a survey from its id
	 * @param id
	 * @return
	 */
	public Sondage getSondageFromId(long id) {
		return this.sondageRepository.findOne(id);
	}

	/**
	 * Get all surveys
	 * @return
	 */
	public List<Sondage> getAllSondages() {
		return (List<Sondage>) this.sondageRepository.findAll();
	}

	/**
	 * Delete a survey from its id
	 * @param id
	 */
	public void deleteSondage(long id) {
		sondageRepository.delete(id);
	}

	/**
	 * Delete all surveys
	 */
	public void deleteAllSondages() {
		sondageRepository.deleteAll();
	}
}

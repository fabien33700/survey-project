package imie.survey.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.SurveyRepository;
import imie.survey.data.Survey;
import imie.survey.mapping.SurveyMapper;
import imie.survey.resources.SurveyResource;

@Service
// @Secured("ROLE_USER")
public class SurveyService {
	
	@Autowired
	private SurveyMapper mapper;
	
	@Autowired
	private SurveyRepository repository;

	/**
	 * Get a survey from its id
	 * @param id
	 * @return
	 */
	public SurveyResource getSurvey(long id) {
		return mapper.getDtoFromEntity(repository.findOne(id));
	}

	/**
	 * Get all surveys
	 * @return
	 */
	public List<SurveyResource> getAllSurveys() {
		Stream<Survey> surveys = StreamSupport.stream(
				repository.findAll().spliterator(), false);
		
		return surveys.map(mapper::getDtoFromEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Delete a survey from its id
	 * @param id
	 */
	public void deleteSurvey(long id) {
		repository.delete(id);
	}

	/**
	 * Delete all surveys
	 */
	public void deleteAllSurveys() {
		repository.deleteAll();
	}
}

package imie.survey.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.converters.Converter;
import imie.survey.converters.LocalDateConverter;
import imie.survey.dao.SurveyRepository;
import imie.survey.dao.UserRepository;
import imie.survey.data.Proposal;
import imie.survey.data.Survey;
import imie.survey.resources.SurveyResource;
import imie.survey.utils.ServiceUtils;

@Service
// @Secured("ROLE_USER")
public class SurveyService {
	
	private Converter<LocalDate, String> dateConverter = 
			LocalDateConverter.getInstance();
	
	@Autowired private SurveyRepository rpSurvey;
	@Autowired private UserRepository rpUser;
	//@Autowired private 

	/**
	 * Get a survey from its id
	 * @param id
	 * @return
	 */
	public Survey getSurvey(long id) {
		return rpSurvey.findOne(id);
	}

	/**
	 * Get all surveys
	 * @return
	 */
	public List<Survey> getAllSurveys() {
		return ServiceUtils.iterableToList(rpSurvey.findAll());
	}

	/**
	 * Delete a survey from its id
	 * @param id
	 */
	public void deleteSurvey(long id) {
		rpSurvey.delete(id);
	}

	/**
	 * Delete all surveys
	 */
	public void deleteAllSurveys() {
		rpSurvey.deleteAll();
	}
	
	private Survey fromResource(SurveyResource resource) {
		Survey entity = (Objects.nonNull(resource.getId())) ?
				rpSurvey.findOne(resource.getId()) : new Survey();
		
				
		entity.setAuthor(rpUser.findByPseudo(resource.getAuthor()));
		entity.setDateStart(
				dateConverter.from(resource.getDateStart()));
		entity.setDateEnd(
				dateConverter.from(resource.getDateEnd()));
		entity.setName(resource.getName());
		entity.setQuestion(resource.getQuestion());
		entity.setProposals(
			resource.getProposals().stream()
				.map(p -> new Proposal(null, p, entity))
				.collect(Collectors.toList())
		);
		
		return entity;
	}

	public Long createSurvey(SurveyResource resource) 
	{
		resource.validate();
		Survey survey = fromResource(resource);
		
		return rpSurvey.save(survey).getId();
	}
}

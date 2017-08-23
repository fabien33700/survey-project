package imie.survey.services;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.converters.Converter;
import imie.survey.converters.LocalDateConverter;
import imie.survey.dao.AnswerRepository;
import imie.survey.dao.ProposalRepository;
import imie.survey.dao.SurveyRepository;
import imie.survey.dao.UserRepository;
import imie.survey.data.Answer;
import imie.survey.resources.AnswerResource;

@Service
public class AnswerService {
	
	private Converter<LocalDate, String> dateConverter = 
			LocalDateConverter.getInstance();
	
	@Autowired private AnswerRepository rpAnswers;
	@Autowired private SurveyRepository rpSurveys;
	@Autowired private UserRepository rpUsers;
	@Autowired private ProposalRepository rpProposals;

	public Answer saveAnswer(AnswerResource resource) {
		resource.validate();
		Answer answer = fromResource(resource);
		
		return rpAnswers.save(answer);
	}

	private Answer fromResource(AnswerResource resource) {
		Answer entity = new Answer();
		
		entity.setSurvey(rpSurveys.findOne(resource.getSurvey()));		
		entity.setUser(rpUsers.findByPseudo(resource.getUser()));
		entity.setDateAnswer(
				dateConverter.from(resource.getDateAnswer()));

		entity.setProposals(
			resource.getProposals().stream()
				.map(rpProposals::findOne)
				.collect(Collectors.toList())
		);
		
		return entity;
	}
	
}

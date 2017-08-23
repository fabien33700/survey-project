package imie.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.AnswerRepository;
import imie.survey.data.Answer;

@Service
public class SurveyAnswerService {
	
	@Autowired
	private AnswerRepository reponseSondageRepository;

	public void saveSuveyAnswer(Answer sondageReponse) {
		reponseSondageRepository.save(sondageReponse);
	}
}

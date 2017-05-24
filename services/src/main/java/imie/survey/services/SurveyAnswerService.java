package imie.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.ReponseSondageRepository;
import imie.survey.data.ReponseSondage;

@Service
public class SurveyAnswerService {
	
	@Autowired
	private ReponseSondageRepository reponseSondageRepository;

	public void saveSuveyAnswer(ReponseSondage sondageReponse) {
		reponseSondageRepository.save(sondageReponse);
	}
}

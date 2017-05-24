package imie.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imie.survey.dao.ReponseSondageRepository;

@Service
public class SurveyAnswerService {
	
	@Autowired
	private ReponseSondageRepository reponseSondageRepository;
	
	

}

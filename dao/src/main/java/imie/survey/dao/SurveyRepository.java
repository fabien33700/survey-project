package imie.survey.dao;

import org.springframework.data.repository.CrudRepository;

import imie.survey.data.Survey;

public interface SurveyRepository extends CrudRepository<Survey, Long> {

}

package imie.survey.dao;

import org.springframework.data.repository.CrudRepository;

import imie.survey.data.Survey;

public interface SondageRepository extends CrudRepository<Survey, Long> {

}

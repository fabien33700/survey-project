package imie.survey.dao;

import org.springframework.data.repository.CrudRepository;

import imie.survey.data.Proposal;

public interface ProposalRepository extends CrudRepository<Proposal, Long>{
	Proposal findByValue(String value);
}

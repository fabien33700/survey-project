package imie.survey.mapping.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Proposal;
import imie.survey.mapping.IWrapper;
import imie.survey.resources.ProposalResource;

@Component
public class ProposalMapper implements IWrapper<Proposal, ProposalResource>{
	
	@Autowired
	private SurveyMapper surveyMapper;
	
	public ProposalMapper() {}

	@Override
	public Proposal getEntityFromDto(ProposalResource dto) {
		
		Proposal proposal = new Proposal();
		
		proposal.setId(dto.getId());
		proposal.setSurvey(surveyMapper.getEntityFromDto(dto.getSurvey()));
		proposal.setValue(dto.getValue());
		
		return proposal;
	}

	@Override
	public ProposalResource getDtoFromEntity(Proposal entity) {
		
		ProposalResource proposalResource = new ProposalResource();
		proposalResource.setId(entity.getId());
		proposalResource.setSurvey(surveyMapper.getDtoFromEntity(entity.getSurvey()));
		proposalResource.setValue(entity.getValue());
		
		return proposalResource;
	}

}

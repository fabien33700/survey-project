package imie.survey.mapping.mappers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

import imie.survey.data.Proposal;
import imie.survey.mapping.IWrapper;
import imie.survey.mapping.ModelMapper;
import imie.survey.mapping.View;
import imie.survey.resources.ProposalResource;

@Component
public class ProposalMapper implements IWrapper<Proposal, ProposalResource>{
	
	/*Autowired
	private SurveyMapper surveyMapper;*/
	
	public ProposalMapper() {}

	/*@Override
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
	}*/

	@Override
	public Proposal getEntityFromDto(ProposalResource dto, View scope) {
		ModelMapper<ProposalResource, Proposal> mapper = 
				new ModelMapper<>(scope, ProposalResource.class, Proposal.class);
		
		try {
			return mapper.convert(dto);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProposalResource getDtoFromEntity(Proposal entity, View scope) {
		ModelMapper<Proposal, ProposalResource> mapper =
				new ModelMapper<>(scope, Proposal.class, ProposalResource.class);
		
		try {
			return mapper.convert(entity);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

}

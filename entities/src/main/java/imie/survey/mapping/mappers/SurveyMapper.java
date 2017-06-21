package imie.survey.mapping.mappers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Proposal;
import imie.survey.data.Role;
import imie.survey.data.Survey;
import imie.survey.mapping.IWrapper;
import imie.survey.mapping.ModelMapper;
import imie.survey.mapping.StackCallTrack;
import imie.survey.mapping.View;
import imie.survey.resources.ProposalResource;
import imie.survey.resources.RoleResource;
import imie.survey.resources.SurveyResource;
import imie.survey.utils.DateConverter;

@Component
public class SurveyMapper implements IWrapper<Survey, SurveyResource> {
	
	
	@Autowired
	private ProposalMapper proposalMapper;
	
	@Autowired
	private UserMapper userMapper;

	public SurveyMapper() {}
	
	

	/*@Override
	public SurveyResource getDtoFromEntity(Survey entity, View scope) {
		
		SurveyResource sondageRes = new SurveyResource();
		
		sondageRes.setId(entity.getId());
		sondageRes.setName(entity.getName());
		sondageRes.setAuthor(userMapper.getDtoFromEntity(entity.getAuthor()));
		
		sondageRes.setDateStart(DateConverter.toString(entity.getDateStart()));
		sondageRes.setDateFin(DateConverter.toString(entity.getDateEnd()));
		
		sondageRes.setQuestion(entity.getQuestion());
		
		Stream<Proposal> proposalStream = entity.getProposals().stream();
		
		if (scope == View.SURVEY) {
			proposalStream.forEach(proposal -> proposal.setSurvey(null));
		}
		
		List<ProposalResource> proposalResource =
				proposalStream.map(proposalMapper::getDtoFromEntity)
				.collect(Collectors.toList());
										
		sondageRes.setProposals(proposalResource);
		
		return sondageRes;
		
	}

	@Override
	public Survey getEntityFromDto(SurveyResource dto, Class clazz) {
		
		Survey survey = new Survey();
		survey.setId(dto.getId());
		survey.setName(dto.getName());
		
		survey.setDateStart(DateConverter.convertDateFromStr(dto.getDateStart()));
		survey.setDateEnd(DateConverter.convertDateFromStr(dto.getDateEnd()));
		
		survey.setAuthor(userMapper.getEntityFromDto(dto.getAuthor()));
		survey.setQuestion(dto.getQuestion());
		
		List<Proposal> proposals = dto.getProposals().stream().map(proposalMapper::getEntityFromDto).collect(Collectors.toList());
		survey.setProposals(proposals);
		
		return survey;
		
	}*/



	@Override
	public Survey getEntityFromDto(SurveyResource dto, View scope) {
		ModelMapper<SurveyResource, Survey> mapper =
				new ModelMapper<>(scope, SurveyResource.class, Survey.class);
		
		try {
			return mapper.convert(dto);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public SurveyResource getDtoFromEntity(Survey entity, View scope) {
		ModelMapper<Survey, SurveyResource> mapper =
				new ModelMapper<>(scope, Survey.class, SurveyResource.class);
		
		try {
			return mapper.convert(entity);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
}

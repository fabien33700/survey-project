package imie.survey.mapping.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Proposal;
import imie.survey.data.Survey;
import imie.survey.mapping.IWrapper;
import imie.survey.mapping.StackCallTrack;
import imie.survey.resources.ProposalResource;
import imie.survey.resources.SurveyResource;
import imie.survey.utils.DateConverter;

@Component
public class SurveyMapper implements IWrapper<Survey, SurveyResource> {
	
	@Autowired
	private StackCallTrack stack;
	
	@Autowired
	private ProposalMapper proposalMapper;
	
	@Autowired
	private UserMapper userMapper;

	public SurveyMapper() {}
	
	

	@Override
	public SurveyResource getDtoFromEntity(Survey entity, Class clazz) {
		
		SurveyResource sondageRes = new SurveyResource();
		
		sondageRes.setId(entity.getId());
		sondageRes.setName(entity.getName());
		sondageRes.setAuthor(userMapper.getDtoFromEntity(entity.getAuthor()));
		
		sondageRes.setDateStart(DateConverter.convertDateToString(entity.getDateStart()));
		sondageRes.setDateFin(DateConverter.convertDateToString(entity.getDateEnd()));
		
		sondageRes.setQuestion(entity.getQuestion());
		
		List<ProposalResource> proposalResource = entity.getProposals().stream()
																		   .map(proposalMapper::getDtoFromEntity)
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
		
	}
}

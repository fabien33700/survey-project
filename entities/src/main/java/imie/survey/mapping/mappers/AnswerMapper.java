package imie.survey.mapping.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Answer;
import imie.survey.data.Proposal;
import imie.survey.mapping.IWrapper;
import imie.survey.resources.AnswerResource;
import imie.survey.resources.ProposalResource;
import imie.survey.utils.DateConverter;

@Component
public class AnswerMapper implements IWrapper<Answer, AnswerResource>{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Autowired
	private ProposalMapper proposalMapper;

	@Override
	public Answer getEntityFromDto(AnswerResource dto) {
		
		Answer answer = new Answer();
		answer.setId(dto.getId());
		answer.setUser(userMapper.getEntityFromDto(dto.getUser()));
		answer.setSurvey(surveyMapper.getEntityFromDto(dto.getSurvey()));
		
		List<Proposal> proposals = dto.getProposals().stream().map(proposalMapper::getEntityFromDto).collect(Collectors.toList());
		answer.setProposals(proposals);
		
		answer.setDateAnswer(DateConverter.convertDateFromStr(dto.getDateAnswer()));
		
		return answer;
		
	}

	@Override
	public AnswerResource getDtoFromEntity(Answer entity) {
		
		AnswerResource answerRes = new AnswerResource();
		answerRes.setId(entity.getId());
		answerRes.setUser(userMapper.getDtoFromEntity(entity.getUser()));
		answerRes.setSurvey(surveyMapper.getDtoFromEntity(entity.getSurvey()));
		
		List<ProposalResource> proposals = entity.getProposals().stream().map(proposalMapper::getDtoFromEntity).collect(Collectors.toList());
		answerRes.setProposals(proposals);
		
		answerRes.setDateAnswer(DateConverter.convertDateToString(entity.getDateAnswer()));
		
		return answerRes;
	}

}

package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import imie.survey.data.Answer;
import imie.survey.mapping.modelmapper.Mapping;

/**
 * Reponse Sondage DTO
 *
 */
@Mapping(target = Answer.class)
public class AnswerResource {
	
	private Long id;
	
	private SurveyResource survey;
	
	private UserResource user;
	
	private List<ProposalResource> proposals;
	
	private String dateAnswer;

	public AnswerResource() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SurveyResource getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyResource survey) {
		this.survey = survey;
	}

	public UserResource getUser() {
		return user;
	}

	public void setUser(UserResource user) {
		this.user = user;
	}

	public List<ProposalResource> getProposals() {
		return proposals;
	}

	public void setProposals(List<ProposalResource> proposals) {
		this.proposals = proposals;
	}

	public String getDateAnswer() {
		return dateAnswer;
	}

	public void setDateAnswer(String dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
	
	public LocalDate getDateAnswerConverted() {
		return convertDateFromStr(this.dateAnswer);
	}
	
	public void setDateAnswerConverted(LocalDate date) {
		this.dateAnswer = convertDateToString(date);
	}
	
    // Converter
    
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	private LocalDate convertDateFromStr(String date) {
		return LocalDate.parse(date, formatter);
	}
	
	private String convertDateToString(LocalDate date) {
		return date.format(formatter);
	}
}

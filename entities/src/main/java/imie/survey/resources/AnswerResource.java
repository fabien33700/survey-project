package imie.survey.resources;

import java.util.List;

import imie.survey.data.Answer;

/**
 * Reponse Sondage DTO
 *
 */
public class AnswerResource implements ResourceEntity<Answer> {

	private Long id;
	
	private Long survey;
	
	private Long user;
	
	private List<String> proposals;
	
	private String dateAnswer;

	public AnswerResource() {}

	public AnswerResource(Long id, Long survey, Long user, List<String> proposals, String dateAnswer) {
		this.id = id;
		this.survey = survey;
		this.user = user;
		this.proposals = proposals;
		this.dateAnswer = dateAnswer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurvey() {
		return survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public List<String> getProposals() {
		return proposals;
	}

	public void setProposals(List<String> proposals) {
		this.proposals = proposals;
	}

	public String getDateAnswer() {
		return dateAnswer;
	}

	public void setDateAnswer(String dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
}

package imie.survey.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Proposition Reponse DTO
 *
 */
public class ProposalResource {
	
	private Long id;
	
	private String value;
	
	@JsonIgnore
	private SurveyResource survey;
	
	public ProposalResource() {}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

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
}

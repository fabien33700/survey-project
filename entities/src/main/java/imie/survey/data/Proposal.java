package imie.survey.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.serialization.Views;

@Entity
@Table(name="proposal")
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proposal")
	@JsonView(Views.Internal.class)
	private Long id;
	
	@Column
	@JsonView(Views.Internal.class)
	private String value;
	
	@ManyToOne
	@JsonView(Views.Proposal.class)
	private Survey survey;

	public String getValue() {
		return value;
	}
	
	public Proposal() {}

	public Proposal(Long id, String value, Survey survey) {
		this.id = id;
		this.value = value;
		this.survey = survey;
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

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
}

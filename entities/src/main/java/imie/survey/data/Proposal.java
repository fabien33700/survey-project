package imie.survey.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import imie.survey.mapping.modelmapper.Mapping;
import imie.survey.resources.ProposalResource;

@Entity
@Table(name="proposal")
@Mapping(target = ProposalResource.class)
public class Proposal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proposal")
	private Long id;
	
	@Column
	private String value;
	
	@ManyToOne
	private Survey survey;

	public String getValue() {
		return value;
	}
	
	public Proposal() {}

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

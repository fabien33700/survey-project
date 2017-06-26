package imie.survey.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import imie.survey.resources.AnswerResource;
import imie.utils.modelmapper.annotations.Mapping;

@Entity
@Table(name="answer")
@Mapping(target = AnswerResource.class)
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_answer")
	private Long id;
	
	@ManyToOne
	private Survey survey;
	
	@ManyToOne
	private User user;
	
	@JoinTable
	@OneToMany
	private List<Proposal> proposals;
	
	@Column(name="date_answer")
	private LocalDate dateAnswer;
	
	public Answer() {}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	public LocalDate getDateAnswer() {
		return dateAnswer;
	}

	public void setDateAnswer(LocalDate dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
}

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

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.serialization.Views;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_answer")
	@JsonView(Views.Internal.class)
	private Long id;
	
	@ManyToOne
	@JsonView(Views.Answer.class)
	private Survey survey;
	
	@ManyToOne
	@JsonView(Views.Answer.class)
	private User user;
	
	@JoinTable
	@OneToMany
	@JsonView(Views.Answer.class)
	private List<Proposal> proposals;
	
	@Column(name="date_answer")
	@JsonView(Views.Internal.class)
	private LocalDate dateAnswer;
	
	public Answer() {}

	public Answer(Long id, Survey survey, User user, List<Proposal> proposals, LocalDate dateAnswer) {
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

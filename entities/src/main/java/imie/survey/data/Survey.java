package imie.survey.data;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.converters.LocalDateConverter;
import imie.survey.serialization.Views;

/**
 * Sondage
 */
@Entity
@Table(name="survey")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_survey")
	@JsonView({Views.Internal.class, Views.Id.class})
	private Long id;
	
	@Column
	@JsonView(Views.Internal.class)
	private String name;
	
	@Column(name="date_start")
	@JsonView(Views.Internal.class)
	private LocalDate dateStart;
	
	@Column(name="date_end")
	@JsonView(Views.Internal.class)
	private LocalDate dateEnd;
	
	@ManyToOne
	@JsonView(Views.Survey.class)
	private User author;
	
	@Column
	@JsonView(Views.Internal.class)
	private String question;
	
	@OneToMany(mappedBy="survey", cascade = {PERSIST, REMOVE})
	
	@JsonView(Views.Survey.class)
	private List<Proposal> proposals;

	public Survey() {}
	
	public Survey(Long id, String name, LocalDate dateStart, LocalDate dateEnd, User author, String question,
			List<Proposal> proposals) {
		this.id = id;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.author = author;
		this.question = question;
		this.proposals = proposals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}

	@JsonGetter("dateStart")
	public String getDateStart() {
		return LocalDateConverter.getInstance().to(dateStart);
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	@JsonGetter("dateEnd")
	public String getDateEnd() {
		return LocalDateConverter.getInstance().to(dateEnd);
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idSondage) {
		this.id = idSondage;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}

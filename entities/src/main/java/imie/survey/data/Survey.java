package imie.survey.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import imie.survey.resources.SurveyResource;
import imie.utils.modelmapper.annotations.Convert;
import imie.utils.modelmapper.annotations.Mapping;
import imie.utils.modelmapper.converters.LocalDateISOToString;

/**
 * Sondage
 */
@Entity
@Table(name="survey")
@Mapping(target = SurveyResource.class)
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_survey")
	private Long id;
	
	@Column
	private String name;
	
	@Convert(using = LocalDateISOToString.class)
	@Column(name="date_start")
	private LocalDate dateStart;
	
	@Convert(using = LocalDateISOToString.class)
	@Column(name="date_end")
	private LocalDate dateEnd;
	
	@ManyToOne
	//@Ignore
	private User author;
	
	@Column
	private String question;
	
	@OneToMany(mappedBy="survey", cascade = CascadeType.PERSIST)
	private List<Proposal> proposals;

	public Survey() {}
	
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

	public LocalDate getDateStart() {
		return dateStart;
	}


	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
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

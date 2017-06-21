package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import imie.survey.customSerializer.SondageSerializer;
import imie.survey.data.Survey;
import imie.survey.mapping.modelmapper.Mapping;

/**
 * Sondage DTO
 */
@Mapping(target = Survey.class)
public class SurveyResource {
	
	private Long id;

	private String name;
	
	private String dateStart;
	
	private String dateEnd;
	
	private UserResource author;
	
	private String question;

	private List<ProposalResource> proposals;
	
	public SurveyResource() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public List<ProposalResource> getProposals() {
		return proposals;
	}

	public void setProposals(List<ProposalResource> proposals) {
		this.proposals = proposals;
	}

	public UserResource getAuthor() {
		return author;
	}
	
	public void setAuthor(UserResource author) {
		this.author = author;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateFin(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "SurveyResource [id=" + id + ", name=" + name + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd
				+ ", author=" + author + ", question=" + question + ", proposals=" + proposals + "]";
	}

	// TODO A supprimer!

	
	
}

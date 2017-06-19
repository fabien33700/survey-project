package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import imie.survey.customSerializer.SondageSerializer;
import imie.survey.data.Proposal;
import imie.survey.mapping.Transform;
import imie.survey.mapping.Treatment;

/**
 * Sondage DTO
 */
@JsonSerialize(using = SondageSerializer.class)
public class SurveyResource {
	
	private Long id;

	private String name;
	
	private String dateStart;
	
	private String dateEnd;
	
	private UserResource author;
	
	private String question;

	// @NestedMapping(target = Proposal.class, source = ProposalResource.class)
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
	
	@scope("UserScope")
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

	public LocalDate getDateStartConverted() {
		return convertDateFromStr(this.dateStart);
    }
	
	public LocalDate getDateEndConverted() {
		return convertDateFromStr(this.dateEnd);
    }
 
    public void setDateStartConverted(LocalDate date) {
        this.dateStart = convertDateToString(date);
    }
    
    public void setDateendConverted(LocalDate date) {
        this.dateEnd = convertDateToString(date);
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

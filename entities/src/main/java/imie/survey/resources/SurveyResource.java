package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import imie.survey.converters.Converter;
import imie.survey.converters.LocalDateConverter;
import imie.survey.data.Survey;

/**
 * Sondage DTO
 */
public class SurveyResource implements ResourceEntity<Survey> {
	
	private Converter<LocalDate, String> converter = 
			LocalDateConverter.getInstance();
	
	private Long id;

	@NotBlank(message = "Le nom du sondage doit être renseigné.")
	private String name;
	
	@NotBlank(message = "La date de début du sondage doit être renseignée.")
	private String dateStart;
	
	@NotBlank(message = "La date de fin du sondage doit être renseignée.")
	private String dateEnd;
	
	@NotNull(message = "L'auteur du sondage doit être renseigné.")
	private String author;
	
	@NotBlank(message = "La question doit être renseignée.")
	private String question;

	@NotEmpty(message = "Des propositions de réponses doivent être renseignées.")
	@Size(min = 2, max = 10, message = "Le nombre de propositions doit être compris entre 2 et 10.")
	private List<String> proposals;
	
	public SurveyResource() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getProposals() {
		return proposals;
	}

	public void setProposals(List<String> proposals) {
		this.proposals = proposals;
	}

	@Override
	public void validate() throws ValidationException {		
		if (converter.from(dateEnd)
				.isBefore(converter.from(dateStart))) {
			throw new ValidationException("La date de fin ne peut être inférieure à la date de début.");
		}	
	}

}

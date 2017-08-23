package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import imie.survey.converters.Converter;
import imie.survey.converters.LocalDateConverter;
import imie.survey.data.Answer;

/**
 * Reponse Sondage DTO
 *
 */
public class AnswerResource implements ResourceEntity<Answer> {

	private Long id;

	@NotNull(message = "L'id du sondage doit être renseigné.")
	private Long survey;
	
	@NotNull(message = "Le pseudo de l'utilisateur doit être renseigné.")
	private String user;
	
	@NotEmpty(message = "Des propositions de réponses doivent être renseignées.")
	@Size(min = 1, message = "La réponse doit comporter au moins une proposition.")
	private List<Long> proposals;
	
	@NotEmpty
	private String dateAnswer;

	public AnswerResource() {}

	public AnswerResource(Long id, Long survey, String user, List<Long> proposals, String dateAnswer) {
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

	public Long getSurvey() {
		return survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Long> getProposals() {
		return proposals;
	}

	public void setProposals(List<Long> proposals) {
		this.proposals = proposals;
	}

	public String getDateAnswer() {
		return dateAnswer;
	}

	public void setDateAnswer(String dateAnswer) {
		this.dateAnswer = dateAnswer;
	}

	@Override
	public void validate() throws ValidationException {
		Converter<LocalDate, String> converter = 
				LocalDateConverter.getInstance();
		
		try {
			converter.from(dateAnswer);
		} catch (Exception e) {
			throw new ValidationException("La date de réponse n'est pas valide.");
		}
	}
}

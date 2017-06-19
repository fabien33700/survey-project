package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import imie.survey.data.PropositionReponse;
import imie.survey.data.Sondage;
import imie.survey.data.Utilisateur;

/**
 * Reponse Sondage DTO
 *
 */
public class ReponseSondageResource {
	
	private Long id;
	
	private Sondage sondage;
	
	private Utilisateur utilisateur;
	
	private List<PropositionReponse> reponses;
	
	private String dateReponse;

	public ReponseSondageResource() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<PropositionReponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<PropositionReponse> reponses) {
		this.reponses = reponses;
	}

	public String getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(String dateReponse) {
		this.dateReponse = dateReponse;
	}
	
	public LocalDate getDateReponseConverted() {
		return convertDateFromStr(this.dateReponse);
	}
	
	public void setDatereponseConverted(LocalDate date) {
		this.dateReponse = convertDateToString(date);
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

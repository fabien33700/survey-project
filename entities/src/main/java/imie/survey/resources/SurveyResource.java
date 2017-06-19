package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import imie.survey.customSerializer.SondageSerializer;
import imie.survey.data.PropositionReponse;
import imie.survey.data.Utilisateur;

/**
 * Sondage DTO
 */
@JsonSerialize(using = SondageSerializer.class)
public class SondageResource {
	
	private Long id;

	private String nom;
	
	private String dateDebut;
	
	private String dateFin;
	
	private Utilisateur auteur;
	
	private String question;

	private List<PropositionReponse> propositionsReponse;
	
	public SondageResource() {}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
    public List<PropositionReponse> getPropositionsReponse() {
		return propositionsReponse;
	}

	public void setPropositionsReponse(List<PropositionReponse> propositionsReponse) {
		this.propositionsReponse = propositionsReponse;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
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

	public LocalDate getDateDebutConverted() {
		return convertDateFromStr(this.dateDebut);
    }
	
	public LocalDate getDateFinConverted() {
		return convertDateFromStr(this.dateFin);
    }
 
    public void setDateDebutConverted(LocalDate date) {
        this.dateDebut = convertDateToString(date);
    }
    
    public void setDateFinConverted(LocalDate date) {
        this.dateFin = convertDateToString(date);
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

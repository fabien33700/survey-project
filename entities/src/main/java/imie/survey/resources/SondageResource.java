package imie.survey.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import imie.survey.data.PropositionReponse;

/**
 * Sondage DTO
 */
public class SondageResource {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	private Long id;

	private String nom;
	
	private String dateDebut;
	
	private String dateFin;
	
	private UtilisateurResource auteur;

	//private List<String> propositionsReponse;
	private List<PropositionReponse> propositionsReponse;
	
	public SondageResource() {}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

//	public List<String> getPropositionsReponse() {
//		return propositionsReponse;
//	}
//
//	public void setPropositionsReponse(List<String> propositionsReponse) {
//		this.propositionsReponse = propositionsReponse;
//	}
    
    public List<PropositionReponse> getPropositionsReponse() {
		return propositionsReponse;
	}

	public void setPropositionsReponse(List<PropositionReponse> propositionsReponse) {
		this.propositionsReponse = propositionsReponse;
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

	public UtilisateurResource getAuteur() {
		return auteur;
	}

	public void setAuteur(UtilisateurResource auteur) {
		this.auteur = auteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
   
    
	private LocalDate convertDateFromStr(String date) {
		return LocalDate.parse(date, formatter);
	}
	
	private String convertDateToString(LocalDate date) {
		return date.format(formatter);
	}
}

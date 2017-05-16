package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

/**
 * Sondage DTO
 */
public class SondageResource {
	
	private Long id;
	
	private String nom;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	private UtilisateurResource auteur;

	private List<PropositionReponseResource> propositionsReponse;
	
	public SondageResource() {}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<PropositionReponseResource> getPropositionsReponse() {
		return propositionsReponse;
	}

	public void setPropositionsReponse(List<PropositionReponseResource> propositionsReponse) {
		this.propositionsReponse = propositionsReponse;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idSondage) {
		this.id = idSondage;
	}

	public UtilisateurResource getAuteur() {
		return auteur;
	}

	public void setAuteur(UtilisateurResource auteur) {
		this.auteur = auteur;
	}
}

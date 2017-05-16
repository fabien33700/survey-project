package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

/**
 * Sondage DTO
 */
public class Sondage {
	
	private Long id;
	
	private String nom;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;

	private List<PropositionReponse> propositionsReponse;
	
	public Sondage() {}

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
}

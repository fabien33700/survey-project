package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

/**
 * Reponse Sondage DTO
 *
 */
public class ReponseSondage {
	
	private Long id;
	
	private Sondage sondage;
	
	private Utilisateur utilisateur;
	
	private List<PropositionReponse> reponses;
	
	private LocalDate dateReponse;

	public ReponseSondage() {}

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

	public LocalDate getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(LocalDate dateReponse) {
		this.dateReponse = dateReponse;
	}
}

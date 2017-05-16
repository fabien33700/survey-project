package imie.survey.resources;

import java.time.LocalDate;
import java.util.List;

/**
 * Reponse Sondage DTO
 *
 */
public class ReponseSondageResource {
	
	private Long id;
	
	private SondageResource sondage;
	
	private UtilisateurResource utilisateur;
	
	private List<PropositionReponseResource> reponses;
	
	private LocalDate dateReponse;

	public ReponseSondageResource() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SondageResource getSondage() {
		return sondage;
	}

	public void setSondage(SondageResource sondage) {
		this.sondage = sondage;
	}

	public UtilisateurResource getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurResource utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<PropositionReponseResource> getReponses() {
		return reponses;
	}

	public void setReponses(List<PropositionReponseResource> reponses) {
		this.reponses = reponses;
	}

	public LocalDate getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(LocalDate dateReponse) {
		this.dateReponse = dateReponse;
	}
}

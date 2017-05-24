package imie.survey.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import imie.survey.data.Sondage;

/**
 * Proposition Reponse DTO
 *
 */
public class PropositionReponseResource {
	
	private Long id;
	
	private String valeur;
	
	@JsonIgnore
	private Sondage sondage;
	
	public PropositionReponseResource() {}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

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
}

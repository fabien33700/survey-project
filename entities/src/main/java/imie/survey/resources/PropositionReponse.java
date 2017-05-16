package imie.survey.resources;

/**
 * Proposition Reponse DTO
 *
 */
public class PropositionReponse {
	
	private Long id;
	
	private String valeur;
	
	private Sondage sondage;
	
	public PropositionReponse() {}

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

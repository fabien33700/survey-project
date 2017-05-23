package imie.survey.resources;

/**
 * Proposition Reponse DTO
 *
 */
public class PropositionReponseResource {
	
	private Long id;
	
	private String valeur;
	
	private SondageResource sondage;
	
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

	public SondageResource getSondage() {
		return sondage;
	}

	public void setSondage(SondageResource sondage) {
		this.sondage = sondage;
	}	
}

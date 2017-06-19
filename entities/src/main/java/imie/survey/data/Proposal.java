package imie.survey.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="proposition_reponse")
public class PropositionReponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_proposition")
	private Long id;
	
	@Column(name="valeur")
	private String valeur;
	
	@ManyToOne
	private Sondage sondage;

	public String getValeur() {
		return valeur;
	}
	
	public PropositionReponse() {}

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

package imie.survey.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reponse_sondage")
public class ReponseSondage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_reponse")
	private Long id;
	
	@ManyToOne
	private Sondage sondage;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToMany
	private List<PropositionReponse> reponses;
	
	@Column(name="date_reponse")
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

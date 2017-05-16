package imie.survey.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sondage
 */
@Entity
@Table(name="sondage")
public class Sondage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_sondage")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="date_debut")
	private LocalDate dateDebut;
	
	@Column(name="date_fin")
	private LocalDate dateFin;
	
	@OneToMany(mappedBy="sondage")
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

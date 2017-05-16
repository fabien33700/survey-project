package imie.survey.resources;

/**
 * Role DTO
 */
public class Role {
	
	private Long id;
	
	private String nom;

	public Role() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

package imie.survey.resources;

/**
 * Utilisateur DTO
 */
public class UtilisateurResource {
	
	private Long id;

	private String pseudo;

	private String hashPass;

	private RoleResource role;

	private Integer age;

	public UtilisateurResource() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getHashPass() {
		return hashPass;
	}

	public void setHashPass(String hashPass) {
		this.hashPass = hashPass;
	}

	public RoleResource getRole() {
		return role;
	}

	public void setRole(RoleResource role) {
		this.role = role;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

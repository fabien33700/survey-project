package imie.survey.resources;

import java.util.List;

/**
 * Utilisateur DTO
 */
public class UserResource {
	
	private Long id;

	private String pseudo;

	private String hashPass;

	private RoleResource role;

	private Integer age;
	
	private List<SurveyResource> surveys;

	public UserResource() {}

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

	public List<SurveyResource> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<SurveyResource> surveys) {
		this.surveys = surveys;
	}

}

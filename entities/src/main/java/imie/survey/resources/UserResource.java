package imie.survey.resources;

import java.util.List;

import imie.survey.data.User;

/**
 * Utilisateur DTO
 */
public class UserResource implements ResourceEntity<User>{
	
	private Long id;

	private String pseudo;

	private String hashPass;

	private Long role;

	private Integer age;
	
	private List<Long> surveys;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public List<Long> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Long> surveys) {
		this.surveys = surveys;
	}
}

package imie.survey.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import imie.survey.mapping.modelmapper.Ignore;
import imie.survey.mapping.modelmapper.Mapping;
import imie.survey.resources.UserResource;


@Entity
@Table(name = "user")
@Mapping(target = UserResource.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "hash_pass")
	private String hashPass;
	
	@ManyToOne
	private Role role;
	
	@Column(name = "age")
	private Integer age;
	
	@OneToMany(mappedBy="author")
	private List<Survey> surveys;

	public User() {}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pseudo=" + pseudo + ", hashPass=" + hashPass + ", role=" + role + ", age=" + age
				+ ", surveys=" + surveys + "]";
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Arrays.asList(role);
//	}
//
//	@Override
//	public String getPassword() {
//		return hashPass;
//	}
//
//	@Override
//	public String getUsername() {
//		return pseudo;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
	
	
}

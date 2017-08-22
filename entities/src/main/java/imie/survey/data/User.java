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

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.serialization.Views;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Internal.class)
	private Long id;
	
	@Column(name = "pseudo")
	@JsonView(Views.Internal.class)
	private String pseudo;
	
	@Column(name = "hash_pass")
	@JsonView(Views.Internal.class)
	private String hashPass;
	
	@ManyToOne
	@JsonView(Views.Internal.class)
	private Role role;
	
	@Column(name = "age")
	@JsonView(Views.Internal.class)
	private Integer age;
	
	@OneToMany(mappedBy="author")
	@JsonView(Views.User.class)
	private List<Survey> surveys;

	public User() {}

	public User(Long id, String pseudo, String hashPass, Role role, Integer age, List<Survey> surveys) {
		this.id = id;
		this.pseudo = pseudo;
		this.hashPass = hashPass;
		this.role = role;
		this.age = age;
		this.surveys = surveys;
	}

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

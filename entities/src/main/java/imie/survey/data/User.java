package imie.survey.data;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

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
	
	@OneToMany(mappedBy="auteur")
	private List<Sondage> sondages;

	public Utilisateur() {}
	
	public Utilisateur(Long id, String pseudo, String hashPass, Role role, Integer age, List<Sondage> sondages) {
		this.id = id;
		this.pseudo = pseudo;
		this.hashPass = hashPass;
		this.role = role;
		this.age = age;
		this.sondages = sondages;
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
	
	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
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

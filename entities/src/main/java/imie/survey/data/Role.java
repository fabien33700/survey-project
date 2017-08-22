package imie.survey.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import imie.survey.serialization.Views;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id_role")
	@JsonView(Views.Internal.class)
	private Long id;
	
	@Column(name = "name")
	@JsonView(Views.Internal.class)
	private String name;

	public Role() {}

	public Role(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String getAuthority() {
//		return nom;
//	}

}

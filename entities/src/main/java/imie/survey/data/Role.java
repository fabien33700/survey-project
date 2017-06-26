package imie.survey.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import imie.survey.resources.RoleResource;
import imie.utils.modelmapper.annotations.Mapping;

@Entity
@Table(name = "role")
@Mapping(target = RoleResource.class)
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id_role")
	private Long id;
	
	@Column(name = "name")
	private String name;

	public Role() {}

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

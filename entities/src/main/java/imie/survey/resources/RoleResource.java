package imie.survey.resources;

import imie.survey.data.Role;
import imie.utils.modelmapper.annotations.Mapping;

/**
 * Role DTO
 */
@Mapping(target = Role.class)
public class RoleResource {
	
	private Long id;
	
	private String name;

	public RoleResource() {}

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

}

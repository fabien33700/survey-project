package imie.survey.resources;

/**
 * Role DTO
 */
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

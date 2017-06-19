package imie.survey.mapping.mappers;

import org.springframework.stereotype.Component;

import imie.survey.data.Role;
import imie.survey.mapping.IWrapper;
import imie.survey.resources.RoleResource;

@Component
public class RoleMapper implements IWrapper<Role, RoleResource>{

	@Override
	public Role getEntityFromDto(RoleResource dto) {
		
		Role role = new Role();
		
		role.setId(dto.getId());
		role.setName(dto.getName());
		
		return role;
	}

	@Override
	public RoleResource getDtoFromEntity(Role entity) {
		
		RoleResource roleRes = new RoleResource();
		roleRes.setId(entity.getId());
		roleRes.setName(entity.getName());
		
		return roleRes;
	}

}

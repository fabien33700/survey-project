package imie.survey.mapping.mappers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

import imie.survey.data.Role;
import imie.survey.mapping.IWrapper;
import imie.survey.mapping.ModelMapper;
import imie.survey.mapping.View;
import imie.survey.resources.RoleResource;

@Component
public class RoleMapper implements IWrapper<Role, RoleResource>{

	/*@Override
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
	}*/

	@Override
	public Role getEntityFromDto(RoleResource dto, View scope) {
		ModelMapper<RoleResource, Role> mapper =
				new ModelMapper<>(scope, RoleResource.class, Role.class);
		
		try {
			return mapper.convert(dto);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RoleResource getDtoFromEntity(Role entity, View scope) {
		ModelMapper<Role, RoleResource> mapper =
				new ModelMapper<>(scope, Role.class, RoleResource.class);
		
		try {
			return mapper.convert(entity);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

}

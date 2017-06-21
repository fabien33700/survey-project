package imie.survey.mapping.mappers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Survey;
import imie.survey.data.User;
import imie.survey.mapping.IWrapper;
import imie.survey.mapping.ModelMapper;
import imie.survey.mapping.View;
import imie.survey.resources.SurveyResource;
import imie.survey.resources.UserResource;

@Component
public class UserMapper implements IWrapper<User, UserResource> {
	
	@Autowired
	private SurveyMapper surveyMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	public UserMapper() {};

	/*@Override
	public User getEntityFromDto(UserResource dto) {
		
		User user = new User();
		
		user.setId(dto.getId());
		user.setAge(dto.getAge());
		user.setPseudo(dto.getPseudo());
		user.setHashPass(dto.getHashPass());
		user.setRole(roleMapper.getEntityFromDto(dto.getRole()));
		
		List<Survey> surveys = dto.getSurveys().stream().map(surveyMapper::getEntityFromDto).collect(Collectors.toList());
		
		user.setSurveys(surveys);
		
		return user;
	}

	@Override
	public UserResource getDtoFromEntity(User entity) {
		
		UserResource userRes = new UserResource();
		
		userRes.setId(entity.getId());
		userRes.setAge(entity.getAge());
		userRes.setHashPass(entity.getHashPass());
		userRes.setPseudo(entity.getPseudo());
		userRes.setRole(roleMapper.getDtoFromEntity(entity.getRole()));
		
		List<SurveyResource> surveysRes = entity.getSurveys().stream().map(surveyMapper::getDtoFromEntity).collect(Collectors.toList());
		userRes.setSurveys(surveysRes);
		
		return userRes;
	}*/

	@Override
	public User getEntityFromDto(UserResource dto, View scope) {
		ModelMapper<UserResource, User> mapper =
				new ModelMapper<>(scope, UserResource.class, User.class);
		
		try {
			return mapper.convert(dto);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserResource getDtoFromEntity(User entity, View scope) {
		ModelMapper<User, UserResource> mapper =
				new ModelMapper<>(scope, User.class, UserResource.class);
		
		try {
			return mapper.convert(entity);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
	

}


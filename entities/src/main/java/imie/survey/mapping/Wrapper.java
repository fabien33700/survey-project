package imie.survey.mapping;

import imie.utils.modelmapper.ModelMapper;

@SuppressWarnings("unchecked")
public interface Wrapper<E, D> {
		
	default E getEntityFromDto(D dto)  {
		ModelMapper mapper = new ModelMapper(dto);
		return (E)mapper.convert();
	}
	
	default D getDtoFromEntity(E entity) {
		ModelMapper mapper = new ModelMapper(entity);
		return (D)mapper.convert();
	}
}

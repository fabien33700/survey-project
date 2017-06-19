package imie.survey.mapping;

public interface IWrapper<E, D> {
	
	E getEntityFromDto(D dto);
	D getDtoFromEntity(E entity);
}

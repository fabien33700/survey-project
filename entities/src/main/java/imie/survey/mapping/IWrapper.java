package imie.survey.mapping;

public interface IWrapper<E, D> {
	
	E getEntityFromDto(D dto, View scope);
	D getDtoFromEntity(E entity, View scope);
}

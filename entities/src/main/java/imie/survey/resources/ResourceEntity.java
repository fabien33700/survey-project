package imie.survey.resources;

import javax.validation.ValidationException;

public interface ResourceEntity<E> {
	default void validate() throws ValidationException {}
}

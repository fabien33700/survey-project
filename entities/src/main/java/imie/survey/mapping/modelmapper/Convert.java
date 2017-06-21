package imie.survey.mapping.modelmapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import imie.survey.mapping.modelmapper.converters.Converter;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Convert {
	@SuppressWarnings("rawtypes")
	Class<? extends Converter> using();
}

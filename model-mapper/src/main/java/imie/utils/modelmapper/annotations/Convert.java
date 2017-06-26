package imie.utils.modelmapper.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import imie.utils.modelmapper.converters.Converter;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Convert {
	@SuppressWarnings("rawtypes")
	Class<? extends Converter> using();
}

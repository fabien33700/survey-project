package imie.survey.converters;

public interface Converter<I, O> {	
	O to(I input);
	I from(O output);
}

package imie.survey.mapping.modelmapper.converters;

public interface Converter<S, T> {
	T convert(S source);
}

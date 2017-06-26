package imie.utils.modelmapper.converters;

public interface Converter<S, T> {
	T convert(S source);
}

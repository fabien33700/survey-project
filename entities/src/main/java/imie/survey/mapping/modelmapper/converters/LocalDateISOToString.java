package imie.survey.mapping.modelmapper.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RegisterConverter(returns = String.class)	
public class LocalDateISOToString implements Converter<LocalDate, String>{
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

	@Override
	public String convert(LocalDate source) {
		return formatter.format(source);
	}
	
}


package imie.survey.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements Converter<LocalDate, String> {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public LocalDate from(String output) {
		return LocalDate.parse(output, formatter);
	}

	@Override
	public String to(LocalDate input) {
		return input.format(formatter);
	}

	public static Converter<LocalDate, String> getInstance() {
		return new LocalDateConverter();
	}

}

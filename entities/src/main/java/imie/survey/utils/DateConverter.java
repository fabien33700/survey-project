package imie.survey.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import imie.survey.mapping.Treatment;

public class DateConverter  {
	
	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	public class ToString implements Function<LocalDate, String> {

		@Override
		public String apply(LocalDate t) {
			return t.format(formatter);
		}
		
	}
	
	public class ToLocalDate implements Function<String, LocalDate> {

		@Override
		public LocalDate apply(String t) {
			return LocalDate.parse(t, formatter);
		}
		
	}

}

package imie.survey.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
	
	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	public static LocalDate convertDateFromStr(String date) {
		return LocalDate.parse(date, formatter);
	}
	
	public static String convertDateToString(LocalDate date) {
		return date.format(formatter);
	}

}

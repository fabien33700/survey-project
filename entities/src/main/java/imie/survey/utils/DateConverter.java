package imie.survey.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

	public static String toString(LocalDate date) {
		return date.format(formatter);

	}

	public static LocalDate toLocalDate(String date) {
		return LocalDate.parse(date, formatter);

	}

}

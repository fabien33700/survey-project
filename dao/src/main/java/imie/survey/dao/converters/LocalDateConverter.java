package imie.survey.dao.converters;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convertisseur pour la conversion de java.sql.Date en java.time.LocalDate
 * @author Fabien
 *
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate locDate) {
		return (locDate == null) ? null : Date.valueOf(locDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate) {
		return (sqlDate == null) ? null : sqlDate.toLocalDate();
	}
}

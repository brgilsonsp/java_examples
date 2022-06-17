package br.com.gilson.integration.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCalendarConvert implements Converter<String, Calendar> {

	@Override
	public Calendar convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			this.validSource(source);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(source));
			return calendar;

		} catch (ParseException e) {
			return null;
		}
	}

	private void validSource(String source) throws ParseException {
		String[] fieldsDate = source.split("/");
		if (fieldsDate.length != 3 || fieldsDate[0].length() > 2 || fieldsDate[1].length() > 2
				|| fieldsDate[2].length() > 4) {
			throw new ParseException(source, 0);
		}

	}

}

package br.com.gilson.integration.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import br.com.gilson.integration.config.StringToCalendarConvert;

public class StringToCalendarConvertTest {

	@Test
	public void mustBeReturnCalendarWhenSentDataInString() {
		//Build scenario
		String dateString = "26/06/2019";
		Calendar dateCalendar = null;
		Exception exception = null;
		
		//Execute operation
		try {
			dateCalendar = new StringToCalendarConvert().convert(dateString);
		} catch (Exception e) {
			exception = e;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String calendarToString = sdf.format(dateCalendar.getTime());
		
		//Execute test
		assertThat(exception).isNull();
		assertThat(dateCalendar).isInstanceOf(Calendar.class);
		assertEquals(dateString, calendarToString);
	}
	
	@Test
	public void mustBeReturnNullWhenSentInvalidDataInString() {
		//Build scenario
		String dateString = "201/06/20";
		Calendar dateCalendar = null;
		Exception exception = null;
		
		//Execute operation
		try {
			dateCalendar = new StringToCalendarConvert().convert(dateString);
		} catch (Exception e) {
			exception = e;
		}
		
		//Execute test
		assertThat(exception).isNull();
		assertThat(dateCalendar).isNull();
	}
}

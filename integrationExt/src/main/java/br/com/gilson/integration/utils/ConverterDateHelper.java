package br.com.gilson.integration.utils;

import java.util.Calendar;
import java.util.Locale;

import org.joda.time.DateTime;

public class ConverterDateHelper {

	public static Calendar dateTimeToCalendar(DateTime dateTime) {
		try {
			return dateTime.toCalendar(Locale.getDefault());
		} catch (Exception e) {
			return null;
		}
	}

	public static DateTime calendarToDateTime(Calendar value) {
		try {
			return new DateTime(value);
		} catch (Exception e) {
			return null;
		}
	}

}

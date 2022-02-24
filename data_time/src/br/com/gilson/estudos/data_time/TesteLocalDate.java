package br.com.gilson.estudos.data_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TesteLocalDate {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(String.format("Now: %s", now));
		
		LocalDate of = LocalDate.of(2020, 12, 31);
		System.out.println(String.format("of: %s", of));
		
		LocalDate casamento = LocalDate.of(2008, 2, 9);
		Period tempoCasado = Period.between(casamento, LocalDate.now());
		System.out.println(String.format("Total dias casado: %s", tempoCasado.toTotalMonths() * 30));
	
		LocalTime horaAtual = LocalTime.now();
		System.out.println(String.format("Hora atual: %s", horaAtual));
		
		LocalDateTime dataCompletoAtual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(String.format("Data e hora atual formatada: %s", dataCompletoAtual.format(formatter)));
		
		final ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
		ZonedDateTime dataAtualSaoPaulo = ZonedDateTime.now(saoPaulo);
		System.out.println(String.format("Data atual São Paulo: %s", dataAtualSaoPaulo));
		
		final ZoneId novaYork = ZoneId.of("America/New_York");
		ZonedDateTime dataAtualNewYork = ZonedDateTime.now(novaYork);
		System.out.println(String.format("Data atual New York: %s", dataAtualNewYork));
		
		MonthDay december25 = MonthDay.of(Month.DECEMBER, 25);
		formatter = DateTimeFormatter.ofPattern("dd/MM");
		System.out.println(String.format("25 de dezembro: %s", december25.format(formatter)));
		
		YearMonth yearMonth = YearMonth.now();
		formatter = DateTimeFormatter.ofPattern("MM/yyyy");
		System.out.println(String.format("Mês e ano hoje: %s", yearMonth.format(formatter)));
		
	}
}

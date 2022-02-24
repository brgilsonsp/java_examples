package br.com.gilson.learn.format.service;

import java.io.IOError;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;

public class FormatterDecimalService {

	public void process()  {
		throw new IOError(new Throwable("My Throwable"));
		/*
		 * PrintStream printStream = System.out; Map<String, String> getenv =
		 * System.getenv(); System.out.println(getenv.get("PROCESSOR_IDENTIFIER"));
		 * Properties properties = System.getProperties();
		 * System.out.format("Month is %tB %n", LocalDateTime.now());
		 * System.out.format("Day is %td %te %n", LocalDateTime.now().minusDays(1),
		 * LocalDateTime.now().minusDays(1)); String stringFormatted =
		 * String.format("%*10s", "102"); System.out.println(stringFormatted);
		 */
		/*
		 * printStream.format("Now we watting %d millis-seconds", 10000); final long
		 * firstTime = System.currentTimeMillis(); this.wait(10000);
		 * printStream.format("Uau we waitting %d millis", System.currentTimeMillis() -
		 * firstTime);
		 */
		//new PrintStream("").format("other value", "args");
		//String.format("one value", "args");
	}
}

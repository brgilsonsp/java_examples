package br.com.gilson.estudos.data_time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.Instant;

public class TestCounterTotalTimeExection {

	public static void main(String[] args) throws IOException {
		
		new TestCounterTotalTimeExection().readFile();
		
	}
	
	public void readFile() throws UnsupportedEncodingException {
		final Instant startExecution = Instant.now();
		
		InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/file.txt"), "UTF-8");             
		BufferedReader bufferedReader = new BufferedReader(reader);
		bufferedReader.lines().forEach(System.out::println);
		
		this.finalizaExecucao(startExecution);
	}
	
	
	private void finalizaExecucao(final Instant startExecution) {
		final Instant endExecution = Instant.now();
		
		final Duration duration = Duration.between(startExecution, endExecution);
		System.out.println(String.format("Execucao finalizado em %d ms OU %d ns", duration.toMillis(), duration.getNano()));
	}
}

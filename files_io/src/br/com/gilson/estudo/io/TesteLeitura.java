package br.com.gilson.estudo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {
	
	public static void main(String[] args) throws IOException {
		InputStream stream = new FileInputStream("lorem.txt");
		Reader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		
		buffer.lines().forEach(System.out::println);
		
		buffer.close();
		
	}

}

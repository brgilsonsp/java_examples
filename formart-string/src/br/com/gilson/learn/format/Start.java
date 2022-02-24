package br.com.gilson.learn.format;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;

import br.com.gilson.learn.format.service.FormatterDecimalService;

public class Start {

	public static void main(String[] args) {
		
		try {
			new FormatterDecimalService().process();
		} catch (IOError e) {
			e.printStackTrace();
		}
		
		

	}

}

package br.com.gilson.estudo.io;

import java.io.IOException;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) throws Exception, IOException {
		
		new TesteProperties().printProp();

	}
	
	public void printProp() throws Exception {
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream("/arq.properties"));
		
		String chaveUm = prop.getProperty("chave_1");
		String chaveDois = prop.getProperty("chave_2");
		System.out.println(String.format("Chave_1: %s, chave_2: %s", chaveUm, chaveDois));
	}

}

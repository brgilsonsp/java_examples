package br.com.gilson.estudo.io;

import java.io.File;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("contas.csv"));
		
		while(scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
		
		scanner.close();
	}
}

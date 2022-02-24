package br.com.gilson.estudo.io;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class TesteScannerCsv {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new File("contas.csv"), StandardCharsets.UTF_8);
		
		while(scanner.hasNext()) {
			Scanner scannerLine = new Scanner(scanner.nextLine());
			scannerLine.useDelimiter(",");
			scannerLine.useLocale(Locale.US);
			final String tipoConta = scannerLine.next();
			final int agencia = scannerLine.nextInt();
			final int conta = scannerLine.nextInt();
			final String name = scannerLine.next();
			final BigDecimal saldo = scannerLine.nextBigDecimal();
			
			
			System.out.println(String.format(
					new Locale("pt", "BR"), 
					"Tipo conta: %s, agência: %05d, conta: %05d, nome: %15s, saldo: R$ %.2f", 
					tipoConta, agencia, conta, name, saldo));
			
			scannerLine.close();
		}
		
		scanner.close();
	}
}

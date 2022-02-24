package br.com.gilson.estudo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteImprimeTela {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = getTexto();
		BufferedWriter writer = getWriter();

		String linha = reader.readLine();
		while(null != linha && !linha.isEmpty()) {
			writer.write(linha);
			writer.newLine();
			writer.flush();
			linha = reader.readLine();
		}

		reader.close();
		writer.close();
	}

	private static BufferedWriter getWriter() throws IOException {
		OutputStream stream = System.out;
		Writer streamWriter = new OutputStreamWriter(stream);
		return new BufferedWriter(streamWriter);
	}

	private static BufferedReader getTexto() throws IOException {
		InputStream stream = new FileInputStream("lorem.txt");
		Reader streamReader = new InputStreamReader(stream);
		return new BufferedReader(streamReader);
	}
}

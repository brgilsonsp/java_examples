package br.com.gilson.estudo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteCtrlCCtrlV {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = getText();
		BufferedWriter writer = getWriter();
		
		reader.lines().forEach(line -> {
			try {
				writer.write(line);
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		reader.close();
		writer.close();
	}

	private static BufferedWriter getWriter() throws IOException {
		OutputStream stream = new FileOutputStream("lorem_copy.txt");
		Writer streamWriter = new OutputStreamWriter(stream);
		return new BufferedWriter(streamWriter);
	}

	private static BufferedReader getText() throws IOException {
		InputStream stream = new FileInputStream("lorem.txt");
		Reader streamReader = new InputStreamReader(stream);
		return new BufferedReader(streamReader);
	}
}

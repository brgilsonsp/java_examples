package br.com.gilson.estudo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class TesteRede {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket();
		// TODO: conectar socket.connect(endpoint);
		InputStream stream = socket.getInputStream();
		Reader streamReader = new InputStreamReader(stream);
		BufferedReader reader =  new BufferedReader(streamReader);
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
		socket.close();
	}

	private static BufferedWriter getWriter() throws IOException {
		OutputStream stream = System.out;
		Writer streamWriter = new OutputStreamWriter(stream);
		return new BufferedWriter(streamWriter);
	}

}

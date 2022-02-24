package br.com.gilson.estudo.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {
	
	public static void main(String[] args) throws IOException{
		
		OutputStream outoput = new FileOutputStream("lorem_2.json");
		Writer writerStream = new OutputStreamWriter(outoput);
		BufferedWriter buffered = new BufferedWriter(writerStream);
		
		buffered.write("{\"key\":\"ajsds\", \"value\":\"aqsw\"}");
		buffered.newLine();
		
		buffered.close();
	}

}

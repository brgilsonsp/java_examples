package br.com.gilson.estudo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TesteTempoExecucao {
	
	public static void main(String[] args) throws IOException{
		
		final long inicio = System.currentTimeMillis();
		Writer writer = new FileWriter("file_writer.rae");
		BufferedWriter buffered = new BufferedWriter(writer);
		
		buffered.write("asdasdASDASDFSDAFSDF");
		buffered.newLine();
		buffered.newLine();
		buffered.write("dsf54f56dsa4f65d4 4sf4asd 6f4dsa6f4 sdaf");
		buffered.newLine();
		buffered.write("dsf54f56dsa4f65d4 4sf4asd 6f4dsa6f4 sdaf");
		buffered.newLine();
		buffered.write("dsf54f56dsa4f65d4 4sf4asd 6f4dsa6f4 sdaf");
		
		buffered.close();
		
		final long fim = System.currentTimeMillis();
		
		System.out.println(String.format("Executado em %d ms", (fim - inicio)));
	}

}

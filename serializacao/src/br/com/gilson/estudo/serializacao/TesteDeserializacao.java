package br.com.gilson.estudo.serializacao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteDeserializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		ObjectInputStream input = new ObjectInputStream(new FileInputStream("gilson.bin"));
		Model model = (Model)input.readObject();
		input.close();
		
		System.out.println(model.toString());
	}

}

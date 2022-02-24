package br.com.gilson.estudo.serializacao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

	public static void main(String[] args) throws IOException {
		final Model model = new Model("Gilson", 35, TipoModel.TipoI);
		//model.setNameFather("Gilçon");
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("gilson.bin"));
		output.writeObject(model);
		output.close();
	}

}

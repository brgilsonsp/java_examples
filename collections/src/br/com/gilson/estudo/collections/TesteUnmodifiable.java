package br.com.gilson.estudo.collections;

public class TesteUnmodifiable {

	public static void main(String[] args) {

		Curso curso = new Curso();
		Utils.getAulas().forEach(curso::adiciona);
		
		try {
			System.out.println("Acho que não vai dar certo....");
			curso.getAulas().add(new Aula("Xii exception"));
		}catch(UnsupportedOperationException exception) {
			System.out.println("Deu ruim né? " + exception);
		}
	}

}

package br.com.gilson.estudo.collections;

import java.util.Comparator;
import java.util.List;

public class TesteSort {

	public static void main(String[] args) {
		
		List<Aula> aulas = Utils.getAulas();
		
		System.out.println(aulas);
		
		aulas.sort(Comparator.comparing(Aula::getName));
		
		System.out.println(aulas);
		
	}

}

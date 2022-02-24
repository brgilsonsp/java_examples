package br.com.gilson.estudo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
	
	private List<Aula> aulas = new ArrayList<>();
	
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(final Aula aula) {
		if(null != aula)
			this.aulas.add(aula);
	}
}

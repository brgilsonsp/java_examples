package br.com.gilson.estudo.collections;

public class Aula {

	private final String name;

	public Aula(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Aula [name=" + name + "]";
	}
	
	
}

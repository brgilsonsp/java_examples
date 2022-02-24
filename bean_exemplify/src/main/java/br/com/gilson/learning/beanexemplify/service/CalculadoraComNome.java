package br.com.gilson.learning.beanexemplify.service;


public class CalculadoraComNome {
	
	private final String nomeCalculadora;
	
	public CalculadoraComNome(String nomeCalculadora) {
		this.nomeCalculadora = nomeCalculadora;
	}

	public String getNome() {
		return this.nomeCalculadora;
	}

}

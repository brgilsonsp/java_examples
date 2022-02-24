package br.com.gilson.estudo.serializacao;

import java.io.Serializable;

public class ModelFather implements Serializable{

	private static final long serialVersionUID = -8717341587679130935L;

	private String nameFather;

	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}

	@Override
	public String toString() {
		return "ModelFather [nameFather=" + nameFather + "]";
	}
	
}

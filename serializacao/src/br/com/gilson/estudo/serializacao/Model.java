package br.com.gilson.estudo.serializacao;

import java.io.Serializable;

public class Model /* extends ModelFather */ implements Serializable{

	private static final long serialVersionUID = -2848342883603481343L;

	private final String name;
	private final int age;
	private final TipoModel tipoModel;

	public Model(final String name, final int age, final TipoModel tipoModel) {
		this.name = name;
		this.age = age;
		this.tipoModel = tipoModel;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public TipoModel getTipoModel() {
		return tipoModel;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Model");
		builder.append(" [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", tipoModel=");
		builder.append(tipoModel);
		builder.append("]");
		
		//builder.append(super.toString());
		
		return builder.toString();
	}
	
}

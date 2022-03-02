package br.com.gilson.examples.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class RegadorInfo {

	@SerializedName("marca")
	private String marca;
	
	@SerializedName("modelo")
	private String modelo;
}

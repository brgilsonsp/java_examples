package br.com.gilson.examples.model;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegadorPlanta 
{
	@SerializedName("id")
	private String id;
	
	@SerializedName("tipo_planta")
	private String tipoPlanta;
	
	@SerializedName("area_para_regar")
	private double areaParaRegar;
	
	@SerializedName("regador_info")
	private RegadorInfo regadorInfo;
}

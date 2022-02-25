package br.com.gilson.awslambda.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelRequest implements Serializable{
	
	private static final long serialVersionUID = 1253262495940712985L;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("name")
	private String age;
	
	@JsonProperty("code")
	private String code;

}
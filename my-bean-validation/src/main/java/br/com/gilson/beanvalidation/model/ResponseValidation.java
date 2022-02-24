package br.com.gilson.beanvalidation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseValidation {
	
	@JsonProperty("property")
	private String property;
	
	@JsonProperty("message")
	private String message;

}

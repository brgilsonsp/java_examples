package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.GatewayErrorResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundGatewayErrorResponse implements Serializable {

	private static final long serialVersionUID = -6393422221087508807L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("message")
	@Column(nullable = true)
	private String message;

	public void buildOrderMundoGatewayErrorResponse(GatewayErrorResponse gatewayError) {
		this.message = gatewayError.getMessage();
	}

}

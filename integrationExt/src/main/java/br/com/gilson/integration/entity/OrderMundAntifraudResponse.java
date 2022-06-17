package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.AntifraudResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundAntifraudResponse implements Serializable {

	private static final long serialVersionUID = 8226534260805890685L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("provider_name")
	@Column(nullable = true)
	private String providerName;

	@JsonProperty("status")
	@Column(nullable = true)
	private String status;

	@JsonProperty("return_code")
	@Column(nullable = true)
	private String returnCode;

	@JsonProperty("return_message")
	@Column(nullable = true)
	private String returnMessage;

	@JsonProperty("score")
	@Column(nullable = true)
	private String score;

	public void buidlOrderMundAntifraudResponse(AntifraudResponse antifraudResponse) {
		this.providerName = antifraudResponse.getProviderName();
		this.status = antifraudResponse.getStatus();
		this.returnCode = antifraudResponse.getReturnCode();
		this.returnMessage = antifraudResponse.getReturnMessage();
		this.score = antifraudResponse.getScore();
	}

}

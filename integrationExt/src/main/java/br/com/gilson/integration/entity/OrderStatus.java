package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OrderStatus implements Serializable{
	
	private static final long serialVersionUID = -691233796533711419L;

	public OrderStatus() {
		this.resetValues();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@Column(nullable=false)
	@JsonProperty(value="processed_gateway")
	private Boolean processedGateway;
	
	@Column(nullable=false)
	@JsonProperty(value="client_in_the_ura")
	private Boolean clientInTheURA;
	
	@Column(nullable=false)
	@JsonProperty(value="processed_ura")
	private Boolean processedURA;
	
	@Transient
	@JsonProperty(value="id_vanrooy")
	private String idVanrooy;
	
	/**
	 * Configure the property clientInTheURA for true
	 */
	@JsonIgnore
	@Transient
	public void uraStarter() {
		this.clientInTheURA = true;
	}
	
	/**
	 * Configure the property processedURA for true
	 * Configure the property clientInTheURA for false
	 */
	@JsonIgnore
	@Transient
	public void uraFinished() {
		this.processedURA = true;
		this.clientInTheURA = false;
	}
	
	/**
	 * Configure the property processedAdyen for true
	 */
	@JsonIgnore
	@Transient
	public void gatewayAnswered(){
		this.processedGateway = true;
	}
	
	/**
	 * Configure the properties to initial values
	 */
	@JsonIgnore
	@Transient
	public void resetValues() {
		this.processedGateway = false;
		this.clientInTheURA = false;
		this.processedURA = false;
	}

	public Long getId() {
		return id;
	}

	public Boolean getProcessedGateway() {
		return processedGateway;
	}

	public Boolean getClientInTheURA() {
		return clientInTheURA;
	}

	public Boolean getProcessedURA() {
		return processedURA;
	}

	public String getIdVanrooy() {
		return idVanrooy;
	}

	public void setIdVanrooy(String idVanrooy) {
		this.idVanrooy = idVanrooy;
	}
	
}


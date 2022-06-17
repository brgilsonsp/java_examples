package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.CardResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundCardResponse implements Serializable {

	private static final long serialVersionUID = -9177893215399584778L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("brand")
	@Column(nullable = true)
	private String brand;

	public void buildOrderMundCardResponse(CardResponse card) {
		this.brand = card.getBrand();
	}

}

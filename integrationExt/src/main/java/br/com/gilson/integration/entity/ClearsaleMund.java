package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.ClearSaleRequest;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Entity
public class ClearsaleMund implements Serializable {

	private static final long serialVersionUID = -717468772972455235L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty(required = true, value = "custom_sla")
	@NotNull(message = "it's necessary")
	@Positive(message = "accept only positive number")
	@Column(nullable = false)
	private int customSla;

	public int getCustomSla() {
		return customSla;
	}

	@JsonIgnore
	@Transient
	public ClearSaleRequest buildClearsalePatterMund() {
		return new ClearSaleRequest(this.customSla);
	}
}

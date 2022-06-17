package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.AddressRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.CardRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class CardMund implements Serializable {

	private static final long serialVersionUID = -6673051739860939299L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty(required = true, value = "holder_name")
	@NotBlank(message = "it's necessary")
	@Size(max = 64, message = "max 64 caracters")
	@Column(nullable = false)
	private String holderName;

	@JsonProperty(required = true, value = "billing_address")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotNull(message = "it's necessary")
	@Valid
	private AddressMund billingAddress;

	public String getHolderName() {
		return holderName;
	}

	public AddressMund getBillingAddress() {
		return billingAddress;
	}

	@JsonIgnore
	@Transient
	public CardRequest buildCardPatterMund() {

		String holderName = this.holderName;
		String type = "credit";
		AddressRequest billingAddress = this.billingAddress != null ? this.billingAddress.buildAddressPatterMundi()
				: null;

		return new CardRequest(holderName, billingAddress, type);
	}

}

package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.CreditCardPaymentRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.PaymentRequest;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Entity
public class PaymentMund implements Serializable {

	private static final long serialVersionUID = -7676975034737525947L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty(required = false, value = "payment_method")
	@Column(nullable = false)
	private String paymentMethod = "credit_card";

	@JsonProperty(required = true, value = "credit_card")
	@NotNull(message = "it's necessary")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Valid
	private CreditCardMund creditCard;

	@JsonProperty(required = false, value = "metadata")
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(length = 150)
	@Column(columnDefinition = "text", nullable = true)
	private Map<String, String> metadata = null;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public CreditCardMund getCreditCard() {
		return creditCard;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	@JsonIgnore
	@Transient
	public PaymentRequest buildPaymentPatterMundi(String currency) {

		String paymentMethod = this.paymentMethod;
		String currencyRequest = currency;
		Map<String, String> metadata = this.metadata;

		CreditCardPaymentRequest creditCard = this.creditCard != null ? this.creditCard.buildCreditCardPatterMundi()
				: null;

		return new PaymentRequest(paymentMethod, creditCard, currencyRequest, metadata);
	}

}
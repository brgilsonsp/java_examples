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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.CardRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.CreditCardPaymentRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class CreditCardMund implements Serializable {

	private static final long serialVersionUID = 6312446703213797229L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer id;

	@JsonProperty(required = true, value = "installments")
	@Column(nullable = false)
	@Positive(message = "only posivite number")
	@NotNull(message = "it's necessary")
	private int installments;

	@JsonProperty(required = false, value = "statement_descriptor")
	@Column(nullable = true)
	@Size(max = 22, message = "accept max 22 characters")
	private String statementDescriptor;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty(required = true, value = "card")
	@NotNull(message = "it's necessary")
	@Valid
	private CardMund card;

	@JsonProperty(required = true, value = "capture")
	@NotNull(message = "it's necessary")
	@Column(nullable = false)
	private Boolean capture;

	public int getInstallments() {
		return installments;
	}

	public String getStatementDescriptor() {
		return statementDescriptor;
	}

	public CardMund getCard() {
		return card;
	}

	public Boolean getCapture() {
		return capture;
	}

	@JsonIgnore
	@Transient
	public CreditCardPaymentRequest buildCreditCardPatterMundi() {

		Integer installments = this.installments;
		String statementDescriptor = this.statementDescriptor;
		Boolean capture = this.capture;
		CardRequest card = this.card != null ? this.card.buildCardPatterMund() : null;

		return new CreditCardPaymentRequest(installments, statementDescriptor, card, capture);
	}

}

package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.utils.ConverterDateHelper;
import gr.betta.onofre.mundipagg.ordermundi.entities.AddressRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.ShippingRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class ShippingMund implements Serializable {

	private static final long serialVersionUID = -4970107090621324713L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty(required = true, value = "amount")
	@Positive(message = "Only positive number")
	@NotNull(message = "it's necessary")
	private int amount;

	@JsonProperty(required = true, value = "description")
	@Column(nullable = false)
	@NotBlank(message = "it's necessary")
	@Size(max = 255, message = "accept max 255 caracters")
	private String description;

	@JsonProperty(required = false, value = "recipient_name")
	@Column(nullable = true)
	@Size(max = 255, message = "accept max 255 caracters")
	private String recipientName;

	@JsonProperty(required = false, value = "recipient_phone")
	@Column(nullable = true)
	@Size(max = 15, message = "accept max 15 caracters")
	private String recipientPhone;

	@JsonProperty(required = true, value = "address")
	@NotNull(message = "it's necessary")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Valid
	private AddressMund address;

	@JsonProperty(required = false, value = "max_delivery_date")
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar maxDeliveryDate;

	@JsonProperty(required = false, value = "estimated_delivery_date")
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar estimatedDeliveryDate;

	@JsonProperty(required = false, value = "type")
	@Column(nullable = true)
	@Size(max = 100, message = "accept max 100 caracters")
	private String type;

	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public AddressMund getAddress() {
		return address;
	}

	public Calendar getMaxDeliveryDate() {
		return maxDeliveryDate;
	}

	public Calendar getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public String getType() {
		return type;
	}


	@JsonIgnore
	@Transient
	public ShippingRequest buidShippingPatternMundi() {

		int amount = this.amount;
		String description = this.description;
		String recipientName = this.recipientName;
		String recipientPhone = this.recipientPhone;
		DateTime maxDeliveryDate = ConverterDateHelper.calendarToDateTime(this.maxDeliveryDate);
		DateTime estimatedDeliveryDate = ConverterDateHelper.calendarToDateTime(this.estimatedDeliveryDate);
		String type = this.type;
		AddressRequest address = this.address != null ? this.address.buildAddressPatterMundi() : null;

		return new ShippingRequest(amount, description, recipientName, recipientPhone, address, maxDeliveryDate,
				estimatedDeliveryDate, type);
	}
}

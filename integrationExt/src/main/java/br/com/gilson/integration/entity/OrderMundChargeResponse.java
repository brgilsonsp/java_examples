package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.utils.BuildMetadatasMundi;
import br.com.gilson.integration.utils.ConverterDateHelper;
import gr.betta.onofre.mundipagg.ordermundi.entities.ChargeResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundChargeResponse implements Serializable {

	private static final long serialVersionUID = -8803967199539069451L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("id_mund")
	@Column(nullable = true)
	private String idMund;

	@JsonProperty("gateway_id")
	@Column(nullable = true)
	private String gatewayId;

	@JsonProperty("amount")
	@Column(nullable = true)
	private Integer amount;

	@JsonProperty("status")
	@Column(nullable = true)
	private String status;

	@JsonProperty("currency")
	@Column(nullable = true)
	private String currency;

	@JsonProperty("payment_method")
	@Column(nullable = true)
	private String paymentMethod;

	@JsonProperty("paid_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Calendar paidAt;

	@JsonProperty("created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Calendar createdAt;

	@JsonProperty("updated_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Calendar updatedAt;

	@JsonProperty("last_transaction")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private OrderMundLastTransactionResponse lastTransaction = new OrderMundLastTransactionResponse();

	@JsonProperty("metadata")
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(length = 150)
	@Column(columnDefinition = "text", nullable = true)
	private Map<String, String> metadata;

	public void buildOrderMundChargeResponse(ChargeResponse charge) {
		this.idMund = charge.getId();
		this.gatewayId = charge.getGatewayId();
		this.amount = charge.getAmount();
		this.status = charge.getStatus();
		this.currency = charge.getCurrency();
		this.paymentMethod = charge.getPaymentMethod();
		this.paidAt = ConverterDateHelper.dateTimeToCalendar(charge.getPaidAt());
		this.createdAt = ConverterDateHelper.dateTimeToCalendar(charge.getCreatedAt());
		this.updatedAt = ConverterDateHelper.dateTimeToCalendar(charge.getUpdatedAt());
		this.lastTransaction.buildOrderMundLastTransactionResponse(charge.getLastTransaction());
		this.metadata = BuildMetadatasMundi.buidMetadadasPatternMundi(charge.getMetadata());
	}

}

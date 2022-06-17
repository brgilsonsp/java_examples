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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.utils.ConverterDateHelper;
import gr.betta.onofre.mundipagg.ordermundi.entities.LastTransactionResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundLastTransactionResponse implements Serializable {

	private static final long serialVersionUID = 7863994383637828233L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty("id_mund")
	@Column(nullable=true)
	private String idMund;
	
	@JsonProperty("transaction_type")
	@Column(nullable=true)
	private String transactionType;
	
	@JsonProperty("gateway_id")
	@Column(nullable=true)
	private String gatewayId;
	
	@JsonProperty("amount")
	@Column(nullable=true)
	private Integer amount;
	
	@JsonProperty("status")
	@Column(nullable=true)
	private String status;
	
	@JsonProperty("success")
	@Column(nullable=true)
	private Boolean success;
	
	@JsonProperty("installments")
	@Column(nullable=true)
	private Integer installments;
	
	@JsonProperty("statement_descriptor")
	@Column(nullable=true)
	private String statementDescriptor;
	
	@JsonProperty("acquirer_name")
	@Column(nullable=true)
	private String acquirerName;
	
	@JsonProperty("acquirer_affiliation_code")
	@Column(nullable=true)
	private String acquirerAffiliationCode;
	
	@JsonProperty("acquirer_tid")
	@Column(nullable=true)
	private String acquirerTid;
	
	@JsonProperty("acquirer_nsu")
	@Column(nullable=true)
	private String acquirerNsu;
	
	@JsonProperty("acquirer_auth_code")
	@Column(nullable=true)
	private String acquirerAuthCode;
	
	@JsonProperty("acquirer_message")
	@Column(nullable=true)
	private String acquirerMessage;
	
	@JsonProperty("acquirer_return_code")
	@Column(nullable=true)
	private String acquirerReturnCode;
	
	@JsonProperty("operation_type")
	@Column(nullable=true)
	private String operationType;
	
	@JsonProperty("card")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	private OrderMundCardResponse card = new OrderMundCardResponse();
	
	@JsonProperty("created_at")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Calendar createdAt;
	
	@JsonProperty("updated_at")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true)
	private Calendar updatedAt;
	
	@JsonProperty("gateway_response")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	private OrderMundGatewayResponse gatewayResponse = new OrderMundGatewayResponse();
	
	@JsonProperty("antifraud_response")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	private OrderMundAntifraudResponse antifraudResponse = new OrderMundAntifraudResponse();

	public void buildOrderMundLastTransactionResponse(LastTransactionResponse lastTransaction) {
		this.idMund = lastTransaction.getId();
		this.transactionType = lastTransaction.getTransactionType();
		this.gatewayId = lastTransaction.getGatewayId();
		this.amount = lastTransaction.getAmount();
		this.status = lastTransaction.getStatus();
		this.success = lastTransaction.getSuccess();
		this.installments = lastTransaction.getInstallments();
		this.statementDescriptor = lastTransaction.getStatementDescriptor();
		this.acquirerName = lastTransaction.getAcquirerName();
		this.acquirerAffiliationCode = lastTransaction.getAcquirerAffiliationCode();
		this.acquirerTid = lastTransaction.getAcquirerTid();
		this.acquirerNsu = lastTransaction.getAcquirerNsu();
		this.acquirerAuthCode = lastTransaction.getAcquirerAuthCode();
		this.acquirerMessage = lastTransaction.getAcquirerMessage();
		this.acquirerReturnCode = lastTransaction.getAcquirerReturnCode();
		this.operationType = lastTransaction.getOperationType();
		this.createdAt = ConverterDateHelper.dateTimeToCalendar(lastTransaction.getCreatedAt());
		this.updatedAt = ConverterDateHelper.dateTimeToCalendar(lastTransaction.getUpdatedAt());
		
		this.card.buildOrderMundCardResponse(lastTransaction.getCard());
		
		this.gatewayResponse.buildOrderMundGatewayResponse(lastTransaction.getGatewayResponse());
		
		this.antifraudResponse.buidlOrderMundAntifraudResponse(lastTransaction.getAntifraudResponse());
	}
}

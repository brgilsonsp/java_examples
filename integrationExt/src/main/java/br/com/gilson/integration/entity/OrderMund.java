package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.AntifraudRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.CustomerRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.ItemRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderResponse;
import gr.betta.onofre.mundipagg.ordermundi.entities.PaymentRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.ShippingRequest;

@Entity
public class OrderMund implements Serializable {

	private static final long serialVersionUID = 5381719448128163217L;
	
	public OrderMund() { }

	public OrderMund(String idVanrooy, OrderDetailMund orderDetail, List<PaymentMund> payments, TokenMund tokenMund) {
		this.idVanrooy = idVanrooy;
		this.orderDetail = orderDetail;
		this.payments = payments;
		this.tokenMund = tokenMund;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@NotBlank(message = "it's necessary")
	@Size(max = 52, message = "accept max 52 characters")
	@Column(nullable = false, unique = true)
	@JsonProperty(required = true, value = "id_vanrooy")
	private String idVanrooy;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonProperty(required = false, value = "order_status")
	private OrderStatus orderStatus = new OrderStatus();

	@JsonProperty(required = true, value = "order_detail")
	@Valid
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private OrderDetailMund orderDetail;

	@JsonProperty(required = true, value = "payments")
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	@Size(max = 1, min = 1, message = "accept only 1 element")
	private List<PaymentMund> payments;

	@JsonProperty(value = "order_mund_response")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private OrderMundResponse orderMundResponse;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JsonProperty(required = true, value = "token_mund")
	@Valid
	private TokenMund tokenMund;

	public Long getId() {
		return id;
	}

	public String getIdVanrooy() {
		return idVanrooy;
	}

	public TokenMund getTokenMund() {
		return tokenMund;
	}

	public OrderStatus getOrderStatus() {
		if (orderStatus != null) {
			orderStatus.setIdVanrooy(this.idVanrooy);
		}
		return orderStatus;
	}

	public OrderDetailMund getOrderDetail() {
		return orderDetail;
	}

	public List<PaymentMund> getPayments() {
		return payments;
	}


	/**
	 * Configure values of the status
	 */
	@JsonIgnore
	@Transient
	public void uraFinishedConference() {
		if (this.orderStatus == null) {
			this.orderStatus = new OrderStatus();
		}
		this.orderStatus.uraFinished();
		this.orderDetail = null;
		this.payments = null;
		this.tokenMund = null;
	}

	/**
	 * Configure values of the status
	 */
	@JsonIgnore
	@Transient
	public void uraStarterConference() {
		if (this.orderStatus == null) {
			this.orderStatus = new OrderStatus();
		}
		this.orderStatus.uraStarter();
	}

	/**
	 * Configure values of the status
	 */
	@JsonIgnore
	@Transient
	public void gatewayAnswered() {
		if (this.orderStatus == null) {
			this.orderStatus = new OrderStatus();
		}
		this.orderStatus.gatewayAnswered();
	}

	/**
	 * Checks if the Order is enabled to receive the card
	 * 
	 * @return true if the order can receive the card, otherwise return false
	 */
	@JsonIgnore
	@Transient
	public Boolean isValidForStartConference() {
		try {
			return this.orderStatus.getClientInTheURA() == false && this.orderStatus.getProcessedGateway() == false
					&& this.orderStatus.getProcessedURA() == false && this.orderStatus.getId() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks if the Order is enabled to receive the card
	 * 
	 * @return true if the order can receive the card, otherwise return false
	 */
	@JsonIgnore
	@Transient
	public Boolean isValidToProcessTransactionInGateway() {
		try {
			return this.orderStatus.getClientInTheURA() && this.orderStatus.getProcessedURA() == false
					&& this.orderStatus.getId() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks if the Order is been in the conference receiving the card
	 * 
	 * @return true if the order is been receiving the card, otherwise return false
	 */
	@JsonIgnore
	@Transient
	public Boolean isValidForFinishConference() {
		try {
			return this.orderStatus.getClientInTheURA() == true && this.orderStatus.getId() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	@JsonIgnore
	@Transient
	public Boolean isEmpty() {
		return this.idVanrooy == null || this.idVanrooy.isEmpty();
	}

	/**
	 * Update the entity managed with the new values
	 * 
	 * @param order
	 */
	@JsonIgnore
	@Transient
	public void updateOrderMundi(OrderMund order) {
		this.initalValues();
		this.orderDetail = order.getOrderDetail();
		this.payments = order.getPayments();
		this.tokenMund = order.tokenMund;
	}

	@JsonIgnore
	@Transient
	private void initalValues() {
		this.orderStatus = new OrderStatus();
		this.orderMundResponse = null;
	}

	@JsonIgnore
	@Transient
	public OrderRequest buildOrderPatterMund() {

		String codeRequest = this.idVanrooy;
		CustomerRequest customerRequest = null;
		List<PaymentRequest> paymentsRequest = null;
		Boolean antifraudEnabledRequest = null;
		ShippingRequest shippingRequest = null;
		Map<String, String> metadataRequest = null;
		String currencyRequest = null;
		List<ItemRequest> itemsRequest = this.buidListItemsPatternMundi();
		AntifraudRequest antifraudRequest = null;

		if (this.orderDetail != null) {
			customerRequest = this.orderDetail.hasCustomer() ? this.orderDetail.getCustomer().buildCustomerPatterMundi()
					: null;

			paymentsRequest = this.buildListPaymentPatterMund(this.orderDetail.getCurrency());
			shippingRequest = this.orderDetail.hasShipping() ? this.orderDetail.getShipping().buidShippingPatternMundi()
					: null;
			metadataRequest = this.orderDetail.getMetadata();
			antifraudEnabledRequest = this.orderDetail.getAntifraudEnabled();
			currencyRequest = this.orderDetail.getCurrency();
			antifraudRequest = this.orderDetail.hasAntifraud()
					? this.orderDetail.getAntifraud().builAntiFraudPatterMund()
					: null;
		}

		return new OrderRequest(itemsRequest, customerRequest, paymentsRequest, codeRequest, shippingRequest,
				metadataRequest, antifraudEnabledRequest, currencyRequest, antifraudRequest);
	}

	@JsonIgnore
	@Transient
	private List<ItemRequest> buidListItemsPatternMundi() {
		List<ItemRequest> listItemsPatterMundi = new ArrayList<>();

		if (this.orderDetail != null && this.orderDetail.hasItems()) {
			this.orderDetail.getItems().forEach(item -> {
				ItemRequest itemPatterMundi = item.buidItemPatternMundi();
				listItemsPatterMundi.add(itemPatterMundi);
			});
		}

		return listItemsPatterMundi;
	}

	@JsonIgnore
	@Transient
	private List<PaymentRequest> buildListPaymentPatterMund(String currency) {
		List<PaymentRequest> paymentPatterMundi = new ArrayList<>();

		if (this.payments != null && this.payments.size() > 0) {
			this.payments.forEach(item -> {
				PaymentRequest paymentsPatterMund = item.buildPaymentPatterMundi(currency);
				paymentPatterMundi.add(paymentsPatterMund);
			});
		}

		return paymentPatterMundi;
	}

	@JsonIgnore
	@Transient
	public boolean hasErrorNotNoted() {

		return this.orderDetail == null || this.payments == null || this.payments.size() == 0
				|| this.orderDetail.hasErrorNotNoted() || this.tokenMund == null;
	}

	@JsonIgnore
	@Transient
	public String getErrorValidationNotNoted() {
		String errorValidation = "";

		if (this.orderDetail == null)
			errorValidation += "{orderDetail it's necessary}, ";

		if (this.payments == null)
			errorValidation += "{payments it's necessary}";

		if (this.orderDetail.getAntifraudEnabled() && this.orderDetail.getAntifraud() == null)
			errorValidation += "{antifraud it's necessary when antifraud_enabled equals true}";

		if (this.tokenMund == null)
			errorValidation += "{token_mund it's necessary}";

		return errorValidation;
	}

	@JsonIgnore
	@Transient
	public void buildResponseMundi(ResponseApi<OrderResponse> response) {

		this.orderMundResponse = new OrderMundResponse();

		if (response.getData() != null) {
			this.gatewayAnswered();

			this.orderMundResponse.buildOrderMundResponse(response.getData());
		} else {
			this.orderMundResponse.buildOrderMundFatalError(response.getMessage(), this.idVanrooy);
		}
	}

	@JsonIgnore
	@Transient
	public OrderMundResponse getOrderMundResponse() {
		if (this.orderMundResponse == null)
			this.orderMundResponse = new OrderMundResponse();

		this.orderMundResponse.addOrderStatus(this.getOrderStatus());

		this.orderMundResponse.setIdVanrooy(this.idVanrooy);
		return this.orderMundResponse;
	}

}
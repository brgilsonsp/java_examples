package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.utils.BuildMetadatasMundi;
import br.com.gilson.integration.utils.ConverterDateHelper;
import gr.betta.onofre.mundipagg.ordermundi.entities.ChargeResponse;
import gr.betta.onofre.mundipagg.ordermundi.entities.ItemResponse;
import gr.betta.onofre.mundipagg.ordermundi.entities.OrderResponse;

@Entity
public class OrderMundResponse implements Serializable {

	private static final long serialVersionUID = 1880765421311453903L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("id_mund")
	@Column(nullable = true)
	private String idMund;

	@JsonProperty("id_vanrooy")
	@Column(nullable = true)
	private String idVanrooy;

	@JsonProperty("message_error_transaction")
	@Column(nullable = true)
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String messageErrorTransaction;

	@JsonProperty("amount")
	@Column(nullable = true)
	private Long amount;

	@JsonProperty("currency")
	@Column(nullable = true)
	private String currency;

	@JsonProperty("closed")
	@Column(nullable = true)
	private Boolean closed;

	@JsonProperty("items")
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderMundItemResponse> items;

	@JsonProperty("shipping")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	private OrderMundShippingResponse shipping = new OrderMundShippingResponse();

	@JsonProperty("status")
	@Column(nullable = true)
	private String status;

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

	@JsonProperty("closed_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Calendar closedAt;

	@JsonProperty("charges")
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderMundChargeResponse> charges;

	@Transient
	@JsonProperty(required = false, value = "order_status")
	private OrderStatus orderStatus = new OrderStatus();

	@JsonProperty(required = false, value = "metadata")
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(length = 150)
	@Column(columnDefinition = "text", nullable = true)
	private Map<String, String> metadata;

	public Long getId() {
		return id;
	}
	public String getIdMund() {
		return idMund;
	}
	public String getMessageErrorTransaction() {
		return messageErrorTransaction;
	}
	public Long getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public Boolean getClosed() {
		return closed;
	}
	public List<OrderMundItemResponse> getItems() {
		return items;
	}
	public OrderMundShippingResponse getShipping() {
		return shipping;
	}
	public String getStatus() {
		return status;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public Calendar getClosedAt() {
		return closedAt;
	}
	public List<OrderMundChargeResponse> getCharges() {
		return charges;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@JsonIgnore
	public void buildOrderMundResponse(OrderResponse orderResponse) {

		this.idMund = orderResponse.getId();
		this.idVanrooy = orderResponse.getCode();
		this.amount = orderResponse.getAmount();
		this.currency = orderResponse.getCurrency();
		this.closed = orderResponse.isClosed();
		this.status = orderResponse.getStatus();
		this.createdAt = ConverterDateHelper.dateTimeToCalendar(orderResponse.getCreatedAt());
		this.updatedAt = ConverterDateHelper.dateTimeToCalendar(orderResponse.getUpdatedAt());
		this.closedAt = ConverterDateHelper.dateTimeToCalendar(orderResponse.getClosedAt());

		this.buildItemsMundResponse(orderResponse.getItems());

		this.shipping.buildOrderMundShippingResponse(orderResponse.getShipping());

		this.buildChargesMundResponse(orderResponse.getCharges());

		this.metadata = BuildMetadatasMundi.buidMetadadasPatternMundi(orderResponse.getMetadata());

		if (orderResponse.hasChagers())
			this.messageErrorTransaction = null;
	}

	private void buildChargesMundResponse(List<ChargeResponse> chargesResponse) {

		if (chargesResponse != null) {
			this.charges = new ArrayList<>();

			if(chargesResponse.size() > 0) {
				chargesResponse.forEach(item -> {
					OrderMundChargeResponse chargeResponse = new OrderMundChargeResponse();
					chargeResponse.buildOrderMundChargeResponse(item);
					this.charges.add(chargeResponse);
					
				});
			}
		}
	}

	private void buildItemsMundResponse(List<ItemResponse> itemsResponse) {
		if (itemsResponse != null) {

			this.items = new ArrayList<>();

			if(itemsResponse.size() > 0) {
				itemsResponse.forEach(item -> {
					OrderMundItemResponse itemOrderResponse = new OrderMundItemResponse();
					itemOrderResponse.buildItemMundResponse(item);
					this.items.add(itemOrderResponse);
					
				});
			}
		}
	}

	public void buildOrderMundFatalError(String message, String idVanrooy) {
		this.messageErrorTransaction = message;
		this.idVanrooy = idVanrooy;

	}

	public void addOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIdVanrooy() {
		return idVanrooy;
	}

	public void setIdVanrooy(String idVanrooy) {
		this.idVanrooy = idVanrooy;
	}

}

package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OrderDetailMund implements Serializable {

	@Transient
	private static final long serialVersionUID = -2516215664367121037L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonProperty(required=true, value="customer")
	@NotNull(message="it's necessary")
	@Valid
	private CustomerMund customer;

	@NotNull(message="it's necessary")
	@JsonProperty(required=true, value="items")
	@OneToMany(cascade=CascadeType.ALL)
	@Valid
	private List<ItemMund> items;

	@JsonProperty(required=false, value="shipping")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Valid
	private ShippingMund shipping;

	@Column(nullable=true)
	@JsonProperty(required=false, value="closed")
	private Boolean closed;

	@JsonProperty(required=false, value="metadata")
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(length=150)
	@Column(columnDefinition="text", nullable=true)
	private Map<String, String> metadata;

	@Column(nullable=false)
	@JsonProperty(required=true, value="antifraud_enabled")
	@NotNull(message="it's necessary")
	private boolean antifraudEnabled;
	
	@JsonProperty(required=false, value="antifraud")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Valid
	private AntifraudMund antifraud;

	@NotBlank(message="it's necessary")
	@Size(max=3, message="accept max 3 characters")
	@Column(nullable=false)
	@JsonProperty(required=true, value="currency")
	private String currency;

	public OrderDetailMund() {
	}
	
	public OrderDetailMund(CustomerMund customer, List<ItemMund> items, String currency) {
		this.customer = customer;
		this.items = items;
		this.currency = currency;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public CustomerMund getCustomer() {
		return customer;
	}
	public List<ItemMund> getItems() {
		return items;
	}
	public ShippingMund getShipping() {
		return shipping;
	}
	public Boolean getClosed() {
		return closed;
	}
	public Map<String, String> getMetadata() {
		return metadata;
	}
	public boolean getAntifraudEnabled() {
		return antifraudEnabled;
	}
	public AntifraudMund getAntifraud() {
		return antifraud;
	}
	public String getCurrency() {
		return currency;
	}

	@JsonIgnore
	@Transient
	public boolean hasShipping() {
		try {
			return this.shipping != null;
		} catch (Exception e) {
			return false;
		}
	}

	@JsonIgnore
	@Transient
	public Boolean hasErrorNotNoted() {
		return this.antifraudEnabled && this.antifraud == null;
	}

	public boolean hasCustomer() {
		return this.customer != null;
	}

	public boolean hasAntifraud() {
		return this.antifraud != null;
	}

	public boolean hasItems() {
		return this.items != null && this.items.size() > 0;
	}

}

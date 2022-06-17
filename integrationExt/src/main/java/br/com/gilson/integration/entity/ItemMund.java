package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.mundippagEnum.StatusItemMundiEnum;
import gr.betta.onofre.mundipagg.ordermundi.entities.ItemRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class ItemMund implements Serializable {

	private static final long serialVersionUID = -6410494678303564395L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty(required=true, value="amount")
	@Positive(message="only posivite number")
	@NotNull(message="it's necessary")
	@Column(nullable=false)
	private int amount;
	
	@JsonProperty(required=true, value="description")
	@NotBlank(message="it's necessary")
	@Column(nullable=false)
	@Size(max=255, message="accept max 255 caracters")
	private String description;
	
	@JsonProperty(required=true, value="quantity")
	@Positive(message="only posivite number")
	@NotNull(message="it's necessary")
	@Column(nullable=false)
	private int quantity;
	
	@JsonProperty(required=false, value="code")
	@Column(nullable=true)
	@Size(max=52, message="accept max 52 caracters")
	private String code;
	
	@JsonProperty(required=false, value="category")
	@Column(nullable=true)
	@Size(max=64, message="accept max 64 caracters")
	private String category;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(required=false, value="status")
	@Column(nullable=true)
	private StatusItemMundiEnum status = null;
	
	public ItemMund() {
	}
	public ItemMund(int amount, String description, int quantity) {
		this.amount = amount;
		this.description = description;
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCode() {
		return code;
	}

	public String getCategory() {
		return category;
	}

	public StatusItemMundiEnum getStatus() {
		return status;
	}

	@JsonIgnore
	@Transient
	public ItemRequest buidItemPatternMundi() {

		int amount = this.amount;
		String category = this.category;
		String code = this.code;
		String description = this.description;
		int quantity = this.quantity;
		
		return new ItemRequest(amount, description, quantity, category, code);
	}
	
}

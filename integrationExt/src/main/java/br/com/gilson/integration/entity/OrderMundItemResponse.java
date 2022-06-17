package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.utils.ConverterDateHelper;
import gr.betta.onofre.mundipagg.ordermundi.entities.ItemResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundItemResponse implements Serializable {

	private static final long serialVersionUID = 379634049736916888L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty("id_mund")
	@Column(nullable=true)
	private String idMund;
	
	@JsonProperty("description")
	@Column(nullable=true)
	private String description;
	
	@JsonProperty("amount")
	@Column(nullable=true)
    private Integer amount;
	
	@JsonProperty("quantity")
	@Column(nullable=true)
    private Integer quantity;
	
	@JsonProperty("status")
	@Column(nullable=true)
    private String status;
	
	@JsonProperty("category")
	@Column(nullable=true)
    private String category;
    
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

	public void buildItemMundResponse(ItemResponse item) {
		this.idMund = item.getId();
		this.description = item.getDescription();
		this.amount = item.getAmount();
		this.quantity = item.getQuantity();
		this.status = item.getStatus();
		this.category = item.getCategory();
		this.createdAt = ConverterDateHelper.dateTimeToCalendar(item.getCreatedAt());
		this.updatedAt = ConverterDateHelper.dateTimeToCalendar(item.getUpdatedAt());
	}

}

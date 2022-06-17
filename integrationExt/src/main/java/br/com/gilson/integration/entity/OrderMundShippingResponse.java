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
import gr.betta.onofre.mundipagg.ordermundi.entities.ShippingResponse;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Entity
public class OrderMundShippingResponse implements Serializable {

	private static final long serialVersionUID = 3187892809760968654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty("max_delivery_date")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Calendar maxDeliveryDate;

	public Calendar getMaxDeliveryDate() {
		return maxDeliveryDate;
	}

	public void buildOrderMundShippingResponse(ShippingResponse shipping) {
		this.maxDeliveryDate = ConverterDateHelper.dateTimeToCalendar(shipping.getMaxDeliveryDate());
	}

}

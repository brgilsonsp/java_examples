package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.GatewayResponse;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class OrderMundGatewayResponse implements Serializable {

	private static final long serialVersionUID = 4476475685386625925L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty("code")
	@Column(nullable=true)
	private String code;
	
	@JsonProperty("errors")
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<OrderMundGatewayErrorResponse> orderGatewayErrors;

	public void buildOrderMundGatewayResponse(GatewayResponse gatewayResponse) {
		this.code = gatewayResponse.getCode();
		
		if(gatewayResponse.getOrderGatewayErrors() != null) {			
			this.orderGatewayErrors = new ArrayList<>();
			
			gatewayResponse.getOrderGatewayErrors().forEach(item -> {
				OrderMundGatewayErrorResponse gatewayError = new OrderMundGatewayErrorResponse();
				gatewayError.buildOrderMundoGatewayErrorResponse(item);
				this.orderGatewayErrors.add(gatewayError);
				
			});
		}
		
	}

}

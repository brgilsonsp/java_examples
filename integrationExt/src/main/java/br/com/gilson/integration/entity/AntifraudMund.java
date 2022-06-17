package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.AntifraudRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.ClearSaleRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class AntifraudMund implements Serializable {

	private static final long serialVersionUID = -8932852224677911171L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty(required=true, value="type")
	@NotBlank(message="it's necessary")
	@Column(nullable=false)
	private String type;
	
	@JsonProperty("clearsale")
	@NotNull(message="it's necessary")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Valid
	private ClearsaleMund clearsale;

	public String getType() {
		return type;
	}
	public ClearsaleMund getClearsale() {
		return clearsale;
	}
	
	@JsonIgnore
	@Transient
	public AntifraudRequest builAntiFraudPatterMund() {
		
		String type = this.type;
		ClearSaleRequest clearsale = this.clearsale != null ? this.clearsale.buildClearsalePatterMund() : null;
		
		return new AntifraudRequest(type, clearsale);
	}

}

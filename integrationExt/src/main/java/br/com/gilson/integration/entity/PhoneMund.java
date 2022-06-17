package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.PhoneRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.PhonesRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class PhoneMund implements Serializable{

	private static final long serialVersionUID = 8626509588608891893L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@JsonProperty(required=false, value="home_phone")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Valid
	private PhoneMundDetail homePhone;

	@JsonProperty(required=false, value="mobile_phone")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Valid
	private PhoneMundDetail mobilePhone;

	public PhoneMundDetail getHomePhone() {
		return homePhone;
	}

	public PhoneMundDetail getMobilePhone() {
		return mobilePhone;
	}

	@JsonIgnore
	@Transient
	public PhonesRequest buildPhonePatterMundi() {

		PhoneRequest homePhone = this.homePhone != null ? this.homePhone.buidPhoneDetailPatterMundi() : null;
		PhoneRequest mobilePhone = this.mobilePhone != null ? this.mobilePhone.buidPhoneDetailPatterMundi() : null;
		
		return new PhonesRequest(homePhone, mobilePhone);
	}
	
}

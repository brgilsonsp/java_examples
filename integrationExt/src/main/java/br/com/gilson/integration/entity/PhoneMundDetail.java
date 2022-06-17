package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.PhoneRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class PhoneMundDetail implements Serializable{

	private static final long serialVersionUID = 8802430626768447085L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@NotBlank(message="it's necessary")
	@Digits(message="accept only digit", integer=3, fraction=0)
	@Column(nullable=false)
	@JsonProperty(required=true, value="country_code")
	private String countryCode;
	
	@NotBlank(message="it's necessary")
	@Digits(message="accept only digit", integer=3, fraction=0)
	@Column(nullable=false)
	@JsonProperty(required=true, value="area_code")
	private String areaCode;
	
	@NotBlank(message="it's necessary")
	@Digits(message="accept only digit", integer=10, fraction=0)
	@Column(nullable=false)
	@JsonProperty(required=true, value="number")
	private String number;

	public String getCountryCode() {
		return countryCode;
	}

	public String getNumber() {
		return number;
	}

	public String getAreaCode() {
		return areaCode;
	}

	@JsonIgnore
	@Transient
	public PhoneRequest buidPhoneDetailPatterMundi() {

		String countryCode = this.countryCode;
		String number = this.number;
		String areaCode = this.areaCode;
		
		return new PhoneRequest(countryCode, number, areaCode);
	}
	
}

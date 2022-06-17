package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.gilson.integration.mundippagEnum.GenderMundiEnum;
import br.com.gilson.integration.mundippagEnum.TypeCustomerMundiEnum;
import gr.betta.onofre.mundipagg.ordermundi.entities.AddressRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.CustomerRequest;
import gr.betta.onofre.mundipagg.ordermundi.entities.PhonesRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class CustomerMund implements Serializable{

	private static final long serialVersionUID = 5562807903430376706L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	
	@NotBlank(message="it's necessary")
	@Size(max=64, message="accept max 64 caracters")
	@Column(nullable=false)
	@JsonProperty(required=true, value="name")
	private String name;
	
	@Column(nullable=true)
	@JsonProperty(required=false, value="email")
	@Size(max=64, message="accept max 64 caracters")
	private String email;
	
	@JsonProperty(required=false, value="phone")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Valid
	private PhoneMund phone;
	
	@Column(nullable=true)
	@JsonProperty(required=false, value="document")
	@Size(max=16, message="accept max 16 caracters")
	private String document;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=true)
	@JsonProperty(required=false, value="type")
	private TypeCustomerMundiEnum type;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=true)
	@JsonProperty(required=false, value="gender")
	private GenderMundiEnum gender;
	
	@JsonProperty(required=false, value="address")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private AddressMund address;
	
	@Column(nullable=true)
	@JsonProperty(required=false, value="code")
	private String code;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(nullable=true)
	@JsonProperty(required=false, value="birthdate")
 	private Calendar birthdate;
	
	@JsonProperty(required=false, value="metadata")
	@ElementCollection(fetch=FetchType.EAGER)
	@MapKeyColumn(length=150)
	@Column(columnDefinition="text", nullable=true)
	private Map<String, String> metadata = null;

	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public PhoneMund getPhone() {
		return phone;
	}
	public String getDocument() {
		return document;
	}
	public TypeCustomerMundiEnum getType() {
		return type;
	}
	public GenderMundiEnum getGender() {
		return gender;
	}
	public AddressMund getAddress() {
		return address;
	}
	public String getCode() {
		return code;
	}
	public Calendar getBirthdate() {
		return birthdate;
	}
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@JsonIgnore
	@Transient
	public CustomerRequest buildCustomerPatterMundi() {
		String name = this.name;
		String email = this.email;
		String document = this.document;
		String type = this.type != null ? this.type.getValue() : null;
		Map<String, String> metadata = this.metadata;
		String code = this.code;
		String gender = this.gender != null ? this.gender.getValue() : null;
		
		AddressRequest address = this.address != null ? this.address.buildAddressPatterMundi() : null;
		PhonesRequest phones = this.phone != null ? this.phone.buildPhonePatterMundi() : null; 
		
		return new CustomerRequest(name, email, document, type, address, metadata, phones, code, gender);
	}
	
}

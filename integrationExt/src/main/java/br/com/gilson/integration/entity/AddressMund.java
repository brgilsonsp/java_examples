package br.com.gilson.integration.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import gr.betta.onofre.mundipagg.ordermundi.entities.AddressRequest;

@SuppressWarnings({"PMD.UnusedPrivateField"})
@Entity
public class AddressMund implements Serializable {

	private static final long serialVersionUID = -5272961752819459274L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@NotBlank(message = "it's necessary")
	@Column(nullable = false)
	@JsonProperty(required = true, value = "line_1")
	private String line1;

	@Column(nullable = true)
	@JsonProperty(required = false, value = "line_2")
	private String line2;

	@NotBlank(message = "it's necessary")
	@Size(max = 10, message = "accept max 10 characters")
	@Column(nullable = false)
	@JsonProperty(required = true, value = "zip_code")
	private String zipCode;

	@NotBlank(message = "it's necessary")
	@Size(max = 50, message = "accept max 50 characters")
	@Column(nullable = false)
	@JsonProperty(required = true, value = "city")
	private String city;

	@NotBlank(message = "it's necessary")
	@Size(max = 6, message = "accept max 6 characters")
	@Column(nullable = false)
	@JsonProperty(required = true, value = "state")
	private String state;

	@NotBlank(message = "it's necessary")
	@Size(max = 2, message = "accept max 2 characters")
	@Column(nullable = false)
	@JsonProperty(required = true, value = "country")
	private String country;

	@JsonProperty(required = false, value = "metadata")
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(length = 150)
	@Column(columnDefinition = "text", nullable = true)
	private Map<String, String> metadata = null;

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	@JsonIgnore
	@Transient
	public AddressRequest buildAddressPatterMundi() {

		String street = this.getValueLine1ByPosition(1);
		String number = this.getValueLine1ByPosition(0);
		String zipCode = this.zipCode;
		String neighborhood = this.getValueLine1ByPosition(2);
		String city = this.city;
		String state = this.state;
		String country = this.country;
		String complement = this.line2;
		Map<String, String> metadata = this.metadata;
		String line1 = this.line1;
		String line2 = this.line2;

		return new AddressRequest(street, number, zipCode, neighborhood, city, state, country, complement, metadata,
				line1, line2);
	}

	@JsonIgnore
	@Transient
	private String getValueLine1ByPosition(int position) {
		
		try {
			String[] datasLine1 = null;

			if (this.line1 != null && !this.line1.isEmpty()) {
				datasLine1 = this.line1.split(",");
			}

			if (datasLine1 != null && datasLine1.length >= position) {
				return datasLine1[position];
			} else {
				return "";
			}
			
		} catch (Exception e) {
			return "";
		}
	}

}

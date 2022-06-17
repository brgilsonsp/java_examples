package br.com.gilson.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({ "PMD.UnusedPrivateField" })
@Entity
public class TokenMund implements Serializable {

	private static final long serialVersionUID = -7621371672275962608L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@JsonProperty(required = true, value = "token")
	@NotBlank(message = "it's necessary")
	@Column(nullable = false)
	private String token;

	public String getToken() {
		return token;
	}

}

package br.com.d2st.exportacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class StatusResponse implements Serializable  {
	
	private static final long serialVersionUID = -4388455838613704622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private String descr;
	
	private String dataResponse;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MessageNumber messageNumber;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private MessageKind messageKind;
	
	private String sbeln;
	
	@NotEmpty
	@ManyToOne
	private Client client;	
	
	@OneToMany(cascade= {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="statusResponse", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<ErrorResponse> errorsResponse = new ArrayList<>();
	
	@Deprecated
	public StatusResponse() { }

	public StatusResponse(String code, String descr, String dataResponse, MessageNumber messageNumber,
			MessageKind messageKind, String sbeln, Client client, List<ErrorResponse> errorsResponse) {
		this.code = code;
		this.descr = descr;
		this.dataResponse = dataResponse;
		this.messageNumber = messageNumber;
		this.messageKind = messageKind;
		this.sbeln = sbeln;
		this.client = client;
		this.errorsResponse = errorsResponse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getDataResponse() {
		return dataResponse;
	}

	public void setDataResponse(String dataResponse) {
		this.dataResponse = dataResponse;
	}

	public MessageNumber getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(MessageNumber messageNumber) {
		this.messageNumber = messageNumber;
	}

	public MessageKind getMessageKind() {
		return messageKind;
	}

	public void setMessageKind(MessageKind messageKind) {
		this.messageKind = messageKind;
	}

	public String getSbeln() {
		return sbeln;
	}

	public void setSbeln(String sbeln) {
		this.sbeln = sbeln;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ErrorResponse> getErrorsResponse() {
		return errorsResponse;
	}

	public void setErrorsResponse(List<ErrorResponse> errorsResponse) {
		this.errorsResponse = errorsResponse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusResponse other = (StatusResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatusResponse [id=" + id + ", sbeln=" + sbeln + ", client=" + client.getId() + "]";
	}
	
	
}

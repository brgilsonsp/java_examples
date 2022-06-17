package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ErrorResponse implements Serializable  {

	private static final long serialVersionUID = 4548003992453917744L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private String descr;
	
	@NotEmpty
	@ManyToOne
	private StatusResponse statusResponse;
	
	@Deprecated
	public ErrorResponse() { }
	
	public ErrorResponse(String code, String descr, StatusResponse statusResponse) {
		this.code = code;
		this.descr = descr;
		this.statusResponse = statusResponse;
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

	public StatusResponse getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
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
		ErrorResponse other = (ErrorResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorResponse [id=" + id + ", code=" + code + ", statusResponse=" + statusResponse.getId() + "]";
	}
	
	
	
}

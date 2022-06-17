package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames= {"messageNumber","messageKind"}))
public class RequestEdx implements Serializable{

	private static final long serialVersionUID = 2735216481371985530L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String edx;
	
	@NotEmpty
	private String type;
	
	@NotEmpty
	private String acao;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Str str;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private MessageNumber messageNumber;
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	private MessageKind messageKind;
	
	@Deprecated
	public RequestEdx() { }
	
	public RequestEdx(String edx, String type, String acao, MessageNumber messageNumber,
			MessageKind messageKind) {
		this.edx = edx;
		this.type = type;
		this.acao = acao;
		this.messageNumber = messageNumber;
		this.messageKind = messageKind;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdx() {
		return edx;
	}

	public void setEdx(String edx) {
		this.edx = edx;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Str getStr() {
		return str;
	}

	public void setStr(Str str) {
		this.str = str;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result + ((edx == null) ? 0 : edx.hashCode());
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
		RequestEdx other = (RequestEdx) obj;
		if (acao == null) {
			if (other.acao != null)
				return false;
		} else if (!acao.equals(other.acao))
			return false;
		if (edx == null) {
			if (other.edx != null)
				return false;
		} else if (!edx.equals(other.edx))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", edx=" + edx + ", acao=" + acao + "]";
	}

	
}

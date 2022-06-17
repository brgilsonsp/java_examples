package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Txpns implements Serializable{

	private static final long serialVersionUID = 4084289730039568115L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	private String kschl;

	private String netwr;
	
	@NotEmpty
	@ManyToOne
	private Tpck tpck;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKschl() {
		return kschl;
	}

	public void setKschl(String kschl) {
		this.kschl = kschl;
	}

	public String getNetwr() {
		return netwr;
	}

	public void setNetwr(String netwr) {
		this.netwr = netwr;
	}

	public Tpck getTpck() {
		return tpck;
	}

	public void setTpck(Tpck tpck) {
		this.tpck = tpck;
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
		Txpns other = (Txpns) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Txpns [id=" + id + ", tpck=" + tpck.getId() + "]";
	}

}

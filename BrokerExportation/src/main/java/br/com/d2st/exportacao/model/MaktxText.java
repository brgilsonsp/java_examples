package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MaktxText implements Serializable {
	
	private static final long serialVersionUID = 3949571991924411733L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteshpn tgteshpn;
	
	private String type;

	private String text;
	
	@Deprecated
	public MaktxText() { }

	public MaktxText(Tgteshpn tgteshpn, String type) {
		this.tgteshpn = tgteshpn;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tgteshpn getTgteshpn() {
		return tgteshpn;
	}

	public void setTgteshpn(Tgteshpn tgteshpn) {
		this.tgteshpn = tgteshpn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
		MaktxText other = (MaktxText) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MaktxText [id=" + id + ", tgteshpn=" + tgteshpn.getId() + ", type=" + type + "]";
	}
	
	

}

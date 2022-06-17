package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class DuetribTabTgteduep implements Serializable{

	private static final long serialVersionUID = 1578265864369751855L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteduep tgteduep;
	
	private String type;

    private String dueid;

    private String dueposnr;

    private String dueatrib;

    private String description;

    @Deprecated
	public DuetribTabTgteduep() { }

	public DuetribTabTgteduep(Long id, Tgteduep tgteduep, String type) {
		super();
		this.id = id;
		this.tgteduep = tgteduep;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tgteduep getTgteduep() {
		return tgteduep;
	}

	public void setTgteduep(Tgteduep tgteduep) {
		this.tgteduep = tgteduep;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDueid() {
		return dueid;
	}

	public void setDueid(String dueid) {
		this.dueid = dueid;
	}

	public String getDueposnr() {
		return dueposnr;
	}

	public void setDueposnr(String dueposnr) {
		this.dueposnr = dueposnr;
	}

	public String getDueatrib() {
		return dueatrib;
	}

	public void setDueatrib(String dueatrib) {
		this.dueatrib = dueatrib;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		DuetribTabTgteduep other = (DuetribTabTgteduep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DuetribTabTgteduep [id=" + id + ", tgteduep=" + tgteduep.getId() + ", type=" + type + "]";
	}
	
	
}

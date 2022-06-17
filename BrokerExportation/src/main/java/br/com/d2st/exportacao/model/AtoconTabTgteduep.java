package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class AtoconTabTgteduep implements Serializable{

	private static final long serialVersionUID = -6428050818519641103L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteduep tgteduep;
	
	private String type;

    private String dueid;

    private String dueposnr;

    private String atocon;

    private String atoconitm;

    private String vlrcomcob;

    private String vlrsemcob;

    private String steuc;

    private String cnpj_benef;

    @Deprecated
	public AtoconTabTgteduep() { }

	public AtoconTabTgteduep(Tgteduep tgteduep, String type) {
		super();
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

	public String getAtocon() {
		return atocon;
	}

	public void setAtocon(String atocon) {
		this.atocon = atocon;
	}

	public String getAtoconitm() {
		return atoconitm;
	}

	public void setAtoconitm(String atoconitm) {
		this.atoconitm = atoconitm;
	}

	public String getVlrcomcob() {
		return vlrcomcob;
	}

	public void setVlrcomcob(String vlrcomcob) {
		this.vlrcomcob = vlrcomcob;
	}

	public String getVlrsemcob() {
		return vlrsemcob;
	}

	public void setVlrsemcob(String vlrsemcob) {
		this.vlrsemcob = vlrsemcob;
	}

	public String getSteuc() {
		return steuc;
	}

	public void setSteuc(String steuc) {
		this.steuc = steuc;
	}

	public String getCnpj_benef() {
		return cnpj_benef;
	}

	public void setCnpj_benef(String cnpj_benef) {
		this.cnpj_benef = cnpj_benef;
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
		AtoconTabTgteduep other = (AtoconTabTgteduep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtoconTabTgteduep [id=" + id + ", tgteduep=" + tgteduep.getId() + ", type=" + type + "]";
	}
    
    
}

package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class NferefTabTgteduep implements Serializable{

	private static final long serialVersionUID = -6091438364265879884L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteduep tgteduep;
	
	private String type;

    private String dueid;

    private String dueposnr;

    private String docnum;

    private String itmnum;
    
    private String nfenum;

    private String series;

    private String parid;

    private String menge;

    @Deprecated
	public NferefTabTgteduep() { }

	public NferefTabTgteduep(Tgteduep tgteduep, String type) {
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

	public String getDocnum() {
		return docnum;
	}

	public void setDocnum(String docnum) {
		this.docnum = docnum;
	}

	public String getItmnum() {
		return itmnum;
	}

	public void setItmnum(String itmnum) {
		this.itmnum = itmnum;
	}

	public String getNfenum() {
		return nfenum;
	}

	public void setNfenum(String nfenum) {
		this.nfenum = nfenum;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getParid() {
		return parid;
	}

	public void setParid(String parid) {
		this.parid = parid;
	}

	public String getMenge() {
		return menge;
	}

	public void setMenge(String menge) {
		this.menge = menge;
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
		NferefTabTgteduep other = (NferefTabTgteduep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NferefTabTgteduep [id=" + id + ", tgteduep=" + tgteduep.getId() + ", type=" + type + "]";
	}
    
    

}

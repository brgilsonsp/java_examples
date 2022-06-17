package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tgteres implements Serializable {

	private static final long serialVersionUID = 1820060860128433993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteshkn tgteshkn;

	private String type;

    @Transient
	private String sbeln;

    private String dsenum;

    private String renum;

    private String andat;

    private String redat;

    private String avbdt;

    private String canal;

    private String ddenum;
    
    private String ddedt;

    private String ddesq;

    private String reanx;

    private String dsesq;

    private String docfat;

    private String xblnr;

    private String inco1;

    private String waers;

    private String ddeadt;
    
    @Deprecated
	public Tgteres() { }

	public Tgteres(Tgteshkn tgteshkn, String type, String sbeln) {
		super();
		this.tgteshkn = tgteshkn;
		this.type = type;
		this.sbeln = sbeln;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tgteshkn getTgteshkn() {
		return tgteshkn;
	}

	public void setTgteshkn(Tgteshkn tgteshkn) {
		this.tgteshkn = tgteshkn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSbeln() {
		return sbeln;
	}

	public void setSbeln(String sbeln) {
		this.sbeln = sbeln;
	}

	public String getDsenum() {
		return dsenum;
	}

	public void setDsenum(String dsenum) {
		this.dsenum = dsenum;
	}

	public String getRenum() {
		return renum;
	}

	public void setRenum(String renum) {
		this.renum = renum;
	}

	public String getAndat() {
		return andat;
	}

	public void setAndat(String andat) {
		this.andat = andat;
	}

	public String getRedat() {
		return redat;
	}

	public void setRedat(String redat) {
		this.redat = redat;
	}

	public String getAvbdt() {
		return avbdt;
	}

	public void setAvbdt(String avbdt) {
		this.avbdt = avbdt;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getDdenum() {
		return ddenum;
	}

	public void setDdenum(String ddenum) {
		this.ddenum = ddenum;
	}

	public String getDdedt() {
		return ddedt;
	}

	public void setDdedt(String ddedt) {
		this.ddedt = ddedt;
	}

	public String getDdesq() {
		return ddesq;
	}

	public void setDdesq(String ddesq) {
		this.ddesq = ddesq;
	}

	public String getReanx() {
		return reanx;
	}

	public void setReanx(String reanx) {
		this.reanx = reanx;
	}

	public String getDsesq() {
		return dsesq;
	}

	public void setDsesq(String dsesq) {
		this.dsesq = dsesq;
	}

	public String getDocfat() {
		return docfat;
	}

	public void setDocfat(String docfat) {
		this.docfat = docfat;
	}

	public String getXblnr() {
		return xblnr;
	}

	public void setXblnr(String xblnr) {
		this.xblnr = xblnr;
	}

	public String getInco1() {
		return inco1;
	}

	public void setInco1(String inco1) {
		this.inco1 = inco1;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getDdeadt() {
		return ddeadt;
	}

	public void setDdeadt(String ddeadt) {
		this.ddeadt = ddeadt;
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
		Tgteres other = (Tgteres) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteres [id=" + id + ", tgteshkn=" + tgteshkn.getId() + ", sbeln=" + sbeln + "]";
	}

    
}

package br.com.d2st.exportacao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "xblnr"))
public class Tpck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;

	@Transient
    private String sbeln;
    
    private String docnr;

    private String pctyp;

    private String parid;

    private String bldat;

    @NotEmpty
    private String xblnr;

    private String zuonr;

    private String bktxt;

    private String sgtxt;

    private String zfbdt;

    private String ablfd;

    private String statu;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "tpck", fetch = FetchType.EAGER)
    private List<Txpns> txpns = new ArrayList<>();
    
    @NotEmpty
    @ManyToOne
    private Shipping shipping;

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

	public String getSbeln() {
		return sbeln;
	}

	public void setSbeln(String sbeln) {
		this.sbeln = sbeln;
	}

	public String getDocnr() {
		return docnr;
	}

	public void setDocnr(String docnr) {
		this.docnr = docnr;
	}

	public String getPctyp() {
		return pctyp;
	}

	public void setPctyp(String pctyp) {
		this.pctyp = pctyp;
	}

	public String getParid() {
		return parid;
	}

	public void setParid(String parid) {
		this.parid = parid;
	}

	public String getBldat() {
		return bldat;
	}

	public void setBldat(String bldat) {
		this.bldat = bldat;
	}

	public String getXblnr() {
		return xblnr;
	}

	public void setXblnr(String xblnr) {
		this.xblnr = xblnr;
	}

	public String getZuonr() {
		return zuonr;
	}

	public void setZuonr(String zuonr) {
		this.zuonr = zuonr;
	}

	public String getBktxt() {
		return bktxt;
	}

	public void setBktxt(String bktxt) {
		this.bktxt = bktxt;
	}

	public String getSgtxt() {
		return sgtxt;
	}

	public void setSgtxt(String sgtxt) {
		this.sgtxt = sgtxt;
	}

	public String getZfbdt() {
		return zfbdt;
	}

	public void setZfbdt(String zfbdt) {
		this.zfbdt = zfbdt;
	}

	public String getAblfd() {
		return ablfd;
	}

	public void setAblfd(String ablfd) {
		this.ablfd = ablfd;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public List<Txpns> getTxpns() {
		return txpns;
	}

	public void setTxpns(List<Txpns> txpns) {
		this.txpns = txpns;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
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
		Tpck other = (Tpck) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tpck [id=" + id + ", sbeln=" + sbeln + ", docnr=" + docnr + ", shipping=" + shipping.getId() + "]";
	}
}

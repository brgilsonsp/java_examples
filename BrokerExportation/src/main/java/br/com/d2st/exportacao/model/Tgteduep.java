package br.com.d2st.exportacao.model;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tgteduep implements Serializable {

	private static final long serialVersionUID = 8574685431968095431L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@ManyToOne
	private Tgteshkn tgteshkn;
	
	private String type;

    private String dueid;

    private String dueposnr;

    private String duenum;

    private String dueitm;

    private String rucnum;
            
    private String prcfob;

    private String cdlandd;

    private String menge;

    private String netwr;

    private String menge_trib;

    private String ntgew;

    private String enqdm;

    private String prvdocid;

    private String prvtpcode;
    
    private String pctcom;

    private String chavenfe;

    private String tpcdrem;

    private String cnpjcpf;

    private String chavenf_form;

    private String cdnfr;

    private String cpnjcpfexp;
    
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "tgteduep", fetch = FetchType.EAGER)
    private List<AtoconTabTgteduep> atoconTabTgteduep = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "tgteduep", fetch = FetchType.EAGER)
    private List<NferefTabTgteduep> nferefTabTgteduep = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "tgteduep", fetch = FetchType.EAGER)
    private List<AddinfoTabTgteduep> addinfoTabTgteduep = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "tgteduep", fetch = FetchType.EAGER)
    private List<DuetribTabTgteduep> duetribTabTgteduep = new ArrayList<>();
    
    @Deprecated
    public Tgteduep() { }

	public Tgteduep(Tgteshkn tgteshkn, String type) {
		super();
		this.tgteshkn = tgteshkn;
		this.type = type;
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

	public String getDuenum() {
		return duenum;
	}

	public void setDuenum(String duenum) {
		this.duenum = duenum;
	}

	public String getDueitm() {
		return dueitm;
	}

	public void setDueitm(String dueitm) {
		this.dueitm = dueitm;
	}

	public String getRucnum() {
		return rucnum;
	}

	public void setRucnum(String rucnum) {
		this.rucnum = rucnum;
	}

	public String getPrcfob() {
		return prcfob;
	}

	public void setPrcfob(String prcfob) {
		this.prcfob = prcfob;
	}

	public String getCdlandd() {
		return cdlandd;
	}

	public void setCdlandd(String cdlandd) {
		this.cdlandd = cdlandd;
	}

	public String getMenge() {
		return menge;
	}

	public void setMenge(String menge) {
		this.menge = menge;
	}

	public String getNetwr() {
		return netwr;
	}

	public void setNetwr(String netwr) {
		this.netwr = netwr;
	}

	public String getMenge_trib() {
		return menge_trib;
	}

	public void setMenge_trib(String menge_trib) {
		this.menge_trib = menge_trib;
	}

	public String getNtgew() {
		return ntgew;
	}

	public void setNtgew(String ntgew) {
		this.ntgew = ntgew;
	}

	public String getEnqdm() {
		return enqdm;
	}

	public void setEnqdm(String enqdm) {
		this.enqdm = enqdm;
	}

	public String getPrvdocid() {
		return prvdocid;
	}

	public void setPrvdocid(String prvdocid) {
		this.prvdocid = prvdocid;
	}

	public String getPrvtpcode() {
		return prvtpcode;
	}

	public void setPrvtpcode(String prvtpcode) {
		this.prvtpcode = prvtpcode;
	}

	public String getPctcom() {
		return pctcom;
	}

	public void setPctcom(String pctcom) {
		this.pctcom = pctcom;
	}

	public String getChavenfe() {
		return chavenfe;
	}

	public void setChavenfe(String chavenfe) {
		this.chavenfe = chavenfe;
	}

	public String getTpcdrem() {
		return tpcdrem;
	}

	public void setTpcdrem(String tpcdrem) {
		this.tpcdrem = tpcdrem;
	}

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public String getChavenf_form() {
		return chavenf_form;
	}

	public void setChavenf_form(String chavenf_form) {
		this.chavenf_form = chavenf_form;
	}

	public String getCdnfr() {
		return cdnfr;
	}

	public void setCdnfr(String cdnfr) {
		this.cdnfr = cdnfr;
	}

	public String getCpnjcpfexp() {
		return cpnjcpfexp;
	}

	public void setCpnjcpfexp(String cpnjcpfexp) {
		this.cpnjcpfexp = cpnjcpfexp;
	}

	public List<AtoconTabTgteduep> getAtoconTabTgteduep() {
		return atoconTabTgteduep;
	}

	public void setAtoconTabTgteduep(List<AtoconTabTgteduep> atoconTabTgteduep) {
		this.atoconTabTgteduep = atoconTabTgteduep;
	}

	public List<NferefTabTgteduep> getNferefTabTgteduep() {
		return nferefTabTgteduep;
	}

	public void setNferefTabTgteduep(List<NferefTabTgteduep> nferefTabTgteduep) {
		this.nferefTabTgteduep = nferefTabTgteduep;
	}

	public List<AddinfoTabTgteduep> getAddinfoTabTgteduep() {
		return addinfoTabTgteduep;
	}

	public void setAddinfoTabTgteduep(List<AddinfoTabTgteduep> addinfoTabTgteduep) {
		this.addinfoTabTgteduep = addinfoTabTgteduep;
	}

	public List<DuetribTabTgteduep> getDuetribTabTgteduep() {
		return duetribTabTgteduep;
	}

	public void setDuetribTabTgteduep(List<DuetribTabTgteduep> duetribTabTgteduep) {
		this.duetribTabTgteduep = duetribTabTgteduep;
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
		Tgteduep other = (Tgteduep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteduep [id=" + id + ", tgteshkn=" + tgteshkn.getId() + "]";
	}
}

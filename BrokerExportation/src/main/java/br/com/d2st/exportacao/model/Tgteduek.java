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
public class Tgteduek implements Serializable {

	private static final long serialVersionUID = 3704020866186311987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteshkn tgteshkn;
	
	private String type;

    private String dueid;

    private String xlocembarq;

    private String xlocdespacho;

    private String cdrad;

    private String emrad;
    
    private String latitude;

    private String longitude;

    private String cdrae;

    private String emrae;

    private String cnpj_desp;

    private String waers;

    private String inco1;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteduek", orphanRemoval=true, fetch = FetchType.EAGER)
    private List<AddressTabTgteduek> address_tab = new ArrayList<>();

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteduek", orphanRemoval=true, fetch = FetchType.EAGER)
    private List<AddinfoTabTgteduek> addinfo_tab = new ArrayList<>();
    
    @Deprecated
	public Tgteduek() { }
    
	public Tgteduek(Tgteshkn tgteshkn, String type, String dueid, List<AddressTabTgteduek> address_tab,
			List<AddinfoTabTgteduek> addinfo_tab) {
		this.tgteshkn = tgteshkn;
		this.type = type;
		this.dueid = dueid;
		this.address_tab = address_tab;
		this.addinfo_tab = addinfo_tab;
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

	public String getXlocembarq() {
		return xlocembarq;
	}

	public void setXlocembarq(String xlocembarq) {
		this.xlocembarq = xlocembarq;
	}

	public String getXlocdespacho() {
		return xlocdespacho;
	}

	public void setXlocdespacho(String xlocdespacho) {
		this.xlocdespacho = xlocdespacho;
	}

	public String getCdrad() {
		return cdrad;
	}

	public void setCdrad(String cdrad) {
		this.cdrad = cdrad;
	}

	public String getEmrad() {
		return emrad;
	}

	public void setEmrad(String emrad) {
		this.emrad = emrad;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCdrae() {
		return cdrae;
	}

	public void setCdrae(String cdrae) {
		this.cdrae = cdrae;
	}

	public String getEmrae() {
		return emrae;
	}

	public void setEmrae(String emrae) {
		this.emrae = emrae;
	}

	public String getCnpj_desp() {
		return cnpj_desp;
	}

	public void setCnpj_desp(String cnpj_desp) {
		this.cnpj_desp = cnpj_desp;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getInco1() {
		return inco1;
	}

	public void setInco1(String inco1) {
		this.inco1 = inco1;
	}

	public List<AddressTabTgteduek> getAddress_tab() {
		return address_tab;
	}

	public void setAddress_tab(List<AddressTabTgteduek> address_tab) {
		this.address_tab = address_tab;
	}

	public List<AddinfoTabTgteduek> getAddinfo_tab() {
		return addinfo_tab;
	}

	public void setAddinfo_tab(List<AddinfoTabTgteduek> addinfo_tab) {
		this.addinfo_tab = addinfo_tab;
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
		Tgteduek other = (Tgteduek) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteduek [id=" + id + ", tgteshkn=" + tgteshkn.getId() + ", type=" + type + "]";
	}
	
	
}

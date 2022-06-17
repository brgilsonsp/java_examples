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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tgteshpn implements Serializable{

	private static final long serialVersionUID = 4185452769929203427L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteshkn tgteshkn;

	private String type;

	@Transient
	@NotEmpty
    private String sbeln;

    private String sbelp;

    private String nbelp;
            
    private String docfat;

    private String itmfat;
    
    private String matnr;

    private String maktx;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshpn", orphanRemoval=true, fetch = FetchType.EAGER)
    private List<MaktxText> maktx_text = new ArrayList<>();

    private String qtditm;

    private String netpr;

    private String kpein;

    private String meins;

    private String netwr;

    private String frtloc;

    private String frtint;

    private String segint;

    private String prcfob;

    private String prcexw;

    private String pctcom;

    private String vlrcom;

    private String renum;

    private String itmre;

    private String enqdm;

    private String brgew;

    private String ntgew;

    private String gewei;

    private String volum;
            
    private String voleh;

    private String steuc;

    private String naladish;

    private String fabitm;

    private String atocon;

    private String amccptc;

    private String brccptc;

    private String ccrom;

    private String fabriluf;

    private String netprori;

    private String kpeinori;

    private String meinsori;

    private String netwrori;

    private String prod;

    private String fkdat;

    @Deprecated
	public Tgteshpn() { }

	public Tgteshpn(Tgteshkn tgteshkn, String type, String sbeln, List<MaktxText> maktx_text) {
		super();
		this.tgteshkn = tgteshkn;
		this.type = type;
		this.sbeln = sbeln;
		this.maktx_text = maktx_text;
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

	public String getSbelp() {
		return sbelp;
	}

	public void setSbelp(String sbelp) {
		this.sbelp = sbelp;
	}

	public String getNbelp() {
		return nbelp;
	}

	public void setNbelp(String nbelp) {
		this.nbelp = nbelp;
	}

	public String getDocfat() {
		return docfat;
	}

	public void setDocfat(String docfat) {
		this.docfat = docfat;
	}

	public String getItmfat() {
		return itmfat;
	}

	public void setItmfat(String itmfat) {
		this.itmfat = itmfat;
	}

	public String getMatnr() {
		return matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public String getMaktx() {
		return maktx;
	}

	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}

	public List<MaktxText> getMaktx_text() {
		return maktx_text;
	}

	public void setMaktx_text(List<MaktxText> maktx_text) {
		this.maktx_text = maktx_text;
	}

	public String getQtditm() {
		return qtditm;
	}

	public void setQtditm(String qtditm) {
		this.qtditm = qtditm;
	}

	public String getNetpr() {
		return netpr;
	}

	public void setNetpr(String netpr) {
		this.netpr = netpr;
	}

	public String getKpein() {
		return kpein;
	}

	public void setKpein(String kpein) {
		this.kpein = kpein;
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public String getNetwr() {
		return netwr;
	}

	public void setNetwr(String netwr) {
		this.netwr = netwr;
	}

	public String getFrtloc() {
		return frtloc;
	}

	public void setFrtloc(String frtloc) {
		this.frtloc = frtloc;
	}

	public String getFrtint() {
		return frtint;
	}

	public void setFrtint(String frtint) {
		this.frtint = frtint;
	}

	public String getSegint() {
		return segint;
	}

	public void setSegint(String segint) {
		this.segint = segint;
	}

	public String getPrcfob() {
		return prcfob;
	}

	public void setPrcfob(String prcfob) {
		this.prcfob = prcfob;
	}

	public String getPrcexw() {
		return prcexw;
	}

	public void setPrcexw(String prcexw) {
		this.prcexw = prcexw;
	}

	public String getPctcom() {
		return pctcom;
	}

	public void setPctcom(String pctcom) {
		this.pctcom = pctcom;
	}

	public String getVlrcom() {
		return vlrcom;
	}

	public void setVlrcom(String vlrcom) {
		this.vlrcom = vlrcom;
	}

	public String getRenum() {
		return renum;
	}

	public void setRenum(String renum) {
		this.renum = renum;
	}

	public String getItmre() {
		return itmre;
	}

	public void setItmre(String itmre) {
		this.itmre = itmre;
	}

	public String getEnqdm() {
		return enqdm;
	}

	public void setEnqdm(String enqdm) {
		this.enqdm = enqdm;
	}

	public String getBrgew() {
		return brgew;
	}

	public void setBrgew(String brgew) {
		this.brgew = brgew;
	}

	public String getNtgew() {
		return ntgew;
	}

	public void setNtgew(String ntgew) {
		this.ntgew = ntgew;
	}

	public String getGewei() {
		return gewei;
	}

	public void setGewei(String gewei) {
		this.gewei = gewei;
	}

	public String getVolum() {
		return volum;
	}

	public void setVolum(String volum) {
		this.volum = volum;
	}

	public String getVoleh() {
		return voleh;
	}

	public void setVoleh(String voleh) {
		this.voleh = voleh;
	}

	public String getSteuc() {
		return steuc;
	}

	public void setSteuc(String steuc) {
		this.steuc = steuc;
	}

	public String getNaladish() {
		return naladish;
	}

	public void setNaladish(String naladish) {
		this.naladish = naladish;
	}

	public String getFabitm() {
		return fabitm;
	}

	public void setFabitm(String fabitm) {
		this.fabitm = fabitm;
	}

	public String getAtocon() {
		return atocon;
	}

	public void setAtocon(String atocon) {
		this.atocon = atocon;
	}

	public String getAmccptc() {
		return amccptc;
	}

	public void setAmccptc(String amccptc) {
		this.amccptc = amccptc;
	}

	public String getBrccptc() {
		return brccptc;
	}

	public void setBrccptc(String brccptc) {
		this.brccptc = brccptc;
	}

	public String getCcrom() {
		return ccrom;
	}

	public void setCcrom(String ccrom) {
		this.ccrom = ccrom;
	}

	public String getFabriluf() {
		return fabriluf;
	}

	public void setFabriluf(String fabriluf) {
		this.fabriluf = fabriluf;
	}

	public String getNetprori() {
		return netprori;
	}

	public void setNetprori(String netprori) {
		this.netprori = netprori;
	}

	public String getKpeinori() {
		return kpeinori;
	}

	public void setKpeinori(String kpeinori) {
		this.kpeinori = kpeinori;
	}

	public String getMeinsori() {
		return meinsori;
	}

	public void setMeinsori(String meinsori) {
		this.meinsori = meinsori;
	}

	public String getNetwrori() {
		return netwrori;
	}

	public void setNetwrori(String netwrori) {
		this.netwrori = netwrori;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public String getFkdat() {
		return fkdat;
	}

	public void setFkdat(String fkdat) {
		this.fkdat = fkdat;
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
		Tgteshpn other = (Tgteshpn) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteshpn [id=" + id + ", tgteshkn=" + tgteshkn.getId() + ", sbeln=" + sbeln + "]";
	}

    
}

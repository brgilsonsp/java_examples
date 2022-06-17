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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tgteshkn implements Serializable{

	private static final long serialVersionUID = -5685731968496959458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@OneToOne(fetch = FetchType.EAGER)
	private Shipping shipping;
		
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Tgteshpn> tgteshpn = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Tgteprd> tgteprd = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<ShpText> shpText = new ArrayList<>();	
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Tgteres> tgteres = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Tgteduek> tgteduek = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.REMOVE, mappedBy="tgteshkn", orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Tgteduep> tgteduep = new ArrayList<>();
	
	private String type;

	@Transient
    private String sbeln;
    
    private String locse;
    
    private String tipse;

    private String tsetmp;

    private String sedat;

    private String etadt;

    private String envdt;

    private String prevdt;
    
    private String trans;

    private String zollao;

    private String zlando;

    private String zollad;

    private String zlandd;

    private String netwr;

    private String waersrf;

    private String inco1;

    private String zterm;

    private String sestat;

    private String waers;

    private String bfmar;

    private String shptrip;

    private String etddt;

    private String blnmb;

    private String bldta;

    private String hsawb;

    private String shpnam;

    private String invnr;
    
    private String dt_invnr;
    
    private String volum;

    private String ntgew;

    private String brgew;

    private String vlfrete;

    private String moedafrt;

    private String vlseguro;

    private String moedasgr;

    private String vlcoagt;

    private String moedacoagt;

    private String pccoagt;

    private String tpcoagt;

    private String dtcltc;
    
    private String dtearm;

    private String dtentc;
    
    private String urfdesp;

    private String urfemba;

    private String modpag;

    private String bascom;

    private String preclct;

    private String dtcoleta;

    private String dtchgarm;

    private String dtpresc;

    private String dtaverb;

    private String dtentrega;

    private String broknm;

    private String nmbook;

    private String dtbook;

    private String tpveic;

    private String tpcarg;

    private String ufembarq;

    private String instneg;

    private String tpprp;
    
    private String dtship;

    private String nroce;

    private String dtce;
    
    @Deprecated
	public Tgteshkn() { }

	public Tgteshkn(Shipping shipping, String type, String sbeln) {
		super();
		this.shipping = shipping;
		this.type = type;
		this.sbeln = sbeln;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public List<Tgteshpn> getTgteshpn() {
		return tgteshpn;
	}

	public void setTgteshpn(List<Tgteshpn> tgteshpn) {
		this.tgteshpn = tgteshpn;
	}

	public List<Tgteprd> getTgteprd() {
		return tgteprd;
	}

	public void setTgteprd(List<Tgteprd> tgteprd) {
		this.tgteprd = tgteprd;
	}

	public List<ShpText> getShpText() {
		return shpText;
	}

	public void setShpText(List<ShpText> shpText) {
		this.shpText = shpText;
	}

	public List<Tgteres> getTgteres() {
		return tgteres;
	}

	public void setTgteres(List<Tgteres> tgteres) {
		this.tgteres = tgteres;
	}

	public List<Tgteduek> getTgteduek() {
		return tgteduek;
	}

	public void setTgteduek(List<Tgteduek> tgteduek) {
		this.tgteduek = tgteduek;
	}

	public List<Tgteduep> getTgteduep() {
		return tgteduep;
	}

	public void setTgteduep(List<Tgteduep> tgteduep) {
		this.tgteduep = tgteduep;
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

	public String getLocse() {
		return locse;
	}

	public void setLocse(String locse) {
		this.locse = locse;
	}

	public String getTipse() {
		return tipse;
	}

	public void setTipse(String tipse) {
		this.tipse = tipse;
	}

	public String getTsetmp() {
		return tsetmp;
	}

	public void setTsetmp(String tsetmp) {
		this.tsetmp = tsetmp;
	}

	public String getSedat() {
		return sedat;
	}

	public void setSedat(String sedat) {
		this.sedat = sedat;
	}

	public String getEtadt() {
		return etadt;
	}

	public void setEtadt(String etadt) {
		this.etadt = etadt;
	}

	public String getEnvdt() {
		return envdt;
	}

	public void setEnvdt(String envdt) {
		this.envdt = envdt;
	}

	public String getPrevdt() {
		return prevdt;
	}

	public void setPrevdt(String prevdt) {
		this.prevdt = prevdt;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getZollao() {
		return zollao;
	}

	public void setZollao(String zollao) {
		this.zollao = zollao;
	}

	public String getZlando() {
		return zlando;
	}

	public void setZlando(String zlando) {
		this.zlando = zlando;
	}

	public String getZollad() {
		return zollad;
	}

	public void setZollad(String zollad) {
		this.zollad = zollad;
	}

	public String getZlandd() {
		return zlandd;
	}

	public void setZlandd(String zlandd) {
		this.zlandd = zlandd;
	}

	public String getNetwr() {
		return netwr;
	}

	public void setNetwr(String netwr) {
		this.netwr = netwr;
	}

	public String getWaersrf() {
		return waersrf;
	}

	public void setWaersrf(String waersrf) {
		this.waersrf = waersrf;
	}

	public String getInco1() {
		return inco1;
	}

	public void setInco1(String inco1) {
		this.inco1 = inco1;
	}

	public String getZterm() {
		return zterm;
	}

	public void setZterm(String zterm) {
		this.zterm = zterm;
	}

	public String getSestat() {
		return sestat;
	}

	public void setSestat(String sestat) {
		this.sestat = sestat;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getBfmar() {
		return bfmar;
	}

	public void setBfmar(String bfmar) {
		this.bfmar = bfmar;
	}

	public String getShptrip() {
		return shptrip;
	}

	public void setShptrip(String shptrip) {
		this.shptrip = shptrip;
	}

	public String getEtddt() {
		return etddt;
	}

	public void setEtddt(String etddt) {
		this.etddt = etddt;
	}

	public String getBlnmb() {
		return blnmb;
	}

	public void setBlnmb(String blnmb) {
		this.blnmb = blnmb;
	}

	public String getBldta() {
		return bldta;
	}

	public void setBldta(String bldta) {
		this.bldta = bldta;
	}

	public String getHsawb() {
		return hsawb;
	}

	public void setHsawb(String hsawb) {
		this.hsawb = hsawb;
	}

	public String getShpnam() {
		return shpnam;
	}

	public void setShpnam(String shpnam) {
		this.shpnam = shpnam;
	}

	public String getInvnr() {
		return invnr;
	}

	public void setInvnr(String invnr) {
		this.invnr = invnr;
	}

	public String getDt_invnr() {
		return dt_invnr;
	}

	public void setDt_invnr(String dt_invnr) {
		this.dt_invnr = dt_invnr;
	}

	public String getVolum() {
		return volum;
	}

	public void setVolum(String volum) {
		this.volum = volum;
	}

	public String getNtgew() {
		return ntgew;
	}

	public void setNtgew(String ntgew) {
		this.ntgew = ntgew;
	}

	public String getBrgew() {
		return brgew;
	}

	public void setBrgew(String brgew) {
		this.brgew = brgew;
	}

	public String getVlfrete() {
		return vlfrete;
	}

	public void setVlfrete(String vlfrete) {
		this.vlfrete = vlfrete;
	}

	public String getMoedafrt() {
		return moedafrt;
	}

	public void setMoedafrt(String moedafrt) {
		this.moedafrt = moedafrt;
	}

	public String getVlseguro() {
		return vlseguro;
	}

	public void setVlseguro(String vlseguro) {
		this.vlseguro = vlseguro;
	}

	public String getMoedasgr() {
		return moedasgr;
	}

	public void setMoedasgr(String moedasgr) {
		this.moedasgr = moedasgr;
	}

	public String getVlcoagt() {
		return vlcoagt;
	}

	public void setVlcoagt(String vlcoagt) {
		this.vlcoagt = vlcoagt;
	}

	public String getMoedacoagt() {
		return moedacoagt;
	}

	public void setMoedacoagt(String moedacoagt) {
		this.moedacoagt = moedacoagt;
	}

	public String getPccoagt() {
		return pccoagt;
	}

	public void setPccoagt(String pccoagt) {
		this.pccoagt = pccoagt;
	}

	public String getTpcoagt() {
		return tpcoagt;
	}

	public void setTpcoagt(String tpcoagt) {
		this.tpcoagt = tpcoagt;
	}

	public String getDtcltc() {
		return dtcltc;
	}

	public void setDtcltc(String dtcltc) {
		this.dtcltc = dtcltc;
	}

	public String getDtearm() {
		return dtearm;
	}

	public void setDtearm(String dtearm) {
		this.dtearm = dtearm;
	}

	public String getDtentc() {
		return dtentc;
	}

	public void setDtentc(String dtentc) {
		this.dtentc = dtentc;
	}

	public String getUrfdesp() {
		return urfdesp;
	}

	public void setUrfdesp(String urfdesp) {
		this.urfdesp = urfdesp;
	}

	public String getUrfemba() {
		return urfemba;
	}

	public void setUrfemba(String urfemba) {
		this.urfemba = urfemba;
	}

	public String getModpag() {
		return modpag;
	}

	public void setModpag(String modpag) {
		this.modpag = modpag;
	}

	public String getBascom() {
		return bascom;
	}

	public void setBascom(String bascom) {
		this.bascom = bascom;
	}

	public String getPreclct() {
		return preclct;
	}

	public void setPreclct(String preclct) {
		this.preclct = preclct;
	}

	public String getDtcoleta() {
		return dtcoleta;
	}

	public void setDtcoleta(String dtcoleta) {
		this.dtcoleta = dtcoleta;
	}

	public String getDtchgarm() {
		return dtchgarm;
	}

	public void setDtchgarm(String dtchgarm) {
		this.dtchgarm = dtchgarm;
	}

	public String getDtpresc() {
		return dtpresc;
	}

	public void setDtpresc(String dtpresc) {
		this.dtpresc = dtpresc;
	}

	public String getDtaverb() {
		return dtaverb;
	}

	public void setDtaverb(String dtaverb) {
		this.dtaverb = dtaverb;
	}

	public String getDtentrega() {
		return dtentrega;
	}

	public void setDtentrega(String dtentrega) {
		this.dtentrega = dtentrega;
	}

	public String getBroknm() {
		return broknm;
	}

	public void setBroknm(String broknm) {
		this.broknm = broknm;
	}

	public String getNmbook() {
		return nmbook;
	}

	public void setNmbook(String nmbook) {
		this.nmbook = nmbook;
	}

	public String getDtbook() {
		return dtbook;
	}

	public void setDtbook(String dtbook) {
		this.dtbook = dtbook;
	}

	public String getTpveic() {
		return tpveic;
	}

	public void setTpveic(String tpveic) {
		this.tpveic = tpveic;
	}

	public String getTpcarg() {
		return tpcarg;
	}

	public void setTpcarg(String tpcarg) {
		this.tpcarg = tpcarg;
	}

	public String getUfembarq() {
		return ufembarq;
	}

	public void setUfembarq(String ufembarq) {
		this.ufembarq = ufembarq;
	}

	public String getInstneg() {
		return instneg;
	}

	public void setInstneg(String instneg) {
		this.instneg = instneg;
	}

	public String getTpprp() {
		return tpprp;
	}

	public void setTpprp(String tpprp) {
		this.tpprp = tpprp;
	}

	public String getDtship() {
		return dtship;
	}

	public void setDtship(String dtship) {
		this.dtship = dtship;
	}

	public String getNroce() {
		return nroce;
	}

	public void setNroce(String nroce) {
		this.nroce = nroce;
	}

	public String getDtce() {
		return dtce;
	}

	public void setDtce(String dtce) {
		this.dtce = dtce;
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
		Tgteshkn other = (Tgteshkn) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteshkn [id=" + id + ", shipping=" + shipping.getId() + ", sbeln=" + sbeln + "]";
	}
    
    

}

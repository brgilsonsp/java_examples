package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class AddinfoTabTgteduek implements Serializable {

	private static final long serialVersionUID = 842563933365217044L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteduek tgteduek;
	
	private String type;

    private String dueid;

    private String dueposnr;

    private String stmtpcode;

    private String stmcode;

    private String lmtdttime;

    private String dttmstr;

    private String description;
    
    @Deprecated
	public AddinfoTabTgteduek() {	}

	public AddinfoTabTgteduek(Long id, Tgteduek tgteduek, String type) {
		super();
		this.id = id;
		this.tgteduek = tgteduek;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tgteduek getTgteduek() {
		return tgteduek;
	}

	public void setTgteduek(Tgteduek tgteduek) {
		this.tgteduek = tgteduek;
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

	public String getStmtpcode() {
		return stmtpcode;
	}

	public void setStmtpcode(String stmtpcode) {
		this.stmtpcode = stmtpcode;
	}

	public String getStmcode() {
		return stmcode;
	}

	public void setStmcode(String stmcode) {
		this.stmcode = stmcode;
	}

	public String getLmtdttime() {
		return lmtdttime;
	}

	public void setLmtdttime(String lmtdttime) {
		this.lmtdttime = lmtdttime;
	}

	public String getDttmstr() {
		return dttmstr;
	}

	public void setDttmstr(String dttmstr) {
		this.dttmstr = dttmstr;
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
		AddinfoTabTgteduek other = (AddinfoTabTgteduek) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddinfoTabTgteduek [id=" + id + ", tgteduek=" + tgteduek.getId() + ", type=" + type + "]";
	}

}

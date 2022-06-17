package br.com.d2st.exportacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tgteprd implements Serializable{

	private static final long serialVersionUID = 6798138355481889919L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@ManyToOne
	private Tgteshkn tgteshkn;

	private String type;

    private String parvw;

    private String parid;

    private String name1;

    private String name2;

    private String street;
    
    private String house_num1;

    private String house_num2;

    private String post_code1;

    private String city1;

    private String city2;

    private String pstlz;

    private String region;

    private String country;

    private String stcd1;

    private String stcd3;

    private String stcd4;
    
    @Deprecated
	public Tgteprd() { }

	public Tgteprd(Tgteshkn tgteshkn, String type) {
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

	public String getParvw() {
		return parvw;
	}

	public void setParvw(String parvw) {
		this.parvw = parvw;
	}

	public String getParid() {
		return parid;
	}

	public void setParid(String parid) {
		this.parid = parid;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_num1() {
		return house_num1;
	}

	public void setHouse_num1(String house_num1) {
		this.house_num1 = house_num1;
	}

	public String getHouse_num2() {
		return house_num2;
	}

	public void setHouse_num2(String house_num2) {
		this.house_num2 = house_num2;
	}

	public String getPost_code1() {
		return post_code1;
	}

	public void setPost_code1(String post_code1) {
		this.post_code1 = post_code1;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public String getPstlz() {
		return pstlz;
	}

	public void setPstlz(String pstlz) {
		this.pstlz = pstlz;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStcd1() {
		return stcd1;
	}

	public void setStcd1(String stcd1) {
		this.stcd1 = stcd1;
	}

	public String getStcd3() {
		return stcd3;
	}

	public void setStcd3(String stcd3) {
		this.stcd3 = stcd3;
	}

	public String getStcd4() {
		return stcd4;
	}

	public void setStcd4(String stcd4) {
		this.stcd4 = stcd4;
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
		Tgteprd other = (Tgteprd) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tgteprd [id=" + id + ", tgteshkn=" + tgteshkn.getId() + ", type=" + type + "]";
	}
        
	
}

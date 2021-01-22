/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yusuf
 */
@Entity
@Table(name = "MUSTERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musteri.findAll", query = "SELECT m FROM Musteri m")
    , @NamedQuery(name = "Musteri.findByMusteritc", query = "SELECT m FROM Musteri m WHERE m.musteritc = :musteritc")
    , @NamedQuery(name = "Musteri.findByIsimsoyisim", query = "SELECT m FROM Musteri m WHERE m.isimsoyisim = :isimsoyisim")
    , @NamedQuery(name = "Musteri.findByTel", query = "SELECT m FROM Musteri m WHERE m.tel = :tel")
    , @NamedQuery(name = "Musteri.findByPara", query = "SELECT m FROM Musteri m WHERE m.para = :para")
    , @NamedQuery(name = "Musteri.findByLimit", query = "SELECT m FROM Musteri m WHERE m.limit = :limit")
    , @NamedQuery(name = "Musteri.findBySifre", query = "SELECT m FROM Musteri m WHERE m.sifre = :sifre")})
public class Musteri implements Serializable {

    public Musteri(Double musteritc, String isimsoyisim, String tel, Double para, Double limit, String sifre) {
        this.musteritc = musteritc;
        this.isimsoyisim = isimsoyisim;
        this.tel = tel;
        this.para = para;
        this.limit = limit;
        this.sifre = sifre;
    }

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MUSTERITC")
    private Double musteritc;
    @Column(name = "ISIMSOYISIM")
    private String isimsoyisim;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "PARA")
    private Double para;
    @Column(name = "LIMIT")
    private Double limit;
    @Column(name = "SIFRE")
    private String sifre;

    public Musteri() {
    }

    public Musteri(Double musteritc) {
        this.musteritc = musteritc;
    }

    public Double getMusteritc() {
        return musteritc;
    }

    public void setMusteritc(Double musteritc) {
        this.musteritc = musteritc;
    }

    public String getIsimsoyisim() {
        return isimsoyisim;
    }

    public void setIsimsoyisim(String isimsoyisim) {
        this.isimsoyisim = isimsoyisim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Double getPara() {
        return para;
    }

    public void setPara(Double para) {
        this.para = para;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musteritc != null ? musteritc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musteri)) {
            return false;
        }
        Musteri other = (Musteri) object;
        if ((this.musteritc == null && other.musteritc != null) || (this.musteritc != null && !this.musteritc.equals(other.musteritc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otomasyon.Musteri[ musteritc=" + musteritc + " ]";
    }
    
}

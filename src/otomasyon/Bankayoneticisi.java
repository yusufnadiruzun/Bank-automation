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
@Table(name = "BANKAYONETICISI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankayoneticisi.findAll", query = "SELECT b FROM Bankayoneticisi b")
    , @NamedQuery(name = "Bankayoneticisi.findByYoneticitc", query = "SELECT b FROM Bankayoneticisi b WHERE b.yoneticitc = :yoneticitc")
    , @NamedQuery(name = "Bankayoneticisi.findByIsimsoyisim", query = "SELECT b FROM Bankayoneticisi b WHERE b.isimsoyisim = :isimsoyisim")
    , @NamedQuery(name = "Bankayoneticisi.findByTelno", query = "SELECT b FROM Bankayoneticisi b WHERE b.telno = :telno")
    , @NamedQuery(name = "Bankayoneticisi.findBySifre", query = "SELECT b FROM Bankayoneticisi b WHERE b.sifre = :sifre")})
public class Bankayoneticisi implements Serializable {

    public Bankayoneticisi(Double yoneticitc, String isimsoyisim, String telno, String sifre) {
        this.yoneticitc = yoneticitc;
        this.isimsoyisim = isimsoyisim;
        this.telno = telno;
        this.sifre = sifre;
    }

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "YONETICITC")
    private Double yoneticitc;
    @Column(name = "ISIMSOYISIM")
    private String isimsoyisim;
    @Column(name = "TELNO")
    private String telno;
    @Column(name = "SIFRE")
    private String sifre;

    public Bankayoneticisi() {
    }

    public Bankayoneticisi(Double yoneticitc) {
        this.yoneticitc = yoneticitc;
    }

    public Double getYoneticitc() {
        return yoneticitc;
    }

    public void setYoneticitc(Double yoneticitc) {
        this.yoneticitc = yoneticitc;
    }

    public String getIsimsoyisim() {
        return isimsoyisim;
    }

    public void setIsimsoyisim(String isimsoyisim) {
        this.isimsoyisim = isimsoyisim;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
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
        hash += (yoneticitc != null ? yoneticitc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankayoneticisi)) {
            return false;
        }
        Bankayoneticisi other = (Bankayoneticisi) object;
        if ((this.yoneticitc == null && other.yoneticitc != null) || (this.yoneticitc != null && !this.yoneticitc.equals(other.yoneticitc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otomasyon.Bankayoneticisi[ yoneticitc=" + yoneticitc + " ]";
    }
    
}

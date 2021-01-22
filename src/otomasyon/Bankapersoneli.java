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
@Table(name = "BANKAPERSONELI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankapersoneli.findAll", query = "SELECT b FROM Bankapersoneli b")
    , @NamedQuery(name = "Bankapersoneli.findByPersoneltc", query = "SELECT b FROM Bankapersoneli b WHERE b.personeltc = :personeltc")
    , @NamedQuery(name = "Bankapersoneli.findByIsimsoyisim", query = "SELECT b FROM Bankapersoneli b WHERE b.isimsoyisim = :isimsoyisim")
    , @NamedQuery(name = "Bankapersoneli.findByTelno", query = "SELECT b FROM Bankapersoneli b WHERE b.telno = :telno")
    , @NamedQuery(name = "Bankapersoneli.findBySifre", query = "SELECT b FROM Bankapersoneli b WHERE b.sifre = :sifre")})
public class Bankapersoneli implements Serializable {

    public Bankapersoneli(Double personeltc, String isimsoyisim, String telno, String sifre) {
        this.personeltc = personeltc;
        this.isimsoyisim = isimsoyisim;
        this.telno = telno;
        this.sifre = sifre;
    }

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PERSONELTC")
    private Double personeltc;
    @Column(name = "ISIMSOYISIM")
    private String isimsoyisim;
    @Column(name = "TELNO")
    private String telno;
    @Column(name = "SIFRE")
    private String sifre;

    public Bankapersoneli() {
    }

    public Bankapersoneli(Double personeltc) {
        this.personeltc = personeltc;
    }

    public Double getPersoneltc() {
        return personeltc;
    }

    public void setPersoneltc(Double personeltc) {
        this.personeltc = personeltc;
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
        hash += (personeltc != null ? personeltc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankapersoneli)) {
            return false;
        }
        Bankapersoneli other = (Bankapersoneli) object;
        if ((this.personeltc == null && other.personeltc != null) || (this.personeltc != null && !this.personeltc.equals(other.personeltc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "otomasyon.Bankapersoneli[ personeltc=" + personeltc + " ]";
    }
    
}

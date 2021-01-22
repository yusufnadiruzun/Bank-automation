/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author yusuf
 */
public class Otomasyon {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("OtomasyonPU");
    EntityManager em = emf.createEntityManager();

    ArrayList<MusteriA> musteriler = new ArrayList<>();
    ArrayList<BankaPersoneliA> personeller = new ArrayList<>();
    ArrayList<BankaYoneticisiA> yoneticiler = new ArrayList<>();

    public void arrayListeVeriAktar() {
        Query mu = em.createQuery("select mus from Musteri mus");
        List<Musteri> musterilerDB = mu.getResultList();
        for (Musteri m : musterilerDB) {
            musteriler.add(new MusteriA(m.getLimit(), m.getPara(), m.getIsimsoyisim(), m.getTel(), m.getSifre(), m.getMusteritc()));
            System.out.println("müşteri eklendi");
        }
        Query pe = em.createQuery("select pu from Bankapersoneli pu");
        List<Bankapersoneli> personellerDB = pe.getResultList();
        for (Bankapersoneli p : personellerDB) {
            personeller.add(new BankaPersoneliA(p.getIsimsoyisim(), p.getTelno(), p.getSifre(), p.getPersoneltc()));
            System.out.println("personel eklendi");
        }
        Query yo = em.createQuery("select yu from Bankayoneticisi yu");
        List<Bankayoneticisi> yoneticilerDB = yo.getResultList();
        for (Bankayoneticisi y : yoneticilerDB) {
            yoneticiler.add(new BankaYoneticisiA(y.getIsimsoyisim(), y.getTelno(), y.getSifre(), y.getYoneticitc()));
            System.out.println("yönetici eklendi");
        }
    }

    public boolean musteriEkle(double tc, String isimsoyisim, String tel, double para, double limit, String sifre) {
        boolean sonuc = true;
        Query q = em.createQuery("select u from Musteri u");
        List<Musteri> musterilerDB = q.getResultList();
        for (Musteri m : musterilerDB) {
            if (m.getMusteritc() == tc) {
                JOptionPane.showMessageDialog(null, "Bu musteri Bulunuyor");
                sonuc = false;
                break;
            }
        }
        if (sonuc) {
            em.getTransaction().begin();
            Musteri mu = new Musteri(tc, isimsoyisim, tel, para, limit, sifre);
            em.persist(mu);
            em.getTransaction().commit();
            musteriler.add(new MusteriA(limit, para, isimsoyisim, tel, sifre, tc));
            JOptionPane.showMessageDialog(null, " Müşteri başarıyla eklendi", "Başarılı işlem", JOptionPane.INFORMATION_MESSAGE);
        }
        return sonuc;
    }

    public void musteriSil(double tc) {
        for (int i = 0; i < musteriler.size(); i++) {
            if (tc == musteriler.get(i).tc) {
                musteriler.remove(musteriler.get(i));
                Query q = em.createQuery("delete from Musteri u where u.musteritc =:pTc");
                q.setParameter("pTc", tc);
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, " Müşteri başarıyla silindi ", "Başarılı işlem", JOptionPane.INFORMATION_MESSAGE);
            }

       
        }
    }

    public boolean personelEkle(double tc, String isimsoyisim, String tel, double para, double limit, String sifre) {
        boolean sonuc = true;
        Query q = em.createQuery("select u from  Bankapersoneli u");
        List<Bankapersoneli> personelDB = q.getResultList();
        for (Bankapersoneli a : personelDB) {
            if (a.getPersoneltc() == tc) {
                JOptionPane.showMessageDialog(null, "Bu personel Bulunuyor");
                sonuc = false;
                break;
            }
        }
        if (sonuc) {
            em.getTransaction().begin();
            Bankapersoneli b = new Bankapersoneli(tc, isimsoyisim, tel, sifre);
            em.persist(b);
            em.getTransaction().commit();
            personeller.add(new BankaPersoneliA(isimsoyisim, tel, sifre, tc));
            JOptionPane.showMessageDialog(null, " personel başarıyla eklendi", "Başarılı işlem", JOptionPane.INFORMATION_MESSAGE);
        }
        return sonuc;
    }

    public boolean yoneticiEkle(double tc, String isimsoyisim, String tel, double para, double limit, String sifre) {
        boolean sonuc = true;
        Query q = em.createQuery("select u from Bankayoneticisi u");
        List<Bankayoneticisi> yoneticilerDB = q.getResultList();
        for (Bankayoneticisi m : yoneticilerDB) {
            if (m.getYoneticitc() == tc) {
                JOptionPane.showMessageDialog(null, "Bu yonetici Bulunuyor");
                sonuc = false;
                break;
            }
        }
        if (sonuc) {
            em.getTransaction().begin();
            Bankayoneticisi b = new Bankayoneticisi(tc, isimsoyisim, tel, sifre);
            em.persist(b);
            em.getTransaction().commit();
            yoneticiler.add(new BankaYoneticisiA(isimsoyisim, tel, sifre, tc));
            JOptionPane.showMessageDialog(null, " Yönetici başarıyla eklendi", "Başarılı işlem", JOptionPane.INFORMATION_MESSAGE);
        }
        return sonuc;
    }

    public void paraGuncelle(double girilenTc, double girilenPara) {
        double topPara = 0;
        Query q = em.createQuery("select u from Musteri u");
        List<Musteri> musterilerDB = q.getResultList();
        for (Musteri m : musterilerDB) {
            if (m.getMusteritc() == girilenTc) {
                em.getTransaction().begin();
                m.setPara(m.getPara() + girilenPara);
                topPara = m.getPara();
                JOptionPane.showMessageDialog(null, "Musterinin yeni bakiyesi : " + m.getPara());
                em.getTransaction().commit();
            }
        }
        for (int i = 0; i < musteriler.size(); i++) {
            if (girilenTc == musteriler.get(i).tc) {
                musteriler.get(i).para = topPara;
            }
        }
    }

    public void paraTransferi(double tc1, double tc2, double para) {
        boolean sonuc1 = false;
        boolean sonuc2 = false;
        MusteriA mu1 = null;
        MusteriA mu2 = null;
        for (int i = 0; i < musteriler.size(); i++) {
            if (tc1 == musteriler.get(i).tc) {
                mu1 = musteriler.get(i);
            }
            if (tc2 == musteriler.get(i).tc) {
                mu2 = musteriler.get(i);
            }
        }
        Musteri m1 = null;
        Musteri m2 = null;
        Query q = em.createQuery("select u from Musteri u");
        List<Musteri> musterilerDB = q.getResultList();
        for (Musteri m : musterilerDB) {
            if (m.getMusteritc() == tc1) {
                m1 = m;
                sonuc1 = true;
            }
            if (m.getMusteritc() == tc2) {
                m2 = m;
                sonuc2 = true;
            }
        }
        if (sonuc2 && sonuc1) {

            em.getTransaction().begin();
            mu1.para = m1.getPara() - para;
            mu2.para = m2.getPara() + para;
            m1.setPara(m1.getPara() - para);
            m2.setPara(m2.getPara() + para);

            JOptionPane.showMessageDialog(null, " İşleminiz başarıyla gerçekleşti. Yeni bakiyeniz  " + m1.getPara());
            em.getTransaction().commit();
        } else {
            JOptionPane.showMessageDialog(null, " Girdiğiniz tc numarasına kayıtlı müşteri yok  ", "Uyarı ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limitGuncelle(double tc, double limit) {

        Query q = em.createQuery("select u from Musteri u");
        List<Musteri> musterilerDB = q.getResultList();
        for (Musteri m : musterilerDB) {
            if (m.getMusteritc() == tc) {
                em.getTransaction().begin();
                m.setLimit(limit);
                em.getTransaction().commit();
                for (int i = 0; i < musteriler.size(); i++) {
                    if (tc == musteriler.get(i).tc) {
                        musteriler.get(i).limit = limit;
                    }
                }
                JOptionPane.showMessageDialog(null, " İşleminiz başarıyla gerçekleşti. Yeni limitiniz  " + limit);
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otomasyon;

/**
 *
 * @author yusuf
 */
public class MusteriA extends BankaYoneticisiA{
    double limit, para;

    public MusteriA(double limit, double para, String isimsoyisim, String telNo, String sifre, double tc) {
        super(isimsoyisim, telNo, sifre, tc);
        this.limit = limit;
        this.para = para;
    }

   
   
    
    
}

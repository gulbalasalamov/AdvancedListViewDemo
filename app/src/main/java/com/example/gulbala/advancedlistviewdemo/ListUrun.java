package com.example.gulbala.advancedlistviewdemo;

/**
 * Created by Gulbala on 18.05.2017
 * Model Sınıf. Nesneye yönelik programlamada verileri temsil etmek icin olustururuz.
 */
public class ListUrun {
    private int urunResim;
    private String urunAd;
    private String urunAciklama;

    //Constructor metot
    //Veri modelimize uygun olarak urunlerin resim, ad ve açıklamalarını hızli bir şekide atamak için oluşturduk.

    public ListUrun(int urunResim, String urunAd, String urunAciklama) {
        this.urunResim = urunResim;
        this.urunAd = urunAd;
        this.urunAciklama = urunAciklama;
    }

    public int getUrunResim() {
        return urunResim;
    }

    public void setUrunResim(int urunResim) {
        this.urunResim = urunResim;
    }

    public String getUrunAd() {
        return urunAd;
    }

    public void setUrunAd(String urunAd) {
        this.urunAd = urunAd;
    }

    public String getUrunAciklama() {
        return urunAciklama;
    }

    public void setUrunAciklama(String urunAciklama) {
        this.urunAciklama = urunAciklama;
    }

    public String toString() {
        return urunAd + "\n" + urunAciklama;
    }

}

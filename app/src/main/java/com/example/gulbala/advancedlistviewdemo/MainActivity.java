package com.example.gulbala.advancedlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Veri modeline uygun model sınıfımızı oluşturduktan sonra veri bütününü ve listeyi olusturabiliriz.
    //listede gösterilecek verileri oluşturuyoruz
    //urunleri tutacak array ve degerleri
    /*public static final String[] urunad = new String[]{"Ananas", "Armut", "Ayva", "Böğürtlen", "Çilek", "Karpuz", "Kavun", "Kayısı",
            "Kiraz", "Limon", "Muz", "Nar", "Portakal", "Şeftali", "Üzüm"};

    //urun açıklamalarını tutacak array ve degerleri
    public static final String[] urunaciklama = new String[]{"Ananas açıklama... ", "Armut açıklama... ", "Ayva açıklama...", "Böğürtlen açıklama...", "Çilek açıklama...", "Karpuz açıklama...", "Kavun açıklama...",
            "Kayısı açıklama...", "Kiraz açıklama...", "Limon açıklama", "Muz açıklama", "Nar açıklama...", "Portakal açıklama...", "Şeftali açıklama...", "Üzüm açıklama..."};

    //urun resimlerini tutacak array ve degerleri
    public static final Integer[] urunresim = new Integer[]{R.drawable.ananas, R.drawable.armut, R.drawable.ayva, R.drawable.bogurtlen,
            R.drawable.cilek, R.drawable.karpuz, R.drawable.kavun, R.drawable.kayisi, R.drawable.kiraz, R.drawable.limon, R.drawable.muz, R.drawable.nar,
            R.drawable.portalal, R.drawable.seftali, R.drawable.uzum};*/

    List<ListUrun> listUrunler; //Liste degiskeni
    ListView listView; //ListView degiskeni

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml'i bagladik

        listUrunler = new ArrayList<ListUrun>();

        /*for (int i = 0; i < urunad.length; i++) {
            //urun nesnesi olusturduk ve degerlerini ekşedık
            ListUrun urun = new ListUrun(urunresim[i], urunad[i], urunaciklama[i]);
            listUrunler.add(urun);
        }*/

        listView = (ListView) findViewById(R.id.listview); //listView nesnesini oluşturuyoruz.

        listUrunler.add(new ListUrun(R.drawable.ananas, "Ananas", "Ananas açıklama"));
        listUrunler.add(new ListUrun(R.drawable.armut, "Armut", "Armut açıklama"));
        listUrunler.add(new ListUrun(R.drawable.ayva, "Ayva", "Ayva açıklama"));
        listUrunler.add(new ListUrun(R.drawable.bogurtlen, "Böğürtlen", "Böğürtlen açıklama"));
        listUrunler.add(new ListUrun(R.drawable.cilek, "Çilek", "Çilek açıklama"));
        listUrunler.add(new ListUrun(R.drawable.karpuz, "Karpuz", "Karpuz açıklama"));
        listUrunler.add(new ListUrun(R.drawable.kavun, "Kavun", "Kavun açıklama"));
        listUrunler.add(new ListUrun(R.drawable.kayisi, "Kayisi", "Kayisi açıklama"));
        listUrunler.add(new ListUrun(R.drawable.kiraz, "Kiraz", "Kiraz açıklama"));
        listUrunler.add(new ListUrun(R.drawable.limon, "Limon", "Limon açıklama"));
        listUrunler.add(new ListUrun(R.drawable.muz, "Muz", "Muz açıklama"));
        listUrunler.add(new ListUrun(R.drawable.nar, "Nar", "Nar açıklama"));
        listUrunler.add(new ListUrun(R.drawable.portalal, "Portakal", "Portakal açıklama"));
        listUrunler.add(new ListUrun(R.drawable.seftali, "Şeftali", "Şeftali açıklama"));
        listUrunler.add(new ListUrun(R.drawable.uzum, "Üzüm", "Üzüm açıklama"));

        //CustomBaseAdapter objemizi olusturuyoruz.
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, listUrunler);

        //Adapter'ı set edip, değerlerimizi ListView gönderiyoruz
        listView.setAdapter(adapter);

        // ListView satırlarını dinlemek için dinleyici
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(), "Ürün " + (position + 1) + ": " + listUrunler.get(position), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}

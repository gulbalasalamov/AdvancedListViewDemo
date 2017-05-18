package com.example.gulbala.advancedlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by gulbala on 7/2/16.
 */
public class CustomBaseAdapter extends BaseAdapter {

    //degiskenleri tanımlıyoruz
    Context context;
    List<ListUrun> urunler;

    public CustomBaseAdapter(Context context, List<ListUrun> marketUrunler) {
        this.context = context;
        this.urunler = marketUrunler;
    }

    @Override
    public int getCount() {
        return urunler.size();
    }

    @Override
    public Object getItem(int position) {
        return urunler.get(position);
    }

    @Override
    public long getItemId(int position) {
        return urunler.indexOf(getItem(position));
    }


    //private viw holder sınıfımız
    //ImageView ve TextView nesnelerimizi tutuyor. Degiskenlerimizi tanımlıyoruz
    private class ViewHolder {
        ImageView iv;
        TextView tvAd;
        TextView tvAciklama;
    }

    //getView fonksiyonumuz şimdi aşağıdaki gibi bir hal alıyor.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        /*ListView'da satırlarımızı recycle ettigimiz zaman convertView argumanı nun-null (null olmayan) bir degere sahiptir.
        Oyuzden convertView null degilken sürekli yeni layout infliate etmek performans düsürür. Bunu minimize etmek için
        mevcut layout uzerinde convertView'in icerigini update etmeliyiz*/

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            //layout inflate ediyoruz.
            //list_urun'den yeni bir view oluşturuyoruz
            convertView = inflater.inflate(R.layout.liste_urunler, null);

            //yeni bir ViewHolder objesi oluşturuyoruz.
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.image);
            holder.tvAciklama = (TextView) convertView.findViewById(R.id.urunaciklama);
            holder.tvAd = (TextView) convertView.findViewById(R.id.urunad);

            //View'ları ViewHolder'da kaydediyoruz.
            convertView.setTag(holder);
        } else {
            //kaynak dosyaları üzerinde findViewById() tekrar tekrar layout olusturmaktan kaciniyoruz
            //bunun yerine ViewHolder kullanıyoruz
            holder = (ViewHolder) convertView.getTag();
        }
        //listede position ile belirtilen satıra denk düsen gösterilecek nesne
        ListUrun raflar = (ListUrun) getItem(position);

        //TextView ve ImageView neslerini alip, verilerini set ediyoruz.
        holder.tvAciklama.setText(raflar.getUrunAciklama());
        holder.tvAd.setText(raflar.getUrunAd());
        holder.iv.setImageResource(raflar.getUrunResim());

        return convertView;

    }
}

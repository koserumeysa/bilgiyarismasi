package com.rk10.bilgiyarismasi;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class kategoriEkrani extends AppCompatActivity {
    GridView KategoriGrid;

    String[] Kategoriler = {"Bilim","Coğrafya","Dini Bilgiler","Edebiyat","Genel Kültür",
            "Sinema","Spor","Tarih","Teknoloji","Yazılım"};

    int []ikonlar={R.drawable.bilim,R.drawable.cografya,R.drawable.din,R.drawable.edebiyat,R.drawable.genelkultur,
            R.drawable.sinema,R.drawable.spor,R.drawable.tarih,R.drawable.tekno,R.drawable.yazilim};



    String[] Sorular = {"DNA'nın açılımı nedir?","Tuz Gölünün hangi illerimizde kıyısı yoktur?","Kuranda kaç sure vardır?",
    "Ahmet Mithat Efendi tarafından yazılan Türk edebiyatının ilk polisiye romanı hangisidir?",
    "Hangi hayvan memeli değildir?","Görsel hangi filme aittir?", "2022-2023 sezonu Spor Toto 1. Lig Şampiyonu hangi takımdır?",
    "Fatih Sultan Mehmet'in babası kimdir?","Hangisi bulut depolama araçlarından değildir?","Hangisi sistem yazılımıdır?"};

    String[] CevapA ={"Deoksiribonükleik asit","Ankara","112","Kramponlu Ceset","Penguen","Esaretin Bedeli","Galatasaray","1. Mehmet","DropBox","Paint"};
    String[] CevapB ={"Asit Deoksiribonükleik","Konya","117","Yakut Gözlü Kedi","Keçi","Sevmek Zamanı","Galatasaray","Yıldırım Beyazit","Google Drive","Pardus"};
    String[] CevapC ={"Deoksiriboleik asit","Niğde","114","Yolpalas Cinayeti","Yarasa","Piyanist","Galatasaray","2. Murat","Yandex","Google Chrome"};
    String[] CevapD ={"Peoksiribonükleik asit","Aksaray","110","Esrar-ı Cinayet","Yunus","Matrix","Galatasaray","Yavuz Selim","Instagram","Avast Antivirüs"};

    String[] dogruSecenek = {"Deoksiribonükleik asit","Konya","114","Esrar-ı Cinayet","Penguen","Piyanist","Galatasaray","2. Murat","Instagram","Pardus"};
    int []gorseller={R.drawable.dna,R.drawable.tuzgolu,R.drawable.kuran,R.drawable.ahmetmithat,R.drawable.omurgali,
    R.drawable.piyanist,R.drawable.galatasaray,R.drawable.fsm,R.drawable.bulut,R.drawable.pardus};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_ekrani);

        KategoriGrid = findViewById(R.id.KategoriGrid);

        CustomAdapter customAdapter = new CustomAdapter();
        KategoriGrid.setAdapter(customAdapter);
        KategoriGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),soruEkrani.class);
                intent.putExtra("name",Kategoriler[i]);
                intent.putExtra("image",ikonlar[i]);
                intent.putExtra("soru",Sorular[i]);
                intent.putExtra("cevapA",CevapA[i]);
                intent.putExtra("cevapB",CevapB[i]);
                intent.putExtra("cevapC",CevapC[i]);
                intent.putExtra("cevapD",CevapD[i]);
                intent.putExtra("gorsel",gorseller[i]);
                intent.putExtra("dogruSecenek",dogruSecenek[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return ikonlar.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.kategori_grid,null);
            TextView name = view1.findViewById(R.id.KategoriAdi);
            ImageView image = view1.findViewById(R.id.ikon);
            name.setText(Kategoriler[i]);
            image.setImageResource(ikonlar[i]);
            return view1;
        }
    }
}



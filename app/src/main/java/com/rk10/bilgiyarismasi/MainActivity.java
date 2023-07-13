package com.rk10.bilgiyarismasi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_kategoriler,kurallar,basla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_kategoriler = findViewById(R.id.btn_kategoriler);
        kurallar = findViewById(R.id.btn_kurallar);
        basla = findViewById(R.id.btn_basla);

        btn_kategoriler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategori_getir();
            }
        });
        kurallar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurallar_getir();
            }
        });
        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { kategori_getir(); }
        });

    }
    public void kategori_getir() {
        Intent intent = new Intent(this,kategoriEkrani.class);
        startActivity(intent);

    }
    public void kurallar_getir() {
        Intent intent = new Intent(this,kurallarEkrani.class);
        startActivity(intent);

    }

}
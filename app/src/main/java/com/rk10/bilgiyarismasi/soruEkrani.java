package com.rk10.bilgiyarismasi;

import static java.lang.Integer.valueOf;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class soruEkrani extends AppCompatActivity {
    TextView gridData, soru, skorSonucu;
    ImageView imageView;
    RadioGroup radioGroup;
    RadioButton cevapA, cevapB, cevapC, cevapD;

    Button btn_geri, btn_bitir;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_ekrani);

        gridData = findViewById(R.id.KategoriAdi);
        skorSonucu = findViewById(R.id.skor);
        soru = findViewById(R.id.soru_metni);
        imageView = findViewById(R.id.soru_resmi);
        radioGroup = findViewById(R.id.radiogroup);
        cevapA = findViewById(R.id.cevapA);
        cevapB = findViewById(R.id.cevapB);
        cevapC = findViewById(R.id.cevapC);
        cevapD = findViewById(R.id.cevapD);
        btn_bitir = findViewById(R.id.btn_bitir);
        btn_geri = findViewById(R.id.btn_geri);

        Intent intent = getIntent();
        String gelenKategori = intent.getStringExtra("name");
        String gelenSoru = intent.getStringExtra("soru");
        String A = intent.getStringExtra("cevapA");
        String B = intent.getStringExtra("cevapB");
        String C = intent.getStringExtra("cevapC");
        String D = intent.getStringExtra("cevapD");
        int gelenGorsel = intent.getIntExtra("gorsel", 0);
        String dogruSecenek = intent.getStringExtra("dogruSecenek");

        gridData.setText(gelenKategori);
        soru.setText(gelenSoru);
        imageView.setImageResource(gelenGorsel);
        cevapA.setText(A);
        cevapB.setText(B);
        cevapC.setText(C);
        cevapD.setText(D);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String secilenCevap = radioButton.getText().toString();
                int skor = 0;
                if (secilenCevap.equals(dogruSecenek)) {
                    Toast.makeText(soruEkrani.this, "Tebrikler!", Toast.LENGTH_SHORT).show();
                    skor++;
                    skorSonucu.setText(String.valueOf(skor));
                    radioButton.setBackgroundColor(valueOf(Color.GREEN));
                }
            }
        });
        btn_geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategori_getir();
            }
        });
        btn_bitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { anasayfa_getir(); }
        });
    }
    public void kategori_getir() {
        Intent i = new Intent(this, kategoriEkrani.class);
        startActivity(i);
    }
    public void anasayfa_getir(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}


package com.zulfa.androiddasar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBuah extends AppCompatActivity {

    private static final String TAG = "DetailActivity";


    TextView tvnamaBuah;
    ImageView ivgambarbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);

        String namabuah = getIntent().getStringExtra(Konstanta.DATANAMA );
        int gambarbuah = getIntent().getIntExtra(Konstanta.DATAGAMBAR,0);



        //logging menggunakan log


        Log.d(TAG, "Nama: "+ namabuah);
        Log.d(TAG, "Gambar: "+ gambarbuah);


        tvnamaBuah = findViewById(R.id.tv_detail_nama);
        ivgambarbuah = findViewById(R.id.iv_detail_gambar);


        tvnamaBuah.setText(namabuah);
        ivgambarbuah.setImageResource(gambarbuah);
    }
}

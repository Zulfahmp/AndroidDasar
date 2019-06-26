package com.zulfa.androiddasar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MenghitungLuas extends Fragment {

    EditText edSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    private AdView mAdView,mAdView1,mAdView2,mAdView3,mAdView4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menghitung, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        edSisi = view.findViewById(R.id.ed_sisi);
        btnHitung = view.findViewById(R.id.btn_hitung);
        tvHasil = view.findViewById(R.id.tv_hasil);
        spinnerPilihan = view.findViewById(R.id.spinner_pilihan);

        mAdView = view.findViewById(R.id.adView);
        mAdView1 = view.findViewById(R.id.adView1);
        mAdView2 = view.findViewById(R.id.adView2);
        mAdView3 = view.findViewById(R.id.adView3);
        mAdView4 = view.findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView1.loadAd(adRequest);
        mAdView2.loadAd(adRequest);
        mAdView3.loadAd(adRequest);
        mAdView4.loadAd(adRequest);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {

                    //rumusvolume
                    rumusvolume();
                    //ctrl+alt+m
                } else if   (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {

                    //rumuskeliling
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    rumusKeliling(sisi);
                } else if   (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {

                    //rumusluaspermukaan
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double hasil = 6 * sisi * sisi;
                    tvHasil.setText(hasil.toString());
                }
            }
        });

        //data
        //adapter
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, pilihanHitung );
        spinnerPilihan.setAdapter(adapter);
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 12 * sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusvolume() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = sisi * sisi * sisi ;
        tvHasil.setText(hasil.toString());
    }
}

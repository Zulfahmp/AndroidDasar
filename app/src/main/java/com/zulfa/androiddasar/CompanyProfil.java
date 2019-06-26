package com.zulfa.androiddasar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zulfa.androiddasar.Company.Gallery;
import com.zulfa.androiddasar.Company.OurService;
import com.zulfa.androiddasar.Company.Web;

public class CompanyProfil extends Fragment {

    TextView gallery,service,web;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        gallery = view.findViewById(R.id.gallery);
        service = view.findViewById(R.id.service);
        web = view.findViewById(R.id.website);

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gal = new Intent(getContext(), Gallery.class);
                startActivity(gal);
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ser = new Intent(getContext(), OurService.class);
                startActivity(ser);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web = new Intent(getContext(), Web.class);
                startActivity(web);
            }
        });

    }
}

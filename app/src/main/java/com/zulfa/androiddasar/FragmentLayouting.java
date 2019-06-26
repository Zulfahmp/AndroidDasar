package com.zulfa.androiddasar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zulfa.androiddasar.Layouting.Constraint;
import com.zulfa.androiddasar.Layouting.Frame;
import com.zulfa.androiddasar.Layouting.Linear;
import com.zulfa.androiddasar.Layouting.Relativ;
import com.zulfa.androiddasar.Layouting.Scroll;

public class FragmentLayouting extends Fragment {
    Button btnLinear, btnRelative, btnFrame, btnConstraint, btnScroll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layouting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnLinear = view.findViewById(R.id.btn_linear);
        btnRelative = view.findViewById(R.id.btn_relative);
        btnFrame = view.findViewById(R.id.btn_frame);
        btnConstraint = view.findViewById(R.id.btn_constraint);
        btnScroll = view.findViewById(R.id.btn_scroll);

        //langkah 3 boleh dievent handling

        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //       Toast.makeText(MenuActivity.this, "ini Linear", Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent(getContext(), Linear.class);
                startActivity(pindah);
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nama komponen apa = new komponen()
                //context = namaActivity
                AlertDialog.Builder pesan = new AlertDialog.Builder(getContext());
                pesan.setTitle("Alert Dialog");
                pesan.setMessage("ini alert dialog");
                pesan.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Anda Memilih Ok", Toast.LENGTH_SHORT).show();
                        Intent pindah = new Intent(getContext(), Relativ.class);
                        startActivity(pindah);

                    }
                });
                pesan.setNegativeButton("Tidak", null);
                pesan.show();

            }
        });

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getContext(), Frame.class);
                startActivity(pindah);
            }
        });

        btnConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getContext(), Constraint.class);
                startActivity(pindah);
            }
        });

        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(getContext(), Scroll.class);
                startActivity(pindah);
            }
        });
    }
}

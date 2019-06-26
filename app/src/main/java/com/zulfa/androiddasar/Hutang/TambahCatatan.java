package com.zulfa.androiddasar.Hutang;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.zulfa.androiddasar.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahCatatan extends AppCompatActivity {

    EditText edJudul, edJumlah, edTanggal;
    Button btnSimpan;

    RealmHelper realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);

        realm = new RealmHelper(TambahCatatan.this);

        edJudul = findViewById(R.id.ed_judul);
        edJumlah = findViewById(R.id.ed_jumlah);
        edTanggal = findViewById(R.id.ed_tanggal);
        btnSimpan = findViewById(R.id.btn_simpan);

        edTanggal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //date picker

                Calendar calendar = Calendar.getInstance();

                // Date nowDate = calendar.getTime();

                int nowYear = calendar.get(Calendar.YEAR);
                int nowMonth = calendar.get(Calendar.MONTH);
                int nowDay = calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(TambahCatatan.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar cal =  Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        edTanggal.setText(dateformat.format(cal.getTime()));
                    }
                }, nowYear, nowMonth, nowDay);
                dialog.show();




            }


        });


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatatanModel catatan = new CatatanModel();
                catatan.setId((int)realm.getNextId());
                catatan.setJudul(edJudul.getText().toString());
                catatan.setJumlahhutang(edJumlah.getText().toString());
                catatan.setTanggal(edTanggal.getText().toString());

                realm.insertData(catatan);

                finish();


            }
        });

    }
}

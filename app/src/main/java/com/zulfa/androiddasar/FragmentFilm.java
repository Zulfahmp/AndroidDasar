package com.zulfa.androiddasar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zulfa.androiddasar.model.ResponseMovie;
import com.zulfa.androiddasar.model.ResultsItem;
import com.zulfa.androiddasar.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentFilm extends Fragment {

    List<ResultsItem> dataMovie = new ArrayList<>();
    RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recycler = view.findViewById(R.id.recycleview);
        getDataOnline();
        //adapter
        recycler.setAdapter(new MovieAdapter(getContext(), dataMovie));
        //layoutmanager
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    private void getDataOnline() {
        final ProgressDialog progress = new ProgressDialog(getContext());
        progress.setMessage("Silahkan menunggu");
        progress.show();

        Call<ResponseMovie> request = RetrofitConfig.getApiServices().ambilDataMovie("e8b96303b7279f47e4800cfe6733a94d");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                progress.dismiss();


                if (response.isSuccessful()){
                    dataMovie = response.body().getResults();
                    recycler.setAdapter(new MovieAdapter(getContext(), dataMovie));

                } else {
                    Toast.makeText(getContext(), "Request Tidak Diterima", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(getContext(), "Request gagal"+t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();

            }
        });
    }

}

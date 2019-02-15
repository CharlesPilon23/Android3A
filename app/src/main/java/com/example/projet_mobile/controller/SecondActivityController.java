package com.example.projet_mobile.controller;

import android.app.Activity;

import com.example.projet_mobile.data.SpaceAPI;
import com.example.projet_mobile.model.Launches;
import com.example.projet_mobile.presentation.MainActivity;
import com.example.projet_mobile.presentation.SecondActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivityController {

    private SecondActivity secondActivity;

    public SecondActivityController(SecondActivity SecondActivity) {
        this.secondActivity = SecondActivity;
    }

    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/v3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        SpaceAPI spaceAPI = retrofit.create(SpaceAPI.class);

        Call<List<Launches>> call = spaceAPI.getListLaunches();
        call.enqueue(new Callback<List<Launches>>() {
            @Override
            public void onResponse(Call<List<Launches>> call, Response<List<Launches>> response) {
                if(response.isSuccessful()) {
                    List<Launches> changesList = response.body();
                    secondActivity.showList(changesList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Launches>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}

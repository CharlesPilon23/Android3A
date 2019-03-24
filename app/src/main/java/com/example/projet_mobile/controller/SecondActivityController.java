package com.example.projet_mobile.controller;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.projet_mobile.data.SpaceAPI;
import com.example.projet_mobile.model.Launches;
import com.example.projet_mobile.presentation.MainActivity;
import com.example.projet_mobile.presentation.SecondActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Console;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivityController {

    private SecondActivity secondActivity;

    public SecondActivityController(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/v3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(secondActivity);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        SpaceAPI spaceAPI = retrofit.create(SpaceAPI.class);
        Call<List<Launches>> call = spaceAPI.getListLaunches();
        call.enqueue(new Callback<List<Launches>>() {
            @Override
            public void onResponse(Call<List<Launches>> call, Response<List<Launches>> response) {
                if(response.isSuccessful()) {
                    List<Launches> changesList = response.body();
                    secondActivity.showList(changesList);

                    //mise en cache
                    Gson gson = new Gson();
                    String json = gson.toJson(changesList);
                    editor.putString("key_cache", json);
                    editor.apply();

                } else {
                    System.out.println(response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<List<Launches>> call, Throwable t) {
                t.printStackTrace();
                Toast toast = new Toast(secondActivity.getBaseContext());
                toast.makeText(secondActivity, "Can not reach the internet",Toast.LENGTH_LONG).show();

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(secondActivity);
                Gson gson = new Gson();
                String json = prefs.getString("key_cache", null);
                Type type = new TypeToken<List<Console>>() {}.getType();
                List<Launches> changesList = gson.fromJson(json, type);

                secondActivity.showList(changesList);
            }
        });

    }
}
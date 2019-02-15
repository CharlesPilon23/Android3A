package com.example.projet_mobile.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.data.SpaceAPI;
import com.example.projet_mobile.model.Launches;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //lancement de l'API
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
                    showList(changesList);
                    //changesList.forEach(change -> System.out.println(change.subject));
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Launches>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        /*final List<String> input = new ArrayList<>(); //création d'une liste d'inputs
        for (int i = 0; i < 100; i++) {
            input.add("Rocket" + i);
        }
        showList(input);*/

    }



    private void showList(List<Launches> input) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // define an adapter
        mAdapter = new LaunchesAdapter(input);
        recyclerView.setAdapter(mAdapter);


    }

}

package com.example.projet_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        Call<List<Change>> call = spaceAPI.getListLaunches();
        call.enqueue(new Callback<List<Change>>() {
            @Override
            public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {
                if(response.isSuccessful()) {
                    List<Change> changesList = response.body();
                    for (Change change : changesList) {
                        System.out.println(change.subject);
                    }
                    //changesList.forEach(change -> System.out.println(change.subject));
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Change>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        /*final List<String> input = new ArrayList<>(); //création d'une liste d'inputs
        for (int i = 0; i < 100; i++) {
            input.add("Rocket" + i);
        }
        showList(input);*/

    }



    private void showList(List<String> input) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);


    }

}

package com.example.projet_mobile.presentation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.controller.SecondActivityController;
import com.example.projet_mobile.model.Launches;
import com.google.gson.Gson;

import java.util.List;


public class SecondActivity extends AppCompatActivity {

    private SecondActivityController controller;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.imageView);

        controller = new SecondActivityController(this);
        controller.onStart();

    }

    public void showList(List<Launches> input) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // define an adapter
        mAdapter = new LaunchesAdapter(input, this, getLaunchesListener());
        recyclerView.setAdapter(mAdapter);
    }

    private LaunchesAdapter.OnItemClickListener getLaunchesListener() {
        return new LaunchesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Launches item) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                Gson gson = new Gson();
                intent.putExtra("CLE", gson.toJson(item));
                startActivity(intent);
            }
        };
    }

}

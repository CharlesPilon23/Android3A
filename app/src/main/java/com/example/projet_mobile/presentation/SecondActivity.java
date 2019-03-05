package com.example.projet_mobile.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.controller.SecondActivityController;
import com.example.projet_mobile.data.SpaceAPI;
import com.example.projet_mobile.model.Launches;
import com.example.projet_mobile.model.Links;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

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
        mAdapter = new LaunchesAdapter(input, this);
        recyclerView.setAdapter(mAdapter);


    }

}

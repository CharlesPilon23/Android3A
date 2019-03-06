package com.example.projet_mobile.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.controller.DetailActivityController;
import com.example.projet_mobile.controller.SecondActivityController;
import com.example.projet_mobile.model.Launches;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity{
    private DetailActivityController controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);



        String launchesJson = getIntent().getStringExtra("CLE");
        Gson gson = new Gson();

        Launches launches = gson.fromJson(launchesJson, Launches.class);

        controller = new DetailActivityController(this);

    }



}

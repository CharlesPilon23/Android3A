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
import android.widget.TextView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.controller.DetailActivityController;
import com.example.projet_mobile.controller.SecondActivityController;
import com.example.projet_mobile.model.Launches;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity{
    private DetailActivityController controller;

    private TextView nomMission;
    private TextView dateLancement;
    private TextView nomFusee;
    private TextView typeFusee;
    private TextView numeroVol;
    private TextView dateLancementUTC;
    private  TextView details;
    private TextView siteLancement;
    ImageView missionPatch;
    private Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);


        String launchesJson = getIntent().getStringExtra("CLE");
        Gson gson = new Gson();

        final Launches launches = gson.fromJson(launchesJson, Launches.class);

        btn = findViewById(R.id.VideoButton);


        controller = new DetailActivityController(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.watchYoutubeVideo(DetailActivity.this, launches.getLinks().getYoutubeVideo());
            }
        });

        initUI();
        showDetailView(launches);

    }


    private void initUI() {
        nomMission = (TextView) findViewById(R.id.NomMission);
        dateLancement = (TextView) findViewById(R.id.DateLancement);
        nomFusee = (TextView) findViewById(R.id.NomFusee);
        typeFusee = (TextView) findViewById(R.id.TypeFusee);
        numeroVol = (TextView) findViewById(R.id.NumeroVol);
        dateLancementUTC = (TextView) findViewById(R.id.DateLancementUTC);
        details = (TextView) findViewById(R.id.details);
        siteLancement = (TextView) findViewById(R.id.SiteLancement);

        missionPatch = (ImageView) findViewById(R.id.MissionPatch);
    }

    private void showDetailView(Launches launches) {
        nomMission.setText(launches.getMissionName());
        dateLancement.setText(launches.getLaunchYear());
        nomFusee.setText(launches.getRocket().getRocketName());
        typeFusee.setText(launches.getRocket().getRocketType());
        numeroVol.setText(launches.getFlightNumber());
        dateLancementUTC.setText(launches.getLaunchTimeUtc());
        details.setText(launches.getDetails());
        if(launches.getLaunchSite() != null){siteLancement.setText(launches.getLaunchSite().getSiteNameLong());}

        Picasso.with(this).load(launches.getLinks().getMissionPatch()).into(missionPatch);
    }



}

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

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity{
    private DetailActivityController controller;

    private TextView NomMission;
    private TextView DateLancement;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        initUI();
        String launchesJson = getIntent().getStringExtra("CLE");
        Gson gson = new Gson();

        Launches launches = gson.fromJson(launchesJson, Launches.class);

        controller = new DetailActivityController(this);

        showDetailView(launches);


        TextView NomFusee = (TextView) findViewById(R.id.NomFusee);
        NomFusee.setText(launches.getRocket().getRocketName());

       TextView TypeFusee = (TextView) findViewById(R.id.TypeFusee);
        TypeFusee.setText(launches.getRocket().getRocketType());

        TextView NumeroVol = (TextView) findViewById(R.id.NumeroVol);
        NumeroVol.setText(launches.getFlightNumber());

        TextView SiteLancement = (TextView) findViewById(R.id.SiteLancement);
        if(launches.getLaunchSite() != null){
        SiteLancement.setText(launches.getLaunchSite().getSiteNameLong());}

        TextView DateLancementUTC = (TextView) findViewById(R.id.DateLancementUTC);
        DateLancementUTC.setText(launches.getLaunchTimeUtc());

        TextView details = (TextView) findViewById(R.id.details);
        details.setText(launches.getDetails());


    }

    private void showDetailView(Launches launches) {
        NomMission.setText(launches.getMissionName());
        DateLancement.setText(launches.getLaunchYear());

    }

    private void initUI() {
        NomMission = (TextView) findViewById(R.id.NomMission);
        DateLancement = (TextView) findViewById(R.id.DateLancement);

    }


}

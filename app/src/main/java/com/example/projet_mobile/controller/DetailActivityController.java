package com.example.projet_mobile.controller;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.projet_mobile.presentation.DetailActivity;
import com.example.projet_mobile.presentation.MainActivity;

public class DetailActivityController {
    private DetailActivity detailActivity;

    public DetailActivityController (DetailActivity detailActivity){this.detailActivity=detailActivity;}

    public void watchYoutubeVideo(Context context, String link) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        context.startActivity(webIntent);
        }


    }


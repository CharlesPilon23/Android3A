package com.example.projet_mobile.controller;

import android.content.Intent;
import com.example.projet_mobile.presentation.MainActivity;


public class MainActivityController {

    private MainActivity mainActivity;

    public MainActivityController (MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }



    public void onListenButton(){
        mainActivity.startSecondActivity();
    }

    public void onListenMail(){
        //essayer de le remplacer par la vraie fonction mais pb lors de l'instanciation du chooser
        mainActivity.obtenirAide();
    }


}

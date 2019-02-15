package com.example.projet_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Rocket {
    @SerializedName("rocket_name")
    String rocketName;
    @SerializedName("rocket_type")
    String rocketType;


    public String getRocketName() {
        return rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }


    public void setRocketName(String rocketName) {
        rocketName = rocketName;
    }

    public void setRocketType(String rocketType) {
        rocketType = rocketType;
    }
}

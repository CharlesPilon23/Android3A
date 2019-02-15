package com.example.projet_mobile.model;

import com.google.gson.annotations.SerializedName;

public class LaunchSite {

    @SerializedName("site_name_long")
    String siteNameLong;


    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }
}

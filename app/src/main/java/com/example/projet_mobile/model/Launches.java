package com.example.projet_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Launches {

    @SerializedName("flight_number")
    int flightNumber;
    @SerializedName("mission_name")
    String missionName;
    @SerializedName("launch_year")
    String launchYear;
    @SerializedName("launch_date_utc")
    String launchTimeUtc;
    String details;


    private Rocket rocket;
    private LaunchSite launchSite;
    private Links links;


    public String getFlightNumber() {
        return String.valueOf(flightNumber);
    }

    public String getMissionName() {
        return missionName;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public String getLaunchTimeUtc() {
        return launchTimeUtc;
    }

    public String getDetails() {
        return details;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public Links getLinks() {
        return links;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public void setLaunchTimeUtc(String launchTimeUtc) {
        this.launchTimeUtc = launchTimeUtc;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}

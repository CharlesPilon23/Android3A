package com.example.projet_mobile.model;

public class Flight {
    int flight_number;
    String mission_name;
    String launch_year;
    String launch_date_utc;
    String details;



    public int getFlight_number() {
        return flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public String getLaunch_date_utc() {
        return launch_date_utc;
    }

    public String getDetails() {
        return details;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public void setLaunch_date_utc(String launch_date_utc) {
        this.launch_date_utc = launch_date_utc;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

package com.example.projet_mobile;

public class Rocket {

    private String name;
    private String launchDate;
    private int numberOfSatellites;
    private float orbitInKilometers;

    public Rocket(String name, String launchDate, int numberOfSatellites, float orbitInKilometers) {
        this.name = name;
        this.launchDate = launchDate;
        this.numberOfSatellites = numberOfSatellites;
        this.orbitInKilometers = orbitInKilometers;
    }


    public String getName() {
        return name;
    }

    public String getLaunchDate(){return launchDate;}

    public int getNumberOfSatellites() {return numberOfSatellites; }

    public float getOrbitInKilometers() {return orbitInKilometers;}
}

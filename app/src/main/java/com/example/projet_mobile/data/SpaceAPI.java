package com.example.projet_mobile.data;

import com.example.projet_mobile.model.Launches;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceAPI {
    @GET("launches/")
    Call<List<Launches>> getListLaunches();
}

package com.example.projet_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Links {

    @SerializedName("video_link")
    String youtubeVideo;
    @SerializedName("mission_patch")
    String missionPatch;

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }
}

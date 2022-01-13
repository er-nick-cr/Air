package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("daily")
    @Expose
    public Daily daily;

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Daily getDaily() {
        return daily;
    }
}
package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("aqi")
    @Expose
    public int aqi;
    @SerializedName("city")
    @Expose
    public City city;
    @SerializedName("forecast")
    @Expose
    public Forecast forecast;

    public City getCity() {
        return city;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public int getAqi() {
        return aqi;
    }
}
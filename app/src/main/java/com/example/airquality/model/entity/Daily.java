package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {

    @SerializedName("o3")
    @Expose
    public List<Ozone> ozone;
    @SerializedName("uvi")
    @Expose
    public List<Uvi> uvi;

    public void setO3(List<Ozone> o3) {
        this.ozone = o3;
    }

    public List<Ozone> getO3() {
        return ozone;
    }

    public void setUvi(List<Uvi> uvi) {
        this.uvi = uvi;
    }

    public List<Uvi> getUvi() {
        return uvi;
    }
}
package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uvi {
    @SerializedName("avg")
    @Expose
    public int avg;

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getAvg() {
        return avg;
    }
}
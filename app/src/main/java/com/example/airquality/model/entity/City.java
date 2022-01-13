package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("name")
    @Expose
    public String name;

    public void setCity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
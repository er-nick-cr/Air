package com.example.airquality.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("data")
    @Expose
    public Result data;
    @SerializedName("body")
    @Expose
    private String body;

    public Result getData() {
        return data;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
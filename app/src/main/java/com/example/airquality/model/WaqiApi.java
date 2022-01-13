package com.example.airquality.model;

import com.example.airquality.model.entity.Post;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WaqiApi {
        @GET("here/")
        Call<Post> getGeolocalizedPost();

        @GET("{cityName}/")
        Call<Post> getPostWithCityName(@Path("cityName") String cityName);
    }
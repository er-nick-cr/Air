package com.example.airquality;

import com.example.airquality.model.NetworkService;
import com.example.airquality.model.entity.Post;

import retrofit2.Call;


public class AirModel {

    public Call<Post> getPostWithCityName(String cityName) {
        return NetworkService.getInstance().getApi().getPostWithCityName(cityName);
    }

    public Call<Post> getGeolocalizedPost() {
        return NetworkService.getInstance().getApi().getGeolocalizedPost();
    }


}

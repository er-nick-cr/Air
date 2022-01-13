package com.example.airquality;

import android.annotation.SuppressLint;
import android.content.Context;


import androidx.annotation.NonNull;

import com.example.airquality.model.NetworkService;
import com.example.airquality.model.entity.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AirPresenter {

    private final AirView airView;
    private final AirModel model = new AirModel();
    ;
    private final PhraseModel phraseModel;


    public AirPresenter(AirView airView, Context context) {
        this.airView = airView;
        this.phraseModel = new PhraseModel(context);
    }

    public void onAppOpen() {
        model.getGeolocalizedPost().enqueue(new Callback<Post>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                Post post = (Post) response.body();
                assert post != null;

                int airQualityNumber = post.getData().getAqi();
                String city = String.valueOf(post.getData().getCity().getName());
                int uvi = post.getData().getForecast().getDaily().getUvi().get(0).getAvg();
                int o3 = post.getData().getForecast().getDaily().getO3().get(2).getAvg();

                checkPollution(airQualityNumber);

                airView.loadDefaultData(airQualityNumber, city, uvi, o3);
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void onSearchButtonClick(String searchValue) {
        if (searchValue.trim().equals("")) {
            airView.showEmptySearchFieldError();
        } else {
            model.getPostWithCityName(searchValue).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    Post post = (Post) response.body();
                    assert post != null;

                    int airQualityNumber = post.getData().getAqi();
                    String city = String.valueOf(post.getData().getCity().getName());
                    int uvi = post.getData().getForecast().getDaily().getUvi().get(0).getAvg();
                    int o3 = post.getData().getForecast().getDaily().getO3().get(2).getAvg();

                    checkPollution(airQualityNumber);

                    airView.loadDefaultData(airQualityNumber, city, uvi, o3);
                }

                @Override
                public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                    t.printStackTrace();
                    airView.showUpdateDataError();
                }
            });
        }
    }

    private void checkPollution(int pollutionIndex) {
        if (pollutionIndex <= 80) {
            airView.makeGoodBackground(phraseModel.getRandomGood());
        } else if (pollutionIndex > 81 && pollutionIndex <= 170) {
            airView.makeMiddleBackground(phraseModel.getRandomMiddle());
        } else if (pollutionIndex > 171) {
            airView.makeBadBackground(phraseModel.getRandomBad());
        }
    }


}

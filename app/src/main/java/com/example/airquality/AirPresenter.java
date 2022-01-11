package com.example.airquality;

import android.annotation.SuppressLint;
import android.widget.TextView;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AirPresenter {

    private AirView airView;
    PhraseModel phraseModel = new PhraseModel();


    public AirPresenter(AirView airView) {
        this.airView = airView;
    }

    private void checkPollution(int pollutionIndex) {
        if(pollutionIndex <= 80) {
            airView.makeGoodBackground(phraseModel.getRandomGood());
        } else if (pollutionIndex > 81 && pollutionIndex <= 170) {
            airView.makeMiddleBackground(phraseModel.getRandomMiddle());
        } else if (pollutionIndex > 171) {
            airView.makeBadBackground(phraseModel.getRandomBad());
        }
    }



    public void onAppOpen() {
        AirModel.NetworkService.getInstance().getJSONApi().getGeolocalizedPost().enqueue(new Callback<AirModel.Post>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<AirModel.Post> call, @NonNull Response<AirModel.Post> response) {
                AirModel.Post post = (AirModel.Post) response.body();
                assert post != null;



                int airQualityNumber = post.getData().getAqi();
                String city = String.valueOf(post.getData().getCity().getName());
                int uvi = post.getData().getForecast().getDaily().getUvi().get(0).getAvg();
                int o3 = post.getData().getForecast().getDaily().getO3().get(2).getAvg();

                checkPollution(airQualityNumber);

                airView.loadDefaultData(airQualityNumber, city, uvi, o3);
            }

            @Override
            public void onFailure(@NonNull Call<AirModel.Post> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void onSearchButtonClick(String searchValue) {
        if(searchValue.trim().equals("")) {
            airView.showEmptySearchFieldError();
        } else {
            AirModel.NetworkService.getInstance().getJSONApi().getPostWithCityNAme(searchValue).enqueue(new Callback<AirModel.Post>() {
                @Override
                public void onResponse(Call<AirModel.Post> call, Response<AirModel.Post> response) {
                    AirModel.Post post = (AirModel.Post) response.body();
                    assert post != null;

                    int airQualityNumber = post.getData().getAqi();
                    String city = String.valueOf(post.getData().getCity().getName());
                    int uvi = post.getData().getForecast().getDaily().getUvi().get(0).getAvg();
                    int o3 = post.getData().getForecast().getDaily().getO3().get(2).getAvg();

                    checkPollution(airQualityNumber);

                    airView.loadDefaultData(airQualityNumber, city, uvi, o3);
                }

                @Override
                public void onFailure(@NonNull Call<AirModel.Post> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        }



}

package com.example.airquality;

import android.widget.TextView;

public interface AirView {
    void loadDefaultData(int airQualityNumber, String city, int uvi, int o3);
    void showEmptySearchFieldError();
    void showUpdateDataError();
    void makeBadBackground(String phrase);
    void makeMiddleBackground(String phrase);
    void makeGoodBackground(String phrase);
}

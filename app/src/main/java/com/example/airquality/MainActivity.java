package com.example.airquality;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AirView {

    private EditText userCity;
    private TextView airDescription;
    private TextView airQualityNumberText;
    private TextView cityText;
    private TextView o3Text;
    private TextView uviText;
    RelativeLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AirPresenter airPresenter = new AirPresenter(this, this);
        airQualityNumberText = findViewById(R.id.air_quality_number);
        cityText = findViewById(R.id.city);
        o3Text = findViewById(R.id.ozone);
        uviText = findViewById(R.id.uvi);
        userCity = findViewById(R.id.edit_city);
        ImageButton searchButton = findViewById(R.id.search_button);
        airDescription = findViewById(R.id.air_description);
        ImageView cloud1 = findViewById(R.id.cloud1);
        ImageView cloud2 = findViewById(R.id.cloud2);
        ImageView cloud3 = findViewById(R.id.cloud3);
        mainView = findViewById(R.id.main);

        initClouds(cloud1, cloud2, cloud3);

        searchButton.setOnClickListener(v -> airPresenter.onSearchButtonClick(userCity.getText().toString()));

        airPresenter.onAppOpen();
    }

    private void initClouds(@NonNull ImageView cloud1, ImageView cloud2, ImageView cloud3) {
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim1);
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim2);
        cloud1.startAnimation(anim1);
        cloud2.startAnimation(anim2);
        cloud3.startAnimation(anim3);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void loadDefaultData(int airQualityNumber, String city, int uvi, int o3) {
        airQualityNumberText.setText(String.valueOf(airQualityNumber));
        cityText.setText(city);
        uviText.setText("УФ индекс: " + uvi);
        o3Text.setText("Озоновый слой: " + o3);
    }

    @Override
    public void showEmptySearchFieldError() {
        Toast.makeText(MainActivity.this, R.string.city_name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUpdateDataError() {
        Toast.makeText(MainActivity.this, R.string.error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void makeBadBackground(String phrase) {
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradiet_bad);
    }

    @Override
    public void makeMiddleBackground(String phrase) {
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradiet_middle);
    }

    @Override
    public void makeGoodBackground(String phrase) {
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradient_good);
    }
}
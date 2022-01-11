package com.example.airquality;

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

public class MainActivity extends AppCompatActivity implements AirView{

    public EditText userCity;
    public ImageButton searchButton;
    public TextView airDescription;
    private Dialog mDialog;
    public TextView airQualityNumberText;
    public TextView cityText;
    public TextView o3Text;
    public TextView uviText;
    public ImageView cloud1;
    public ImageView cloud2;
    public ImageView cloud3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AirPresenter airPresenter = new AirPresenter(this);
        airQualityNumberText = findViewById(R.id.air_quality_number);
        cityText = findViewById(R.id.city);
        o3Text = findViewById(R.id.ozone);
        uviText = findViewById(R.id.uvi);
        userCity = findViewById(R.id.edit_city);
        searchButton = findViewById(R.id.search_button);
        airDescription = findViewById(R.id.air_description);
        cloud1 = findViewById(R.id.cloud1);
        cloud2 = findViewById(R.id.cloud2);
        cloud3 = findViewById(R.id.cloud3);



        searchButton.setOnClickListener(v -> {
            airPresenter.onSearchButtonClick(userCity.getText().toString());
        });


        airPresenter.onAppOpen();

        Animation anim1;
        Animation anim2;
        Animation anim3;

        anim1 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim1);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.cloud_anim2);
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
        mDialog = new Dialog(this);
        Toast.makeText(MainActivity.this, R.string.city_name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void makeBadBackground(String phrase) {
        RelativeLayout mainView = findViewById(R.id.main);
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradiet_bad);
    }

    @Override
    public void makeMiddleBackground(String phrase) {
        RelativeLayout mainView = findViewById(R.id.main);
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradiet_middle);
    }

    @Override
    public void makeGoodBackground(String phrase) {
        RelativeLayout mainView = findViewById(R.id.main);
        airDescription.setText(phrase);
        mainView.setBackgroundResource(R.drawable.background_gradient_good);
    }
}
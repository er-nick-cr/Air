package com.example.airquality;

import android.content.Context;

public class PhraseModel {

    private Context context;

    private String[] bad;
    private String[] middle;
    private String[] good;

    public PhraseModel(Context context) {
        this.context = context;
        bad = context.getResources().getStringArray(R.array.bad);
        middle = context.getResources().getStringArray(R.array.middle);
        good = context.getResources().getStringArray(R.array.good);
    }

    public String getRandomBad() {
        int s = (int)Math.floor(Math.random() * bad.length);
        return bad[s];
    }

    public String getRandomMiddle() {
        int s = (int)Math.floor(Math.random() * middle.length);
        return middle[s];
    }

    public String getRandomGood() {
        int s = (int)Math.floor(Math.random() * good.length);
        return good[s];
    }
}

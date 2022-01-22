package com.example.geografi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class Karta extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysetting";
    public static final String APP_PREFERENCES_COUNTER = "kartinka";
    private SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karta);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String kartinka = "";

        if (mSettings.contains("kartinka")) {
            // Получаем число из настроек
            kartinka = mSettings.getString("kartinka","");
        }


        SubsamplingScaleImageView im = findViewById(R.id.imageView);
        String mDrawableName = kartinka;
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        im.setImage(ImageSource.resource(resID));

        ImageView ex = findViewById(R.id.imageView4);
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hmn = new Intent(Karta.this,ShablonStr.class);
                hmn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(hmn);
            }
        });
    }
}
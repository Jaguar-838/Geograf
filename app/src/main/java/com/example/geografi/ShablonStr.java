package com.example.geografi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class ShablonStr extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysetting";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shablon_str);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String kartinka = "";
        String taxt ="";
        String title="";
        if (mSettings.contains("kartinka")) {
            // Получаем число из настроек
            kartinka = mSettings.getString("kartinka","");
            taxt = mSettings.getString("taxt","");
            title = mSettings.getString("title","");
        }



        SubsamplingScaleImageView im = findViewById(R.id.imageView);
        String mDrawableName = kartinka;
        int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        im.setImage(ImageSource.resource(resID));

        TextView txt = findViewById(R.id.textView8);
        String mStringName = taxt;
        int resID1 = getResources().getIdentifier(mStringName , "strings", getPackageName());
        txt.setText(resID1);

        TextView tit = findViewById(R.id.textView7);
        String mStringName2 = title;
        int resID2 = getResources().getIdentifier(mStringName2 , "strings", getPackageName());
        tit.setText(resID2);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt = new Intent(ShablonStr.this, Karta.class);
                intt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intt);
            }
        });
    }

    public  void home (View v)
    {
        Intent hmn = new Intent(this,MainActivity.class);
        hmn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(hmn);
    }
}
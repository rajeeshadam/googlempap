package com.task.googlemap;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Rajeesh adambil on 05/02/17
 */
public class SplashSCreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        checkLoginStatus();


    }
    public void checkLoginStatus() {
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                SharedPreferences sharedPref  = getSharedPreferences("LOGIN_STATUS", MODE_PRIVATE);
                if(!sharedPref.getBoolean("STATUS",false)){
                    Intent intentLogin=new Intent(SplashSCreen.this,LoginActivity.class);
                    startActivity(intentLogin);
                    finish();
                }else{
                    Intent intentMap=new Intent(SplashSCreen.this,MapsActivity.class);
                    startActivity(intentMap);
                    finish();
                }
            }

        }, 2000);
    }
}

package com.example.homework2472;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                // Do something after 5s = 5000ms

                Intent intent = new Intent(SplashScreenActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();



            }
        }, 3000);



    }
}
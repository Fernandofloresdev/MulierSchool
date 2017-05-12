package com.fernando.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, LoginActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_TIME);*/
        Intent mainIntent = new Intent().setClass(
                SplashActivity.this, LoginActivity.class);
        startActivity(mainIntent);
    }
}

package com.example.joselara.pizza5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
                    dbHelper db = new dbHelper(this);

            db.clearDatabase();
            getSupportActionBar().hide();

            setContentView(R.layout.activity_main);

            int SPLASH_TIME_OUT = 600;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent next = new Intent(MainActivity.this, page1.class);
                    startActivity(next);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

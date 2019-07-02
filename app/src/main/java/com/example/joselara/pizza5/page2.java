
package com.example.joselara.pizza5;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_page2);

        ImageView takeout = (ImageView) findViewById(R.id.takeoutView);
        ImageView pickup = (ImageView) findViewById(R.id.pickupView);

        takeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page2.this, page3.class);
                startActivity(intent);
            }
        });
        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page2.this, page3.class);
                startActivity(intent);
            }
        });

    }
}

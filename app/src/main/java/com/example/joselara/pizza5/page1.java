package com.example.joselara.pizza5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_page1);

        Button GuestOrder = (Button) findViewById(R.id.btnGuestOrder);
        Button login = findViewById(R.id.loginBtn);
        
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(page1.this, "Feature Under Construction", Toast.LENGTH_SHORT).show();
            }
        });


        GuestOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (page1.this, page2.class);
                startActivity(intent);
            }
        });
    }
}

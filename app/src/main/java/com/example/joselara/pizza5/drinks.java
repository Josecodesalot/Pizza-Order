package com.example.joselara.pizza5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

public class drinks extends AppCompatActivity {

    public ImageView dasaniAdd, cokeAdd, dietCokeAdd, pepsiAdd, drpepAdd, mountainAdd, spriteAdd;
    public dbHelper db = new dbHelper(this);
    public Button menu, pizza, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        getSupportActionBar().hide();


        dasaniAdd=findViewById(R.id.dasaniadd);
        cokeAdd = findViewById(R.id.cokeadd);
        dietCokeAdd=findViewById(R.id.dietcokeadd);
        pepsiAdd = findViewById(R.id.pepsiadd);
        drpepAdd =findViewById(R.id.drpepadd);
        mountainAdd = findViewById(R.id.mountainadd);
        spriteAdd = findViewById(R.id.spriteadd);

        final Intent add = new Intent( drinks.this, cart.class);

        dasaniAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Dasani Bottle","1.25");
                startActivity(add);
            }
        });
        cokeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Coca Cola Can","1.25");
                startActivity(add);
            }
        });
        dietCokeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Diet Coke Can","1.25");
                startActivity(add);
            }
        });
        pepsiAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Pepsi Can","1.25");
                startActivity(add);
            }
        });
        drpepAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Dr. Pepper","1.25");
                startActivity(add);
            }
        });
        mountainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Mountain Dew","1.25");
                startActivity(add);
            }
        });
        spriteAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSide("Sprite Can","1.25");
                startActivity(add);
            }
        });

    }


}

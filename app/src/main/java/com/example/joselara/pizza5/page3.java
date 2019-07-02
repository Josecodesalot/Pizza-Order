package com.example.joselara.pizza5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class page3 extends AppCompatActivity {

    public Button pizzaM, sides, drinks,catering;
    public Button menu, pizza, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_page3);


        pizzaM = findViewById(R.id.pizzaBtn);
        sides = findViewById(R.id.sidesBtn);
        drinks = findViewById(R.id.drinksBtn);
        catering= findViewById(R.id.cateringBtn);

        pizzaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pizza = new Intent(page3.this, toppings.class);
                startActivity(pizza);
            }
        });
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent drinks = new Intent(page3.this, drinks.class);
                startActivity(drinks);
            }
        });
        catering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(page3.this, "Feature Under Construction", Toast.LENGTH_SHORT).show();
            }
        });
        sides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(page3.this, "Feature Under Construction", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

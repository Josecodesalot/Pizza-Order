package com.example.joselara.pizza5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class createpizza extends AppCompatActivity {

    public String cheeseStr, crustStr, sauceStr, sizeStr;
    public Button previous, next;
    public Button menu, pizza, cart;
    public SeekBar size, cheese,crust,sauce;
    public TextView cheeseTxt, crustTxt,sauceTxt, sizeTxt;
    public ImageView pizzaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_createpizza);

        previous = findViewById(R.id.previousBtn);
        next = findViewById(R.id.nextBtn);

        cheese = findViewById(R.id.cheeseSeek);
        sauce = findViewById(R.id.sauceSeek);
        crust = findViewById(R.id.crustSeek);
        size = findViewById(R.id.sizeSeek);

        cheeseTxt=findViewById(R.id.cheeseTxt);
        crustTxt=findViewById(R.id.crustTxt);
        sauceTxt=findViewById(R.id.sauceTxt);
        sizeTxt=findViewById(R.id.sizeText);

        pizzaView=findViewById(R.id.sizeView);




        size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0){
                    pizzaView.setBackgroundResource(R.drawable.bsize);
                    sizeTxt.setText("Baby - 6 Slices");
                    sizeStr = "Baby";

                }
                if (progress==1){
                    pizzaView.setBackgroundResource(R.drawable.ssize);
                    sizeTxt.setText("Small - 8 Slices");
                    sizeStr = "Small";
                }
                if (progress==2){
                    pizzaView.setBackgroundResource(R.drawable.msize);
                    sizeTxt.setText("Medium - 12 Slices");
                    sizeStr = "Medium";
                }
                if (progress==3){
                    pizzaView.setBackgroundResource(R.drawable.lsize);
                    sizeTxt.setText("Large - 16 Slices");
                    sizeStr = "Large";
                }
                if (progress==4){
                    pizzaView.setBackgroundResource(R.drawable.qsize);
                    sizeTxt.setText("Queen - 24 Slices");
                    sizeStr = "Queen";
                }
                if (progress==5){
                    pizzaView.setBackgroundResource(R.drawable.ksize);
                    sizeTxt.setText("King - 32 Slices");
                    sizeStr = "King";
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        cheese.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0){
                    cheeseTxt.setText("No Cheese");
                    cheeseStr = "No Cheese";
                }
                if (progress==1){
                    cheeseTxt.setText("Regular Cheese");
                    cheeseStr ="";
                }
                if (progress==2){
                    cheeseTxt.setText("Extra Cheese");
                    cheeseStr = "Extra Cheese";
                }
                if (progress==3){
                    cheeseTxt.setText("Extra Extra Cheese");
                    cheeseStr = "Extrs Extra Cheese";
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sauce.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    sauceTxt.setText("No Sauce");
                    sauceStr = "No Sauce";
                }
                if (progress == 1) {
                    sauceTxt.setText("Regular Sauce");
                    sauceStr = "";
                }
                if (progress == 2) {
                    sauceTxt.setText("Extra Sauce");
                    sauceStr="Extra Sauce";
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        crust.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    crustTxt.setText("Thin Crust");
                    crustStr = crustTxt.getText().toString();
                }
                if (progress == 1) {
                    crustTxt.setText("Regular Crust");
                    crustStr = "";
                }
                if (progress == 2) {
                    crustTxt.setText("Ticc' Crust");
                    crustStr = crustTxt.getText().toString();
                }

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        size.setProgress(1);
        crust.setProgress(1);
        cheese.setProgress(1);
        sauce.setProgress(1);

        sizeStr="Small";
        cheeseStr="";
        sauceStr="";
        crustStr="";


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous = new Intent(createpizza.this, page3.class);
                startActivity(previous);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(createpizza.this, toppings.class);

                next.putExtra("sizeSeek",sizeStr);
                next.putExtra("crustSeek", crustStr);
                next.putExtra("cheeseSeek", cheeseStr);
                next.putExtra("sauceSeek", sauceStr);

                startActivity(next);
            }
        });

    }



}

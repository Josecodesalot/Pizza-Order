package com.example.joselara.pizza5;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import static java.lang.StrictMath.round;

public class toppings extends AppCompatActivity {

    public Button menu, pizza, cart;

    public Boolean pepBool, hamBool, beefBool, sausBool, bacBool, greenPBool, tomatoBool,blackOlivesBool, olivesBool, mushBool, pineBool, onionBool;

    public Button previous, next;

    //below, number of total items, starting at 0, so if 10 items, the number will be 9.
    public int t = 12;

    public String cheeseStr, crustStr, sauceStr, sizeStr;

    public SeekBar sizeSeek, cheeseSeek, crustSeek, sauceSeek;
    public TextView cheeseTxt, crustTxt,sauceTxt, sizeTxt;
    public ImageView pizzaView;
    public String [] toppingNames = {"Pepperoni", "Ham", "Ground Beef", "Sausage", "Bacon", "Green Peppers", "Tomato",
            "Black Olives", "Green Olives", "Mushrooms", "Pineaples","Onions"};
    public final int pepInt =0, hamInt = 1, beefInt =2, sausInt =3, bacInt=4, gPepInt=5, tomatoInt=6,
            bolivesInt=7, olivesInt =8, mushInt=9, pineInt=10, onionInt=11;
    public int [] multiplier = new int[t];
    public int [] multiplier2 =  new int [t];


    public final int pepNumL=100, hanNumL=101,beefNumL=102,sausNumL=103,bacNumL=104,gPepNumL=105,tomatoNumL=106,bolivesNumL=107,olivesNumL=108,mushNumL=109, pineNumL=110, onionNumL=111;
    public final int pepNum= 200, hanNum= 201,beefNum=202,sausNum=203,bacNum=204,gPepNum=205,tomatoNum=206,bolivesNum=207,olivesNum=208,mushNum=209, pineNum=210, onionNum=211;
    public final int pepNumR=300, hanNumR= 301,beefNumR=102,sausNumR=303,bacNumR=304,gPepNumR=305,tomatoNumR=306,bolivesNumR=307,olivesNumR=308,mushNumR=309, pineNumR=310, onionNumR=311;

    public SeekBar pepSeek, hamSeek, beefSeek, sausSeek, bacSeek, greenPSeek, tomatoSeek,
            blackOlivesSeek, olivesSeek, mushSeek, pineSeek, onionSeek ;

    public ImageView pepView, pepCheck, pepLeftBtn, peprightBtn, pepcentreBtn;
    public ImageView hamView,  hamCheck, hamleftBtn, hamrightBtn, hamcentreBtn;
    public ImageView beefView, beefCheck, beefLeft, beefCentre, beefRight;
    public ImageView sausView, sausCheck, sausLeft, sausCentre, sausRight;
    public ImageView bacView, bacCheck, bacLeft, bacCentre, bacRight;
    public ImageView greenPView, greenPCheck, greenPLeft, greenPCentre, greenPRight;
    public ImageView tomatoView, tomatoCheck, tomatoLeft, tomatoCentre, tomatoRight;
    public ImageView blackOlivesView, blackOlivesCheck, blackOlivesLeft, blackOlivesCentre, blackOlivesRight;
    public ImageView olivesView, olivesCheck,olivesLeft,olivesCentre,olivesRight;
    public ImageView mushView, mushCheck, mushLeft, mushCentre, mushRight;
    public ImageView pineView, pineCheck,pineLeft, pineCentre, pineRight;
    public ImageView onionView, onionCheck, onionLeft, onionCentre, onionRight;
    public Drawable zerotimes, onetimes, twotimes, threetimes, fourtimes;
    public String  sumoftoppings;
    public TextView textView;

   // public int centreTopInt;

    public dbHelper database = new dbHelper(this);
    public Bundle d= new Bundle();

    public double currentnumoftoppings;

    ///uodate!

    public String tb_Toppings [] = {"1","1","1","1","1","1","1","1","1","1","1","1","1",};
    public String tb_Multiplier [] =  new String [t];
    public String  tb_Details [] = new String[8];
    public int tb_States [] = new int [t];

    public int topMultiplier [] = new int [t];
    public int state [] = new int [t];
    public final int OFF=0, LEFT=1, CENTRE=2, RIGHT=3;
    // sum of toppings is the addition of all toppings, respecting the multipliers, and left or right toppings get are worth .5 rather than 1;
    //number of toppings, is the amount of active toppings in the pizza;
    public int numberOfToppings;
    public double sumOfToppings;
    //b represents the number of active toppings;
    public int b;

/**/
    ///

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_toppings);

        Intent get = getIntent();
        d = get.getExtras();
        final dbHelper2 db2=new dbHelper2(this);




    //database.clearDatabase();

        referenceToppings();
        initialize();
        createpizzamethod();

        setupDrawables();
        setSeeksToZero();
        pepperoni();
        ham();
        beef();
        bacon();
        greenPeppers();
        sausage();
        tomatoes();
        blackOlives();
        olives();
        mushrooms();
        pineaples();
        onions();

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous = new Intent(toppings.this, page3.class);
                startActivity(previous);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent (toppings.this, cart.class);


                sumOfToppings=0;
                b=0;
                filterThroughToppings();
//                String populateTextView = populateTestString();

                //textView.setText(populateTextView);

               // next.putExtra("t",t);
               // next.putExtra("names", toppingNames);
                //next.putExtra("sizeSeek", d.getString("sizeSeek"));
               // next.putExtra( "crustSeek",d.getString("crustSeek"));
                //next.putExtra("cheeseSeek",d.getString("cheeseSeek"));
               // next.putExtra("sauceSeek",d.getString("sauceSeek"));'

                setDetails();
                database.addOrder(tb_States,multiplier,tb_Details);
             //   db2.addOrder(tb_Details, tb_Toppings);
                startActivity(next);
            }
        });
        }

    private void createpizzamethod() {
        sizeSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress==0){
                    pizzaView.setImageResource(R.mipmap.bsize);
                    sizeTxt.setText("Baby - 6 Slices");
                    sizeStr = "Baby";

                }
                if (progress==1){
                    pizzaView.setImageResource(R.mipmap.ssize);
                    sizeTxt.setText("Small - 8 Slices");
                    sizeStr = "Small";
                }
                if (progress==2){
                    pizzaView.setImageResource(R.mipmap.msize);
                    sizeTxt.setText("Medium - 12 Slices");
                    sizeStr = "Medium";
                }
                if (progress==3){
                    pizzaView.setImageResource(R.mipmap.lsize);
                    sizeTxt.setText("Large - 16 Slices");
                    sizeStr = "Large";
                }
                if (progress==4){
                    pizzaView.setImageResource(R.mipmap.qsize);
                    sizeTxt.setText("Queen - 24 Slices");
                    sizeStr = "Queen";
                }
                if (progress==5){
                    pizzaView.setImageResource(R.mipmap.ksize);
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

        cheeseSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
                    cheeseStr = "Extra Extra Cheese";
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sauceSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        crustSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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

        sizeSeek.setProgress(1);
        crustSeek.setProgress(1);
        cheeseSeek.setProgress(1);
        sauceSeek.setProgress(1);

        sizeStr="Small";
        cheeseStr="";
        sauceStr="";
        crustStr="";

    }

    public void initialize(){
        for (int i =0;i<t;i++) {
            tb_States [i]=0;
            tb_Toppings [i]="null";
        }
        }

    private void setDetails() {
        tb_Details[0]=sizeStr;
        tb_Details[1]=sauceStr;
        tb_Details[2]=cheeseStr;
        tb_Details[3]=(""+b);
        tb_Details[4]=(""+getPrize());
        tb_Details[5]=("1");
        tb_Details[6]=("pizza");
        tb_Details[7]=crustStr;


    }

    private void filterThroughToppings() {
        for (int i=0; i<t;i++){
            if (state[i]>200&&state[i]<300){
                tb_Toppings[b]= " " + toppingNames[i] + " " + multiplierAdapter(multiplier[i]);
                tb_Multiplier[b] = multiplierAdapter(multiplier[i]);
                tb_States[b]= state[i];
                sumOfToppings+=1.00*multiplier2[i];
                b++;
            }
            if (state[i]>100&&state[i]<200){
                tb_Toppings[b]= " " + toppingNames[i] + " " + multiplierAdapter(multiplier[i]);
                tb_Multiplier[b] = multiplierAdapter(multiplier[i]);
                tb_States[b]= state[i];
                sumOfToppings+=0.50*multiplier2[i];
                b++;
            }
            if (state[i]>300&&state[i]<400){
                tb_Toppings[b]= " " + toppingNames[i] + " " + multiplierAdapter(multiplier[i]);
                tb_Multiplier[b] = multiplierAdapter(multiplier[i]);
                tb_States[b]= state[i];
                sumOfToppings+=0.50*multiplier2[i];
                b++;
            }
        }
        numberOfToppings=b;
        finishAddingToppings(b);
    }

    private void finishAddingToppings(int b) {
        for (int i=b+1; i<t; i++){
            tb_Toppings[i]="";
            tb_Multiplier[i]="";
            tb_States[i]=0;
        }
    }

    private String multiplierAdapter(int i) {
        String adapter="";
        if(i==0){
            adapter=" X0";
        }
        if(i==1){
            adapter="";
        }
        if(i==2){
            adapter="x2";
        }
        if(i==3){
            adapter="x3";
        }
        if(i==4){
            adapter="x4";
        }
        if(i==5){
            adapter="x5";
        }
        if(i==6){
            adapter="x6";
        }
        return adapter;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setSeeksToZero() {
        pepSeek.setProgress(0);  hamSeek.setProgress(0); beefSeek.setProgress(0); sausSeek.setProgress(0); bacSeek.setProgress(0);
        greenPSeek.setProgress(0); tomatoSeek.setProgress(0); blackOlivesSeek.setProgress(0); olivesSeek.setProgress(0); mushSeek.setProgress(0);
        pineSeek.setProgress(0); onionSeek.setProgress(0);

        /*pepSeek.setThumb(zerotimes);  hamSeek.setThumb(zerotimes); beefSeek.setThumb(zerotimes); sausSeek.setThumb(zerotimes); bacSeek.setThumb(zerotimes);
        greenPSeek.setThumb(zerotimes); tomatoSeek.setThumb(zerotimes); blackOlivesSeek.setThumb(zerotimes); olivesSeek.setThumb(zerotimes); mushSeek.setThumb(zerotimes);
        pineSeek.setThumb(zerotimes); onionSeek.setThumb(zerotimes);
*/

        pepSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        pepSeek.setPadding(80,0,78,0);

        hamSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        hamSeek.setPadding(80,0,78,0);

        beefSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        beefSeek.setPadding(80,0,78,0);

        sausSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        sausSeek.setPadding(80,0,78,0);

        bacSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        bacSeek.setPadding(80,0,78,0);

        greenPSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        greenPSeek.setPadding(80,0,78,0);

        tomatoSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        tomatoSeek.setPadding(80,0,78,0);

        blackOlivesSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        blackOlivesSeek.setPadding(80,0,78,0);

        olivesSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        olivesSeek.setPadding(80,0,78,0);

        mushSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        mushSeek.setPadding(80,0,78,0);

        pineSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        pineSeek.setPadding(80,0,78,0);

        onionSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        onionSeek.setPadding(80,0,78,0);



        cheeseSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);

        sauceSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);

        crustSeek.getProgressDrawable().setColorFilter(Color.parseColor("#D9232E"), PorterDuff.Mode.MULTIPLY);
        sizeSeek.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.MULTIPLY);



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupDrawables(){
         zerotimes = (getDrawable(R.drawable.zeroex));
        onetimes = (getDrawable(R.drawable.oneex));
        twotimes = (getDrawable(R.drawable.twoex));
        threetimes = (getDrawable(R.drawable.threeex));
        fourtimes = (getDrawable(R.drawable.fourex));

        pepSeek.setVisibility(View.GONE);
        hamSeek.setVisibility(View.GONE);
        beefSeek.setVisibility(View.GONE);
        sausSeek.setVisibility(View.GONE);
        bacSeek.setVisibility(View.GONE);
        greenPSeek.setVisibility(View.GONE);
        tomatoSeek.setVisibility(View.GONE);
        blackOlivesSeek.setVisibility(View.GONE);
        olivesSeek.setVisibility(View.GONE);
        mushSeek.setVisibility(View.GONE);
        pineSeek.setVisibility(View.GONE);
        onionSeek.setVisibility(View.GONE);

        //setGone(pepSeek,pepLeftBtn,peprightBtn,pepcentreBtn);
        //setGone(hamSeek,hamleftBtn,hamrightBtn,hamcentreBtn);
    }

    private ShapeDrawable lineDra() {
        ShapeDrawable square = new ShapeDrawable();

        square.setShape(new RectShape());
        square.getPaint().setColor(Color.WHITE);
        square.getPaint().setStrokeWidth(1);
        square.getPaint().setStyle(Paint.Style.FILL);
        square.setPadding(0,5,0,5);

        return square;
    }

    @SuppressLint("DefaultLocale")
    private String getPrize() {
        String priceString="";
        double Price =0;

        if (sizeStr.equals("Baby")){
            if (sumOfToppings==0){
                Price=8.85;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price=9.57;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price=10.04;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price=10.61;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price=11.76;
            }
            if (sumOfToppings >4||sumOfToppings>4.5){
                Price=11.76 + (1.00*(sumOfToppings-4));
            }

            if (cheeseStr.equals("Extra Cheese")) {
                Price+=1.50;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=3.00;
            }
        }
        if (sizeStr.equals("Small")){
            if (sumOfToppings==0){
                Price=12.87;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price=14.67;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price=15.75;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price=16.65;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price=17.73;
            }
            if (sumOfToppings>4.0||sumOfToppings>4.5){
                Price=17.73 + (1.25*(sumOfToppings-4));
            }
            if (cheeseStr.equals("Extra Cheese")) {
                Price+=1.75;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=3.50;
            }
        }

        if (sizeStr.equals("Medium")){
            if (sumOfToppings==0){
                Price=18.10;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price=19.60;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price=20.56;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price=21.40;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price=22.45;
            }
            if (sumOfToppings>4||sumOfToppings>4.5){
                Price=22.45 + (1.25*(sumOfToppings-4));
            }
            if (cheeseStr.equals("Extra Cheese")) {
                Price+=2.25;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=4.50;
            }
        }

        if (sizeStr.equals("Large")){
            if (sumOfToppings==0){
                Price=22.75;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price=24.55;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price=25.10;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price=26.10;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price=27.10;
            }
            if (sumOfToppings>4||sumOfToppings>4.5){
                Price=27.10 + (1.25*(sumOfToppings-4));
            }
            if (cheeseStr.equals("Extra Cheese")) {
                Price+=2.25;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=4.50;
            }
        }
        if (sizeStr.equals("Queen")){
            if (sumOfToppings==0){
                Price=31.16;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price=33.70;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price=34.84;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price=36.27;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price=37.55;
            }
            if (sumOfToppings>4||sumOfToppings>4.5){
                Price=37.55 + (2.50*(sumOfToppings-4));
            }
            if (cheeseStr.equals("Extra Cheese")) {
                Price+=3.50;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=7.00;
            }

        }
        if (sizeStr.equals("King")){
            if (sumOfToppings==0){
                Price= 37.85;
            }
            if (sumOfToppings >0 && sumOfToppings<1.5){
                Price= 41.86;
            }
            if (sumOfToppings >1 && sumOfToppings<2.5){
                Price= 42.78;
            }
            if (sumOfToppings >2 && sumOfToppings<3.5){
                Price= 43.80;
            }
            if (sumOfToppings >3 && sumOfToppings<4.5){
                Price= 44.68;
            }
            if (sumOfToppings>4||sumOfToppings>4.5){
                Price= 37.55 + (2.50*(sumOfToppings-4));
            }
            if (cheeseStr.equals("Extra Cheese")) {
                Price+=3.50;

            }
            if (cheeseStr.equals("Extrs Extra Cheese")) {
                Price+=7.00;
            }
        }

        priceString = String.format("%.2f", Price);
        return priceString;
    }


    public void pepperoni() {

        pepSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (pepBool) {
                    if (progress == 0) {
                        pepSeek.setThumb(zerotimes);
                        pepBool=true;
                        pepView.performClick();
                        multiplier[pepInt]=0;
                        state[pepInt]=0;
                        multiplier[pepInt]=0;
                        multiplier2[pepInt]=0;
                    }
                    if (progress == 1) {
                        pepSeek.setThumb(onetimes);
                        multiplier[pepInt]=1;
                        multiplier2[pepInt]=1;
                    }
                    if (progress == 2) {
                        pepSeek.setThumb(twotimes);
                        multiplier[pepInt]=2001;
                        multiplier2[pepInt]=2;
                    }
                    if (progress == 3) {
                        pepSeek.setThumb(threetimes);
                        multiplier[pepInt]=3001;
                        multiplier2[pepInt]=3;
                    }
                    if (progress == 4) {
                        pepSeek.setThumb(fourtimes);
                        multiplier[pepInt]=4001;
                        multiplier2[pepInt]=4;
                    }
                    }else{
                    pepSeek.setProgress(0);
                    pepSeek.setThumb(zerotimes);
                    multiplier[pepInt]=0;
                    multiplier2[pepInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        pepView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pepBool) {
                    pepBool = false;
                    pepView.setImageResource(R.drawable.pepoff);
                    pepSeek.setProgress(0);
                    state[pepInt] = 0;
                    if (hamBool) {
                        pepSeek.setVisibility(View.INVISIBLE);
                    } else {
                        pepSeek.setVisibility(View.GONE);
                    }

                }else {
                    pepBool = true;
                    pepSeek.setProgress(1);
                    pepView.setImageResource(R.drawable.pepon);
                    state[pepInt] = 201;
                    pepSeek.setVisibility(View.VISIBLE);
                    if (!hamBool) {
                        hamSeek.setVisibility(View.INVISIBLE);
                    }


                    }


            }
        });

        pepLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pepBool) {
                    pepView.setImageResource(R.drawable.pepleft);
                    state[pepInt]=101;
                }
            }
        });
        peprightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pepBool) {
                    pepView.setImageResource(R.drawable.pepright);
                    state[pepInt]=301;
                }
            }
        });
        pepcentreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pepBool) {
                    pepView.setImageResource(R.drawable.pepon);
                    state[pepInt]=201;
                }
            }
        });
    }

    public void ham(){
        hamSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (hamBool) {
                    if (progress == 0) {
                        hamSeek.setThumb(zerotimes);
                        hamView.performClick();
                        multiplier[hamInt]=0;
                        multiplier2[hamInt]=0;

                    }
                    if (progress == 1) {
                        hamSeek.setThumb(onetimes);
                        multiplier[hamInt]=1002;
                        multiplier2[hamInt]=1;
                    }
                    if (progress == 2) {
                        hamSeek.setThumb(twotimes);
                        multiplier[hamInt]=2002;
                        multiplier2[hamInt]=2;
                    }
                    if (progress == 3) {
                        hamSeek.setThumb(threetimes);
                        multiplier[hamInt]=3002;
                        multiplier2[hamInt]=3;
                    }
                    if (progress == 4) {
                        hamSeek.setThumb(fourtimes);
                        multiplier[hamInt]=4002;
                        multiplier2[hamInt]=4;
                    }
                } else {
                    hamSeek.setProgress(0);
                    hamSeek.setThumb(zerotimes);
                    multiplier[hamInt]=0;
                    multiplier2[hamInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        hamView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hamBool) {
                    hamBool = false;
                    hamView.setImageResource(R.drawable.hamoff);
                    hamSeek.setProgress(0);
                    state[hamInt] = OFF;
                    hamSeek.setVisibility(View.VISIBLE);
                    if (pepBool) {
                        hamSeek.setVisibility(View.INVISIBLE);
                    } else {
                        hamSeek.setVisibility(View.GONE); }
                } else {
                    if (!pepBool) {
                        pepSeek.setVisibility(View.INVISIBLE);
                    }
                    hamBool = true;
                    hamView.setImageResource(R.drawable.hamon);
                    hamSeek.setProgress(1);
                    state[hamInt] = 202;
                    hamSeek.setVisibility(View.VISIBLE);

                }
            }
        });


        hamcentreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hamBool) {
                    hamView.setImageResource(R.drawable.hamon);
                    state[hamInt]=202;
                }
            }
        });
        hamleftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hamBool) {
                    hamView.setImageResource(R.drawable.hamleft);
                    state[hamInt]=102;
                }
            }
        });
        hamrightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hamBool) {
                    hamView.setImageResource(R.drawable.hamright);
                    state[hamInt]=302;
                }
            }
        });


    }

    public void beef(){
        beefSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (beefBool) {
                    if (progress == 0) {
                        beefSeek.setThumb(zerotimes);
                        beefView.performClick();
                        state[beefInt]=0;
                        multiplier[beefInt]=0;
                        multiplier2[beefInt]=0;
                    }
                    if (progress == 1) {
                        beefSeek.setThumb(onetimes);
                        multiplier[beefInt]=1003;
                        multiplier2[beefInt]=1;
                    }
                    if (progress == 2) {
                        beefSeek.setThumb(twotimes);
                        multiplier[beefInt]=2003;
                        multiplier2[beefInt]=2;
                    }
                    if (progress == 3) {
                        beefSeek.setThumb(threetimes);
                        multiplier[beefInt]=3003;
                        multiplier2[beefInt]=3;
                    }
                    if (progress == 4) {
                        beefSeek.setThumb(fourtimes);
                        multiplier[beefInt]=4003;
                        multiplier2[beefInt]=4;
                    }
                } else {
                    beefSeek.setProgress(0);
                    beefSeek.setThumb(zerotimes);
                    multiplier[beefInt]=0;
                    multiplier2[beefInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        beefView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (beefBool) {
                    beefBool = false;
                    beefView.setImageResource(R.drawable.beefoff);
                    beefSeek.setProgress(0);
                    state[beefInt]=0;
                    if (sausBool){
                        beefSeek.setVisibility(View.INVISIBLE);
                    }else{
                        beefSeek.setVisibility(View.GONE);
                    }

                } else {
                    beefBool = true;
                    beefView.setImageResource(R.drawable.beefon);
                    beefSeek.setProgress(1);
                    state[beefInt]=203;
                    beefSeek.setVisibility(View.VISIBLE);
                    if (!sausBool){
                        sausSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        beefLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beefBool) {
                    beefView.setImageResource(R.drawable.beefleft);
                    state[beefInt]=103;
                }
            }
        });
        beefRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beefBool) {
                    beefView.setImageResource(R.drawable.beefright);
                    state[beefInt]=303;
                }
            }
        });
        beefCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beefBool) {
                    beefView.setImageResource(R.drawable.beefon);
                    state[beefInt]=203;
                }
            }
        });




    }
    public void sausage(){
        sausSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (sausBool) {
                    if (progress == 0) {
                        sausSeek.setThumb(zerotimes);
                        sausView.performClick();
                        multiplier[sausInt]=0;
                        multiplier2[sausInt]=0;
                    }
                    if (progress == 1) {
                        sausSeek.setThumb(onetimes);
                        multiplier[sausInt]=1004;
                        multiplier2[sausInt]=1;
                    }
                    if (progress == 2) {
                        sausSeek.setThumb(twotimes);
                        multiplier[sausInt]=2004;
                        multiplier2[sausInt]=2;
                    }
                    if (progress == 3) {
                        sausSeek.setThumb(threetimes);
                        multiplier[sausInt]=3004;
                        multiplier2[sausInt]=3;
                    }
                    if (progress == 4) {
                        sausSeek.setThumb(fourtimes);
                        multiplier[sausInt]=4004;
                        multiplier2[sausInt]=4;
                    }
                } else {
                    sausSeek.setProgress(0);
                    sausSeek.setThumb(zerotimes);
                    multiplier[sausInt]=0;
                    multiplier2[sausInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sausView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sausBool) {

                    sausBool = false;
                    sausView.setImageResource(R.drawable.sausageoff);
                    sausSeek.setProgress(0);
                    state[sausInt]=OFF;
                    sausSeek.setVisibility(View.VISIBLE);
                    if (beefBool){
                        sausSeek.setVisibility(View.INVISIBLE);
                    }else{
                        sausSeek.setVisibility(View.GONE);
                    }

                } else {

                    sausBool = true;
                    sausView.setImageResource(R.drawable.sausageon);
                    sausSeek.setProgress(1);
                    state[sausInt]=204;
                    sausSeek.setVisibility(View.VISIBLE);
                    if (!beefBool){
                        beefSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        sausLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sausBool) {
                    sausView.setImageResource(R.drawable.sausageleft);
                    state[sausInt]=104;
                }
            }
        });
        sausCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sausBool) {
                    sausView.setImageResource(R.drawable.sausageon);
                    state[sausInt]=204;
                }
            }
        });
        sausRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sausBool) {
                    sausView.setImageResource(R.drawable.sausageright);
                    state[sausInt]=304;
                }
            }
        });



    }
    public void bacon(){
        bacSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (bacBool) {
                    if (progress == 0) {
                        bacSeek.setThumb(zerotimes);
                        bacView.performClick();
                        multiplier[bacInt]=0;
                        multiplier2[bacInt]=0;
                    }
                    if (progress == 1) {
                        bacSeek.setThumb(onetimes);
                        multiplier[bacInt]=1005;
                        multiplier2[bacInt]=1;
                    }
                    if (progress == 2) {
                        bacSeek.setThumb(twotimes);
                        multiplier[bacInt]=2005;
                        multiplier2[bacInt]=2;
                    }
                    if (progress == 3) {
                        bacSeek.setThumb(threetimes);
                        multiplier[bacInt]=3005;
                        multiplier2[bacInt]=3;
                    }
                    if (progress == 4) {
                        bacSeek.setThumb(fourtimes);
                        multiplier[bacInt]=4005;
                        multiplier2[bacInt]=4;
                    }
                } else {
                    bacSeek.setProgress(0);
                    bacSeek.setThumb(zerotimes);
                    multiplier[bacInt]=0;
                    multiplier2[bacInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bacView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bacBool) {
                    bacBool = false;
                    bacView.setImageResource(R.drawable.baconoff);
                    bacSeek.setProgress(0);
                    state[bacInt]=OFF;
                    if (greenPBool){
                        bacSeek.setVisibility(View.INVISIBLE);
                    }else{
                        bacSeek.setVisibility(View.GONE);
                    }
                } else {
                    bacBool = true;
                    bacView.setImageResource(R.drawable.baconon);
                    bacSeek.setProgress(1);
                    state[bacInt]=205;
                    bacSeek.setVisibility(View.VISIBLE);
                    if (!greenPBool){
                        greenPSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        bacLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bacBool) {
                    bacView.setImageResource(R.drawable.baconleft);
                    state[bacInt]=105;

                }
            }
        });
        bacRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bacBool) {
                    bacView.setImageResource(R.drawable.baconright);
                    state[bacInt]=305;
                }
            }
        });
        bacCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bacBool) {
                    bacView.setImageResource(R.drawable.baconon);
                    state[bacInt]=205;
                }
            }
        });
    }


    public void greenPeppers (){
        greenPSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (greenPBool) {
                    if (progress == 0) {
                        greenPSeek.setThumb(zerotimes);
                        greenPView.performClick();
                        multiplier[gPepInt]=0;
                        multiplier2[gPepInt]=0;
                    }
                    if (progress == 1) {
                        greenPSeek.setThumb(onetimes);
                        multiplier[gPepInt]=1006;
                        multiplier2[gPepInt]=1;
                    }
                    if (progress == 2) {
                        greenPSeek.setThumb(twotimes);
                        multiplier[gPepInt]=2006;
                        multiplier2[gPepInt]=2;
                    }
                    if (progress == 3) {
                        greenPSeek.setThumb(threetimes);
                        multiplier[gPepInt]=3006;
                        multiplier2[gPepInt]=3;
                    }
                    if (progress == 4) {
                        greenPSeek.setThumb(fourtimes);
                        multiplier[gPepInt]=4006;
                        multiplier2[gPepInt]=4;
                    }
                } else {
                    greenPSeek.setProgress(0);
                    greenPSeek.setThumb(zerotimes);
                    multiplier[gPepInt]=0;
                    multiplier2[gPepInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        greenPView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (greenPBool) {

                    greenPBool = false;
                    greenPView.setImageResource(R.drawable.greenpepoff);
                    greenPSeek.setProgress(0);
                    state[gPepInt]=OFF;
                    if (bacBool){
                        greenPSeek.setVisibility(View.INVISIBLE);
                    }else{
                        greenPSeek.setVisibility(View.GONE);
                    }
                } else {
                    greenPBool = true;
                    greenPView.setImageResource(R.drawable.greenpepon);
                    greenPSeek.setProgress(1);
                    state[gPepInt]=206;
                    greenPSeek.setVisibility(View.VISIBLE);
                    if (!bacBool){
                        bacSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        greenPLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greenPBool) {
                    greenPView.setImageResource(R.drawable.greenpepleft);
                    state[gPepInt]=106;
                }
            }
        });
        greenPCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greenPBool) {
                    greenPView.setImageResource(R.drawable.greenpepon);
                    state[gPepInt]=206;
                }
            }
        });
        greenPRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greenPBool) {
                    greenPView.setImageResource(R.drawable.greenpepright);
                    state[gPepInt]=306;
                }
            }
        });

    }
    public void  tomatoes (){
        tomatoSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (tomatoBool) {
                    if (progress == 0) {
                        tomatoSeek.setThumb(zerotimes);
                        tomatoView.performClick();
                        multiplier[tomatoInt]=0;
                        multiplier2[tomatoInt]=0;
                    }
                    if (progress == 1) {
                        tomatoSeek.setThumb(onetimes);
                        multiplier[tomatoInt]=1007;
                        multiplier2[tomatoInt]=1;
                    }
                    if (progress == 2) {
                        tomatoSeek.setThumb(twotimes);
                        multiplier[tomatoInt]=2007;
                        multiplier2[tomatoInt]=2;
                    }
                    if (progress == 3) {
                        tomatoSeek.setThumb(threetimes);
                        multiplier[tomatoInt]=3007;
                        multiplier2[tomatoInt]=3;
                    }
                    if (progress == 4) {
                        tomatoSeek.setThumb(fourtimes);
                        multiplier[tomatoInt]=4007;
                        multiplier2[tomatoInt]=4;
                    }
                } else {
                    tomatoSeek.setProgress(0);
                    tomatoSeek.setThumb(zerotimes);
                    multiplier[tomatoInt]=0;
                    multiplier2[tomatoInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tomatoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tomatoBool) {

                    tomatoBool = false;
                    tomatoView.setImageResource(R.drawable.tomatoof);
                    tomatoSeek.setProgress(0);
                    state[tomatoInt]=OFF;

                    if (blackOlivesBool){
                        tomatoSeek.setVisibility(View.INVISIBLE);
                    }else{
                        tomatoSeek.setVisibility(View.GONE);
                    }
                } else {

                    tomatoBool = true;
                    tomatoView.setImageResource(R.drawable.tomatoon);
                    tomatoSeek.setProgress(1);
                    state[tomatoInt]=207;
                    tomatoSeek.setVisibility(View.VISIBLE);
                    if (!blackOlivesBool){
                        blackOlivesSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        tomatoLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tomatoBool) {
                    tomatoView.setImageResource(R.drawable.tomatoleft);
                    state[tomatoInt]=107;
                }
            }
        });
        tomatoRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tomatoBool) {
                    tomatoView.setImageResource(R.drawable.tomatoright);
                    state[tomatoInt]=307;
                }
            }
        });
        tomatoCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tomatoBool) {
                    tomatoView.setImageResource(R.drawable.tomatoon);
                    state[tomatoInt]=207;
                }
            }
        });

    }
    public void blackOlives(){
        blackOlivesSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (blackOlivesBool) {
                    if (progress == 0) {
                        blackOlivesSeek.setThumb(zerotimes);
                        blackOlivesView.performClick();
                        multiplier[bolivesInt]=0;
                        multiplier2[bolivesInt]=0;
                    }
                    if (progress == 1) {
                        blackOlivesSeek.setThumb(onetimes);
                        multiplier[bolivesInt]=1008;
                        multiplier2[bolivesInt]=1;
                    }
                    if (progress == 2) {
                        blackOlivesSeek.setThumb(twotimes);
                        multiplier[bolivesInt]=2008;
                        multiplier2[bolivesInt]=2;
                    }
                    if (progress == 3) {
                        blackOlivesSeek.setThumb(threetimes);
                        multiplier[bolivesInt]=3008;
                        multiplier2[bolivesInt]=3;
                    }
                    if (progress == 4) {
                        blackOlivesSeek.setThumb(fourtimes);
                        multiplier[bolivesInt]=4008;
                        multiplier2[bolivesInt]=4;
                    }
                } else {
                    blackOlivesSeek.setProgress(0);
                    blackOlivesSeek.setThumb(zerotimes);
                    multiplier[bolivesInt]=0;
                    multiplier2[bolivesInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blackOlivesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (blackOlivesBool) {


                    blackOlivesBool = false;
                    blackOlivesView.setImageResource(R.drawable.blackolivesoff);
                    blackOlivesSeek.setProgress(0);
                    state[bolivesInt]=OFF;
                    if (tomatoBool){
                        blackOlivesSeek.setVisibility(View.INVISIBLE);
                    }else{
                        blackOlivesSeek.setVisibility(View.GONE);
                    }
                } else {

                    blackOlivesBool = true;
                    blackOlivesView.setImageResource(R.drawable.blackoliveson);
                    blackOlivesSeek.setProgress(1);
                    state[bolivesInt]=208;
                    blackOlivesSeek.setVisibility(View.VISIBLE);
                    if (!tomatoBool){
                        tomatoSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        blackOlivesLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blackOlivesBool) {
                    blackOlivesView.setImageResource(R.drawable.blackolivesleft);
                    state[bolivesInt]=108;
                }
            }
        });
        blackOlivesRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blackOlivesBool) {
                    blackOlivesView.setImageResource(R.drawable.blackoliveright);
                    state[bolivesInt]=308;
                }
            }
        });
        blackOlivesCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blackOlivesBool) {
                    blackOlivesView.setImageResource(R.drawable.blackoliveson);
                    state[bolivesInt]=208;
                }
            }
        });
    }
    public void olives (){
        olivesSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (olivesBool) {
                    if (progress == 0) {
                        olivesSeek.setThumb(zerotimes);
                        olivesView.performClick();
                        multiplier[olivesInt]=0;
                        multiplier2[olivesInt]=0;
                    }
                    if (progress == 1) {
                        olivesSeek.setThumb(onetimes);
                        multiplier[olivesInt]=1009;
                        multiplier2[olivesInt]=1;
                    }
                    if (progress == 2) {
                        olivesSeek.setThumb(twotimes);
                        multiplier[olivesInt]=2009;
                        multiplier2[olivesInt]=2;
                    }
                    if (progress == 3) {
                        olivesSeek.setThumb(threetimes);
                        multiplier[olivesInt]=3009;
                        multiplier2[olivesInt]=3;
                    }
                    if (progress == 4) {
                        olivesSeek.setThumb(fourtimes);
                        multiplier[olivesInt]=4009;
                        multiplier2[olivesInt]=4;
                    }
                } else {
                    olivesSeek.setProgress(0);
                    olivesSeek.setThumb(zerotimes);
                    multiplier[olivesInt]=0;
                    multiplier2[olivesInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        olivesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (olivesBool) {
                    olivesBool = false;
                    olivesView.setImageResource(R.drawable.olivesoff);
                    olivesSeek.setProgress(0);
                    state[olivesInt]=OFF;
                    if (mushBool){
                        olivesSeek.setVisibility(View.INVISIBLE);
                    }else{
                        olivesSeek.setVisibility(View.GONE);
                    }

                } else {
                    olivesBool = true;
                    olivesView.setImageResource(R.drawable.oliveson);
                    olivesSeek.setProgress(1);
                    state[olivesInt]=209;
                    olivesSeek.setVisibility(View.VISIBLE);
                    if (!mushBool){
                        mushSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        olivesLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (olivesBool) {
                    olivesView.setImageResource(R.drawable.olivesleft);
                    state[olivesInt]=109;                }
            }
        });
        olivesRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (olivesBool) {
                    olivesView.setImageResource(R.drawable.olivesright);
                    state[olivesInt]=309;
                }
            }
        });
        olivesCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (olivesBool) {
                    olivesView.setImageResource(R.drawable.oliveson);
                    state[olivesInt]=209;
                }
            }
        });
    }

    public void mushrooms(){
        mushSeek
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        if (mushBool) {
                            if (progress == 0) {
                                mushSeek.setThumb(zerotimes);
                                mushView.performClick();
                                multiplier[mushInt]=0;
                                multiplier2[mushInt]=0;
                            }
                            if (progress == 1) {
                                mushSeek.setThumb(onetimes);
                                multiplier[mushInt]=1010;
                                multiplier2[mushInt]=1;
                            }
                            if (progress == 2) {
                                mushSeek.setThumb(twotimes);
                                multiplier[mushInt]=2010;
                                multiplier2[mushInt]=2;
                            }
                            if (progress == 3) {
                                mushSeek.setThumb(threetimes);
                                multiplier[mushInt]=3010;
                                multiplier2[mushInt]=3;
                            }
                            if (progress == 4) {
                                mushSeek.setThumb(fourtimes);
                                multiplier[mushInt]=4010;
                                multiplier2[mushInt]=4;
                            }
                        } else {
                            mushSeek.setProgress(0);
                            mushSeek.setThumb(zerotimes);
                            multiplier[mushInt]=0;
                            multiplier2[mushInt]=0;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
        mushView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mushBool) {
                    mushBool = false;
                    mushView.setImageResource(R.drawable.mushoff);
                    mushSeek.setProgress(0);
                    state[mushInt]=OFF;
                    if (olivesBool){
                        mushSeek.setVisibility(View.INVISIBLE);
                    }else{
                        mushSeek.setVisibility(View.GONE);
                    }
                } else {
                    mushBool = true;
                    mushView.setImageResource(R.drawable.mushon);
                    mushSeek.setProgress(1);
                    state[mushInt]=210;
                    mushSeek.setVisibility(View.VISIBLE);
                    if (!olivesBool){
                        olivesSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        mushLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mushBool) {
                    mushView.setImageResource(R.drawable.mushleft);
                    state[mushInt]=110;
                }
            }
        });
        mushRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mushBool) {
                    mushView.setImageResource(R.drawable.mushright);
                    state[mushInt]=310;
                }
            }
        });
        mushCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mushBool) {
                    mushView.setImageResource(R.drawable.mushon);
                    state[mushInt]=210;
                }
            }
        });
    }
    public void  pineaples (){
        pineSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (pineBool) {
                    if (progress == 0) {
                        pineSeek.setThumb(zerotimes);
                        pineView.performClick();
                        multiplier[pineInt]=0;
                        multiplier2[pineInt]=0;
                    }
                    if (progress == 1) {
                        pineSeek.setThumb(onetimes);
                        multiplier[pineInt]=1011;
                        multiplier2[pineInt]=1;
                    }
                    if (progress == 2) {
                        pineSeek.setThumb(twotimes);
                        multiplier[pineInt]=2011;
                        multiplier2[pineInt]=2;
                    }
                    if (progress == 3) {
                        pineSeek.setThumb(threetimes);
                        multiplier[pineInt]=3011;
                        multiplier2[pineInt]=3;
                    }
                    if (progress == 4) {
                        pineSeek.setThumb(fourtimes);
                        multiplier[pineInt]=4011;
                        multiplier2[pineInt]=4;
                    }
                } else {
                    pineSeek.setProgress(0);
                    pineSeek.setThumb(zerotimes);
                    multiplier[pineInt]=0;
                    multiplier2[pineInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        pineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pineBool) {

                    pineBool = false;
                    pineView.setImageResource(R.drawable.pineappleoff);
                    pineSeek.setProgress(0);
                    state[pineInt]=OFF;
                    if (onionBool){
                        pineSeek.setVisibility(View.INVISIBLE);
                    }else{
                        pineSeek.setVisibility(View.GONE);
                    }

                } else {

                    pineBool = true;
                    pineView.setImageResource(R.drawable.pineappleon);
                    pineSeek.setProgress(1);
                    state[pineInt]=211;
                    pineSeek.setVisibility(View.VISIBLE);
                    if (!onionBool){
                        onionSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        pineLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pineBool) {
                    pineView.setImageResource(R.drawable.pineappleleft);
                    state[pineInt]=111;
                }
            }
        });
        pineRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pineBool) {
                    pineView.setImageResource(R.drawable.pineappleright);
                    state[pineInt]=311;
                }
            }
        });
        pineCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pineBool) {
                    pineView.setImageResource(R.drawable.pineappleon);
                    state[pineInt]=211;
                }
            }
        });
    }
    public void onions (){
        onionSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (onionBool) {
                    if (progress == 0) {
                        onionSeek.setThumb(zerotimes);
                        onionView.performClick();
                        multiplier[onionInt]=0;
                        multiplier2[onionInt]=0;
                    }
                    if (progress == 1) {
                        onionSeek.setThumb(onetimes);
                        multiplier[onionInt]=1012;
                        multiplier2[onionInt]=1;
                    }
                    if (progress == 2) {
                        onionSeek.setThumb(twotimes);
                        multiplier[onionInt]=2012;
                        multiplier2[onionInt]=2;
                    }
                    if (progress == 3) {
                        onionSeek.setThumb(threetimes);
                        multiplier[onionInt]=3012;
                        multiplier2[onionInt]=3;
                    }
                    if (progress == 4) {
                        onionSeek.setThumb(fourtimes);
                        multiplier[onionInt]=4012;
                        multiplier2[onionInt]=4;
                    }
                } else {
                    onionSeek.setProgress(0);
                    onionSeek.setThumb(zerotimes);
                    multiplier[onionInt]=0;
                    multiplier2[onionInt]=0;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        onionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onionBool) {


                    onionBool = false;
                    onionView.setImageResource(R.drawable.onionoff);
                    onionSeek.setProgress(0);
                    state[onionInt]=OFF;
                    if (pineBool){
                        onionSeek.setVisibility(View.INVISIBLE);
                    }else{
                        onionSeek.setVisibility(View.GONE);
                    }
                } else {

                    onionBool = true;
                    onionView.setImageResource(R.drawable.onionon);
                    onionSeek.setProgress(1);
                    state[onionInt]=212;
                    onionSeek.setVisibility(View.VISIBLE);
                    if (!pineBool){
                        pineSeek.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        onionLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onionBool) {
                    onionView.setImageResource(R.drawable.onionleft);
                    state[onionInt]=112;
                }
            }
        });
        onionRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onionBool) {
                    onionView.setImageResource(R.drawable.onionright);
                    state[onionInt]=312;
                }
            }
        });
        onionCentre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onionBool) {
                    onionView.setImageResource(R.drawable.onionon);
                    state[onionInt]=212;
                }
            }
        });
    }
    private void referenceToppings() {
        pepSeek = findViewById(R.id.pepSeek);
       // pepCheck = findViewById(R.id.pepcheck);
        pepView = findViewById(R.id.pepView);
        pepLeftBtn = findViewById(R.id.pepleft);
        pepcentreBtn = findViewById(R.id.pepcentre);
        peprightBtn = findViewById(R.id.pepright);
        pepBool = false;


        //ham = 1
        hamSeek = findViewById(R.id.hamseek);
        //hamCheck = findViewById(R.id.hamcheck);
        hamView = findViewById(R.id.hamView);
        hamleftBtn = findViewById(R.id.hamleft);
        hamrightBtn = findViewById(R.id.hamright);
        hamcentreBtn = findViewById(R.id.hamcentre);
        hamBool = false;

        //beef = 2
        beefSeek = findViewById(R.id.beefSeek);
        beefView = findViewById(R.id.beefView);
      //  beefCheck= findViewById(R.id.beefcheck);
        beefLeft= findViewById(R.id.beefLeft);
        beefCentre= findViewById(R.id.beefCentre);
        beefRight= findViewById(R.id.beefRight);
        beefBool =false;

        //sausage = 3
        sausSeek =findViewById(R.id.sausSeek);
        sausView= findViewById(R.id.sausageView);
      //  sausCheck= findViewById(R.id.sausCheck);
        sausLeft = findViewById(R.id.sausleft);
        sausCentre= findViewById(R.id.sauscentre);
        sausRight= findViewById(R.id.sausRight);
        sausBool = false;

        //bac = 4
        bacSeek =findViewById(R.id.bacseek);
        bacView= findViewById(R.id.baconView);
     //   bacCheck= findViewById(R.id.baccheck);
        bacLeft= findViewById(R.id.bacleft);
        bacCentre= findViewById(R.id.baccentre);
        bacRight= findViewById(R.id.bacright);
        bacBool = false;

        greenPSeek = findViewById(R.id.greenPSeek);
        greenPView= findViewById(R.id.greenpepView);
     //   greenPCheck= findViewById(R.id.greeenpepcheck);
        greenPLeft= findViewById(R.id.greenpepleft);
        greenPCentre= findViewById(R.id.greeenpepcentre);
        greenPRight = findViewById(R.id.greenpepright);
        greenPBool = false;

        tomatoSeek = findViewById(R.id.tomatoSeek);
        tomatoView= findViewById(R.id.tomatoView);
      //  tomatoCheck= findViewById(R.id.tomatoCheck);
        tomatoLeft= findViewById(R.id.tomatoLeft);
        tomatoCentre= findViewById(R.id.tomatoCentre);
        tomatoRight= findViewById(R.id.tomatoRight);
        tomatoBool= false;

        blackOlivesSeek = findViewById(R.id.blackOliveSeek);
        blackOlivesView = findViewById(R.id.blackOliveView);
       // blackOlivesCheck= findViewById(R.id.blackOliveCheck);
        blackOlivesLeft= findViewById(R.id.blackOlivesLeft);
        blackOlivesCentre = findViewById(R.id.blackOlivesCentre);
        blackOlivesRight = findViewById(R.id.blackOlivesRight);
        blackOlivesBool = false;

        olivesSeek = findViewById(R.id.olivesSeek);
        olivesView= findViewById(R.id.olivesView);
   //     olivesCheck= findViewById(R.id.olivesCheck);
        olivesLeft= findViewById(R.id.olivesleft);
        olivesCentre= findViewById(R.id.olivesCentre);
        olivesRight= findViewById(R.id.olivesRight);
        olivesBool = false;

        mushSeek = findViewById(R.id.mushSeek);
        mushView= findViewById(R.id.mushView);
   //     mushCheck= findViewById(R.id.mushCheck);
        mushLeft= findViewById(R.id.mushleft);
        mushCentre= findViewById(R.id.mushcentre);
        mushRight= findViewById(R.id.mushRight);
        mushBool= false;

        pineSeek = findViewById(R.id.pineappleSeek);
        pineView= findViewById(R.id.pineapleView);
    //    pineCheck= findViewById(R.id.pineapleCheck);
        pineLeft= findViewById(R.id.pineapleLeft);
        pineCentre= findViewById(R.id.pineapleCentre);
        pineRight= findViewById(R.id.pineapleRight);
        pineBool = false;

        onionSeek = findViewById(R.id.onionSeek);
        onionView= findViewById(R.id.onionView);
   //     onionCheck= findViewById(R.id.onionCheck);
        onionLeft= findViewById(R.id.onionLeft);
        onionCentre= findViewById(R.id.onionCentre);
        onionRight= findViewById(R.id.onionRight);
        onionBool = false;

        textView =  findViewById(R.id.textView);
        previous= findViewById(R.id.previousBtn);
        next = findViewById(R.id.nextBtn);

        cheeseSeek = findViewById(R.id.cheeseSeek);
        sauceSeek = findViewById(R.id.sauceSeek);
        crustSeek = findViewById(R.id.crustSeek);
        sizeSeek = findViewById(R.id.sizeSeek);

        cheeseTxt=findViewById(R.id.cheeseTxt);
        crustTxt=findViewById(R.id.crustTxt);
        sauceTxt=findViewById(R.id.sauceTxt);
        sizeTxt=findViewById(R.id.sizeText);

        pizzaView=findViewById(R.id.sizeView);
    }
    public void setInvisible(SeekBar a, ImageView b, ImageView c, ImageView d){
        a.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        c.setVisibility(View.INVISIBLE);
        d.setVisibility(View.INVISIBLE);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        a.setLayoutParams(layoutParams);
        b.setLayoutParams(layoutParams);
        c.setLayoutParams(layoutParams);
        d.setLayoutParams(layoutParams);
    }
    public void setGone(SeekBar a, ImageView b, ImageView c, ImageView d){
        a.setVisibility(View.GONE);
        b.setVisibility(View.GONE);
        c.setVisibility(View.GONE);
        d.setVisibility(View.GONE);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        a.setLayoutParams(layoutParams);
        b.setLayoutParams(layoutParams);
        c.setLayoutParams(layoutParams);
        d.setLayoutParams(layoutParams);
            }
    public void setVisible(SeekBar a, ImageView b, ImageView c, ImageView d){
        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
        c.setVisibility(View.VISIBLE);
        d.setVisibility(View.VISIBLE);
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        a.setLayoutParams(layoutParams);
        b.setLayoutParams(layoutParams);
        c.setLayoutParams(layoutParams);
        d.setLayoutParams(layoutParams);
    }


}


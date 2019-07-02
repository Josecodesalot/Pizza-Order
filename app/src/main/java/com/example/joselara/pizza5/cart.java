package com.example.joselara.pizza5;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import static android.app.PendingIntent.getActivity;
import static java.security.AccessController.getContext;

public class cart extends AppCompatActivity {
    public LinearLayout.LayoutParams LayoutForOrder;
    public Boolean pizza = true;
    public dbHelper db;
    public int NumberOfOrders, NumberOfPizzas, numberOfToppings;
    public final int pepInt = 0, hamInt = 1, beefInt = 2, sausInt = 3, bacInt = 4, gPepInt = 5, tomatoInt = 6,
            bolivesInt = 7, olivesInt = 8, mushInt = 9, pineInt = 10, onionInt = 11;
    public final int OFF = 0, LEFT = 1, CENTRE = 2, RIGHT = 3;
    public TextView subtotalTxt, grandtotalTxt, gstTxt;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        LinearLayout L = findViewById(R.id.hey);
        db = new dbHelper(this);

        subtotalTxt = findViewById(R.id.subTotalNumber);
        grandtotalTxt = findViewById(R.id.grandtotalNumber);
        gstTxt = findViewById(R.id.gstNumber);

        populateTotal();
        if (db.CountRows() == 0) {
            populateTotal();
        } else {
            for (int i = 0; i < db.CountRows(); i++) {
                L.addView(orderDetailL(i, db.getItemType(i)));
            }
        }
       L.addView(addCreditCardInput());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private TableLayout addCreditCardInput(){


            TableLayout item = new TableLayout(this);
            item.setBackground(square());
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30, 25, 30, 25);
            item.setPadding(30,30,30,30);

            TableRow row0 = new TableRow(this);
            row0.addView(creditCartTitleTextView());
            item.setLayoutParams(params);
            TableRow row1 = new TableRow(this);
            row1.addView(nameTextView());
            TableRow row2 = new TableRow(this);
            row2.addView(nameEditText());
            TableRow row3 = new TableRow(this);
            row3.addView(adressTextView());
            TableRow row4 = new TableRow(this);
            row4.addView(addressEditText());
            TableRow row5 = new TableRow(this);
            row5.addView(cardNumberTextView());
            TableRow row6 = new TableRow(this);
            row6.addView(cardMumberEditText());
            TableRow row7 = new TableRow(this);
            row7.addView(expDateTextView());
            row7.addView(CVVTextView());
            TableRow row8 = new TableRow(this);
            row8.addView(expDateEditText());
            row8.addView(CVVEdditText());
            TableRow row9 = new TableRow(this);
            row9.addView(sumbitButton ());

            TableLayout.LayoutParams params1 = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            row9.setLayoutParams(params1);

            item.addView(row0);
            item.addView(row1);
            item.addView(row2);
            item.addView(row3);
            item.addView(row4);
            item.addView(row5);
            item.addView(row6);
            item.addView(row7);
            item.addView(row8);
            item.addView(row9);


        return item;
    }

    private TextView creditCartTitleTextView() {
        TextView name = new TextView(this);
        name.setText("PAYMENT");
        name.setTextColor(Color.parseColor("#FFFFFF"));

        name.setTextSize(20);

        TableRow.LayoutParams params = new TableRow.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT|CENTRE, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 20, 0, 80);

        name.setLayoutParams(params);

        return name;
}

    private Button sumbitButton() {
        Button name = new Button(this);
        name.setText("Submit");


        TableRow.LayoutParams params = new TableRow.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 20, 50, 20);

        name.setLayoutParams(params);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(cart.this, "Payment Gate Under Construction", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return name;

    }

    private EditText CVVEdditText() {
        final EditText name = new EditText(this);
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setHintTextColor(Color.parseColor("#A9A9A9"));

        name.setTextSize(16);
        String tempString="CVV CODE";


        final SpannableString spanString = new SpannableString(tempString);
        spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
       // spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
        spanString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spanString.length(), 0);
        name.setHint(spanString);

        TableRow.LayoutParams params = new TableRow.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        //name.setGravity(Gravity.CENTER_VERTICAL);
        name.setLayoutParams(params);

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    name.setHint("");
                }else{
                    name.setHint("CVV");
                }
            }
        });

        return name;

    }

    private EditText expDateEditText() {
        EditText name = new EditText(this);
        name.setHint("12/19");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setHintTextColor(Color.parseColor("#A9A9A9"));
        name.setTextSize(16);
        return  name;
    }

    private TextView CVVTextView() {
        TextView name = new TextView(this);
        name.setText("CVV");
        name.setTextColor(Color.parseColor("#FFFFFF"));

        name.setTextSize(16);

        return name;
    }

    private TextView expDateTextView() {
        TextView name = new TextView(this);
        name.setText("Exp. Date");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setTextSize(16);

        return name;
    }

    private EditText cardMumberEditText() {
        final EditText name = new EditText(this);
        name.setHint("5555 5555 5555 5555");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setHintTextColor(Color.parseColor("#A9A9A9"));
        name.setTextSize(16);
        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    name.setHint("");
                }else{
                    name.setHint("1234-5678-9101-1121");
                }
            }
        });


        return name;
    }

    private TextView cardNumberTextView() {
        TextView name = new TextView(this);
        name.setText("Card Number");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setTextSize(16);

        return name;
    }

    private EditText addressEditText() {
        final EditText name = new EditText(this);

        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setHintTextColor(Color.parseColor("#A9A9A9"));
        name.setTextSize(16);

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    name.setHint("");
                }else{
                    name.setHint("123 Street Av");
                }
            }
        });

        return name;
    }

    private TextView adressTextView() {
        TextView name = new TextView(this);
        name.setText("Adress");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setTextSize(16);

        return name;
    }


    private EditText nameEditText() {

        final EditText name = new EditText(this);
        name.setHint("Name as it appears on the Card");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setHintTextColor(Color.parseColor("#A9A9A9"));
        name.setTextSize(16);

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    name.setHint("");
                }else{
                    name.setHint("Name as it appears on the card");
                }
            }
        });

        return name;
    }

    private TextView nameTextView() {
        TextView name = new TextView(this);
        name.setText("Name");
        name.setTextColor(Color.parseColor("#FFFFFF"));
        name.setTextSize(16);

        return name;
    }

    private void populateTotal(){
        DecimalFormat f = new DecimalFormat("##.00");
        subtotalTxt.setText("$  "+  f.format(db.subTotal()));
        grandtotalTxt.setText("$  "+f.format(db.grandTotal()));
        gstTxt.setText("$  " + f.format(db.GST()));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private LinearLayout orderDetailL(int i, String itemType) {
        LinearLayout item = new LinearLayout(this);
        item.setId(i);
        item.setOrientation(LinearLayout.VERTICAL);
        item.setBackground(square());
        TextView error = new TextView(this);
        error.setText("error");
        error.setTextColor(Color.parseColor("#FFFFFF"));

        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        paramss.setMargins(30, 25, 30, 25);
        item.setLayoutParams(paramss);

        if (itemType.equals("pizza")){
            item.addView(pizzaTitle(i));
            item.addView(pizzaDescription(i));
            item.addView(pizzaToppings(i));

           // item.addView(price(i));
        }else
            item.addView(addSide(i,itemType,db.getPrice(i)));
            item.addView(price(i));
            return item;
    }


    private LinearLayout addSide(int i, String itemType, String price) {
        LinearLayout horTop =  new LinearLayout(this);
        horTop.setId(i);
        horTop.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        paramss.setMargins(35, 35, 15, 20);
        horTop.setLayoutParams(paramss);
        horTop.addView(sideView(i, itemType));
        horTop.addView(sideTitle(i, itemType));
        return  horTop;
    }

    private TextView sideTitle(int i, String itemType) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText(db.getItemType(i));
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(20);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(15, 0, 0, 0);
        title.setGravity(Gravity.CENTER_VERTICAL);
        title.setLayoutParams(params);
        return title;

    }

    private ImageView sideView(int i, String itemType) {
        ImageView toppingView = new ImageView(this);
        toppingView.setId(i);
        toppingView.setAdjustViewBounds(true);
        toppingView.setMaxHeight(100);

        if (itemType.equals("Dasani Bottle")){
            toppingView.setImageResource(R.mipmap.dasani);
        }
        if (itemType.equals("Coca Cola Can")){
            toppingView.setImageResource(R.mipmap.coke);
        }
        if (itemType.equals("Diet Coke Can")){
            toppingView.setImageResource(R.mipmap.dietcoke);
        }
        if (itemType.equals("Pepsi Can")){
            toppingView.setImageResource(R.drawable.pepsi);
        }
        if (itemType.equals("Dr. Pepper")){
            toppingView.setImageResource(R.mipmap.drpepper);
        }
        if (itemType.equals("Mountain Dew")){
            toppingView.setImageResource(R.drawable.mountandew);
        }
        if (itemType.equals("Sprite Can")){
            toppingView.setImageResource(R.mipmap.sprite);
        }
        return toppingView;
    }

    private TextView price(int i) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText("$ " +db.getPrice(i));
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(20);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 20, 50, 20);
        title.setPadding(0,0,0,0);
        title.setLayoutParams(params);
        title.setGravity(Gravity.END);
        return title;
    }

    private LinearLayout pizzaToppings(int i) {
        LinearLayout vertTop = new LinearLayout(this);
        vertTop.setId(i);
        vertTop.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        paramss.setMargins(15, 10, 10, 35);
        vertTop.setLayoutParams(paramss);
        for (int a=0; a<Integer.parseInt(db.getNumberOfToppings(i));a++){
            vertTop.addView(oneTopping(i,a));
        }

        return vertTop;
    }

    private LinearLayout oneTopping(int i, int b) {
        LinearLayout horTop =  new LinearLayout(this);
        horTop.setId(i);
        horTop.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        paramss.setMargins(15, 7, 15, 7);
        horTop.setLayoutParams(paramss);
        horTop.addView(topImage(i,b));
        horTop.addView(topName(i,b));
        return  horTop;
    }

    private TextView topName(int i, int b) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText(db.getToppingNames(db.toppingNameAr(i),i)[b]);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(20);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(15, 0, 0, 0);
        title.setGravity(Gravity.CENTER_VERTICAL);
        title.setLayoutParams(params);
        return title;
    }

    private ImageView topImage(int i, int b) {
        ImageView toppingView = new ImageView(this);
        toppingView.setId(i);
        toppingView.setAdjustViewBounds(true);
        toppingView.setMaxHeight(100);
        toppingView.setImageResource(db.getImageSrc(db.toppingNameAr(i)[b]));
        return toppingView;
    }

    private TextView pizzaDescription(int i) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText(db.getPizzaDetails(i));
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(18);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(40, 0, 0, 40);
        title.setLayoutParams(params);
        return title;
    }

    private TextView pizzaTitle(int i) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText(db.getPizaTitleName(i));
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(20);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 15, 0, 20);
        title.setLayoutParams(params);
        title.setGravity(Gravity.CENTER_HORIZONTAL);
        return title;
    }
    private ShapeDrawable square () {
        ShapeDrawable square = new ShapeDrawable();

        square.setShape(new RectShape());
        square.getPaint().setColor(Color.WHITE);
        square.getPaint().setStrokeWidth(12);
        square.getPaint().setStyle(Paint.Style.STROKE);


        return square;
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(cart.this, page3.class));
        finish();

    }
    }

    /*@RequiresApi(ap
}i = Build.VERSION_CODES.JELLY_BEAN)
    public LinearLayout orders(int i) {
        LinearLayout cart = new LinearLayout(this);
        cart.setId(i);
        cart.addView(populatePizza(i));

        return cart;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private LinearLayout populatePizza(int i) {
        //make an if gate, to prevent your pizza chart to become out of sync, so that when peple who order non pizza items, this method is not activated
        LinearLayout definition = new LinearLayout(this);
        definition.setOrientation(LinearLayout.VERTICAL);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(35, 30, 35, 30);
        definition.setLayoutParams(params);

      //  definition.setBackground(square());

        definition.addView(pizzaTitle(i));

        int a = numberOfToppings; // db.getListOfToppings(i).sizeSeek();
        for (int b = 0; b < a; b++) {
            LinearLayout topping = new LinearLayout(this);
            topping.setOrientation(LinearLayout.HORIZONTAL);
            topping.setId(b);

            LinearLayout.LayoutParams paramss = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT);
            paramss.setMargins(10, 10, 10, 10);
            topping.setLayoutParams(paramss);

            topping.addView(imageOfTopping(i, b));

            topping.addView(toppingName(i, b));



            definition.addView(topping);

        }

        //definition.addView(Ordernotes(i));
        definition.addView(price(i));

        return definition;
    }

    private TextView toppingName(int orderNumber, int b) {

        //  db.getListOfToppings(orderNumber).get(b);
        TextView nameofTopping = new TextView(this);
        nameofTopping.setId(b);
        // nameofTopping.setText(db.getListOfToppings(orderNumber).get(b));
        nameofTopping.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 20, 0, 20);
        nameofTopping.setLayoutParams(params);

        return nameofTopping;

    }

    private ImageView imageOfTopping(int orderNumber, int b) {


        ImageView toppingView = new ImageView(this);
        toppingView.setId(b);
        toppingView.setAdjustViewBounds(true);
        toppingView.setMaxHeight(100);
      ////  toppingView.setImageResource(getToppingImageResource(orderNumber, b));

        return toppingView;

    }

    private TextView pizzaTitle(int i) {
        TextView title = new TextView(this);
        title.setId(i);
        title.setText(db.getPizaTitleName(i));
        title.setTextColor(Color.parseColor("#FFFFFF"));
        title.setTextSize(20);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 20, 0, 20);
        title.setLayoutParams(params);


        return title;
    }

    private TextView price(int i) {
        TextView prive = new TextView(this);
        prive.setId(i);
        prive.setTextColor(Color.parseColor("#FFFFFF"));
        if (i == 0) {
            prive.setText("costs 0");
        }
        if (i == 1) {
            prive.setText("costs 1");
        }
        if (i == 2) {
            prive.setText("costs 2");
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 20, 30, 20);
        prive.setLayoutParams(params);

        return prive;
    }

    private TextView Ordernotes(int i) {
        TextView notes = new TextView(this);
        notes.setText("These are the notes ");
        notes.setTextColor(Color.parseColor("#FFFFFF"));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 20, 30, 20);
        notes.setLayoutParams(params);
        return notes;
    }

    private String getToppingName(int b) {
        String het = "";
        if (b == 0) {
            het = "Topping Name 0";
        }
        if (b == 01) {
            het = "topping name 1";
        }
        if (b == 2) {
            het = " Topping name 2";
        }
        if (b == 3) {
            het = "Topping name 3";
        }
        return het;
    }
}

   /* private int getToppingImageResource(int i, int b) {
        int  topping ; //db.getToppingsInt(db.getListOfToppings(i)).get(b);
        //ArrayList <Integer>states = db.getStateList(i);



      //  int state= states.get(b);

        if (topping == pepInt) {
            if (state == CENTRE) {
                return R.drawable.pepon;
            }
            if (state == LEFT) {
                return R.drawable.pepleft;
            }
            if (state == RIGHT) {
                return R.drawable.pepright;
            }
        }
        if (topping == hamInt) {
            if (state == CENTRE) {
                return R.drawable.hamon;
            }
            if (state == LEFT) {
                return R.drawable.hamleft;
            }
            if (state == RIGHT) {
                return R.drawable.hamright;
            }
        }
        if (topping == beefInt) {
            if (state == CENTRE) {
                return R.drawable.beefon;
            }
            if (state == LEFT) {
                return R.drawable.beefleft;
            }
            if (state == RIGHT) {
                return R.drawable.beefright;
            }
        }
        if (topping == sausInt) {
            if (state == CENTRE) {
                return R.drawable.sausageon;
            }
            if (state == LEFT) {
                return R.drawable.sausageleft;
            }
            if (state == RIGHT) {
                return R.drawable.sausageright;
            }
        }
        if (topping == bacInt) {
            if (state == CENTRE) {
                return R.drawable.baconon;
            }
            if (state == LEFT) {
                return R.drawable.baconleft;
            }
            if (state == RIGHT) {
                return R.drawable.baconright;
            }
        }
        if (topping == gPepInt) {
            if (state == CENTRE) {
                return R.drawable.greenpepon;
            }
            if (state == LEFT) {
                return R.drawable.greenpepleft;
            }
            if (state == RIGHT) {
                return R.drawable.greenpepright;
            }
        }
        if (topping == tomatoInt) {
            if (state == CENTRE) {
                return R.drawable.tomatoon;
            }
            if (state == LEFT) {
                return R.drawable.tomatoleft;
            }
            if (state == RIGHT) {
                return R.drawable.tomatoright;
            }
        }
        if (topping == bolivesInt) {
            if (state == CENTRE) {
                return R.drawable.blackoliveson;
            }
            if (state == LEFT) {
                return R.drawable.blackolivesleft;
            }
            if (state == RIGHT) {
                return R.drawable.blackoliveright;
            }
        }
        if (topping == olivesInt) {
            if (state == CENTRE) {
                return R.drawable.oliveson;
            }
            if (state == LEFT) {
                return R.drawable.olivesright;
            }
            if (state == RIGHT) {
                return R.drawable.olivesright;
            }
        }
        if (topping == mushInt) {
            if (state == CENTRE) {
                return R.drawable.mushon;
            }
            if (state == LEFT) {
                return R.drawable.mushleft;
            }
            if (state == RIGHT) {
                return R.drawable.mushright;
            }
        }
        if (topping == pineInt) {
            if (state == CENTRE) {
                return R.drawable.pineappleon;
            }
            if (state == LEFT) {
                return R.drawable.pineappleleft;
            }
            if (state == RIGHT) {
                return R.drawable.pineappleright;
            }
        }
        if (topping == onionInt) {
            if (state == CENTRE) {
                return R.drawable.onionon;
            }
            if (state == LEFT) {
                return R.drawable.onionleft;
            }
            if (state == RIGHT) {
                return R.drawable.onionright;
            }
        }
        return R.drawable.brocon;
    }


        private int getnumberOfPizzas () {
            int hey;
            hey = NumberOfPizzas;
            return hey;
        }

        private String getPizaTitleName ( int i){
            String Title = "   This is the Title";
            //add a way by which title gets the sizeSeek of the "i" number of pizza in the database
            return Title;
        }
        private ShapeDrawable square () {
            ShapeDrawable square = new ShapeDrawable();

            square.setShape(new RectShape());
            square.getPaint().setColor(Color.WHITE);
            square.getPaint().setStrokeWidth(7);
            square.getPaint().setStyle(Paint.Style.STROKE);


            return square;
        }
        private TextView toppingCost ( int i){
            TextView price = new TextView(this);
            price.setTextSize(20);
            price.setId(i);

            price.setTextColor(Color.parseColor("#FFFFFF"));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 20, 30, 20);

            price.setText(getPrice(i));
            price.setLayoutParams(params);

            return price;
        }

        private String getPrice ( int i){
            String price = "   price is  1     ";
            return price;
        }
    }
*/
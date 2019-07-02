package com.example.joselara.pizza5;

import android.content.Context;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class carttest1 extends AppCompatActivity {
    public dbHelper db = new dbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carttest1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


         db = new dbHelper(this);
        //dbHelper2 db2 = new dbHelper2(this);
        TextView hey = findViewById(R.id.text1);
        TextView hey2 = findViewById(R.id.text2);
        //hey.setText(db2.dbToString() + " " +db2.CountRows() );
        String This = "hre";
        LinearLayout add= findViewById(R.id.add);

        for (int i = 0; i<db.CountRows();i++){
            add.addView(textViewTest(i));
            add.addView(textViewTest2(i));
            add.addView(toppingsPopulate(i, db.getNumberOfToppings(i)));
            add.addView(price(i));

            This= " The following is the pizza " + db.getCrust(i) + " "+
                    db.getCheese(i) + " "+ db.getPrice(i) + " "+
                    db.getSauce(i) + " ";

        }
        hey.setText(This);
    }

    private LinearLayout toppingsPopulate(int i, String numberOfToppings) {
        LinearLayout L = new LinearLayout(this);
        L.setId(i);
        L.setOrientation(LinearLayout.HORIZONTAL);
        for (int a=0; a<Integer.parseInt(db.getNumberOfToppings(i));a++){
            L.addView(textViewTopping(i,a));
            L.addView(imageTopping(i,a));
        }
        return L;
    }

    private ImageView imageTopping(int i, int a) {
        ImageView img = new ImageView(this);
        img.setId(a);
        img.setImageResource(db.getImageSrc(db.toppingNameAr(i)[a]));
        img.setMaxHeight(50);

        return  img;
    }

    private TextView textViewTopping(int i, int a) {
        TextView txt = new TextView(this);
        txt.setId(a);
        txt.setText(db.getToppingNames(db.toppingNameAr(i), i)[a]);

        return txt;
    }


    private TextView price(int i) {
    TextView hey = new TextView(this);
    hey.setId(i);
    hey.setText(db.getPrice(i)+"\n");
    return hey;
    }

    private TextView textViewTest3(int i, String numberOfToppings) {
        TextView hey = new TextView(this);
        hey.setId(i*199);


        StringBuilder thereturn= new StringBuilder();
        for (int a = 0; a < Integer.parseInt(numberOfToppings); a++) {
        thereturn.append(db.getToppingNames(db.toppingNameAr(i), i)[a]);
        }

        hey.setText(thereturn.toString());
        return  hey;
    }

    private TextView textViewTest2(int i) {
        TextView hey = new TextView(this);
        hey.setId(i*199);
        hey.setText(db.getPizaTitleName(i));
        return  hey;
    }

    private TextView textViewTest(int i) {
        TextView hey = new TextView(this);

        hey.setText("topping code "+db.getNumberOfToppings(i));
        return  hey;
    }


}

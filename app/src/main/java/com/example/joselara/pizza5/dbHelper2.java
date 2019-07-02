package com.example.joselara.pizza5;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.res.TypedArrayUtils;

import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.ArrayList;

public class dbHelper2 extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "wowow.db";
    private static final String IDU1 = "_id";
    private static final String IDU2 = "_id";
    private static final String IDU3 = "_id";
    //table 1pizza
    private static final String TB_ORDER_DETAILS = "PIZZA";
    private static final String COL0 = "crust";
    private static final String COL1 = "size";
    private static final int SIZE = 101;
    private static final String COL2 = "sauce";
    private static final int SAUCE = 102;
    private static final String COL3 = "cheese";
    private static final int CHEESE = 103;
    private static final String COL4 = "toppings";
    private static final int TOPPINGS = 104;
    private static final String COL5 = "price";
    private static final int PRICE = 105;
    private static final String COL6 = "multiplier";
    private static final int MULTIPLIER = 106;
    private static final String COL7 = "product_Id";
    private static final int PRODUCTID = 107;

    private static final String TOP1 = "ONE";
    //  private static final int PRODUCTID= 101;
    private static final String TOP2 = "TWO";
    //   private static final int PRODUCTID= 101;
    private static final String TOP3 = "THREE";
    //   private static final int PRODUCTID= 101;
    private static final String TOP4 = "FOUR";
    //    private static final int PRODUCTID= 101;
    private static final String TOP5 = "FIVE";
//    private static final int PRODUCTID= 101;

    private static final String TOP6 = "SIX";
    //    private static final int PRODUCTID= 101;
    private static final String TOP7 = "SEVEN";
    //    private static final int PRODUCTID= 101;
    private static final String TOP8 = "EIGHT";
    //    private static final int PRODUCTID= 101;
    private static final String TOP9 = "NINE";
    //    private static final int PRODUCTID= 101;
    private static final String TOP10 = "TEN";
    //    private static final int PRODUCTID= 101;
    private static final String TOP11 = "ELEVEN";
    //    private static final int PRODUCTID= 101;
    private static final String TOP12 = "totoo";
//    private static final int PRODUCTID= 101;

    private static final String STATE1 = "ONEa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE2 = "TWOa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE3 = "THREEa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE4 = "FOURa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE5 = "FIVEa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE6 = "SIXa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE7 = "SEVENa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE8 = "EIGHTa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE9 = "NINEa";
    //   private static final int PRODUCTID= 101;
    private static final String STATE10 = "TENa";
    //   private static final int PRODUCTID= 101;
    private static final String STATE11 = "ELEVENa";
    //    private static final int PRODUCTID= 101;
    private static final String STATE12 = "TWELVEa";
//    private static final int PRODUCTID= 101;

    //table 2
    private static final String TB_TOPPINGS = "TOPPINGS";

    //table 3
    private static final String TB_STATES = "PizzaState";


    public dbHelper2(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLE1
        String table1 = "CREATE TABLE " + TB_ORDER_DETAILS + " (" +
                IDU1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL0 + " TEXT," +
                COL1 + " TEXT, " + COL2 + " TEXT, " + COL3 + " TEXT, " +
                COL4 + " TEXT, " + COL5 + " TEXT, " +
                COL6 + " TEXT," + COL7 + " TEXT, " +
                /*TOP1 + " TEXT, " + TOP2 + " TEXT, " + TOP3 + " TEXT, " +
                TOP4 + " TEXT, " + TOP5 + " TEXT, " +
                TOP6 + " TEXT, " + TOP7 + " TEXT, " + TOP8 + " TEXT, " +
                TOP9 + " TEXT, " + TOP10 + " TEXT, " + TOP11 +
                " TEXT, " + TOP12 + " TEXT, " +
                */
                STATE1 + " INTEGER, " + STATE2 + " INTEGER, " + STATE3 + " INTEGER, " +
                STATE4 + " INTEGER, " + STATE5 + " INTEGER, " + STATE6 + " INTEGER, " +
                STATE7 + " INTEGER, " + STATE8 + " INTEGER, " + STATE9 + " INTEGER, " +
                STATE10 + " INTEGER, " + STATE11 + " INTEGER, " + STATE12 + " INTEGER);";

        /*
        //TABLE3
        String table3 = "CREATE TABLE " + TB_STATES + " (" +
                IDU2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STATE1 + " INTEGER, " + STATE2 + " INTEGER, " + STATE3 + " INTEGER, " +
                STATE4 + " INTEGER, " + STATE5 + " INTEGER, " + STATE6 + " INTEGER, " +
                STATE7 + " INTEGER, " + STATE8 + " INTEGER, " + STATE9 + " INTEGER, " +
                STATE10 + " INTEGER, " + STATE11 + " INTEGER, " + STATE12 + " INTEGER);";

        //TABLE4
        String table4 = "CREATE TABLE " + TB_TOPPINGS + " (" +
                IDU3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TOP1 + " TEXT, " + TOP2 + " TEXT, " + TOP3 + " TEXT, " +
                TOP4 + " TEXT, " + TOP5 + " TEXT, " +
                TOP6 + " TEXT, " + TOP7 + " TEXT, " + TOP8 + " TEXT, " +
                TOP9 + " TEXT, " + TOP10 + " TEXT, " + TOP11 +
                " TEXT, " + TOP12 + " TEXT
*/
        db.execSQL(table1);
        // db.execSQL(table3);
        // db.execSQL(table4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_ORDER_DETAILS);
        //db.execSQL("DROP TABLE IF EXISTS " + TB_TOPPINGS);
        //db.execSQL("DROP TABLE IF EXISTS " + TB_STATES);
        onCreate(db);
    }

    public void addOrder(int[] states, /*String[] toppings,*/ String[] details) {
        ContentValues detailsValues = new ContentValues();
        ContentValues toppingValues = new ContentValues();
        ContentValues stateValues = new ContentValues();

        detailsValues.put(COL0, "CrustComming");

        detailsValues.put(COL1, details[0]);
        detailsValues.put(COL2, details[1]);
        detailsValues.put(COL3, details[2]);
        detailsValues.put(COL4, details[3]);
        detailsValues.put(COL5, details[4]);
        detailsValues.put(COL6, details[5]);
        detailsValues.put(COL7, details[6]);

        detailsValues.put(STATE1, states[0]);
        detailsValues.put(STATE2, states[1]);
        detailsValues.put(STATE3, states[2]);
        detailsValues.put(STATE4, states[3]);
        detailsValues.put(STATE5, states[4]);
        detailsValues.put(STATE6, states[5]);
        detailsValues.put(STATE7, states[6]);
        detailsValues.put(STATE8, states[7]);
        detailsValues.put(STATE9, states[8]);
        detailsValues.put(STATE10, states[9]);
        detailsValues.put(STATE11, states[10]);
        detailsValues.put(STATE12, states[11]);
/*
        detailsValues.put(TOP1, toppings[0]);
        detailsValues.put(TOP2, toppings[1]);
        detailsValues.put(TOP3, toppings[2]);
        detailsValues.put(TOP4, toppings[3]);
        detailsValues.put(TOP5, toppings[4]);
        detailsValues.put(TOP6, toppings[5]);
        detailsValues.put(TOP7, toppings[6]);
        detailsValues.put(TOP8, toppings[7]);
        detailsValues.put(TOP9, toppings[8]);
        detailsValues.put(TOP10, toppings[9]);
        detailsValues.put(TOP11, toppings[10]);
        detailsValues.put(TOP12, toppings[11]);
*/
        SQLiteDatabase db = getWritableDatabase();

        db.insert(TB_ORDER_DETAILS, null, detailsValues);
        //db.insert(TB_TOPPINGS, null, toppingValues);
        //  db.insert(TB_STATES, null, stateValues);

        db.close();
    }

    public String dbToS(int a, int b) {
        SQLiteDatabase db = getWritableDatabase();
        String E = "Error, no String was found";
        String sql = "SELECT * FROM " + TB_ORDER_DETAILS + " WHERE 1 ";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        for (int i = 0; i < a&&!c.isAfterLast(); i++) {
            c.moveToNext();
        }

        int NumberId = 69;
        if (b==100){
            NumberId =c.getColumnIndex(COL0);
            E= c.getString(NumberId);
        }
        if (b == 101) {
            NumberId = c.getColumnIndex(COL1);
            E = c.getString(NumberId);
        }
        if (b == 102) {
            NumberId = c.getColumnIndex(COL2);
            E = c.getString(NumberId);
        }
        if (b == 103) {
            NumberId = c.getColumnIndex(COL3);
            E = c.getString(NumberId);
        }
        if (b == 104) {
            NumberId = c.getColumnIndex(COL4);
            E = c.getString(NumberId);
        }
        if (b == 105) {
            NumberId = c.getColumnIndex(COL5);
            E = c.getString(NumberId);
        }
        if (b == 106) {
            NumberId = c.getColumnIndex(COL6);
            E = c.getString(NumberId);
        }
        if (b == 107) {
            NumberId = c.getColumnIndex(COL7);
            E = c.getString(NumberId);
        }
        if (b == 201) {
            NumberId = c.getColumnIndex(TOP1);
            E = c.getString(NumberId);
        }
        if (b == 202) {
            NumberId = c.getColumnIndex(TOP2);
            E = c.getString(NumberId);
        }
        if (b == 203) {
            NumberId = c.getColumnIndex(TOP3);
            E = c.getString(NumberId);
        }
        if (b == 204) {
            NumberId = c.getColumnIndex(TOP4);
            E = c.getString(NumberId);
        }
        if (b == 205) {
            NumberId = c.getColumnIndex(TOP5);
            E = c.getString(NumberId);
        }
        if (b == 206) {
            NumberId = c.getColumnIndex(TOP6);
            E = c.getString(NumberId);
        }
        if (b == 207) {
            NumberId = c.getColumnIndex(TOP7);
            E = c.getString(NumberId);
        }
        if (b == 208) {
            NumberId = c.getColumnIndex(TOP8);
            E = c.getString(NumberId);
        }
        if (b == 209) {
            NumberId = c.getColumnIndex(TOP9);
            E = c.getString(NumberId);
        }
        if (b == 210) {
            NumberId = c.getColumnIndex(TOP10);
            E = c.getString(NumberId);
        }
        if (b == 211) {
            NumberId = c.getColumnIndex(TOP11);
            E = c.getString(NumberId);
        }
        if (b == 212) {
            NumberId = c.getColumnIndex(TOP12);
            E = c.getString(NumberId);
        }
        if (b == 301) {
            NumberId = c.getColumnIndex(STATE1);
            E = c.getString(NumberId);
        }
        if (b == 302) {
            NumberId = c.getColumnIndex(STATE2);
            E = c.getString(NumberId);
        }
        if (b == 303) {
            NumberId = c.getColumnIndex(STATE3);
            E = c.getString(NumberId);
        }
        if (b == 304) {
            NumberId = c.getColumnIndex(STATE4);
            E = c.getString(NumberId);
        }
        if (b == 305) {
            NumberId = c.getColumnIndex(STATE5);
            E = c.getString(NumberId);
        }
        if (b == 306) {
            NumberId = c.getColumnIndex(STATE6);
            E = c.getString(NumberId);
        }
        if (b == 307) {
            NumberId = c.getColumnIndex(STATE7);
            E = c.getString(NumberId);
        }
        if (b == 308) {
            NumberId = c.getColumnIndex(STATE8);
            E = c.getString(NumberId);
        }
        if (b == 309) {
            NumberId = c.getColumnIndex(STATE9);
            E = c.getString(NumberId);
        }
        if (b == 310) {
            NumberId = c.getColumnIndex(STATE10);
            E = c.getString(NumberId);
        }
        if (b == 311) {
            NumberId = c.getColumnIndex(STATE11);
            E = c.getString(NumberId);
        }
        if (b == 312) {
            NumberId = c.getColumnIndex(STATE12);
            E = c.getString(NumberId);
        }

        c.close();
        return E;
    }

    public String getPizaTitleName(int orderNumber) {
        String it;
        it = dbToS(orderNumber, 101);
        String dbString = it + "  Pizza.";
        return dbString;
    }

    public String getPrice(int orderNumber){
        String it = "";
        it = dbToS(orderNumber,105);
        return  it;
    }

    public String getNumberOfToppings(int orderNumber) {
        String txt = "";
        txt =dbToS(orderNumber, 104);
        return txt;
    }
    public String getCheese(int orderNumber){
        String txt = "";
        txt =dbToS(orderNumber, 103);
        return txt;
    }
    public String getCrust(int orderNumber){
        String txt = "";

        txt = dbToS(orderNumber, 100);
        return txt;
    }
    public String getSauce(int orderNumber){
        String txt = "";
        txt = dbToS(orderNumber, 102);
        return txt;
    }

    public Integer[]toppingNameAr(int i, int t) {


        ArrayList<Integer> strAr = new ArrayList<>();

        if (Integer.parseInt(dbToS(i, 301)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 301)));
        }
        if (Integer.parseInt(dbToS(i, 302)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 302)));
        }
        if (Integer.parseInt(dbToS(i, 303)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 303)));
        }
        if (Integer.parseInt(dbToS(i, 304)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 304)));
        }
        if (Integer.parseInt(dbToS(i, 305)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 305)));
        }
        if (Integer.parseInt(dbToS(i, 306)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 306)));
        }
        if (Integer.parseInt(dbToS(i, 307)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 307)));
        }
        if (Integer.parseInt(dbToS(i, 308)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 308)));
        }
        if (Integer.parseInt(dbToS(i, 309)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 309)));
        }
        if (Integer.parseInt(dbToS(i, 310)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 310)));
        }
        if (Integer.parseInt(dbToS(i, 311)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 311)));
        }
        if (Integer.parseInt(dbToS(i, 312)) != 0) {
            strAr.add(Integer.parseInt(dbToS(i, 312)));
        }

        Integer [] hey = new Integer[strAr.size()];
        hey=strAr.toArray(hey);
        return hey;
    }
    public int CountRows () {
        int Count = 0;
        String sql = "SELECT * FROM " + TB_ORDER_DETAILS + " WHERE 1 ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Count += 1;
        }
        c.close();

        return Count;
    }
    public void clearDatabase() {
        SQLiteDatabase db = getWritableDatabase();
        // String clearStates = " DELETE FROM " + TB_STATES;
        String clearDetails = " DELETE FROM " + TB_ORDER_DETAILS;
        // String clearToppings = " DELETE FROM " + TB_TOPPINGS;
        // db.execSQL(clearStates);
        db.execSQL(clearDetails);
        // db.execSQL(clearToppings);

    }

}


package com.example.joselara.pizza5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.AbstractSequentialList;
import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "pizzathree.db";
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


    public dbHelper(Context context) {
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
                TOP1 + " INTEGER, " + TOP2 + " INTEGER, " + TOP3 + " INTEGER, " +
                TOP4 + " INTEGER, " + TOP5 + " INTEGER, " +
                TOP6 + " INTEGER, " + TOP7 + " INTEGER, " + TOP8 + " INTEGER, " +
                TOP9 + " INTEGER, " + TOP10 + " INTEGER, " + TOP11 +
                " INTEGER, " + TOP12 + " INTEGER, " +
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
                " TEXT, " + TOP12 + " TEXT);";
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

    public void addOrder(int[] states, int[] toppings, String[] details) {
        ContentValues detailsValues = new ContentValues();
        ContentValues toppingValues = new ContentValues();
        ContentValues stateValues = new ContentValues();

        detailsValues.put(COL0, details[7]);

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

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TB_ORDER_DETAILS, null, detailsValues);
        //db.insert(TB_TOPPINGS, null, toppingValues);
        //  db.insert(TB_STATES, null, stateValues);

        db.close();
    }

    public void addSide(String id, String price){
        ContentValues detailsValues = new ContentValues();
        ContentValues toppingValues = new ContentValues();
        ContentValues stateValues = new ContentValues();

        detailsValues.put(COL0, "na");

        detailsValues.put(COL1, "na");
        detailsValues.put(COL2, "na");
        detailsValues.put(COL3, "na");
        detailsValues.put(COL4, "na");
        detailsValues.put(COL5, price);
        detailsValues.put(COL6, "na");
        detailsValues.put(COL7, id);

        detailsValues.put(STATE1, 0);
        detailsValues.put(STATE2, 0);
        detailsValues.put(STATE3, 0);
        detailsValues.put(STATE4, 0);
        detailsValues.put(STATE5, 0);
        detailsValues.put(STATE6, 0);
        detailsValues.put(STATE7, 0);
        detailsValues.put(STATE8, 0);
        detailsValues.put(STATE9, 0);
        detailsValues.put(STATE10, 0);
        detailsValues.put(STATE11, 0);
        detailsValues.put(STATE12, 0);

        detailsValues.put(TOP1, "na");
        detailsValues.put(TOP2, "na");
        detailsValues.put(TOP3, "na");
        detailsValues.put(TOP4, "na");
        detailsValues.put(TOP5, "na");
        detailsValues.put(TOP6, "na");
        detailsValues.put(TOP7, "na");
        detailsValues.put(TOP8, "na");
        detailsValues.put(TOP9, "na");
        detailsValues.put(TOP10,"na");
        detailsValues.put(TOP11,"na");
        detailsValues.put(TOP12,"na");

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
            //crustSeek
            if (b==100){
            NumberId =c.getColumnIndex(COL0);
            E= c.getString(NumberId);
        }
        //sizeSeek
        if (b == 101) {
            NumberId = c.getColumnIndex(COL1);
            E = c.getString(NumberId);
        }
        //sauceSeek
        if (b == 102) {
            NumberId = c.getColumnIndex(COL2);
            E = c.getString(NumberId);
        }
        //cheeseSeek
        if (b == 103) {
            NumberId = c.getColumnIndex(COL3);
            E = c.getString(NumberId);
        }
        //topping
        if (b == 104) {
            NumberId = c.getColumnIndex(COL4);
            E = c.getString(NumberId);
        }
        //price
        if (b == 105) {
            NumberId = c.getColumnIndex(COL5);
            E = c.getString(NumberId);
        }
        //multiplier
        if (b == 106) {
            NumberId = c.getColumnIndex(COL6);
            E = c.getString(NumberId);
        }
        //product id
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

    public double grandTotal (){
        DecimalFormat f = new DecimalFormat("##.00");
        double hey =subTotal()+GST();
        return  hey;
    }
    public double subTotal(){
        double total = 0;
        for (int i=0; i<CountRows();i++ ){
            total+=getPriceDouble(i);
        }
        return total;
    }
    public double GST(){

        double gst = subTotal()*13;
        gst=gst/100;
        return gst;
    }

    public String getPizaTitleName(int orderNumber) {

        String it;
        it = dbToS(orderNumber, 101);
        String dbString = it + " Pizza";
        return dbString;
    }
    public String getPizzaDetails(int i){
        String it = "";
        if (!dbToS(i, 100).equals("")) {
        it +=("\n" +dbToS(i,100));
        }
        if (!dbToS(i, 103).equals("")) {
            it +=("\n" +dbToS(i,103));
        }
        if (!dbToS(i, 102).equals("")) {
            it +=("\n" +dbToS(i,102));
        }
        return it;
    }


    public String getPrice(int orderNumber){
        String it = "";
        it = dbToS(orderNumber,105);
        return  it;
    }
    public double getPriceDouble(int orderNumber){
        String it = "";
        it = dbToS(orderNumber,105);
        return  Double.parseDouble(it);
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

    public Integer[]toppingNameAr(int i) {


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

    public String [] getToppingNames (Integer [] idArray, int a) {
        String[] topS = new String[Integer.parseInt(getNumberOfToppings(a))];
        for (int i = 0; i < Integer.parseInt(getNumberOfToppings(a)); i++) {


            if (idArray[i] == 101 || idArray[i] == 201 || idArray[i] == 301) {
                topS[i] = "Pepperoni " + getMultiplier(a,101);
            }
            if (idArray[i] == 102 || idArray[i] == 202 || idArray[i] == 302) {
                topS[i] = "Ham " + getMultiplier(a,102);
            }
            if (idArray[i] == 103 || idArray[i] == 203 || idArray[i] == 303) {
                topS[i] = "Ground Beef " + getMultiplier(a,103);
            }
            if (idArray[i] == 104 || idArray[i] == 204 || idArray[i] == 304) {
                topS[i] = "Italian Sausage " + getMultiplier(a,104);
            }
            if (idArray[i] == 105 || idArray[i] == 205 || idArray[i] == 305) {
                topS[i] = "Bacon " + getMultiplier(a,105);
            }
            if (idArray[i] == 106 || idArray[i] == 206 || idArray[i] == 306) {
                topS[i] = "Green Peppers " + getMultiplier(a,106);
            }
            if (idArray[i] == 107 || idArray[i] == 207 || idArray[i] == 307) {
                topS[i] = "Tomato " + getMultiplier(a,107);
            }
            if (idArray[i] == 108 || idArray[i] == 208 || idArray[i] == 308) {
                topS[i] = "Black Olives " + getMultiplier(a,108);
            }
            if (idArray[i] == 109 || idArray[i] == 209 || idArray[i] == 309) {
                topS[i] = "Green Olives " + getMultiplier(a,109);
            }
            if (idArray[i] == 110 || idArray[i] == 210 || idArray[i] == 310) {
                topS[i] ="Mushrooms " + getMultiplier(a,110);
            }
            if (idArray[i] == 111 || idArray[i] == 211 || idArray[i] == 311) {
                topS[i] = "Pineapple " + getMultiplier(a,111);
            }
            if (idArray[i] == 112 || idArray[i] == 212 || idArray[i] == 312) {
                topS[i] = "Onions " + getMultiplier(a,112);
            }
        }
        return topS;
    }

    private String getMultiplier(int orderNumber, int topId){
        String multi= "";
        //pep
        if (topId==(101)){
            if (dbToS(orderNumber,201).equals("2001")){
                multi = "2x";
            }
            if (dbToS(orderNumber,201).equals("3001")){
                multi = "3x";
            }
            if (dbToS(orderNumber,201).equals("4001")){
                multi = "4x";
            }
        }
        //ham
        if (topId==(102)) {
            if (dbToS(orderNumber, 202).equals("2002")) {
                multi = "2x";
            }
            if (dbToS(orderNumber, 202).equals("3002")) {
                multi = "3x";
            }
            if (dbToS(orderNumber, 202).equals("4002")) {
                multi = "4x";
            }
        }
        //
        if (topId==(103)){
            if (dbToS(orderNumber,203).equals("2003")){
                multi = "2x";
            }
            if (dbToS(orderNumber,203).equals("3003")){
                multi = "3x";
            }
            if (dbToS(orderNumber,203).equals("4003")){
                multi = "4x";
            }
        }
        //
        if (topId==(104)){
            if (dbToS(orderNumber,204).equals("2004")){
                multi = "2x";
            }
            if (dbToS(orderNumber,204).equals("3004")){
                multi = "3x";
            }
            if (dbToS(orderNumber,204).equals("4004")){
                multi = "4x";
            }
        }
        //
        if (topId==(105)){
            if (dbToS(orderNumber,205).equals("2005")){
                multi = "2x";
            }
            if (dbToS(orderNumber,205).equals("3005")){
                multi = "3x";
            }
            if (dbToS(orderNumber,205).equals("4005")){
                multi = "4x";
            }
        }
//
        if (topId==(106)){
            if (dbToS(orderNumber,206).equals("2006")){
                multi = "2x";
            }
            if (dbToS(orderNumber,206).equals("3006")){
                multi = "3x";
            }
            if (dbToS(orderNumber,206).equals("4006")){
                multi = "4x";
            }
        }
        //
        if (topId==(107)){
            if (dbToS(orderNumber,207).equals("2007")){
                multi = "2x";
            }
            if (dbToS(orderNumber,207).equals("3007")){
                multi = "3x";
            }
            if (dbToS(orderNumber,207).equals("4007")){
                multi = "4x";
            }
        }
        //
        if (topId==(108)){
            if (dbToS(orderNumber,208).equals("2008")){
                multi = "2x";
            }
            if (dbToS(orderNumber,208).equals("3008")){
                multi = "3x";
            }
            if (dbToS(orderNumber,208).equals("4008")){
                multi = "4x";
            }
        }
        //
        if (topId==(109)){
            if (dbToS(orderNumber,209).equals("2009")){
                multi = "2x";
            }
            if (dbToS(orderNumber,209).equals("3009")){
                multi = "3x";
            }
            if (dbToS(orderNumber,209).equals("4009")){
                multi = "4x";
            }
        }
        //
        if (topId==(110)){
            if (dbToS(orderNumber,210).equals("2010")){
                multi = "2x";
            }
            if (dbToS(orderNumber,210).equals("3010")){
                multi = "3x";
            }
            if (dbToS(orderNumber,210).equals("4010")){
                multi = "4x";
            }
        }
        //
        if (topId==(111)){
            if (dbToS(orderNumber,211).equals("2011")){
                multi = "2x";
            }
            if (dbToS(orderNumber,211).equals("3011")){
                multi = "3x";
            }
            if (dbToS(orderNumber,211).equals("4011")){
                multi = "4x";
            }
        }
        //
        if (topId==(112)){
            if (dbToS(orderNumber,212).equals("2012")){
                multi = "2x";
            }
            if (dbToS(orderNumber,212).equals("3012")){
                multi = "3x";
            }
            if (dbToS(orderNumber,212).equals("4012")){
                multi = "4x";
            }
        }
        //
        return multi;
    }

    public String getItemType(int orderNumber){
        String itemType = "ItemTypeNotFund";
        itemType = dbToS(orderNumber,107);
        return itemType;
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
    public int getImageSrc(int topping){
        int resource =69;
        if (topping == 201) {
            return R.drawable.pepon;
        }
        if (topping == 101) {
            return R.drawable.pepleft;
        }
        if (topping == 301) {
                return R.drawable.pepright;
        }
        if (topping == 202) {
                return R.drawable.hamon;
        }
        if (topping == 102) {
            return R.drawable.hamleft;
        }
        if (topping == 302) {
            return R.drawable.hamright;
        }
        if (topping == 203) {
            return R.drawable.beefon;
        }
        if (topping == 103) {
            return R.drawable.beefleft;
        }
        if (topping == 303) {
            return R.drawable.beefright;
        }

        if (topping == 204) {
            return R.drawable.sausageon;
        }
        if (topping == 104) {
            return R.drawable.sausageleft;
        }
        if (topping == 304) {
            return R.drawable.sausageright;
        }
        if (topping == 205) {

                return R.drawable.baconon;
            }
            if (topping == 105) {
                return R.drawable.baconleft;
            }
            if (topping == 305) {
                return R.drawable.baconright;
            }

        if (topping == 206) {
                return R.drawable.greenpepon;
            }
            if (topping == 106) {
                return R.drawable.greenpepleft;
            }
            if (topping == 306) {
                return R.drawable.greenpepright;
            }

        if (topping == 207) {

                return R.drawable.tomatoon;
            }
            if (topping == 107) {
                return R.drawable.tomatoleft;
            }
            if (topping == 307) {
                return R.drawable.tomatoright;
            }

        if (topping == 208) {

                return R.drawable.blackoliveson;
            }
            if (topping == 108) {
                return R.drawable.blackolivesleft;
            }
            if (topping == 308) {
                return R.drawable.blackoliveright;
        }
        if (topping == 209) {

                return R.drawable.oliveson;
            }
            if (topping == 309) {
                return R.drawable.olivesright;
            }
            if (topping == 109) {
                return R.drawable.olivesleft;
            }

        if (topping == 210) {

                return R.drawable.mushon;
            }
            if (topping == 110) {
                return R.drawable.mushleft;
            }
            if (topping == 310) {
                return R.drawable.mushright;
        }
        if (topping == 211) {
                return R.drawable.pineappleon;
            }
            if (topping == 111) {
                return R.drawable.pineappleleft;
            }
            if (topping == 311) {
                return R.drawable.pineappleright;
        }
        if (topping == 212) {

                return R.drawable.onionon;
            }
            if (topping == 112) {
                return R.drawable.onionleft;
            }
            if (topping == 312) {
                return R.drawable.onionright;

        }
        return R.drawable.brocon;
    }
}




































/*
    public ArrayList<String> toppingNameAr(int i) {
        ArrayList<String> strAr = new ArrayList<>();
        if (!dbToS(i, 201).equals("null")) {
            strAr.add("pepperoni");
        }
        if (!dbToS(i, 202).equals("null")) {
            strAr.add("ham");
        }
        if (!dbToS(i, 202).equals("null")) {
            strAr.add("Ground Beef");
        }
        if (!dbToS(i, 202).equals("null")) {
            strAr.add("Sausage");
        }
        return strAr;
    }

    public ArrayList<Integer> stateAr(int i) {
        ArrayList<Integer> stateAr = new ArrayList<>();
        if (dbToS(i, 201).equals("1")) {
            stateAr.add(1);
        }
        if (!dbToS(i, 202).equals("1")) {
            stateAr.add(1);
        }
        if (!dbToS(i, 202).equals("1")) {
            stateAr.add(1);
        }
        if (!dbToS(i, 202).equals("1")) {
            stateAr.add(1);
            return stateAr;
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

        public void clearDatabase () {
            SQLiteDatabase db = getWritableDatabase();
            String clearStates = " DELETE FROM " + TB_STATES;
            String clearDetails = " DELETE FROM " + TB_ORDER_DETAILS;
            String clearToppings = " DELETE FROM " + TB_TOPPINGS;
            db.execSQL(clearStates);
            db.execSQL(clearDetails);
            db.execSQL(clearToppings);

        }

        public int getNumberOfToppings ( int OrderNumber){
            int it;
            String dbString = "";

            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TB_STATES + " WHERE 1 ";

            Cursor c = db.rawQuery(query, null);


            c.moveToFirst();
            for (int i = 0; i < OrderNumber; i++) {
                c.moveToNext();
            }
            int NumberId = c.getColumnIndex(COL4);
            it = c.getInt(NumberId);

            c.close();


            return it;
        }



        public ArrayList<String> getListOfToppings ( int orderNumber){
            ArrayList<Integer> it = new ArrayList<>();
            String temp = "";

            String dbString = "";
            int b = 0;

            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TB_TOPPINGS + " WHERE 1 ";

            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            for (int i = 0; i < orderNumber; i++) {
                c.moveToNext();
            }

            int top1Index = c.getColumnIndex(TOP1);
            temp = c.getString(top1Index);
            if (!temp.equals("")) {
                it.add("Pepperoni");

            }
            int top2Index = c.getColumnIndex(TOP2);
            temp = c.getString(top2Index);
            if (!temp.equals("")) {
                it.add("Ham");
            }
            // int top3Index = c.getColumnIndex(TOP3);
            //temp = c.getString(top3Index);
            //if (!temp.equals("")) {
            //   it.add("Ground Beef");
            //}
            int top4Index = c.getColumnIndex(TOP4);
            temp = c.getString(top4Index);
            if (!temp.equals("")) {
                it.add("Sausage");
            }
            int top5Index = c.getColumnIndex(TOP5);
            temp = c.getString(top5Index);
            if (!temp.equals("")) {
                it.add("Bacon");

            }
            int top6Index = c.getColumnIndex(TOP6);
            temp = c.getString(top6Index);
            if (!temp.equals("")) {
                it.add("Green Peppers");
            }
            int top7Index = c.getColumnIndex(TOP7);
            temp = c.getString(top7Index);
            if (!temp.equals("")) {
                it.add("Tomato");
            }
            int top8Index = c.getColumnIndex(TOP8);
            temp = c.getString(top8Index);
            if (!temp.equals("")) {
                it.add("Black Olives");
            }
            int top9Index = c.getColumnIndex(TOP9);
            temp = c.getString(top9Index);
            if (!temp.equals("")) {
                it.add("Green Olives");
            }
            int top10Index = c.getColumnIndex(TOP10);
            temp = c.getString(top10Index);
            if (!temp.equals("")) {
                it.add("Mushrooms");
            }
            int top11Index = c.getColumnIndex(TOP11);
            temp = c.getString(top11Index);
            if (!temp.equals("")) {
                it.add("Pineapple");
            }
            int top12Index = c.getColumnIndex(TOP12);
            temp = c.getString(top12Index);
            if (!temp.equals("")) {
                it.add("Onions");
            }
            c.close();
            db.close();

            return it;
        }

        public ArrayList<Integer> getStateList ( int orderNumber){
            ArrayList<Integer> it = new ArrayList<>();


            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TB_STATES + " WHERE 1 ";

            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();


            for (int i = 0; i < orderNumber; i++) {
                c.moveToNext();
            }

            int value1 = c.getColumnIndex(STATE1);


            int value2 = c.getColumnIndex(STATE2);

            int value3 = c.getColumnIndex(STATE3);

            int value4 = c.getColumnIndex(STATE4);

            int value5 = c.getColumnIndex(STATE5);

            int value6 = c.getColumnIndex(STATE6);

            int value7 = c.getColumnIndex(STATE7);

            int value8 = c.getColumnIndex(STATE8);

            int value9 = c.getColumnIndex(STATE9);

            int value10 = c.getColumnIndex(STATE10);

            int value11 = c.getColumnIndex(STATE11);

            int value12 = c.getColumnIndex(STATE12);


            if (c.getInt(value1) != 0) {
                it.add(c.getInt(value1));
            }
            if (c.getInt(value2) != 0) {
                it.add(c.getInt(value2));
            }
            if (c.getInt(value3) != 0) {
                it.add(c.getInt(value3));
            }
            if (c.getInt(value4) != 0) {
                it.add(c.getInt(value4));
            }
            if (c.getInt(value5) != 0) {
                it.add(c.getInt(value5));
            }
            if (c.getInt(value6) != 0) {
                it.add(c.getInt(value6));
            }
            if (c.getInt(value7) != 0) {
                it.add(c.getInt(value7));
            }
            if (c.getInt(value8) != 0) {
                it.add(c.getInt(value8));
            }
            if (c.getInt(value9) != 0) {
                it.add(c.getInt(value9));
            }
            if (c.getInt(value10) != 0) {
                it.add(c.getInt(value10));
            }
            if (c.getInt(value11) != 0) {
                it.add(c.getInt(value11));
            }
            if (c.getInt(value12) != 0) {
                it.add(c.getInt(value12));
            }


            c.close();
            db.close();

            return it;

        }
    /*
    public ArrayList<Integer> getToppingsInt (bundle){
        ArrayList<Integer> b =  new ArrayList<>();
        for (int i = 0; i < b.sizeSeek(); i++) {
            if (a.get(i).equals("Pepperoni")) {
                b.add(0);
            }
            if (a.get(i).equals("Ham")) {
                b.add(1);
            }
            if (a.get(i).equals("Ground Beef")) {
                b.add(2);
            }
            if (a.get(i).equals("Sausage")) {
                b.add(3);
            }
            if (a.get(i).equals("Bacon")) {
                b.add(4);
            }
            if (a.get(i).equals("Green Peppers")) {
                b.add(5);
            }
            if (a.get(i).equals("Tomato")) {
                b.add(6);
            }
            if (a.get(i).equals("Black Olives")) {
                b.add(7);
            }
            if (a.get(i).equals("Mushrooms")) {
                b.add(8);
            }
            if (a.get(i).equals("Green Olives")) {
                b.add(9);
            }
            if (a.get(i).equals("Pineapple")) {
                b.add(10);
            }
            if (a.get(i).equals("Onions")) {
                b.add(11);
            }
        }
        return b;
    }

    public String getRowString() {
        String sql = "SELECT * FROM " + TB_STATES + " WHERE 1 ";

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        String Row="";

        int val1=c.getColumnIndex(COL1);
        int val2=c.getColumnIndex(COL2);
        int val3=c.getColumnIndex(COL3);
        int val4=c.getColumnIndex(COL4);
        int val5=c.getColumnIndex(COL5);
        int val6=c.getColumnIndex(COL6);
        int val7=c.getColumnIndex(COL7);


        c.moveToFirst();

        Row= new StringBuilder().append(c.getString(val1)).toString()+c.getString(val2)+c.getString(val3)+c.getString(val4)+c.getString(val5)+c.getString(val6)+c.getString(val7);

        return Row;
    }
    */


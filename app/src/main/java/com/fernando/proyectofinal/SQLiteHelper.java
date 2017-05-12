package com.fernando.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Dell on 08/05/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String sqlCreate = "CREATE TABLE users(id INTEGER PRIMARY KEY,name TEXT,last_name TEXT,email TEXT,password TEXT);";
    private static final String sqlCreateMember = "CREATE TABLE member(id INTEGER PRIMARY KEY,name TEXT,last_name TEXT,email TEXT,password TEXT,adress TEXT,image_resource INTEGER,earnings REAL,is_associated INTEGER);";
    private static final String sqlCreateInventory = "CREATE TABLE inventory(id INTEGER PRIMARY KEY,name TEXT,description TEXT,image_resource INTEGER,is_empty INTEGER);";
    private static final String sqlCreateProduct = "CREATE TABLE product(id INTEGER PRIMARY KEY,name TEXT,description TEXT,price REAL,quantity INTEGER,image_resource INTEGER)";
    private static final String sqlCreateSets = "CREATE TABLE sets(id INTEGER PRIMARY KEY,name TEXT,description TEXT,image_resource INTEGER);";
    private static final String sqlCreateOrder = "CREATE TABLE product_order(id INTEGER PRIMARY KEY,user_id INTEGER);";
    private static final String sqlCreateProductOrder = "CREATE TABLE product_order(FOREIGN KEY (product_id) REFERENCES product(id),FOREIGN KEY (order_id) REFERENCES order(id));";
    private static final String sqlCreateProductInventory = "CREATE TABLE product_order(FOREIGN KEY (product_id) REFERENCES product(id),FOREIGN KEY (inventory_id) REFERENCES inventory(id));";
    private static final String sqlCreateProductSets = "CREATE TABLE product_sets(FOREIGN KEY (product_id) REFERENCES product(id),FOREIGN KEY (set_id) REFERENCES sets(id));";


    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreateMember);
        db.execSQL(sqlCreateInventory);
        db.execSQL(sqlCreateProduct);
        db.execSQL(sqlCreateSets);
        db.execSQL(sqlCreateOrder);
        //db.execSQL(sqlCreateProductOrder);
        //db.execSQL(sqlCreateProductInventory);
        //db.execSQL(sqlCreateProductSets);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS member" );
        db.execSQL("DROP TABLE IF EXISTS product" );
        db.execSQL("DROP TABLE IF EXISTS product_order" );
        //db.execSQL("DROP TABLE IF EXISTS order" );
    }
}

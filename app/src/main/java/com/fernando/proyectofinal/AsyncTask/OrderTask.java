package com.fernando.proyectofinal.AsyncTask;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.fernando.proyectofinal.HomeActivity;
import com.fernando.proyectofinal.model.Product;

import java.util.ArrayList;

/**
 * Created by Dell on 02/05/2017.
 */

public class OrderTask extends AsyncTask<ArrayList<Product>, Void, Boolean> {
    private final Context context;
    ProgressDialog dialog;

    public OrderTask(Context mContext ) {
        dialog= new ProgressDialog(mContext);
        this.context = mContext.getApplicationContext();

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Ordering");
        dialog.show();
    }


    @Override
    protected Boolean doInBackground(ArrayList<Product>... arrayLists) {
        String result = "";
        //In this place it will be ordering
        SystemClock.sleep(1000);

        //In this place we verify if the store was found

        //will return true if the transaction was succesfully made
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        Toast.makeText(context, "Order Done!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

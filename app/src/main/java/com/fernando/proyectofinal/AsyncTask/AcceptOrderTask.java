package com.fernando.proyectofinal.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.fernando.proyectofinal.HomeActivity;
import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.Order;

/**
 * Created by Dell on 06/05/2017.
 */

public class AcceptOrderTask extends AsyncTask<Order, Void, Boolean> {

    private final Context context;
    private ProgressDialog dialog;

    public AcceptOrderTask(Context context) {
        this.context = context;
        dialog=new ProgressDialog(context);
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Accepting");
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(Order... orders) {

        SystemClock.sleep(1000);
        //this will send the order to the acepted orders
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        dialog.dismiss();
        Toast.makeText(context, "Order Accepted!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}

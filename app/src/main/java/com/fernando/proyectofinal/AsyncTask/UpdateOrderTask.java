package com.fernando.proyectofinal.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.fernando.proyectofinal.CheckOrdersActivity;
import com.fernando.proyectofinal.model.DummyTest;
import com.fernando.proyectofinal.model.Order;

import java.util.ArrayList;

/**
 * Created by Dell on 03/05/2017.
 */

public class UpdateOrderTask extends AsyncTask<Integer,Void,ArrayList<Order>> {

    private ProgressDialog dialog;
    private Context context;

    public UpdateOrderTask(Context mContext) {
        dialog= new ProgressDialog(mContext);
        this.context = mContext.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Searching");
        dialog.show();
    }

    @Override
    protected ArrayList<Order> doInBackground(Integer... integers) {

        //Go and search for the orders assigned to the memberstore id

        SystemClock.sleep(1000);
        ArrayList<Order> orders = new DummyTest().getSuccesfulOrders();
        return orders;
    }


    @Override
    protected void onPostExecute(ArrayList<Order> result) {
        super.onPostExecute(result);
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
        if(result.isEmpty()){
            Toast.makeText(context, "You have no Orders", Toast.LENGTH_SHORT);
        }else{
            Intent intent =new Intent(context,CheckOrdersActivity.class);
            intent.putExtra(CheckOrdersActivity.ORDERS_FOUND, result);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }

}

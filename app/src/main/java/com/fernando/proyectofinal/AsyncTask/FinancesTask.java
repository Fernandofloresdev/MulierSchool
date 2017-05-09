package com.fernando.proyectofinal.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.fernando.proyectofinal.PersonalFinancesActivity;

/**
 * Created by Dell on 06/05/2017.
 */

public class FinancesTask extends AsyncTask<Integer, Void, Boolean> {

    private Context context;
    private int userId, days;
    private double balance,earnings;
    private ProgressDialog dialog;

    public FinancesTask(Context context) {
        this.context = context;
        dialog=new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Obtaining finances");
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        userId=integers[0];
        SystemClock.sleep(1000);
        //this will send the order to the acepted orders
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

        dialog.dismiss();

        days=10;
        balance =1500;
        earnings =420;

        Intent intent = new Intent(context, PersonalFinancesActivity.class);
        intent.putExtra(PersonalFinancesActivity.BALANCE,balance);
        intent.putExtra(PersonalFinancesActivity.EARNINGS,earnings);
        intent.putExtra(PersonalFinancesActivity.DAYS,days);
        context.startActivity(intent);
    }
}

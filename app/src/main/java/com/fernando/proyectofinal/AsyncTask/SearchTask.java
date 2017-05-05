package com.fernando.proyectofinal.AsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.fernando.proyectofinal.MemberStoreActivity;
import com.fernando.proyectofinal.R;
import com.fernando.proyectofinal.model.DummyTest;
import com.fernando.proyectofinal.model.MemberStore;

/**
 * Created by Dell on 01/05/2017.
 */

/*
    ****************************************************************************************
    ASYNC TASK !!!!!!!!!! ******************************************************************
    ****************************************************************************************
    * **************************************************************************************
    ASYNC TASK !!!!!!!!!! ******************************************************************
    ****************************************************************************************
     */

public class SearchTask extends AsyncTask<Integer, Void, MemberStore> {

    private ProgressDialog dialog;
    private Context context;
    private MemberStore memberStoreFound;

    public SearchTask(Context mContext) {
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
    protected MemberStore doInBackground(Integer... params) {

        String result = "";
        //In this place it will be searching
        SystemClock.sleep(1000);

        memberStoreFound = new DummyTest().searchMemberStore(params);
        //In this place we verify if the store was found

        return memberStoreFound;

    }

    @Override
    protected void onPostExecute(MemberStore result) {
        super.onPostExecute(result);
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
        if(memberStoreFound.isEmpty()){
            Toast.makeText(context, "member Store was not found", Toast.LENGTH_SHORT);
        }else{
            Intent intent =new Intent(context,MemberStoreActivity.class);
            intent.putExtra("memberStoreFound", memberStoreFound);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }


}
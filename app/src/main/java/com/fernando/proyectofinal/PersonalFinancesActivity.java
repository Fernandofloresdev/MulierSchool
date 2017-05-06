package com.fernando.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PersonalFinancesActivity extends AppCompatActivity {
    TextView balanceTv, earningsTv, daysTv;
    ProgressBar progressBar;
    private int days;
    private double balance, earnings;
    public static final String EARNINGS="earnings";
    public static final String BALANCE="balance";
    public static final String DAYS="days";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_finances);

        findViews();
        setContent();

    }

    private void findViews(){
        balanceTv = (TextView)findViewById(R.id.balanceTV);
        earningsTv=(TextView)findViewById(R.id.earningsTV);
        daysTv=(TextView)findViewById(R.id.daysTV);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
    }

    private void setContent(){
        Intent intent = getIntent();
        balance =intent.getDoubleExtra(BALANCE,0);
        earnings=intent.getDoubleExtra(EARNINGS,0);
        days=intent.getIntExtra(DAYS,0);

        balanceTv.setText("$"+Double.toString(balance));
        earningsTv.setText("$"+Double.toString(earnings));
        daysTv.setText(Integer.toString(days)+" days");

        progressBar.setVisibility(View.VISIBLE);
        progressBar.setMax(20);

        progressBar.setProgress(days);

    }
}

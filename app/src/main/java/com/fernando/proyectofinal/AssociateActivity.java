package com.fernando.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AssociateActivity extends AppCompatActivity {
    private Spinner citySpinner;
    private TextView stateText;
    private EditText streetEditText, coloniaEditText, houseNumberEditText, interiorNumberEditText,
            zipCodeEditText,phoneNumberEditText, houseReferencesEditText, cityEditText;
    private Button sendRequestButton;
    private String street,city,state,colonia,houseNumber, interiorNumber,zipCode, phoneNumber, houseReferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associate);

        //find Views
        findViews();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mexicanStatesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String state = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citySpinner.performClick();
            }
        });

    }

    private void findViews(){
        citySpinner = (Spinner) findViewById(R.id.stateSpinner);
        cityEditText=(EditText)findViewById(R.id.cityEditText);
        stateText = (TextView) findViewById(R.id.stateDisplay);
        streetEditText =(EditText)findViewById(R.id.streetEditText);
        coloniaEditText = (EditText) findViewById(R.id.coloniaEditText);
        houseNumberEditText= (EditText)findViewById(R.id.houseNumberEditText);
        interiorNumberEditText=(EditText)findViewById(R.id.interiorNumberEditText);
        zipCodeEditText=(EditText)findViewById(R.id.zipCodeEditText);
        phoneNumberEditText=(EditText)findViewById(R.id.phoneNumberEditText);
        houseReferencesEditText=(EditText)findViewById(R.id.houseReferencesEditText);
    }

    public void sendRequest(View view){
        street = streetEditText.getText().toString();
        city = cityEditText.getText().toString();
        state = stateText.getText().toString();
        colonia = coloniaEditText.getText().toString();
        houseNumber = houseNumberEditText.getText().toString();
        interiorNumber = interiorNumberEditText.getText().toString();
        zipCode = zipCodeEditText.getText().toString();
        phoneNumber = phoneNumberEditText.getText().toString();
        houseReferences = houseReferencesEditText.getText().toString();

        Toast.makeText(this, "DONE!", Toast.LENGTH_SHORT).show();

    }
}

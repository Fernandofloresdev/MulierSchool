package com.fernando.proyectofinal;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText birthText, nameEditText, lastNameEditText, emailEditText, repeatEmailEditText;
    private EditText passwordEditText,repeatPasswordEditText;
    private String birthDate, name, lastName, email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();

        birthText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDatePickerDialog(v);
                }
            }
        });
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onDateSet(DatePicker view, int year, int mes, int day){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(birthText.getWindowToken(), 0);
        String month=Integer.toString(mes);
        if(mes<9){
            month= 0+month;
        }
        birthText.setText(day+"/"+month+"/"+year);
    }

    private void findViews(){
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        lastNameEditText = (EditText)findViewById(R.id.lastNameEditText);
        birthText = (EditText)findViewById(R.id.birthDate);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        repeatEmailEditText = (EditText)findViewById(R.id.repeatEmailEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        repeatPasswordEditText = (EditText)findViewById(R.id.repeatPasswordEditText);
    }

    public void registerUser(View view){
        birthDate= birthText.getText().toString();
        name = nameEditText.getText().toString();
        lastName = lastNameEditText.getText().toString();
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();

        if(!(email.equals(repeatEmailEditText.getText().toString()))){
            Toast.makeText(this, R.string.emailIsNotSame,Toast.LENGTH_SHORT).show();
        }else if(!(password.equals(repeatPasswordEditText.getText().toString()))){
            Toast.makeText(this, R.string.passwordIsNotSame,Toast.LENGTH_SHORT);
            passwordEditText.getText().clear();
            repeatPasswordEditText.getText().clear();
        } else {
            //Replace this code for the register connection
            SharedPreferences sharedPref = getSharedPreferences("user_data", 0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", name);
            editor.putString("lastName", lastName);
            editor.putString("email",email);
            editor.putString("password",password);
            editor.commit();
            //ending replace
            Intent intent = new Intent(this,LoginActivity.class);
            intent.putExtra("email",email);
            intent.putExtra("password", password);
            startActivity(intent);
        }
    }
}

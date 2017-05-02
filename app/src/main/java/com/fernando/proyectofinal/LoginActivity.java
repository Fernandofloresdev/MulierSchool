package com.fernando.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fernando.proyectofinal.model.Cart;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private String emailAccount="oscarfernando_offg@hotmail.com", passwordAccount="y";
    public Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = (EditText)findViewById(R.id.emailLoginEditText);
        passwordEditText=(EditText)findViewById(R.id.passwordLoginEditText);
        Intent intent = getIntent();

        if(intent.hasExtra("email")){
            emailEditText.setText(intent.getStringExtra("email"));
            passwordEditText.setText(intent.getStringExtra("password"));
        }
    }

    public void login(View view){
        String email, password;
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();

        /* LOGIN USING SHAREDPREFENCES
        SharedPreferences sharedPref = getSharedPreferences("user_data" ,0);
        String emailAccount = sharedPref.getString("email", "");
        String passwordAccount =sharedPref.getString("password","");*/


        if(email.equals(emailAccount) && password.equals(passwordAccount)){
            Toast.makeText(this,"Login granted", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }
    public void openRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void showCitySpinner(View view){
        Intent intent = new Intent(this, AssociateActivity.class);
        startActivity(intent);
    }

    public void showHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void showMemberStore(View view){
        Intent intent = new Intent(this, MemberStoreActivity.class);
        startActivity(intent);
    }
}

package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
    public void clickLoginButton(View view) {
        Intent myIntent = new Intent(Index.this, Login.class);
        Index.this.startActivity(myIntent);
    }
    public void clickRegisterButton(View view) {
        Intent myIntent = new Intent(Index.this, Registration.class);
        Index.this.startActivity(myIntent);
    }
    public void clickAboutUsButton(View view){
        Intent myIntent = new Intent(Index.this, AboutUs.class);
        Index.this.startActivity(myIntent);
    }
    public void clickContactUsButton(View view) {
        Intent myIntent = new Intent(Index.this, ContactUs.class);
        Index.this.startActivity(myIntent);
    }
}
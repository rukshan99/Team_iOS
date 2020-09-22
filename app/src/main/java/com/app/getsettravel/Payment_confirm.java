package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Payment_confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_confirm);
    }

    public void goToHome(View view) {
        Intent myIntent = new Intent(Payment_confirm.this, home.class);
        Payment_confirm.this.startActivity(myIntent);
    }

    public void goToFeedback(View view) {
        Intent myIntent = new Intent(Payment_confirm.this, Feedback.class);
        Payment_confirm.this.startActivity(myIntent);
    }
}
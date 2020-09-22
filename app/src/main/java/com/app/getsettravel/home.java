package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void clickFeedbackButton(View view) {
        Intent myIntent = new Intent(home.this, Feedback.class);
        home.this.startActivity(myIntent);
    }
    public void clickBookAHotelButton(View view) {
        Intent myIntent = new Intent(home.this, BookingDetails.class);
        home.this.startActivity(myIntent);
    }
    public void clickMapButton(View view) {
        Intent myIntent = new Intent(home.this, Map.class);
        home.this.startActivity(myIntent);
    }
    public void clickMyAccountButton(View view) {
        Intent myIntent = new Intent(home.this, UserAccount.class);
        home.this.startActivity(myIntent);
    }

}
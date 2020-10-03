package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    String user_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent getIntent = getIntent();
        user_Name = getIntent.getStringExtra("userName");

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
        myIntent.putExtra("userName",user_Name);
        home.this.startActivity(myIntent);
    }

}
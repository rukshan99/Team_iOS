package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Grand_Hotel extends AppCompatActivity {

    float basePrice=30000;
    String hotelName="Hotel Grand";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grand__hotel);
    }

    public void clickCheckAvailabilityButton(View view) {
        Intent myIntent = new Intent(Grand_Hotel.this, BookingDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        Grand_Hotel.this.startActivity(myIntent);
    }
}
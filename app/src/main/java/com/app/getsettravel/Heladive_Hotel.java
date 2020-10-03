package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Heladive_Hotel extends AppCompatActivity {

    float basePrice=15000;
    String hotelName="Hotel Heladive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heladive__hotel);
    }

    public void clickCheckAvailabilityButton(View view) {
        Intent myIntent = new Intent(Heladive_Hotel.this, BookingDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        Heladive_Hotel.this.startActivity(myIntent);
    }
}
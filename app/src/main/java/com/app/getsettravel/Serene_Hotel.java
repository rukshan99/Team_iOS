package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Serene_Hotel extends AppCompatActivity {

    float basePrice=10000;
    String hotelName="Hotel Serene";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serene);
    }

    public void clickCheckAvailabilityButton(View view) {
        Intent myIntent = new Intent(Serene_Hotel.this, BookingDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        Serene_Hotel.this.startActivity(myIntent);
    }
}
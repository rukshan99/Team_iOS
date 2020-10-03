package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Aranya_Hotel extends AppCompatActivity {

    float basePrice=25000;
    String hotelName="Hotel Aranya";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranya__hotel);
    }

    public void clickCheckAvailabilityButton(View view) {
        Intent myIntent = new Intent(Aranya_Hotel.this, BookingDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        Aranya_Hotel.this.startActivity(myIntent);
    }
}
package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Anatamaa_Hotel extends AppCompatActivity {

    float basePrice=20000;
    String hotelName="Hotel Anatamaa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatamaa__hotel);
    }
    public void clickCheckAvailabilityButton(View view) {
        Intent myIntent = new Intent(Anatamaa_Hotel.this, BookingDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        Anatamaa_Hotel.this.startActivity(myIntent);
    }
}
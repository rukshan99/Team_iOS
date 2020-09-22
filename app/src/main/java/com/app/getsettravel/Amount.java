package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class Amount extends AppCompatActivity {

    Integer noOfRooms, noOfNights;
    String checkInTime, roomType, checkInDate, hotelName;
    Float basePrice, bookingCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        /***
         *
         * Initializing the values passed from the Booking Details page***/
        Intent intent = getIntent();
        hotelName = intent.getStringExtra("HOTEL_NAME");
        basePrice = intent.getFloatExtra("BASE_PRICE",1000);
        roomType = intent.getStringExtra("ROOM_TYPE");
        noOfRooms = intent.getIntExtra("NO_OF_ROOMS",1);
        checkInDate = intent.getStringExtra("CHECK_IN_DATE");
        checkInTime = intent.getStringExtra("CHECK_IN_TIME");
        noOfNights = intent.getIntExtra("NO_OF_NIGHTS",1);

        TextView cost = (TextView)findViewById(R.id.textView35);
        cost.setText(Float.toString(calculateBookingCost(basePrice, roomType, noOfRooms, noOfNights)));
    }

    public float calculateBookingCost(Float base_Price, String room_Type, Integer noOf_Rooms, Integer noOf_Nights){

        int roomValueMultiplier = 1;

        if(room_Type.equals("Double"))
            roomValueMultiplier = 2;
        else if(room_Type.equals("Family"))
            roomValueMultiplier = 3;
        else if(room_Type.equals("VIP Suite"))
            roomValueMultiplier = 5;

        bookingCost = (float) base_Price * roomValueMultiplier * noOf_Rooms * noOf_Nights;
        return bookingCost;
    }

    public void viewPaymentDetails(View view) {
        Intent myIntent = new Intent(Amount.this, PaymentDetails.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BOOKING_COST",calculateBookingCost(basePrice,roomType,noOfRooms,noOfNights));
        myIntent.putExtra("ROOM_TYPE",roomType);
        myIntent.putExtra("NO_OF_ROOMS",noOfRooms);
        myIntent.putExtra("CHECK_IN_DATE",checkInDate);
        myIntent.putExtra("CHECK_IN_TIME",checkInTime);
        myIntent.putExtra("NO_OF_NIGHTS",noOfNights);
        Amount.this.startActivity(myIntent);
    }
}

package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BookingDetails extends AppCompatActivity {

    Spinner roomType, noOfRooms, checkInTime, noOfNights;
    DatePicker checkInDate;
    String hotelName;
    Float basePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        /***
         *
         * Initializing the values passed from the Hotel page***/
        Intent intent = getIntent();
        hotelName = intent.getStringExtra("HOTEL_NAME");
        basePrice = intent.getFloatExtra("BASE_PRICE",1000);

        /***
         *
         * Inserting data to the Room Types spinner***/
        roomType = findViewById(R.id.spinner);
        ArrayList<String> roomTypes = new ArrayList<>();
        roomTypes.add("Single");
        roomTypes.add("Double");
        roomTypes.add("Family");
        roomTypes.add("VIP Suite");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, roomTypes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomType.setAdapter(arrayAdapter);
        roomType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String list = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + list, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the No. of Rooms spinner***/
        noOfRooms = findViewById(R.id.spinner2);
        ArrayList<Integer> noRooms = new ArrayList<>();
        noRooms.add(1);
        noRooms.add(2);
        noRooms.add(3);
        noRooms.add(4);
        noRooms.add(5);
        ArrayAdapter<Integer> arrayAdapter2= new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, noRooms);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noOfRooms.setAdapter(arrayAdapter2);
        noOfRooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int no = (int) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + no, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the Check-in Times spinner***/
        checkInTime = findViewById(R.id.spinner3);
        ArrayList<String> times = new ArrayList<>();
        times.add("11.00 a.m");
        times.add("6.00 p.m");
        ArrayAdapter<String> arrayAdapter3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, times);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        checkInTime.setAdapter(arrayAdapter3);
        checkInTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String time = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + time, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the No. of Nights spinner***/
        noOfNights = findViewById(R.id.spinner4);
        ArrayList<Integer> noNights = new ArrayList<>();
        noNights.add(1);
        noNights.add(2);
        noNights.add(3);
        noNights.add(4);
        noNights.add(5);
        noNights.add(6);
        noNights.add(7);
        ArrayAdapter<Integer> arrayAdapter4= new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, noNights);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noOfNights.setAdapter(arrayAdapter4);
        noOfNights.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int nights = (int) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + nights, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });


       // roomType = (Spinner)findViewById(R.id.spinner);
       // noOfRooms = (Spinner) findViewById(R.id.spinner2);
        checkInDate = (DatePicker) findViewById(R.id.datePicker1);
       // checkInTime = (Spinner) findViewById(R.id.spinner3);
        //noOfNights = (Spinner) findViewById(R.id.spinner4);

    }
//java.util.Date
    /**
     *
     * @param datePicker
     * @return a java.util.Date
     */
    public static String getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        //int year =  datePicker.getYear();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM");
        Calendar calendar = Calendar.getInstance();
        calendar.set( 0, month, day);

        return df.format(calendar.getTimeInMillis());
        //return calendar.getTime();
    }

    public void viewAmount(View view) {

        Intent myIntent = new Intent(BookingDetails.this, Amount.class);
        myIntent.putExtra("HOTEL_NAME",hotelName);
        myIntent.putExtra("BASE_PRICE",basePrice);
        myIntent.putExtra("ROOM_TYPE",roomType.getSelectedItem().toString());
        myIntent.putExtra("NO_OF_ROOMS",Integer.parseInt(noOfRooms.getSelectedItem().toString()));
        myIntent.putExtra("CHECK_IN_DATE",getDateFromDatePicker(checkInDate).toString());
        myIntent.putExtra("CHECK_IN_TIME",checkInTime.getSelectedItem().toString());
        myIntent.putExtra("NO_OF_NIGHTS",Integer.parseInt(noOfNights.getSelectedItem().toString()));
        BookingDetails.this.startActivity(myIntent);
    }

}
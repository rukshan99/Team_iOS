package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        /***
         *
         * Inserting data to the Room Types spinner***/
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> roomTypes = new ArrayList<>();
        roomTypes.add("Single");
        roomTypes.add("Double");
        roomTypes.add("Family");
        roomTypes.add("VIP Suite");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, roomTypes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String list = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + list, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the No. of Rooms spinner***/
        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayList<Integer> noRooms = new ArrayList<>();
        noRooms.add(1);
        noRooms.add(2);
        noRooms.add(3);
        noRooms.add(4);
        noRooms.add(5);
        ArrayAdapter<Integer> arrayAdapter2= new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, noRooms);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int no = (int) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + no, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the Check-in Times spinner***/
        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayList<String> times = new ArrayList<>();
        times.add("11.00 a.m");
        times.add("6.00 p.m");
        ArrayAdapter<String> arrayAdapter3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, times);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String time = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + time, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        /***
         *
         * Inserting data to the No. of Nights spinner***/
        Spinner spinner4 = findViewById(R.id.spinner4);
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
        spinner4.setAdapter(arrayAdapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int nights = (int) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + nights, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });


    }

    public void viewAmount(View view) {
        Intent myIntent = new Intent(BookingDetails.this, Amount.class);
        BookingDetails.this.startActivity(myIntent);
    }
}
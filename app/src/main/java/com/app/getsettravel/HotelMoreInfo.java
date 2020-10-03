package com.app.getsettravel;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.Database.Hotel_DBHelper;
import com.app.getsettravel.model.Hotel;


public class HotelMoreInfo extends AppCompatActivity {
    EditText hhotelName;
    EditText hwebSite;
    EditText hlocation;
    EditText hcontactPersonName;
    EditText hemail;
    EditText hmobileNo;
    EditText hbudget;
    EditText hdescription;

    private Hotel_DBHelper hotelDbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_more_info);

        hotelDbHelper = new Hotel_DBHelper(HotelMoreInfo.this);


        hhotelName = (EditText) findViewById(R.id.hhotelName);
        hwebSite = (EditText) findViewById(R.id.hwebSite);
        hlocation = (EditText) findViewById(R.id.hlocation);
        hcontactPersonName = (EditText) findViewById(R.id.hcontactPersonName);
        hemail = (EditText) findViewById(R.id.hemail);
        hmobileNo = (EditText) findViewById(R.id.hmobileNo);
        hbudget = (EditText) findViewById(R.id.hbudget);
        hdescription = (EditText) findViewById(R.id.hdescription);

        final String id = getIntent().getStringExtra("Id");
        Hotel hotel = hotelDbHelper.getHotel(Integer.parseInt(id));

        hhotelName.setText(hotel.getHotelName());
        hwebSite.setText(hotel.getWebSite());
        hlocation.setText(hotel.getLocation());
        hcontactPersonName.setText(hotel.getContactPersonName());
        hemail.setText(hotel.getEmail());
        hmobileNo.setText(hotel.getMobileNo());
        hbudget.setText(hotel.getBudget());
        hdescription.setText(hotel.getDescription());
    }
}
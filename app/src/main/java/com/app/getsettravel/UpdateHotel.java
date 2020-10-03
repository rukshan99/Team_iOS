package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.Database.Hotel_DBHelper;
import com.app.getsettravel.model.Hotel;


public class UpdateHotel extends AppCompatActivity {
    EditText hotelName,webSite,location,contactPersonName,email,mobileNo,budget,description;
    private Hotel_DBHelper hotelDbHelper;
    private Button updatebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hotel);

        hotelDbHelper = new Hotel_DBHelper(UpdateHotel.this);

        hotelName = (EditText) findViewById(R.id.UhotelName);
        webSite = (EditText) findViewById(R.id.UwebSite);
        location = (EditText) findViewById(R.id.Ulocation);
        contactPersonName = (EditText) findViewById(R.id.UcontactPersonName);
        email = (EditText) findViewById(R.id.Uemail);
        mobileNo = (EditText) findViewById(R.id.UmobileNo);
        budget = (EditText) findViewById(R.id.Ubudget);
        description = (EditText) findViewById(R.id.Udescription);

         updatebutton = (Button) findViewById(R.id.updatebutton);
         final  String id = getIntent().getStringExtra("Id");
         Hotel hotel = hotelDbHelper.getHotel(Integer.parseInt(id));

        hotelName.setText(hotel.getHotelName());
        webSite.setText(hotel.getWebSite());
        location.setText(hotel.getLocation());
        contactPersonName.setText(hotel.getContactPersonName());
        email.setText(hotel.getEmail());
        mobileNo.setText(hotel.getMobileNo());
        budget.setText(hotel.getBudget());
        description.setText(hotel.getDescription());

       updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String HotelName = hotelName.getText().toString();
                String WebSite = webSite.getText().toString();
                String Location = location.getText().toString();
                String ContactPersonName = contactPersonName.getText().toString();
                String Email = email.getText().toString();
                String MobileNo = mobileNo.getText().toString();
                String Budget = budget.getText().toString();
                String Description = description.getText().toString();


                Hotel hotel = new Hotel(Integer.parseInt(id),HotelName,WebSite,Location,ContactPersonName,Email,MobileNo,Budget,Description);
                int state = hotelDbHelper.updateHotel(hotel);
                Intent intentUPD = new Intent(UpdateHotel.this,HotelList.class);
                startActivity(intentUPD);

            }
        });
    }
}
package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.Database.Hotel_DBHelper;


public class AddHotel extends AppCompatActivity {

    EditText hotelName,webSite,location,contactPersonName,email,mobileNo,budget,description;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);
        hotelName = (EditText) findViewById(R.id.hotelName);
        webSite = (EditText) findViewById(R.id.webSite);
        location = (EditText) findViewById(R.id.location);
        contactPersonName = (EditText) findViewById(R.id.contactPersonName);
        email = (EditText) findViewById(R.id.email);
        mobileNo = (EditText) findViewById(R.id.mobileNo);
        budget = (EditText) findViewById(R.id.budget);
        description = (EditText) findViewById(R.id.description);
        btnAdd = findViewById(R.id.addbutton);



       btnAdd.setOnClickListener(new View.OnClickListener() {
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

               Hotel_DBHelper hotelDbHelper = new Hotel_DBHelper(AddHotel.this);

               Hotel hotel = new Hotel(HotelName,WebSite,Location,ContactPersonName,Email,MobileNo,Budget,Description);

               Intent intent = new Intent(AddHotel.this,HotelList.class);
               startActivity(intent);

               long val = hotelDbHelper.addHotel(hotel);

               if(val > 0){
                   Toast.makeText(AddHotel.this, "New Hotel Added Sucessfully ", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(AddHotel.this, "New Hotel Added Unsucessfully", Toast.LENGTH_LONG).show();
               }
           }
       });
    }
 /*    public void addButton(View view){
        Hotel_DBHelper dbHelper = new Hotel_DBHelper( this);

        long val = dbHelper.addButton(hotelName.getText().toString(),webSite.getText().toString(),location.getText().toString(),contactPersonName.getText().toString(),email.getText().toString(),mobileNo.getText().toString(),budget.getText().toString(),description.getText().toString());

        if(val > 0){
            Toast.makeText(this, "New Hotel Added Sucessfully ", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText( this, "New Hotel Added Unsucessfully", Toast.LENGTH_LONG).show();
        }
    }*/

}


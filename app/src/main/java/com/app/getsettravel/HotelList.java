
package com.app.getsettravel;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.app.getsettravel.Database.Hotel_DBHelper;
import com.app.getsettravel.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelList extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private List<Hotel> hotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        add = findViewById(R.id.addhotel);
        listView = findViewById(R.id.list);
        final Hotel_DBHelper hotelDbHelper = new Hotel_DBHelper(this);
        hotels = new ArrayList<>();

        hotels = hotelDbHelper.getAllHotel();

        HotelAdapter adapter = new HotelAdapter(HotelList.this,R.layout.singlehotel,hotels);


        listView.setAdapter(adapter);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentadd = new Intent(HotelList.this, AddHotel.class);
                startActivity(intentadd);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Hotel hotel = hotels.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(HotelList.this);
                builder.setTitle(hotel.getHotelName());
                builder.setMessage(hotel.getBudget());
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent3 = new Intent(HotelList.this, UpdateHotel.class);
                        intent3.putExtra("Id", String.valueOf(hotel.getId()));
                        startActivity(intent3);
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        hotelDbHelper.deletehotel(hotel.getId());
                        Intent intent3 = new Intent(HotelList.this,HotelList.class);
                        startActivity(intent3);

            }
        });

                builder.setNeutralButton("MoreInfo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent4 = new Intent(HotelList.this,HotelMoreInfo.class);
                        intent4.putExtra("Id",String.valueOf(hotel.getId()));
                        startActivity(intent4);
                    }
                });
                builder.show();
            }
        });
    }
}


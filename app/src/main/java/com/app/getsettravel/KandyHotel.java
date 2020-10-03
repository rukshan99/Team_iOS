package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class KandyHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandy_hotel);
    }

    public  void  ClickAranButton(View view){

        Intent intent = new Intent(KandyHotel.this,Heladive_Hotel.class);
        startActivity(intent);

    }
    public  void  ClickAraButton(View view){

        Intent intent = new Intent(KandyHotel.this,Anatamaa_Hotel.class);
        startActivity(intent);

    }
}
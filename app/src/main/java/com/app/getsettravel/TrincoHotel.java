package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TrincoHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinco_hotel);
    }

    public  void  ClickGranButton(View view){

        Intent intent = new Intent(TrincoHotel.this,Grand_Hotel.class);
        startActivity(intent);

    }
    public  void  ClickAranyButton(View view){

        Intent intent = new Intent(TrincoHotel.this,Aranya_Hotel.class);
        startActivity(intent);

    }
}
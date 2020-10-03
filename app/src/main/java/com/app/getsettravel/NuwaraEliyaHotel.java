package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NuwaraEliyaHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuwara_eliya_hotel);
    }

    public  void  ClickAranyaButton(View view){

        Intent intent = new Intent(NuwaraEliyaHotel.this,Aranya_Hotel.class);
        startActivity(intent);

    }

    public  void  ClickAntanaButton(View view){

        Intent intent = new Intent(NuwaraEliyaHotel.this,Anatamaa_Hotel.class);
        startActivity(intent);

    }
}
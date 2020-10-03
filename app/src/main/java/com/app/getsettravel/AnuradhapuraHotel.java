package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AnuradhapuraHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuradhapura_hotel);




    }

    public  void  ClickAranyaButton(View view){

       Intent intent1 = new Intent(AnuradhapuraHotel.this,Aranya_Hotel.class);
        startActivity(intent1);

    }

    public  void  ClickHeladiveButton(View view){

        Intent intent2 = new Intent(AnuradhapuraHotel.this,Heladive_Hotel.class);
        startActivity(intent2);

    }

}
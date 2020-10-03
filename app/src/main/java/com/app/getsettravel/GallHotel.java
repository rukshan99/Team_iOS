package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GallHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gall_hotel);
    }

    public  void  ClickSereneButton(View view){

        Intent intent = new Intent(GallHotel.this,Serene_Hotel.class);
        startActivity(intent);

    }

    public  void  ClickGrandButton(View view){

        Intent intent = new Intent(GallHotel.this,Grand_Hotel.class);
        startActivity(intent);

    }
}
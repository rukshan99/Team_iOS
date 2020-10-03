package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Location extends AppCompatActivity {
    private Button btNuwaraeliya,btKandy,btGall,btAnuradhapura,btTrinco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        btNuwaraeliya = (Button) findViewById(R.id.btNuwaraeliya);
        btAnuradhapura = (Button) findViewById(R.id.btAnuradhapura);
        btGall = (Button) findViewById(R.id.btGalle);
        btKandy = (Button) findViewById(R.id.btKandy);
        btTrinco = (Button) findViewById(R.id.btTrinco);

        btNuwaraeliya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuwaraeliya();
            }
        });

        btTrinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trincomalee();
            }
        });

        btKandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kandy();
            }
        });

        btGall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galle();
            }
        });

        btAnuradhapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anuradhapura();
            }
        });
    }
    public void  nuwaraeliya(){
        Intent intent1 = new Intent(this, NuwaraEliyaHotel.class);
        startActivity(intent1);
    }
    public void  anuradhapura(){
        Intent intent2 = new Intent(this, AnuradhapuraHotel.class);
        startActivity(intent2);
    }
    public void  galle(){
        Intent intent3 = new Intent(this, GallHotel.class);
        startActivity(intent3);
    }
    public void  kandy(){
        Intent intent4 = new Intent(this, KandyHotel.class);
        startActivity(intent4);
    }
    public void  trincomalee(){
        Intent intent5 = new Intent(this, TrincoHotel.class);
        startActivity(intent5);
    }
}
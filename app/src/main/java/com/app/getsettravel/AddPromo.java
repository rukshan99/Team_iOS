package com.app.getsettravel;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.getsettravel.Database.DBHelper;


public class AddPromo extends AppCompatActivity {

    EditText etCode,etType,etOffer,etDes;
    Button btsub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        etCode = (EditText) findViewById(R.id.etCode);
        etType = (EditText) findViewById(R.id.etType);
        etOffer = (EditText) findViewById(R.id.etOffer);
        etDes = (EditText) findViewById(R.id.etDes);
        btsub = (Button) findViewById(R.id.btsub);

        final DBHelper dbHelper = new DBHelper(this);
    }


    public void addPromo(View view) {
        Intent intent2 = new Intent(AddPromo.this,PromotionList.class);

        DBHelper dbHelper = new DBHelper(this);

        long val = dbHelper.addPromo(etCode.getText().toString(), etType.getText().toString(), etOffer.getText().toString(), etDes.getText().toString());

        if (val > 0) {
            Toast.makeText(this, "Promotion Added Sucessfully ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Promotion Added Unsucessfully", Toast.LENGTH_LONG).show();
        }
        startActivity(intent2);
    }
}

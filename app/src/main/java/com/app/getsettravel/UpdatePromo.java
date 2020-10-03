package com.app.getsettravel;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.getsettravel.Database.DBHelper;


public class UpdatePromo extends AppCompatActivity {

    EditText etCode,etType,etOffer,etDes;
    Button btupdate;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_promo);
        dbHelper = new DBHelper(UpdatePromo.this);

        /*setContentView(R.layout.activity_promotion);*/
        etCode = (EditText) findViewById(R.id.uetCode);
        etType = (EditText) findViewById(R.id.uetType);
        etOffer = (EditText) findViewById(R.id.uetOffer);
        etDes = (EditText) findViewById(R.id.uetDes);
        btupdate = (Button) findViewById(R.id.btupdate);

        final String id = getIntent().getStringExtra("Id");
        Pro pro = dbHelper.getPro(Integer.parseInt(id));

        etCode.setText(pro.getPcode());
        etType.setText(pro.getPtype());
        etOffer.setText(pro.getPoffer());
        etDes.setText(pro.getPdes());

        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etcode = etCode.getText().toString();
                String ettype = etType.getText().toString();
                String etoffer = etOffer.getText().toString();
                String etdes = etDes.getText().toString();

                Pro pro = new Pro(Integer.parseInt(id), etcode, ettype, etoffer, etdes);
                int state = dbHelper.updatePro(pro);
                Intent intent = new Intent(UpdatePromo.this, AddPromo.class);
                startActivity(intent);

            }
        });

    }
}
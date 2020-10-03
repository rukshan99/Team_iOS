package com.app.getsettravel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.Database.UserDBHelper;

public class EditDetails extends AppCompatActivity {

    UserDBHelper getsettravel;

    TextView name;
    EditText email, pass, phone, add;
    Button update;
    private String user_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        Intent getIntent = getIntent();
        user_Name = getIntent.getStringExtra("userName");

        name = findViewById(R.id.uName);
        name.setText(user_Name);
        /*user_Name = findViewById(R.id.uName);*/
        email = findViewById(R.id.uEmail);
        pass = findViewById(R.id.pass);
        phone = findViewById(R.id.phone);
        add = findViewById(R.id.address);
        update = findViewById(R.id.buttonUpdate);


        getsettravel = new UserDBHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();
                String passTXT = pass.getText().toString();
                String phoneTXT = phone.getText().toString();
                String addTXT = add.getText().toString();
                String updateTXT = update.getText().toString();


                Boolean checkInsertData = getsettravel.updateData(nameTXT, emailTXT, passTXT, addTXT, phoneTXT);
                if (checkInsertData == true) {

                    Toast.makeText(EditDetails.this, "Data updated successfully", Toast.LENGTH_SHORT).show();

                } else

                    Toast.makeText(EditDetails.this, "Data update unsuccessfully", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
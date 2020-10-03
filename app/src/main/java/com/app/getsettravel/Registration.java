package com.app.getsettravel;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.getsettravel.data.UserDBHelper;

public class Registration extends AppCompatActivity {

    EditText userName,password,rePass,email,address,phone;
    Button signIn,signUp;
    UserDBHelper getsettravel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = (EditText) findViewById(R.id.uName);
        email = (EditText) findViewById(R.id.uEmail);
        password = (EditText) findViewById(R.id.pass);
        rePass= (EditText) findViewById(R.id.rePass);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);

        signUp = (Button) findViewById(R.id.buttonSignUp);
        signIn = (Button) findViewById(R.id.buttonSignIn);

        getsettravel = new UserDBHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                String rPass = rePass.getText().toString();
                String uEmail = email.getText().toString();
                String add = address.getText().toString();
                String phoneNo = phone.getText().toString();

                if (user.equals("")||pass.equals("")||rPass.equals("")||uEmail.equals("")||add.equals("")||phoneNo.equals("")) {
                    Toast.makeText(Registration.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(rPass)) {

                        Boolean checkUser = getsettravel.checkUsername(user);

                        if (checkUser == false) {
                            Boolean insert = getsettravel.insertData(user, pass, uEmail, add, phoneNo);

                            if (insert == true) {
                                Toast.makeText(Registration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registration.this,Login.class));
                            }

                        } else {

                            Toast.makeText(Registration.this, "User Already exist.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(Registration.this, "Passwords not matching.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);

            }
        });

    }
}
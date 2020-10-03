package com.app.getsettravel;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.getsettravel.data.UserDBHelper;

public class Login extends AppCompatActivity {

    Button login,signUp;
    EditText uName,pass;
    UserDBHelper getsettrsvel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uName = findViewById(R.id.userName1);
        pass = findViewById(R.id.pass1);
        login = findViewById(R.id.buttonLogin);
        signUp = findViewById(R.id.buttonSup);
        getsettrsvel = new UserDBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = uName.getText().toString();
                String password = pass.getText().toString();

                if (user.equals("") || password.equals("")) {

                    Toast.makeText(Login.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();

                } else {

                    if (user.equals("Admin")&& password.equals("Admin")) {



                        Toast.makeText(Login.this, "Sign In successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, AdminDashBoard.class));

                    } else {
                        Boolean checkUserPass = getsettrsvel.checkUsernamePassword(user, password);
                        if (checkUserPass == true) {

                            Toast.makeText(Login.this, "Sign In successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, home.class);
                            intent.putExtra("userName",user);
                            startActivity(intent);

                        } else
                            Toast.makeText(Login.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                }
            }




        });




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login.this,Registration.class));

            }
        });




    }
}
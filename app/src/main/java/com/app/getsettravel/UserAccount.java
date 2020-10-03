package com.app.getsettravel;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.getsettravel.Database.UserDBHelper;
import com.app.getsettravel.model.User;

public class UserAccount extends AppCompatActivity {


    Button edit,signout,forgotPass,delete;
    UserDBHelper getsettravel;
    TextView userName,email,phone,address;
    private  String user_Name;
    /*private no.nordicsemi.android.nrftoolbox.myDbAdapter mydb;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        Intent getIntent = getIntent();
        user_Name = getIntent.getStringExtra("userName");



        /* setContentView(R.layout.activity_registration);*/

        userName = findViewById(R.id.textViewUserName);
        email = findViewById(R.id.textViewEmail);
        phone = findViewById(R.id.textViewPhone);
        address = findViewById(R.id.textViewAddress);

        getsettravel = new UserDBHelper(this);

        User user = getsettravel.getUser(user_Name);

        userName.setText(user.getName());
        email.setText(user.getEmail());
        phone.setText(user.getAdd());
        address.setText(user.getPhone());



        edit = findViewById(R.id.buttonEditUser);
        forgotPass = findViewById(R.id.buttonFogotPass);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UserAccount.this, EditDetails.class);
                intent.putExtra("userName",user_Name);
                startActivity(intent);
                /*startActivity(new Intent(UserAccount.this, EditDetails.class));*/


            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserAccount.this, ResetPassword.class));

            }
        });


        signout = findViewById(R.id.buttonSignOut);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserAccount.this, Index.class));


            }
        });


        delete = findViewById(R.id.buttonDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Boolean checkInsertData = getsettravel.deleteData(user_Name);
                if (checkInsertData == true) {

                    Toast.makeText(UserAccount.this, "Account Deleted successfully", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(UserAccount.this, "User does not exists", Toast.LENGTH_SHORT).show();


                }


            }

        });


    }

}
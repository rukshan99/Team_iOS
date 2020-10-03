package com.app.getsettravel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.Database.UserDBHelper;

public class ResetPassword extends AppCompatActivity {

    Button reset;
    EditText name,newPass,reNewPass;
    UserDBHelper getsettravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        name = findViewById(R.id.enterUserName);
        newPass = findViewById(R.id.newPass);
        reNewPass = findViewById(R.id.reNewPass);
        reset = findViewById(R.id.buttonReset);

        getsettravel = new UserDBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameTXT = name.getText().toString();
                String newPassTXT = newPass.getText().toString();
                String reNewPassTXT = reNewPass.getText().toString();

                Boolean checkUser = getsettravel.checkUsername(nameTXT);

                if (checkUser == true) {

                    if (newPassTXT.equals(reNewPassTXT)) {


                        Boolean checkUpdatePassword = getsettravel.ResetPassword(nameTXT, newPassTXT);

                        if (checkUpdatePassword == true) {

                            /*startActivity(new Intent(ResetPassword.this,login.class));*/
                            Toast.makeText(ResetPassword.this, "Password reset successfully", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(ResetPassword.this, "Password reset unsuccessfully", Toast.LENGTH_SHORT).show();

                        }

                    } else {

                        Toast.makeText(ResetPassword.this, "Passwords not matching", Toast.LENGTH_SHORT).show();

                    }


                }
                else {

                    Toast.makeText(ResetPassword.this, "User does not exist", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
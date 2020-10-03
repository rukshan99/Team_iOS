package com.app.getsettravel;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.app.getsettravel.data.UserDBHelper;
import com.app.getsettravel.model.User;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    ListView userList;
    ArrayList<User> usersList;
    UserDBHelper userDbHelper;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userList = findViewById(R.id.userListView);
        userDbHelper = new UserDBHelper(this);
        usersList = new ArrayList<>();


        LoadDataInListView();

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final  User user = usersList.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(UserList.this);
                builder.setTitle("Manage User Details");
                builder.setMessage(user.getName());
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Boolean checkInsertData = userDbHelper.deleteData(user.getName());
                        if (checkInsertData == true) {

                            Toast.makeText(UserList.this, "User Deleted successfully", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(UserList.this, "User does not exists", Toast.LENGTH_SHORT).show();


                        }

                    }
                });
                builder.show();
            }

        });




    }




    public  void LoadDataInListView(){

        usersList = userDbHelper.getUsers();
        userAdapter =  new UserAdapter(this,usersList);
        userList.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();



    }

}
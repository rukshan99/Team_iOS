package com.app.getsettravel;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.app.getsettravel.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDetails extends AppCompatActivity {

    ListView listView;

    private List<FeedbackV> feedbackVS;
    private Context context;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_details);

        listView = findViewById(R.id.listFeedback);

        /*final DBHelper dbHelper = new DBHelper(context);*/
         dbHelper = new DBHelper(context);
        feedbackVS = new ArrayList<>();

        feedbackVS = dbHelper.getAllFeedback();

        FeedBackAdapter adapter = new FeedBackAdapter(context,R.layout.feedbackrow,feedbackVS);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                final FeedbackV feedbackV = feedbackVS.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit Riders Details");
                builder.setMessage(feedbackV.getComment() + "\n" + feedbackV.getFmail());
                builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHelper.deletefeedback(feedbackV.getId());
                        startActivity(new Intent(context,FeedbackDetails.class));
                    }
                });

                builder.show();
            }
        });





    }
}
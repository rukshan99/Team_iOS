package com.app.getsettravel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.app.getsettravel.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class PromotionList extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private List<Pro> promotions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_list);

        add = findViewById(R.id.addpro);
        listView = findViewById(R.id.list);
        final DBHelper dbHelper = new DBHelper(this);
        promotions = new ArrayList<>();

        promotions = dbHelper.getAllPro();

        ProAdapter adapter = new ProAdapter(PromotionList.this,R.layout.single_pro,promotions);

        listView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentadd = new Intent(PromotionList.this,AddPromo.class);
                startActivity(intentadd);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                final Pro pro = promotions.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(PromotionList.this);
                builder.setTitle(pro.getPcode());
                builder.setMessage(pro.getPtype());
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent3 = new Intent(PromotionList.this,UpdatePromo.class);
                        intent3.putExtra("Id",String.valueOf(pro.getId()));
                        startActivity(intent3);

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHelper.deletepro(pro.getId());
                        Intent intent2 = new Intent(PromotionList.this,PromotionList.class);
                        startActivity(intent2);

                    }
                });

                builder.show();
            }
        });
    }
}


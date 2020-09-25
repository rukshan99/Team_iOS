package com.app.getsettravel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.getsettravel.model.ModelPayment;

import java.util.ArrayList;
import java.util.List;

public class AdminBookingList extends AppCompatActivity {

    List<ModelPayment> bookingList;
    SQLiteDatabase mDatabase;
    ListView listViewBookings;
    AdminBookingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        listViewBookings = (ListView) findViewById(R.id.listViewBookings);
        bookingList = new ArrayList<>();

        //opening the database
        mDatabase = openOrCreateDatabase(PaymentDetails.DATABASE_NAME, MODE_PRIVATE, null);

        //this method will display the bookings in the list
        showBookingsFromDatabase();

    }

    private void showBookingsFromDatabase() {

        //use rawQuery(sql, selectionargs) for fetching all the Bookings
        Cursor cursorBookings = mDatabase.rawQuery("SELECT * FROM bookings", null);

        //if the cursor has some data
        if (cursorBookings.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the Booking list
                bookingList.add(new ModelPayment(
                        cursorBookings.getInt(0),
                        cursorBookings.getInt(1),
                        cursorBookings.getString(2),
                        cursorBookings.getString(3),
                        cursorBookings.getInt(4),
                        cursorBookings.getString(5),
                        cursorBookings.getString(6),
                        cursorBookings.getInt(7),
                        cursorBookings.getFloat(8),
                        cursorBookings.getString(9),
                        cursorBookings.getInt(10),
                        cursorBookings.getInt(11),
                        cursorBookings.getInt(12),
                        cursorBookings.getString(13),
                        // cursorBookings.getString(14),
                        cursorBookings.getString(14)
                ));
            } while (cursorBookings.moveToNext());
        }
        //closing the cursor
        cursorBookings.close();

        //creating the adapter object
        adapter = new AdminBookingAdapter(this, R.layout.admin_list_layout_booking, bookingList,mDatabase);

        //adding the adapter to listview
        listViewBookings.setAdapter(adapter);
    }
}

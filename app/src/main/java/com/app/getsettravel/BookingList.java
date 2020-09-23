package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.getsettravel.model.ModelPayment;

import java.util.ArrayList;
import java.util.List;

public class BookingList extends AppCompatActivity {

    List<ModelPayment> bookingList;
    SQLiteDatabase mDatabase;
    ListView listViewBookings;
    BookingAdapter adapter;
    Button b1;

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

        //creating a notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description =
                    getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new
                    NotificationChannel("@string/CHANNEL_ID", name, importance);
            channel.setDescription(description);
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

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
                        cursorBookings.getInt(2),
                        cursorBookings.getInt(3),
                        cursorBookings.getInt(4),
                        cursorBookings.getInt(5),
                        cursorBookings.getInt(6),
                        cursorBookings.getString(7),
                        cursorBookings.getString(8),
                        cursorBookings.getString(9),
                        cursorBookings.getString(10),
                        cursorBookings.getString(11),
                        cursorBookings.getString(12),
                        cursorBookings.getString(13),
                       // cursorBookings.getString(14),
                        cursorBookings.getFloat(14)
                ));
            } while (cursorBookings.moveToNext());
        }
        //closing the cursor
        cursorBookings.close();

        //creating the adapter object
        adapter = new BookingAdapter(this, R.layout.list_layout_booking, bookingList,mDatabase);

        //adding the adapter to listview
        listViewBookings.setAdapter(adapter);
    }

    public void paymentConfirm(View view) {
        Intent myIntent = new Intent(BookingList.this, Payment_confirm.class);

        //creating a notification
        Intent intent = new Intent(this, Feedback.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "@string/CHANNEL_ID")
                .setSmallIcon(R.drawable.debitcard)
                .setContentTitle("Payment Validated!")
                .setContentText("Your payment details have been validated and the payment has been successful. Enjoy your vacation. Tap here to give feedback. Thank you.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, builder.build());

        BookingList.this.startActivity(myIntent);

    }


    public void addAnotherBooking(View view) {
        Intent myIntent = new Intent(BookingList.this, BookingDetails.class);
        BookingList.this.startActivity(myIntent);
    }



}
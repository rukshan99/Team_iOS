package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PaymentDetails extends AppCompatActivity implements View.OnClickListener{

    Integer noOfRooms, noOfNights;
    String checkInTime, roomType, checkInDate, hotelName;
    Float bookingCost;

    public static final String DATABASE_NAME = "getsettravel";
    SQLiteDatabase mDatabase;

    TextInputEditText cardNumber, month, year, securityNumber, cardHolderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        /***
         *
         * Initializing the values passed from the Amount page***/
        Intent intent = getIntent();
        hotelName = intent.getStringExtra("HOTEL_NAME");
        bookingCost = intent.getFloatExtra("BOOKING_COST",1000);
        roomType = intent.getStringExtra("ROOM_TYPE");
        noOfRooms = intent.getIntExtra("NO_OF_ROOMS",1);
        checkInDate = intent.getStringExtra("CHECK_IN_DATE");
        checkInTime = intent.getStringExtra("CHECK_IN_TIME");
        noOfNights = intent.getIntExtra("NO_OF_NIGHTS",1);

        /***
         *
         * Assigning the values added from the payment details form to variables***/
        cardNumber = (TextInputEditText)findViewById(R.id.textInputEditText);
        month = (TextInputEditText)findViewById(R.id.editText2);
        year = (TextInputEditText)findViewById(R.id.editText3);
        securityNumber = (TextInputEditText)findViewById(R.id.editText4);
        cardHolderName = (TextInputEditText)findViewById(R.id.editText5);

        findViewById(R.id.button).setOnClickListener(this);

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
    }


    /***
     *
     * The method for the Create operation***/
    private void addBookingDetails(){

        String Card_number = cardNumber.getText().toString().trim();
        String Month = month.getText().toString();
        String Year = year.getText().toString();
        String Security_number = securityNumber.getText().toString();
        String Card_Holder = cardHolderName.getText().toString().trim();

        //getting the current time for payment date
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String paymentDate = sdf.format(cal.getTime());

        String insertSQL = "INSERT INTO bookings \n" +
                "(RoomType, NoOfRooms, CheckInDate, CheckInTime, NoOfNights, Amount, CardNumber, Month, Year, SecurityNumber, CardHolder, PaymentDate)\n" +
                "VALUES \n" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        mDatabase.execSQL(insertSQL, new String[]{roomType, String.valueOf(noOfRooms), checkInDate, checkInTime, String.valueOf(noOfNights), String.valueOf(bookingCost),
                Card_number, Month, Year, Security_number, Card_Holder, paymentDate});

        Toast.makeText(this, "Booking and Payment details Saved!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        addBookingDetails();

        /***
         *
         * redirecting to RUD operations***///////////////////////////////////////////////////////////////
        Intent myIntent = new Intent(PaymentDetails.this, RUDPayment.class);
        PaymentDetails.this.startActivity(myIntent);
    }

    private void createBookingDetailsTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS bookings (\n" +
                        "    BookingId int NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "    CustomerID int,\n" +
                        "    Hotel varchar(200) ,\n" +
                        "    RoomType varchar(200) NOT NULL,\n" +
                        "    NoOfRooms int NOT NULL,\n" +
                        "    CheckInDate varchar(200) NOT NULL,\n" +
                        "    CheckInTime varchar(200) NOT NULL,\n" +
                        "    NoOfNights int NOT NULL,\n" +
                        "    Amount real NOT NULL,\n" +
                        "    CardNumber varchar(200) NOT NULL,\n" +
                        "    Month varchar(200) NOT NULL,\n" +
                        "    Year varchar(200) NOT NULL,\n" +
                        "    SecurityNumber varchar(200) NOT NULL,\n" +
                        "    CardHolder varchar(200) NOT NULL,\n" +
                        "    PaymentDate varchar(200) NOT NULL \n);"
        );
    }
}
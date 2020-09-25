package com.app.getsettravel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.getsettravel.model.ModelPayment;

import java.util.List;

public class AdminBookingAdapter extends ArrayAdapter<ModelPayment> {

    Context mCtx;
    int listLayoutRes;
    List<ModelPayment> BookingList;
    SQLiteDatabase mDatabase;

    public AdminBookingAdapter(Context mCtx, int listLayoutRes, List<ModelPayment> bookingList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, bookingList);
        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        BookingList = bookingList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        final ModelPayment booking = BookingList.get(position);


        //getting admin views
        TextView adminViewBookingId = view.findViewById(R.id.adminViewBookingId);
        TextView adminViewUserId = view.findViewById(R.id.adminViewUserId);
        TextView adminViewHotelName = view.findViewById(R.id.adminViewHotelName);
        TextView adminViewRooms = view.findViewById(R.id.adminViewRooms);
        TextView adminViewCheckIn = view.findViewById(R.id.adminViewCheckIn);
        TextView adminViewNoNights = view.findViewById(R.id.adminViewNoNights);
        TextView adminViewAmount = view.findViewById(R.id.adminViewAmount);
        TextView adminViewCardNo = view.findViewById(R.id.adminViewCardNo);
        TextView adminViewMMYY = view.findViewById(R.id.adminViewMonthYear);
        TextView adminViewSecurityNo = view.findViewById(R.id.adminViewSecurityNo);
        TextView adminViewCardHolder = view.findViewById(R.id.adminViewCardHolder);


        //adding data to admin views
        adminViewBookingId.setText("Booking ID: "+booking.getBookingId());
        adminViewUserId.setText("User ID: ");
        adminViewHotelName.setText("Hotel: "+booking.getHotelName());
        adminViewRooms.setText(booking.getRoomType()+" Rooms: "+booking.getNoOfRooms());
        adminViewCheckIn.setText("Check in: "+booking.getCheckInDate() + " | " + booking.getCheckInTime());
        adminViewNoNights.setText("Nights: "+booking.getNoOfNights());
        adminViewAmount.setText("LKR "+booking.getBookingCost()+"0");
        adminViewCardNo.setText("Card no: "+booking.getCardNumber());
        adminViewMMYY.setText("MM: "+booking.getMonth()+" , YY: "+booking.getYear());
        adminViewSecurityNo.setText("Security: "+booking.getSecurityNumber());
        adminViewCardHolder.setText(booking.getCardHolder()+"");

        return view;
    }
}

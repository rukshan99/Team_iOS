package com.app.getsettravel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.getsettravel.model.ModelPayment;

import java.util.List;

public class BookingAdapter extends ArrayAdapter<ModelPayment> {

    Context mCtx;
    int listLayoutRes;
    List<ModelPayment> BookingList;
    SQLiteDatabase mDatabase;

    public BookingAdapter(Context mCtx, int listLayoutRes, List<ModelPayment> bookingList, SQLiteDatabase mDatabase) {
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


        //getting views
        TextView textViewHotel = view.findViewById(R.id.textViewHotel);
        TextView textViewRoomType = view.findViewById(R.id.textViewRoomType);
        TextView textViewAmount = view.findViewById(R.id.textViewAmount);
        TextView textViewBookingDate = view.findViewById(R.id.textViewBookingDate);

        //adding data to views
        textViewHotel.setText(booking.getHotelName());
        textViewRoomType.setText(booking.getRoomType());
        textViewAmount.setText(String.valueOf(booking.getBookingCost()));
        textViewBookingDate.setText(booking.getPaymentDate());

        //we will use these buttons for update and delete operation
        Button buttonDelete = view.findViewById(R.id.buttonDeletePayment);
        Button buttonEdit = view.findViewById(R.id.buttonEditPayment);

        //adding a clicklistener to button
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatePaymentDetails(booking);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM bookings WHERE BookingId = ?";
                        mDatabase.execSQL(sql, new Integer[]{booking.getBookingId()});
                        reloadBookingsFromDatabase();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return view;
    }

    private void updatePaymentDetails(final ModelPayment payment) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.dialog_update_payment, null);
        builder.setView(view);

        final EditText editTextUpdateCardNo = view.findViewById(R.id.editTextUpdateCardNo);
        final EditText editTextUpdateMonth = view.findViewById(R.id.editTextUpdateMonth);
        final EditText editTextUpdateYear = view.findViewById(R.id.editTextUpdateYear);
        final EditText editTextUpdateSecurityNo = view.findViewById(R.id.editTextUpdateSecurityNo);
        final EditText editTextUpdateCardHolderName = view.findViewById(R.id.editTextUpdateCardHolderName);

        editTextUpdateCardNo.setText(String.valueOf(payment.getCardNumber()));
        editTextUpdateMonth.setText(String.valueOf(payment.getMonth()));
        editTextUpdateYear.setText(String.valueOf(payment.getYear()));
        editTextUpdateSecurityNo.setText(String.valueOf(payment.getSecurityNumber()));
        editTextUpdateCardHolderName.setText(payment.getCardHolder());

        final AlertDialog dialog = builder.create();
        dialog.show();

        view.findViewById(R.id.buttonUpdatePayment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CardNo = editTextUpdateCardNo.getText().toString().trim();
                String Month = editTextUpdateMonth.getText().toString().trim();
                String Year = editTextUpdateYear.getText().toString().trim();
                String SecurityNo = editTextUpdateSecurityNo.getText().toString().trim();
                String CardHolderName = editTextUpdateCardHolderName.getText().toString().trim();


                if (CardNo.isEmpty()) {
                    editTextUpdateCardNo.setError("Card number can't be blank");
                    editTextUpdateCardNo.requestFocus();
                    return;
                }

                if (Month.isEmpty()) {
                    editTextUpdateMonth.setError("Month can't be blank");
                    editTextUpdateMonth.requestFocus();
                    return;
                }
                if (Year.isEmpty()) {
                    editTextUpdateYear.setError("Year can't be blank");
                    editTextUpdateYear.requestFocus();
                    return;
                }
                if (SecurityNo.isEmpty()) {
                    editTextUpdateSecurityNo.setError("Security number can't be blank");
                    editTextUpdateSecurityNo.requestFocus();
                    return;
                }
                if (CardHolderName.isEmpty()) {
                    editTextUpdateCardHolderName.setError("Card holder name can't be blank");
                    editTextUpdateCardHolderName.requestFocus();
                    return;
                }

                String sql = "UPDATE bookings \n" +
                        "SET CardNumber = ?, \n" +
                        "Month = ?, \n" +
                        "Year = ?, \n" +
                        "SecurityNumber = ?, \n" +
                        "CardHolder = ? \n" +
                        "WHERE BookingId = ?;\n";

                mDatabase.execSQL(sql, new String[]{CardNo, Month, Year, SecurityNo, CardHolderName, String.valueOf(payment.getBookingId())});
                Toast.makeText(mCtx, "Payment Details Updated", Toast.LENGTH_SHORT).show();
                reloadBookingsFromDatabase();

                dialog.dismiss();
            }
        });
    }

    private void reloadBookingsFromDatabase() {
        Cursor cursorBookings = mDatabase.rawQuery("SELECT * FROM bookings", null);
        if (cursorBookings.moveToFirst()) {
            BookingList.clear();
            do {
                BookingList.add(new ModelPayment(
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
        cursorBookings.close();
        notifyDataSetChanged();
    }
}

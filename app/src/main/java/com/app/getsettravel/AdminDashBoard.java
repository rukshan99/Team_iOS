package com.app.getsettravel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class AdminDashBoard extends AppCompatActivity {

    Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);

    }

    public void hotelDetailsDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_hotel_details);
        dialog.show();
    }

    public void promotionFeedbackDetailsDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_promotions_feedbacks);
        dialog.show();
    }

    public void clickHotelDetailsButton(View view) {

        hotelDetailsDialog(AdminDashBoard.this);
    }

    public void clickPromotionFeedbackDetailsButton(View view) {

        promotionFeedbackDetailsDialog(AdminDashBoard.this);
    }

    public void clickAddHotelDetailsButton(View view) {
        Intent myIntent = new Intent(AdminDashBoard.this, AddHotelDetails.class);
        AdminDashBoard.this.startActivity(myIntent);
    }
    public void clickAddHPromotionButton(View view) {
        Intent myIntent = new Intent(AdminDashBoard.this, AddPromo.class);
        AdminDashBoard.this.startActivity(myIntent);
    }
    public void clickViewPromotionsButton(View view) {
        Intent myIntent = new Intent(AdminDashBoard.this, PromotionList.class);
        AdminDashBoard.this.startActivity(myIntent);
    }
    public void clickViewFeedbacksButton(View view) {
        Intent myIntent = new Intent(AdminDashBoard.this, FeedbackDetails.class);
        AdminDashBoard.this.startActivity(myIntent);
    }

    public void clickPaymentDetailsButton(View view) {
        Intent myIntent = new Intent(AdminDashBoard.this, AdminBookingList.class);
        AdminDashBoard.this.startActivity(myIntent);
    }
}
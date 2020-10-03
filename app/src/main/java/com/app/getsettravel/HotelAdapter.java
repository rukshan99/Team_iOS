package com.app.getsettravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.getsettravel.model.Hotel;

import java.util.List;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private Context context;
    private int resource;
    List<Hotel> hotels;

    HotelAdapter(Context context, int resource, List<Hotel> hotels){
        super(context,resource,hotels);
        this.context = context;
        this.resource = resource;
        this.hotels = hotels;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView title = row.findViewById(R.id.Titleeee);


        Hotel hotel = hotels.get(position);
        title.setText(hotel.getHotelName());

        return row;
    }

}


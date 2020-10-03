package com.app.getsettravel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProAdapter extends ArrayAdapter<Pro> {

    private Context context;
    private int resource;
    List<Pro> promotions;

    ProAdapter(Context context, int resource, List<Pro> promotions){
        super(context,resource,promotions);
        this.context = context;
        this.resource = resource;
        this.promotions = promotions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title = row.findViewById(R.id.Titleeee);

        Pro pro = promotions.get(position);
        title.setText(pro.getPtype());

        return row;
    }
}

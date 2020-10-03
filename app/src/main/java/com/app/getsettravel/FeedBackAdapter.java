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

public class FeedBackAdapter extends ArrayAdapter<FeedbackV> {

    private Context context;
    private int resource;
    List<FeedbackV> feedbackVS;

    public FeedBackAdapter(Context context, int resource, List<FeedbackV> feedbackVS) {
        super(context, resource, feedbackVS);
        this.context = context;
        this.resource = resource;
        this.feedbackVS = feedbackVS;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView fedemail = row.findViewById(R.id.fedmail);
        TextView fedcomment = row.findViewById(R.id.fedcomment);


        FeedbackV feedbackV = feedbackVS.get(position);
        fedemail.setText(feedbackV.getFmail());
        fedcomment.setText(feedbackV.getComment());


        return row;
    }
}

package com.example.vee.eventsapp.views.implementations;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vee.eventsapp.R;

/**
 * Created by vee on 2/12/18.
 */

public class EventHolder extends RecyclerView.ViewHolder {
    public  TextView name;
    public  TextView venue;
    public  TextView seats;
    public  TextView price;
    public  TextView date;
    public  TextView labels;
    public EventHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        venue = itemView.findViewById(R.id.venue);
        seats = itemView.findViewById(R.id.available_seats);
        price = itemView.findViewById(R.id.price);
        date = itemView.findViewById(R.id.event_date);
        labels = itemView.findViewById(R.id.labels);
    }
}

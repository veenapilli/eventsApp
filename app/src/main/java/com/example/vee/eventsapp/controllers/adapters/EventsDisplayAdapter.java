package com.example.vee.eventsapp.controllers.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vee.eventsapp.R;
import com.example.vee.eventsapp.models.EventObject;
import com.example.vee.eventsapp.utils.Logger;
import com.example.vee.eventsapp.views.implementations.EventHolder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by vee on 2/12/18.
 */

public class EventsDisplayAdapter extends RecyclerView.Adapter<EventHolder>{
    private static final String TAG = EventsDisplayAdapter.class.getSimpleName();
    private final Context context;
    private final ArrayList<EventObject> events;
    private final int width;
    private final int height;
    private final boolean all;

    public EventsDisplayAdapter(Context context, ArrayList<EventObject> events, int w, int h, boolean all){
        Logger.logData(TAG, "Adapter");
        this.context = context;
        this.events = events;
        this.width = w;
        this.height = h;
        this.all = all;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Logger.logData(TAG, "create");

        EventHolder eventHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.event_item, parent, false);
        eventHolder = new EventHolder(v);
        return eventHolder;
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Logger.logData(TAG, "bind");
        final EventObject item = events.get(position);
        if(null != item){
            final EventHolder eventHolder = holder;
            eventHolder.name.setText(item.getName());
            eventHolder.seats.setText(String.valueOf(item.getAvailable_seats()));
            eventHolder.date.setText(item.getDate());
            eventHolder.price.setText(String.valueOf(item.getPrice()));
            eventHolder.venue.setText(item.getVenue());
            StringBuffer s = new StringBuffer();
            for (String tag : item.getLabels()
                    ) {
                s.append(tag + ", ");
            }
            if(s.length() > 2)
                s.replace(s.length()-2, s.length(), "");
            eventHolder.labels.setText(s.toString());
        }
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}

package com.example.vee.eventsapp.models;

import com.example.vee.eventsapp.utils.Logger;

import java.util.ArrayList;

/**
 * Created by vee on 2/12/18.
 */

public class EventData {
    ArrayList<EventObject> events;

    public void displayData() {
        for (EventObject e : events)
            Logger.logData(e.name, e.venue);
    }

    public ArrayList<EventObject> getEvents() {
        return events;
    }
}

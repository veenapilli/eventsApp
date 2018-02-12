package com.example.vee.eventsapp.models;

import com.example.vee.eventsapp.utils.Logger;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vee on 2/12/18.
 */

public class LoadedData {
    public static boolean AVAILABLE = false;
    public static boolean ONLY_PLAYS = false;
    public static boolean SORT_DATE = false;

    public static ArrayList<EventObject> events = new ArrayList<EventObject>();
    public static ArrayList<EventObject> updatedEvents = new ArrayList<EventObject>();
    public static ArrayList<EventObject> getData(int option){
        updatedEvents.clear();
        switch(option){
            case 0:
                if(AVAILABLE)
                    AVAILABLE = false;
                else
                    AVAILABLE = true;
                ONLY_PLAYS = false;
                SORT_DATE = false;

                if(AVAILABLE){
                    for (EventObject e:events
                            ) {
                        if(e.getAvailable_seats() > 0)
                            updatedEvents.add(e);
                    }
                }else{
                    updatedEvents.addAll(events);
                }
                break;
            case 1:
                if(ONLY_PLAYS)
                    ONLY_PLAYS = false;
                else
                    ONLY_PLAYS = true;
                AVAILABLE =false;
                SORT_DATE = false;
                if(ONLY_PLAYS){ //only plays
                    for (EventObject e:events
                            ) {
                        if(e.getLabels().contains("play")){
                            updatedEvents.add(e);
                        }
                    }
                }else{
                    updatedEvents.addAll(events);
                }
                break;
            case 2:
                if(SORT_DATE)
                    SORT_DATE = false;
                else
                    SORT_DATE = true;
                ONLY_PLAYS = false;
                AVAILABLE = false;

                if(SORT_DATE){
                    for (EventObject e:events
                            ) {
                        if(e.getDate() != null && e.getDate().length() > 0){
                            updatedEvents.add(e);
                        }
                        Collections.sort(updatedEvents, new Comparator<EventObject>() {
                            public int compare(EventObject o1, EventObject o2) {
                                return o1.getDate().compareTo(o2.getDate());
                            }
                        });
                    }

                }else{
                    updatedEvents.addAll(events);
                }
                break;

            default:
                updatedEvents.addAll(events);

        }
        return updatedEvents;
    }
    public static void setData(EventData eventData) {
        if(null != events && events.size() > 0){
            events.clear();
        }
        events = eventData.getEvents();
    }
    public static void displayData(){
        for (EventObject e:updatedEvents
                ) {
            Logger.logData(e.name, e.venue);
        }
    }
}

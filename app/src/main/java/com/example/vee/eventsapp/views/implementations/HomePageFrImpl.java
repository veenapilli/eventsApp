package com.example.vee.eventsapp.views.implementations;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vee.eventsapp.R;
import com.example.vee.eventsapp.controllers.adapters.EventsDisplayAdapter;
import com.example.vee.eventsapp.models.EventData;
import com.example.vee.eventsapp.models.EventObject;
import com.example.vee.eventsapp.models.LoadedData;
import com.example.vee.eventsapp.utils.Logger;
import com.example.vee.eventsapp.utils.MathUtil;
import com.example.vee.eventsapp.utils.NetworkUtil;
import com.example.vee.eventsapp.views.interfaces.HomePageFr;
import com.google.gson.Gson;

import java.util.ArrayList;

import io.reactivex.subjects.AsyncSubject;


/**
 * Created by vee on 2/12/18.
 */

public class HomePageFrImpl implements HomePageFr {
    final Handler handler = new Handler
            ();
    final Runnable uiRunnable = new Runnable() {
        @Override
        public void run() {
            Logger.logData(TAG, "in RUN");
            updateList(-1);
        }
    };

    AsyncSubject<EventObject> dataSource = AsyncSubject.create();

    private static final String TAG = HomePageFrImpl.class.getSimpleName();
    private final AppCompatActivity context;
    private final EventsDisplayAdapter eventsDisplayAdapter;
    private final View mRootView;
    private LinearLayoutManager mListLayoutManager;
    RecyclerView eventsList = null;
    ArrayList<EventObject> eventsData = new ArrayList<EventObject>();

    public HomePageFrImpl(AppCompatActivity context, LayoutInflater inflater, ViewGroup container) {
        this.context = context;
        if (!NetworkUtil.isNetworkAvailable(context)){
            Toast.makeText(context, "No Internet!", Toast.LENGTH_SHORT).show();
        }
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        eventsList = (RecyclerView) mRootView.findViewById(R.id.details_list);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        final int height = displayMetrics.heightPixels;
        eventsDisplayAdapter = new EventsDisplayAdapter(context, eventsData, width, height, false);
        mListLayoutManager = new LinearLayoutManager(context);
        eventsList.setLayoutManager(mListLayoutManager);
        eventsList.setAdapter(eventsDisplayAdapter);
        if(NetworkUtil.isNetworkAvailable(context)) {
            new FetchEvents().execute();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.available:
                updateList(0);
                break;
            case R.id.all:
                updateList(1);
                break;
            case R.id.sort:
                updateList(2);
                break;
        }
        return true;
    }

    private class FetchEvents extends AsyncTask<Void, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean success = false;
            String data = NetworkUtil.fetchEventsData();
            if(null != data){
                Gson gson = new Gson();
                success = true;
                try {
                    EventData events = gson.fromJson(data, EventData.class);
                    if(null != events) {
                        LoadedData.setData(events);
                        handler.post(uiRunnable);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return success;
        }

    }

    private void updateList(int option) {
        Logger.logData(TAG, "update list; displaying data");
        if (null != eventsData) {
            eventsData.clear();
        }
        eventsData.addAll(LoadedData.getData(option));
        Logger.logData(TAG, "ev len: " + eventsData.size());
        eventsDisplayAdapter.notifyDataSetChanged();
        if (option == 1 || option == 0) {
            int removedItems = LoadedData.events.size() - eventsData.size();
            if (removedItems > 0)
                Toast.makeText(context, removedItems + " items removed by filter.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "No items removed by filter", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}

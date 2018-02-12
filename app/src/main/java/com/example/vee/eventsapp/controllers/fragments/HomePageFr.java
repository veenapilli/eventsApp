package com.example.vee.eventsapp.controllers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vee.eventsapp.R;
import com.example.vee.eventsapp.views.implementations.HomePageFrImpl;


public class HomePageFr extends Fragment {
    HomePageFrImpl homePageFr = null;
    private static Fragment instance;
    public static Fragment getInstance() {
        instance = new HomePageFr();
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        homePageFr = new HomePageFrImpl((AppCompatActivity) getActivity(), inflater, container);
        return  homePageFr.getRootView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(null != homePageFr)
            return homePageFr.onOptionsItemSelected(item);
        else
            return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

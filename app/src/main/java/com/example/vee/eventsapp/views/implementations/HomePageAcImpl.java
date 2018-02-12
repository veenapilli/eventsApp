package com.example.vee.eventsapp.views.implementations;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.vee.eventsapp.R;
import com.example.vee.eventsapp.controllers.fragments.HomePageFr;
import com.example.vee.eventsapp.utils.NetworkUtil;

/**
 * Created by vee on 2/12/18.
 */

public class HomePageAcImpl {
    private final AppCompatActivity context;

    public HomePageAcImpl(AppCompatActivity context) {
        this.context = context;
        context.setContentView(R.layout.activity_home);
        context.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, HomePageFr.getInstance()).commit();

    }
}

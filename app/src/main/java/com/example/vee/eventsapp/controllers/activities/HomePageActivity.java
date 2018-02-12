package com.example.vee.eventsapp.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vee.eventsapp.views.implementations.HomePageAcImpl;
import com.example.vee.eventsapp.views.implementations.HomePageFrImpl;

public class HomePageActivity extends AppCompatActivity {
    public static AppCompatActivity context;

    HomePageAcImpl homePage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        homePage = new HomePageAcImpl(context);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.context = null;
    }
}

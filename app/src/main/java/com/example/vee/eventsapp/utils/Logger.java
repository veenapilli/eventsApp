package com.example.vee.eventsapp.utils;

import android.util.Log;

import com.example.vee.eventsapp.BuildConfig;

/**
 * Created by vee on 2/12/18.
 */

public class Logger {
    public static void logData(String tag, String data){
        if(BuildConfig.DEBUG){
            Log.v(tag, data);
        }
    }
    public static void logError(String tag, String data){
        if(BuildConfig.DEBUG){
            Log.e(tag, data);
        }
    }
}

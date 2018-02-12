package com.example.vee.eventsapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

/**
 * Created by vee on 2/12/18.
 */

public class NetworkUtil {
    private static final String TAG = NetworkUtil.class.getSimpleName();

    public static String fetchEventsData(){
        Logger.logData(TAG, "fetching data");
        String url = ServerSettings.getInstance().getServer() + "bridj-coding-challenge/events.json";
        String response = null;
        try {
            response = NetworkRequest.instantGetRequest(url);
            Logger.logData(TAG, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}


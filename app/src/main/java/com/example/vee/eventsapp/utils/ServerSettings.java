package com.example.vee.eventsapp.utils;

/**
 * Created by vee on 2/12/18.
 */

public class ServerSettings {
    private static ServerSettings serverSettings;
    private static String server = "";

    private ServerSettings(){
        if(Config.prodServer){
            server = Constants.SERVER_PROD;
        }
    }
    public static ServerSettings getInstance(){
        if(null == serverSettings){
            serverSettings = new ServerSettings();
        }
        return serverSettings;
    }

    public String getServer(){
        return server;
    }
}

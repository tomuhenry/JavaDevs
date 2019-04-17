package com.andela.tomusange.javadevsnairobi.view.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckConnection {

    private Context context;

    public CheckConnection(Context context){
        this.context = context;

    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo != null && netInfo.isConnectedOrConnecting()){
            android.net.NetworkInfo wifi = cm.getActiveNetworkInfo();
            android.net.NetworkInfo mobile_data = cm.getActiveNetworkInfo();
            if(mobile_data != null && mobile_data.isConnectedOrConnecting() || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        }
        else  return false;
    }
}

package com.nbservicesin.u15_instagramclone;

import android.app.Application;

import com.parse.Parse;


/**
 * Configuration class for the parse server
 * It has ben added in Manifest as  <application android:name=".App" ></application>
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );
    }
}

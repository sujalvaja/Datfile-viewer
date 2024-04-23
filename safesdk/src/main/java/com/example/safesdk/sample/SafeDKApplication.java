package com.example.safesdk.sample;

import android.app.Application;
import android.content.Context;
import com.example.safesdk.sample.utils.Logger;

public class SafeDKApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        Logger.m3601d("SafeDKApplication", "onCreate");
        context = getApplicationContext();
        SafeDK.m2703a(getApplicationContext());
        SafeDK.m2704a((Application) this);
    }

    public static Context getAppContext() {
        return context;
    }
}

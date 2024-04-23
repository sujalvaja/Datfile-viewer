package com.example.safesdk.sample.internal;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.utils.Logger;

public class DexBridge {
    public static String generateString(String content) {
        return content;
    }

    public static Context getContext() {
        return SafeDK.getInstance().mo19137g();
    }

    public static void appClassOnCreateBefore(Application app) {
        Logger.m3601d("SafeDKApplication", "onCreate");
        SafeDK.m2703a(app.getApplicationContext());
        SafeDK.m2704a(app);
    }

    public static void providerOnCreateBefore(ContentProvider provider) {
        Logger.m3601d(AppLovinBridge.f2360a, "Content Provider: onCreate");
        SafeDK.m2703a(provider.getContext());
    }
}

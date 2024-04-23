package com.example.safesdk.sample.internal.partials;

import android.webkit.WebView;
import com.example.safesdk.sample.internal.SafeDKWebAppInterface;
import com.example.safesdk.sample.utils.Logger;

/* compiled from: OpenMeasurementSourceFile */
public class OpenMeasurementNetworkBridge {
    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.m3600d("OpenMeasurementNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/OpenMeasurementNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.m3601d("SafeDKNetwork", "webviewLoadUrl. url: " + url);
        NetworkBridge.logWebviewLoadURLRequest("com.iab.omid.library", targetInstance, url);
        SafeDKWebAppInterface.m3504a("com.iab.omid.library", targetInstance, url);
        targetInstance.loadUrl(url);
    }
}

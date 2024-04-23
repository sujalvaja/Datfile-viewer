package com.example.safesdk.sample.internal.partials;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.internal.C1351f;
import com.example.safesdk.sample.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: FacebookAudienceNetworkSourceFile */
public class FacebookAudienceNetworkNetworkBridge {
    public static InputStream urlConnectionGetInputStream(URLConnection targetInstance) throws IOException {
        Logger.m3600d("FacebookAudienceNetworkNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/FacebookAudienceNetworkNetworkBridge;->urlConnectionGetInputStream(Ljava/net/URLConnection;)Ljava/io/InputStream;");
        String url = targetInstance.getURL().toString();
        Logger.m3601d("SafeDKNetwork", "urlConnectionGetInputStream : " + url);
        Map<String, List<String>> headerFields = targetInstance.getHeaderFields();
        InputStream inputStream = null;
        try {
            inputStream = targetInstance.getInputStream();
        } catch (Throwable th) {
            Logger.m3602d("SafeDKNetwork", "Exception in urlConnectionGetInputStream : " + th.getMessage(), th);
        }
        InputStream a = CreativeInfoManager.m3064a("com.facebook.ads", url, inputStream, headerFields);
        if ((targetInstance instanceof HttpURLConnection) && (a instanceof C1351f)) {
            Logger.m3601d("SafeDKNetwork", "following HttpURLConnection:" + targetInstance + " and stream: " + a);
            C1351f fVar = (C1351f) a;
            HttpURLConnection httpURLConnection = (HttpURLConnection) targetInstance;
            NetworkBridge.f3570a.put(httpURLConnection, fVar);
            fVar.mo19630a(httpURLConnection);
        }
        return a;
    }

    public static OutputStream urlConnectionGetOutputStream(URLConnection targetInstance) throws IOException {
        Logger.m3600d("FacebookAudienceNetworkNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/FacebookAudienceNetworkNetworkBridge;->urlConnectionGetOutputStream(Ljava/net/URLConnection;)Ljava/io/OutputStream;");
        OutputStream outputStream = targetInstance.getOutputStream();
        String url = targetInstance.getURL().toString();
        Logger.m3601d("SafeDKNetwork", "urlConnectionGetOutputStream url=" + url);
        return CreativeInfoManager.m3065a("com.facebook.ads", url, outputStream);
    }

    public static void httpUrlConnectionDisconnect(HttpURLConnection targetInstance) {
        Logger.m3600d("FacebookAudienceNetworkNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/FacebookAudienceNetworkNetworkBridge;->httpUrlConnectionDisconnect(Ljava/net/HttpURLConnection;)V");
        try {
            Logger.m3601d("SafeDKNetwork", "httpUrlConnectionDisconnect");
            C1351f remove = NetworkBridge.f3570a.remove(targetInstance);
            if (remove != null) {
                remove.mo19629a();
            }
        } catch (Throwable th) {
        }
        targetInstance.disconnect();
    }
}

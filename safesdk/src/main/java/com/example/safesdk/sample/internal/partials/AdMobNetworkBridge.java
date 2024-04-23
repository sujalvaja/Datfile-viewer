package com.example.safesdk.sample.internal.partials;

import android.webkit.WebView;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.internal.C1351f;
import com.example.safesdk.sample.internal.SafeDKWebAppInterface;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* compiled from: AdMobSourceFile */
public class AdMobNetworkBridge {
    public static InputStream urlConnectionGetInputStream(URLConnection targetInstance) throws IOException {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->urlConnectionGetInputStream(Ljava/net/URLConnection;)Ljava/io/InputStream;");
        String url = targetInstance.getURL().toString();
        Logger.m3601d("SafeDKNetwork", "urlConnectionGetInputStream : " + url);
        Map<String, List<String>> headerFields = targetInstance.getHeaderFields();
        InputStream inputStream = null;
        try {
            inputStream = targetInstance.getInputStream();
        } catch (Throwable th) {
            Logger.m3602d("SafeDKNetwork", "Exception in urlConnectionGetInputStream : " + th.getMessage(), th);
        }
        InputStream a = CreativeInfoManager.m3064a(C1357d.f3603k, url, inputStream, headerFields);
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
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->urlConnectionGetOutputStream(Ljava/net/URLConnection;)Ljava/io/OutputStream;");
        OutputStream outputStream = targetInstance.getOutputStream();
        String url = targetInstance.getURL().toString();
        Logger.m3601d("SafeDKNetwork", "urlConnectionGetOutputStream url=" + url);
        return CreativeInfoManager.m3065a(C1357d.f3603k, url, outputStream);
    }

    public static int httpUrlConnectionGetResponseCode(HttpURLConnection targetInstance) throws IOException {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->httpUrlConnectionGetResponseCode(Ljava/net/HttpURLConnection;)I");
        int responseCode = targetInstance.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            String url = targetInstance.getURL().toString();
            Logger.m3601d("SafeDKNetwork", "httpUrlConnectionGetResponseCode url=" + url);
            CreativeInfoManager.m3064a(C1357d.f3603k, url, targetInstance.getInputStream(), (Map<String, List<String>>) targetInstance.getHeaderFields());
        }
        return responseCode;
    }

    public static void httpUrlConnectionDisconnect(HttpURLConnection targetInstance) {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->httpUrlConnectionDisconnect(Ljava/net/HttpURLConnection;)V");
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

    public static void webviewLoadUrl(WebView targetInstance, String url) {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->webviewLoadUrl(Landroid/webkit/WebView;Ljava/lang/String;)V");
        Logger.m3601d("SafeDKNetwork", "webviewLoadUrl. url: " + url);
        NetworkBridge.logWebviewLoadURLRequest(C1357d.f3603k, targetInstance, url);
        SafeDKWebAppInterface.m3504a(C1357d.f3603k, targetInstance, url);
        targetInstance.loadUrl(url);
    }

    public static void webviewLoadDataWithBaseURL(WebView targetInstance, String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->webviewLoadDataWithBaseURL(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        CreativeInfoManager.m3076a(baseUrl, data, targetInstance.toString(), C1357d.f3603k);
        SafeDKWebAppInterface.m3504a(C1357d.f3603k, targetInstance, baseUrl);
        targetInstance.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    public static void webviewLoadData(WebView targetInstance, String data, String mimeType, String encoding) {
        Logger.m3600d("AdMobNetwork|SafeDK: Partial-Network> Lcom/safedk/android/internal/partials/AdMobNetworkBridge;->webviewLoadData(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");
        Logger.m3601d("SafeDKNetwork", "webviewLoadData: " + data);
        CreativeInfoManager.m3076a(C1357d.f3603k, data, targetInstance.toString(), C1357d.f3603k);
        SafeDKWebAppInterface.m3504a(C1357d.f3603k, targetInstance, data);
        targetInstance.loadData(data, mimeType, encoding);
    }
}

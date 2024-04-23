package com.example.safesdk.sample.internal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.itextpdf.text.html.HtmlTags;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SafeDKWebAppInterface {

    /* renamed from: a */
    public static  String f3385a = "SafeDKWebAppInterface";

    /* renamed from: b */
    public static  String f3386b = "status";

    /* renamed from: c */
    public static  String f3387c = "playing";

    /* renamed from: d */
    public static  String f3388d = "paused";

    /* renamed from: e */
    public static  String f3389e = "sdk_id";

    /* renamed from: f */
    public static  String f3390f = "javascript:";

    /* renamed from: g */
    public static  String f3391g = "(function(){var isMainFrame=function(){return window.location===window.parent.location};var log=function(message){try{window.webkit.messageHandlers.safedkDebug.postMessage(message)}catch(error){}};var sdkId=\"{{SDK_ID}}\";var isElementHidden=function(element){try{while(element){if(getComputedStyle(element).display==\"none\")return true;element=element.parentElement}}catch(error){window.webkit.messageHandlers.safedkVideoExc.postMessage(error.message+\"\\n\"+error.stack)}return false};var isElementInEventHidden=function(event){return isElementHidden(event.srcElement)};var getVideoPath=function(event){try{var videoElement=event.srcElement;if(videoElement.tagName!=\"VIDEO\")return null;var path=videoElement.src;if(!path){var sourceNodes=videoElement.getElementsByTagName(\"SOURCE\");for(var sourceNode of sourceNodes){if(sourceNode.src){path=sourceNode.src;break}}}if(path){if(path.length>=200){path=path.substring(0,199)}}return path}catch(error){window.webkit.messageHandlers.safedkVideoExc.postMessage(error.message+\"\\n\"+error.stack)}return null};var notifyPlay=function(event){if(isElementInEventHidden(event))return;event.srcElement.safedkVideoPlaying=true;var message={status:\"playing\",sdk_id:sdkId};var src=getVideoPath(event);if(src)message[\"src\"]=src;log(\"Notifying client that video is playing for SdkId: ${sdkId}\");window.webkit.messageHandlers.safedkVideo.postMessage(JSON.stringify(message))};var notifyPause=function(event){event.srcElement.safedkVideoPlaying=false;var message={status:\"paused\",sdk_id:sdkId};var src=getVideoPath(event);if(src)message[\"src\"]=src;log(\"Notifying client that video is paused for SdkId: ${sdkId}\");window.webkit.messageHandlers.safedkVideo.postMessage(JSON.stringify(message))};var addVideoListeners=function(doc){try{if(doc.nodeName==\"#text\")return;var videoElements=doc.getElementsByTagName(\"VIDEO\");if(videoElements.length==0){if(doc.tagName&&doc.tagName==\"VIDEO\"){videoElements=[doc]}}for(i=0;i<videoElements.length;i++){var videoElement=videoElements[i];if(videoElement.safedkVideoListeners!=true){log(\"Found VIDEO tag, adding event listeners. sdkId: ${sdkId}\");videoElement.safedkVideoListeners=true;videoElement.addEventListener(\"play\",notifyPlay);videoElement.addEventListener(\"pause\",notifyPause)}}}catch(error){}};log(\"Initializing\");addVideoListeners(document);try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var node of mutation.addedNodes){addVideoListeners(node)}for(var node of mutation.removedNodes){if(node.tagName){var removedVideoElements=node.getElementsByTagName(\"VIDEO\");for(var removedVideoElement of removedVideoElements){if(removedVideoElement.safedkVideoPlaying){log(\"VIDEO tag removed. Calling notifyPause\");var event={srcElement:removedVideoElement};notifyPause(event)}}}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){window.webkit.messageHandlers.safedkVideoExc.postMessage(error.message+\"\\n\"+error.stack)}})();\n";

    /* renamed from: h */
    public static Set<String> f3392h = new HashSet();

    /* renamed from: i */
    Context f3393i;

    public SafeDKWebAppInterface(Context c) {
        this.f3393i = c;
    }

    @JavascriptInterface
    public void postMessage(String msg) {
        String str;
        boolean z = false;
        Logger.m3601d(f3385a, "postMessage : msg = " + msg);
        try {
            JSONObject jSONObject = new JSONObject(msg);
            if (jSONObject.has("status") && jSONObject.get("status").equals(f3388d)) {
                z = true;
            }
            if (jSONObject.has(f3389e)) {
                str = jSONObject.getString(f3389e);
            } else {
                str = null;
            }
            Logger.m3605i(f3385a, "postMessage : status = " + z + ", sdk_id = " + str + ", src = " + (jSONObject.has(HtmlTags.SRC) ? jSONObject.get(HtmlTags.SRC) : "NA"));
            if (str != null) {
                Logger.m3601d(f3385a, "Calling creative info manager's video completed function");
                String[] split = str.split("_");
                CreativeInfoManager.m3080a(split[0], split[1], z);
            }
        } catch (JSONException e) {
            Logger.m3601d(f3385a, "Received msg is not a JSON object : " + msg);
        }
    }

    @JavascriptInterface
    public void logMessage(String msg) {
        Logger.m3605i(f3385a, "logMessage msg = " + msg);
    }

    @JavascriptInterface
    public void requestNoSampling(String sdkId) {
        Logger.m3605i(f3385a, "requestNoSampling : sdkId = " + sdkId);
        CreativeInfoManager.m3092c();
    }

    /* renamed from: a */
    public static void m3504a(String str, WebView webView, String str2) {
        String j = BrandSafetyUtils.m2922j(webView.toString());
        SafeDK instance = SafeDK.getInstance();
        Logger.m3601d(f3385a, "addJavaScriptInterfaceToWebViewIfNeeded started sdkPackage=" + str + ", webView=" + j + " ,url=" + str2 + " , isMaxInit=" + SafeDK.m2695P() + " , isWebViewTrackingDisabled=" + instance.mo19136e());
        if (!SafeDK.m2695P() || instance == null || instance.mo19136e()) {
            Logger.m3601d(f3385a, "SafeDK not initialized yet or WebView tracking is disabled, JS interface will not be added to WebView " + j);
        } else if (str2 == null || str2.startsWith(f3390f)) {
            Logger.m3601d(f3385a, "addJavaScriptInterfaceToWebViewIfNeeded loaded data is javascript, ignoring. url : " + str2);
        } else if (CreativeInfoManager.m3091b(str,  false) ||
                CreativeInfoManager.m3091b(str,  false)) {
            webView.addJavascriptInterface(new SafeDKWebAppInterface(webView.getContext()), f3385a);
            Logger.m3601d(f3385a, "addJavaScriptInterfaceToWebViewIfNeeded javascript interface added, WebView address is " + j);
            m3506b(str, webView, str2);
        } else {
            Logger.m3601d(f3385a, "addJavaScriptInterfaceToWebViewIfNeeded javascript interface NOT added, WebView address is " + j);
        }
    }

    /* renamed from: a */
    public static String m3503a(String str, String str2) {
        return f3390f + str2.replace("window.webkit.", "window.").replace("messageHandlers.safedkNoSamplingExc.postMessage", "SafeDKWebAppInterface.logMessage").replace("messageHandlers.safedkNoSampling.postMessage", "SafeDKWebAppInterface.requestNoSampling").replace("messageHandlers.safedkDebug.postMessage", "SafeDKWebAppInterface.logMessage").replace("{{SDK_ID}}", str);
    }

    /* renamed from: b */
    public static String m3505b(String str, String str2) {
        return f3390f + f3391g.replace("window.webkit.", "window.").replace("messageHandlers.safedkDebug.postMessage", "SafeDKWebAppInterface.logMessage").replace("messageHandlers.safedkVideoExc.postMessage", "SafeDKWebAppInterface.logMessage").replace("messageHandlers.safedkNoSampling.postMessage", "SafeDKWebAppInterface.logMessage").replace("messageHandlers.safedkVideo", f3385a).replace("{{SDK_ID}}", str + "_" + str2);
    }

    /* renamed from: b */
    public static void m3506b(String str, WebView webView, String str2) {
         String j = BrandSafetyUtils.m2922j(webView.toString());
        SafeDK instance = SafeDK.getInstance();
        if (SafeDK.m2695P() && instance != null && !SafeDK.getInstance().mo19136e()) {
             HashSet hashSet = new HashSet();
            Logger.m3601d(f3385a, "attachJsScriptIfNeeded sdk: " + str + ", address: " + j + " resource: " + str2);
            Bundle g = CreativeInfoManager.m3105g(str);
            if (g == null) {
                Logger.m3601d(f3385a, "attachJsScriptIfNeeded configBundle is empty, existing");
                return;
            }
            if (g != null) {
                Logger.m3601d(f3385a, "attachJsScriptIfNeeded sdk " + str + " items: js privacy : " + g.getBoolean(AdNetworkDiscovery.f2657n, false) + ", js video : " + g.getBoolean(AdNetworkDiscovery.f2648e, false));
            } else {
                Logger.m3601d(f3385a, "attachJsScriptIfNeeded sdk " + str + " config bundle is empty");
            }
            if (g.getBoolean(AdNetworkDiscovery.f2657n, false)) {
                String string = g.getString(AdNetworkDiscovery.f2658o, (String) null);
                if (string == null || string.length() <= 0) {
                    Logger.m3601d(f3385a, "attachJsScriptIfNeeded privacy button click detection script is empty, skipping.");
                } else {
                    hashSet.add(m3503a(str, string));
                    Logger.m3601d(f3385a, "attachJsScriptIfNeeded added privacy button click detection script.");
                }
            }
            if (g.getBoolean(AdNetworkDiscovery.f2648e)) {
                hashSet.add(m3505b(str, j));
            } else {
                Logger.m3601d(f3385a, "attachJsScriptIfNeeded no need to add video detection script. WebView : " + j);
            }
             String str3 = str;
             String str4 = str2;
             WebView webView2 = webView;
            webView.post(new Runnable() {
                public void run() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            if (str != null && str.length() > 0) {
                                C1361h.m3694b(SafeDKWebAppInterface.f3385a, "Injecting script for " + str3 + " WebView : " + j + ", url = " + str4);
                                webView2.evaluateJavascript(str, (ValueCallback) null);
                            }
                        }
                        hashSet.clear();
                        return;
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        String str2 = (String) it2.next();
                        if (str2 != null && str2.length() > 0) {
                            Logger.m3601d(SafeDKWebAppInterface.f3385a, "Injecting script for " + str3 + " WebView : " + j + ", url = " + str4);
                            webView2.loadUrl(str2, (Map) null);
                        }
                    }
                }
            });
        }
    }
}

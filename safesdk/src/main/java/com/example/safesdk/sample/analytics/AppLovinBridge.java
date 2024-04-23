package com.example.safesdk.sample.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AppLovinBridge {

    /* renamed from: A */
    private static String f2357A = "https://edge.safedk.com/v1/resolved";

    /* renamed from: B */
    private static HashMap<String, ArrayList<C1269b>> f2358B = new HashMap<>();

    /* renamed from: C */
    private static Context f2359C = null;

    /* renamed from: a */
    public static  String f2360a = "SafeDK";

    /* renamed from: b */
    public static  String f2361b = "v1/events";

    /* renamed from: c */
    public static  String f2362c = "v1/image_uploaded";

    /* renamed from: d */
    public static  String f2363d = "v1/resolved";

    /* renamed from: e */
    public static  String f2364e = "platform";

    /* renamed from: f */
    public static  String f2365f = "package";

    /* renamed from: g */
    public static  String f2366g = "android";

    /* renamed from: h */
    public static  String f2367h = "body";

    /* renamed from: i */
    static AppLovinCommunicatorSubscriber f2368i = new AppLovinCommunicatorSubscriber() {
        public void onMessageReceived(AppLovinCommunicatorMessage message) {
           // Logger.m3601d(AppLovinBridge.f2369j, "Response received " + message.getMessageData() + ", topic=" + message.getTopic() + ", url=" + message.getMessageData().getString("url"));
            Bundle messageData = message.getMessageData();
            String string = message.getMessageData().getString("url");
            if (string.endsWith(AppLovinBridge.f2361b)) {
                AppLovinBridge.m2798b(AppLovinBridge.f2361b, messageData.getBundle("body"));
            } else if (string.endsWith(AppLovinBridge.f2362c)) {
                AppLovinBridge.m2798b(AppLovinBridge.f2362c, messageData.getBundle("body"));
            } else if (string.endsWith(AppLovinBridge.f2363d)) {
                AppLovinBridge.m2798b(AppLovinBridge.f2363d, messageData.getBundle("body"));
            }
        }

        public String getCommunicatorId() {
            return AppLovinBridge.f2360a;
        }
    };

    /* renamed from: j */
    private static  String f2369j = "AppLovinBridge";

    /* renamed from: k */
    private static  String f2370k = "max_ad_events";

    /* renamed from: l */
    private static  String f2371l = "safedk_init";

    /* renamed from: m */
    private static  String f2372m = "user_info";

    /* renamed from: n */
    private static  String f2373n = "send_http_request";

    /* renamed from: o */
    private static  String f2374o = "receive_http_response";

    /* renamed from: p */
    private static  String f2375p = "url";

    /* renamed from: q */
    private static  String f2376q = "backup_url";

    /* renamed from: r */
    private static  String f2377r = "post_body";

    /* renamed from: s */
    private static  String f2378s = "report";

    /* renamed from: t */
    private static  String f2379t = "metadata";

    /* renamed from: u */
    private static  String f2380u = "events";

    /* renamed from: v */
    private static String f2381v = "https://edge.safedk.com/v1/events";

    /* renamed from: w */
    private static String f2382w = "https://edge.safedk.com/v1/events";

    /* renamed from: x */
    private static String f2383x = "https://edge.safedk.com/v1/image_uploaded";

    /* renamed from: y */
    private static String f2384y = "https://edge.safedk.com/v1/image_uploaded";

    /* renamed from: z */
    private static String f2385z = "https://edge.safedk.com/v1/resolved";
    private static ArrayList<Bundle> arrayList;
    private static AppLovinCommunicatorPublisher appLovinCommunicatorPublisher;

    public static void init(Context context) {
        f2359C = context;
        registerToReceiveResponse(f2368i);
    }

    public static void receiveEdgeUrls(String url, String backupUrl) {
        Logger.m3601d(f2369j, "receiveEdgeUrls url=" + url + ", backupUrl=" + backupUrl);
        if (!TextUtils.isEmpty(url)) {
            f2381v = url + "/" + f2361b;
            Logger.m3601d(f2369j, "receiveEdgeUrls edgeBrandSafetyReportUrl updated to " + f2381v);
            f2383x = url + "/" + f2362c;
            Logger.m3601d(f2369j, "receiveEdgeUrls ImageUploadedUrl updated to " + f2383x);
            f2385z = url + "/" + f2363d;
            Logger.m3601d(f2369j, "receiveEdgeUrls resolvedUrl updated to " + f2385z);
        }
        if (!TextUtils.isEmpty(backupUrl)) {
            f2382w = backupUrl + "/" + f2361b;
            Logger.m3601d(f2369j, "Backup edgeBackupBrandSafetyReportUrl updated to " + f2382w);
            f2384y = backupUrl + "/" + f2362c;
            Logger.m3601d(f2369j, "Backup ImageUploadedUrl updated to " + f2384y);
            f2357A = backupUrl + "/" + f2363d;
            Logger.m3601d(f2369j, "Backup resolvedUrl updated to " + f2357A);
        }
    }

    /* renamed from: a */
    static void m2797a(ArrayList<Bundle> arrayList, AppLovinCommunicatorPublisher appLovinCommunicatorPublisher) {
        AppLovinBridge.arrayList = arrayList;
        AppLovinBridge.appLovinCommunicatorPublisher = appLovinCommunicatorPublisher;
        C1361h.m3694b(f2369j, "reportEvents start " + arrayList.size() + " events. edgeUrl=" + f2381v + ", events : " + arrayList.toString());
        Bundle bundle = new Bundle();
        bundle.putString("url", f2381v);
        bundle.putString(f2376q, f2382w);
        Bundle bundle2 = new Bundle();
        //bundle2.putBundle(f2379t,
           //     SafeDK.getInstance().mo19147q());
        bundle2.putParcelableArrayList("events", arrayList);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle("report", bundle2);
        bundle.putBundle(f2377r, bundle3);
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, f2373n, appLovinCommunicatorPublisher);
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(f2359C);
        Logger.m3601d(f2369j, "publishing message with " + arrayList.size() + " events");
        instance.getMessagingService().publish(appLovinCommunicatorMessage);
    }

    public static void reportImageUploadEvent(Bundle data, AppLovinCommunicatorPublisher callback) {
        Logger.m3601d(f2369j, "reportImageUploadEvent start. Data=" + data.toString());
        Bundle bundle = new Bundle();
        bundle.putString("url", f2383x);
        bundle.putString(f2376q, f2384y);
        bundle.putBundle(f2377r, data);
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, f2373n, callback);
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(f2359C);
        Logger.m3601d(f2369j, "publishing message. body=" + data.toString());
        instance.getMessagingService().publish(appLovinCommunicatorMessage);
    }

    public static void reportClickUrlResolvedEvent(Bundle data, AppLovinCommunicatorPublisher callback) {
        Logger.m3601d(f2369j, "reportClickUrlResolvedEvent start");
        Bundle bundle = new Bundle();
        bundle.putString("url", f2385z);
        bundle.putString(f2376q, f2357A);
        bundle.putBundle(f2377r, data);
        AppLovinCommunicatorMessage appLovinCommunicatorMessage = new AppLovinCommunicatorMessage(bundle, f2373n, callback);
        AppLovinCommunicator instance = AppLovinCommunicator.getInstance(f2359C);
        Logger.m3601d(f2369j, "publishing message");
        instance.getMessagingService().publish(appLovinCommunicatorMessage);
    }

    public static void registerToReceiveMaxEvents(AppLovinCommunicatorSubscriber subscriber) {
        m2795a(subscriber, f2370k);
    }

    public static void registerToReceiveResponse(AppLovinCommunicatorSubscriber subscriber) {
        m2795a(subscriber, f2374o);
    }

    public static void registerToReceiveSafeDKSettings(AppLovinCommunicatorSubscriber subscriber) {
        m2795a(subscriber, f2371l);
    }

    public static void registerToReceiveUserInfo(AppLovinCommunicatorSubscriber subscriber) {
        m2795a(subscriber, f2372m);
    }

    /* renamed from: a */
    private static void m2795a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        AppLovinCommunicator.getInstance(f2359C).subscribe(appLovinCommunicatorSubscriber, (List<String>) Arrays.asList(new String[]{str}));
    }

    public static void registerListener(String requestName, C1269b listener) {
        try {
            Logger.m3601d(f2369j, "registerListener started, requestName=" + requestName);
            if (!f2358B.containsKey(requestName)) {
                Logger.m3601d(f2369j, "registerListener listener list created for requestName=" + requestName);
                f2358B.put(requestName, new ArrayList());
            }
            Logger.m3601d(f2369j, "registerListener listener added for requestName=" + requestName + "," + listener);
            f2358B.get(requestName).add(listener);
        } catch (Throwable th) {
            Logger.m3604e(f2369j, "registerListener failed during registerListener. requestName:" + requestName + ", listener: " + listener, th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: b */
    public static void m2798b(String str, Bundle bundle) {
        try {
            Logger.m3601d(f2369j, "notifyListeners started, requestName=" + str + ",data=" + bundle.toString());
            ArrayList arrayList = f2358B.get(str);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Logger.m3601d(f2369j, "Invoking handler for requestName '" + str + "', Bundle : " + bundle.toString());
                    ((C1269b) it.next()).mo19209a(str, bundle);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f2369j, "Failed to read response", th);
        }
    }
}

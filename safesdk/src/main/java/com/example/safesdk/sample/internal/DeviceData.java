package com.example.safesdk.sample.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.example.safesdk.sample.C1254a;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.utils.C1359f;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;

public class DeviceData implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    private static  String f3339A = "is_ad_tracking_enabled";

    /* renamed from: B */
    private static  String f3340B = "enduser_id";

    /* renamed from: C */
    private static  String f3341C = "app_version_name";

    /* renamed from: D */
    private static  String f3342D = "app_version";

    /* renamed from: E */
    private static  String f3343E = "init_success";

    /* renamed from: F */
    private static  String f3344F = "value";

    /* renamed from: G */
    private static  String f3345G = "user_id";

    /* renamed from: a */
    public static  String f3346a = "sdk_key";

    /* renamed from: l */
    private static  String f3347l = "DeviceData";

    /* renamed from: m */
    private static  String f3348m = "values";

    /* renamed from: n */
    private static  String f3349n = "operator";

    /* renamed from: o */
    private static  String f3350o = "lte";

    /* renamed from: p */
    private static  String f3351p = "gte";

    /* renamed from: q */
    private static  String f3352q = "deactivationPercentage";

    /* renamed from: r */
    private static  String f3353r = "device_type";

    /* renamed from: s */
    private static  String f3354s = "applovin_random_token";

    /* renamed from: t */
    private static  String f3355t = "device_brand";

    /* renamed from: u */
    private static  String f3356u = "device_model";

    /* renamed from: v */
    private static  String f3357v = "device_revision";

    /* renamed from: w */
    private static  String f3358w = "os_version";

    /* renamed from: x */
    private static  String f3359x = "safedk_version";

    /* renamed from: y */
    private static  String f3360y = "applovin_version";

    /* renamed from: z */
    private static  String f3361z = "from_store";

    /* renamed from: H */
    private C1359f f3362H;

    /* renamed from: b */
    String f3363b;

    /* renamed from: c */
    String f3364c;

    /* renamed from: d */
    int f3365d;

    /* renamed from: e */
    int f3366e;

    /* renamed from: f */
    String f3367f;

    /* renamed from: g */
    String f3368g;

    /* renamed from: h */
    String f3369h;

    /* renamed from: i */
    String f3370i;

    /* renamed from: j */
    String f3371j;

    /* renamed from: k */
    boolean f3372k = false;

    private enum CriteriaField {
        deviceModel,
        manufacturer,
        country,
        appVersionCode,
        androidVersion,
        osVersion,
        appDeviceIDs,
        age,
        region
    }

    private DeviceData() {
    }

    public DeviceData( Context context, C1359f prefs) {
        Logger.m3601d(f3347l, "DeviceData started");
        this.f3362H = prefs;
        this.f3363b = Build.MODEL;
        this.f3364c = Build.MANUFACTURER.toLowerCase();
        this.f3366e = Build.VERSION.SDK_INT;
        try {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        DeviceData.this.f3372k = DeviceData.this.m3498a(context);
                    } catch (Throwable th) {
                    }
                }
            }).start();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f3367f = packageInfo.versionName;
            this.f3365d = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m3604e(f3347l, "Error getting device data", e);
        } catch (Throwable th) {
            Logger.m3604e(f3347l, "Error getting device data", th);
        }
        AppLovinBridge.registerToReceiveSafeDKSettings(this);
        AppLovinBridge.registerToReceiveUserInfo(this);
    }

    /* renamed from: a */
    public String mo19561a() {
        if (this.f3370i != null) {
            return this.f3370i;
        }
        if (this.f3362H.mo19699n() == this.f3365d) {
            return this.f3362H.mo19698m();
        }
        return null;
    }

    /* renamed from: b */
    public String mo19562b() {
        if (this.f3369h != null) {
            return this.f3369h;
        }
        if (this.f3362H.mo19699n() == this.f3365d) {
            return this.f3362H.mo19700o();
        }
        return null;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage message) {
        Logger.m3601d(f3347l, "message received " + message.getMessageData());
        Bundle messageData = message.getMessageData();
        if (messageData.containsKey(f3343E)) {
            this.f3369h = messageData.getString(f3354s);
            this.f3370i = messageData.getString("sdk_key");
            this.f3362H.mo19683a(this.f3365d, this.f3369h, this.f3370i);
            this.f3368g = messageData.getString(f3353r);
            SdksMapping.setMaxAdapterVersions(messageData);
            if (Boolean.valueOf(messageData.getString(f3343E)).booleanValue()) {
                Logger.m3601d(f3347l, "AppLovinSdk reported success to retrieve settings");
                SafeDK.getInstance().mo19127a(messageData, true);
                return;
            }
            SafeDK.getInstance().mo19128a(true);
            Logger.m3601d(f3347l, "AppLovinSdk reported a failure to retrieve settings. The saved settings from a previous session will be used.");
        } else if (messageData.containsKey("value")) {
            this.f3371j = messageData.getString("value");
        } else if (messageData.containsKey(f3345G)) {
            this.f3371j = messageData.getString(f3345G);
        }
    }

    public String getCommunicatorId() {
        return AppLovinBridge.f2360a;
    }

    /* renamed from: a */
    public static float m3497a(String str, String str2) {
        return (float) ((Math.abs((str + str2).hashCode()) % 100000) / 1000);
    }

    /* renamed from: c */
    public Bundle mo19563c() {
        Bundle bundle = new Bundle();
        bundle.putString(AppLovinBridge.f2365f, SafeDK.getInstance().mo19137g().getPackageName());
        bundle.putString(AppLovinBridge.f2364e, AppLovinBridge.f2366g);
        bundle.putString(f3354s, mo19562b());
        bundle.putString(f3360y, C1361h.m3670a());
        bundle.putString("safedk_version", C1254a.f2331a);
        bundle.putString(f3353r, this.f3368g);
        bundle.putString(f3356u, Build.MODEL);
        bundle.putString(f3355t, Build.MANUFACTURER);
        bundle.putString(f3357v, Build.DEVICE);
        bundle.putString(f3358w, Build.VERSION.RELEASE);
        bundle.putString(f3342D, String.valueOf(this.f3365d));
        bundle.putString(f3341C, this.f3367f);
        SafeDK.getInstance();
        bundle.putBoolean(f3361z, SafeDK.m2708a());
        bundle.putString(f3340B, this.f3371j);
        bundle.putBoolean(f3339A, this.f3372k);
        return bundle;
    }

    /* renamed from: a */
    public boolean m3498a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo == null || advertisingIdInfo.isLimitAdTrackingEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}

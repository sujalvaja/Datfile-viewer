package com.example.safesdk.sample.analytics.events;

import android.os.Bundle;

import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;

import java.io.Serializable;

public class RedirectEvent extends StatsEvent implements Serializable {

    /* renamed from: a */
    public static  int f3277a = 120000;

    /* renamed from: b */
    public static  String f3278b = "redirect";

    /* renamed from: c */
    public static  String f3279c = "redirect_url";

    /* renamed from: d */
    public static  String f3280d = "redirect_type";

    /* renamed from: e */
    public static  String f3281e = "foreground_activity";

    /* renamed from: f */
    public static  String f3282f = "max_events";

    /* renamed from: g */
    public static  String f3283g = "touch_ts";

    /* renamed from: h */
    public static  String f3284h = "external";

    /* renamed from: i */
    public static  String f3285i = "internal";

    /* renamed from: j */
    public static  String f3286j = "suspected_store_kit";

    /* renamed from: k */
    private static  String f3287k = "RedirectEvent";

    /* renamed from: l */
    private String f3288l;

    /* renamed from: m */
    private String f3289m;

    /* renamed from: n */
    private String f3290n;

    /* renamed from: o */
    private String f3291o;

    /* renamed from: p */
    private MaxEvents f3292p = null;

    /* renamed from: q */
    private long f3293q;

    public RedirectEvent(String sdk, String redirectUrl, String redirectType, String foregroundActivity, long timestamp, long touchTs) {
        super(sdk, StatsCollector.EventType.redirect);
        Logger.m3601d(f3287k, "RedirectEvent ctor started, sdk=" + sdk + ", redirectUrl=" + redirectUrl + ", redirectType=" + redirectType + ", foregroundActivity=" + foregroundActivity + " ,timestamp=" + timestamp + ", touchTs=" + touchTs);
        Logger.m3601d(f3287k, "RedirectEvent ctor SdksMapping.getSdkNameByPackage()=" + SdksMapping.getSdkNameByPackage(sdk));
        Logger.m3601d(f3287k, "RedirectEvent ctor SdksMapping.getSdkPackageByClass()=" + SdksMapping.getSdkPackageByClass(sdk));
        String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(sdk);
        if (sdkUUIDByPackage == null || SdksMapping.getAllSdkVersionsMap() == null || SdksMapping.getAllSdkVersionsMap().get(sdkUUIDByPackage) == null) {
            Logger.m3601d(f3287k, "RedirectEvent ctor cannot find version for sdk " + sdk + " , SdkVersionsMap=" + SdksMapping.getAllSdkVersionsMap());
        } else {
            this.f3288l = SdksMapping.getAllSdkVersionsMap().get(sdkUUIDByPackage);
            Logger.m3601d(f3287k, "RedirectEvent ctor sdkVersion=" + this.f3288l);
        }
        this.f3289m = redirectUrl;
        this.f3290n = redirectType;
        this.f3291o = foregroundActivity;
        this.f3293q = C1361h.m3690b(touchTs);
        this.f3307I = false;
    }

    /* renamed from: a */
    public void mo19533a(MaxEvents maxEvents) {
        this.f3292p = (MaxEvents) maxEvents.clone();
        Logger.m3601d(f3287k, "setMaxEvents , added " + this.f3292p.size() + " items. content : " + this.f3292p.toString());
    }

    /* renamed from: b */
    public StatsCollector.EventType mo19511b() {
        return StatsCollector.EventType.redirect;
    }

    /* renamed from: c */
    public String mo19512c() {
        StringBuilder sb = new StringBuilder();
        sb.append(StatsCollector.EventType.redirect + "_");
        sb.append(this.f3289m == null ? "_" : this.f3289m + "_");
        sb.append(this.f3305G);
        Logger.m3601d(f3287k, "Getting key from object : " + sb.toString());
        return sb.toString();
    }

    /* renamed from: a */
    public static String m3456a(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append(StatsCollector.EventType.redirect + "_");
        if (bundle.getString(f3279c) == null) {
            sb.append("_");
        } else {
            sb.append(bundle.getString(f3279c) + "_");
        }
        sb.append(bundle.getLong("timestamp"));
        Logger.m3601d(f3287k, "Getting key from bundle : " + sb.toString());
        return sb.toString();
    }

    /* renamed from: a */
    public void mo19510a(StatsEvent statsEvent) {
        if (((RedirectEvent) statsEvent).f3307I) {
            this.f3307I = true;
        }
        if (((RedirectEvent) statsEvent).mo19536f() != null && mo19536f() == null) {
            mo19534a(((RedirectEvent) statsEvent).mo19536f());
        }
    }

    /* renamed from: d */
    public Bundle mo19513d() {
        Bundle d = super.mo19513d();
        d.putString("sdk_version", this.f3288l);
        d.putString(f3279c, this.f3289m);
        d.putString(f3280d, this.f3290n);
        d.putString("foreground_activity", this.f3291o);
        d.putLong(f3283g, this.f3293q);
        if (this.f3292p != null && this.f3292p.size() > 0) {
            d.putParcelableArrayList(f3282f, this.f3292p.mo19527a());
        }
        Logger.m3601d(f3287k, "Redirect Event toBundle : " + d.toString());
        return d;
    }

    /* renamed from: a_ */
    public boolean mo19535a_() {
        return System.currentTimeMillis() - this.f3305G > 120000 || this.f3289m != null || this.f3307I;
    }

    /* renamed from: f */
    public String mo19536f() {
        return this.f3289m;
    }

    /* renamed from: a */
    public void mo19534a(String str) {
        this.f3289m = str;
    }
}

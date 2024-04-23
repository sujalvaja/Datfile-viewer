package com.example.safesdk.sample.analytics.events;

import android.os.Bundle;
import com.example.safesdk.sample.utils.Logger;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaxEvent implements Serializable, Comparable<MaxEvent> {

    /* renamed from: a */
    public static  String f3264a = "event";

    /* renamed from: b */
    public static  String f3265b = "ts";

    /* renamed from: c */
    public static  String f3266c = "ad_format";

    /* renamed from: d */
    public static  String f3267d = "network";

    /* renamed from: e */
    public static  String f3268e = "creative_id";

    /* renamed from: f */
    private static  String f3269f = "MaxEvent";

    /* renamed from: g */
    private String f3270g;

    /* renamed from: h */
    private Long f3271h;

    /* renamed from: i */
    private String f3272i;

    /* renamed from: j */
    private String f3273j;

    /* renamed from: k */
    private String f3274k;

    /* renamed from: a */
    public String mo19518a() {
        return this.f3274k;
    }

    /* renamed from: b */
    public String mo19520b() {
        return this.f3270g;
    }

    /* renamed from: a */
    public void mo19519a(String str) {
        this.f3270g = str;
    }

    /* renamed from: c */
    public long mo19521c() {
        return this.f3271h.longValue();
    }

    /* renamed from: d */
    public String mo19523d() {
        return this.f3272i;
    }

    /* renamed from: e */
    public String mo19524e() {
        return this.f3273j;
    }

    public MaxEvent(String event, long timestamp, String adFormat, String network, String creativeId) {
        this.f3270g = event;
        this.f3271h = Long.valueOf(timestamp);
        this.f3272i = adFormat;
        this.f3273j = network;
        this.f3274k = creativeId;
        Logger.m3601d(f3269f, "New MaxEvent created , event=" + event + ", timestamp=" + timestamp + ", adFormat=" + adFormat + ", network=" + network + ", creativeId=" + creativeId);
    }

    /* renamed from: f */
    public Bundle mo19525f() {
        Bundle bundle = new Bundle();
        bundle.putString("event", this.f3270g);
        bundle.putLong(f3265b, this.f3271h.longValue());
        bundle.putString("ad_format", this.f3272i);
        bundle.putString(f3267d, this.f3273j);
        bundle.putString("creative_id", this.f3274k);
        Logger.m3601d(f3269f, "MaxEvent toBundle : " + bundle.toString());
        return bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("event : " + this.f3270g + ", ");
        sb.append("ts : " + this.f3271h);
        sb.append(" (" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.f3271h.longValue() * 1000)) + "), ");
        sb.append("ad_format : " + this.f3272i + ", ");
        sb.append("network : " + this.f3273j);
        sb.append("creative_id : " + this.f3274k);
        return sb.toString();
    }

    /* renamed from: a */
    public int compareTo(MaxEvent maxEvent) {
        return this.f3271h.compareTo(maxEvent.f3271h);
    }
}

package com.example.safesdk.sample.analytics.events;

import android.os.Build;


import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.analytics.events.base.StatsEventWithBundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;

public class CrashEvent extends StatsEventWithBundle implements Serializable {

    /* renamed from: a */
    protected static  String f3255a = "is_caught";

    /* renamed from: b */
    protected static  String f3256b = "is_emulator";

    /* renamed from: c */
    protected static  String f3257c = "is_debug";

    /* renamed from: d */
    protected static  String f3258d = "generic";

    /* renamed from: e */
    public static  String f3259e = "report";

    /* renamed from: f */
    public static  String f3260f = "events";

    /* renamed from: g */
    public static  String f3261g = "sdk_versions_map";

    /* renamed from: h */
    public static  String f3262h = "sdk_key";

    /* renamed from: j */
    private static  String f3263j = "CrashEvent";
    private static  long serialVersionUID = 0;

    public CrashEvent(JSONObject report) {
        super((String) null, StatsCollector.EventType.crash, report);
    }

    public CrashEvent(String sdk, StatsCollector.EventType eventType, JSONObject report) {
        super(sdk, eventType, report);
    }

    /* renamed from: f */
    public JSONObject mo19516f() throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put(f3259e, jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONObject2.put(f3260f, jSONArray);
        JSONObject f = super.mo19516f();
        f.put(StatsEvent.f3300z, mo19511b().toString());
        f.put("timestamp", this.f3305G);
        f.put(f3255a, mo19515a());
        f.put(f3256b, Build.FINGERPRINT.contains(f3258d));
        f.put(f3257c, SafeDK.getInstance().mo19140i());
        JSONObject G = SafeDK.getInstance().mo19116G();

        jSONObject2.put("metadata", C1361h.m3683a(SafeDK.getInstance().mo19147q().mo19563c()));
        jSONObject.put("sdk_key", SafeDK.getInstance().mo19147q().mo19561a());
        return jSONObject;
    }

    
    /* renamed from: a */
    public boolean mo19515a() {
        return false;
    }

    /* renamed from: b */
    public StatsCollector.EventType mo19511b() {
        return StatsCollector.EventType.crash;
    }

    /* renamed from: c */
    public String mo19512c() {
        return "";
    }

    /* renamed from: a */
    public void mo19510a(StatsEvent statsEvent) {
    }
}

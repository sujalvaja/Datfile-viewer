package com.example.safesdk.sample.analytics.events.base;

import android.util.Base64;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.utils.C1361h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class StatsEventWithBundle extends StatsEvent implements Serializable {

    /* renamed from: a */
    private static  String f3311a = "CrashEvent";

    /* renamed from: b */
    private static  String f3312b = "report";

    /* renamed from: i */
    protected static  String f3313i = "metadata";

    /* renamed from: c */
    private JSONObject f3314c;

    public StatsEventWithBundle(String sdk, StatsCollector.EventType eventType, JSONObject report) {
        super(sdk, eventType);
        this.f3303E = eventType;
        this.f3301C = sdk;
        this.f3305G = C1361h.m3690b(System.currentTimeMillis());
        this.f3314c = report;
    }

    /* renamed from: f */
    public JSONObject mo19516f() throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        C1361h.m3694b(f3311a, "report : " + this.f3314c);
        jSONObject.put("report", m3483a(this.f3314c.toString().replace("\\/", "/")));
        return jSONObject;
    }

    /* renamed from: a */
    private String m3483a(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return new String(Base64.encode(byteArray, 2));
    }
}

package com.example.safesdk.sample.analytics.events;

import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import java.io.Serializable;
import org.json.JSONObject;

public class CaughtCrashEvent extends CrashEvent implements Serializable {

    /* renamed from: j */
    private static  String f3254j = "CaughtCrashEvent";
    private static  long serialVersionUID = 0;

    public CaughtCrashEvent(JSONObject report) {
        super((String) null, StatsCollector.EventType.crash, report);
    }

    
    /* renamed from: a */
    public boolean mo19515a() {
        return true;
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

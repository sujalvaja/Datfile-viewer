package com.example.safesdk.sample.analytics.brandsafety;

import androidx.work.WorkRequest;
import com.example.safesdk.sample.analytics.events.MaxEvent;
import com.example.safesdk.sample.analytics.events.MaxEvents;
import com.example.safesdk.sample.utils.Logger;
import java.util.Iterator;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.j */
public class C1337j {

    /* renamed from: a */
    public static  int f3180a = 50;

    /* renamed from: b */
    public static  int f3181b = 10;

    /* renamed from: c */
    public static  int f3182c = 30000;

    /* renamed from: d */
    private static  String f3183d = "MaxEventsManager";

    /* renamed from: e */
    private static  Object f3184e = new Object();

    /* renamed from: f */
    private static C1337j f3185f;

    /* renamed from: g */
    private MaxEvents f3186g = new MaxEvents(50);

    private C1337j() {
    }

    /* renamed from: a */
    public static C1337j m3416a() {
        C1337j jVar;
        synchronized (f3184e) {
            if (f3185f == null) {
                f3185f = new C1337j();
            }
            jVar = f3185f;
        }
        return jVar;
    }

    /* renamed from: a */
    public void mo19501a(MaxEvent maxEvent) {
        this.f3186g.add(maxEvent);
    }

    /* renamed from: b */
    public MaxEvents mo19502b() {
        MaxEvents c = m3418c();
        return c.size() >= 10 ? c : m3417a(10);
    }

    /* renamed from: c */
    private MaxEvents m3418c() {
        long currentTimeMillis = System.currentTimeMillis();
        Logger.m3601d(f3183d, "");
        MaxEvents maxEvents = new MaxEvents(50);
        Iterator it = this.f3186g.iterator();
        while (it.hasNext()) {
            MaxEvent maxEvent = (MaxEvent) it.next();
            if (currentTimeMillis - (maxEvent.mo19521c() * 1000) < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                Logger.m3601d(f3183d, "getEventFromLastInterval Adding max event ts = " + currentTimeMillis + ", " + maxEvent.toString());
                maxEvents.add(maxEvent);
            }
        }
        return maxEvents;
    }

    /* renamed from: a */
    private MaxEvents m3417a(int i) {
        MaxEvents maxEvents = new MaxEvents(i);
        int size = this.f3186g.size() < 10 ? 0 : this.f3186g.size() - 10;
        while (true) {
            int i2 = size;
            if (i2 >= this.f3186g.size()) {
                return maxEvents;
            }
            Logger.m3601d(f3183d, "getLastXEvents adding max event index " + i2 + " " + ((MaxEvent) this.f3186g.get(i2)).toString());
            maxEvents.add(new MaxEvent(((MaxEvent) this.f3186g.get(i2)).mo19520b(), ((MaxEvent) this.f3186g.get(i2)).mo19521c(), ((MaxEvent) this.f3186g.get(i2)).mo19523d(), ((MaxEvent) this.f3186g.get(i2)).mo19524e(), ((MaxEvent) this.f3186g.get(i2)).mo19518a()));
            size = i2 + 1;
        }
    }
}

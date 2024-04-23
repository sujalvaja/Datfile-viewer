package com.example.safesdk.sample.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.analytics.events.RedirectEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.C1338k;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.internal.C1346a;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.internal.C1349d;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.PersistentConcurrentHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class StatsCollector implements C1346a {

    /* renamed from: a */
    public static volatile int f2386a = 0;

    /* renamed from: c */
    private static  String f2387c = "StatsCollector";

    /* renamed from: d */
    private static  String f2388d = "SafeDKEvents.";

    /* renamed from: e */
    private static StatsCollector f2389e;

    /* renamed from: m */
    private static boolean f2390m;

    /* renamed from: o */
    private static boolean f2391o = false;

    /* renamed from: p */
    public static  Object f2392p = new Object();

    /* renamed from: b */
    public AtomicLong f2393b = new AtomicLong(0);

    /* renamed from: f */
    public PersistentConcurrentHashMap<String, StatsEvent> f2394f = new PersistentConcurrentHashMap<>();

    /* renamed from: g */
    private Map<String, C1338k> f2395g = new HashMap();

    /* renamed from: h */
    private SharedPreferences f2396h;

    /* renamed from: i */
    public volatile AtomicBoolean f2397i;

    /* renamed from: j */
    private AtomicBoolean f2398j = new AtomicBoolean(false);

    /* renamed from: k */
    private StatsReporter f2399k;

    /* renamed from: l */
    private ExecutorService f2400l = Executors.newSingleThreadExecutor();

    /* renamed from: n */
    public String f2401n = null;

    public enum EventType {
        Network,
        Launch,
        Thread,
        Location,
        CaughtException,
        UserDataAccess,
        ActiveUser,
        BrandSafety,
        AdIntelligenceFill,
        ANR,
        UserSession,
        crash,
        redirect
    }

    /* renamed from: a */
    public static boolean m2805a() {
        return f2391o;
    }

    /* renamed from: a */
    public static void m2804a(boolean z) {
        f2391o = z;
    }

    /* renamed from: b */
    public static void m2808b(boolean z) {
        synchronized (f2392p) {
            Logger.m3601d(f2387c, "setActiveMode to " + z);
            f2390m = z;
            f2389e = null;
        }
    }

    /* renamed from: b */
    public static StatsCollector m2806b() {
        StatsCollector statsCollector = null;
        if (f2391o || SafeDK.m2711b()) {
            synchronized (f2392p) {
                if (f2389e == null) {
                    f2389e = new StatsCollector(300, C1347b.getInstance().isInBackground(), C1349d.f3439b, (StatsReporter) null, C1361h.m3671a(SafeDK.getInstance().mo19137g()));
                }
                statsCollector = f2389e;
            }
        } else {
            Logger.m3601d(f2387c, "Reporter thread has not been initialized yet");
        }
        return statsCollector;
    }

    private StatsCollector(int interval, boolean isBackground, int maximumEventsSize, StatsReporter statsReporter, String processName) {
        if (f2390m) {
            Logger.m3601d(f2387c, "Initializing Stats collector");
            m2801a(interval, isBackground, statsReporter);
            this.f2401n = f2388d + processName;
            C1347b.getInstance().registerBackgroundForegroundListener(this);
        }
    }

    /* renamed from: c */
    public void mo19194c() {
        this.f2400l.execute(new Runnable() {
            public void run() {
                PersistentConcurrentHashMap persistentConcurrentHashMap;
                try {
                    Logger.m3601d(StatsCollector.f2387c, "Attempting to load Stats events from storage.");
                    persistentConcurrentHashMap = new PersistentConcurrentHashMap(StatsCollector.this.f2401n);
                } catch (Throwable th) {
                    Logger.m3602d(StatsCollector.f2387c, "Error loading events from storage : " + th.getMessage(), th);
                    return;
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                if (StatsCollector.this.f2394f == null || StatsCollector.this.f2394f.size() <= 0) {
                    Logger.m3601d(StatsCollector.f2387c, "Stats repository does not contain previously accumulated events.");
                } else {
                    concurrentHashMap.putAll(StatsCollector.this.f2394f);
                    Logger.m3601d(StatsCollector.f2387c, "Stats repository contains " + concurrentHashMap.size() + " items. they will be added to the stored ones.");
                }
                synchronized (StatsCollector.f2392p) {
                    PersistentConcurrentHashMap unused = StatsCollector.this.f2394f = persistentConcurrentHashMap;
                }
                Logger.m3601d(StatsCollector.f2387c, StatsCollector.this.f2394f.size() + " events loaded from storage");
                for (StatsEvent statsEvent : StatsCollector.this.f2394f.values()) {
                    String str = null;
                    if (statsEvent.mo19512c() != null) {
                        str = statsEvent.mo19512c();
                    }
                    Logger.m3601d(StatsCollector.f2387c, "Setting event maturity, next_session, first_session (" + SafeDK.getInstance().mo19133c() + ") for stored event. key " + str);
                    statsEvent.mo19542b(true);
                    statsEvent.mo19544c(true);
                    statsEvent.mo19540a(SafeDK.getInstance().mo19133c());
                }
                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                    StatsCollector.this.f2394f.mo19672a(false);
                  /*  for (Object statsEvent2 : concurrentHashMap.values()) {
                        Logger.m3601d(StatsCollector.f2387c, "adding previously accumulated event to the stats repository : " + statsEvent2.toString());
                        StatsCollector.this.mo19195c(statsEvent2);
                    }
                    StatsCollector.this.f2394f.mo19672a(true);*/
                }
                Logger.m3601d(StatsCollector.f2387c, "Completed Loading events from storage. " + StatsCollector.this.f2394f.size() + " items loaded");
                if (StatsCollector.this.f2394f.size() > 0) {
                    Logger.m3601d(StatsCollector.f2387c, StatsCollector.this.f2394f.size() + " event(s) will be reported");
                    StatsCollector.this.m2810c(true);
                }
            }
        });
    }

    /* renamed from: d */
    public PersistentConcurrentHashMap<String, StatsEvent> mo19196d() {
        return this.f2394f;
    }

    /* renamed from: a */
    public ConcurrentHashMap<String, StatsEvent> mo19188a(EventType eventType) {
        ConcurrentHashMap<String, StatsEvent> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : this.f2394f.keySet()) {
            StatsEvent statsEvent = (StatsEvent) this.f2394f.get(str);
            if (statsEvent != null && statsEvent.mo19511b().equals(eventType)) {
                Logger.m3601d(f2387c, "Get events by type adding event with key " + str);
                concurrentHashMap.put(statsEvent.mo19512c(), statsEvent);
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: e */
    public Map<String, C1338k> mo19197e() {
        return this.f2395g;
    }

    /* renamed from: a */
    public boolean mo19192a(String str, String str2) {
        if (this.f2395g == null || !this.f2395g.containsKey(str) || !this.f2395g.get(str).mo19507c().equals(str2)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m2802a(Context context, String str) {
        this.f2396h = context.getSharedPreferences(str, 0);
        this.f2396h.edit().clear().commit();
        Logger.m3601d(f2387c, "Old StatsRepository data cleared");
    }

    /* renamed from: a */
    public void mo19189a(int i, boolean z, int i2, StatsReporter statsReporter) {
        m2801a(i, z, statsReporter);
        this.f2398j.set(true);
    }

    /* renamed from: a */
    private void m2801a(int i, boolean z, StatsReporter statsReporter) {
        f2386a = i;
        this.f2393b.set(C1361h.m3690b(System.currentTimeMillis()));
        this.f2397i = new AtomicBoolean(z);
        this.f2399k = statsReporter;
    }

    /* renamed from: a */
    public void mo19190a(StatsEvent statsEvent) {
        C1361h.m3694b(f2387c, "received stats safety event " + statsEvent.mo19513d());
        m2811d(statsEvent);
    }

    /* renamed from: b */
    public void mo19193b(StatsEvent statsEvent) {
        C1361h.m3694b(f2387c, "received brand safety event (mature=" + statsEvent.mo19535a_() + ", " + statsEvent.mo19513d());
        m2811d(statsEvent);
    }

    /* renamed from: d */
    private void m2811d( StatsEvent statsEvent) {
        if (f2390m) {
            this.f2400l.execute(new Runnable() {
                public void run() {
                    try {
                        if (!StatsCollector.this.f2397i.get()) {
                            StatsCollector.this.mo19195c(statsEvent);
                            StatsCollector.this.m2810c(false);
                        } else if (!statsEvent.mo19535a_() || statsEvent.mo19547h().equals(SafeDK.f2298a)) {
                            Logger.m3601d(StatsCollector.f2387c, "Saving bundle to disk : " + statsEvent.toString());
                            StatsCollector.this.mo19195c(statsEvent);
                        } else {
                            StatsCollector.this.mo19195c(statsEvent);
                            StatsCollector.this.m2810c(true);
                        }
                    } catch (Throwable th) {
                        Logger.m3604e(StatsCollector.f2387c, th.getMessage(), th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo19195c(StatsEvent statsEvent) {
        String c = statsEvent.mo19512c();
        m2813i();
        if (c == null) {
            Logger.m3601d(f2387c, "Event key is null, cannot add to events repository.");
        } else if (this.f2394f.containsKey(c)) {
            StatsEvent statsEvent2 = (StatsEvent) this.f2394f.get(c);
            statsEvent2.mo19541b(statsEvent);
            this.f2394f.put(c, statsEvent2);
            Logger.m3601d(f2387c, "Event " + c + " found. Aggregating. event = " + statsEvent2.mo19513d().toString());
        } else {
            this.f2394f.put(c, statsEvent);
            Logger.m3601d(f2387c, "Event " + c + " found. Adding. event = " + statsEvent.mo19513d().toString());
        }
    }

    /* renamed from: a */
    public synchronized void mo19191a(String str) {
        m2813i();
        if (str == null) {
            Logger.m3601d(f2387c, "Event key is null, cannot remove from events repository.");
        } else if (this.f2394f.remove(str) != null) {
            Logger.m3601d(f2387c, "Event successfully removed from events repository, key=" + str);
        } else {
            Logger.m3601d(f2387c, "Event to remove wasn't found in events repository, key=" + str);
        }
    }

    /* renamed from: f */
    public synchronized void mo19198f() {
        if (f2390m) {
            Logger.m3601d(f2387c, "onBackground started");
            this.f2397i.set(true);
            this.f2400l.execute(new Runnable() {
                public void run() {
                    StatsCollector.this.m2810c(true);
                }
            });
        }
    }

    /* renamed from: g */
    public synchronized void mo19199g() {
        if (f2390m) {
            Logger.m3601d(f2387c, "onForeground started");
            this.f2397i.set(false);
            this.f2400l.execute(new Runnable() {
                public void run() {
                    StatsCollector.this.m2810c(true);
                }
            });
        }
    }

    /* renamed from: c */
    public void m2810c(boolean z) {
        try {
            Logger.m3601d(f2387c, "sendEvents started, persistImmatureEvents=" + z);
            if (this.f2394f == null || this.f2394f.size() == 0) {
                Logger.m3601d(f2387c, "sendEvents no events to report, skipping");
            }
            HashSet<StatsEvent> hashSet = new HashSet<>(this.f2394f.values());
            HashSet<StatsEvent> hashSet2 = new HashSet<>();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                StatsEvent statsEvent = (StatsEvent) it.next();
                C1361h.m3694b(f2387c, "event " + statsEvent.mo19512c() + ", mature=" + statsEvent.mo19535a_() + ", event details " + statsEvent.toString());
                if (!statsEvent.mo19535a_()) {
                    hashSet2.add(statsEvent);
                    it.remove();
                }
            }
            Logger.m3601d(f2387c, "sendEvents " + (hashSet != null ? hashSet.toString() : ""));
            m2813i();
            ArrayList<Bundle> a = this.f2399k.mo19204a((Set<StatsEvent>) hashSet);
            if (a.size() > 0) {
                Logger.m3601d(f2387c, "sendEvents sending the following events (" + a.size() + ") : " + a.toString());
                this.f2399k.mo19205a(a);
                Iterator<Bundle> it2 = a.iterator();
                while (it2.hasNext()) {
                    Bundle next = it2.next();
                    if (next.containsKey(StatsEvent.f3300z) && next.getString(StatsEvent.f3300z).equals("impression")) {
                        Logger.m3601d(f2387c, "sendEvents removing brand safety event  " + next.getString(BrandSafetyEvent.f3206c));
                        this.f2394f.remove(next.getString(BrandSafetyEvent.f3206c));
                    } else if (!next.containsKey(StatsEvent.f3300z) || !next.getString(StatsEvent.f3300z).equals(RedirectEvent.f3278b)) {
                        Logger.m3601d(f2387c, "sendEvents Cannot remove event from stats repository " + next.toString());
                    } else {
                        Logger.m3601d(f2387c, "sendEvents removing redirect event for key  " + RedirectEvent.m3456a(next) + ", exists ? " + this.f2394f.containsKey(RedirectEvent.m3456a(next)));
                        this.f2394f.remove(RedirectEvent.m3456a(next));
                    }
                }
            }
            if (z) {
                Logger.m3601d(f2387c, "sendEvents persisting immature events");
                if (hashSet2.size() > 0) {
                    Logger.m3601d(f2387c, hashSet2.size() + "sendEvents events to save");
                    for (StatsEvent c : hashSet2) {
                        mo19195c(c);
                    }
                }
            } else if (this.f2394f == null || hashSet == null || this.f2394f.size() <= 0 || hashSet.size() <= 0) {
                Logger.m3601d(f2387c, "No events to remove from events repository");
            } else {
                Logger.m3601d(f2387c, "Before removing stats. repository size = " + this.f2394f.size() + " repository keys = " + this.f2394f.keySet().toString() + ", events (" + hashSet.size() + ") :" + hashSet.toString());
                for (StatsEvent statsEvent2 : hashSet) {
                    Logger.m3601d(f2387c, "event key is " + statsEvent2.mo19512c());
                    this.f2394f.remove(statsEvent2.mo19512c(), statsEvent2);
                }
                Logger.m3601d(f2387c, "After removing stats events (" + this.f2394f.size() + ") :" + this.f2394f.toString());
            }
        } catch (Exception e) {
            Logger.m3602d(f2387c, e.getMessage(), e);
            new CrashReporter().caughtException(e);
        }
    }

    /* renamed from: i */
    private void m2813i() {
        if (this.f2399k == null) {
            Logger.m3601d(f2387c, "statsReporter is null, initializing");
            StatsReporter.m2826a();
            this.f2399k = StatsReporter.m2827b();
        }
    }
}

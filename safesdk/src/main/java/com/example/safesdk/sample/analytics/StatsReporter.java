package com.example.safesdk.sample.analytics;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatsReporter implements AppLovinCommunicatorPublisher {

    /* renamed from: a */
    private static  String f2421a = "StatsReporter";

    /* renamed from: b */
    private static StatsReporter f2422b;

    /* renamed from: c */
    private static  ExecutorService f2423c = Executors.newSingleThreadExecutor();

    public String getCommunicatorId() {
        return AppLovinBridge.f2360a;
    }

    /* renamed from: a */
    public static synchronized void m2826a() {
        synchronized (StatsReporter.class) {
            f2422b = new StatsReporter();
        }
    }

    /* renamed from: b */
    public static synchronized StatsReporter m2827b() {
        StatsReporter statsReporter;
        synchronized (StatsReporter.class) {
            statsReporter = f2422b;
        }
        return statsReporter;
    }

    /* renamed from: a */
    public void mo19205a( ArrayList<Bundle> arrayList) {
        try {
            f2423c.execute(new Runnable() {
                public void run() {
                    try {
                        if (arrayList.size() > 0) {
                            Logger.m3601d(StatsReporter.f2421a, "Starting report stats events!");
                            AppLovinBridge.m2797a((ArrayList<Bundle>) arrayList, (AppLovinCommunicatorPublisher) StatsReporter.this);
                        }
                    } catch (Throwable th) {
                        Logger.m3604e(StatsReporter.f2421a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.m3604e(f2421a, "failed during reportEvents. events: " + arrayList, th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: a */
    public ArrayList<Bundle> mo19204a(Set<StatsEvent> set) {
        Object valueOf;
        Logger.m3601d(f2421a, "filtersReportsAndBundle started");
        StringBuilder append = new StringBuilder().append("eventsToSend : ");
        if (set == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(set.size());
        }
        Logger.m3601d(f2421a, append.append(valueOf).toString());
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            for (StatsEvent next : set) {
                boolean z = false;
                if (SafeDK.m2711b() && (next.mo19511b().equals(StatsCollector.EventType.BrandSafety) || next.mo19511b().equals(StatsCollector.EventType.redirect))) {
                    z = true;
                }
                Logger.m3601d(f2421a, "Event type = " + next.mo19511b() + "; should report = " + z);
                Bundle d = next.mo19513d();
                Logger.m3601d(f2421a, next.mo19511b() + " event:" + C1361h.m3683a(d).toString());
                if (z) {
                    Set<String> e = next.mo19514e();
                    if (e != null) {
                        HashSet hashSet = new HashSet();
                        for (String next2 : e) {
                            if (!d.containsKey(next2)) {
                                hashSet.add(next2);
                            }
                        }
                        if (hashSet.size() > 0) {
                            Logger.m3601d(f2421a, "*** missing fields: " + hashSet);
                        }
                    }
                    arrayList.add(d);
                }
            }
            C1361h.m3694b(f2421a, "events to be reported : " + arrayList.toString());
        } catch (Exception e2) {
            Logger.m3604e(f2421a, "Exception filtering events for report", e2);
        }
        return arrayList;
    }
}

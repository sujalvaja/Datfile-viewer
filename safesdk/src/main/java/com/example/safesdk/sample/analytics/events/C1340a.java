package com.example.safesdk.sample.analytics.events;

import java.util.Comparator;

/* renamed from: com.example.safesdk.sample.analytics.events.a */
public class C1340a implements Comparator<MaxEvent> {
    /* renamed from: a */
    public int compare(MaxEvent maxEvent, MaxEvent maxEvent2) {
        if (maxEvent.mo19521c() > maxEvent2.mo19521c()) {
            return 1;
        }
        if (maxEvent.mo19521c() < maxEvent2.mo19521c()) {
            return -1;
        }
        return 0;
    }
}

package com.example.safesdk.sample.analytics.events;

import android.os.Bundle;
import com.example.safesdk.sample.utils.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MaxEvents extends ArrayList<MaxEvent> implements Serializable {

    /* renamed from: a */
    private static  String f3275a = "MaxEvents";

    /* renamed from: b */
    private int f3276b = 10;

    private MaxEvents() {
    }

    public MaxEvents(int capacity) {
        this.f3276b = capacity;
    }

    /* renamed from: a */
    public boolean add(MaxEvent maxEvent) {
        if (size() >= this.f3276b) {
            remove(0);
        }
        return super.add(maxEvent);
    }

    /* renamed from: a */
    public void add(int i, MaxEvent maxEvent) {
        super.add(i, maxEvent);
    }

    /* renamed from: a */
    public ArrayList<Bundle> mo19527a() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((MaxEvent) it.next()).mo19525f());
        }
        Logger.m3601d(f3275a, "MaxEvents toBundle : " + arrayList.toString());
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxEvents (" + size() + " items)");
        return sb.toString();
    }
}

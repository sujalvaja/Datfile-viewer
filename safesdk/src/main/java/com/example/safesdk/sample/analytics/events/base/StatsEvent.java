package com.example.safesdk.sample.analytics.events.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;
import java.io.Serializable;
import java.util.Set;

public abstract class StatsEvent implements Serializable, Comparable<StatsEvent> {

    /* renamed from: A */
    protected static  String f3294A = "timestamp";

    /* renamed from: B */
    public static  String f3295B = "application";

    /* renamed from: a */
    private static  String f3296a = "StatsEvent";
    private static  long serialVersionUID = 0;

    /* renamed from: w */
    protected static  String f3297w = "sdk_version";

    /* renamed from: x */
    protected static  String f3298x = "sdk_uuid";

    /* renamed from: y */
    protected static  String f3299y = "isBackground";

    /* renamed from: z */
    public static  String f3300z = "event_type";

    /* renamed from: C */
    protected String f3301C;

    /* renamed from: D */
    protected String f3302D;

    /* renamed from: E */
    protected StatsCollector.EventType f3303E;

    /* renamed from: F */
    protected boolean f3304F;

    /* renamed from: G */
    protected long f3305G;

    /* renamed from: H */
    protected int f3306H;

    /* renamed from: I */
    protected boolean f3307I = true;

    /* renamed from: J */
    protected boolean f3308J = false;

    /* renamed from: K */
    String f3309K = null;

    /* renamed from: aq */
    protected transient boolean f3310aq = false;

    /* renamed from: a */
    public abstract void mo19510a(StatsEvent statsEvent);

    /* renamed from: b */
    public abstract StatsCollector.EventType mo19511b();

    /* renamed from: c */
    public abstract String mo19512c();

    /* renamed from: g */
    public boolean mo19546g() {
        return this.f3310aq;
    }

    /* renamed from: a */
    public void mo19540a(boolean z) {
        this.f3310aq = z;
    }

    public StatsEvent(String sdk, StatsCollector.EventType eventType) {
        this.f3303E = eventType;
        this.f3301C = sdk;
        this.f3304F = C1347b.getInstance().isInBackground();
        this.f3305G = C1361h.m3690b(System.currentTimeMillis());
        this.f3306H = SafeDK.m2714f();
        Logger.m3601d(f3296a, "StatsEvent ctor sdk=" + sdk);
    }

    /* renamed from: h */
    public String mo19547h() {
        return this.f3301C;
    }

    /* renamed from: i */
    public long mo19548i() {
        return this.f3305G;
    }

    /* renamed from: a */
    public void mo19539a(long j) {
        this.f3305G = j;
    }

    /* renamed from: d */
    public Bundle mo19513d() {
        String str;
        Bundle bundle = new Bundle();
        Logger.m3601d(f3296a, "toBundle sdk=" + this.f3301C + " , sdkUid=" + this.f3309K);
        if (this.f3301C != null) {
            this.f3309K = SdksMapping.getSdkUUIDByPackage(this.f3301C);
            if (this.f3309K == null) {
                this.f3309K = this.f3301C;
            }
        }
        if (this.f3309K != null) {
            bundle.putString(f3298x, this.f3309K);
        } else {
            Logger.m3601d(f3296a, "toBundle unable to determine sdk/sdk_uuid field value");
        }
        if (!(this.f3309K == null || this.f3302D != null || (str = SdksMapping.getAllSdkVersionsMap().get(this.f3309K)) == null)) {
            bundle.putString("sdk_version", str);
        }
        bundle.putString(f3300z, mo19511b().toString());
        bundle.putLong(f3294A, this.f3305G);
        if (!TextUtils.isEmpty(this.f3302D)) {
            bundle.putString("sdk_version", this.f3302D);
        }
        if (this.f3301C == null) {
            Logger.m3601d(f3296a, "toBundle sdk field value was null. bundle : " + bundle.toString());
        }
        Logger.m3601d(f3296a, "toBundle : " + bundle.toString());
        return bundle;
    }

    /* renamed from: b */
    public void mo19541b(StatsEvent statsEvent) {
        if (mo19511b() == statsEvent.mo19511b()) {
            this.f3307I |= statsEvent.f3307I;
            mo19510a(statsEvent);
            return;
        }
        Logger.m3603e(f3296a, "Cannot aggregate events of different types");
    }

    
    /* renamed from: j */
    public long mo19549j() {
        return C1361h.m3696c(this.f3305G);
    }

    /* renamed from: a_ */
    public boolean mo19535a_() {
        return this.f3307I;
    }

    /* renamed from: b */
    public void mo19542b(boolean z) {
        this.f3307I = z;
    }

    /* renamed from: k */
    public boolean mo19550k() {
        return this.f3308J;
    }

    /* renamed from: c */
    public void mo19544c(boolean z) {
        this.f3308J = z;
    }

    /* renamed from: e */
    public Set<String> mo19514e() {
        return null;
    }

    /* renamed from: c */
    public int compareTo(StatsEvent statsEvent) {
        if (statsEvent == null) {
            throw new NullPointerException();
        } else if (this.f3305G == statsEvent.f3305G) {
            return 0;
        } else {
            if (this.f3305G < statsEvent.f3305G) {
                return -1;
            }
            return 1;
        }
    }

    public String toString() {
        return mo19513d().toString();
    }
}

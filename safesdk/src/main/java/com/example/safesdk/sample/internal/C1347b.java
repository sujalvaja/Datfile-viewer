package com.example.safesdk.sample.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.example.safesdk.sample.internal.b */
public class C1347b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private static  String f3399a = "LifecycleManager";

    /* renamed from: b */
    private static C1347b f3400b = null;

    /* renamed from: f */
    private static boolean f3401f;

    /* renamed from: c */
    private LinkedHashSet<Activity> f3402c = new LinkedHashSet<>();

    /* renamed from: d */
    private int f3403d = 0;

    /* renamed from: e */
    private boolean f3404e = true;

    /* renamed from: g */
    private Set<C1346a> f3405g = Collections.newSetFromMap(new ConcurrentHashMap());

    private C1347b() {
    }

    public static synchronized C1347b getInstance() {
        C1347b bVar;
        synchronized (C1347b.class) {
            if (f3400b == null) {
                f3400b = new C1347b();
            }
            bVar = f3400b;
        }
        return bVar;
    }

/*
    public synchronized Activity getForegroundActivity() {
        Activity activity;
        try {
            Logger.m3601d(f3399a, "getForegroundActivity Number of live activities " + this.f3402c.size() + ", activities = " + this.f3402c.toString());
            if (this.f3402c.size() > 0) {
                activity = (Activity) this.f3402c.toArray()[this.f3402c.size() - 1];
                try {
                    Logger.m3601d(f3399a, "getForegroundActivity Foreground activity is " + activity.toString());
                } catch (Throwable th) {
                    th = th;
                    Logger.m3604e(f3399a, th.getMessage(), th);
                    new CrashReporter().caughtException(th);
                    return activity;
                }
            } else {
                activity = null;
            }
        } catch (Throwable th2) {
            th = th2;
            activity = null;
            Logger.m3604e(f3399a, th.getMessage(), th);
            new CrashReporter().caughtException(th);
            return activity;
        }
        return activity;
    }
*/

    public boolean isInBackground() {
        return this.f3404e;
    }

    public synchronized boolean isInterstitialActivity(Context activity) {
        boolean z = false;
        synchronized (this) {
            if (this.f3403d != 0) {
                if (this.f3403d == System.identityHashCode(activity)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (f3401f) {
            Logger.m3601d(f3399a, "onActivityCreated " + activity.toString());
        }
    }

    public synchronized void onActivityStarted(Activity activity) {
        try {
            if (f3401f) {
                Logger.m3601d(f3399a, "onActivityStarted " + activity.toString());
                this.f3402c.add(activity);
                Logger.m3601d(f3399a, "onActivityStarted foregroundActivities=" + this.f3402c.toString());
                if (this.f3402c.size() == 1) {
                    m3512b();
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3399a, "onActivityStarted failed", th);
            new CrashReporter().caughtException(th);
        }
        return;
    }

    public void onActivityResumed(Activity activity) {
        try {
            if (f3401f) {
                Logger.m3601d(f3399a, "onActivityResumed " + activity.toString() + ", isActive=" + f3401f);
                if (BrandSafetyUtils.m2914c((Class) activity.getClass())) {
                    this.f3403d = System.identityHashCode(activity);
                    SafeDK.getInstance().mo19126a(activity);
                    return;
                }
                SafeDK.getInstance().mo19132c(activity);
            }
        } catch (Throwable th) {
            Logger.m3604e(f3399a, "onActivityResumed failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    public void onActivityPaused(Activity activity) {
        try {
            if (f3401f) {
                Logger.m3601d(f3399a, "onActivityPaused " + activity.toString());
                if (BrandSafetyUtils.m2914c((Class) activity.getClass())) {
                    SafeDK.getInstance().mo19129b(activity);
                } else {
                    SafeDK.getInstance().mo19135d(activity);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3399a, "onActivityPaused failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        try {
            if (f3401f) {
                Logger.m3601d(f3399a, "onActivityStopped " + activity.toString());
                this.f3402c.remove(activity);
                Logger.m3601d(f3399a, "onActivityStopped foregroundActivities=" + this.f3402c.toString());
                if (this.f3402c.size() == 0) {
                    m3509a();
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3399a, "onActivityStopped failed", th);
            new CrashReporter().caughtException(th);
        }
        return;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (f3401f) {
            Logger.m3601d(f3399a, "onActivitySaveInstanceState " + activity.toString());
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (f3401f) {
            Logger.m3601d(f3399a, "onActivityDestroyed " + activity.toString());
            if (BrandSafetyUtils.m2914c((Class) activity.getClass())) {
                SafeDK.getInstance().mo19130b(activity.toString());
            }
        }
    }

    /* renamed from: a */
    private void m3510a(boolean z) {
        this.f3404e = z;
    }

    /* renamed from: a */
    private void m3509a() {
        Logger.m3601d(f3399a, "Identified background");
        m3510a(true);
        for (C1346a next : this.f3405g) {
            Logger.m3601d(f3399a, "notifyBackground to " + next.getClass().getCanonicalName());
            next.mo19198f();
        }
    }

    /* renamed from: b */
    private void m3512b() {
        Logger.m3601d(f3399a, "Identified foreground");
        m3510a(false);
        for (C1346a g : this.f3405g) {
            g.mo19199g();
        }
    }

    public synchronized void registerBackgroundForegroundListener(C1346a listener) {
        try {
            if (f3401f) {
                if (!this.f3405g.contains(listener) && !m3511a(listener)) {
                    Logger.m3601d(f3399a, "Adding " + listener.getClass() + " to listen to BG FG events");
                    this.f3405g.add(listener);
                    if (isInBackground()) {
                        listener.mo19198f();
                    } else {
                        listener.mo19199g();
                    }
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3399a, "Failed to add listener to BG/FG events", th);
            new CrashReporter().caughtException(th);
        }
        return;
    }

    /* renamed from: a */
    private boolean m3511a(C1346a aVar) {
        Logger.m3601d(f3399a, "listenersContainsType started, listener is " + aVar.getClass());
        ArrayList arrayList = new ArrayList();
        if (this.f3405g != null) {
            Logger.m3601d(f3399a, "listenersContainsType iteration listener is " + aVar.getClass());
            for (C1346a aVar2 : this.f3405g) {
                arrayList.add(aVar2.getClass().getCanonicalName());
            }
        }
        return arrayList.contains(aVar.getClass().getCanonicalName());
    }

    public synchronized void clearBackgroundForegroundListeners() {
        Logger.m3601d(f3399a, "Clearing Background Foreground listeners collection");
        this.f3405g = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void setActiveMode(boolean enable) {
        f3401f = enable;
        Logger.m3601d(f3399a, "setting active mode to " + enable);
    }

    public Activity getForegroundActivity() {
        return null;
    }
}

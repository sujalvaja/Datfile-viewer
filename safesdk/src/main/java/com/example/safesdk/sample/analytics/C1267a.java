package com.example.safesdk.sample.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.safesdk.sample.analytics.reporters.C1341a;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.example.safesdk.sample.analytics.a */
public class C1267a extends Thread {

    /* renamed from: a */
    private static  String f2426a = "ANRDetector";

    /* renamed from: b */
    private static  int f2427b = 5000;

    /* renamed from: c */
    private static  Set<String> f2428c = new HashSet(Arrays.asList(new String[]{"com.android.internal.os.RuntimeInit$UncaughtHandler.uncaughtException", "com.android.internal.os.RuntimeInit$KillApplicationHandler.uncaughtException"}));

    /* renamed from: d */
    public volatile int f2429d;

    /* renamed from: e */
    private Context f2430e;

    /* renamed from: f */
    private int f2431f;

    /* renamed from: g */
    private Handler f2432g;

    /* renamed from: h */
    private C1341a f2433h;

    /* renamed from: i */
    private String f2434i;

    /* renamed from: j */
    private boolean f2435j;

    /* renamed from: k */
    private  Runnable f2436k;

    public C1267a(Context context) {
        this(context, 5000, false);
    }

    public C1267a(Context context, boolean z) {
        this(context, 5000, z);
    }

    public C1267a(Context context, int i, boolean z) {
        this.f2429d = 0;
        this.f2436k = new Runnable() {
            public void run() {
                int unused = C1267a.this.f2429d = (C1267a.this.f2429d + 1) % Integer.MAX_VALUE;
            }
        };
        this.f2430e = context;
        this.f2431f = i;
        this.f2435j = z;
        this.f2432g = new Handler(Looper.getMainLooper());
        this.f2433h = new C1341a(context);
    }

    public void run() {
    }

    /* renamed from: a */
    private StackTraceElement[] m2833a() {
        return Looper.getMainLooper().getThread().getStackTrace();
    }

    /* renamed from: a */
    private static String m2832a(StackTraceElement[] stackTraceElementArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                instance.update(stackTraceElement.toString().getBytes());
            }
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}

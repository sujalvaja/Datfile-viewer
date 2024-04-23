package com.example.safesdk.sample;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.StatsReporter;
import com.example.safesdk.sample.analytics.brandsafety.BannerFinder;
import com.example.safesdk.sample.analytics.brandsafety.C1319d;
import com.example.safesdk.sample.analytics.brandsafety.C1320e;
import com.example.safesdk.sample.analytics.brandsafety.C1324f;
import com.example.safesdk.sample.analytics.brandsafety.C1331g;
import com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.internal.C1349d;
import com.example.safesdk.sample.internal.DeviceData;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1359f;
import com.example.safesdk.sample.utils.Logger;

import com.google.android.gms.common.api.Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class SafeDK {

    /* renamed from: H */
    private static AtomicBoolean f2295H = new AtomicBoolean(false);

    /* renamed from: I */
    private static AtomicBoolean f2296I = new AtomicBoolean(false);

    /* renamed from: J */
    private static Boolean f2297J = false;

    /* renamed from: a */
    public static  String f2298a = "com.example.safedk";

    /* renamed from: c */
    private static  String f2299c = "SafeDKMain";

    /* renamed from: d */
    private static  String f2300d = "SafeDK";

    /* renamed from: e */
    private static  String f2301e = "https://config.safedk.com/";

    /* renamed from: f */
    private static  String f2302f = "com.example.safedk.AppID";

    /* renamed from: g */
    private static  String f2303g = "com.example.safedk.ConfigPrefix";

    /* renamed from: h */
    private static  String f2304h = "com.example.safedk.APIPrefix";

    /* renamed from: i */
    private static  String f2305i = "com.example.safedk.DebugMode";

    /* renamed from: j */
    private static  String f2306j = "com.example.safedk.MaximumStatsSetSize";

    /* renamed from: k */
    private static  String f2307k = "com.example.safedk.AggregationThreshold";

    /* renamed from: l */
    private static  List<String> f2308l = Arrays.asList(new String[]{"com.android.vending", "com.amazon.venezia", "com.sec.android.app.samsungapps"});

    /* renamed from: m */
    private static boolean f2309m = false;

    /* renamed from: n */
    private static String f2310n;

    /* renamed from: o */
    private static String f2311o;

    /* renamed from: p */
    private static String f2312p;

    /* renamed from: q */
    private static int f2313q;

    /* renamed from: r */
    private static boolean f2314r;

    /* renamed from: t */
    private static boolean f2315t;

    /* renamed from: u */
    private static SafeDK f2316u = null;

    /* renamed from: v */
    private static Context f2317v;

    /* renamed from: w */
    private static C1349d f2318w = new C1349d();

    /* renamed from: x */
    private static AtomicBoolean f2319x = new AtomicBoolean(false);

    /* renamed from: A */
    private C1319d f2320A = null;

    /* renamed from: B */
    private InterstitialFinder f2321B = null;

    /* renamed from: C */
    private BannerFinder f2322C = null;

    /* renamed from: D */
    private C1359f f2323D;

    /* renamed from: E */
    private AtomicBoolean f2324E = new AtomicBoolean(false);

    /* renamed from: F */
    private int f2325F = 0;

    /* renamed from: G */
    private int f2326G = 0;

    /* renamed from: b */
    C1324f f2327b = null;

    /* renamed from: s */
    private boolean f2328s;

    /* renamed from: y */
    private String f2329y = null;

    /* renamed from: z */
    private DeviceData f2330z;

    public static String getSdkKey() {
        return "DaM0EZg08VG4QyiQ5tehq_QLmuM4KUDQW0LL8dtwemkd_MHn_kT8tiAVlF6fJQJ_8ntQT1gXQElih8VkXRQtBT";
    }

    /* renamed from: a */
    public static boolean m2708a() {
        return f2315t;
    }

    /* renamed from: b */
    public static synchronized boolean m2711b() {
        boolean z;
        synchronized (SafeDK.class) {
            z = f2319x.get();
        }
        return z;
    }

    private SafeDK(Context context) {
        Logger.m3601d(f2299c, "SafeDK ctor started");
        f2317v = context;
        AppLovinBridge.init(context);
        this.f2323D = new C1359f(context.getSharedPreferences("SafeDKToggles", 0), f2309m);
        Logger.m3601d(f2299c, "Before reading shared prefs");
        this.f2330z = new DeviceData(context, this.f2323D);
    }

    /* renamed from: R */
    private void m2697R() {
        Logger.m3601d(f2299c, "init");
        if (!mo19143l()) {
            if (this.f2321B != null) {
                this.f2321B.mo19212a();
                this.f2321B = null;
            }
            if (this.f2322C != null) {
                this.f2322C.mo19212a();
                this.f2322C = null;
            }
        }
    }

    /* renamed from: S */
    private void m2698S() {
        try {
            ApplicationInfo applicationInfo = f2317v.getPackageManager().getApplicationInfo(f2317v.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                m2705a(applicationInfo);
                m2709b(applicationInfo);
                m2712c(applicationInfo);
                m2713d(applicationInfo);
                return;
            }
            Logger.m3603e(f2299c, "SafeDK meta data is missing from manifest file");
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m3601d(f2299c, "Couldn't get application's meta data");
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2705a(ApplicationInfo r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            android.content.Context r2 = f2317v     // Catch:{ NameNotFoundException -> 0x010b }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x010b }
            android.content.Context r3 = f2317v     // Catch:{ NameNotFoundException -> 0x010b }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x010b }
            r4 = 0
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x010b }
            java.lang.String r3 = "SafeDKMain"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r4.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r5 = "package is: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r5 = r2.packageName     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r5 = ", Installer Package Name is "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x0114 }
            android.content.Context r5 = f2317v     // Catch:{ Throwable -> 0x0114 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r6 = r2.packageName     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r5 = r5.getInstallerPackageName(r6)     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0114 }
            com.example.safesdk.sample.utils.Logger.m3601d(r3, r4)     // Catch:{ Throwable -> 0x0114 }
            java.util.List<java.lang.String> r3 = f2308l     // Catch:{ Throwable -> 0x0114 }
            android.content.Context r4 = f2317v     // Catch:{ Throwable -> 0x0114 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r5 = r2.packageName     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r4 = r4.getInstallerPackageName(r5)     // Catch:{ Throwable -> 0x0114 }
            boolean r3 = r3.contains(r4)     // Catch:{ Throwable -> 0x0114 }
            f2315t = r3     // Catch:{ Throwable -> 0x0114 }
            int r3 = r8.flags     // Catch:{ Throwable -> 0x0114 }
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0125
        L_0x005d:
            f2314r = r0     // Catch:{ Throwable -> 0x0114 }
            android.os.Bundle r0 = r8.metaData     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r0 = extractAppIdentifier(r0)     // Catch:{ Throwable -> 0x0114 }
            f2312p = r0     // Catch:{ Throwable -> 0x0114 }
            android.net.Uri$Builder r0 = new android.net.Uri$Builder     // Catch:{ Throwable -> 0x0114 }
            r0.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = "apps"
            android.net.Uri$Builder r0 = r0.appendPath(r1)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = "cfg"
            android.net.Uri$Builder r0 = r0.appendPath(r1)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = f2312p     // Catch:{ Throwable -> 0x0114 }
            android.net.Uri$Builder r0 = r0.appendPath(r1)     // Catch:{ Throwable -> 0x0114 }
            int r1 = r2.versionCode     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0114 }
            android.net.Uri$Builder r0 = r0.appendPath(r1)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = "store"
            boolean r3 = f2315t     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x0114 }
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r1, r3)     // Catch:{ Throwable -> 0x0114 }
            boolean r1 = f2315t     // Catch:{ Throwable -> 0x0114 }
            if (r1 == 0) goto L_0x00a2
            java.lang.String r1 = "versionName"
            java.lang.String r3 = r2.versionName     // Catch:{ Throwable -> 0x0114 }
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r1, r3)     // Catch:{ Throwable -> 0x0114 }
        L_0x00a2:
            android.net.Uri r0 = r0.build()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0114 }
            android.os.Bundle r1 = r8.metaData     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = extractUrlPrefix(r1)     // Catch:{ Throwable -> 0x0114 }
            f2311o = r1     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = f2311o     // Catch:{ Throwable -> 0x0114 }
            if (r1 == 0) goto L_0x0128
            java.lang.String r1 = f2311o     // Catch:{ Throwable -> 0x0114 }
            int r1 = r1.length()     // Catch:{ Throwable -> 0x0114 }
            if (r1 <= 0) goto L_0x0128
            java.lang.String r1 = "SafeDKMain"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r3.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r4 = "apiURL Value from manifest is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r4 = f2311o     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r4 = ". Setting new edge urls"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0114 }
            com.example.safesdk.sample.utils.Logger.m3601d(r1, r3)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = f2311o     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r3 = f2311o     // Catch:{ Throwable -> 0x0114 }
            com.example.safesdk.sample.analytics.AppLovinBridge.receiveEdgeUrls(r1, r3)     // Catch:{ Throwable -> 0x0114 }
        L_0x00e5:
            int r1 = r2.versionCode     // Catch:{ Throwable -> 0x0114 }
            f2313q = r1     // Catch:{ Throwable -> 0x0114 }
            android.os.Bundle r1 = r8.metaData     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r2 = "com.example.safedk.ConfigPrefix"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Throwable -> 0x0114 }
            if (r1 != 0) goto L_0x0130
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r1.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r2 = getDefaultConfig()     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0114 }
            f2310n = r0     // Catch:{ Throwable -> 0x0114 }
        L_0x010a:
            return
        L_0x010b:
            r0 = move-exception
            java.lang.String r0 = "SafeDKMain"
            java.lang.String r1 = "Bad URL; won't update toggles"
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ Throwable -> 0x0114 }
            goto L_0x010a
        L_0x0114:
            r0 = move-exception
            java.lang.String r1 = "SafeDKMain"
            java.lang.String r2 = "Caught exception"
            com.example.safesdk.sample.utils.Logger.m3604e(r1, r2, r0)
            com.example.safesdk.sample.analytics.reporters.CrashReporter r1 = new com.example.safesdk.sample.analytics.reporters.CrashReporter
            r1.<init>()
            r1.caughtException(r0)
            goto L_0x010a
        L_0x0125:
            r0 = r1
            goto L_0x005d
        L_0x0128:
            java.lang.String r1 = "SafeDKMain"
            java.lang.String r3 = "no apiURL Value in manifest"
            com.example.safesdk.sample.utils.Logger.m3601d(r1, r3)     // Catch:{ Throwable -> 0x0114 }
            goto L_0x00e5
        L_0x0130:
            java.lang.String r2 = java.io.File.separator     // Catch:{ Throwable -> 0x0114 }
            boolean r2 = r1.endsWith(r2)     // Catch:{ Throwable -> 0x0114 }
            if (r2 != 0) goto L_0x014b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r2.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0114 }
        L_0x014b:
            java.lang.String r2 = java.io.File.separator     // Catch:{ Throwable -> 0x0114 }
            boolean r2 = r0.startsWith(r2)     // Catch:{ Throwable -> 0x0114 }
            if (r2 == 0) goto L_0x0158
            r2 = 1
            java.lang.String r0 = r0.substring(r2)     // Catch:{ Throwable -> 0x0114 }
        L_0x0158:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r2.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0114 }
            f2310n = r0     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r0 = "SafeDKMain"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0114 }
            r1.<init>()     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r2 = "basePrefix != null, configUrl:"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r2 = f2310n     // Catch:{ Throwable -> 0x0114 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0114 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0114 }
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ Throwable -> 0x0114 }
            goto L_0x010a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.SafeDK.m2705a(android.content.pm.ApplicationInfo):void");
    }

    private static String extractAppIdentifier(Bundle metaData) {
        return metaData.getString(f2302f);
    }

    private static String extractUrlPrefix(Bundle metaData) {
        return metaData.getString(f2304h, "https://edge.safedk.com");
    }

    private static String getDefaultConfig() {
        return f2301e;
    }

    public static String getProguardMD5() {
        return "";
    }

    /* renamed from: b */
    private void m2709b(ApplicationInfo applicationInfo) {
        boolean z = false;
        if (f2318w.mo19619v() && (applicationInfo.metaData.getBoolean(f2305i, false) || m2702W())) {
            z = true;
        }
        Logger.setDebugMode(z);
    }

    /* renamed from: c */
    private void m2712c(ApplicationInfo applicationInfo) {
        f2318w.mo19594a(applicationInfo.metaData.getInt(f2306j, C1349d.f3439b));
    }

    /* renamed from: d */
    private void m2713d(ApplicationInfo applicationInfo) {
        f2318w.mo19597b(applicationInfo.metaData.getInt(f2307k, C1349d.f3440c));
    }

    /* renamed from: T */
    private void m2699T() {
        this.f2329y = UUID.randomUUID().toString();
        this.f2323D.mo19685a(this.f2329y);
    }

    /* renamed from: a */
    public static synchronized SafeDK m2703a(Context context) {
        SafeDK safeDK;
        synchronized (SafeDK.class) {
            Logger.m3601d(f2299c, "start started");
            if (f2316u == null) {
                f2316u = new SafeDK(context);
                f2316u.mo19128a(false);
                if (f2318w.mo19619v()) {
                    Logger.m3605i("SafeDK", "SafeDK Device ID: " + f2316u.f2329y);
                    Logger.m3605i("SafeDK", "SafeDK version: " + getVersion());
                }
                f2316u.m2710b(true);
            } else {
                Logger.m3601d(f2299c, "SafeDK already started");
            }
            safeDK = f2316u;
        }
        return safeDK;
    }

    /* renamed from: a */
    public static void m2704a(Application application) {
        if (getInstance().mo19141j() && Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(C1347b.getInstance());
        }
    }

    /* renamed from: U */
    private void m2700U() {
        try {
            Logger.m3601d(f2299c, "setIsFirstSession started");
            if (!f2296I.get()) {
                String p = this.f2323D.mo19701p();
                Logger.m3601d(f2299c, "setIsFirstSession Current safedk version : 4.0.0 , stored version is " + p);
                if (p == null || !C1254a.f2331a.equals(p)) {
                    Logger.m3601d(f2299c, "setIsFirstSession setting is_first_session to true");
                    this.f2328s = true;
                }
                this.f2323D.mo19688c(C1254a.f2331a);
                f2296I.set(true);
                return;
            }
            Logger.m3601d(f2299c, "setIsFirstSession already executed, value is " + this.f2328s);
        } catch (Throwable th) {
            Logger.m3602d(f2299c, "setIsFirstSession Exception : " + th.getMessage(), th);
        }
    }

    /* renamed from: c */
    public boolean mo19133c() {
        return this.f2328s;
    }

    public static SafeDK getInstance() {
        return f2316u;
    }

    /* renamed from: d */
    public int mo19134d() {
        return f2318w.mo19593a();
    }

    /* renamed from: e */
    public boolean mo19136e() {
        return f2318w.mo19599b();
    }

    /* renamed from: a */
    private void m2707a(boolean z, boolean z2) {
        try {
            if (f2316u == null) {
                Logger.m3601d(f2299c, "instance is null, existing");
                return;
            }
            f2316u.m2710b(false);
            if (!f2318w.mo19619v()) {
                Logger.m3601d(f2299c, "SafeDK is disabled.");
                Logger.setDebugMode(false);
                C1347b.getInstance().clearBackgroundForegroundListeners();
                return;
            }
            m2698S();
            if (m2702W()) {
                Logger.setDebugMode(true);
            }
            Logger.m3601d(f2299c, "Configuration download completed, configurationDownloadedSuccessfully=" + z);
            Logger.m3601d(f2299c, "configurationDownloadCompleted isMaxProcess " + z2);
            Logger.m3601d(f2299c, "configurationDownloadCompleted isActive " + f2318w.mo19619v());
            if (f2318w.mo19619v()) {
                m2701V();
                if (z2 && !f2295H.get()) {
                    f2295H.set(true);
                    if (z) {
                        Logger.m3601d(f2299c, "Will attempt to load events from storage");
                        StatsCollector.m2806b().mo19194c();
                    } else {
                        m2700U();
                    }
                    m2700U();
                    Logger.m3601d(f2299c, "Loading singletons");
                    C1320e.m3369a();
                    C1331g.m3396a();
                    if (this.f2327b == null) {
                        this.f2327b = C1324f.m3378a();
                    }
                    if (this.f2320A == null) {
                        this.f2320A = new C1319d();
                    }
                    if (this.f2321B == null) {
                        this.f2321B = new InterstitialFinder();
                    }
                    if (this.f2322C == null && mo19142k()) {
                        this.f2322C = new BannerFinder();
                    }
                }
            }
            this.f2324E.set(true);
        } catch (Throwable th) {
            Logger.m3604e(f2299c, "Exception handling configuration event", th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: V */
    private static void m2701V() {
        Logger.m3601d(f2299c, "Starting reporter init func called");
        if (!f2319x.get()) {
            Logger.m3601d(f2299c, "Starting reporter thread");
            StatsCollector.m2804a(true);
            int x = f2318w.mo19621x();
            int B = f2318w.mo19583B();
            StatsReporter.m2826a();
            StatsCollector.m2806b().mo19189a(x, C1347b.getInstance().isInBackground(), B, StatsReporter.m2827b());
            StatsCollector.m2804a(false);
            StatsCollector.m2808b(getInstance().mo19143l());
            f2319x.set(true);
            Logger.m3601d(f2299c, "Reporter thread started");
            return;
        }
        Logger.m3601d(f2299c, "Reporter thread already initialized, skipping");
    }

    /* renamed from: a */
    public void mo19127a(Bundle bundle, boolean z) {
        Logger.m3601d(f2299c, "Updating configuration");
        boolean a = f2318w.mo19596a(bundle, true);
        if (a) {
            m2706a(bundle);
        }
        m2707a(a, z);
    }

    /* renamed from: a */
    private void m2706a(Bundle bundle) {
        Logger.m3601d(f2299c, "Writing to shared preferences: " + bundle.toString());
        this.f2323D.mo19684a(bundle);
    }

    /* renamed from: f */
    public static int m2714f() {
        return f2313q;
    }

    /* renamed from: g */
    public Context mo19137g() {
        return f2317v;
    }

    /* renamed from: h */
    public boolean mo19139h() {
        return f2318w.mo19620w() || m2702W();
    }

    /* renamed from: i */
    public boolean mo19140i() {
        return f2314r;
    }

    /* renamed from: j */
    public boolean mo19141j() {
        return f2318w.mo19619v();
    }

    /* renamed from: k */
    public boolean mo19142k() {
        return f2318w.mo19615r();
    }

    /* renamed from: l */
    public boolean mo19143l() {
        return !mo19144m() && f2318w.mo19619v();
    }

    /* renamed from: m */
    public boolean mo19144m() {
        return this.f2323D.mo19686b();
    }

    /* renamed from: W */
    private boolean m2702W() {
        try {
            Set<String> F = f2318w.mo19587F();
            if (F.contains("*") || F.contains(this.f2329y)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Logger.m3604e(f2299c, "Caught exception", th);
            new CrashReporter().caughtException(th);
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m2715n() {
        return f2318w.mo19582A();
    }

    /* renamed from: o */
    public List<String> mo19145o() {
        return f2318w.mo19616s();
    }

    /* renamed from: p */
    public List<String> mo19146p() {
        return f2318w.mo19617t();
    }

    /* renamed from: q */
    public DeviceData mo19147q() {
        return this.f2330z;
    }

    /* renamed from: r */
    public InterstitialFinder mo19148r() {
        return this.f2321B;
    }

    /* renamed from: s */
    public BannerFinder mo19149s() {
        return this.f2322C;
    }

    /* renamed from: t */
    public C1319d mo19150t() {
        return this.f2320A;
    }

    /* renamed from: u */
    public int mo19151u() {
        return f2318w.mo19623z();
    }

    /* renamed from: v */
    public int mo19152v() {
        return this.f2326G;
    }

    /* renamed from: w */
    public int mo19153w() {
        return this.f2325F;
    }

    /* renamed from: a */
    public int mo19125a(String str) {
        int c;
        if (str.equals(C1357d.f3603k)) {
            c = 16384;
        } else {
            c = f2318w.mo19600c();
        }
        Logger.m3601d(f2299c, "getMinValidImageSize sdkPackage=" + str + ", result = " + c);
        return c;
    }

    /* renamed from: x */
    public int mo19154x() {
        return f2318w.mo19601d();
    }

    /* renamed from: y */
    public float mo19155y() {
        return f2318w.mo19602e();
    }

    /* renamed from: z */
    public float mo19156z() {
        return f2318w.mo19603f();
    }

    /* renamed from: A */
    public boolean mo19110A() {
        return f2318w.mo19604g();
    }

    /* renamed from: B */
    public int mo19111B() {
        return f2318w.mo19605h();
    }

    /* renamed from: C */
    public long mo19112C() {
        return f2318w.mo19606i();
    }

    /* renamed from: D */
    public int mo19113D() {
        return f2318w.mo19607j();
    }

    /* renamed from: E */
    public int mo19114E() {
        return f2318w.mo19608k();
    }

    /* renamed from: F */
    public int mo19115F() {
        return f2318w.mo19609l();
    }

    /* renamed from: a */
    public void mo19128a(boolean z) {
        Logger.m3601d(f2299c, "Reading configuration from shared preferences");
        try {
            this.f2329y = this.f2323D.mo19681a();
            if (this.f2329y == null) {
                m2699T();
            }
            Bundle e = this.f2323D.mo19690e();
            Logger.m3601d(f2299c, "configurationBundle loaded : " + e.toString());
            if (e == null || e.isEmpty()) {
                Logger.m3601d(f2299c, "Configuration bundle from storage is empty");
            } else {
                Logger.m3601d(f2299c, "Parsing configuration from shared preferences");
                f2318w.mo19596a(e, false);
            }
            m2707a(false, z);
        } catch (Throwable th) {
            Logger.m3604e(f2299c, "Caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: a */
    public synchronized void mo19126a(Activity activity) {
        Logger.m3601d(f2299c, "Starting interstitial finder in activity " + activity.getClass().getName());
        if (this.f2321B != null) {
            this.f2321B.mo19251d();
        }
    }

    /* renamed from: b */
    public synchronized void mo19129b(Activity activity) {
        Logger.m3601d(f2299c, "Stopping interstitial finder in activity " + activity.getClass().getName());
        if (this.f2321B != null) {
            this.f2321B.mo19245a(activity);
        }
    }

    /* renamed from: b */
    public synchronized void mo19130b(String str) {
        if (this.f2321B != null) {
            this.f2321B.mo19250c(str);
        }
    }

    /* renamed from: c */
    public synchronized void mo19132c(Activity activity) {
        if (mo19141j()) {
            Logger.m3601d(f2299c, "onForegroundActivity " + activity.getClass().getName());
        }
    }

    /* renamed from: d */
    public synchronized void mo19135d(Activity activity) {
        if (mo19141j()) {
            Logger.m3601d(f2299c, "onBackgroundActivity " + activity.getClass().getName());
        }
    }

    /* renamed from: c */
    public String mo19131c(String str) {
        String str2 = null;
        Logger.m3601d(f2299c, "getSdkVersion getSdkVersion: " + str);
        JSONObject j = this.f2323D.mo19695j();
        if (j != null) {
            Logger.m3601d(f2299c, "getSdkVersion sdkVersionsJson=" + j.toString());
        }
        try {
            JSONObject jSONObject = j.getJSONObject(str);
            if (jSONObject == null) {
                Logger.m3601d(f2299c, "getSdkVersion sdkData is null");
                return str2;
            }
            Logger.m3601d(f2299c, "getSdkVersion sdkData : " + jSONObject.toString());
            str2 = jSONObject.getString("sdk_version");
            Logger.m3601d(f2299c, "getSdkVersion version : " + str2);
            Logger.m3601d(f2299c, "return sdk version: " + str2);
            return str2;
        } catch (Throwable th) {
        }
        return str2;
    }

    /* renamed from: G */
    public JSONObject mo19116G() {
        return this.f2323D.mo19695j();
    }

    public String getUserId() {
        return this.f2329y;
    }

    public static String getVersion() {
        return C1254a.f2331a;
    }

    /* renamed from: b */
    private void m2710b(boolean z) {
        boolean l = mo19143l();
        Logger.m3601d(f2299c, "notifyMonitorUserActivityUpdate shouldMonitorUser is " + l);
        CreativeInfoManager.m3081a(l);
        C1347b.setActiveMode(l);
        C1324f.m3384a(l);
        if (z) {
            m2697R();
        }
    }

    /* renamed from: H */
    public long mo19117H() {
        return f2318w.mo19590I();
    }

    /* renamed from: I */
    public int mo19118I() {
        return f2318w.mo19591J();
    }

    /* renamed from: J */
    public ArrayList<String> mo19119J() {
        return f2318w.mo19592K();
    }

    /* renamed from: K */
    public float mo19120K() {
        return f2318w.mo19610m();
    }

    /* renamed from: L */
    public float mo19121L() {
        return f2318w.mo19611n();
    }

    /* renamed from: M */
    public int mo19122M() {
        return f2318w.mo19612o();
    }

    /* renamed from: N */
    public int mo19123N() {
        return f2318w.mo19613p();
    }

    /* renamed from: O */
    public int mo19124O() {
        return f2318w.mo19614q();
    }

    /* renamed from: P */
    public static boolean m2695P() {
        return f2297J.booleanValue();
    }

    /* renamed from: Q */
    public static void m2696Q() {
        f2297J = true;
        if (!m2711b()) {
            m2701V();
        }
    }
}

package com.example.safesdk.sample.analytics.brandsafety;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1316e;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.analytics.events.MaxEvent;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1346a;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class InterstitialFinder implements AppLovinCommunicatorSubscriber, C1284a, C1346a {

    /* renamed from: a */
    public static  String f2538a = "INTER";

    /* renamed from: b */
    public static  String f2539b = "REWARDED";

    /* renamed from: f */
    private static  String f2540f = "InterstitialFinder";

    /* renamed from: g */
    private static  long f2541g = 500;

    /* renamed from: h */
    private static  long f2542h = 1000;

    /* renamed from: i */
    private static  int f2543i = 120;

    /* renamed from: j */
    private static  int f2544j = 2;

    /* renamed from: k */
    private static  int f2545k = 3;

    /* renamed from: l */
    private static  String f2546l = "ad_format";

    /* renamed from: m */
    private static  String f2547m = "type";

    /* renamed from: n */
    private static  String f2548n = "WILL_DISPLAY";

    /* renamed from: o */
    private static  String f2549o = "WILL_LOAD";

    /* renamed from: p */
    private static  String f2550p = "DID_HIDE";

    /* renamed from: q */
    private static  String f2551q = "DID_CLICKED";

    /* renamed from: r */
    private static  String f2552r = "DID_LOAD";

    /* renamed from: s */
    private static  String f2553s = "DID_DISPLAY";

    /* renamed from: t */
    private static  String f2554t = "DID_FAIL_DISPLAY";

    /* renamed from: u */
    private static  String f2555u = "network_name";

    /* renamed from: v */
    private static  String f2556v = "third_party_ad_placement_id";

    /* renamed from: w */
    private static  String f2557w = "creative_id";

    /* renamed from: A */
    private String f2558A = null;

    /* renamed from: B */
    public Activity f2559B = null;

    /* renamed from: C */
    public String f2560C = null;

    /* renamed from: D */
    public C1335h f2561D;

    /* renamed from: E */
    private int f2562E;

    /* renamed from: F */
    public int f2563F = 0;

    /* renamed from: G */
    public long f2564G = 0;

    /* renamed from: H */
    private String f2565H = null;

    /* renamed from: I */
    private long f2566I = 0;

    /* renamed from: J */
    private long f2567J = 0;

    /* renamed from: K */
    private long f2568K = 0;

    /* renamed from: L */
    private Map<String, List<C1336i>> f2569L = new HashMap();

    /* renamed from: M */
    private Map<String, AtomicReference<Bundle>> f2570M = new HashMap();

    /* renamed from: N */
    private Set<String> f2571N = new HashSet();

    /* renamed from: O */
    private BrandSafetyUtils.ScreenShotOrientation f2572O = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;

    /* renamed from: P */
    public boolean f2573P = false;

    /* renamed from: Q */
    private boolean f2574Q = false;

    /* renamed from: R */
    public boolean f2575R = false;

    /* renamed from: S */
    private boolean f2576S = false;

    /* renamed from: T */
    private C1282a f2577T = null;

    /* renamed from: U */
    private Set<String> f2578U = new HashSet(Arrays.asList(new String[]{CreativeInfo.f2980j, CreativeInfo.f2979i}));

    /* renamed from: c */
    AtomicReference<Bundle> f2579c = new AtomicReference<>();

    /* renamed from: d */
    boolean f2580d = false;

    /* renamed from: e */
    String f2581e = null;

    /* renamed from: x */
    private Timer f2582x;

    /* renamed from: y */
    private TimerTask f2583y;

    /* renamed from: z */
    private C1335h f2584z;

    /* renamed from: h */
    static  int m2973h(InterstitialFinder interstitialFinder) {
        int i = interstitialFinder.f2563F + 1;
        interstitialFinder.f2563F = i;
        return i;
    }

    /* renamed from: b */
    public synchronized void mo19248b() {
        m2956a(true);
        Logger.m3601d(f2540f, "setOnVideoCompletedEventHasBeenTriggered set to true");
        this.f2573P = true;
    }

    /* renamed from: a */
    public synchronized void mo19246a(String str, boolean z) {
        Logger.m3601d(f2540f, "setOnVideoCompletedEventHasBeenTriggered started, webViewAddress = " + str + " , videoCompleted=" + z);
        m2956a(z);
        if (!(this.f2561D == null || this.f2561D.f2614J == null || !this.f2561D.f2614J.equals(str))) {
            if (this.f2561D.f2609E != null && !this.f2561D.f2609E.mo19418j()) {
                Logger.m3601d(f2540f, "Setting creative info as video ad");
                this.f2561D.f2609E.mo19401c(true);
            }
            Logger.m3601d(f2540f, "setting video completed to value " + z);
            this.f2573P = z;
        }
    }

    /* renamed from: a */
    private void m2956a(boolean z) {
        if (!z || this.f2573P || this.f2574Q) {
            Logger.m3601d(f2540f, "avoid clearing any images taken previously: videoCompleted=" + z + " onVideoCompletedEventHasBeenTriggered=" + this.f2573P + " impressionScreenshotsRemoved=" + this.f2574Q);
            return;
        }
        Logger.m3601d(f2540f, "Video is marked as completed, clearing any images taken previously");
        SafeDK.getInstance().mo19150t().mo19466b();
        this.f2574Q = true;
    }

    /* renamed from: c */
    public void mo19249c() {
        Logger.m3601d(f2540f, "stopping taking screenshots for impression. starting.");
        if (this.f2580d) {
            this.f2575R = true;
            SafeDK.getInstance().mo19150t().mo19466b();
            Logger.m3601d(f2540f, "stopping taking screenshots for impression. attempting to clear image hash and files");
            if (this.f2561D != null && this.f2561D.mo19267c() != null) {
                Logger.m3601d(f2540f, "stopping taking screenshots for impression. will delete file " + this.f2561D.mo19267c());
                BrandSafetyUtils.m2913c(this.f2561D.mo19267c());
                this.f2561D.f2620r = null;
                this.f2561D.mo19265b((String) null);
                m2955a(this.f2561D, "stopTakingScreenshotsForImpression");
            } else if (this.f2584z == null || this.f2584z.mo19267c() == null) {
                Logger.m3601d(f2540f, "stopping taking screenshots for impression. no active ci or no image taken.");
            } else {
                Logger.m3601d(f2540f, "stopping taking screenshots for impression. will delete file " + this.f2584z.mo19267c());
                BrandSafetyUtils.m2913c(this.f2584z.mo19267c());
                this.f2584z.f2620r = null;
                this.f2584z.mo19265b((String) null);
                m2955a(this.f2584z, "stopTakingScreenshotsForImpression");
            }
        } else {
            Logger.m3601d(f2540f, "stopping taking screenshots for impression. Request to stop taking screenshots received when no max ad is active. ignoring");
        }
    }

    public InterstitialFinder() {
        Logger.m3601d(f2540f, "InterstitialFinder ctor started");
        this.f2562E = 0;
        SafeDK.getInstance().mo19150t().mo19460a(BrandSafetyUtils.AdType.INTERSTITIAL);
        C1347b.getInstance().registerBackgroundForegroundListener(this);
        AppLovinBridge.registerToReceiveMaxEvents(this);
    }

    /* renamed from: b */
    private synchronized WebView m2959b(ViewGroup viewGroup) {
        WebView webView;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                webView = null;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (!(childAt instanceof WebView)) {
                if ((childAt instanceof ViewGroup) && (webView = m2959b((ViewGroup) childAt)) != null) {
                    Logger.m3601d(f2540f, "looping through views found WebView : " + webView.toString());
                    break;
                }
                i = i2 + 1;
            } else {
                webView = (WebView) childAt;
                break;
            }
        }
        return webView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo19247a(Activity activity, String str) {
        boolean z = true;
        synchronized (this) {
            if (this.f2561D == null || activity == null) {
                z = false;
            } else if (this.f2561D.mo19273e().equals(str)) {
                Logger.m3601d(f2540f, "ad clicked and redirected to another activity");
                this.f2561D.mo19262a(true);
            }
        }
        return z;
    }

    public synchronized void onMessageReceived(AppLovinCommunicatorMessage message) {
        String str = null;
        synchronized (this) {
            if (SafeDK.getInstance().mo19141j()) {
                SafeDK.getInstance();
                SafeDK.m2696Q();
                Bundle messageData = message.getMessageData();
                String string = messageData.getString("type");
                String string2 = messageData.getString("ad_format");
                String string3 = messageData.getString("third_party_ad_placement_id");
                this.f2581e = string3;
                String string4 = messageData.getString(f2555u);
                String b = CreativeInfoManager.m3083b(string4);
                long b2 = C1361h.m3690b(System.currentTimeMillis());
                Logger.m3601d(f2540f, "packageName " + b + ", ts (seconds)=" + b2 + ", message received " + message.getMessageData());
                if (messageData.containsKey("creative_id")) {
                    str = messageData.getString("creative_id");
                }
                C1337j.m3416a().mo19501a(new MaxEvent(string, b2, string2, string4, str));
/*
                if (f2538a.equals(string2) || f2539b.equals(string2)) {
                    if (f2548n.equals(string)) {
                      */
/*  if (b != null) {
                            this.f2580d = true;
                            BrandSafetyUtils.m2923k(b);
                            this.f2579c = new AtomicReference<>(messageData);
                            mo19251d();
                            CreativeInfoManager.m3077a(b, string3, str, (String) null, string2);
                            Logger.m3601d(f2540f, "WILL_DISPLAY event for package " + b + " placement " + string3 + " ad_type " + string2);
                        }*//*

                        this.f2562E++;
                    } else if (f2551q.equals(string)) {
                        if (this.f2561D != null) {
                            StringBuilder append = new StringBuilder().append("DID_CLICKED event detected for package ");
                            if (b != null) {
                                string4 = b;
                            }
                            Logger.m3601d(f2540f, append.append(string4).toString());
                            m2975i();
                            if (!TextUtils.isEmpty(this.f2561D.mo19275g())) {
                                m2955a(this.f2561D, "onMessageReceived");
                            }
                        }
                    } else if (f2549o.equals(string)) {
                        if (b != null) {
                            Logger.m3601d(f2540f, "WILL_LOAD event detected for package " + b + " placement " + string3);
                            C1308d.m3136b(b, string3);
                        }
                    } else if (f2550p.equals(string)) {
                        if (b != null) {
                            BrandSafetyUtils.m2924l(b);
                            Logger.m3601d(f2540f, "DID_HIDE event detected for package " + b + " placement " + string3);
                            m2974h((String) null);
                        }
                    } else if (f2552r.equals(string)) {
                        if (b != null) {
                            Logger.m3601d(f2540f, "DID_LOAD event detected for package " + b + " placement " + string3);
                        }
                    } else if (f2553s.equals(string)) {
                        if (b != null) {
                            if (str != null) {
                                m2971g(str);
                            }
                            Logger.m3601d(f2540f, "DID_DISPLAY event detected for package " + b + " placement " + string3);
                        }
                    } else if (f2554t.equals(string)) {
                        Logger.m3601d(f2540f, "DID_FAIL_DISPLAY event detected for package " + b + " placement " + string3);
                    }
                }
*/
            }
        }
    }

    /* renamed from: d */
    public synchronized void mo19251d() {
        if (C1347b.getInstance().getForegroundActivity() == null) {
            Logger.m3601d(f2540f, "startAdMonitoring No foreground activity, not starting ad monitoring");
        } else if (!this.f2580d) {
            Logger.m3601d(f2540f, "startAdMonitoring MAX ad is not currently active (no WILL_DISPLAY msg received)");
        } else {
            Logger.m3601d(f2540f, "startAdMonitoring started, foreground activity is " + C1347b.getInstance().getForegroundActivity());
            if (BrandSafetyUtils.m2914c((Class) C1347b.getInstance().getForegroundActivity().getClass())) {
                Logger.m3601d(f2540f, "startAdMonitoring Starting ad monitoring");
                m2961b(C1347b.getInstance().getForegroundActivity());
            } else {
                Logger.m3601d(f2540f, "startAdMonitoring current foreground activity is not a supported ad activity");
            }
        }
    }

    /* renamed from: i */
    private void m2975i() {
        Logger.m3601d(f2540f, "handleDidClicked started");
        if (this.f2561D != null) {
            this.f2561D.mo19262a(true);
            if (this.f2561D.mo19275g() == null && this.f2577T != null && this.f2577T.f2589a != 0) {
                Logger.m3601d(f2540f, "handleDidClicked checking ClickUrlCandidate");
                if (System.currentTimeMillis() - this.f2577T.f2589a < 5000) {
                    Logger.m3601d(f2540f, "handleDidClicked setting clickUrl");
                    this.f2561D.mo19272d(this.f2577T.f2590b);
                }
            }
        }
    }

    public synchronized String getCommunicatorId() {
        return AppLovinBridge.f2360a;
    }

    /* renamed from: e */
    public synchronized C1335h mo19253e() {
        return this.f2561D;
    }

    /* renamed from: b */
    private synchronized void m2961b(Activity activity) {
        Set<String> set = null;
        C1336i f;
        Bundle bundle;
        C1336i iVar;
        CreativeInfo creativeInfo = null;
        synchronized (this) {
            Logger.m3601d(f2540f, "InterstitialFinder started");
            this.f2559B = activity;
            this.f2560C = activity.toString();
            String a = BrandSafetyUtils.m2893a(this.f2560C, true);
            String a2 = BrandSafetyUtils.m2893a(this.f2560C, false);
            String b = BrandSafetyUtils.m2909b((Class) this.f2559B.getClass());
            int i = this.f2562E;
            this.f2567J = SystemClock.elapsedRealtime();
            this.f2568K = 0;
            if (this.f2561D == null || !a.equals(this.f2561D.f2607C)) {
                if (this.f2561D == null) {
                    set = null;
                } else if (!this.f2561D.f2608D.equals(a2)) {
                    Set<String> set2 = this.f2561D.f3172K;
                    if (set2.contains(a)) {
                        Logger.m3601d(f2540f, "Ignoring restart of suspected mediation " + this.f2560C);
                    } else {
                        set2.add(this.f2561D.f2607C);
                        i = this.f2561D.f2605A;
                        set = set2;
                    }
                }
                String[] strArr = {a2, a};
                Logger.m3601d(f2540f, "start currentActivityInterstitial " + this.f2561D);
                if (this.f2561D == null) {
                    i = this.f2562E;
                    f = m2970f(b);
                } else if (!this.f2561D.f2610F) {
                    Logger.m3601d(f2540f, "current interstitial activity != null : " + this.f2561D);
                    CreativeInfo h = this.f2561D.mo19276h();
                    if (h == null || this.f2578U.contains(h.mo19385D())) {
                        iVar = null;
                    } else {
                        Logger.m3601d(f2540f, "setting current interstitial activity's creative info: " + h);
                        iVar = new C1336i(h, h.mo19385D(), h.mo19386E());
                    }
                    f = iVar;
                } else {
                    f = null;
                }
                Logger.m3601d(f2540f, "AppLovin data bundle is " + (this.f2579c != null ? this.f2579c.get() : "null"));
                if (this.f2579c != null) {
                    bundle = this.f2579c.get();
                } else {
                    bundle = null;
                }
                this.f2561D = new C1335h(strArr, b, i, bundle);
                if (f != null) {
                    m2965b(f);
                }
                this.f2566I = 0;
                StringBuilder append = new StringBuilder().append("created new currentActivityInterstitial info. activityAddress: ").append(a).append(" sdk: ").append(b).append(" creative info: ");
                if (f != null) {
                    creativeInfo = f.f3177a;
                }
                Logger.m3601d(f2540f, append.append(creativeInfo).toString());
                this.f2584z = null;
                if (set != null) {
                    this.f2561D.f3172K = set;
                }
                this.f2574Q = false;
                Logger.m3601d(f2540f, "Starting timer to sample interstitial on activity " + activity.toString());
                this.f2582x = new Timer();
                this.f2583y = new C1283b();
                this.f2582x.scheduleAtFixedRate(this.f2583y, f2541g, f2542h);
            } else if (TextUtils.isEmpty(this.f2561D.mo19264b()) || !m2958a(this.f2561D.f2628z, this.f2561D.mo19270d())) {
                Logger.m3601d(f2540f, "Starting counter from previous value " + this.f2561D.mo19282n());
                this.f2561D.mo19499s();
                this.f2563F = this.f2561D.mo19282n();
                int i2 = this.f2561D.f2605A;
                Logger.m3601d(f2540f, "Starting timer to sample interstitial on activity " + activity.toString());
                this.f2582x = new Timer();
                this.f2583y = new C1283b();
                this.f2582x.scheduleAtFixedRate(this.f2583y, f2541g, f2542h);
            } else {
                Logger.m3601d(f2540f, "Not starting timer on activity " + activity.toString() + " -- impression already logged");
            }
        }
    }

    /* renamed from: f */
    private C1336i m2970f(String str) {
        boolean b = CreativeInfoManager.m3091b(str, false);
        List<C1336i> list = this.f2569L.get(str);
        if (list != null) {
            for (C1336i iVar : list) {
                Logger.m3601d(f2540f, "checkIfPendingCIExists shouldMatchPendingCiUsingPlacementId=" + b + ", maxPlacementId=" + this.f2581e + ", ciPlacementId=" + (iVar.f3177a != null ? iVar.f3177a.mo19429p() : null));
                if (iVar != null && (iVar.f3178b == null || !this.f2578U.contains(iVar.f3178b))) {
                    list.remove(iVar);
                    Logger.m3601d(f2540f, "creative info is the pending creative info: " + iVar.toString());
                    return iVar;
                }
            }
        }
        return null;
    }

    /* renamed from: g */
    private void m2971g(String str) {
        Logger.m3601d(f2540f, "updateMaxCreativeId started, maxCreativeId is " + str);
        if (this.f2561D == null || this.f2561D.f2609E == null) {
            Logger.m3601d(f2540f, "updateMaxCreativeId currentActivityInterstitial or CI is null");
        } else if (this.f2561D.f2609E.mo19390I() == null) {
            Logger.m3601d(f2540f, "updateMaxCreativeId setting Max creativeId in CI to : " + str);
            this.f2561D.f2609E.mo19445w(str);
        } else {
            Logger.m3601d(f2540f, "updateMaxCreativeId Max creativeId already exists");
        }
    }

    /* renamed from: a */
    public synchronized void mo19212a() {
        try {
            if (this.f2582x != null) {
                Logger.m3601d(f2540f, "Canceling timer for interstitials");
                this.f2582x.cancel();
                this.f2583y.cancel();
            }
        } catch (Throwable th) {
            Logger.m3604e(f2540f, "Failed to stopTimers interstitial finder", th);
            new CrashReporter().caughtException(th);
        }
        if (this.f2561D != null && this.f2561D.mo19282n() == 0) {
            this.f2561D.f2626x = this.f2563F;
        }
        this.f2563F = 0;
        this.f2564G = 0;
        Logger.m3601d(f2540f, "Stop holding reference to activity " + this.f2559B);
        this.f2559B = null;
        this.f2558A = null;
        return;
    }

    /* renamed from: a */
    public synchronized CreativeInfo mo19210a(String str) {
        CreativeInfo creativeInfo;
        if (this.f2561D == null || this.f2561D.f2614J == null || !this.f2561D.f2614J.equals(str)) {
            creativeInfo = null;
        } else {
            creativeInfo = this.f2561D.f2609E;
        }
        return creativeInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r0.mo19444w().equals(r5) != false) goto L_0x0017;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo mo19211a(String r4, String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.example.safesdk.sample.analytics.brandsafety.h r0 = r3.f2561D     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0019
            com.example.safesdk.sample.analytics.brandsafety.h r0 = r3.f2561D     // Catch:{ all -> 0x0048 }
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r0 = r0.mo19276h()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0046
            java.lang.String r1 = r0.mo19444w()     // Catch:{ all -> 0x0048 }
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0046
        L_0x0017:
            monitor-exit(r3)
            return r0
        L_0x0019:
            java.util.Map<java.lang.String, java.util.List<com.example.safesdk.sample.analytics.brandsafety.i>> r0 = r3.f2569L     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0048 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0046
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x0048 }
        L_0x0027:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x0048 }
            com.example.safesdk.sample.analytics.brandsafety.i r0 = (com.example.safesdk.sample.analytics.brandsafety.C1336i) r0     // Catch:{ all -> 0x0048 }
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r2 = r0.f3177a     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0027
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r2 = r0.f3177a     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r2.mo19444w()     // Catch:{ all -> 0x0048 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0027
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r0 = r0.f3177a     // Catch:{ all -> 0x0048 }
            goto L_0x0017
        L_0x0046:
            r0 = 0
            goto L_0x0017
        L_0x0048:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.mo19211a(java.lang.String, java.lang.String):com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo");
    }

    /* renamed from: a */
    public synchronized void mo19245a(Activity activity) {
        try {
            Logger.m3601d(f2540f, "stop started");
            if (activity.toString().equals(this.f2560C)) {
                Logger.m3601d(f2540f, "Stopping interstitial finder for activity " + this.f2560C);
                mo19212a();
                this.f2568K = SystemClock.elapsedRealtime();
                this.f2566I += this.f2568K - this.f2567J;
                Logger.m3601d(f2540f, "Viewing time (ms) = " + this.f2566I);
            }
            this.f2571N.clear();
            this.f2572O = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
            Logger.m3601d(f2540f, "reset interstitial orientation");
        } catch (Throwable th) {
            Logger.m3604e(f2540f, th.getMessage(), th);
            new CrashReporter().caughtException(th);
        }
        return;
    }

    /* renamed from: c */
    public synchronized void mo19250c(String str) {
        Logger.m3601d(f2540f, "onActivityDestroyed start, calling onAdHidden");
        m2974h(str);
    }

    /* renamed from: h */
    private synchronized void m2974h(String str) {
        String str2;
        StringBuilder append = new StringBuilder().append("onAdHidden started, activityClass=");
        if (str == null) {
            str2 = "null";
        } else {
            str2 = str;
        }
        Logger.m3601d(f2540f, append.append(str2).append(", interstitialActivityName=").append(this.f2560C).toString());
        m2964b(str, true);
    }

    /* renamed from: b */
    private synchronized void m2964b(String str, boolean z) {
        Logger.m3601d(f2540f, "cleanAndReport started, activityClass=" + (str == null ? "null" : str) + ", interstitialActivityName=" + this.f2560C);
        C1319d t = SafeDK.getInstance().mo19150t();
        this.f2580d = false;
        this.f2581e = null;
        this.f2577T = null;
        if (this.f2561D == null || this.f2561D.mo19267c() == null) {
            try {
                if (!(this.f2584z == null || this.f2584z.mo19267c() == null)) {
                    t.mo19467b(this.f2584z.f2621s);
                }
            } catch (Throwable th) {
                this.f2560C = null;
                throw th;
            }
        } else {
            t.mo19467b(this.f2561D.mo19267c());
        }
        Logger.m3601d(f2540f, "cleanAndReport imageHandler.lastActivityImpressionScreenshotFilename set to " + t.mo19470d());
        this.f2573P = false;
        if (str == null) {
            str = this.f2560C;
            Logger.m3601d(f2540f, "cleanAndReport activityClass set to " + this.f2560C);
        }
        if (!(this.f2561D == null || this.f2561D.f2614J == null)) {
            C1308d.m3126a(this.f2561D.f2614J);
        }
        if (this.f2561D == null || this.f2561D.f2607C == null || !this.f2561D.f2607C.equals(BrandSafetyUtils.m2893a(str, true))) {
            Logger.m3601d(f2540f, "cleanAndReport DID NOT enter unload logic, currentActivityInterstitial=" + this.f2561D);
        } else {
            mo19212a();
            Logger.m3601d(f2540f, "cleanAndReport tmpInterstitialToReport = " + this.f2584z);
            if (this.f2584z != null) {
                int b = t.mo19465b(BrandSafetyUtils.AdType.INTERSTITIAL);
                if (z && b < SafeDK.getInstance().mo19111B()) {
                    Logger.m3601d(f2540f, "cleanAndReport waiting to report file: " + this.f2584z.f2621s + ", impressionId: " + this.f2584z.f2619q);
                    t.mo19461a((C1285b) this.f2584z);
                } else if (!t.mo19464a(this.f2584z.f2620r, this.f2584z.f2619q)) {
                    BrandSafetyUtils.m2913c(this.f2584z.f2621s);
                    this.f2584z.f2620r = null;
                    this.f2584z.mo19265b((String) null);
                }
                Logger.m3601d(f2540f, "cleanAndReport currentActivityInterstitial.hashValue: " + this.f2561D.f2620r + " currOrientation: " + this.f2561D.f2627y);
                if (this.f2561D.f2620r == null && !this.f2575R) {
                    Logger.m3601d(f2540f, "cleanAndReport assigning last captured hash to interstitial: " + this.f2584z.f2620r);
                    this.f2561D.f2620r = this.f2584z.f2620r;
                    this.f2561D.f2627y = this.f2584z.f2627y;
                }
                this.f2584z = null;
            }
            if (this.f2568K == 0) {
                this.f2568K = SystemClock.elapsedRealtime();
                this.f2566I += this.f2568K - this.f2567J;
                Logger.m3601d(f2540f, "Viewing time (ms) = " + this.f2566I);
            }
            if (this.f2561D != null) {
                this.f2561D.f3175N = this.f2566I;
                C1308d.m3123a(this.f2561D.mo19276h());
                if (z) {
                    m2955a(this.f2561D, "onAdHidden");
                } else if (StatsCollector.m2806b() != null) {
                    StatsCollector.m2806b().mo19191a(this.f2561D.mo19283o());
                } else {
                    Logger.m3609w(f2540f, "Stats collector instance is null, cannot remove brand safety event");
                }
                this.f2569L.remove(this.f2561D.mo19273e());
            }
            this.f2561D = null;
            this.f2566I = 0;
        }
        this.f2575R = false;
        Logger.m3601d(f2540f, "clearing AppLovin bundle");
        this.f2579c = null;
        this.f2560C = null;
        return;
    }

    /* renamed from: a */
    public synchronized void m2955a(C1335h hVar, String str) {
        C1361h.m3694b(f2540f, "reportInterstitialEvent started, root= " + str + ", info=" + hVar);
        if (!hVar.f3174M) {
            Logger.m3601d(f2540f, "info is not interstitial, don't report info");
        } else {
            boolean z = !hVar.f2610F;
            boolean z2 = !hVar.f2611G && hVar.mo19274f();
            float f = (((float) hVar.f2628z) / 1000.0f) * 100.0f;
            Logger.m3601d(f2540f, "imageUniformity=" + f);
            String str2 = null;
            if (hVar.mo19264b() != null && !this.f2575R) {
                str2 = hVar.mo19264b() + "_" + hVar.mo19283o();
            }
            if (!(this.f2565H == null || hVar == null || hVar.mo19276h() == null)) {
                Logger.m3601d(f2540f, "setting ci last DID_FAIL msg timestamp : " + this.f2565H);
                hVar.mo19276h().mo19428o("lastDidFailDisplayDateTime=" + this.f2565H);
                this.f2565H = null;
            }
            BrandSafetyEvent brandSafetyEvent = new BrandSafetyEvent(hVar.mo19273e(), hVar.f2605A, str2, z2, hVar.mo19274f() ? hVar.mo19275g() : null, hVar.mo19276h(), hVar.mo19258a(), hVar.f2608D, hVar.mo19283o(), hVar.f3175N, hVar.f3175N > 0, hVar.f2606B, hVar.f2627y, hVar.f3176O, hVar.f2622t, f, hVar.f2626x, SafeDK.getInstance().mo19133c());
            if (StatsCollector.m2806b() != null) {
                StatsCollector.m2806b().mo19193b((StatsEvent) brandSafetyEvent);
                m2963b(hVar, str2);
                if (z) {
                    hVar.mo19266b(true);
                }
                if (z2) {
                    hVar.mo19269c(true);
                }
            } else {
                Logger.m3609w(f2540f, "Stats collector instance is null, cannot report brand safety event");
            }
        }
    }

    /* renamed from: b */
    private void m2963b(C1335h hVar, String str) {
        if (hVar.mo19276h() != null && str != null) {
            String a = BrandSafetyUtils.m2890a(BrandSafetyUtils.AdType.INTERSTITIAL, hVar.mo19264b(), hVar.mo19273e(), hVar.mo19283o(), hVar.f2627y);
            if (!new File(a).exists()) {
                Logger.m3601d(f2540f, "Screenshot file filePath doesn't exist");
            } else if (!hVar.mo19276h().mo19386E().contains("screenshot_datetime")) {
                String w = C1361h.m3725w(a);
                hVar.mo19276h().mo19428o("screenshot_datetime" + ":" + w);
                Logger.m3601d(f2540f, "Adding to ci debug info : " + w);
            } else {
                Logger.m3601d(f2540f, "Stats repo is null or already contains this event");
            }
        }
    }

    /* renamed from: h */
    public synchronized void mo19255h() {
        mo19252d((String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized void mo19252d( String str) {
        if (this.f2559B != null) {
             String b = BrandSafetyUtils.m2909b((Class) this.f2559B.getClass());
            this.f2559B.runOnUiThread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        r0 = 1
                        r1 = 0
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r3 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ Throwable -> 0x00f7 }
                        monitor-enter(r3)     // Catch:{ Throwable -> 0x00f7 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r2 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        android.app.Activity r2 = r2.f2559B     // Catch:{ all -> 0x00f4 }
                        if (r2 == 0) goto L_0x00f1
                        java.lang.String r2 = "InterstitialFinder"
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
                        r4.<init>()     // Catch:{ all -> 0x00f4 }
                        java.lang.String r5 = "Run on UI thread in "
                        java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r5 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        java.lang.String r5 = r5.f2560C     // Catch:{ all -> 0x00f4 }
                        java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00f4 }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.utils.Logger.m3601d(r2, r4)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r2 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        android.app.Activity r2 = r2.f2559B     // Catch:{ all -> 0x00f4 }
                        android.view.Window r2 = r2.getWindow()     // Catch:{ all -> 0x00f4 }
                        android.view.View r2 = r2.getDecorView()     // Catch:{ all -> 0x00f4 }
                        r4 = 16908290(0x1020002, float:2.3877235E-38)
                        android.view.View r4 = r2.findViewById(r4)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r2 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.h r2 = r2.f2561D     // Catch:{ all -> 0x00f4 }
                        if (r2 != 0) goto L_0x0052
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "takeScreenshot currentActivityInterstitial cannot be null, exiting function"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        monitor-exit(r3)     // Catch:{ all -> 0x00f4 }
                    L_0x0051:
                        return
                    L_0x0052:
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r2 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.h r2 = r2.f2561D     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r5 = r2.mo19276h()     // Catch:{ all -> 0x00f4 }
                        java.lang.String r2 = "com.google.ads"
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r6 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.h r6 = r6.f2561D     // Catch:{ all -> 0x00f4 }
                        java.lang.String r6 = r6.mo19273e()     // Catch:{ all -> 0x00f4 }
                        boolean r6 = r2.equals(r6)     // Catch:{ all -> 0x00f4 }
                        java.lang.String r2 = "com.supersonicads"
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r7 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.h r7 = r7.f2561D     // Catch:{ all -> 0x00f4 }
                        java.lang.String r7 = r7.mo19273e()     // Catch:{ all -> 0x00f4 }
                        boolean r7 = r2.equals(r7)     // Catch:{ all -> 0x00f4 }
                        if (r5 == 0) goto L_0x0109
                        java.lang.String r2 = "vast/multiple_ads"
                        java.lang.String r8 = r5.mo19404d()     // Catch:{ all -> 0x00f4 }
                        boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x00f4 }
                        if (r2 == 0) goto L_0x0109
                        r2 = r0
                    L_0x008c:
                        if (r5 == 0) goto L_0x010b
                        java.lang.String r8 = "vungle_mraid"
                        java.lang.String r9 = r5.mo19404d()     // Catch:{ all -> 0x00f4 }
                        boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x00f4 }
                        if (r8 == 0) goto L_0x010b
                    L_0x009b:
                        if (r0 == 0) goto L_0x00a4
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "This ad is a VUNGLE_MRAID_AD"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                    L_0x00a4:
                        if (r5 == 0) goto L_0x00da
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
                        r1.<init>()     // Catch:{ all -> 0x00f4 }
                        java.lang.String r8 = "ci isVideoAd="
                        java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00f4 }
                        boolean r8 = r5.mo19418j()     // Catch:{ all -> 0x00f4 }
                        java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00f4 }
                        java.lang.String r8 = ", isVastVideoAd="
                        java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00f4 }
                        boolean r8 = r5.mo19424m()     // Catch:{ all -> 0x00f4 }
                        java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00f4 }
                        java.lang.String r8 = ", isInmobiMultiAd="
                        java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00f4 }
                        java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00f4 }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                    L_0x00da:
                        com.example.safesdk.sample.SafeDK r0 = com.example.safesdk.sample.SafeDK.getInstance()     // Catch:{ all -> 0x00f4 }
                        boolean r0 = r0.mo19110A()     // Catch:{ all -> 0x00f4 }
                        if (r0 != 0) goto L_0x0156
                        if (r6 != 0) goto L_0x0156
                        if (r7 != 0) goto L_0x0156
                        if (r5 != 0) goto L_0x010d
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "no creative info yet"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                    L_0x00f1:
                        monitor-exit(r3)     // Catch:{ all -> 0x00f4 }
                        goto L_0x0051
                    L_0x00f4:
                        r0 = move-exception
                        monitor-exit(r3)     // Catch:{ all -> 0x00f4 }
                        throw r0     // Catch:{ Throwable -> 0x00f7 }
                    L_0x00f7:
                        r0 = move-exception
                        java.lang.String r1 = "InterstitialFinder"
                        java.lang.String r2 = "Failed while taking screenshot"
                        com.example.safesdk.sample.utils.Logger.m3604e(r1, r2, r0)
                        com.example.safesdk.sample.analytics.reporters.CrashReporter r1 = new com.example.safesdk.sample.analytics.reporters.CrashReporter
                        r1.<init>()
                        r1.caughtException(r0)
                        goto L_0x0051
                    L_0x0109:
                        r2 = r1
                        goto L_0x008c
                    L_0x010b:
                        r0 = r1
                        goto L_0x009b
                    L_0x010d:
                        boolean r0 = r5.mo19420k()     // Catch:{ all -> 0x00f4 }
                        if (r0 != 0) goto L_0x0115
                        if (r2 == 0) goto L_0x011d
                    L_0x0115:
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "ad is playable or multi ad"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        goto L_0x00f1
                    L_0x011d:
                        boolean r0 = r5.mo19418j()     // Catch:{ all -> 0x00f4 }
                        if (r0 != 0) goto L_0x0134
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "ad is not a video/playable ad"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r0 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        java.lang.String r1 = r0     // Catch:{ all -> 0x00f4 }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x00f4 }
                        r0.m2952a((android.view.View) r4, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00f4 }
                        goto L_0x00f1
                    L_0x0134:
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r0 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        boolean r0 = r0.f2573P     // Catch:{ all -> 0x00f4 }
                        if (r0 == 0) goto L_0x014e
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "video ad finished playing"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r0 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        java.lang.String r1 = r0     // Catch:{ all -> 0x00f4 }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x00f4 }
                        r0.m2952a((android.view.View) r4, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00f4 }
                        goto L_0x00f1
                    L_0x014e:
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "Video hasn't finished playing yet, waiting for onVideoCompleted event"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        goto L_0x00f1
                    L_0x0156:
                        java.lang.String r0 = "InterstitialFinder"
                        java.lang.String r1 = "SafeDK Config item 'AlwaysTakeScreenshot' is true or Admob SDK. taking screenshot"
                        com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ all -> 0x00f4 }
                        com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder r0 = com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.this     // Catch:{ all -> 0x00f4 }
                        java.lang.String r1 = r0     // Catch:{ all -> 0x00f4 }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x00f4 }
                        r0.m2952a((android.view.View) r4, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00f4 }
                        goto L_0x00f1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder.C12811.run():void");
                }
            });
        }
    }

    /* renamed from: a */
    public synchronized boolean mo19215a(C1336i iVar) {
        boolean z;
        Logger.m3601d(f2540f, iVar.toString());
        CreativeInfo creativeInfo = iVar.f3177a;
        if (creativeInfo != null) {
            creativeInfo.mo19409e(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.m2912c()));
            String B = creativeInfo.mo19383B();
            if (this.f2561D == null || !this.f2561D.mo19273e().equals(B)) {
                Logger.m3601d(f2540f, "Adding as pending");
                List list = this.f2569L.get(B);
                if (list == null) {
                    list = new ArrayList();
                    this.f2569L.put(B, list);
                }
                list.add(iVar);
                z = true;
            } else {
                if (this.f2561D.mo19276h() != null) {
                    Logger.m3601d(f2540f, "Replacing  " + this.f2561D.mo19276h());
                }
                z = m2965b(iVar);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private synchronized boolean m2965b(C1336i iVar) {
        boolean z = false;
        synchronized (this) {
            C1361h.m3694b(f2540f, "setCreativeInfo started, matchingInfo=" + (iVar == null ? "null" : iVar.toString()));
            if (iVar != null) {
                Logger.m3601d(f2540f, iVar.toString());
                CreativeInfo creativeInfo = iVar.f3177a;
                if (creativeInfo != null) {
                    if (this.f2561D.mo19276h() != null) {
                        CreativeInfoManager.m3066a(this.f2561D.mo19276h());
                        Logger.m3601d(f2540f, "already matched! matching attempt CI: " + creativeInfo + ", instead of " + this.f2561D.mo19276h());
                    }
                    creativeInfo.mo19392a(iVar.f3178b, iVar.f3179c);
                    CreativeInfo creativeInfo2 = this.f2561D.f2609E;
                    this.f2561D.mo19260a(creativeInfo);
                    if (this.f2561D.f2613I != AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP || this.f2561D.f2614J == null) {
                        C1308d.m3124a(creativeInfo, (String) null);
                    } else {
                        C1308d.m3129a(this.f2561D.f2614J, creativeInfo);
                    }
                    if (creativeInfo2 != null && creativeInfo2.mo19444w().equals(creativeInfo.mo19444w())) {
                        Iterator<String> it = creativeInfo2.mo19414h().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!creativeInfo.mo19414h().contains(next)) {
                                Logger.m3601d(f2540f, "Added Resource url " + next + " to CI");
                                creativeInfo.mo19414h().add(next);
                            }
                        }
                        Iterator<String> it2 = creativeInfo2.mo19412g().iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!creativeInfo.mo19412g().contains(next2)) {
                                Logger.m3601d(f2540f, "Added Dsp url " + next2 + " to CI");
                                creativeInfo.mo19412g().add(next2);
                            }
                        }
                    }
                    if (iVar.f3178b.startsWith(CreativeInfo.f2978h)) {
                        this.f2561D.mo19285q();
                    }
                    m2955a(this.f2561D, "setCreativeInfo");
                    if (creativeInfo.mo19418j()) {
                        this.f2573P = false;
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public synchronized void mo19217b(String str, String str2) {
        Logger.m3601d(f2540f, "set ad click URL started, sdkPackageName=" + str2 + ", url=" + str);
        if (!(this.f2561D == null || this.f2561D.mo19273e() == null || !SdksMapping.isSameSdkByPackages(this.f2561D.mo19273e(), str2))) {
            Logger.m3601d(f2540f, "set ad click URL applying clickUrl candidate logic. url=" + str);
            if (!this.f2561D.mo19274f()) {
                Logger.m3601d(f2540f, "set ad click URL current Activity Interstitial is not marked as clicked, setting clickUrl : " + str);
                mo19254e(str);
            } else if (this.f2561D.mo19275g() == null) {
                Logger.m3601d(f2540f, "set ad click URL no clickUrl yet, setting clickUrl : " + str);
                this.f2561D.mo19272d(str);
            } else {
                Logger.m3601d(f2540f, "set ad click URL clickUrl already set : " + this.f2561D.mo19275g());
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo19216b(String str) {
        if (this.f2561D != null && this.f2561D.mo19274f()) {
            Logger.m3601d(f2540f, "detected URL for click in previous activity (not yet destroyed)");
            if (this.f2561D.mo19272d(str)) {
                m2955a(this.f2561D, "setPreviousActivityClickUrl");
            }
        }
    }

    /* renamed from: a */
    public synchronized void m2952a(View view, String str, String str2) {
        try {
            if (this.f2561D != null) {
                Logger.m3601d(f2540f, "InterstitialFinder: Taking screenshot");
                if (str.contains("com.appsaholic") && this.f2561D.mo19273e().equals(str)) {
                    Logger.m3601d(f2540f, "Appsaholic interstitial: check for inner SDK.");
                    String a = mo19244a((ViewGroup) view);
                    if (a != null && !a.isEmpty()) {
                        Logger.m3601d(f2540f, "Identified inner SDK: " + a);
                        this.f2561D.mo19268c(a);
                    }
                }
                String e = this.f2561D.mo19273e();
                Bitmap a2 = new C1316e().mo19348a(view, SafeDK.getInstance().mo19154x());
                if (a2 != null) {
                    BrandSafetyUtils.C1277a a3 = BrandSafetyUtils.m2885a(e, a2);
                    int a4 = a3.mo19228a();
                    if (BrandSafetyUtils.m2902a(e, a3)) {
                        String a5 = BrandSafetyUtils.m2887a(a2);
                        this.f2572O = BrandSafetyUtils.m2907b(a2);
                        Logger.m3601d(f2540f, "Found Interstitial!!");
                        if (this.f2561D == null || this.f2561D.mo19283o() == null) {
                            Logger.m3601d(f2540f, "impressionId is null");
                        } else {
                            Logger.m3601d(f2540f, "impressionId is " + this.f2561D.mo19283o());
                        }
                        String o = (this.f2561D == null || this.f2561D.mo19283o() == null) ? "" : this.f2561D.mo19283o();
                        String a6 = BrandSafetyUtils.m2888a(a2, BrandSafetyUtils.AdType.INTERSTITIAL, a5, e, o, this.f2572O);
                        Logger.m3601d(f2540f, "Screenshot file created, filename = " + a6);
                        long b = BrandSafetyUtils.m2906b(a6);
                        if (b < ((long) SafeDK.getInstance().mo19125a(e))) {
                            Logger.m3601d(f2540f, "File size too small " + b + " (bytes). This image will not be used");
                            BrandSafetyUtils.m2913c(a6);
                        } else {
                            Logger.m3601d(f2540f, "Stored file size is " + b + " bytes, counter is " + this.f2563F + ", uniform pixel count is " + a4 + " (" + ((((float) a4) / 1000.0f) * 100.0f) + "%)");
                            C1319d t = SafeDK.getInstance().mo19150t();
                            int b2 = t.mo19465b(BrandSafetyUtils.AdType.INTERSTITIAL);
                            if (!t.mo19468b(a5, o)) {
                                boolean z = false;
                                if (b2 < SafeDK.getInstance().mo19111B()) {
                                    Logger.m3601d(f2540f, "impressionsToReport.size()=" + b2 + ", maxImagesToStore=" + SafeDK.getInstance().mo19111B());
                                    if (this.f2584z == null) {
                                        z = true;
                                    } else if (!this.f2584z.f2620r.equals(a5)) {
                                        BrandSafetyUtils.m2913c(this.f2584z.f2621s);
                                        z = true;
                                    }
                                    if (z) {
                                        Logger.m3601d(f2540f, "keeping file of interstitial " + a5 + ". file size is " + b + " (bytes), orientation: " + this.f2572O);
                                        this.f2584z = new C1335h(a5, e, o, this.f2572O, a6, b, a4, this.f2563F, this.f2561D.mo19284p());
                                        BrandSafetyUtils.m2897a(this.f2561D.mo19284p(), BrandSafetyUtils.AdType.INTERSTITIAL, a5, e, o, this.f2572O);
                                    }
                                } else if (!t.mo19464a(a5, o)) {
                                    Logger.m3601d(f2540f, "No open slot for interstitial " + a5 + "; next hashes to be reported to server are " + t.mo19469c());
                                    BrandSafetyUtils.m2913c(a6);
                                } else {
                                    Logger.m3601d(f2540f, "image " + a5 + "_" + o + " is already scheduled for upload");
                                }
                            } else {
                                Logger.m3601d(f2540f, "Not saving file for interstitial " + a5 + "_" + o);
                                BrandSafetyUtils.m2913c(a6);
                                if (t.mo19468b(a5, o)) {
                                    Logger.m3601d(f2540f, "Interstitial " + a5 + "_" + o + " was already reported");
                                } else {
                                    Logger.m3601d(f2540f, "Waiting to report stored interstitial " + this.f2584z.mo19264b());
                                }
                                if (this.f2584z != null) {
                                    if (t.mo19464a(this.f2584z.mo19264b(), this.f2584z.mo19283o())) {
                                        BrandSafetyUtils.m2913c(this.f2584z.f2621s);
                                        this.f2584z = null;
                                    } else {
                                        Logger.m3601d(f2540f, "not deleting not best image " + this.f2584z.f2621s);
                                    }
                                }
                            }
                            Logger.m3601d(f2540f, "Setting interstitial info data (previousInterstitialHash=" + this.f2558A + ", current hash = " + a5 + ")");
                            boolean z2 = (a5 == null || this.f2558A == null || a5.equals(this.f2558A)) ? false : true;
                            if (this.f2561D != null) {
                                if (this.f2572O.equals(BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED)) {
                                    this.f2572O = BrandSafetyUtils.m2907b(a2);
                                }
                                this.f2561D.mo19497a(a5, (String) null, b, a4, this.f2563F, this.f2572O, z2);
                            }
                            if (this.f2558A == null) {
                                Logger.m3601d(f2540f, "No previous hash to detect animation, keep sampling");
                                this.f2558A = a5;
                            } else if (m2958a(a4, b)) {
                                this.f2561D.mo19498e(z2);
                                Logger.m3601d(f2540f, "Setting interstitial is_animated field to " + z2);
                                if (!TextUtils.isEmpty(a5)) {
                                    if (this.f2572O.equals(BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED)) {
                                        this.f2561D.f2627y = BrandSafetyUtils.m2907b(a2);
                                    }
                                    m2955a(this.f2561D, "takeScreenshot");
                                    this.f2561D.mo19271d(true);
                                }
                                mo19212a();
                            } else {
                                this.f2558A = a5;
                            }
                        }
                    } else {
                        Logger.m3601d(f2540f, "Screenshot is not valid (uniform pixel count too high: " + a4 + "), try again...");
                    }
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f2540f, "InterstitialFinder: Error while taking screenshot", th);
            Logger.printStackTrace();
            new CrashReporter().caughtException(th);
        }
        return;
    }

    /* renamed from: a */
    private synchronized String m2951a(View view) {
        return BrandSafetyUtils.m2909b((Class) view.getClass());
    }

    
    /* renamed from: a */
    public synchronized String mo19244a(ViewGroup viewGroup) {
        String str;
        if (viewGroup != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewGroup.getChildCount()) {
                    str = null;
                    break;
                }
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof WebView) {
                    int width = childAt.getWidth();
                    int height = childAt.getHeight();
                    Logger.m3601d(f2540f, "View = " + childAt + ": width = " + width + " height = " + height);
                    if (childAt.getVisibility() == 0 && m2957a(width, height)) {
                        str = m2951a(childAt);
                        Logger.m3601d(f2540f, "Found full screen webview of SDK = " + str);
                        break;
                    }
                } else if (childAt instanceof ViewGroup) {
                    str = mo19244a((ViewGroup) childAt);
                    break;
                }
                i = i2 + 1;
            }
        } else {
            str = null;
        }
        return str;
    }

    /* renamed from: b */
    private void m2962b(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                CharSequence text = ((TextView) view).getText();
                Logger.m3601d(f2540f, "extract text for exact ad match=" + text);
                this.f2571N.add(text.toString());
            }
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < ((ViewGroup) view).getChildCount()) {
                        m2962b(((ViewGroup) view).getChildAt(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2957a(int i, int i2) {
        return i == BrandSafetyUtils.m2884a() && i2 == BrandSafetyUtils.m2905b();
    }

    /* renamed from: a */
    private synchronized boolean m2958a(int i, long j) {
        boolean z;
        Logger.m3601d(f2540f, "shouldStopSampling started, maxUniformedPixelsCount=" + i + ", fileSize=" + j + " (bytes), stopSamplingFileSize=" + SafeDK.getInstance().mo19112C());
        z = BrandSafetyUtils.m2899a(i) && j > SafeDK.getInstance().mo19112C();
        Logger.m3601d(f2540f, "shouldStopSampling returned " + z);
        return z;
    }

    /* renamed from: f */
    public synchronized void mo19198f() {
        if (this.f2561D != null && this.f2561D.f3174M) {
            m2955a(this.f2561D, "onBackground");
        }
    }

    /* renamed from: g */
    public synchronized void mo19199g() {
    }

    /* renamed from: j */
    public synchronized void m2977j() {
        WebView b;
        Logger.m3601d(f2540f, "scanForWebViews started");
        if (this.f2559B != null) {
            View findViewById = this.f2559B.getWindow().getDecorView().findViewById(16908290);
            try {
                if (this.f2561D != null && this.f2561D.f2613I == AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP && this.f2561D.f2614J == null && (b = m2959b((ViewGroup) findViewById)) != null) {
                    Logger.m3601d(f2540f, "found webview : " + b);
                    String a = BrandSafetyUtils.m2889a((View) b);
                    this.f2561D.f2614J = a;
                    CreativeInfo h = this.f2561D.mo19276h();
                    if (h != null) {
                        C1308d.m3129a(a, h);
                    }
                }
            } catch (Throwable th) {
                Logger.m3604e(f2540f, "Exception in searchForWebView execution", th);
            }
        }
        return;
    }

    /* renamed from: e */
    public void mo19254e(String str) {
        this.f2577T = new C1282a(System.currentTimeMillis(), str);
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder$b */
    private class C1283b extends TimerTask {
        private C1283b() {
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (InterstitialFinder.this.f2563F == 2 && InterstitialFinder.this.f2561D != null && !InterstitialFinder.this.f2561D.f2610F) {
                InterstitialFinder.this.m2955a(InterstitialFinder.this.f2561D, "timer task run");
            }
            if (InterstitialFinder.this.f2564G == 0 || ((double) (currentTimeMillis - InterstitialFinder.this.f2564G)) >= 900.0d) {
                long unused = InterstitialFinder.this.f2564G = currentTimeMillis;
                if (!InterstitialFinder.this.f2575R) {
                    InterstitialFinder.this.mo19255h();
                } else {
                    Logger.m3601d(InterstitialFinder.f2540f, "Request To Stop Taking Screenshots Has Been Received, skipping.");
                }
                if (InterstitialFinder.m2973h(InterstitialFinder.this) == 120) {
                    Logger.m3601d(InterstitialFinder.f2540f, "Max number of screenshots threshold reached, no need to start timers");
                    InterstitialFinder.this.mo19212a();
                }
                InterstitialFinder.this.m2977j();
            }
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder$a */
    private class C1282a {

        /* renamed from: d */
        private String f2588d = "ClickUrlCandidate";

        /* renamed from: a */
        public long f2589a = 0;

        /* renamed from: b */
        public String f2590b;

        public C1282a(long j, String str) {
            Logger.m3601d(f2588d, "ClickUrlCandidate ctor currentTime=" + j + ", clickUrl=" + str);
            this.f2589a = j;
            this.f2590b = str;
        }
    }
}

package com.example.safesdk.sample.analytics.brandsafety;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.mediation.ads.MaxAdView;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1316e;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;
import com.example.safesdk.sample.internal.C1346a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;

public class BannerFinder implements AppLovinCommunicatorSubscriber, C1284a, C1346a {

    /* renamed from: A */
    private static WeakReference<MaxAdView> f2438A = null;

    /* renamed from: a */
    public static  String f2439a = "BANNER";

    /* renamed from: b */
    public static  String f2440b = "LEADER";

    /* renamed from: d */
    private static  String f2441d = "BannerFinder";

    /* renamed from: e */
    private static  long f2442e = 500;

    /* renamed from: f */
    private static  long f2443f = 1000;

    /* renamed from: g */
    private static  int f2444g = 5;

    /* renamed from: h */
    private static  String f2445h = "ad_format";

    /* renamed from: i */
    private static  String f2446i = "type";

    /* renamed from: j */
    private static  String f2447j = "WILL_DISPLAY";

    /* renamed from: k */
    private static  String f2448k = "WILL_LOAD";

    /* renamed from: l */
    private static  String f2449l = "DID_HIDE";

    /* renamed from: m */
    private static  String f2450m = "DID_CLICKED";

    /* renamed from: n */
    private static  String f2451n = "DID_LOAD";

    /* renamed from: o */
    private static  String f2452o = "DID_DISPLAY";

    /* renamed from: p */
    private static  String f2453p = "DID_FAIL_DISPLAY";

    /* renamed from: q */
    private static  String f2454q = "network_name";

    /* renamed from: r */
    private static  String f2455r = "third_party_ad_placement_id";

    /* renamed from: s */
    private static  String f2456s = "creative_id";

    /* renamed from: t */
    private static  String f2457t = "id";

    /* renamed from: c */
    AtomicReference<Bundle> f2458c = null;

    /* renamed from: u */
    private  Timer f2459u = new Timer();

    /* renamed from: v */
    public  Map<C1273a, C1286c> f2460v = new HashMap();

    /* renamed from: w */
    private  Map<String, List<C1336i>> f2461w = new HashMap();

    /* renamed from: x */
    public Activity f2462x = null;

    /* renamed from: y */
    public int f2463y = 0;

    /* renamed from: z */
    private C1276c f2464z = null;

    public BannerFinder() {
        Logger.m3601d(f2441d, "BannerFinder ctor started");
        SafeDK.getInstance().mo19150t().mo19460a(BrandSafetyUtils.AdType.BANNER);
        C1347b.getInstance().registerBackgroundForegroundListener(this);
        AppLovinBridge.registerToReceiveMaxEvents(this);
    }

    public synchronized void onMessageReceived(AppLovinCommunicatorMessage message) {
        if (SafeDK.getInstance().mo19141j() && SafeDK.getInstance().mo19142k()) {
            SafeDK.m2696Q();
            Bundle messageData = message.getMessageData();
            String string = messageData.getString("type");
            String string2 = messageData.getString("ad_format");
            String string3 = messageData.getString("third_party_ad_placement_id");
            String string4 = messageData.getString("id", (String) null);
            if (string4 == null) {
                Logger.m3601d(f2441d, "No eventId in data bundle, cannot match");
            }
            String string5 = messageData.getString(f2454q);
            String b = CreativeInfoManager.m3083b(string5);
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = C1361h.m3690b(currentTimeMillis);
            String str = null;
            if (messageData.containsKey("creative_id")) {
                str = messageData.getString("creative_id");
            }
/*
            if (f2439a.equals(string2) || f2440b.equals(string2)) {
                this.f2462x = C1347b.getInstance().getForegroundActivity();
                Logger.m3601d(f2441d, "packageName " + b + ", ts (seconds)=" + b2 + ", message received: " + message.getMessageData());
                C1273a aVar = new C1273a(string3, string4);
                if (f2447j.equals(string)) {
                    if (b != null && m2867d(b)) {
                        Logger.m3601d(f2441d, "WILL_DISPLAY event detected for package=" + b + " placementId=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                        this.f2458c = new AtomicReference<>(messageData);
                        CreativeInfoManager.m3077a(b, string3, str, string4, string2);
                    }
                    m2850a(b, str, aVar, currentTimeMillis);
                } else if (f2450m.equals(string)) {
                    if (m2867d(b) && this.f2460v.get(aVar) != null) {
                        StringBuilder append = new StringBuilder().append("DID_CLICKED event detected for package=");
                        if (b == null) {
                            b = string5;
                        }
                        Logger.m3601d(f2441d, append.append(b).append(", slotCount=").append(this.f2463y).toString());
                        m2866d(aVar);
                    }
                } else if (f2448k.equals(string)) {
                    if (b != null && m2867d(b)) {
                        Logger.m3601d(f2441d, "WILL_LOAD event detected for package=" + b + " placement=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                        C1308d.m3136b(b, string3);
                    }
                } else if (f2449l.equals(string)) {
                    if (b != null && m2867d(b)) {
                        BrandSafetyUtils.m2924l(b);
                        Logger.m3601d(f2441d, "DID_HIDE event detected for package=" + b + " placement=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                        m2864c(aVar);
                    }
                } else if (f2451n.equals(string)) {
                    if (b != null && m2867d(b)) {
                        Logger.m3601d(f2441d, "DID_LOAD event detected for package=" + b + " placement=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                    }
                } else if (f2452o.equals(string)) {
                    this.f2463y++;
                    if (b != null && m2867d(b)) {
                        Logger.m3601d(f2441d, "DID_DISPLAY event detected for package=" + b + " placement=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                        m2849a(b, aVar, str, currentTimeMillis);
                    }
                } else if (f2453p.equals(string) && b != null && m2867d(b)) {
                    Logger.m3601d(f2441d, "DID_FAIL_DISPLAY event detected for package=" + b + " placement=" + string3 + " eventId=" + string4 + ", slotCount=" + this.f2463y);
                }
            }
*/
        }
    }

    /* renamed from: a */
    private void m2839a(C1273a aVar) {
        C1286c remove = this.f2460v.remove(aVar);
        BrandSafetyUtils.m2913c(remove.f2621s);
        remove.f2620r = null;
        remove.mo19265b((String) null);
        m2845a(remove);
        if (StatsCollector.m2806b() != null) {
            StatsCollector.m2806b().mo19191a(remove.mo19283o());
        } else {
            Logger.m3609w(f2441d, "Stats collector instance is null, cannot remove brand safety event");
        }
    }

    /* renamed from: a */
/*
    private void m2850a(String str, String str2, C1273a aVar, long j) {
        C1286c cVar = this.f2460v.get(aVar);
        if (cVar == null) {
            cVar = m2869e(str);
            this.f2460v.put(aVar, cVar);
            Logger.m3601d(f2441d, "New activity banner created for " + str + ", activityBannerKey is " + aVar + ", currentActivityBanners size is " + this.f2460v.size());
        } else if (cVar.f2607C == null || (cVar.f2608D == null && this.f2462x != null)) {
            cVar.mo19263a(m2865c());
        }
        cVar.f2634P = true;
        cVar.f2637S = true;
        cVar.f2639U = j;
         String str3 = str;
         C1273a aVar2 = aVar;
         String str4 = str2;
         long j2 = j;
        this.f2459u.scheduleAtFixedRate(new TimerTask() {

            */

    /* renamed from: a */
    private void m2849a(String str, C1273a aVar, String str2, long j) {
         String str3 = str;
         C1273a aVar2 = aVar;
         String str4 = str2;
         long j2 = j;
        this.f2459u.schedule(new TimerTask() {
            public void run() {
                synchronized (BannerFinder.this) {
                    Logger.m3601d(BannerFinder.f2441d, "handleDidDisplay package=" + str3 + " activityBannerKey=" + aVar2);
                    C1286c cVar = (C1286c) BannerFinder.this.f2460v.get(aVar2);
                    if (cVar != null) {
                        Logger.m3601d(BannerFinder.f2441d, "Banner info already exists, package=" + str3 + " activityBanner=" + cVar);
                        cVar.f2605A = BannerFinder.this.f2463y;
                        if (cVar.f2607C == null || (cVar.f2608D == null && BannerFinder.this.f2462x != null)) {
                            cVar.mo19263a(BannerFinder.this.m2865c());
                        }
                    } else {
                        BannerFinder.this.m2861b(aVar2);
                        cVar = BannerFinder.this.m2869e(str3);
                        BannerFinder.this.f2460v.put(aVar2, cVar);
                        Logger.m3601d(BannerFinder.f2441d, "New activity banner created for " + str3 + ", activityBannerKey is " + aVar2 + ", currentActivityBanners size is " + BannerFinder.this.f2460v.size());
                    }
                    BannerFinder.this.m2846a(cVar, str4);
                    cVar.f2640V = j2;
                }
            }
        }, 0);
    }

    /* renamed from: a */
/*
    public synchronized void m2851a(String str, String str2, C1273a aVar, List<WeakReference<View>> list, long j) {
        C1286c cVar;
        Logger.m3601d(f2441d, "monitorBannerImpression started for " + str);
        WeakReference weakReference = null;
        for (WeakReference next : list) {
            if (weakReference != null) {
                next.clear();
                next = weakReference;
            }
            weakReference = next;
        }
        if (!(weakReference == null || weakReference.get() == null || (cVar = this.f2460v.get(aVar)) == null)) {
            m2848a(str, aVar, BrandSafetyUtils.m2889a((View) weakReference.get()));
            m2846a(cVar, str2);
            cVar.f2638T = true;
            cVar.f2641W = 0.0f;
            if (((View) weakReference.get()).getWidth() > 0 && ((View) weakReference.get()).getHeight() > 0) {
                cVar.f2641W = ((float) ((View) weakReference.get()).getWidth()) / ((float) ((View) weakReference.get()).getHeight());
            }
            Logger.m3601d(f2441d, "start taking screenshots for view: " + ((View) weakReference.get()).toString());
            this.f2462x = C1347b.getInstance().toString();
            int N = SafeDK.getInstance().mo19123N() * 1000;
            this.f2459u.scheduleAtFixedRate(new C1274b(cVar, weakReference), f2442e, (long) N);
        }
    }
*/

    /* renamed from: b */
    public synchronized void m2861b(C1273a aVar) {
        Iterator<Map.Entry<C1273a, C1286c>> it = this.f2460v.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            C1273a aVar2 = (C1273a) next.getKey();
            C1286c cVar = (C1286c) next.getValue();
            if (aVar2.f2477a.equals(aVar.f2477a) && !aVar2.f2478b.equals(aVar.f2478b) && !cVar.f2634P) {
                Logger.m3601d(f2441d, "report undetected banner started for placement=" + aVar2.f2477a + ", eventId=" + aVar2.f2478b);
                m2847a(cVar, true, "reportUndetectedBannerIfNeeded");
                it.remove();
                m2845a(cVar);
            }
        }
    }

    /* renamed from: d */
    public boolean m2867d(String str) {
        Bundle g = CreativeInfoManager.m3105g(str);
        if (g != null) {
            Logger.m3601d(f2441d, "sdk " + str + " config item CONFIGURATION_SUPPORTS_BANNER_IMPRESSION_TRACKING is " + g.getBoolean(AdNetworkDiscovery.f2656m));
            if (g.getBoolean(AdNetworkDiscovery.f2656m)) {
                return true;
            }
            Logger.m3601d(f2441d, "Banners tracking is not supported for this ad network (" + str + ")");
        } else {
            Logger.m3601d(f2441d, "ad network (" + str + ") is not supported");
        }
        return false;
    }

    /* renamed from: e */
    public C1286c m2869e(String str) {
        return new C1286c(m2865c(), str, this.f2463y, BrandSafetyUtils.m2912c().name().toLowerCase(), this.f2458c != null ? this.f2458c.get() : m2858b());
    }

    /* renamed from: b */
    private Bundle m2858b() {
        Logger.m3601d(f2441d, "Creating empty applovin bundle");
        Bundle bundle = new Bundle();
        bundle.putString("ad_format", BrandSafetyEvent.AdFormatType.BANNER.toString());
        return bundle;
    }

    /* renamed from: c */
    public String[] m2865c() {
        String str;
        String str2;
        if (this.f2462x != null) {
            String obj = this.f2462x.toString();
            String a = BrandSafetyUtils.m2893a(obj, true);
            str = BrandSafetyUtils.m2893a(obj, false);
            str2 = a;
        } else {
            str = null;
            str2 = null;
        }
        return new String[]{str, str2};
    }

    /* renamed from: a */
    private synchronized void m2848a(String str, C1273a aVar, String str2) {
        CreativeInfo a;
        Logger.m3601d(f2441d, "checkIfPendingCIExists started, sdkPackageName = " + str + ", activityBannerKey = " + aVar);
        if (aVar == null) {
            Logger.m3601d(f2441d, "checkIfPendingCIExists activityBannerKey is null, existing");
        } else {
            C1286c cVar = this.f2460v.get(aVar);
            if (cVar == null) {
                Logger.m3601d(f2441d, "checkIfPendingCIExists currentActivityBanner is null, existing");
            } else if (cVar.mo19276h() != null) {
                Logger.m3601d(f2441d, "checkIfPendingCIExists CI already exist");
            } else {
                if (aVar.f2478b != null) {
                    Logger.m3601d(f2441d, "checkIfPendingCIExists activityBannerKey : " + aVar);
                    AdNetworkDiscovery f = CreativeInfoManager.m3103f(str);
                    if (!(f == null || (a = f.mo19291a((Object) aVar.f2477a + "_" + aVar.f2478b + "_" + str)) == null)) {
                        Logger.m3601d(f2441d, "checkIfPendingCIExists discovery class returned a ci : " + a.toString());
                        a.mo19419k(BrandSafetyEvent.AdFormatType.BANNER.name());
                    }
                }
                List list = this.f2461w.get(str);
                if (list != null) {
                    C1361h.m3694b(f2441d, "checkIfPendingCIExists pendingCandidates collection for " + str + " contains the following items : " + list.toString());
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1336i iVar = (C1336i) it.next();
                        if (iVar.f3177a != null) {
                            if (iVar.f3177a.mo19410f() == null || !iVar.f3177a.mo19410f().equals(aVar.f2478b)) {
                                if (iVar.f3177a.mo19407e() != null && iVar.f3177a.mo19407e().equals(str2)) {
                                    Logger.m3601d(f2441d, "checkIfPendingCIExists creative info found by WebView address : " + iVar.f3177a);
                                    iVar.f3177a.mo19405d(aVar.f2478b);
                                    m2862b(iVar);
                                    list.remove(iVar);
                                    break;
                                }
                            } else {
                                Logger.m3601d(f2441d, "checkIfPendingCIExists creative info found by eventId: " + iVar.f3177a);
                                m2862b(iVar);
                                list.remove(iVar);
                                break;
                            }
                        }
                    }
                } else {
                    Logger.m3601d(f2441d, "checkIfPendingCIExists There are no pending candidates");
                }
            }
        }
    }

    /* renamed from: c */
    private synchronized void m2864c(C1273a aVar) {
        C1286c cVar = this.f2460v.get(aVar);
        if (cVar != null) {
            Logger.m3601d(f2441d, "Banner did hide received, placementId=" + aVar.f2477a);
            cVar.f2636R = true;
        }
    }

    /* renamed from: d */
    private synchronized void m2866d(C1273a aVar) {
        Logger.m3601d(f2441d, "handleDidClicked started");
        C1286c cVar = this.f2460v.get(aVar);
        if (cVar != null) {
            cVar.mo19262a(true);
            if (!(cVar.mo19275g() != null || this.f2464z == null || this.f2464z.f2488a == 0)) {
                Logger.m3601d(f2441d, "handleDidClicked checking ClickUrlCandidate");
                if (System.currentTimeMillis() - this.f2464z.f2488a < 5000) {
                    Logger.m3601d(f2441d, "handleDidClicked setting clickUrl");
                    cVar.mo19272d(this.f2464z.f2489b);
                }
            }
        }
    }

    public String getCommunicatorId() {
        return AppLovinBridge.f2360a;
    }

    /* renamed from: a */
    public void m2846a(C1286c cVar, String str) {
        Logger.m3601d(f2441d, "updateMaxCreativeId started, maxCreativeId is " + str);
        if (cVar == null || cVar.f2609E == null) {
            Logger.m3601d(f2441d, "updateMaxCreativeId currentActivityBanner or CI is null");
        } else if (cVar.f2609E.mo19390I() == null) {
            Logger.m3601d(f2441d, "updateMaxCreativeId setting Max creativeId in CI to : " + str);
            cVar.f2609E.mo19445w(str);
        } else {
            Logger.m3601d(f2441d, "updateMaxCreativeId Max creativeId already exists");
        }
    }

    /* renamed from: a */
    public synchronized void mo19212a() {
        for (C1286c cVar : this.f2460v.values()) {
            cVar.f2636R = true;
        }
    }

    /* renamed from: a */
    public synchronized CreativeInfo mo19210a(String str) {
        CreativeInfo creativeInfo;
        Iterator<C1286c> it = this.f2460v.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                creativeInfo = null;
                break;
            }
            C1286c next = it.next();
            if (next.f2614J != null && next.f2614J.equals(str) && next.f2634P) {
                creativeInfo = next.f2609E;
                break;
            }
        }
        return creativeInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = r3.f2461w.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r1 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r1.hasNext() == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r0 = (com.example.safesdk.sample.analytics.brandsafety.C1336i) r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r0.f3177a == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r0.f3177a.mo19444w().equals(r5) == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r0 = r0.f3177a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        r0 = null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo mo19211a(String r4, String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<com.example.safesdk.sample.analytics.brandsafety.BannerFinder$a, com.example.safesdk.sample.analytics.brandsafety.c> r0 = r3.f2460v     // Catch:{ all -> 0x005a }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x005a }
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x005a }
        L_0x000b:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x005a }
            com.example.safesdk.sample.analytics.brandsafety.c r0 = (com.example.safesdk.sample.analytics.brandsafety.C1286c) r0     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x000b
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r0 = r0.mo19276h()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x000b
            java.lang.String r2 = r0.mo19444w()     // Catch:{ all -> 0x005a }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x000b
        L_0x0029:
            monitor-exit(r3)
            return r0
        L_0x002b:
            java.util.Map<java.lang.String, java.util.List<com.example.safesdk.sample.analytics.brandsafety.i>> r0 = r3.f2461w     // Catch:{ all -> 0x005a }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x005a }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0058
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x005a }
        L_0x0039:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0058
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x005a }
            com.example.safesdk.sample.analytics.brandsafety.i r0 = (com.example.safesdk.sample.analytics.brandsafety.C1336i) r0     // Catch:{ all -> 0x005a }
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r2 = r0.f3177a     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0039
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r2 = r0.f3177a     // Catch:{ all -> 0x005a }
            java.lang.String r2 = r2.mo19444w()     // Catch:{ all -> 0x005a }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0039
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r0 = r0.f3177a     // Catch:{ all -> 0x005a }
            goto L_0x0029
        L_0x0058:
            r0 = 0
            goto L_0x0029
        L_0x005a:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.BannerFinder.mo19211a(java.lang.String, java.lang.String):com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo");
    }

    /* renamed from: a */
    private void m2845a(C1286c cVar) {
        try {
            Logger.m3601d(f2441d, "clean started, banner activity: " + this.f2462x + " , currentActivityBanners size is " + this.f2460v.size());
            this.f2464z = null;
            C1319d t = SafeDK.getInstance().mo19150t();
            if (!(cVar == null || cVar.mo19267c() == null)) {
                t.mo19467b(cVar.mo19267c());
                Logger.m3601d(f2441d, "lastActivityImpressionScreenshotFilename set to " + t.mo19470d());
            }
            if (cVar != null && cVar.f2614J != null) {
                C1308d.m3126a(cVar.f2614J);
            }
        } catch (Throwable th) {
            Logger.m3604e(f2441d, th.getMessage(), th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: a */
    public void m2847a(C1286c cVar, boolean z, String str) {
        Logger.m3601d(f2441d, "reportBannerEvent started, root=" + str + ", isMature=" + z + ", info=" + cVar);
        if (cVar.f2640V == 0) {
            Logger.m3601d(f2441d, "reportBannerEvent don't report due to missing DID_DISPLAY event");
            return;
        }
        boolean z2 = !cVar.f2610F;
        boolean z3 = !cVar.f2611G && cVar.mo19274f();
        float f = (((float) cVar.f2628z) / 500.0f) * 100.0f;
        Logger.m3601d(f2441d, "imageUniformity=" + f);
        long j = 0;
        if (cVar.f2639U > 0 && cVar.f2640V > 0) {
            j = cVar.f2639U - cVar.f2640V;
        }
        String str2 = null;
        if (cVar.mo19264b() != null) {
            str2 = cVar.mo19264b() + "_" + cVar.mo19283o();
        }
        CreativeInfo h = cVar.mo19276h();
        if (h != null && h.mo19385D() == null) {
            Logger.m3601d(f2441d, "Don't report CI as it was matched only by eventId and not by webview resources");
            h = null;
        }
        StatsCollector.m2806b().mo19193b((StatsEvent) new BrandSafetyEvent(cVar.mo19273e(), cVar.mo19280l(), str2, z3, cVar.mo19274f() ? cVar.mo19275g() : null, h, cVar.mo19258a(), cVar.mo19278j(), cVar.mo19283o(), 0, z, cVar.mo19281m(), cVar.f2627y, false, cVar.f2622t, f, cVar.f2626x, cVar.f2637S, cVar.f2638T, j, cVar.f2641W, cVar.f2642X, SafeDK.getInstance().mo19133c()));
        C1319d t = SafeDK.getInstance().mo19150t();
        if (t.mo19465b(BrandSafetyUtils.AdType.BANNER) < SafeDK.getInstance().mo19111B()) {
            Logger.m3601d(f2441d, "reportBannerEvent waiting to report file " + cVar.f2621s);
            t.mo19461a((C1285b) cVar);
        } else {
            BrandSafetyUtils.m2913c(cVar.f2621s);
        }
        if (z2) {
            cVar.mo19266b(true);
        }
        if (z3) {
            cVar.mo19269c(true);
        }
    }

    /* renamed from: a */
    public synchronized boolean mo19215a(C1336i iVar) {
        boolean z;
        try {
            C1361h.m3694b(f2441d, "setCreativeInfoDetails started. matchingInfo = " + iVar.toString());
            CreativeInfo creativeInfo = iVar.f3177a;
            if (creativeInfo != null) {
                Logger.m3601d(f2441d, "setCreativeInfoDetails CI exists, sdk = " + creativeInfo.mo19383B());
                creativeInfo.mo19409e(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.m2912c()));
                String B = creativeInfo.mo19383B();
                C1273a aVar = new C1273a(iVar.f3177a.mo19429p(), iVar.f3177a.mo19410f() != null ? iVar.f3177a.mo19410f() : "");
                Logger.m3601d(f2441d, "setCreativeInfoDetails activityBannerKey = " + aVar);
                C1286c cVar = this.f2460v.get(aVar);
                C1361h.m3694b(f2441d, "setCreativeInfoDetails currentActivityBanners=" + (this.f2460v != null ? this.f2460v.toString() : ""));
                if (cVar == null || !cVar.mo19273e().equals(B)) {
                    Logger.m3601d(f2441d, "setCreativeInfoDetails starting to iterate over currentActivityBanners");
                    Iterator<C1273a> it = this.f2460v.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            C1273a next = it.next();
                            C1286c cVar2 = this.f2460v.get(next);
                            Logger.m3601d(f2441d, "setCreativeInfoDetails bannerInfo webview address=" + cVar2.f2614J + ", CI webview address=" + creativeInfo.mo19407e());
                            if (cVar2.f2614J != null && creativeInfo.mo19407e() != null && cVar2.f2614J.equals(creativeInfo.mo19407e())) {
                                Logger.m3601d(f2441d, "setCreativeInfoDetails matched by webViewAddress " + creativeInfo.mo19407e());
                                if (creativeInfo.mo19410f() == null) {
                                    Logger.m3601d(f2441d, "setCreativeInfoDetails updated creative info eventId to " + next.f2478b);
                                    creativeInfo.mo19405d(next.f2478b);
                                }
                                z = m2862b(iVar);
                            }
                        } else {
                            Logger.m3601d(f2441d, "setCreativeInfoDetails Adding as pending, sdk = " + B);
                            List list = this.f2461w.get(B);
                            if (list == null) {
                                list = new ArrayList();
                                this.f2461w.put(B, list);
                            }
                            list.add(iVar);
                            z = true;
                        }
                    }
                } else {
                    Logger.m3601d(f2441d, "setCreativeInfoDetails currentActivityBanner is not null, sdk = " + B);
                    if (cVar.mo19276h() != null) {
                        Logger.m3601d(f2441d, "setCreativeInfoDetails Replacing  " + cVar.mo19276h());
                    }
                    z = m2862b(iVar);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f2441d, "Exception in setCreativeInfoDetails : " + th.getMessage(), th);
        }
        z = false;
        return z;
    }

    /* renamed from: b */
    private synchronized boolean m2862b(C1336i iVar) {
        boolean z;
        C1361h.m3694b(f2441d, "setCreativeInfo started, matchingInfo=" + (iVar == null ? "null" : iVar.toString()));
        if (iVar == null) {
            Logger.m3601d(f2441d, "matchingInfo is null");
            z = false;
        } else {
            CreativeInfo creativeInfo = iVar.f3177a;
            if (creativeInfo != null) {
                C1273a aVar = new C1273a(creativeInfo.mo19429p(), creativeInfo.mo19410f());
                Logger.m3601d(f2441d, "setCreativeInfo activityBannerKey = " + aVar);
                C1286c cVar = this.f2460v.get(aVar);
                if (cVar != null) {
                    C1361h.m3694b(f2441d, "setCreativeInfo currentActivityBanner = " + cVar.toString());
                    CreativeInfo creativeInfo2 = cVar.f2609E;
                    if (creativeInfo2 != null) {
                        CreativeInfoManager.m3066a(creativeInfo2);
                        C1361h.m3694b(f2441d, "setCreativeInfo already matched! matching attempt CI: " + creativeInfo + ", instead of " + creativeInfo2);
                    }
                    creativeInfo.mo19392a(iVar.f3178b, iVar.f3179c);
                    cVar.mo19260a(creativeInfo);
                    if (cVar.f2613I == AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP && cVar.f2614J != null) {
                        C1361h.m3694b(f2441d, "ResourceUrlFilter attachResourceInfoToCreativeInfo address=" + cVar.f2614J + " , ci = " + creativeInfo.toString());
                        C1308d.m3129a(cVar.f2614J, creativeInfo);
                    }
                    if (creativeInfo2 != null && creativeInfo2.mo19444w().equals(creativeInfo.mo19444w())) {
                        Iterator<String> it = creativeInfo2.mo19414h().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!creativeInfo.mo19414h().contains(next)) {
                                Logger.m3601d(f2441d, "Added Resource url " + next + " to CI");
                                creativeInfo.mo19414h().add(next);
                            }
                        }
                        Iterator<String> it2 = creativeInfo2.mo19412g().iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!creativeInfo.mo19412g().contains(next2)) {
                                Logger.m3601d(f2441d, "Added Dsp url " + next2 + " to CI");
                                creativeInfo.mo19412g().add(next2);
                            }
                        }
                        m2846a(cVar, creativeInfo2.mo19390I());
                    }
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized void mo19217b(String str, String str2) {
        Logger.m3601d(f2441d, "set ad click URL started, sdkPackageName=" + str2 + ", url=" + str);
        if (str != null) {
            for (C1285b next : this.f2460v.values()) {
                if (!(next == null || next.mo19273e() == null || !SdksMapping.isSameSdkByPackages(next.mo19273e(), str2))) {
                    String c = C1361h.m3699c(str, "clcode");
                    Logger.m3601d(f2441d, "set ad click URL clcode=" + c);
                    if (c == null || next.f2609E == null || next.f2609E.mo19444w().equals(c)) {
                        Logger.m3601d(f2441d, "set ad click URL applying clickUrl candidate logic. url=" + str);
                        if (!next.mo19274f()) {
                            Logger.m3601d(f2441d, "set ad click URL current Activity Banner is not marked as clicked, setting clickUrl : " + str);
                            mo19218c(str);
                        } else if (next.mo19275g() == null) {
                            Logger.m3601d(f2441d, "set ad click URL no clickUrl yet, setting clickUrl : " + str);
                            next.mo19272d(str);
                        } else {
                            Logger.m3601d(f2441d, "set ad click URL clickUrl already set : " + next.mo19275g());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo19216b(String str) {
    }

    /* renamed from: a */
    private boolean m2853a(float f, float f2) {
        float f3 = f / f2;
        Logger.m3601d(f2441d, "isBannerRatio ratio is " + f3);
        return (((double) f3) >= 6.0d && ((double) f3) <= 8.4d) || (((double) f3) >= 12.0d && ((double) f3) <= 15.0d);
    }

    /* renamed from: a */
    public boolean m2854a(int i) {
        boolean b = BrandSafetyUtils.m2910b(i);
        Logger.m3601d(f2441d, "shouldStopSampling started, maxUniformedPixelsCount=" + i + ", return value=" + b);
        return b;
    }

    /* renamed from: f */
    public void mo19198f() {
        Logger.m3601d(f2441d, "onBackground started");
    }

    /* renamed from: g */
    public void mo19199g() {
        Logger.m3601d(f2441d, "onForeground started");
    }

    /* renamed from: c */
    public void mo19218c(String str) {
        this.f2464z = new C1276c(System.currentTimeMillis(), str);
    }

    /* renamed from: a */
    public static void m2838a(MaxAdView maxAdView) {
        if (maxAdView == null) {
            return;
        }
        if (f2438A == null || f2438A.get() != maxAdView) {
            Logger.m3601d(f2441d, "setMaxAdView current: " + (f2438A == null ? "null" : f2438A.get()) + " new: " + maxAdView);
            if (f2438A != null) {
                f2438A.clear();
            }
            f2438A = new WeakReference<>(maxAdView);
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BannerFinder$b */
    private class C1274b extends TimerTask {

        /* renamed from: a */
        C1286c f2480a;

        /* renamed from: b */
        WeakReference<View> f2481b;

        /* renamed from: c */
        int f2482c = 0;

        public C1274b(C1286c cVar, WeakReference<View> weakReference) {
            this.f2481b = weakReference;
            this.f2480a = cVar;
            if (cVar != null) {
                String a = BrandSafetyUtils.m2889a((View) weakReference.get());
                cVar.f2614J = a;
                CreativeInfo h = cVar.mo19276h();
                if (h != null) {
                    C1308d.m3129a(a, h);
                    h.mo19428o("wv:" + a);
                }
            }
        }

        public void run() {
            this.f2482c++;
            if (BannerFinder.this.f2462x == null || this.f2480a == null) {
                Logger.m3601d(BannerFinder.f2441d, "Banner finder timer task cannot be started: bannerActivity=" + (BannerFinder.this.f2462x == null ? "" : BannerFinder.this.f2462x.getClass().getName()) + ", currentActivityBanner=" + this.f2480a);
            } else if (this.f2480a != null) {
                int M = SafeDK.getInstance().mo19122M();
                if (this.f2482c == M || this.f2480a.f2636R) {
                    Logger.m3601d(BannerFinder.f2441d, "Going to report banner, stopTimerAndReport=" + this.f2480a.f2636R + ", counter=" + this.f2482c + ", maxAttemptsToCaptureBannerImage=" + M);
                    if (!this.f2480a.f2610F) {
                        BannerFinder.this.m2847a(this.f2480a, false, "TimerTask");
                        this.f2481b.clear();
                        cancel();
                        return;
                    }
                }
                if (this.f2480a.f2609E != null) {
                    m2883a(this.f2480a, (View) this.f2481b.get());
                } else {
                    Logger.m3601d(BannerFinder.f2441d, "no creative info yet");
                }
            }
        }

        /* renamed from: a */
        private void m2883a( C1286c cVar,  View view) {
            BannerFinder.this.f2462x.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        if (cVar != null && view != null) {
                            Logger.m3601d(BannerFinder.f2441d, "BannerFinder: Taking screenshot, counter=" + C1274b.this.f2482c + ", view=" + view.toString());
                            Bitmap a = new C1316e().mo19348a(view, SafeDK.getInstance().mo19124O());
                            if (a != null) {
                                String e = cVar.mo19273e();
                                BrandSafetyUtils.C1277a b = BrandSafetyUtils.m2908b(e, a);
                                int a2 = b.mo19228a();
                                if (BrandSafetyUtils.m2911b(e, b)) {
                                    String a3 = BrandSafetyUtils.m2887a(a);
                                    BrandSafetyUtils.ScreenShotOrientation b2 = BrandSafetyUtils.m2907b(a);
                                    String o = cVar.mo19283o() != null ? cVar.mo19283o() : "";
                                    String a4 = BrandSafetyUtils.m2888a(a, BrandSafetyUtils.AdType.BANNER, a3, e, o, b2);
                                    Logger.m3601d(BannerFinder.f2441d, "Screenshot file created, counter = " + C1274b.this.f2482c + " filename = " + a4);
                                    long b3 = BrandSafetyUtils.m2906b(a4);
                                    Logger.m3601d(BannerFinder.f2441d, "Stored file size is " + b3 + " bytes, counter is " + C1274b.this.f2482c + ", uniform pixel count is " + a2 + " (" + ((((float) a2) / 500.0f) * 100.0f) + "%)");
                                    C1319d t = SafeDK.getInstance().mo19150t();
                                    int b4 = t.mo19465b(BrandSafetyUtils.AdType.BANNER);
                                    if (t.mo19468b(a3, o)) {
                                        Logger.m3601d(BannerFinder.f2441d, "Not saving file for banner " + a3 + "_" + o);
                                        BrandSafetyUtils.m2913c(a4);
                                    } else if (b4 < SafeDK.getInstance().mo19111B()) {
                                        if (cVar.f2620r != null && !cVar.f2620r.equals(a3)) {
                                            BrandSafetyUtils.m2913c(cVar.f2621s);
                                        }
                                    } else if (!t.mo19464a(a3, o)) {
                                        Logger.m3601d(BannerFinder.f2441d, "No open slot for banner " + a3 + "_" + o + "; next hashes to be reported to server are " + t.mo19469c());
                                        BrandSafetyUtils.m2913c(a4);
                                    } else {
                                        Logger.m3601d(BannerFinder.f2441d, "Image " + a3 + "_" + o + " is already scheduled for upload");
                                    }
                                    cVar.mo19288a(a3, a4, b3, a2, C1274b.this.f2482c, b2);
                                    if (BannerFinder.this.m2854a(a2) && !TextUtils.isEmpty(a3)) {
                                        cVar.mo19271d(true);
                                        BannerFinder.this.m2847a(cVar, false, "takeScreenshot");
                                        C1274b.this.cancel();
                                        return;
                                    }
                                    return;
                                }
                                Logger.m3601d(BannerFinder.f2441d, "Screenshot is not valid (uniform pixel count too high: " + a2 + ", counter = " + C1274b.this.f2482c + ", try again...");
                            }
                        }
                    } catch (Throwable th) {
                        Logger.m3604e(BannerFinder.f2441d, "BannerFinder: Error while taking screenshot", th);
                        Logger.printStackTrace();
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19214a(String str, List<WeakReference<View>> list) {
        this.f2462x = C1347b.getInstance().getForegroundActivity();
        Logger.m3601d(f2441d, "findBannerImpression started, current foreground activity is " + (this.f2462x == null ? "" : this.f2462x.getClass().getName()));
        try {
            if (f2438A != null) {
                ArrayList arrayList = new ArrayList();
                mo19213a((ViewGroup) f2438A.get(), str, list, (List<C1339l>) arrayList, 1);
                Logger.m3601d(f2441d, "findBannerImpression topView: " + ((MaxAdView) f2438A.get()).toString());
                Logger.m3601d(f2441d, "findBannerImpression visible WebViews: " + arrayList.toString());
                Logger.m3601d(f2441d, "findBannerImpression visible views: " + list.toString());
            }
        } catch (Throwable th) {
            Logger.m3604e(f2441d, "Failed while scanning the screen for banners", th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: a */
    public synchronized void m2852a(List<WeakReference<View>> list, C1273a aVar) {
        boolean z;
        Iterator<Map.Entry<C1273a, C1286c>> it = this.f2460v.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((C1273a) next.getKey()).equals(aVar)) {
                Logger.m3601d(f2441d, "Skipping newly created banner info, activityBannerKey=" + aVar);
            } else {
                Logger.m3601d(f2441d, "check to report banner info, activityBannerKey=" + next.getKey());
                C1286c cVar = (C1286c) next.getValue();
                if (cVar.f2614J != null) {
                    Logger.m3601d(f2441d, "Looking for completed banners to report, webview=" + cVar.f2614J);
                    if (list != null) {
                        Iterator<WeakReference<View>> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String a = BrandSafetyUtils.m2889a((View) it2.next().get());
                            if (cVar.f2614J.equals(a)) {
                                Logger.m3601d(f2441d, "WebView address still active, webview=" + a);
                                z = true;
                                break;
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    m2847a(cVar, true, "findBannerImpression");
                    it.remove();
                    m2845a(cVar);
                }
            }
        }
    }

    
    /* renamed from: a */
    public void mo19213a(ViewGroup viewGroup, String str, List<WeakReference<View>> list, List<C1339l> list2, int i) {
        if (viewGroup != null) {
            String a = BrandSafetyUtils.m2891a((Class) viewGroup.getClass());
            if (TextUtils.isEmpty(a)) {
                a = str;
            }
            Logger.m3607v(f2441d, "scanForBannerViews view is an instance of: " + viewGroup.getClass().getName() + ", child count is: " + viewGroup.getChildCount());
            if (!m2855a((View) viewGroup, list, list2, i)) {
                int i2 = i + 1;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < viewGroup.getChildCount()) {
                        View childAt = viewGroup.getChildAt(i4);
                        if (m2855a(childAt, list, list2, i2) || !(childAt instanceof ViewGroup)) {
                            Logger.m3607v(f2441d, "scanForBannerViews view is an instance of: " + childAt.getClass().getName());
                        } else {
                            mo19213a((ViewGroup) childAt, a, list, list2, i2);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m2855a(View view, List<WeakReference<View>> list, List<C1339l> list2, int i) {
        String a = BrandSafetyUtils.m2889a(view);
        if (!(view instanceof WebView)) {
            return false;
        }
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        Logger.m3601d(f2441d, "isAdView view is an instance of WebView : " + a + ", class : " + view.getClass().getCanonicalName() + ", hierarchyCount=" + i + ", width=" + width + ", height=" + height);
        if (!m2870f(view.getClass().getName())) {
            return false;
        }
        Logger.m3601d(f2441d, "Banner view class name is " + view.getClass().getName());
        list2.add(new C1339l(a, view.getClass().getName(), view.getWidth(), view.getHeight(), i));
        list.add(new WeakReference(view));
        Logger.m3607v(f2441d, "found view = " + view + ": width = " + width + " height = " + height + " sdk: " + view.getClass().getName());
        return true;
    }

    /* renamed from: f */
    private boolean m2870f(String str) {
        String sdkPackageByClass = SdksMapping.getSdkPackageByClass(str);
        if (sdkPackageByClass != null) {
            boolean b = CreativeInfoManager.m3091b(sdkPackageByClass, false);
            Logger.m3601d(f2441d, "isBannerSupportedSdk class " + str + " is part of " + sdkPackageByClass + ", banner tracking supported? " + b);
            return b;
        }
        Logger.m3601d(f2441d, "isBannerSupportedSdk class " + str + " is not part of a supported sdk");
        return false;
    }

    /* renamed from: a */
    private String m2837a(View view, String str) {
        String a = BrandSafetyUtils.m2891a((Class) view.getClass());
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (TextUtils.isEmpty(str)) {
            return view.getClass().getName();
        }
        return str;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BannerFinder$c */
    private class C1276c {

        /* renamed from: d */
        private String f2487d = "ClickUrlCandidate";

        /* renamed from: a */
        public long f2488a = 0;

        /* renamed from: b */
        public String f2489b;

        public C1276c(long j, String str) {
            Logger.m3601d(f2487d, "ClickUrlCandidate ctor currentTime=" + j + ", clickUrl=" + str);
            this.f2488a = j;
            this.f2489b = str;
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BannerFinder$a */
    private class C1273a {

        /* renamed from: a */
        String f2477a;

        /* renamed from: b */
        String f2478b;

        public C1273a(String str, String str2) {
            this.f2477a = str;
            this.f2478b = str2;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            C1273a aVar = (C1273a) o;
            boolean equals = this.f2477a.equals(aVar.f2477a);
            if (this.f2478b == null) {
                return equals;
            }
            if (!equals || !this.f2478b.equals(aVar.f2478b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.f2478b != null) {
                return this.f2477a.hashCode() * this.f2478b.hashCode();
            }
            return this.f2477a.hashCode();
        }

        public String toString() {
            return "{placementId=" + this.f2477a + ", eventId=" + this.f2478b + "}";
        }

        /* renamed from: a */
        public String mo19222a() {
            return (this.f2477a != null ? this.f2477a : "") + "_" + (this.f2478b != null ? this.f2478b : "");
        }
    }
}

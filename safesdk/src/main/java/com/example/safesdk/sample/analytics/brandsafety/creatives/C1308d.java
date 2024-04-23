package com.example.safesdk.sample.analytics.brandsafety.creatives;

import android.util.Pair;
import android.webkit.WebView;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.BannerFinder;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder;
import com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.*;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.AdMobCreativeInfo;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.FyberCreativeInfo;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.d */
public class C1308d {

    /* renamed from: a */
    public static  String f2813a = "ResourceUrlFilter";

    /* renamed from: b */
    public static  String f2814b = "attribution.urls";

    /* renamed from: c */
    public static  String f2815c = "general_exclusion_list";

    /* renamed from: d */
    public static  String f2816d = "http";

    /* renamed from: e */
    private static  ConcurrentHashMap<String, String[]> f2817e = m3135b();

    /* renamed from: f */
    private static  float f2818f = 1.1f;

    /* renamed from: g */
    private static  float f2819g = 1.3f;

    /* renamed from: h */
    private static  String f2820h = "BannerView";

    /* renamed from: i */
    private static  float f2821i = 6.0f;

    /* renamed from: j */
    private static  float f2822j = 8.0f;

    /* renamed from: k */
    private static  LinkedHashSet<String> f2823k = new LinkedHashSet<>();

    /* renamed from: l */
    private static  int f2824l = 10;

    /* renamed from: m */
    private static String f2825m = null;

    /* renamed from: n */
    private static ConcurrentHashMap<String, C1311b> f2826n = new ConcurrentHashMap<>();

    /* renamed from: o */
    private static ConcurrentHashMap<String, C1310a> f2827o = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static ConcurrentHashMap<String, String[]> m3122a() {
        return f2817e;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.d$b */
    private static class C1311b {

        /* renamed from: a */
        ConcurrentHashMap<String, Pair<ArrayList<String>, ArrayList<String>>> f2830a;

        /* renamed from: b */
        CreativeInfo f2831b;

        private C1311b() {
            this.f2830a = new ConcurrentHashMap<>();
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.d$a */
    private static class C1310a {

        /* renamed from: a */
        Set<String> f2828a = new HashSet();

        /* renamed from: b */
        Set<String> f2829b = new HashSet();

        C1310a() {
        }

        public String toString() {
            String str;
            synchronized (this) {
                str = "webviewResources=" + (this.f2828a != null ? this.f2828a.toString() : "null") + ", dspDomains=" + (this.f2829b != null ? this.f2829b.toString() : "null");
            }
            return str;
        }
    }

    /* renamed from: b */
    private static String m3134b(String str) {
        if (C1357d.f3610r.equals(str)) {
            return C1357d.f3608p;
        }
        if (C1357d.f3600h.equals(str)) {
            return C1357d.f3599g;
        }
        return str;
    }

    /* renamed from: b */
    private static ConcurrentHashMap<String, String[]> m3135b() {
        ConcurrentHashMap<String, String[]> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(C1357d.f3593a, new String[]{".applovin.com"});
        concurrentHashMap.put(C1357d.f3599g, new String[]{".supersonicads.com", ".supersonic.com", "streamrail.com", "streamrail.net", "simharif.com", "atom-data.io", "supersonicads-a.akamaihd.net", ".ssacdn.com", ".isprog.com"});
        concurrentHashMap.put(C1357d.f3596d, new String[]{".vungle.com"});
        concurrentHashMap.put(C1357d.f3608p, new String[]{".unity3d.com"});
        concurrentHashMap.put("com.facebook.ads", new String[]{".facebook.com"});
        concurrentHashMap.put(C1357d.f3603k, new String[]{".doubleclick.net", ".google.com", ".googlesyndication.com", ".googleadservices.com", ".googleapis.com", ".youtube.com", ".googleusercontent.com", ".gstatic.com", ".googlevideo.com"});
        concurrentHashMap.put(C1357d.f3612t, new String[]{"rayjump.com", "mobvista.com", "mintegral.com", "mindworks-creative.com"});
        concurrentHashMap.put(C1357d.f3594b, new String[]{"adcolony.com", "adccache.cn", "adtilt.com", "admarvel.com"});
        concurrentHashMap.put(f2814b, new String[]{"play.google.com", ".appsflyer.com", ".adjust.com", ".singular.net", ".tenjin.io", ".kochava.com", ".tune.com", ".partytrack.it", ".tapstream.com", ".apsalar.com", ".adj.st", ".singular.com", ".sng.link", ".tenjin.com", ".doubleverify.com", ".onelink.me"});
        concurrentHashMap.put(C1357d.f3613u, new String[]{".inner-active.mobi", ".inner-active.com", "w3.org"});
        concurrentHashMap.put(C1357d.f3605m, new String[]{"inmobicdn.net", "inmobi.com"});
        concurrentHashMap.put(f2815c, new String[]{"outcome-cdn.supersonicads.com/", "click-haproxy.supersonicads.com/", "supersonicads.com/pixel", "supersonicads.com/endcardclick", "supersonicads.com/videoimpression", "supersonicads.com/isendcardclick", "supersonicads.com/isvideoimpression", "k.isprog.com", "events.isprog.com", ".simharif.com", "csi.gstatic.com/csi", "googleads.g.doubleclick.net/pagead/conversion", ".applovin.com/imp", ".applovin.com/click", ".applovin.com/interact", ".applovin.com/redirect", "event.inner-active.mobi", "events.inner-active.mobi"});
        return concurrentHashMap;
    }

    /* renamed from: a */
    public static boolean m3133a(String[] strArr, String str) {
        for (String b : strArr) {
            if (!m3131a(m3134b(b), str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[EDGE_INSN: B:25:0x0043->B:16:0x0043 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3131a(String r7, String r8) {
        /*
            r2 = 1
            r3 = 0
            java.lang.String r0 = "http"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            return r3
        L_0x000b:
            java.lang.String r0 = m3134b(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x004f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String[]> r1 = f2817e
            java.lang.Object r0 = r1.get(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 == 0) goto L_0x004f
            int r4 = r0.length
            r1 = r3
        L_0x0021:
            if (r1 >= r4) goto L_0x004f
            r5 = r0[r1]
            boolean r5 = r8.contains(r5)
            if (r5 == 0) goto L_0x0047
            r1 = r2
        L_0x002c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String[]> r0 = f2817e
            java.lang.String r4 = "attribution.urls"
            java.lang.Object r0 = r0.get(r4)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r5 = r0.length
            r4 = r3
        L_0x0038:
            if (r4 >= r5) goto L_0x0043
            r6 = r0[r4]
            boolean r6 = r8.contains(r6)
            if (r6 == 0) goto L_0x004a
            r1 = r2
        L_0x0043:
            if (r1 != 0) goto L_0x004d
        L_0x0045:
            r3 = r2
            goto L_0x000a
        L_0x0047:
            int r1 = r1 + 1
            goto L_0x0021
        L_0x004a:
            int r4 = r4 + 1
            goto L_0x0038
        L_0x004d:
            r2 = r3
            goto L_0x0045
        L_0x004f:
            r1 = r3
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d.m3131a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static void m3128a(String str, WebView webView, String str2, Map<String, String> map) {
        String j = BrandSafetyUtils.m2922j(webView.toString());
        String b = m3134b(str);
        Logger.m3601d(f2813a, "handleResourceUrlLoaded " + b + " on webview " + j + ", resource " + str2);
        CreativeInfo creativeInfo = null;
        InterstitialFinder r = SafeDK.getInstance().mo19148r();
        if (r != null) {
            creativeInfo = r.mo19210a(j);
        }
        BannerFinder s = SafeDK.getInstance().mo19149s();
        if (creativeInfo == null && s != null) {
            creativeInfo = s.mo19210a(j);
        }
        if (creativeInfo != null) {
            if (m3132a(b, str2, map)) {
                creativeInfo.mo19376a(str2);
            } else if (m3131a(b, str2)) {
                Logger.m3601d(f2813a, "WebView resource discarded (should not be added to dsp domains). resource = " + str2);
            }
            if (creativeInfo.mo19383B().equals(C1357d.f3612t)) {
                creativeInfo.mo19428o("added_webview_rec_to_ci(" + C1361h.m3705e() + "");
                return;
            }
            return;
        }
        C1310a aVar = f2827o.get(j);
        if (aVar == null) {
            aVar = new C1310a();
            f2827o.put(j, aVar);
        }
        synchronized (aVar) {
            if (m3132a(b, str2, map)) {
                aVar.f2828a.add(str2);
            } else if (m3131a(b, str2)) {
                Logger.m3601d(f2813a, "WebView resource discarded (should not be added to dsp domains). resource = " + str2);
            }
        }
    }

    /* renamed from: a */
    public static void m3126a(String str) {
        Logger.m3601d(f2813a, "clearing for " + str);
        Logger.m3601d(f2813a, "success = " + (f2827o.remove(str) != null));
    }

    /* renamed from: a */
    public static void m3129a(String str, CreativeInfo creativeInfo) {
        C1361h.m3694b(f2813a, "attaching resource info to creative info. webviewAddress=" + str + ", ci = " + creativeInfo);
        C1310a aVar = f2827o.get(str);
        if (aVar == null) {
            Logger.m3601d(f2813a, "no data for " + str);
            return;
        }
        synchronized (aVar) {
            for (String next : aVar.f2828a) {
                Logger.m3601d(f2813a, "attaching resource info to creative info. resource url = " + next);
                creativeInfo.mo19376a(next);
            }
            for (String next2 : aVar.f2829b) {
                Logger.m3601d(f2813a, "attaching resource info to creative info. dsp resource url = " + next2);
                creativeInfo.mo19432q(next2);
            }
        }
        if (creativeInfo.mo19383B().equals(C1357d.f3612t)) {
            creativeInfo.mo19428o("attached_webview_rec_to_ci(" + C1361h.m3705e() + "");
        }
        Logger.m3601d(f2813a, "clearing resource info.  webviewAddress=" + str + ", webViewToResource = " + f2827o.toString());
        f2827o.remove(str);
    }

    /* renamed from: a */
    public static void m3127a(String str, WebView webView, String str2, String str3, Map<String, String> map) {
        String j = BrandSafetyUtils.m2922j(webView.toString());
        String b = m3134b(str);
        Logger.m3601d(f2813a, "handleResourceUrlLoaded " + b + " on webview " + j + ", context " + webView.getContext() + " resource " + str2 + " size: " + webView.getWidth() + "," + webView.getHeight() + ", webView.Id=" + Integer.toHexString(webView.getId()));
        if (map != null) {
            Logger.m3601d(f2813a, "handleResourceUrlLoaded requestHeaders=" + map.toString());
        }
        boolean isInterstitialActivity = C1347b.getInstance().isInterstitialActivity(webView.getContext());
        Logger.m3601d(f2813a, "handleResourceUrlLoaded interstitialActivity=" + isInterstitialActivity);
        if (!isInterstitialActivity) {
            if (!C1357d.f3608p.equals(b) && !C1357d.f3599g.equals(b) && !C1357d.f3613u.equals(b) && !C1357d.f3596d.equals(b) && !C1357d.f3605m.equals(b)) {
                return;
            }
            if (C1357d.f3608p.equals(b) && webView.getContext().toString().contains("UnityPlayerActivity")) {
                return;
            }
            /*if (e().containsKey(Integer.valueOf(webView.getId()))) {
                Logger.m3601d(f2813a, j + " will be added to WebviewAddressList");
                f2823k.add(j);
                boolean a = m3130a(webView);
                Logger.m3601d(f2813a, "webview context = " + webView.getContext() + " size: " + webView.getWidth() + "," + webView.getHeight() + ", interstitialBySize: " + a);
                if (!a) {
                    return;
                }
            }
            else if (!C1357d.f3613u.equals(b)) {
                Logger.m3601d(f2813a, j + " will be added to WebviewAddressList");
                f2823k.add(j);
                boolean a = m3130a(webView);
                Logger.m3601d(f2813a, "webview context = " + webView.getContext() + " size: " + webView.getWidth() + "," + webView.getHeight() + ", interstitialBySize: " + a);
                if (!a) {
                    return;
                }
            } else {
                return;
            }*/
        }
        C1311b bVar = f2826n.get(b);
        if (bVar != null) {
            Logger.m3601d(f2813a, "handleResourceUrlLoaded before calling shouldIncludeResourceUrl");
            boolean a2 = m3132a(b, str2, map);
            if (bVar.f2831b == null || C1357d.f3613u.equals(b)) {
                if (C1357d.f3599g.equals(b)) {
                    if (str3 == null) {
                        str3 = f2825m;
                    }
                    Logger.m3601d(f2813a, "using placement Id as key " + str3);
                } else {
                    str3 = j;
                }
                Pair pair = bVar.f2830a.get(str3);
                if (pair == null) {
                    pair = new Pair(new ArrayList(), new ArrayList());
                    bVar.f2830a.put(str3, pair);
                }
                if (a2) {
                    Logger.m3601d(f2813a, "handleResourceUrlLoaded storing resource for webview " + str3 + " resource " + str2);
                    ((ArrayList) pair.second).add(str2);
                } else if (m3131a(b, str2)) {
                    Logger.m3601d(f2813a, "WebView resource discarded (should not be added to dsp domains). resource = " + str2);
                }
            } else if (a2) {
                Logger.m3601d(f2813a, "handleResourceUrlLoaded adding resource url " + str2);
                bVar.f2831b.mo19376a(str2);
            } else if (m3131a(b, str2)) {
                Logger.m3601d(f2813a, "WebView resource discarded (should not be added to dsp domains). resource = " + str2);
            }
            m3139d();
        }
    }

    /* renamed from: a */
    public static boolean m3132a(String str, String str2, Map<String, String> map) {
        return C1361h.m3687a(str2, map) || m3138c(str, str2) || (C1357d.f3613u.equals(str) && !FyberCreativeInfo.m3323x(str2));
    }

    /* renamed from: c */
    private static boolean m3138c(String str, String str2) {
        if (!m3134b(str).equals(C1357d.f3608p)) {
            return false;
        }
        boolean b = AdMobCreativeInfo.m3244b(str2);
        if (!b) {
            return b;
        }
        Logger.m3601d(f2813a, "isAdmobKnownDomainUrl resourceUrl=" + str2);
        return b;
    }

    /* renamed from: b */
    public static void m3136b(String str, String str2) {
        Logger.m3601d(f2813a, "set new url Info data for package " + str);
        String b = m3134b(str);
        if (C1357d.f3599g.equals(b)) {
            if (!f2826n.contains(b)) {
                f2826n.put(b, new C1311b());
            }
            f2825m = str2;
            Logger.m3601d(f2813a, "updating placement Id to " + str2);
            return;
        }
        f2826n.put(b, new C1311b());
    }

    /* renamed from: a */
    public static synchronized void m3124a(CreativeInfo creativeInfo, String str) {
        synchronized (C1308d.class) {
            String b = m3134b(creativeInfo.mo19383B());
            C1311b bVar = f2826n.get(b);
            if (bVar != null) {
                bVar.f2831b = creativeInfo;
                Logger.m3601d(f2813a, "handleCreativeInfoSelected sdk " + b + " Info data: " + creativeInfo);
                if (C1357d.f3599g.equals(b)) {
                    if (bVar == null || bVar.f2830a == null) {
                        Logger.m3601d(f2813a, "webViewToUrlInfo is null for package " + b + " , cannot add resources to CI. WebView address is " + str + ", ci = " + (creativeInfo == null ? "null" : creativeInfo.toString()));
                    } else if (creativeInfo.mo19429p() != null) {
                        Pair pair = bVar.f2830a.get(creativeInfo.mo19429p());
                        if (pair != null) {
                            m3125a(creativeInfo, creativeInfo.mo19429p(), (Pair<ArrayList<String>, ArrayList<String>>) pair);
                        } else {
                            Logger.m3601d(f2813a, "webViewResources is null, cannot attach resource url to CI, placementId = " + creativeInfo.mo19429p());
                        }
                    } else {
                        Logger.m3601d(f2813a, "IronSource CI without placement. Cannot execute logic to determine if we need to attach resource urls to the CI. CI=" + creativeInfo);
                    }
                } else if (!C1357d.f3613u.equals(b)) {
                    for (String next : bVar.f2830a.keySet()) {
                        m3125a(creativeInfo, next, bVar.f2830a.get(next));
                    }
                } else if (str != null) {
                    Logger.m3601d(f2813a, "handleCreativeInfoSelected, mainSdkPackage=" + b + ", webView=" + str + ", ci = " + creativeInfo.toString());
                    m3125a(creativeInfo, str, bVar.f2830a.get(str));
                } else {
                    Logger.m3601d(f2813a, "handleCreativeInfoSelected WebView instance is null");
                }
            }
            m3139d();
        }
    }

    /* renamed from: a */
    private static synchronized void m3125a(CreativeInfo creativeInfo, String str, Pair<ArrayList<String>, ArrayList<String>> pair) {
        synchronized (C1308d.class) {
            C1361h.m3694b(f2813a, "attachResourceUrlsToCI from key " + str + " resource url db " + pair);
            if (pair != null) {
                Logger.m3601d(f2813a, "attachResourceUrlsToCI webViewResources.first " + pair.first);
                Iterator it = ((ArrayList) pair.first).iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    Logger.m3601d(f2813a, "attachResourceUrlsToCI adding stored dsp resource " + str2 + " for address " + str);
                    creativeInfo.mo19432q(str2);
                }
                Logger.m3601d(f2813a, "attachResourceUrlsToCI webViewResources.second " + pair.second);
                Iterator it2 = ((ArrayList) pair.second).iterator();
                while (it2.hasNext()) {
                    String str3 = (String) it2.next();
                    Logger.m3601d(f2813a, "attachResourceUrlsToCI adding stored resource url " + str3 + " for address " + str);
                    creativeInfo.mo19376a(str3);
                }
            }
            m3139d();
        }
    }

    /* renamed from: a */
    public static synchronized void m3123a(CreativeInfo creativeInfo) {
        synchronized (C1308d.class) {
            Logger.m3601d(f2813a, "handleCreativeInfoDestroyed Info data to ci " + creativeInfo);
            if (!(creativeInfo == null || creativeInfo.mo19383B() == null)) {
                String b = m3134b(creativeInfo.mo19383B());
                if (C1357d.f3599g.equals(b)) {
                    C1311b bVar = f2826n.get(b);
                    if (creativeInfo.mo19429p() != null) {
                        bVar.f2830a.remove(creativeInfo.mo19429p());
                    }
                    bVar.f2831b = null;
                    f2825m = null;
                    Logger.m3601d(f2813a, "removed ci & Info data for placementId: " + creativeInfo.mo19429p());
                } else if (C1357d.f3613u.equals(b)) {
                    m3137c();
                } else {
                    Logger.m3601d(f2813a, "removed Info data: " + f2826n.remove(b));
                }
                m3139d();
            }
        }
    }

    /* renamed from: c */
    private static synchronized void m3137c() {
        synchronized (C1308d.class) {
            Logger.m3601d(f2813a, "removeWebViewUrlsIfNeeded started, WebViewAddressList.size()=" + f2823k.size() + " , list=" + f2823k.toString());
            while (f2823k.size() > 10) {
                try {
                    Iterator it = f2823k.iterator();
                    if (!it.hasNext()) {
                        Logger.m3601d(f2813a, "Unable to get WebView address for removal, exiting");
                        break;
                    }
                    String str = (String) it.next();
                    Logger.m3601d(f2813a, "removeWebViewUrlsIfNeeded " + str + " will be removed");
                    f2826n.get(C1357d.f3613u).f2830a.remove(str);
                    f2823k.remove(str);
                    Logger.m3601d(f2813a, "removeWebViewUrlsIfNeeded " + str + " removed, size is " + f2823k.size());
                    m3139d();
                } catch (Throwable th) {
                    Logger.m3604e(f2813a, "Exception in removeWebViewUrlsIfNeeded", th);
                }
            }
            if (f2823k.size() == 0) {
                f2826n.remove(C1357d.f3613u);
            }
        }
        return;
    }

    /* renamed from: a */
    private static boolean m3130a(WebView webView) {
        boolean z;
        try {
            float width = (float) webView.getWidth();
            float height = (float) webView.getHeight();
            if (height <= 0.0f) {
                return true;
            }
            float f = width / height;
            boolean z2 = f >= f2818f && f <= f2819g;
            if (f < f2821i || f > f2822j) {
                z = false;
            } else {
                z = true;
            }
            if (z2 || z) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    /* renamed from: d */
    private static void m3139d() {
        try {
            if (f2826n != null) {
                for (String next : f2826n.keySet()) {
                    if (f2826n.get(next) == null) {
                        Logger.m3601d(f2813a, "printCurrentContents key is " + next);
                        C1311b bVar = f2826n.get(next);
                        C1361h.m3694b(f2813a, "printCurrentContents sdkLoadedUrlsInfo.ci = " + bVar.f2831b);
                        ConcurrentHashMap<String, Pair<ArrayList<String>, ArrayList<String>>> concurrentHashMap = bVar.f2830a;
                        for (String next2 : concurrentHashMap.keySet()) {
                            Pair pair = concurrentHashMap.get(next2);
                            if (pair.first != null || pair.second != null) {
                                Logger.m3601d(f2813a, "printCurrentContents Urls for WebView address " + next2);
                                C1361h.m3694b(f2813a, "printCurrentContents first list :  " + ((ArrayList) pair.first).toString());
                                C1361h.m3694b(f2813a, "printCurrentContents second list :  " + ((ArrayList) pair.second).toString());
                            }
                        }
                    }
                }
            }
        } catch (ConcurrentModificationException e) {
            Logger.m3601d(f2813a, "ConcurrentModificationException during printing, skipping");
        } catch (Throwable th) {
            Logger.m3604e(f2813a, "Exception printing resource info", th);
        }
    }
}

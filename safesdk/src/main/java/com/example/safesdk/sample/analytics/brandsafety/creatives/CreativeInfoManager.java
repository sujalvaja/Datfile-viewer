package com.example.safesdk.sample.analytics.brandsafety.creatives;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.ads.MaxAdView;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.BannerFinder;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.C1284a;
import com.example.safesdk.sample.analytics.brandsafety.C1336i;
import com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder;
import com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.C1313c;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1350e;
import com.example.safesdk.sample.internal.C1351f;
import com.example.safesdk.sample.internal.C1352g;
import com.example.safesdk.sample.internal.SafeDKWebAppInterface;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.PersistentConcurrentHashMap;
import com.itextpdf.text.xml.xmp.XmpWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreativeInfoManager {

    /* renamed from: A */
    private static  String f2665A = "FYBER_NETWORK";

    /* renamed from: B */
    private static  String f2666B = "FYBER_BIDDING";

    /* renamed from: C */
    private static  String f2667C = "ADCOLONY_NETWORK";

    /* renamed from: D */
    private static  String f2668D = "ADCOLONY_BIDDING";

    /* renamed from: E */
    private static  String f2669E = "AMAZON_NETWORK";

    /* renamed from: F */
    private static  String f2670F = "AMAZON_BIDDING";

    /* renamed from: G */
    private static  String f2671G = "CHARTBOOST_NETWORK";

    /* renamed from: H */
    private static  String f2672H = "CHARTBOOST_BIDDING";

    /* renamed from: I */
    private static  String f2673I = "GOOGLE_AD_MANAGER_NETWORK";

    /* renamed from: J */
    private static  String f2674J = "GOOGLE_AD_MANAGER_BIDDING";

    /* renamed from: K */
    private static  String f2675K = "INMOBI_NETWORK";

    /* renamed from: L */
    private static  String f2676L = "INMOBI_BIDDING";

    /* renamed from: M */
    private static  String f2677M = "MAIO_NETWORK";

    /* renamed from: N */
    private static  String f2678N = "MAIO_BIDDING";

    /* renamed from: O */
    private static  String f2679O = "MYTARGET_NETWORK";

    /* renamed from: P */
    private static  String f2680P = "MYTARGET_BIDDING";

    /* renamed from: Q */
    private static  String f2681Q = "NEND_NETWORK";

    /* renamed from: R */
    private static  String f2682R = "NEND_BIDDING";

    /* renamed from: S */
    private static  String f2683S = "OGURY_NETWORK";

    /* renamed from: T */
    private static  String f2684T = "OGURY_BIDDING";

    /* renamed from: U */
    private static  String f2685U = "TIKTOK_NETWORK";

    /* renamed from: V */
    private static  String f2686V = "TIKTOK_BIDDING";

    /* renamed from: W */
    private static  String f2687W = "SMAATO_NETWORK";

    /* renamed from: X */
    private static  String f2688X = "SMAATO_BIDDING";

    /* renamed from: Y */
    private static  String f2689Y = "SNAP_NETWORK";

    /* renamed from: Z */
    private static  String f2690Z = "SNAP_BIDDING";

    /* renamed from: a */
    public static  String f2691a = "/mediate";

    /* renamed from: aa */
    private static  String f2692aa = "TAPJOY_NETWORK";

    /* renamed from: ab */
    private static  String f2693ab = "TAPJOY_BIDDING";

    /* renamed from: ac */
    private static  String f2694ac = "VERIZON_NETWORK";

    /* renamed from: ad */
    private static  String f2695ad = "VERIZON_BIDDING";
    public static TreeMap<String, AdNetworkDiscovery> adNetworkDiscoveries = new TreeMap<>();

    /* renamed from: ae */
    private static  String f2696ae = "YANDEX_NETWORK";

    /* renamed from: af */
    private static  String f2697af = "YANDEX_BIDDING";

    /* renamed from: ag */
    private static ConcurrentHashMap<String, ConcurrentHashMap<BrandSafetyUtils.AdType, C1302a>> f2698ag = new ConcurrentHashMap<>();

    /* renamed from: ah */
    private static ConcurrentHashMap<String, LinkedHashMap<String, C1303b>> f2699ah = new ConcurrentHashMap<>();

    /* renamed from: ai */
    private static ExecutorService f2700ai = Executors.newSingleThreadExecutor();

    /* renamed from: aj */
    private static boolean f2701aj = false;

    /* renamed from: b */
    public static  String f2702b = "ms.applovin.com";

    /* renamed from: c */
    public static  String f2703c = "ms.applvn.com";

    /* renamed from: d */
    public static  String f2704d = "@!1:ad_fetch@!";

    /* renamed from: e */
    private static  String f2705e = "CreativeInfoManager";

    /* renamed from: f */
    private static  String f2706f = "timestamp";

    /* renamed from: g */
    private static  String f2707g = "urls";

    /* renamed from: h */
    private static  List<String> f2708h = new ArrayList();

    /* renamed from: i */
    private static  String f2709i = "adIdToCreatives";

    /* renamed from: j */
    public static PersistentConcurrentHashMap<String, CreativeInfo> f2710j = null;

    /* renamed from: k */
    private static  String f2711k = "contentHashCodeToCreatives";

    /* renamed from: l */
    public static PersistentConcurrentHashMap<Integer, CreativeInfo> f2712l = null;

    /* renamed from: m */
    private static  String f2713m = "webviewAddressToCreatives";

    /* renamed from: n */
    public static PersistentConcurrentHashMap<String, CreativeInfo> f2714n = null;

    /* renamed from: o */
    private static  Map<String, String> f2715o = new HashMap();

    /* renamed from: p */
    private static  String f2716p = "APPLOVIN_NETWORK";

    /* renamed from: q */
    private static  String f2717q = "IRONSOURCE_NETWORK";

    /* renamed from: r */
    private static  String f2718r = "IRONSOURCE_BIDDING";

    /* renamed from: s */
    private static  String f2719s = "VUNGLE_NETWORK";

    /* renamed from: t */
    private static  String f2720t = "VUNGLE_BIDDING";

    /* renamed from: u */
    private static  String f2721u = "UNITY_NETWORK";

    /* renamed from: v */
    private static  String f2722v = "UNITY_BIDDING";

    /* renamed from: w */
    private static  String f2723w = "ADMOB_NETWORK";

    /* renamed from: x */
    private static  String f2724x = "ADMOB_BIDDING";

    /* renamed from: y */
    private static  String f2725y = "MINTEGRAL_NETWORK";

    /* renamed from: z */
    private static  String f2726z = "MINTEGRAL_BIDDING";

    private static void init() {
        //   adNetworkDiscoveries.put(C1357d.f3603k, new C1312b());
        //  adNetworkDiscoveries.put(C1357d.f3593a, new C1313c());
    }

    static {
        try {
            m3109i();
            m3107h();
            init();
        } catch (Throwable th) {
            Logger.m3604e(f2705e, "Error initializing CreativeInfoManager ", th);
        }
    }

    /* renamed from: a */
    public static int m3057a() {
        return f2710j.size();
    }

    public static Bundle m3105g(String str) {
        return null;
    }

    public static AdNetworkDiscovery m3103f(String str) {
        return null;
    }

    public static boolean m3091b(String sdkPackageByClass, boolean b) {
        return false;
    }



    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager$a */
    private static class C1302a {

        /* renamed from: a */
        ArrayList<CreativeInfo> f2777a = new ArrayList<>();

        /* renamed from: b */
        CreativeInfo f2778b;

        private C1302a() {
        }
    }

    /* renamed from: a */
    public static void m3079a(String str, String str2, String str3, Map<String, List<String>> map, C1313c.C1314a aVar) {
        Logger.m3601d(f2705e, "handlePrefetch started, networkName=" + str + ", url=" + str2 + ", prefetch=" + str3);
        String b = m3083b(str);
        if (b == null) {
            Logger.m3601d(f2705e, "sdkPackage is null, skipping");
        } else if (m3102e(str2) || str2.equals(f2704d)) {
            Bundle g = m3105g(b);
            if (g != null) {
                Logger.m3601d(f2705e, "sdk " + b + " config item CONFIGURATION_SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN is " + g.getBoolean(AdNetworkDiscovery.f2644a));
                if (g.getBoolean(AdNetworkDiscovery.f2644a)) {
                    m3096c(b, str2, str3, map, aVar);
                } else {
                    Logger.m3601d(f2705e, "sdkPackage is not supported");
                }
            } else {
                Logger.m3601d(f2705e, "sdkPackage does not exist");
            }
        } else {
            Logger.m3601d(f2705e, "Url is not a mediation url, skipping");
        }
    }

    public static boolean m3102e(String str2) {
        return false;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager$b */
    private static class C1303b {

        /* renamed from: a */
        ArrayList<String> f2779a = new ArrayList<>();

        /* renamed from: b */
        long f2780b;

        private C1303b() {
        }
    }

    /* renamed from: h */
    private static void m3107h() {
        try {
            f2710j = new PersistentConcurrentHashMap<>(f2709i);
            f2712l = new PersistentConcurrentHashMap<>(f2711k);
            f2714n = new PersistentConcurrentHashMap<>(f2713m);
        } catch (InvalidParameterException e) {
            Logger.m3604e(f2705e, "Error initializing CreativeInfoManager class, ads caching will not be available", e);
        }
    }

    /* renamed from: b */
    public static void m3084b() {
     /*   adNetworkDiscoveries.put(C1357d.f3596d, new i());
        adNetworkDiscoveries.put(C1357d.f3593a, new C1313c());
        adNetworkDiscoveries.put(C1357d.f3599g, new f());
        adNetworkDiscoveries.put(C1357d.f3613u, new FyberDiscovery());
        adNetworkDiscoveries.put(C1357d.f3605m, new e());
        adNetworkDiscoveries.put(C1357d.f3594b, new a());
        adNetworkDiscoveries.put(C1357d.f3608p, new h());*/
    }

    /* renamed from: i */
    private static void m3109i() {
        f2715o.put(f2716p, C1357d.f3593a);
        f2715o.put(f2717q, C1357d.f3599g);
        f2715o.put(f2718r, C1357d.f3599g);
        f2715o.put(f2719s, C1357d.f3596d);
        f2715o.put(f2720t, C1357d.f3596d);
        f2715o.put(f2721u, C1357d.f3608p);
        f2715o.put(f2722v, C1357d.f3608p);
        f2715o.put(f2723w, C1357d.f3603k);
        f2715o.put(f2724x, C1357d.f3603k);
        f2715o.put(f2725y, C1357d.f3612t);
        f2715o.put(f2726z, C1357d.f3612t);
        f2715o.put(f2665A, C1357d.f3613u);
        f2715o.put(f2666B, C1357d.f3613u);
        f2715o.put(f2667C, C1357d.f3594b);
        f2715o.put(f2668D, C1357d.f3594b);
        f2715o.put(f2671G, C1357d.f3595c);
        f2715o.put(f2672H, C1357d.f3595c);
        f2715o.put(f2669E, C1357d.f3614v);
        f2715o.put(f2670F, C1357d.f3614v);
        f2715o.put(f2673I, C1357d.f3603k);
        f2715o.put(f2674J, C1357d.f3603k);
        f2715o.put(f2675K, C1357d.f3605m);
        f2715o.put(f2676L, C1357d.f3605m);
        f2715o.put(f2677M, C1357d.f3615w);
        f2715o.put(f2678N, C1357d.f3615w);
        f2715o.put(f2679O, C1357d.f3616x);
        f2715o.put(f2680P, C1357d.f3616x);
        f2715o.put(f2681Q, C1357d.f3617y);
        f2715o.put(f2682R, C1357d.f3617y);
        f2715o.put(f2683S, C1357d.f3618z);
        f2715o.put(f2684T, C1357d.f3618z);
        f2715o.put(f2685U, C1357d.f3588A);
        f2715o.put(f2686V, C1357d.f3588A);
        f2715o.put(f2687W, C1357d.f3589B);
        f2715o.put(f2688X, C1357d.f3589B);
        f2715o.put(f2689Y, C1357d.f3590C);
        f2715o.put(f2690Z, C1357d.f3590C);
        f2715o.put(f2692aa, C1357d.f3606n);
        f2715o.put(f2693ab, C1357d.f3606n);
        f2715o.put(f2694ac, C1357d.f3591D);
        f2715o.put(f2695ad, C1357d.f3591D);
        f2715o.put(f2696ae, C1357d.f3592E);
        f2715o.put(f2697af, C1357d.f3592E);
    }

    /* renamed from: a */
    public static AdNetworkDiscovery.WebViewResourceMatchingMethod m3060a(String str) {
        AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
        if (adNetworkDiscovery == null) {
            return null;
        }
        return adNetworkDiscovery.mo19300b();
    }

    /* renamed from: b */
    public static String m3083b(String str) {
        String str2 = f2715o.get(str);
        Logger.m3601d(f2705e, "translateNetworkNameToPackageName for " + str + ", is " + str2 + ", adNetworkDiscoveries " + adNetworkDiscoveries.keySet() + " , maxNetworkNameToPackage=" + f2715o.toString());
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return null;
    }

    /* renamed from: a */
    public static void m3081a(boolean z) {
        f2701aj = z;
        Logger.m3601d(f2705e, "setting active mode to " + z);
    }

    public static WebResourceResponse onWebViewResponse(String sdkPackageName, String url, WebResourceResponse response) {
        Logger.m3601d(f2705e, "onWebViewResponse " + sdkPackageName + " url " + url);
        return m3058a(sdkPackageName, url, response);
    }

    public static WebResourceResponse onWebViewResponseWithHeaders(String sdkPackageName, WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse response) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                String uri = webResourceRequest.getUrl().toString();
                Logger.m3601d(f2705e, "onWebViewResponseWithHeaders " + sdkPackageName + " url " + uri);
                if (webResourceRequest == null || webResourceRequest.getRequestHeaders() == null) {
                    Logger.m3601d(f2705e, "onWebViewResponseWithHeaders webResourceRequest is null");
                } else if (webResourceRequest != null && webResourceRequest.getRequestHeaders() != null && webResourceRequest.getRequestHeaders().size() > 0 && webResourceRequest.getRequestHeaders().containsKey(C1361h.f3647b)) {
                    Logger.m3601d(f2705e, "onWebViewResponseWithHeaders webResourceRequest Accept header value is " + webResourceRequest.getRequestHeaders().get(C1361h.f3647b));
                    if (!m3090b(adNetworkDiscoveries.get(sdkPackageName), sdkPackageName, webView, uri, webResourceRequest.getRequestHeaders())) {
                        C1308d.m3127a(sdkPackageName, webView, uri, (String) null, webResourceRequest.getRequestHeaders());
                    }
                }
            } else {
                Logger.m3601d(f2705e, "onWebViewResponseWithHeaders Android SDK version too low.");
            }
        } catch (Throwable th) {
        }
        return response;
    }

    /* renamed from: a */
    public static WebResourceResponse m3058a(String str, String str2, WebResourceResponse webResourceResponse) {
        Logger.m3601d(f2705e, "activeMode = " + f2701aj);
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "followWebViewResponseIfNeeded for " + str + ", url " + str2);
                AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
                if (adNetworkDiscovery != null && adNetworkDiscovery.mo19299a(str2)) {
                    if (webResourceResponse == null) {
                        webResourceResponse = new WebResourceResponse("text/javascript", XmpWriter.UTF8, new C1351f(str, str2, new URL(str2).openStream(), (Map<String, List<String>>) null, false));
                    } else {
                        webResourceResponse.setData(new C1351f(str, str2, webResourceResponse.getData(), (Map<String, List<String>>) null, false));
                    }
                    Logger.m3601d(f2705e, "following webView response " + str2 + " wrapping input stream in response: " + webResourceResponse);
                }
            }
        } catch (Throwable th) {
            Logger.m3603e(f2705e, th.getMessage());
        }
        return webResourceResponse;
    }

    /* renamed from: a */
    public static InputStream m3064a(String str, String str2, InputStream inputStream, Map<String, List<String>> map) {
        boolean z = false;
        try {
            Logger.m3601d(f2705e, "followInputStreamIfNeeded started for url " + str2);
            if (!f2701aj) {
                return inputStream;
            }
            Logger.m3601d(f2705e, "followInputStreamIfNeeded for " + str + ", url " + str2 + " adNetworkDiscoveries=" + adNetworkDiscoveries.keySet().toString());
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            Logger.m3601d(f2705e, "followInputStreamIfNeeded for " + str + ", discoveryObj=" + adNetworkDiscovery + " shouldFollowInputStream=" + (adNetworkDiscovery != null ? Boolean.valueOf(adNetworkDiscovery.mo19299a(str2)) : "null"));
            if (adNetworkDiscovery != null) {
                boolean f = adNetworkDiscovery.mo19310f(str2);
                boolean b = m3091b(str, false);
                Logger.m3601d(f2705e, "enforceCloseVIV value for sdk " + str + " is " + b + ", isVastInVastUrl returned " + f + " for url " + str2);
                boolean b2 = m3091b(str, false);
                Logger.m3601d(f2705e, "enforceClose value for sdk " + str + " is " + b2 + " for url " + str2);
                if (adNetworkDiscovery.mo19299a(str2)) {
                    Logger.m3601d(f2705e, "followInputStreamIfNeeded following input stream for url " + str2);
                }
                if (b2 || (b && f)) {
                    z = true;
                }
                return new C1351f(str, str2, inputStream, map, z);
            }
            Logger.m3601d(f2705e, "no discovery class for " + str + " or discovery class does not follow this url.");
            return inputStream;
        } catch (Throwable th) {
            return inputStream;
        }
    }


    /* renamed from: a */
/*
    public static BufferedSource m3059a(String str, String str2, BufferedSource bufferedSource, int i) {
        AdNetworkDiscovery adNetworkDiscovery;
        try {
            if (!f2701aj || (adNetworkDiscovery = adNetworkDiscoveries.get(str)) == null || !adNetworkDiscovery.mo19299a(str2)) {
                return bufferedSource;
            }
            Logger.m3601d(f2705e, "following source stream for url " + str2);
            return SafeDKSourceMintegral.create(bufferedSource, i);
        } catch (Throwable th) {
            Logger.m3604e(f2705e, th.getMessage(), th);
            new CrashReporter().caughtException(th);
            return bufferedSource;
        }
    }
*/

    /* renamed from: a */
    public static OutputStream m3065a(String str, String str2, OutputStream outputStream) {
        AdNetworkDiscovery adNetworkDiscovery;
        try {
            if (!f2701aj || (adNetworkDiscovery = adNetworkDiscoveries.get(str)) == null || !adNetworkDiscovery.mo19303b(str2)) {
                return outputStream;
            }
            Logger.m3601d(f2705e, "following output stream for url " + str2);
            return new C1352g(str, str2, outputStream);
        } catch (Throwable th) {
            return outputStream;
        }
    }

    /* renamed from: a */
    public static FileOutputStream m3063a(String str, String str2, FileOutputStream fileOutputStream) {
        try {
            if (!f2701aj) {
                return fileOutputStream;
            }
            Logger.m3601d(f2705e, "followOutputFileStreamIfNeeded " + str2 + ", stream " + fileOutputStream);
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery == null || !adNetworkDiscovery.mo19303b(str2)) {
                return fileOutputStream;
            }
            Logger.m3601d(f2705e, "following output stream for file path " + str2);
            return new C1350e(str, str2, fileOutputStream);
        } catch (Throwable th) {
            return fileOutputStream;
        }
    }

    /* renamed from: c */
    public static boolean m3097c(String str) {
        AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
        if (adNetworkDiscovery == null) {
            return false;
        }
        return adNetworkDiscovery.mo19298a();
    }

    public static void onResourceLoaded(String sdkPackageName, WebView webView, String resource) {
        String str = null;
        String str1 = null;
        try {
            if (f2701aj) {
                try {
                    str1 = URLDecoder.decode(resource, XmpWriter.UTF8);
                } catch (Throwable th) {
                    Logger.m3601d(f2705e, "onResourceLoaded failed url decoding " + resource);
                    str1 = resource;
                }
                 String j = BrandSafetyUtils.m2922j(webView.toString());
                Logger.m3601d(f2705e, "onResourceLoaded() sdk: " + sdkPackageName + ", webView: " + webView + " resource: " + str);
              //   AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(sdkPackageName);
                 String str2 = sdkPackageName;
                 WebView webView2 = webView;
                 String str3 = resource;
                f2700ai.execute(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0096 A[Catch:{ Throwable -> 0x00fe }] */
                    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d7 A[Catch:{ Throwable -> 0x00fe }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r7 = this;
                            r1 = 0
                            com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery r0 = r1     // Catch:{ Throwable -> 0x00fe }
                            if (r0 == 0) goto L_0x0111
                            com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery r0 = r1     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r2     // Catch:{ Throwable -> 0x00fe }
                            boolean r0 = r0.mo19306c(r2)     // Catch:{ Throwable -> 0x00fe }
                            if (r0 == 0) goto L_0x0111
                            com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery r0 = r1     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r2     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = r2     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r0.mo19292a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00fe }
                            if (r2 == 0) goto L_0x0111
                            java.lang.String r0 = "CreativeInfoManager"
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fe }
                            r3.<init>()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r4 = "adId = "
                            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r3 = r3.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.Logger.m3601d(r0, r3)     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.PersistentConcurrentHashMap r0 = com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.f2710j     // Catch:{ Throwable -> 0x00fe }
                            java.lang.Object r0 = r0.remove(r2)     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo r0 = (com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo) r0     // Catch:{ Throwable -> 0x00fe }
                            if (r0 == 0) goto L_0x0111
                            java.lang.String r1 = r0.mo19429p()     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType r3 = r0.mo19442v()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r4 = r3     // Catch:{ Throwable -> 0x00fe }
                            r0.mo19423m(r4)     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType r4 = com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.AdType.INTERSTITIAL     // Catch:{ Throwable -> 0x00fe }
                            if (r3 == r4) goto L_0x0054
                            com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType r4 = com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.AdType.BANNER     // Catch:{ Throwable -> 0x00fe }
                            if (r3 != r4) goto L_0x00a8
                        L_0x0054:
                            java.lang.String r4 = "CreativeInfoManager"
                            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fe }
                            r5.<init>()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r6 = "Ad identified, calling setCreativeInAdFinder, adType="
                            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r3 = r5.append(r3)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r5 = ", clickUrl="
                            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r5 = r0.mo19446x()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.C1361h.m3694b((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = "exact_resource"
                            com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.m3093c((com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo) r0, (java.lang.String) r3, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.PersistentConcurrentHashMap r2 = com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.f2712l     // Catch:{ Throwable -> 0x00fe }
                            r0.mo19399b((java.util.Map<java.lang.Integer, com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo>) r2)     // Catch:{ Throwable -> 0x00fe }
                            r0 = r1
                        L_0x0087:
                            com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery r1 = r1     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r4     // Catch:{ Throwable -> 0x00fe }
                            android.webkit.WebView r3 = r5     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r4 = r6     // Catch:{ Throwable -> 0x00fe }
                            r5 = 0
                            boolean r1 = com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.m3090b((com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery) r1, (java.lang.String) r2, (android.webkit.WebView) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ Throwable -> 0x00fe }
                            if (r1 != 0) goto L_0x00d7
                            java.lang.String r1 = "CreativeInfoManager"
                            java.lang.String r2 = "Calling ResourceUrlFilter.handleResourceUrlLoaded"
                            com.example.safesdk.sample.utils.Logger.m3601d(r1, r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r1 = r4     // Catch:{ Throwable -> 0x00fe }
                            android.webkit.WebView r2 = r5     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = r2     // Catch:{ Throwable -> 0x00fe }
                            r4 = 0
                            com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d.m3127a(r1, r2, r3, r0, r4)     // Catch:{ Throwable -> 0x00fe }
                        L_0x00a7:
                            return
                        L_0x00a8:
                            java.lang.String r3 = "CreativeInfoManager"
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fe }
                            r4.<init>()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r5 = "Linking adId "
                            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r4 = " to web view "
                            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r4 = r3     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.Logger.m3601d(r3, r2)     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.PersistentConcurrentHashMap r2 = com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.f2714n     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r3 = r3     // Catch:{ Throwable -> 0x00fe }
                            r2.put(r3, r0)     // Catch:{ Throwable -> 0x00fe }
                            r0 = r1
                            goto L_0x0087
                        L_0x00d7:
                            java.lang.String r0 = "CreativeInfoManager"
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00fe }
                            r1.<init>()     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = "shouldHandleResourceAttachment returned true , not Calling ResourceUrlFilter.handleResourceUrlLoaded. sdkPackageName="
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r4     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = ", resource="
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r2 = r6     // Catch:{ Throwable -> 0x00fe }
                            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x00fe }
                            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x00fe }
                            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)     // Catch:{ Throwable -> 0x00fe }
                            goto L_0x00a7
                        L_0x00fe:
                            r0 = move-exception
                            com.example.safesdk.sample.analytics.reporters.CrashReporter r1 = new com.example.safesdk.sample.analytics.reporters.CrashReporter
                            r1.<init>()
                            r1.caughtException(r0)
                            java.lang.String r1 = "CreativeInfoManager"
                            java.lang.String r0 = r0.getMessage()
                            com.example.safesdk.sample.utils.Logger.m3603e(r1, r0)
                            goto L_0x00a7
                        L_0x0111:
                            r0 = r1
                            goto L_0x0087
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.C12871.run():void");
                    }
                });
                return;
            }
            return;
        } catch (Throwable th2) {
        }
        str = str1;
      //  Logger.m3604e(f2705e, th.getMessage(), th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3069a(File r7, File r8) throws IOException {
        /*
            r2 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0027 }
            r0.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0027 }
            java.nio.channels.FileChannel r1 = r0.getChannel()     // Catch:{ FileNotFoundException -> 0x0027 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0062 }
            r0.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0062 }
            java.nio.channels.FileChannel r6 = r0.getChannel()     // Catch:{ FileNotFoundException -> 0x0062 }
        L_0x0013:
            r2 = 0
            long r4 = r1.size()     // Catch:{ Throwable -> 0x002e }
            r1.transferTo(r2, r4, r6)     // Catch:{ Throwable -> 0x002e }
            if (r1 == 0) goto L_0x0021
            r1.close()
        L_0x0021:
            if (r6 == 0) goto L_0x0026
            r6.close()
        L_0x0026:
            return
        L_0x0027:
            r0 = move-exception
            r1 = r2
        L_0x0029:
            r0.printStackTrace()
            r6 = r2
            goto L_0x0013
        L_0x002e:
            r0 = move-exception
            java.lang.String r2 = "CreativeInfoManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r3.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "Exception in copyFile :"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0056 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0056 }
            com.example.safesdk.sample.utils.Logger.m3602d(r2, r3, r0)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            if (r6 == 0) goto L_0x0026
            r6.close()
            goto L_0x0026
        L_0x0056:
            r0 = move-exception
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            if (r6 == 0) goto L_0x0061
            r6.close()
        L_0x0061:
            throw r0
        L_0x0062:
            r0 = move-exception
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.m3069a(java.io.File, java.io.File):void");
    }

    /* renamed from: d */
    public static String m3099d(String str) {
        SafeDK.getInstance().mo19137g();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (FileNotFoundException e) {
            Logger.m3604e(f2705e, "Exception reading file " + str, e);
        } catch (IOException e2) {
            Logger.m3604e(f2705e, "Exception reading file " + str, e2);
        }
        return sb.toString();
    }

    public static void onWebViewPageFinished(String sdkPackage, WebView webView, String url) {
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "onWebViewPageFinished, WebView : " + webView.toString() + ", url " + url);
                if (adNetworkDiscoveries.get(sdkPackage) != null) {
                    Logger.m3601d(f2705e, "Will add js interface and scripts (if necessary) for WebView : " + webView.toString() + " for url " + url);
                    SafeDKWebAppInterface.m3504a(sdkPackage, webView, url);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f2705e, "Exception in onWebViewPageFinished : " + th.getMessage(), th);
        }
    }

    public static void onMaxAdViewCreated(MaxAdView maxAdView, MaxAdFormat adFormat) {
        Logger.m3601d(f2705e, "onMaxAdViewCreated maxAdView: " + maxAdView + " adFormat: " + adFormat);
        if (maxAdView != null && adFormat != null) {
            if (adFormat == MaxAdFormat.BANNER || adFormat == MaxAdFormat.LEADER) {
                BannerFinder.m2838a(maxAdView);
            }
        }
    }

    /* renamed from: b */
    public static boolean m3090b(AdNetworkDiscovery adNetworkDiscovery, String str, WebView webView, String str2, Map<String, String> map) {
        Logger.m3601d(f2705e, "shouldHandleResourceAttachment started sdkPackageName=" + str + ", resource=" + str2 + ", headers=" + (map != null ? map.toString() : "null"));
        if (adNetworkDiscovery == null) {
            return false;
        }
        AdNetworkDiscovery.WebViewResourceMatchingMethod b = adNetworkDiscovery.mo19300b();
        Logger.m3601d(f2705e, "WebViewResourceMatchingMethod is " + b.name());
        if (b == AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO) {
            String e = adNetworkDiscovery.mo19309e(str2);
            if (e != null) {
                CreativeInfo creativeInfo = (CreativeInfo) f2710j.get(e);
                if (creativeInfo == null) {
                    Logger.m3601d(f2705e, "resource matching: no adId for " + e);
                    if (SafeDK.getInstance() != null) {
                        C1284a r = SafeDK.getInstance().mo19148r();
                        if (r == null) {
                            r = SafeDK.getInstance().mo19149s();
                        }
                        if (r != null) {
                            creativeInfo = r.mo19211a(str, e);
                        }
                    }
                }
                if (creativeInfo != null) {
                    Logger.m3601d(f2705e, "attaching resource for adId " + e);
                    if (C1308d.m3132a(str, str2, map)) {
                        creativeInfo.mo19376a(str2);
                    } else if (C1308d.m3131a(str, str2)) {
                        Logger.m3601d(f2705e, "WebView resource discarded (should not be added to dsp domains). resource = " + str2);
                    }
                }
            } else {
                Logger.m3601d(f2705e, "Discarding " + str2);
            }
        } else if (b != AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP) {
            return false;
        } else {
            C1308d.m3128a(str, webView, str2, map);
        }
        return true;
    }

    /* renamed from: a */
    public static void m3078a( String str,  String str2,  String str3,  Map<String, List<String>> map) {
        try {
            if (f2701aj) {
                if (C1361h.m3724v(str2)) {
                    Logger.m3601d(f2705e, "onAdFetched package: " + str + " url: " + str2 + " , content size=" + str3.length());
                } else {
                    C1361h.m3694b(f2705e, "onAdFetched package: " + str + " url: " + str2 + " , content size=" + str3.length() + "\nvalue: " + str3);
                }
                if (C1357d.f3613u.equals(str)) {
                    new Thread(new Runnable() {
                        public void run() {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onAdFetched Runnable started " + str + " url: " + str2);
                            CreativeInfoManager.m3096c(str, str2, str3, map, (C1313c.C1314a) null);
                        }
                    }).start();
                } else {
                    f2700ai.execute(new Runnable() {
                        public void run() {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onAdFetched ExecutorService started " + str + " url: " + str2);
                            CreativeInfoManager.m3096c(str, str2, str3, map, (C1313c.C1314a) null);
                        }
                    });
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public static void m3096c(String str, String str2, String str3, Map<String, List<String>> map, C1313c.C1314a aVar) {
        try {
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery != null) {
                if (str3.length() > 204800 || str2.endsWith(".gif") || str2.endsWith(".mp4") || str2.endsWith(".jpg") || str2.endsWith(".jpeg")) {
                    Logger.m3601d(f2705e, "onAdFetchedImpl sdkPackageName: " + str + " url: " + str2 + " , content size=" + str3.length());
                } else {
                    C1361h.m3694b(f2705e, "onAdFetchedImpl sdkPackageName=" + str + ", originalUrl=" + str2 + " eventId = " + (aVar == null ? "" : aVar.f2898a) + ", value=" + str3);
                }
                long nanoTime = System.nanoTime();
                List<CreativeInfo> a = adNetworkDiscovery.mo19293a(str2, str3, map, aVar);
                Logger.m3601d(f2705e, "adNetworkDiscovery.generateInfo sdkPackageName " + str + " took " + ((System.nanoTime() - nanoTime) / 1000000) + " ms, number of CIs: " + (a != null ? a.size() : 0));
                if (a != null && a.size() > 0) {
                    for (CreativeInfo next : a) {
                        try {
                            Logger.m3601d(f2705e, "onAdFetchedImpl remove any information of a previously loaded ad with this id: " + next.mo19444w());
                            m3108h(next.mo19444w());
                        } catch (Throwable th) {
                        }
                        if (next.mo19441u()) {
                            Logger.m3601d(f2705e, "onAdFetchedImpl ci is empty");
                        } else {
                            Logger.m3601d(f2705e, "onAdFetchedImpl ci saved id=" + next.mo19444w() + ", videoUrl=" + next.mo19433r());
                            m3066a(next);
                        }
                    }
                    return;
                }
                return;
            }
            Logger.m3601d(f2705e, "no discovery object found for SDK " + str);
        } catch (Throwable th2) {
        }
    }

    /* renamed from: a */
    public static void m3066a(CreativeInfo creativeInfo) {
        if (creativeInfo == null || creativeInfo.mo19444w() == null) {
            Logger.m3601d(f2705e, "creative info is null or ci.getId() is null, cannot store it.");
            return;
        }
        f2710j.put(creativeInfo.mo19444w(), creativeInfo);
        if (creativeInfo.mo19396a((Map<Integer, CreativeInfo>) f2712l)) {
            Logger.m3601d(f2705e, "storing creative info with hashcode: " + creativeInfo.mo19384C() + ", CI: " + creativeInfo);
        } else {
            Logger.m3601d(f2705e, "creative info content hashcode is null, cannot store it.");
        }
    }

    /* renamed from: a */
    public static void m3076a( String str,  String str2,  String str3,  String str4) {
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "onDataLoadedToWebView " + str3 + " package: " + str4 + " baseUrl: " + str + ", content size is " + str2.length());
                f2700ai.execute(new Runnable() {
                    public void run() {
                        CreativeInfo creativeInfo;
                        try {
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str4);
                            if (adNetworkDiscovery != null) {
                                String str = null;
                                if (str != null) {
                                    str = adNetworkDiscovery.mo19292a(str2, str);
                                }
                                Logger.m3601d(CreativeInfoManager.f2705e, "onDataLoadedToWebView adId " + str);
                                String j = BrandSafetyUtils.m2922j(str3);
                                if (str != null) {
                                    creativeInfo = (CreativeInfo) CreativeInfoManager.f2710j.remove(str);
                                    Logger.m3601d(CreativeInfoManager.f2705e, "onDataLoadedToWebView adId " + str + " ci " + creativeInfo.toString());
                                    if (creativeInfo != null && (creativeInfo.mo19442v() == BrandSafetyUtils.AdType.INTERSTITIAL || creativeInfo.mo19442v() == BrandSafetyUtils.AdType.BANNER)) {
                                        CreativeInfoManager.m3093c(creativeInfo, CreativeInfo.f2982l, str);
                                        creativeInfo.mo19423m(j);
                                        return;
                                    }
                                } else {
                                    int d = adNetworkDiscovery.mo19307d(str2);
                                    Logger.m3601d(CreativeInfoManager.f2705e, String.format("Trying to match by hashcode: %s .contentHashCodeToCreatives size: %s", new Object[]{Integer.valueOf(d), Integer.valueOf(CreativeInfoManager.f2712l.size())}));
                                    if (d == 0) {
                                        Logger.m3601d(CreativeInfoManager.f2705e, "hashcode 0, with value: " + str2);
                                    }
                                    creativeInfo = (CreativeInfo) CreativeInfoManager.f2712l.get(Integer.valueOf(d));
                                }
                                if (creativeInfo != null) {
                                    Logger.m3601d(CreativeInfoManager.f2705e, "onDataLoadedToWebView getting Base64 resources");
                                    ArrayList<String> f = C1361h.m3708f(str2);
                                    if (f != null && f.size() > 0) {
                                        creativeInfo.mo19393a(f);
                                    }
                                    creativeInfo.mo19423m(j);
                                    if (creativeInfo.mo19442v().equals(BrandSafetyUtils.AdType.INTERSTITIAL) || creativeInfo.mo19442v().equals(BrandSafetyUtils.AdType.BANNER)) {
                                        CreativeInfoManager.m3085b(creativeInfo, CreativeInfo.f2980j, creativeInfo.mo19384C());
                                        return;
                                    }
                                    if (TextUtils.isEmpty(j)) {
                                        Logger.m3601d(CreativeInfoManager.f2705e, "webview address is empty - can't link creative info to webview");
                                    }
                                    Logger.m3601d(CreativeInfoManager.f2705e, "Linking " + creativeInfo.mo19384C() + " to web view " + j);
                                    CreativeInfoManager.f2714n.put(j, creativeInfo);
                                }
                            }
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3603e(CreativeInfoManager.f2705e, th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m3071a( String str,  FileInputStream fileInputStream,  String str2) {
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "onFileInputStreamCompleted " + str + " , " + str2);
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                adNetworkDiscovery.mo19295a(fileInputStream, str2);
                            } else {
                                Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object for SDK " + str);
                            }
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3603e(CreativeInfoManager.f2705e, th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m3075a( String str,  String str2,  String str3) {
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "onFileOutputStreamCompleted " + str + " , " + str2);
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                adNetworkDiscovery.mo19302b(str2, str3);
                            } else {
                                Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object for SDK " + str);
                            }
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3604e(CreativeInfoManager.f2705e, th.getMessage(), th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public static void m3088b( String str,  String str2,  String str3) {
        try {
            if (f2701aj) {
                Logger.m3601d(f2705e, "handleOutputStream " + str + " , " + str3);
                f2700ai.execute(new Runnable() {
                    public void run() {
                        CreativeInfo creativeInfo;
                        try {
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                String c = adNetworkDiscovery.mo19304c(str2, str3);
                                if (c != null && (creativeInfo = (CreativeInfo) CreativeInfoManager.f2710j.remove(c)) != null) {
                                    if (creativeInfo.mo19442v() == BrandSafetyUtils.AdType.INTERSTITIAL || creativeInfo.mo19442v() == BrandSafetyUtils.AdType.BANNER) {
                                        CreativeInfoManager.m3093c(creativeInfo, CreativeInfo.f2983m, c);
                                        Logger.m3601d(CreativeInfoManager.f2705e, "handleOutputStream setCreativeInAdFinder called ci : " + creativeInfo.toString());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Logger.m3601d(CreativeInfoManager.f2705e, "handleOutputStream no discovery object for SDK " + str);
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3604e(CreativeInfoManager.f2705e, th.getMessage(), th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static CreativeInfo m3061a(String str, String str2) {
        try {
            CreativeInfo remove = f2714n.remove(str2);
            if (remove == null) {
                return remove;
            }
            if (remove.mo19444w() != null) {
                f2710j.remove(remove.mo19444w());
            }
            remove.mo19399b((Map<Integer, CreativeInfo>) f2712l);
            return remove;
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: c */
    private static void m3095c( String str,  String str2,  String str3) {
        try {
            if (f2701aj) {
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                String a = adNetworkDiscovery.mo19292a(str3, str2);
                                if (a != null) {
                                    Logger.m3601d(CreativeInfoManager.f2705e, "adId = " + a);
                                    CreativeInfo creativeInfo = (CreativeInfo) CreativeInfoManager.f2710j.remove(a);
                                    if (creativeInfo != null) {
                                        Logger.m3601d(CreativeInfoManager.f2705e, "clickUrl = " + creativeInfo.mo19446x());
                                        if (creativeInfo.mo19442v() == BrandSafetyUtils.AdType.INTERSTITIAL || creativeInfo.mo19442v() == BrandSafetyUtils.AdType.BANNER) {
                                            CreativeInfoManager.m3093c(creativeInfo, CreativeInfo.f2982l, a);
                                            creativeInfo.mo19399b((Map<Integer, CreativeInfo>) CreativeInfoManager.f2712l);
                                            return;
                                        }
                                        return;
                                    }
                                    Logger.m3601d(CreativeInfoManager.f2705e, "no pre-fetched data for adId");
                                    return;
                                }
                                return;
                            }
                            Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object for SDK " + str);
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3603e(CreativeInfoManager.f2705e, th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m3074a( String str,  String str2,  BrandSafetyEvent.AdFormatType adFormatType) {
        try {
            if (f2701aj) {
                f2700ai.execute(new Runnable() {
                    public void run() {
                        String a;
                        try {
                            Logger.m3601d(CreativeInfoManager.f2705e, "handleShowAdByApi sdkPackageName = " + str + ", message: " + str2 + ", adFormatType=" + adFormatType);
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null && (a = adNetworkDiscovery.mo19292a(str2, str2)) != null) {
                                Logger.m3601d(CreativeInfoManager.f2705e, "handleShowAdByApi adId = " + a);
                                CreativeInfo creativeInfo = (CreativeInfo) CreativeInfoManager.f2710j.remove(a);
                                if (creativeInfo == null) {
                                    Logger.m3601d(CreativeInfoManager.f2705e, "no ci for adId");
                                } else if (adFormatType.equals(BrandSafetyEvent.AdFormatType.INTER) || adFormatType.equals(BrandSafetyEvent.AdFormatType.BANNER)) {
                                    CreativeInfoManager.m3093c(creativeInfo, CreativeInfo.f2983m, a);
                                }
                            }
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3603e(CreativeInfoManager.f2705e, th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static CreativeInfo m3062a(String str, Set<String> set) {
        try {
            if (!f2701aj) {
                return null;
            }
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery != null) {
                Pair<String, List<String>> a = adNetworkDiscovery.mo19290a(set);
                if (a != null) {
                    String str2 = (String) a.first;
                    List list = (List) a.second;
                    Collections.sort(list);
                    Logger.m3601d(f2705e, "adId = " + str2);
                    CreativeInfo remove = f2710j.remove(str2);
                    if (remove != null) {
                        remove.mo19394a((List<String>) list);
                        Logger.m3601d(f2705e, "clickUrl = " + remove.mo19446x());
                        if (remove.mo19442v() != BrandSafetyUtils.AdType.INTERSTITIAL) {
                            return remove;
                        }
                        remove.mo19399b((Map<Integer, CreativeInfo>) f2712l);
                        return remove;
                    }
                    Logger.m3601d(f2705e, "no pre-fetched data for adId");
                }
            } else {
                Logger.m3601d(f2705e, "no discovery object for SDK " + str);
            }
            return null;
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            Logger.m3603e(f2705e, th.getMessage());
        }
        return null;
    }

    /* renamed from: b */
    public static void m3085b(CreativeInfo creativeInfo, String str, int i) {
        m3093c(creativeInfo, str, i + "");
    }

    /* renamed from: c */
    public static void m3093c(CreativeInfo creativeInfo, String str, String str2) {
        C1284a aVar = null;
        C1361h.m3694b(f2705e, "setCreativeInAdFinder started, ci=" + creativeInfo.toString());
        if (creativeInfo.mo19442v() == BrandSafetyUtils.AdType.INTERSTITIAL) {
            aVar = SafeDK.getInstance().mo19148r();
        } else if (creativeInfo.mo19442v() == BrandSafetyUtils.AdType.BANNER) {
            aVar = SafeDK.getInstance().mo19149s();
        }
        if (aVar != null) {
            Logger.m3601d(f2705e, "setCreativeInAdFinder updating ci " + aVar.mo19215a(new C1336i(creativeInfo, str, str2)) + ", matchingMethod=" + str + ", adId=" + creativeInfo.mo19444w() + ", adType=" + creativeInfo.mo19442v());
            return;
        }
        Logger.m3601d(f2705e, "setCreativeInAdFinder cannot update AdFinder");
    }

    /* renamed from: a */
    public static void m3068a(CreativeInfo creativeInfo, String str, String str2) {
        BannerFinder s = SafeDK.getInstance().mo19149s();
        if (s != null) {
            Logger.m3601d(f2705e, "setCreativeInBannerFinder updating ci " + s.mo19215a(new C1336i(creativeInfo, str, str2)) + ", matchingMethod=" + str + ", adId=" + creativeInfo.mo19444w());
        }
    }

    /* renamed from: c */
    public static void m3092c() {
        Logger.m3601d(f2705e, "request to stop take screenshots from current impression received");
        InterstitialFinder r = SafeDK.getInstance().mo19148r();
        if (r == null) {
            Logger.m3601d(f2705e, "InterstitialFinder is null, exiting");
        } else {
            r.mo19249c();
        }
    }

    /* renamed from: h */
    private static void m3108h(String str) {
        CreativeInfo remove = f2710j.remove(str);
        if (remove != null) {
            remove.mo19399b((Map<Integer, CreativeInfo>) f2712l);
            remove.mo19403c((Map<String, CreativeInfo>) f2714n);
        }
    }

    /* renamed from: a */
    public static void m3073a( String str,  Object obj,  Object obj2) {
        try {
            if (f2701aj) {
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onMediaPlayerSetDataSource " + obj + ", video file " + obj2);
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                adNetworkDiscovery.mo19296a(obj, obj2);
                            } else {
                                Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object found for SDK " + str);
                            }
                        } catch (Throwable th) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m3072a( String str,  Object obj) {
        try {
            if (f2701aj) {
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onMediaPlayerStart " + obj);
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                String b = adNetworkDiscovery.mo19301b(obj);
                                if (b != null) {
                                    CreativeInfo creativeInfo = (CreativeInfo) CreativeInfoManager.f2710j.remove(b);
                                    if (creativeInfo != null) {
                                        Logger.m3601d(CreativeInfoManager.f2705e, "calling setCreativeInAdFinder after MediaPlayer start called. video url: " + creativeInfo.mo19433r());
                                        CreativeInfoManager.m3093c(creativeInfo, CreativeInfo.f2981k, b);
                                        return;
                                    }
                                    Logger.m3601d(CreativeInfoManager.f2705e, "no ci for adId " + b + " after MediaPlayer.start called");
                                    return;
                                }
                                return;
                            }
                            Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object found for SDK " + str);
                        } catch (Throwable th) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static void m3070a( String str,  FileInputStream fileInputStream,  FileDescriptor fileDescriptor) {
        try {
            if (f2701aj) {
                f2700ai.execute(new Runnable() {
                    public void run() {
                        try {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onFileDescriptorCreated " + fileInputStream + ", FD " + fileDescriptor);
                            AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str);
                            if (adNetworkDiscovery != null) {
                                adNetworkDiscovery.mo19294a(fileInputStream, fileDescriptor);
                            } else {
                                Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object for SDK " + str);
                            }
                        } catch (Throwable th) {
                            new CrashReporter().caughtException(th);
                            Logger.m3603e(CreativeInfoManager.f2705e, th.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public static void m3087b( String str) {
        try {
            Logger.m3601d(f2705e, "onAdObjectReady started");
            if (f2701aj) {
               /* if (C1357d.f3613u.equals(str)) {
                    new Thread(new Runnable() {
                        public void run() {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onAdObjectReady Runnable started " + str + " adInstance: " + obj);
                            CreativeInfoManager.m3100d(str);
                        }
                    }).start();
                } else {
                    f2700ai.execute(new Runnable() {
                        public void run() {
                            Logger.m3601d(CreativeInfoManager.f2705e, "onAdObjectReady ExecutorService started " + str + " adInstance: " + obj);
                            CreativeInfoManager.m3100d(str, obj);
                        }
                    });
                }*/
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public static void m3100d(String str, Object obj) {
        try {
            Logger.m3601d(f2705e, "onAdObjectReadyImpl " + obj);
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery != null) {
                CreativeInfo a = adNetworkDiscovery.mo19291a(obj);
                if (a != null) {
                    if (BrandSafetyUtils.AdType.INTERSTITIAL.equals(a.mo19442v()) || BrandSafetyUtils.AdType.BANNER.equals(a.mo19442v())) {
                        Logger.m3601d(f2705e, "onAdObjectReadyImpl calling setCreativeInInterstitialFinder with " + a);
                        m3093c(a, CreativeInfo.f2984n, (String) null);
                    }
                    m3108h(a.mo19444w());
                    return;
                }
                Logger.m3601d(f2705e, "no CI returned.");
                return;
            }
            Logger.m3601d(f2705e, "onAdObjectReadyImpl no discovery object for SDK " + str);
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            Logger.m3603e(f2705e, th.getMessage());
        }
    }

    public static void onVideoCompleted(String sdkPackageName, Object mediaPlayer) {
        Logger.m3601d(f2705e, "onVideoCompleted sdkPackageName=" + sdkPackageName + ", mediaPlayer " + mediaPlayer);
        SafeDK instance = SafeDK.getInstance();
        if (instance != null && instance.mo19148r() != null) {
            instance.mo19148r().mo19248b();
        }
    }

    /* renamed from: a */
    public static void m3080a(String str, String str2, boolean z) {
        Logger.m3601d(f2705e, "onVideoCompleted sdkPackageName=" + str + ",webViewAddress=" + str2 + ", isCompleted=" + z);
        SafeDK instance = SafeDK.getInstance();
        if (instance != null && instance.mo19148r() != null) {
            Logger.m3601d(f2705e, "onVideoCompleted calling setOnVideoCompletedEventHasBeenTriggered");
            instance.mo19148r().mo19246a(str2, z);
        }
    }

    public static void onViewClicked(String sdkPackageName, View view) {
        if (view == null) {
            try {
                Logger.m3601d(f2705e, "onViewClicked sdkPackageName=" + sdkPackageName + ", view=null, exiting.");
            } catch (Throwable th) {
                Logger.m3604e(f2705e, "Exception in onViewClicked", th);
            }
        } else {
            Logger.m3601d(f2705e, "onViewClicked sdkPackageName=" + sdkPackageName + ", view.getId() = " + view.getId());
         /*   if (sdkPackageName.equals(C1357d.f3613u)) {
                int identifier = SafeDK.getInstance().mo19137g().getResources().getIdentifier("ia_tv_skip", FacebookMediationAdapter.KEY_ID, SafeDK.getInstance().mo19137g().getPackageName());
                int identifier2 = SafeDK.getInstance().mo19137g().getResources().getIdentifier("ia_iv_close_button", FacebookMediationAdapter.KEY_ID, SafeDK.getInstance().mo19137g().getPackageName());
                Logger.m3601d(f2705e, "onViewClicked ia_tv_skip resId=" + identifier + ", ia_iv_close_button resId=" + identifier2);
                if (view.getId() == identifier || view.getId() == identifier2) {
                    Logger.m3601d(f2705e, "onViewClicked view type is =" + view.getClass().getName());
                    if (view instanceof TextView) {
                        Logger.m3601d(f2705e, "onViewClicked Clicked the 'skip' TextView. Calling CreativeInfoManager.onVideoCompleted()");
                        onVideoCompleted(C1357d.f3613u, (Object) null);
                        return;
                    }
                    Logger.m3601d(f2705e, "onViewClicked Clicked view is not of type 'TextView'. exiting function");
                    return;
                }
                Logger.m3601d(f2705e, "onViewClicked Clicked view is not the 'skip' TextView.");
                return;
            }
            Logger.m3601d(f2705e, "onViewClicked Clicked view is not a TextView");*/
        }
    }

    public static boolean onViewTouched(String sdkPackageName, View view, MotionEvent motionEvent) {
        if (view == null) {
            try {
                Logger.m3601d(f2705e, "onViewTouched sdkPackageName=" + sdkPackageName + ", view=null, exiting.");
                return false;
            } catch (Throwable th) {
                Logger.m3604e(f2705e, "Exception in onViewTouched", th);
            }
        } else if (motionEvent.getAction() == 0 || motionEvent.getAction() == 11) {
            Logger.m3601d(f2705e, "onViewTouched sdkPackageName=" + sdkPackageName + ", view.getId() = " + view.getId() + ", motionEvent=" + motionEvent.toString());
         /*   if (sdkPackageName.equals(C1357d.f3613u)) {
                int identifier = SafeDK.getInstance().mo19137g().getResources().getIdentifier("ia_tv_skip", FacebookMediationAdapter.KEY_ID, SafeDK.getInstance().mo19137g().getPackageName());
                int identifier2 = SafeDK.getInstance().mo19137g().getResources().getIdentifier("ia_iv_close_button", FacebookMediationAdapter.KEY_ID, SafeDK.getInstance().mo19137g().getPackageName());
                Logger.m3601d(f2705e, "onViewTouched ia_tv_skip resId=" + identifier + ", ia_iv_close_button resId=" + identifier2);
                if (view.getId() == identifier || view.getId() == identifier2) {
                    Logger.m3601d(f2705e, "onViewTouched view type is =" + view.getClass().getName());
                    if (view instanceof TextView) {
                        Logger.m3601d(f2705e, "onViewTouched Clicked the 'skip' TextView. Calling CreativeInfoManager.onVideoCompleted()");
                        onVideoCompleted(C1357d.f3613u, (Object) null);
                    } else {
                        Logger.m3601d(f2705e, "onViewTouched Clicked view is not of type 'TextView'. exiting function");
                    }
                } else {
                    Logger.m3601d(f2705e, "onViewTouched Clicked view is not the 'skip' TextView.");
                }
            } else {
                Logger.m3601d(f2705e, "onViewTouched Clicked view is not a TextView");
            }*/
     /*       return true;
        } else {
            Logger.m3601d(f2705e, "onViewTouched sdkPackageName=" + sdkPackageName + ", MotionEvent=" + motionEvent.getAction() + ". exiting.");
            return false;
        }*/
        }

        /*    *//* renamed from: e *//*
    public static boolean m3102e(String str) {
        return (str.contains(f2691a) || str.contains(f2703c)) && str.contains(f2702b);
    }

    *//* renamed from: a *//*
    public static synchronized void m3077a(String str, String str2, String str3, String str4, String str5) {
        synchronized (CreativeInfoManager.class) {
            try {
                if (f2701aj) {
                    if (C1347b.getInstance().getForegroundActivity() == null) {
                        Logger.m3601d(f2705e, "updating creative info details from Max, current foreground activity is null, exiting");
                    } else {
                         String str6 = str;
                         String str7 = str2;
                         String str8 = str3;
                         String str9 = str5;
                         String str10 = str4;
                        C1347b.getInstance().getForegroundActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                Logger.m3601d(CreativeInfoManager.f2705e, "updating creative info details from Max, sdkPackageName=" + str6 + ", placementId=" + str7 + ", creativeId=" + str8 + ", adFormat=" + str9);
                                AdNetworkDiscovery adNetworkDiscovery = (AdNetworkDiscovery) CreativeInfoManager.adNetworkDiscoveries.get(str6);
                                if (adNetworkDiscovery != null) {
                                    adNetworkDiscovery.mo19297a(str7, str8, str10, str9);
                                } else {
                                    Logger.m3601d(CreativeInfoManager.f2705e, "no discovery object for SDK " + str6);
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    *//* renamed from: f *//*
    public static synchronized AdNetworkDiscovery m3103f(String str) {
        AdNetworkDiscovery adNetworkDiscovery;
        synchronized (CreativeInfoManager.class) {
            adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery != null) {
                Logger.m3601d(f2705e, "Discovery class for sdk " + str + " is " + adNetworkDiscovery.toString());
            } else {
                adNetworkDiscovery = null;
            }
        }
        return adNetworkDiscovery;
    }*/

        /* renamed from: g */
/*    public static synchronized Bundle m3105g(String str) {
        Bundle bundle;
        synchronized (CreativeInfoManager.class) {
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (adNetworkDiscovery != null) {
                bundle = adNetworkDiscovery.mo19308d();
            } else {
                bundle = null;
            }
        }
        return bundle;
    }

    *//* renamed from: b *//*
    public static synchronized boolean m3091b(String str, String str2, boolean z) {
        synchronized (CreativeInfoManager.class) {
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (!(adNetworkDiscovery == null || adNetworkDiscovery.mo19308d() == null || !adNetworkDiscovery.mo19308d().containsKey(str2))) {
                z = adNetworkDiscovery.mo19308d().getBoolean(str2);
            }
        }
        return z;
    }

    *//* renamed from: a *//*
    public static synchronized float m3056a(String str, String str2, float f) {
        synchronized (CreativeInfoManager.class) {
            AdNetworkDiscovery adNetworkDiscovery = adNetworkDiscoveries.get(str);
            if (!(adNetworkDiscovery == null || adNetworkDiscovery.mo19308d() == null || !adNetworkDiscovery.mo19308d().containsKey(str2))) {
                f = adNetworkDiscovery.mo19308d().getFloat(str2);
            }
        }
        return f;
    }*/
        return false;
    }
}

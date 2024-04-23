package com.example.safesdk.sample.analytics.brandsafety;

import static com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager.*;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;

import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.events.RedirectEvent;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.SdksMapping;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BrandSafetyUtils {
    private static  String INTERSTITIAL_ACTIVITIES = "Y29tLnZ1bmdsZS5wdWJsaXNoZXIuRmxleFZpZXdBZEFjdGl2aXR5fGNvbS52dW5nbGUucHVibGlzaGVyLlZpZGVvRnVsbFNjcmVlbkFkQWN0aXZpdHl8Y29tLmdvb2dsZS5hZHMuQWRBY3Rpdml0eXxjb20udW5pdHkzZC5hZHMuYWR1bml0LkFkVW5pdEFjdGl2aXR5fGNvbS5hcHBsb3Zpbi5hZHZpZXcuQXBwTG92aW5JbnRlcnN0aXRpYWxBY3Rpdml0eXxjb20udW5pdHkzZC5hZHMuYW5kcm9pZC52aWV3LlVuaXR5QWRzRnVsbHNjcmVlbkFjdGl2aXR5fGNvbS52dW5nbGUud2FycmVuLnVpLlZ1bmdsZUFjdGl2aXR5fGNvbS51bml0eTNkLnNlcnZpY2VzLmFkcy5hZHVuaXQuQWRVbml0U29mdHdhcmVBY3Rpdml0eXxjb20udnVuZ2xlLnB1Ymxpc2hlci5NcmFpZEZ1bGxTY3JlZW5BZEFjdGl2aXR5fGNvbS5nb29nbGUuYW5kcm9pZC5nbXMuYWRzLkFkQWN0aXZpdHl8Y29tLnVuaXR5M2Quc2VydmljZXMuYWRzLmFkdW5pdC5BZFVuaXRBY3Rpdml0eXxjb20uYXBwbG92aW4uaW1wbC5hZHZpZXcuQXBwTG92aW5PcmllbnRhdGlvbkF3YXJlSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLm1pbnRlZ3JhbC5tc2RrLnJld2FyZC5wbGF5ZXIuTVRHUmV3YXJkVmlkZW9BY3Rpdml0eXxjb20udW5pdHkzZC5hZHMuYWR1bml0LkFkVW5pdFNvZnR3YXJlQWN0aXZpdHl8Y29tLmlyb25zb3VyY2Uuc2RrLmNvbnRyb2xsZXIuSW50ZXJzdGl0aWFsQWN0aXZpdHl8Y29tLm1pbnRlZ3JhbC5tc2RrLmludGVyc3RpdGlhbC52aWV3Lk1UR0ludGVyc3RpdGlhbEFjdGl2aXR5fGNvbS5taW50ZWdyYWwubXNkay5pbnRlcmFjdGl2ZWFkcy5hY3Rpdml0eS5JbnRlcmFjdGl2ZVNob3dBY3Rpdml0eXxjb20ubWJyaWRnZS5tc2RrLnJld2FyZC5wbGF5ZXIuTUJSZXdhcmRWaWRlb0FjdGl2aXR5fGNvbS5tYnJpZGdlLm1zZGsuaW50ZXJzdGl0aWFsLnZpZXcuTUJJbnRlcnN0aXRpYWxBY3Rpdml0eXxjb20ubWJyaWRnZS5tc2RrLmludGVyYWN0aXZlYWRzLmFjdGl2aXR5LkludGVyYWN0aXZlU2hvd0FjdGl2aXR5fGNvbS52dW5nbGUucHVibGlzaGVyLkZ1bGxTY3JlZW5BZEFjdGl2aXR5fGNvbS5zdXBlcnNvbmljYWRzLnNkay5jb250cm9sbGVyLkludGVyc3RpdGlhbEFjdGl2aXR5fGNvbS5hcHBsb3Zpbi5hZHZpZXcuQXBwTG92aW5GdWxsc2NyZWVuQWN0aXZpdHl8Y29tLmZ5YmVyLmlubmVyYWN0aXZlLnNkay5hY3Rpdml0aWVzLklubmVyYWN0aXZlRnVsbHNjcmVlbkFkQWN0aXZpdHl8Y29tLnZ1bmdsZS53YXJyZW4udWkuVnVuZ2xlRmxleFZpZXdBY3Rpdml0eXxjb20uc3VwZXJzb25pY2Fkcy5zZGsuY29udHJvbGxlci5Db250cm9sbGVyQWN0aXZpdHl8Y29tLmlyb25zb3VyY2Uuc2RrLmNvbnRyb2xsZXIuQ29udHJvbGxlckFjdGl2aXR5fGNvbS5pbm1vYmkuYWRzLnJlbmRlcmluZy5Jbk1vYmlBZEFjdGl2aXR5fGNvbS5hZGNvbG9ueS5zZGsuQWRDb2xvbnlJbnRlcnN0aXRpYWxBY3Rpdml0eXxjb20uYWRjb2xvbnkuc2RrLkFkQ29sb255QWRWaWV3QWN0aXZpdHk=";

    /* renamed from: a */
    static  String f2491a = ".jpg";

    /* renamed from: b */
    static  String f2492b = ".txt";

    /* renamed from: c */
    static  String f2493c = "unknown";

    /* renamed from: d */
    static  String f2494d = "com.appsaholic";

    /* renamed from: e */
    static  int f2495e = 1000;

    /* renamed from: f */
    static  int f2496f = 500;

    /* renamed from: g */
    static  String f2497g = "com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL";

    /* renamed from: h */
    public static  int f2498h = 86400000;

    /* renamed from: i */
    private static  String f2499i = "BrandSafetyUtils";

    /* renamed from: j */
    private static Set<String> f2500j = new HashSet(Arrays.asList(new String(Base64.decode(INTERSTITIAL_ACTIVITIES, 0)).split("\\|")));

    /* renamed from: k */
    private static Set<String> f2501k = new HashSet(Arrays.asList(new String(Base64.decode("", 0)).split("\\|")));

    /* renamed from: l */
    private static Set<String> f2502l = new HashSet();

    /* renamed from: m */
    private static List<Integer> f2503m = new LinkedList();

    /* renamed from: n */
    private static  int f2504n = 100;

    /* renamed from: o */
    private static  int f2505o = 0;

    /* renamed from: p */
    private static  int f2506p = 8947848;

    /* renamed from: q */
    private static  float f2507q = 0.15f;

    /* renamed from: r */
    private static  float f2508r = 0.15f;

    /* renamed from: s */
    private static  float f2509s = 0.15f;

    /* renamed from: t */
    private static  float f2510t = 0.15f;

    /* renamed from: u */
    private static int f2511u = 0;

    /* renamed from: v */
    private static int f2512v = 0;

    public enum AdType {
        INTERSTITIAL,
        MEDIUMRECTANGLE,
        BANNER,
        NATIVE
    }

    public enum ScreenShotOrientation {
        NOT_INITIALIZED,
        PORTRAIT,
        LANDSCAPE
    }

    static {
        Logger.m3601d(f2499i, "BrandSafetyUtils initialized with " + f2500j + ",  INTERSTITIAL_ACTIVITIES=" + INTERSTITIAL_ACTIVITIES);
        Logger.m3601d(f2499i, "BrandSafetyUtils initialized with " + f2501k + ",  INTERNAL_BROWSER_ACTIVITIES=" + INTERSTITIAL_ACTIVITIES);
    }

    /* renamed from: a */
    public static void m2895a(String str) {
        f2501k.add(str);
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$b */
    static class C1278b implements FilenameFilter {
        C1278b() {
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(BrandSafetyUtils.f2491a);
        }
    }

    public static void detectAdClick(Intent intent, String sdkPackageName) {
        String str;
        try {
            if (SafeDK.getInstance().mo19141j()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Logger.m3601d(f2499i, "detectAdClick started , currentTimestamp (elapsed)=" + elapsedRealtime + ", sdk=" + sdkPackageName + ", intent=" + C1361h.m3672a(intent));
                if (SafeDK.getInstance().mo19143l()) {
                    Logger.m3601d(f2499i, "detectAdClick should monitor");
                    if (intent != null) {
                        Intent intent2 = (Intent) intent.clone();
                        Logger.m3601d(f2499i, "detectAdClick intent cloned");
                        int d = SafeDK.getInstance().mo19134d();
                        Logger.m3601d(f2499i, "Redirect Click Timeout is " + d);
                        String str2 = null;
                        try {
                            Uri data = intent2.getData();
                            String a = m2892a(sdkPackageName, intent2);
                            if (a != null) {
                                Logger.m3601d(f2499i, "detectAdClick uri extracted from intent extras");
                                data = Uri.parse(a);
                            }
                            if (data != null) {
                                if (C1361h.m3720r(data.toString())) {
                                    Logger.m3601d(f2499i, "detectAdClick Uri is a store url : " + data.toString());
                                    str2 = data.toString();
                                } else {
                                    URL url = new URL(data.toString());
                                    Logger.m3601d(f2499i, "detectAdClick Uri is a standard url : " + data.toString());
                                    str2 = url.toString();
                                }
                            }
                            str = str2;
                        } catch (MalformedURLException e) {
                            str = null;
                        }
                        if (!"android.intent.action.VIEW".equals(intent2.getAction()) || intent2.getData() == null) {
                            Logger.m3601d(f2499i, "detectAdClick Intent doesn't have url");
                            Activity foregroundActivity = C1347b.getInstance().getForegroundActivity();
                            if (foregroundActivity == null) {
                                Logger.m3601d(f2499i, "currentForegroundActivity is null");
                            } else if (f2501k.contains(foregroundActivity.getClass().getName())) {
                                Logger.m3601d(f2499i, "detectAdClick detected internal browser launch");
                                if (!m2901a(intent)) {
                                    Pair<Long, Long> a2 = DetectTouchUtils.m2948a(sdkPackageName);
                                    long longValue = a2 == null ? 0 : ((Long) a2.first).longValue();
                                    long longValue2 = a2 == null ? 0 : ((Long) a2.second).longValue();
                                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                    Logger.m3601d(f2499i, "detectAdClick currentElapsedRealtime = " + elapsedRealtime2 + ", webviewLastTouched=" + longValue + " ,currentElapsedRealtime - activityLastTouched=" + (elapsedRealtime2 - longValue));
                                    if (longValue == 0 || elapsedRealtime2 - longValue > ((long) d)) {
                                        Logger.m3601d(f2499i, "detectAdClick Redirecting through ad");
                                        m2896a(sdkPackageName, elapsedRealtime, longValue2, m2925m(sdkPackageName) ? RedirectEvent.f3286j : RedirectEvent.f3285i, str, foregroundActivity.getClass().getName());
                                    }
                                }
                            } else {
                                Logger.m3601d(f2499i, "Activity " + foregroundActivity.getClass().getName() + " is not in the redirect tracked activities, ignoring");
                            }
                        } else {
                            Logger.m3601d(f2499i, "detectAdClick has URL, url = " + intent2.getData().toString());
                            if (!m2901a(intent)) {
                                Logger.m3601d(f2499i, "detectAdClick not handled");
                                Activity foregroundActivity2 = C1347b.getInstance().getForegroundActivity();
                                if (foregroundActivity2 != null) {
                                    Logger.m3601d(f2499i, "detectAdClick has foreground");
                                    InterstitialFinder r = SafeDK.getInstance().mo19148r();
                                    C1335h e2 = r != null ? r.mo19253e() : null;
                                    if (r == null || e2 == null) {
                                        Logger.m3601d(f2499i, "detectAdClick no interstitial");
                                        BannerFinder s = SafeDK.getInstance().mo19149s();
                                        if (s != null) {
                                            Logger.m3601d(f2499i, "detectAdClick has banner");
                                            s.mo19217b(str, sdkPackageName);
                                        }
                                        Pair<Long, Long> a3 = DetectTouchUtils.m2948a(sdkPackageName);
                                        long longValue3 = a3 == null ? 0 : ((Long) a3.first).longValue();
                                        long longValue4 = a3 == null ? 0 : ((Long) a3.second).longValue();
                                        String a4 = C1338k.m3421a(sdkPackageName, longValue3);
                                        Logger.m3601d(f2499i, "detectAdClick lastTouchEvent(elapsed) = " + longValue3 + ", lastTouchEvent(currentTimeMillis) = " + longValue4 + ", redirectInfoKey=" + a4);
                                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                        Logger.m3601d(f2499i, "detectAdClick currentElapsedRealtime = " + elapsedRealtime3 + ", lastTouchEventTimestampElapsed=" + longValue3 + " ,currentElapsedRealtime - lastTouchEventTimestampElapsed=" + (elapsedRealtime3 - longValue3));
                                        if (!SafeDK.m2711b() || StatsCollector.m2806b().mo19192a(sdkPackageName, a4) || elapsedRealtime3 - longValue3 <= ((long) d)) {
                                            Logger.m3601d(f2499i, "Reporter thread not initialized or stats collector instance is null or redirect info does not exist, skipping");
                                        } else {
                                            m2896a(sdkPackageName, elapsedRealtime, longValue4, m2925m(sdkPackageName) ? RedirectEvent.f3286j : RedirectEvent.f3284h, str, foregroundActivity2.getClass().getName());
                                        }
                                    } else {
                                        Logger.m3601d(f2499i, "detectAdClick has interstitial");
                                        r.mo19217b(str, sdkPackageName);
                                        boolean f = e2.mo19274f();
                                        Logger.m3601d(f2499i, "detectAdClick clicked " + f);
                                        String a5 = m2893a(foregroundActivity2.getClass().getName(), true);
                                        Pair<Long, Long> a6 = DetectTouchUtils.m2948a(sdkPackageName);
                                        long longValue5 = a6 == null ? 0 : ((Long) a6.first).longValue();
                                        long longValue6 = a6 == null ? 0 : ((Long) a6.second).longValue();
                                        Logger.m3601d(f2499i, "detectAdClick lastTouchEvent(elapsed) = " + longValue5 + " lastTouchEvent(currentTimeMillis) = " + longValue6 + ", activityAddress=" + a5);
                                        String a7 = C1338k.m3421a(sdkPackageName, longValue5);
                                        boolean z = true;
                                        if (!SafeDK.m2711b() || !StatsCollector.m2806b().mo19192a(sdkPackageName, a7)) {
                                            Logger.m3601d(f2499i, "Reporter thread not initialized or stats collector instance is null or redirect info does not exist, skipping");
                                        } else {
                                            z = false;
                                        }
                                        Logger.m3601d(f2499i, "detectAdClick should handle click " + z);
                                        if (z) {
                                            long elapsedRealtime4 = SystemClock.elapsedRealtime();
                                            Logger.m3601d(f2499i, "detectAdClick currentElapsedRealtime = " + elapsedRealtime4 + ", activityLastTouched=" + longValue5 + " ,currentElapsedRealtime - activityLastTouched=" + (elapsedRealtime4 - longValue5) + " ,isClicked=" + f);
                                            if ((longValue5 == 0 || elapsedRealtime4 - longValue5 > ((long) d)) && !f) {
                                                Logger.m3601d(f2499i, "detectAdClick redirect");
                                                m2896a(sdkPackageName, elapsedRealtime, longValue6, m2925m(sdkPackageName) ? RedirectEvent.f3286j : RedirectEvent.f3284h, str, foregroundActivity2.getClass().getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.m3602d(f2499i, "error in detectAdClick", th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: a */
    private static String m2892a(String str, Intent intent) {
        Logger.m3601d(f2499i, "Attempting to extract url from intent extra, sdkPackageName is " + str + ", intent : " + C1361h.m3672a(intent));
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null || !C1357d.f3605m.equals(str) || !intent.getExtras().containsKey(f2497g)) {
                return null;
            }
            Logger.m3601d(f2499i, "found url in intent : " + intent.getExtras().getString(f2497g));
            return intent.getExtras().getString(f2497g);
        } catch (Throwable th) {
            Logger.m3603e(f2499i, "Exception when attempting to extract url from intent extra");
            return null;
        }
    }

    public static void detectAdClick(Uri uri, String sdkPackageName) {
        Logger.m3601d(f2499i, "detectAdClick Uri invoked, sdkPackageName=" + sdkPackageName + ", url = " + uri.toString());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(uri);
        detectAdClick(intent, sdkPackageName);
    }

    /* renamed from: a */
    private static boolean m2901a(Intent intent) {
        int identityHashCode = System.identityHashCode(intent);
        if (f2503m.contains(Integer.valueOf(identityHashCode))) {
            Logger.m3601d("detectAdClick", "markIntentAsHandled found " + identityHashCode);
            return true;
        }
        if (f2503m.size() >= 100) {
            Logger.m3601d("detectAdClick", "markIntentAsHandled > MAX events");
            f2503m.remove(0);
        }
        Logger.m3601d("detectAdClick", "markIntentAsHandled add " + identityHashCode);
        f2503m.add(Integer.valueOf(identityHashCode));
        return false;
    }

    /* renamed from: a */
    public static void m2898a(String str, String str2, WebView webView) {
        InterstitialFinder r;
        try {
            Logger.m3601d(f2499i, "Attach Loaded Url To Detected Click started , sdk=" + str + ", url=" + str2 + ",webview=" + webView.toString());
            if (str2.equals("about:blank") || str2.equals("About:blank")) {
                Logger.m3601d(f2499i, "url is blank, skipping");
                return;
            }
            if ((str2.startsWith("http://") || str2.startsWith("https://")) && (r = SafeDK.getInstance().mo19148r()) != null) {
                r.mo19216b(str2);
            }
            if (SafeDK.m2711b()) {
                ConcurrentHashMap<String, StatsEvent> a = StatsCollector.m2806b().mo19188a(StatsCollector.EventType.redirect);
                for (String str3 : a.keySet()) {
                    RedirectEvent redirectEvent = (RedirectEvent) a.get(str3);
                    if (redirectEvent.mo19547h().equals(str) && redirectEvent.mo19536f() == null) {
                        Logger.m3601d(f2499i, "Attaching url to url-less redirect event. event = " + redirectEvent.toString() + ", url = " + str2);
                        redirectEvent.mo19534a(str2);
                    }
                }
                return;
            }
            Logger.m3601d(f2499i, "Reporter thread not initialized or stats collector instance is null, skipping");
        } catch (Throwable th) {
            Logger.m3604e(f2499i, "failed to attach url to detected click (internal browser)", th);
        }
    }

    /* renamed from: a */
    static String m2887a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(byteArray, 0, byteArray.length);
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            Logger.m3604e(f2499i, "Failed to get hash value for bitmap", e);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063 A[SYNTHETIC, Splitter:B:16:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[SYNTHETIC, Splitter:B:21:0x006c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static String m2888a(Bitmap r5, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.AdType r6, String r7, String r8, String r9, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.ScreenShotOrientation r10) {
        /*
            java.lang.String r0 = m2890a(r6, r7, r8, r9, r10)
            java.lang.String r1 = "BrandSafetyUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Saving image to file: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.example.safesdk.sample.utils.Logger.m3601d(r1, r2)
            r2 = 0
            java.lang.String r1 = "BrandSafetyUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            r3.<init>()     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            java.lang.String r4 = "Saving screenshot to file "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            com.example.safesdk.sample.utils.Logger.m3601d(r1, r3)     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            int r1 = r5.getWidth()     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            int r3 = r5.getHeight()     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            r4 = 0
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r5, r1, r3, r4)     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x0056, all -> 0x0069 }
            if (r1 == 0) goto L_0x0050
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Throwable -> 0x0077 }
            r4 = 90
            r3.compress(r2, r4, r1)     // Catch:{ Throwable -> 0x0077 }
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0055:
            return r0
        L_0x0056:
            r0 = move-exception
            r1 = r2
        L_0x0058:
            java.lang.String r2 = "BrandSafetyUtils"
            java.lang.String r3 = "Failed to save screenshot to file"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r0)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = ""
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0055
        L_0x0067:
            r1 = move-exception
            goto L_0x0055
        L_0x0069:
            r0 = move-exception
        L_0x006a:
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ IOException -> 0x0072 }
        L_0x006f:
            throw r0
        L_0x0070:
            r1 = move-exception
            goto L_0x0055
        L_0x0072:
            r1 = move-exception
            goto L_0x006f
        L_0x0074:
            r0 = move-exception
            r2 = r1
            goto L_0x006a
        L_0x0077:
            r0 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.m2888a(android.graphics.Bitmap, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType, java.lang.String, java.lang.String, java.lang.String, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$ScreenShotOrientation):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[SYNTHETIC, Splitter:B:16:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[SYNTHETIC, Splitter:B:22:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m2897a(String r4, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.AdType r5, String r6, String r7, String r8, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.ScreenShotOrientation r9) {
        /*
            if (r4 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.String r0 = m2890a(r5, r6, r7, r8, r9)
            java.lang.String r1 = ".jpg"
            java.lang.String r2 = ".txt"
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "BrandSafetyUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Saving ad text to file: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.example.safesdk.sample.utils.Logger.m3601d(r1, r2)
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x003f, all -> 0x0050 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x003f, all -> 0x0050 }
            byte[] r0 = r4.getBytes()     // Catch:{ Throwable -> 0x005c }
            r1.write(r0)     // Catch:{ Throwable -> 0x005c }
            r1.close()     // Catch:{ Throwable -> 0x005c }
            if (r1 == 0) goto L_0x0002
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0002
        L_0x003d:
            r0 = move-exception
            goto L_0x0002
        L_0x003f:
            r0 = move-exception
            r1 = r2
        L_0x0041:
            java.lang.String r2 = "BrandSafetyUtils"
            java.lang.String r3 = "Failed to save ad text to file"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r0)     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0002
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0002
        L_0x004e:
            r0 = move-exception
            goto L_0x0002
        L_0x0050:
            r0 = move-exception
            r1 = r2
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0057:
            throw r0
        L_0x0058:
            r1 = move-exception
            goto L_0x0057
        L_0x005a:
            r0 = move-exception
            goto L_0x0052
        L_0x005c:
            r0 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.m2897a(java.lang.String, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType, java.lang.String, java.lang.String, java.lang.String, com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$ScreenShotOrientation):void");
    }

    /* renamed from: a */
    public static String m2893a(String str, boolean z) {
        if (str == null) {
            try {
                Logger.m3601d(f2499i, "Parameter name 'activityName' cannot be null");
                return null;
            } catch (Throwable th) {
                Logger.m3604e(f2499i, "Failed to get activity address for " + str, th);
                return "";
            }
        } else {
            String[] split = str.split("@");
            return split.length > 1 ? split[z ? (char) 1 : 0] : "";
        }
    }

    /* renamed from: b */
    static long m2906b(String str) {
        try {
            return new File(str).length();
        } catch (Throwable th) {
            Logger.m3604e(f2499i, "Failed to create new file for screenshot", th);
            return 0;
        }
    }

    /* renamed from: c */
    static synchronized void m2913c(String str) {
        synchronized (BrandSafetyUtils.class) {
            if (str != null) {
                Logger.m3601d(f2499i, "removeAdFiles started, filepath " + str);
                if (!new File(str).exists()) {
                    Logger.m3601d(f2499i, "removeAdFiles filePath does not exist. file=" + str);
                } else if (!new File(str).delete()) {
                    Logger.m3601d(f2499i, "removeAdFiles Failed to delete file " + str);
                } else {
                    Logger.m3601d(f2499i, "removeAdFiles deleted file " + str);
                }
                File file = new File(str.replace(f2491a, f2492b));
                if (file.exists()) {
                    Logger.m3601d(f2499i, "removeAdFiles Deleting file " + file.getAbsolutePath());
                    if (!file.delete()) {
                        Logger.m3601d(f2499i, "removeAdFiles Failed to delete file " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static String m2891a(Class cls) {
        return m2915d(cls.getName());
    }

    /* renamed from: d */
    public static String m2915d(String str) {
        if (str == null) {
            return null;
        }
        if (m2926n(str)) {
            return C1357d.f3603k;
        }
        return SdksMapping.getSdkPackageByClass(str);
    }

    /* renamed from: b */
    public static String m2909b(Class cls) {
        String name = cls.getName();
        String d = m2915d(name);
        if (d == null) {
            d = name;
        }
        Logger.m3607v(f2499i, "SDK package for class " + name + " is " + d);
        return d == null ? "unknown" : d;
    }

    /* renamed from: e */
    public static boolean m2917e(String str) {
        if (!m2926n(str) && SdksMapping.getSdkPackageByClass(str) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    private static boolean m2926n(String str) {
        if (str.startsWith("maps.bi.f") || str.startsWith("avu") ) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static C1277a m2885a(String str, Bitmap bitmap) {
        return m2886a(str, bitmap, 1000);
    }

    /* renamed from: b */
    public static C1277a m2908b(String str, Bitmap bitmap) {
        return m2886a(str, bitmap, 500);
    }

    /* renamed from: a */
    private static C1277a m2886a(String str, Bitmap bitmap, int i) {
        C1277a aVar = new C1277a();
        Logger.m3601d(f2499i, "scanBitmap started");
        Random random = new Random();
        HashMap hashMap = new HashMap();
        float a = m3056a(str, "CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT", 0.15f);
        float a2 = m3056a(str, AdNetworkDiscovery.f2650g, 0.15f);
        float a3 = m3056a(str, "CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT", 0.15f);
        float a4 = m3056a(str, AdNetworkDiscovery.f2652i, 0.15f);
        Logger.m3601d(f2499i, "bitmap scan : margins are : top " + a + " , right " + a2 + ", left " + a3 + ", right " + a4);
        int width = bitmap.getWidth();
        int i2 = (int) ((double) (a3 * ((float) width)));
        int i3 = (int) ((double) (((float) width) - (a2 * ((float) width))));
        int height = bitmap.getHeight();
        int i4 = (int) ((double) (a * ((float) height)));
        int i5 = (int) ((double) (((float) height) - (((float) height) * a4)));
        for (int i6 = 0; i6 < i; i6++) {
            int pixel = 16777215 & bitmap.getPixel(random.nextInt(i3 - i2) + i2, random.nextInt(i5 - i4) + i4);
            Integer num = (Integer) hashMap.get(Integer.valueOf(pixel));
            if (num == null) {
                hashMap.put(Integer.valueOf(pixel), 1);
            } else {
                hashMap.put(Integer.valueOf(pixel), Integer.valueOf(num.intValue() + 1));
            }
        }
        int i7 = 0;
   /*     for (Integer intValue : hashMap.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 > i7) {
                aVar.mo19229a(intValue2);
            } else {
                intValue2 = i7;
            }
            i7 = intValue2;
        }*/
        Logger.m3601d(f2499i, "bitmap scan : pixel map : " + hashMap.toString());
        if (!(hashMap.get(0) == null || ((Integer) hashMap.get(0)) == null)) {
            int intValue3 = (((Integer) hashMap.get(0)).intValue() * 100) / i;
            Logger.m3601d(f2499i, "bitmap scan : Black Pixel Percentage is " + intValue3 + " (" + hashMap.get(0) + "/" + i + ")");
            aVar.mo19232b(intValue3);
        }
        if (!(hashMap.get(Integer.valueOf(f2506p)) == null || ((Integer) hashMap.get(Integer.valueOf(f2506p))) == null)) {
            int intValue4 = (((Integer) hashMap.get(Integer.valueOf(f2506p))).intValue() * 100) / i;
            Logger.m3601d(f2499i, "bitmap scan : Grey Pixel Percentage is " + intValue4 + " (" + hashMap.get(Integer.valueOf(f2506p)) + "/" + i + ")");
            aVar.mo19234c(intValue4);
        }
        Logger.m3607v(f2499i, "bitmap scan : maxPixelValue = " + i7);
        boolean b = m3091b(str, false);
        Logger.m3601d(f2499i, "bitmap scan : Configuration item  CONFIGURATION_BITMAP_SCAN_SHOULD_CHECK_ADDITIONAL_BITMAP_ATTRIBUTES returned " + b + " for sdk " + str);
        if (b) {
            aVar.mo19230a(m2904a((Map<Integer, Integer>) hashMap));
        }
        return aVar;
    }

    private static float m3056a(String str, String configuration_bitmap_scan_top_margin_percent, float v) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2904a(Map<Integer, Integer> r4) {
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.m2904a(java.util.Map):boolean");
    }

    /* renamed from: a */
    public static boolean m2899a(int i) {
        return m2900a(i, 1000, SafeDK.getInstance().mo19155y());
    }

    /* renamed from: b */
    public static boolean m2910b(int i) {
        return m2900a(i, 500, SafeDK.getInstance().mo19120K());
    }

    /* renamed from: a */
    private static boolean m2900a(int i, int i2, float f) {
        Logger.m3601d(f2499i, "isScreenshotEnough Max Banner Uniform Pixel Percentage to Stop Sampling is " + f);
        return ((float) i) < (f / 100.0f) * ((float) i2);
    }

    /* renamed from: a */
    public static boolean m2902a(String str, C1277a aVar) {
        return m2903a(str, aVar, 1000, SafeDK.getInstance().mo19156z());
    }

    /* renamed from: b */
    public static boolean m2911b(String str, C1277a aVar) {
        return m2903a(str, aVar, 500, SafeDK.getInstance().mo19121L());
    }

    /* renamed from: a */
    private static boolean m2903a(String str, C1277a aVar, int i, float f) {
        Logger.m3601d(f2499i, "isScreenshotValid started, BitmapScanResult=" + aVar);
        Logger.m3601d(f2499i, "isScreenshotValid bitmapScanResult.getMaxPixelCount() is " + aVar.mo19228a());
        Logger.m3601d(f2499i, "isScreenshotValid Min Uniform Pixels Percentage For Uniform Image is " + f);
        Logger.m3601d(f2499i, "isScreenshotValid Min Uniform Pixels Percentage For Uniform Image calc result is " + ((f / 100.0f) * ((float) i)));
        if (((float) aVar.mo19228a()) > (f / 100.0f) * ((float) i)) {
            Logger.m3601d(f2499i, "Screenshot max color pixel count is above uniformity threshold, image is NOT valid");
            return false;
        } else if (aVar.mo19231b() > 10 && aVar.mo19233c() > 10) {
            Logger.m3601d(f2499i, "Screenshot black pixel percentage is " + aVar.mo19231b() + "% , grey pixel percentage is " + aVar.mo19233c() + "%, => above threshold, image is not valid");
            return false;
        } else if (aVar.mo19233c() > 50) {
            Logger.m3601d(f2499i, "Screenshot black pixel percentage is " + aVar.mo19231b() + "%  => above threshold, image is not valid");
            return false;
        } else {
            boolean b = m3091b(str, false);
            Logger.m3601d(f2499i, "Configuration item CONFIGURATION_BITMAP_SCAN_SHOULD_CHECK_ADDITIONAL_BITMAP_ATTRIBUTES returned " + b + " for sdk " + str);
            if (b) {
                if (aVar.mo19235d()) {
                    Logger.m3601d(f2499i, "Screenshot is NSFD");
                    return false;
                }
                Logger.m3601d(f2499i, "Screenshot is NOT NSFD");
            }
            return true;
        }
    }

    /* renamed from: a */
    public static String m2890a(AdType adType, String str, String str2, String str3, ScreenShotOrientation screenShotOrientation) {
        return SafeDK.getInstance().mo19137g().getDir("SafeDK_" + adType, 0) + File.separator + str + "_" + str2 + "_" + str3 + "_" + screenShotOrientation.name().toLowerCase() + f2491a;
    }

    /* renamed from: c */
    public static boolean m2914c(Class cls) {
        return m2918f(cls.getName());
    }

    /* renamed from: f */
    public static boolean m2918f(String str) {
        Logger.m3601d(f2499i, "isInterstitialActivity started, Activity name : " + str + ", result : " + f2500j.contains(str) + ", interstitialActivities= " + f2500j);
        return f2500j.contains(str);
    }

    /* renamed from: g */
    public static String m2919g(String str) {
        for (String next : f2500j) {
            if (str.startsWith(next)) {
                return next;
            }
        }
        return "";
    }

    /* renamed from: h */
    public static void m2920h(String str) {
        Logger.m3601d(f2499i, "addInterstitialActivity started name=" + str);
        f2500j.add(str);
    }

    /* renamed from: i */
    public static void m2921i(String str) {
        Logger.m3601d(f2499i, "removeInterstitialActivity started name=" + str);
        f2500j.remove(str);
    }

    /* renamed from: a */
    public static List<C1279c> m2894a(AdType adType) {
        BufferedReader bufferedReader;
        String str;
        String str2;
        int i = 0;
        ArrayList arrayList = new ArrayList();
        try {
            Logger.m3601d(f2499i, "Restoring " + adType + " images for upload");
            File[] listFiles = SafeDK.getInstance().mo19137g().getDir("SafeDK_" + adType, 0).listFiles(new C1278b());
            if (listFiles != null) {
                Logger.m3601d(f2499i, "Found " + listFiles.length + " candidate images for upload");
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        break;
                    }
                    String name = listFiles[i2].getName();
                    Logger.m3601d(f2499i, "Checking file " + name);
                    String absolutePath = listFiles[i2].getAbsolutePath();
                    File file = new File(absolutePath.replace(f2491a, f2492b));
                    if (System.currentTimeMillis() - listFiles[i2].lastModified() > 86400000) {
                        Logger.m3601d(f2499i, "Deleting file " + listFiles[i2].getAbsolutePath());
                        listFiles[i2].delete();
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    String[] split = name.replace(f2491a, "").split("_");
                    if (split.length >= 4) {
                        String str3 = split[0];
                        String str4 = split[1];
                        String str5 = split[2];
                        ScreenShotOrientation valueOf = ScreenShotOrientation.valueOf(split[3].toUpperCase());
                        Logger.m3601d(f2499i, "Restore image for upload: " + absolutePath);
                   /*     try {
                            if (file.exists()) {
                                Logger.m3601d(f2499i, "Restore ad text " + file.getName());
                                bufferedReader = new BufferedReader(new FileReader(file));
                                try {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        stringBuffer.append(readLine);
                                    }
                                    str2 = stringBuffer.toString();
                                } catch (Throwable th) {
                                }
                            } else {
                                str2 = null;
                            }
                            str = str2;
                        } catch (Throwable th2) {
                            bufferedReader = null;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    str = null;
                                } catch (Throwable th3) {
                                    str = null;
                                }
                            } else {
                                str = null;
                            }
                            arrayList.add(new C1279c(str3, str4, str5, valueOf, absolutePath, str));
                            i = i2 + 1;
                        }*/
                       // arrayList.add(new C1279c(str3, str4, str5, valueOf, absolutePath, str));
                    }
                    else {
                        listFiles[i2].delete();
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    i = i2 + 1;
                }
            }
        } catch (Throwable th4) {
            Logger.m3602d(f2499i, "Error while restoring ads for upload", th4);
            new CrashReporter().caughtException(th4);
        }
        return arrayList;
    }

    /* renamed from: d */
    private static void m2916d() {
        DisplayMetrics displayMetrics = SafeDK.getInstance().mo19137g().getResources().getDisplayMetrics();
        f2512v = displayMetrics.heightPixels;
        f2511u = displayMetrics.widthPixels;
    }

    /* renamed from: a */
    static int m2884a() {
        if (f2511u == 0) {
            m2916d();
        }
        return f2511u;
    }

    /* renamed from: b */
    static int m2905b() {
        if (f2512v == 0) {
            m2916d();
        }
        return f2512v;
    }

    /* renamed from: c */
    static ScreenShotOrientation m2912c() {
        DisplayMetrics displayMetrics = SafeDK.getInstance().mo19137g().getResources().getDisplayMetrics();
        return displayMetrics.heightPixels > displayMetrics.widthPixels ? ScreenShotOrientation.PORTRAIT : ScreenShotOrientation.LANDSCAPE;
    }

    /* renamed from: b */
    static ScreenShotOrientation m2907b(Bitmap bitmap) {
        if (bitmap == null) {
            return ScreenShotOrientation.NOT_INITIALIZED;
        }
        return bitmap.getHeight() > bitmap.getWidth() ? ScreenShotOrientation.PORTRAIT : ScreenShotOrientation.LANDSCAPE;
    }

    /* renamed from: j */
    public static String m2922j(String str) {
        String[] split = str.split("\\{");
        if (split.length > 1) {
            return split[1].split(" ")[0];
        }
        Logger.m3601d(f2499i, "couldn't find webview address from class: " + str);
        return "";
    }

    /* renamed from: a */
    public static String m2889a(View view) {
        if (view != null) {
            return m2922j(view.toString());
        }
        Logger.m3601d(f2499i, "getWebViewAddress view is null");
        return null;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$c */
    public static class C1279c {

        /* renamed from: a */
        String f2527a;

        /* renamed from: b */
        String f2528b;

        /* renamed from: c */
        String f2529c;

        /* renamed from: d */
        ScreenShotOrientation f2530d;

        /* renamed from: e */
        String f2531e;

        /* renamed from: f */
        String f2532f;

        public C1279c(String str, String str2, String str3, ScreenShotOrientation screenShotOrientation, String str4, String str5) {
            this.f2527a = str;
            this.f2528b = str2;
            this.f2529c = str3;
            this.f2530d = screenShotOrientation;
            this.f2531e = str4;
            this.f2532f = str5;
        }

        /* renamed from: a */
        public String mo19238a() {
            return this.f2527a;
        }

        /* renamed from: b */
        public String mo19239b() {
            return this.f2528b;
        }

        /* renamed from: c */
        public String mo19240c() {
            return this.f2529c;
        }

        /* renamed from: d */
        public ScreenShotOrientation mo19241d() {
            return this.f2530d;
        }

        /* renamed from: e */
        public String mo19242e() {
            return this.f2531e;
        }

        /* renamed from: f */
        public String mo19243f() {
            return this.f2532f;
        }
    }

    /* renamed from: a */
    private static void m2896a(String str, long j, long j2, String str2, String str3, String str4) {
        try {
            Logger.m3601d(f2499i, "Report click url with no impression to server starting, sdkPackageName=" + str + ", url=" + str3 + ", currentForegroundActivityName=" + str4);
            SafeDK.getInstance();
            if (!SafeDK.m2695P()) {
                Logger.m3601d(f2499i, "Max not initialized, this is not a Max mediated App.");
            }
            if (!C1280d.m2943a(str)) {
                Logger.m3601d(f2499i, "Redirect reporting not supported for Sdk " + str + ", report will not be sent");
            } else if (str3 != null) {
                Uri parse = Uri.parse(str3);
                if (parse.getScheme() != null && parse.getHost() != null) {
                    if (C1280d.m2944a(str, str3)) {
                        Logger.m3601d(f2499i, "Ignoring this intent as it was already reported , sdkPackageName=" + str + " ,intentUrl=" + str);
                        return;
                    }
                    RedirectEvent redirectEvent = new RedirectEvent(str, str3, str2, str4, j, j2);
                    redirectEvent.mo19533a(C1337j.m3416a().mo19502b());
                    if (SafeDK.m2711b()) {
                        StatsCollector.m2806b().mo19190a((StatsEvent) redirectEvent);
                    } else {
                        Logger.m3601d(f2499i, "Reporter thread not initialized or stats collector instance is null, skipping");
                    }
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f2499i, "Exception during attempt to create redirect event", th);
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$d */
    private static class C1280d {

        /* renamed from: a */
        private static  String f2533a = "SdkUrlRedirectManager";

        /* renamed from: b */
        private static Map<String, Long> f2534b = new HashMap();

        /* renamed from: c */
        private static int f2535c = 1000;

        private C1280d() {
        }

        /* renamed from: b */
        private static String m2945b(String str, String str2) {
            return str + "_" + str2;
        }

        /* renamed from: c */
        private static boolean m2946c(String str, String str2) {
            Logger.m3601d(f2533a, "Check : does timestamp exist for Sdk and url ?  sdkPackageName=" + str + ", url=" + str2 + " , result = " + f2534b.containsKey(m2945b(str, str2)));
            return f2534b.containsKey(m2945b(str, str2));
        }

        /* renamed from: d */
        private static long m2947d(String str, String str2) {
            Logger.m3601d(f2533a, "getting latest timestamp for Sdk and url started. sdkPackageName=" + str + ", url=" + str2);
            if (m2946c(str, str2)) {
                return f2534b.get(m2945b(str, str2)).longValue();
            }
            return 0;
        }

        /* renamed from: a */
        public static boolean m2944a(String str, String str2) {
            long currentTimeMillis = System.currentTimeMillis();
            m2941a();
            long d = m2947d(str, str2);
            Logger.m3601d(f2533a, "Checking if we should ignore the redirect instance sdkPackageName=" + str + ", url=" + str2 + ", timestamp=" + currentTimeMillis + ",System.currentTimeMillis()=" + System.currentTimeMillis() + ", latestTimestamp=" + d + ", diff=" + (System.currentTimeMillis() - d));
            if (d == 0 || System.currentTimeMillis() - d >= ((long) f2535c)) {
                m2942a(str, str2, currentTimeMillis);
                return false;
            }
            Logger.m3601d(f2533a, "should ignore this redirect.");
            return true;
        }

        /* renamed from: a */
        private static void m2942a(String str, String str2, long j) {
            Logger.m3601d(f2533a, "Update latest timestamp for Sdk and url started. sdkPackageName=" + str + ", url=" + str2);
            f2534b.put(m2945b(str, str2), Long.valueOf(j));
            Logger.m3601d(f2533a, "timestamps : " + f2534b.toString());
        }

        /* renamed from: a */
        private static void m2941a() {
            Logger.m3601d(f2533a, "Clear data started, (" + f2534b.size() + ") : " + f2534b.toString());
            ArrayList<String> arrayList = new ArrayList<>();
            for (String next : f2534b.keySet()) {
                Logger.m3601d(f2533a, "Clear System.currentTimeMillis()-sdkAndUrlToTimestamp.get(key)=" + (System.currentTimeMillis() - f2534b.get(next).longValue()));
                if (System.currentTimeMillis() - f2534b.get(next).longValue() > ((long) f2535c)) {
                    Logger.m3601d(f2533a, "Added key for removal : " + next);
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                for (String str : arrayList) {
                    Logger.m3601d(f2533a, "Removing key " + str);
                    f2534b.remove(str);
                }
            }
            Logger.m3601d(f2533a, "Clear data finished, Items (" + f2534b.size() + ") : " + f2534b.toString());
        }

        /* renamed from: a */
        public static boolean m2943a(String str) {
            String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(str);
            if (sdkUUIDByPackage == null || sdkUUIDByPackage.length() <= 0 || SdksMapping.getRedirectSupportedSdks() == null) {
                Logger.m3601d(f2533a, "Cannot determine if sdk is redirect detection supported, sdk=" + str);
                return false;
            }
            Logger.m3601d(f2533a, "sdk=" + str + ", sdkUid=" + sdkUUIDByPackage + ", supported ? " + SdksMapping.getRedirectSupportedSdks().contains(sdkUUIDByPackage));
            return SdksMapping.getRedirectSupportedSdks().contains(sdkUUIDByPackage);
        }
    }

    /* renamed from: k */
    public static void m2923k(String str) {
        Logger.m3601d(f2499i, "adding to redirect current open fullscreen ad collection. sdk = " + str + ", redirectDetectionCurrentInterstitialBySdk = " + f2502l.toString());
        f2502l.add(str);
    }

    /* renamed from: l */
    public static void m2924l(String str) {
        Logger.m3601d(f2499i, "removing from redirect current open fullscreen ad collection. sdk = " + str + ", redirectDetectionCurrentInterstitialBySdk = " + f2502l.toString());
        f2502l.remove(str);
    }

    /* renamed from: m */
    public static boolean m2925m(String str) {
        Logger.m3601d(f2499i, "checking if there is a redirect current open fullscreen ad in collection. sdk = " + str + ", result is " + f2502l.contains(str) + ", redirectDetectionCurrentInterstitialBySdk = " + f2502l.toString());
        return f2502l.contains(str);
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$a */
    public static class C1277a {

        /* renamed from: a */
        private static  String f2522a = "BitmapScanResult";

        /* renamed from: b */
        private int f2523b;

        /* renamed from: c */
        private int f2524c;

        /* renamed from: d */
        private int f2525d;

        /* renamed from: e */
        private boolean f2526e = false;

        /* renamed from: a */
        public int mo19228a() {
            return this.f2523b;
        }

        /* renamed from: a */
        public void mo19229a(int i) {
            this.f2523b = i;
        }

        /* renamed from: b */
        public int mo19231b() {
            return this.f2524c;
        }

        /* renamed from: b */
        public void mo19232b(int i) {
            Logger.m3601d(f2522a, "setBlackPixelPercentage : " + i);
            this.f2524c = i;
        }

        /* renamed from: c */
        public int mo19233c() {
            return this.f2525d;
        }

        /* renamed from: c */
        public void mo19234c(int i) {
            Logger.m3601d(f2522a, "setGreyPixelPercentage : " + i);
            this.f2525d = i;
        }

        /* renamed from: d */
        public boolean mo19235d() {
            return this.f2524c > 50 && this.f2526e;
        }

        /* renamed from: a */
        public void mo19230a(boolean z) {
            this.f2526e = z;
        }

        public String toString() {
            return "MaxPixelCount = " + this.f2523b + ", BlackPixelPercentage = " + this.f2524c + ", GreyPixelPercentage = " + this.f2525d;
        }
    }
}

package com.example.safesdk.sample.analytics.brandsafety;

import android.os.SystemClock;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.Logger;
import java.util.HashMap;

public class DetectTouchUtils {

    /* renamed from: a */
    private static  String f2536a = "DetectTouchUtils";

    /* renamed from: b */
    private static HashMap<String, Pair<Long, Long>> f2537b = new HashMap<>();

    /* renamed from: a */
    public static Pair<Long, Long> m2948a(String str) {
        if (!f2537b.containsKey(str) || f2537b.get(str) == null) {
            return null;
        }
        return f2537b.get(str);
    }

    public static void activityOnTouch(String sdkPackageName, MotionEvent me) {
        try {
            if (me.getAction() == 0) {
                Logger.m3601d(f2536a, "activityOnTouch started, sdkPackageName=" + sdkPackageName + ", MotionEvent=" + me.toString());
                if ((0 != me.getEventTime()) && me.getActionMasked() != 2) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long currentTimeMillis = System.currentTimeMillis();
                    f2537b.put(sdkPackageName, new Pair(Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis)));
                    Logger.m3601d(f2536a, "detect touch. time (elapsed): " + elapsedRealtime + ", time(currentTimeMillis): " + currentTimeMillis);
                }
            }
        } catch (Throwable th) {
            Logger.m3602d(f2536a, "error in activityOnTouch", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static void webViewOnTouch(String sdkPackage, WebView view, MotionEvent me) {
        try {
            if (me.getAction() == 0) {
                Logger.m3601d(f2536a, "WebViewOnTouch started, sdkPackage=" + sdkPackage + ", view=" + view.toString() + ", MotionEvent=" + me.toString());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long currentTimeMillis = System.currentTimeMillis();
                f2537b.put(sdkPackage, new Pair(Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis)));
                Logger.m3601d(f2536a, "detect touch. time (elapsed): " + elapsedRealtime + ", time(currentTimeMillis): " + currentTimeMillis);
            }
        } catch (Throwable th) {
            Logger.m3602d(f2536a, "error in activityOnTouch", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static void viewGroupOnTouch(String sdkPackage, ViewGroup viewGroup, MotionEvent me) {
        try {
            if (me.getAction() == 0) {
                Logger.m3601d(f2536a, "viewGroupOnTouch started, sdkPackage=" + sdkPackage + ", view=" + viewGroup.toString() + ", MotionEvent=" + me.toString());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long currentTimeMillis = System.currentTimeMillis();
                f2537b.put(sdkPackage, new Pair(Long.valueOf(elapsedRealtime), Long.valueOf(currentTimeMillis)));
                Logger.m3601d(f2536a, "viewGroupOnTouch detect touch. time (elapsed): " + elapsedRealtime + ", time(currentTimeMillis): " + currentTimeMillis);
            }
        } catch (Throwable th) {
            Logger.m3602d(f2536a, "error in viewGroupOnTouch", th);
        }
    }
}

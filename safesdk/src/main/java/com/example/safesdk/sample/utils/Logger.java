package com.example.safesdk.sample.utils;

import android.util.Log;

public  class Logger {
    private static boolean debugMode = false;

    private Logger() {
    }

    public static void setDebugMode(boolean debug) {
        debugMode = debug;
    }

    /* renamed from: v */
    public static int m3607v(String tag, String msg) {
        if (debugMode) {
            return Log.v(tag, msg);
        }
        return 0;
    }

    /* renamed from: v */
    public static int m3608v(String tag, String msg, Throwable tr) {
        if (debugMode) {
            return Log.v(tag, msg, tr);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m3601d(String tag, String msg) {
        if (debugMode) {
            return Log.d(tag, msg);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m3602d(String tag, String msg, Throwable tr) {
        if (debugMode) {
            return Log.d(tag, msg, tr);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m3600d(String tag_msg) {
        if (!debugMode) {
            return 0;
        }
        String[] split = tag_msg.split("\\|");
        return Log.d(split[0], split[1]);
    }

    /* renamed from: i */
    public static int m3605i(String tag, String msg) {
        return Log.i(tag, msg);
    }

    /* renamed from: i */
    public static int m3606i(String tag, String msg, Throwable tr) {
        return Log.i(tag, msg, tr);
    }

    /* renamed from: w */
    public static int m3609w(String tag, String msg) {
        return Log.w(tag, msg);
    }

    /* renamed from: w */
    public static int m3610w(String tag, String msg, Throwable tr) {
        return Log.w(tag, msg, tr);
    }

    /* renamed from: w */
    public static int m3611w(String tag, Throwable tr) {
        return Log.w(tag, tr);
    }

    /* renamed from: e */
    public static int m3603e(String tag, String msg) {
        try {
            return Log.e(tag, msg);
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: e */
    public static int m3604e(String tag, String msg, Throwable tr) {
        try {
            return Log.e(tag, msg, tr);
        } catch (Throwable th) {
            return 0;
        }
    }

    public static void printStackTrace() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            Log.d("StackTrace", stackTraceElement.toString());
        }
    }
}

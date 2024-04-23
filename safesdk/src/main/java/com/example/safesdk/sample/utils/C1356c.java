package com.example.safesdk.sample.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.example.safesdk.sample.SafeDK;
import java.io.File;
import java.text.DecimalFormat;

/* renamed from: com.example.safesdk.sample.utils.c */
public class C1356c {

    /* renamed from: a */
    public static  int f3586a = 620;

    /* renamed from: b */
    private static  String f3587b = C1356c.class.getSimpleName();

    /* renamed from: a */
    public static long m3624a(Context context) {
        return Runtime.getRuntime().freeMemory();
    }

    /* renamed from: b */
    public static boolean m3632b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    /* renamed from: a */
    public static String m3626a() {
        try {
            return m3628a(m3625a(Environment.getDataDirectory()));
        } catch (Throwable th) {
            Logger.m3603e(f3587b, "error in getHumanReadableFreeInternalMemory()");
            return "";
        }
    }

    /* renamed from: b */
    public static long m3630b() {
        return m3625a(Environment.getDataDirectory());
    }

    /* renamed from: a */
    private static long m3625a(File file) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            }
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            Logger.m3603e(f3587b, "error in getAvailableMemoryInPath");
            return 0;
        }
    }

    /* renamed from: a */
    public static String m3628a(long j) {
        long j2 = 1024 * 1024;
        long j3 = j2 * 1024;
        long j4 = j3 * 1024;
        long j5 = j4 * 1024;
        long j6 = j5 * 1024;
        if (j < 1024) {
            return m3627a((double) j) + " byte";
        }
        if (j >= 1024 && j < j2) {
            return m3627a(((double) j) / ((double) 1024)) + " Kb";
        }
        if (j >= j2 && j < j3) {
            return m3627a(((double) j) / ((double) j2)) + " Mb";
        }
        if (j >= j3 && j < j4) {
            return m3627a(((double) j) / ((double) j3)) + " Gb";
        }
        if (j >= j4 && j < j5) {
            return m3627a(((double) j) / ((double) j4)) + " Tb";
        }
        if (j >= j5 && j < j6) {
            return m3627a(((double) j) / ((double) j5)) + " Pb";
        }
        if (j >= j6) {
            return m3627a(((double) j) / ((double) j6)) + " Eb";
        }
        return "???";
    }

    /* renamed from: a */
    private static String m3627a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    /* renamed from: c */
    public static long m3633c() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    /* renamed from: a */
    public static void m3629a(String str) {
        String a = m3628a((long) str.getBytes().length);
        String a2 = m3628a(m3633c());
        Logger.m3601d(f3587b, "loaded from prefs: " + a);
        Logger.m3601d(f3587b, "available heap size: " + a2);
        if (m3632b(SafeDK.getInstance().mo19137g())) {
            Logger.m3603e(f3587b, "android low memory!");
        }
    }

    /* renamed from: b */
    public static void m3631b(String str) {
        String a = m3628a((long) str.getBytes().length);
        String a2 = m3628a(m3633c());
        Logger.m3601d(f3587b, "saved in prefs: " + a);
        boolean b = m3632b(SafeDK.getInstance().mo19137g());
        Logger.m3601d(f3587b, "available heap size: " + a2);
        if (b) {
            Logger.m3603e(f3587b, "android low memory!");
        }
    }
}

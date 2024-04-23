package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.C1269b;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.e */
public class C1320e implements AppLovinCommunicatorPublisher {

    /* renamed from: a */
    private static  String f3081a = "BrandSafetyReporter";

    /* renamed from: b */
    private static  ExecutorService f3082b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public static C1320e f3083c = null;

    private C1320e() {
        m3374e();
    }

    /* renamed from: a */
    public static C1320e m3369a() {
        if (f3083c == null) {
            f3083c = new C1320e();
        }
        return f3083c;
    }

    /* renamed from: e */
    private void m3374e() {

    }

    /* renamed from: a */
    public static void m3371a( Bundle bundle, String str) {
        Logger.m3601d(f3081a, "reportImageUploadedToServer started");
        try {
            f3082b.execute(new Runnable() {
                public void run() {
                    try {
                        if (bundle == null) {
                            Logger.m3601d(C1320e.f3081a, "Data argument is null, which means that the upload failed. Nothing to report to the server.");
                        } else if (bundle.size() > 0) {
                            Logger.m3601d(C1320e.f3081a, "Starting image upload report event.");
                            AppLovinBridge.reportImageUploadEvent(bundle, C1320e.f3083c);
                            C1320e.m3375f();
                        }
                    } catch (Throwable th) {
                        Logger.m3604e(C1320e.f3081a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.m3604e(f3081a, "failed during reportImageUploadedToServer. data: " + bundle.toString(), th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: f */
    public static void m3375f() {
        C1319d t = SafeDK.getInstance().mo19150t();
        if (t != null) {
            Logger.m3601d(f3081a, "Executing image cleanup request");
            t.mo19459a();
            return;
        }
        Logger.m3601d(f3081a, "Upload: Handler not found for image cleanup request");
    }

    /* renamed from: a */
    public static void m3370a( Bundle bundle) {
        try {
            f3082b.execute(new Runnable() {
                public void run() {
                    try {
                        if (bundle == null) {
                            Logger.m3601d(C1320e.f3081a, "Data argument is null, which means reporting a resolved click url is not possible. ");
                        } else if (bundle.size() > 0) {
                            Logger.m3601d(C1320e.f3081a, "Starting url resolution report event.");
                            AppLovinBridge.reportClickUrlResolvedEvent(bundle, C1320e.f3083c);
                        }
                    } catch (Throwable th) {
                        Logger.m3604e(C1320e.f3081a, "Caught exception while creating json data", th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.m3604e(f3081a, "failed during reportImageUploadedToServer. data: " + bundle.toString(), th);
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: b */
    public String mo19471b() {
        return AppLovinBridge.f2360a;
    }

    /**
     * @return
     */
    @Override
    public String getCommunicatorId() {
        return null;
    }
}

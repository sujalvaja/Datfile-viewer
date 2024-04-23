package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.C1331g;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.p055a.C1255a;
import com.example.safesdk.sample.utils.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.d */
public class C1319d {

    /* renamed from: a */
    private static  String f3077a = "BrandSafetyImageHandler";

    /* renamed from: b */
    private Map<String, C1285b> f3078b = new HashMap();

    /* renamed from: c */
    private Set<String> f3079c = new HashSet();

    /* renamed from: d */
    private String f3080d = null;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19462a(C1331g.C1333a aVar, String str, String str2) {
        Logger.m3601d(f3077a, "handleUploadRequest started, imageToUpload=" + str + ", impressionsToReport=" + this.f3078b.toString());
        C1285b bVar = this.f3078b.get(str);
        if (bVar != null) {
            C1320e.m3371a(m3355a(str, aVar, str2), bVar.mo19267c());
            Logger.m3601d(f3077a, "Attempting to remove the file " + bVar.mo19267c());
            m3356c(str);
            return;
        }
        Logger.m3601d(f3077a, "handleUploadRequest impressionsToReport doesn't contain imageToUpload " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19463a(String str) {
        m3356c(str);
        mo19459a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19459a() {
        mo19466b();
    }

    /* renamed from: c */
    private synchronized void m3356c(String str) {
        if (this.f3078b == null || !this.f3078b.containsKey(str)) {
            Logger.m3601d(f3077a, "Cannot find " + str + " in impressionsToReport, cannot clean up image");
        } else {
            Logger.m3601d(f3077a, "Cleaning stored impressions: " + str);
            this.f3079c.add(str);
            BrandSafetyUtils.m2913c(this.f3078b.get(str).mo19267c());
            this.f3078b.remove(str);
        }
    }

    /* renamed from: b */
    public void mo19466b() {
        Logger.m3601d(f3077a, "removeImpressionScreenshots started");
        if (this.f3080d != null) {
            Logger.m3601d(f3077a, "Calling BrandSafetyUtils.removeAdFiles, filename = " + this.f3080d);
            BrandSafetyUtils.m2913c(this.f3080d);
            this.f3080d = null;
        } else {
            Logger.m3601d(f3077a, "lastActivityImpressionScreenshotFilename is null");
        }
        this.f3079c = new HashSet();
    }

    /* renamed from: a */
    private Bundle m3355a(String str, C1331g.C1333a aVar, String str2) {
        C1285b bVar;
        if (this.f3078b != null) {
            Logger.m3601d(f3077a, "Uploading impression " + str + " to server, timeout=" + SafeDK.getInstance().mo19113D() + "ms");
            synchronized (this) {
                bVar = this.f3078b.get(str);
            }
            if (bVar != null) {
                C1255a.C1256a a = new C1255a(bVar.mo19267c(), str, SafeDK.getInstance().mo19113D(), aVar).mo19159a();
                if (a != null) {
                    String a2 = a.mo19160a();
                    String c = a.mo19162c();
                    Logger.m3601d(f3077a, "Upload impression image succeeded: " + a2 + " , return code =" + a.mo19161b());
                    if (a2 != null && !a2.isEmpty()) {
                        Bundle bundle = new Bundle();
                        try {
                            bundle.putString(C1331g.f3126b, str2);
                            bundle.putString("ad_format_type", bVar.f2616n == BrandSafetyUtils.AdType.INTERSTITIAL ? BrandSafetyEvent.AdFormatType.INTER.name() : BrandSafetyEvent.AdFormatType.BANNER.name());
                            bundle.putString(C1285b.f2600h, a2);
                            bundle.putString("image_orientation", bVar.f2627y.name().toLowerCase());
                            bundle.putString(AppLovinBridge.f2364e, AppLovinBridge.f2366g);
                            bundle.putString("image_id", c);
                            bundle.putString(AppLovinBridge.f2365f, SafeDK.getInstance().mo19137g().getPackageName());
                        } catch (Throwable th) {
                            Logger.m3604e(f3077a, th.getMessage(), th);
                            new CrashReporter().caughtException(th);
                        }
                        return bundle;
                    }
                } else {
                    Logger.m3601d(f3077a, "upload response is null");
                    this.f3078b.remove(str);
                }
            } else {
                Logger.m3601d(f3077a, "impressionInfoToUpload is null");
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized void mo19460a(BrandSafetyUtils.AdType adType) {
        List<BrandSafetyUtils.C1279c> a = BrandSafetyUtils.m2894a(adType);
        int B = a.size() > SafeDK.getInstance().mo19111B() ? SafeDK.getInstance().mo19111B() : a.size();
        for (int i = 0; i < B; i++) {
            BrandSafetyUtils.C1279c cVar = a.get(i);
            String str = cVar.mo19238a() + "_" + cVar.mo19240c();
            if (adType == BrandSafetyUtils.AdType.INTERSTITIAL) {
                this.f3078b.put(str, new C1335h(cVar.mo19238a(), cVar.mo19239b(), cVar.mo19240c(), cVar.mo19241d(), cVar.mo19242e(), cVar.mo19243f()));
            } else {
                this.f3078b.put(str, new C1286c(cVar.mo19238a(), cVar.mo19239b(), cVar.mo19240c(), cVar.mo19241d(), cVar.mo19242e(), cVar.mo19243f()));
            }
        }
    }

    /* renamed from: b */
    public int mo19465b(BrandSafetyUtils.AdType adType) {
        int i = 0;
        Iterator<C1285b> it = this.f3078b.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            if (it.next().f2616n == adType) {
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    /* renamed from: a */
    public void mo19461a(C1285b bVar) {
        if (bVar != null && bVar.f2620r != null && bVar.f2619q != null) {
            Logger.m3601d(f3077a, "addImpressionsToReport " + bVar.f2620r + "_" + bVar.f2619q);
            this.f3078b.put(bVar.f2620r + "_" + bVar.f2619q, bVar);
        }
    }

    /* renamed from: c */
    public Set<String> mo19469c() {
        return this.f3078b.keySet();
    }

    /* renamed from: a */
    public boolean mo19464a(String str, String str2) {
        return this.f3078b.containsKey(str + "_" + str2);
    }

    /* renamed from: b */
    public boolean mo19468b(String str, String str2) {
        return this.f3079c.contains(str + "_" + str2);
    }

    /* renamed from: d */
    public String mo19470d() {
        return this.f3080d;
    }

    /* renamed from: b */
    public void mo19467b(String str) {
        this.f3080d = str;
    }
}

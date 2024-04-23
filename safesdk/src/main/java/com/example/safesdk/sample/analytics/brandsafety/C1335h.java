package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.h */
public class C1335h extends C1285b {

    /* renamed from: K */
    Set<String> f3172K;

    /* renamed from: L */
    boolean f3173L;

    /* renamed from: M */
    boolean f3174M;

    /* renamed from: N */
    long f3175N;

    /* renamed from: O */
    boolean f3176O;

    public C1335h(String[] strArr, String str, int i, Bundle bundle) {
        super(strArr, i, bundle, (String) null, str, (String) null, BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED, BrandSafetyUtils.AdType.INTERSTITIAL);
        this.f3173L = true;
        this.f3174M = true;
        this.f3176O = false;
        this.f3172K = new HashSet();
    }

    public C1335h(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        super(str, str2, str3, screenShotOrientation, str4, BrandSafetyUtils.AdType.INTERSTITIAL);
        this.f3173L = true;
        this.f3174M = true;
        this.f3176O = false;
        this.f2617o = str5;
    }

    public C1335h(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, long j, int i, int i2, String str5) {
        super(str, str2, str3, screenShotOrientation, str4, BrandSafetyUtils.AdType.INTERSTITIAL);
        this.f3173L = true;
        this.f3174M = true;
        this.f3176O = false;
        this.f2623u = str2;
        this.f2617o = str5;
        mo19497a(str, str4, j, i, i2, screenShotOrientation, false);
    }

    /* renamed from: a */
    public synchronized void mo19497a(String str, String str2, long j, int i, int i2, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean z) {
        this.f2620r = str;
        this.f2621s = str2;
        this.f2622t = j;
        this.f2628z = i;
        this.f2626x = i2;
        this.f2627y = screenShotOrientation;
        this.f3176O = z;
    }

    /* renamed from: s */
    public synchronized void mo19499s() {
        this.f3173L = true;
    }

    /* renamed from: e */
    public void mo19498e(boolean z) {
        this.f3176O = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("hash=").append(this.f2620r != null ? this.f2620r : "").append(", orientation=").append(this.f2627y != null ? this.f2627y.name() : "").append(", ci ").append(this.f2609E != null ? this.f2609E : "");
        return sb.toString();
    }
}

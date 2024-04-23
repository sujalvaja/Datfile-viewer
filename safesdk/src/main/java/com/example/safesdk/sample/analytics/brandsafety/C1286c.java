package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.c */
public class C1286c extends C1285b {

    /* renamed from: K */
    public int f2629K = 0;

    /* renamed from: L */
    public int f2630L = 0;

    /* renamed from: M */
    public int f2631M = 0;

    /* renamed from: N */
    public int f2632N = 0;

    /* renamed from: O */
    public int f2633O = 0;

    /* renamed from: P */
    boolean f2634P = false;

    /* renamed from: Q */
    public String f2635Q = "";

    /* renamed from: R */
    boolean f2636R = false;

    /* renamed from: S */
    boolean f2637S = false;

    /* renamed from: T */
    boolean f2638T = false;

    /* renamed from: U */
    long f2639U = 0;

    /* renamed from: V */
    long f2640V = 0;

    /* renamed from: W */
    float f2641W = 0.0f;

    /* renamed from: X */
    String f2642X = null;

    /* renamed from: Y */
    private boolean f2643Y = false;

    public C1286c(String[] strArr, String str, int i, String str2, Bundle bundle) {
        super(strArr, i, bundle, (String) null, str, (String) null, BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED, BrandSafetyUtils.AdType.BANNER);
        this.f2642X = str2;
    }

    public C1286c(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        super(str, str2, str3, screenShotOrientation, str4, BrandSafetyUtils.AdType.BANNER);
        this.f2617o = str5;
    }

    /* renamed from: s */
    public boolean mo19289s() {
        return this.f2643Y;
    }

    public String toString() {
        return super.toString() + " isNative: " + this.f2643Y + " webView: " + this.f2614J + " hash: " + mo19264b() + " url: " + mo19275g() + " isClicked: " + mo19274f() + " touch timestamp: " + mo19286r() + " activity address: " + this.f2607C + " activity class name: " + this.f2608D + " filename: " + mo19267c() + " type: " + this.f2616n;
    }

    /* renamed from: a */
    public void mo19288a(String str, String str2, long j, int i, int i2, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation) {
        this.f2620r = str;
        this.f2621s = str2;
        this.f2622t = j;
        this.f2628z = i;
        this.f2626x = i2;
        this.f2627y = screenShotOrientation;
    }
}

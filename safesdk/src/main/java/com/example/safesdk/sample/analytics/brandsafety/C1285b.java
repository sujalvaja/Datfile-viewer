package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.utils.Logger;
import java.util.List;
import java.util.UUID;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.b */
public class C1285b {

    /* renamed from: a */
    public static  String f2593a = "AdInfo";

    /* renamed from: b */
    public static  String f2594b = "image_hash";

    /* renamed from: c */
    public static  String f2595c = "sdk_package";

    /* renamed from: d */
    public static  String f2596d = "sdk_uid";

    /* renamed from: e */
    public static  String f2597e = "type";

    /* renamed from: f */
    public static  String f2598f = "ad_format_type";

    /* renamed from: g */
    public static  String f2599g = "response_code";

    /* renamed from: h */
    public static  String f2600h = "image_url";

    /* renamed from: i */
    public static  String f2601i = "image_id";

    /* renamed from: j */
    public static  String f2602j = "image_orientation";

    /* renamed from: k */
    public static  String f2603k = "text";

    /* renamed from: l */
    public static  String f2604l = "safedk_version";

    /* renamed from: A */
    int f2605A;

    /* renamed from: B */
    public Bundle f2606B;

    /* renamed from: C */
    String f2607C;

    /* renamed from: D */
    String f2608D;

    /* renamed from: E */
    CreativeInfo f2609E;

    /* renamed from: F */
    boolean f2610F;

    /* renamed from: G */
    boolean f2611G;

    /* renamed from: H */
    boolean f2612H;

    /* renamed from: I */
    AdNetworkDiscovery.WebViewResourceMatchingMethod f2613I;

    /* renamed from: J */
    String f2614J;

    /* renamed from: m */
    long f2615m;

    /* renamed from: n */
    public BrandSafetyUtils.AdType f2616n;

    /* renamed from: o */
    protected String f2617o;

    /* renamed from: p */
    long f2618p;

    /* renamed from: q */
    String f2619q;

    /* renamed from: r */
    String f2620r;

    /* renamed from: s */
    String f2621s;

    /* renamed from: t */
    long f2622t;

    /* renamed from: u */
    String f2623u;

    /* renamed from: v */
    boolean f2624v;

    /* renamed from: w */
    String f2625w;

    /* renamed from: x */
    int f2626x;

    /* renamed from: y */
    BrandSafetyUtils.ScreenShotOrientation f2627y;

    /* renamed from: z */
    int f2628z;

    public C1285b(String[] strArr, int i, Bundle bundle, String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, BrandSafetyUtils.AdType adType) {
        this(str, str2, str3, screenShotOrientation, (String) null, adType);
        this.f2608D = strArr[0];
        this.f2607C = strArr[1];
        this.f2606B = bundle;
        this.f2605A = i;
    }

    public C1285b(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, BrandSafetyUtils.AdType adType) {
        this.f2615m = 0;
        this.f2622t = 0;
        this.f2624v = false;
        this.f2625w = null;
        this.f2626x = 0;
        this.f2627y = BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED;
        this.f2628z = 0;
        this.f2607C = null;
        this.f2608D = null;
        this.f2609E = null;
        this.f2610F = false;
        this.f2611G = false;
        this.f2612H = false;
        this.f2613I = AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
        this.f2620r = str;
        this.f2623u = str2;
        this.f2619q = str3 == null ? UUID.randomUUID().toString() : str3;
        this.f2627y = screenShotOrientation;
        this.f2621s = str4;
        this.f2618p = System.currentTimeMillis();
        this.f2616n = adType;
        if (str2 != null) {
            this.f2613I = CreativeInfoManager.m3060a(str2);
        }
    }

    /* renamed from: a */
    public long mo19258a() {
        return this.f2618p;
    }

    /* renamed from: b */
    public String mo19264b() {
        return this.f2620r;
    }

    /* renamed from: a */
    public void mo19261a(String str) {
        this.f2620r = str;
    }

    /* renamed from: c */
    public String mo19267c() {
        return this.f2621s;
    }

    /* renamed from: b */
    public void mo19265b(String str) {
        this.f2621s = str;
    }

    /* renamed from: d */
    public long mo19270d() {
        return this.f2622t;
    }

    /* renamed from: a */
    public void mo19259a(long j) {
        this.f2622t = j;
    }

    /* renamed from: e */
    public String mo19273e() {
        return this.f2623u;
    }

    /* renamed from: c */
    public synchronized void mo19268c(String str) {
        this.f2623u = str;
    }

    /* renamed from: f */
    public boolean mo19274f() {
        return this.f2624v;
    }

    /* renamed from: a */
    public void mo19262a(boolean z) {
        this.f2624v = z;
    }

    /* renamed from: g */
    public String mo19275g() {
        return this.f2625w;
    }

    /* renamed from: d */
    public boolean mo19272d(String str) {
        if (this.f2625w != null || (this.f2609E != null && this.f2609E.mo19446x() != null)) {
            return false;
        }
        this.f2625w = str;
        return true;
    }

    /* renamed from: a */
    public void mo19260a(CreativeInfo creativeInfo) {
        this.f2609E = creativeInfo;
    }

    /* renamed from: h */
    public CreativeInfo mo19276h() {
        return this.f2609E;
    }

    /* renamed from: i */
    public synchronized String mo19277i() {
        return this.f2607C;
    }

    /* renamed from: j */
    public synchronized String mo19278j() {
        return this.f2608D;
    }

    /* renamed from: a */
    public synchronized void mo19263a(String[] strArr) {
        this.f2608D = strArr[0];
        this.f2607C = strArr[1];
    }

    /* renamed from: k */
    public synchronized int mo19279k() {
        return this.f2628z;
    }

    /* renamed from: l */
    public synchronized int mo19280l() {
        return this.f2605A;
    }

    /* renamed from: m */
    public synchronized Bundle mo19281m() {
        return this.f2606B;
    }

    /* renamed from: n */
    public synchronized int mo19282n() {
        return this.f2626x;
    }

    /* renamed from: b */
    public void mo19266b(boolean z) {
        this.f2610F = z;
    }

    /* renamed from: c */
    public void mo19269c(boolean z) {
        this.f2611G = z;
    }

    /* renamed from: d */
    public void mo19271d(boolean z) {
        this.f2612H = z;
    }

    /* renamed from: o */
    public String mo19283o() {
        return this.f2619q;
    }

    /* renamed from: p */
    public String mo19284p() {
        return this.f2617o;
    }

    /* renamed from: q */
    public void mo19285q() {
        if (this.f2609E != null) {
            if (this.f2609E != null) {
                List<String> F = this.f2609E.mo19387F();
                if (F != null && F.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String append : F) {
                        sb.append(append).append("\n");
                    }
                    this.f2617o = sb.toString();
                    return;
                }
                return;
            }
            Logger.m3601d(f2593a, "Cannot extract text as Creative info object is null");
        }
    }

    /* renamed from: r */
    public long mo19286r() {
        return this.f2615m;
    }

    public String toString() {
        return " sdk: " + (this.f2623u != null ? this.f2623u : "") + " impressionId: " + (this.f2619q != null ? this.f2619q : "") + " clickUrl: " + (this.f2625w != null ? this.f2625w : "");
    }
}

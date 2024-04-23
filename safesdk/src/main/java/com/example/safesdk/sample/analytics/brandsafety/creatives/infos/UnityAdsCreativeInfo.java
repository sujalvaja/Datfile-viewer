package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;

import java.util.Map;

public class UnityAdsCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    public static  String f3066Y = "admob-video";

    /* renamed from: Z */
    private static  String f3067Z = "playableUrl";

    /* renamed from: aa */
    private static  String f3068aa = "adDomain";

    /* renamed from: ah */
    private static String[] f3069ah = {C1357d.f3603k, C1357d.f3608p};
    private static  long serialVersionUID = 7447619620074487878L;

    /* renamed from: ac */
    private String f3070ac;

    /* renamed from: ad */
    private String f3071ad;

    /* renamed from: ae */
    private String f3072ae;

    /* renamed from: af */
    private String f3073af;

    /* renamed from: ag */
    private String f3074ag;

    public UnityAdsCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String playableAd, String contentType, String adDomain, String adFormat, String placementId, String sdkVersion, String bundleId, String buyerId) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3608p, id, creativeId, clickUrl, videoUrl, contentType);
        this.f3070ac = playableAd;
        this.f3071ad = adDomain;
        this.f3030ar = adFormat;
        this.f3003K = placementId;
        this.f3008Q = sdkVersion;
        if (TextUtils.isEmpty(this.f3004M)) {
            this.f3004M = bundleId;
        }
        this.f3028ap = buyerId;
        this.f3014W = !TextUtils.isEmpty(this.f3070ac);
    }

    /* renamed from: b */
    public void mo19456b(String str, String str2) {
        this.f3072ae = str;
        this.f3073af = str2;
        if (!TextUtils.isEmpty(str2)) {
            this.f3011T = true;
        }
    }

    /* renamed from: b */
    public void mo19380b(String str) {
        this.f3074ag = str;
        if (!TextUtils.isEmpty(str)) {
            this.f3011T = true;
        }
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (!TextUtils.isEmpty(this.f3070ac)) {
            b.putString(f3067Z, this.f3070ac);
        }
        if (!TextUtils.isEmpty(this.f3071ad)) {
            b.putString(f3068aa, this.f3071ad);
        }
        if (mo19447y() == null || (this.f3001I && this.f3072ae != null)) {
            b.putString("creative_id", this.f3072ae);
        }
        if (this.f3002J == null || (this.f3001I && this.f3073af != null)) {
            b.putString(CreativeInfo.f2975e, this.f3073af);
        }
        return b;
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return TextUtils.isEmpty(mo19447y()) || TextUtils.isEmpty(mo19446x());
    }

    
    /* renamed from: p */
    public boolean mo19430p(String str) {
        if (this.f2998F.contains(f3066Y)) {
            return C1308d.m3133a(f3069ah, str);
        }
        return super.mo19430p(str);
    }

    
    /* renamed from: c */
    public boolean mo19381c(String str) {
        if (this.f2998F.contains(f3066Y)) {
            return AdMobCreativeInfo.m3244b(str) || C1361h.m3687a(str, (Map<String, String>) null) || C1361h.m3713k(str);
        }
        return super.mo19381c(str);
    }
}

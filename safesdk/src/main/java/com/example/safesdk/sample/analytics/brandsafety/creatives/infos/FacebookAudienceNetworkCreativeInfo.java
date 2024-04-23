package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;


public class FacebookAudienceNetworkCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    public static  String f3035Y = "unknown";

    /* renamed from: Z */
    public static  String f3036Z = "template";

    /* renamed from: a */
    public static  String f3037a = "placementId";

    /* renamed from: aa */
    public static  String f3038aa = "markup";

    /* renamed from: ab */
    public static  String f3039ab = "end_card_markup";

    /* renamed from: ac */
    public static  String f3040ac = "template_carousel";

    /* renamed from: ad */
    String f3041ad;

    public FacebookAudienceNetworkCreativeInfo(BrandSafetyUtils.AdType adType, String id, String clickUrl, String videoUrl, String placementId, String downstreamStruct) {
        super(adType, "com.facebook.ads", id, (String) null, clickUrl, videoUrl, downstreamStruct);
        this.f3000H = true;
        this.f3041ad = placementId;
    }

    /* renamed from: q */
    public String mo19431q() {
        return super.mo19431q() + this.f3041ad;
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        b.putString(f3037a, this.f3041ad);
        return b;
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return TextUtils.isEmpty(this.f3041ad) || (TextUtils.isEmpty(mo19446x()) && TextUtils.isEmpty(this.f3002J));
    }
}

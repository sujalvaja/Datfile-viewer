package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;


public class AppLovinCreativeInfo extends CreativeInfo {
    private static  long serialVersionUID = 909322237728593140L;

    /* renamed from: a */
    private String f2960a;

    public AppLovinCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String videoUrl, String adFormatType, String placementId, String sdkVersion, String struct, String dspName, String eventId, String appPackageName, boolean isVideoAd, boolean isPlayable) {
        super(adType, C1357d.f3593a, id, creativeId, clickUrl, videoUrl, struct);
        this.f3003K = placementId;
        this.f3030ar = adFormatType;
        this.f3008Q = sdkVersion;
        this.f2960a = dspName;
        this.f3011T = isVideoAd;
        this.f3014W = isPlayable;
        if (mo19437t() == null && appPackageName != null) {
            mo19421l(appPackageName);
        }
        mo19405d(eventId);
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return TextUtils.isEmpty(mo19447y()) || TextUtils.isEmpty(mo19446x());
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (!TextUtils.isEmpty(this.f2960a)) {
            b.putString("buyer_id", this.f2960a);
        }
        return b;
    }
}

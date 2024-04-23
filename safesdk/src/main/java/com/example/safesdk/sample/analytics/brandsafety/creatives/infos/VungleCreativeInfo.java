package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;

import java.sql.Timestamp;

public class VungleCreativeInfo extends CreativeInfo {

    /* renamed from: a */
    public static  String f3075a = "vungle_mraid";
    private static  long serialVersionUID = -7630682732175543531L;

    /* renamed from: Y */
    private boolean f3076Y = false;

    public VungleCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String adFormat, String placement_id, String sdkVersion, long expiry, String struct) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3596d, id, creativeId, clickUrl, videoUrl, struct);
        this.f3030ar = adFormat;
        this.f3003K = placement_id;
        this.f3008Q = sdkVersion;
        this.f3009R = new Timestamp(expiry);
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return TextUtils.isEmpty(mo19447y()) || TextUtils.isEmpty(mo19446x());
    }

    /* renamed from: a */
    public void mo19395a(boolean z) {
    }

    /* renamed from: p */
    public boolean mo19430p(String str) {
        return super.mo19430p(str);
    }

    /* renamed from: t */
    public String mo19437t() {
        return this.f3004M;
    }

    /* renamed from: l */
    public void mo19421l(String str) {
        this.f3004M = str;
    }

    /* renamed from: J */
    public boolean mo19457J() {
        return this.f3076Y;
    }

    /* renamed from: f */
    public void mo19458f(boolean z) {
        this.f3076Y = z;
    }
}

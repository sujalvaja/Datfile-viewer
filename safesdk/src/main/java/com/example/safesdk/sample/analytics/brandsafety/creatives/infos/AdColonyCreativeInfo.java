package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.utils.C1357d;

import java.util.ArrayList;
import java.util.List;

public class AdColonyCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    private static  String f2952Y = "AdColonyCreativeInfo";

    /* renamed from: a */
    public static  String f2953a = "manifest_url";
    private static  long serialVersionUID = -5937630405018276749L;

    /* renamed from: Z */
    private String f2954Z;

    /* renamed from: aa */
    private String f2955aa;

    /* renamed from: ab */
    private List<String> f2956ab = new ArrayList();

    /* renamed from: ac */
    private List<String> f2957ac = new ArrayList();

    public AdColonyCreativeInfo(String id, String creativeId, String campaignId, String clickUrl, String videoUrl, String adFormat, String placementId, String sdkVersion, boolean isPlayable, String struct) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3594b, id, creativeId, clickUrl, videoUrl, struct);
        this.f2954Z = campaignId;
        this.f3030ar = adFormat;
        this.f3003K = placementId;
        this.f3008Q = sdkVersion;
        this.f3014W = isPlayable;
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return TextUtils.isEmpty(mo19447y()) || TextUtils.isEmpty(mo19446x());
    }

    /* renamed from: a */
    public void mo19377a(List<String> list, List<String> list2) {
        if (list != null) {
            this.f2956ab.addAll(list);
        }
        if (list2 != null) {
            this.f2957ac.addAll(list2);
        }
    }

    /* renamed from: a */
    public void mo19376a(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u) && !this.f2957ac.contains(u)) {
            super.mo19376a(u);
        }
    }

    /* renamed from: b */
    public void mo19380b(String str) {
        this.f2955aa = str;
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (!TextUtils.isEmpty(this.f2954Z)) {
            b.putString(CreativeInfo.f2964D, this.f2954Z);
        }
        if (this.f2956ab != null && !this.f2956ab.isEmpty()) {
            b.putStringArrayList(BrandSafetyEvent.f3224u, new ArrayList(this.f2956ab));
        }
        if (this.f2955aa != null && !this.f2955aa.isEmpty()) {
            b.putString(f2953a, this.f2955aa);
        }
        return b;
    }
}

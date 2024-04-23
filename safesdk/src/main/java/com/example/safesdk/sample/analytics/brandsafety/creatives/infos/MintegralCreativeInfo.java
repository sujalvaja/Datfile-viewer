package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MintegralCreativeInfo extends CreativeInfo {

    /* renamed from: aa */
    private static  String f3062aa = "MintegralCreativeInfo";
    private static  long serialVersionUID = 5780851683333587923L;

    /* renamed from: Y */
    private Set<String> f3063Y = new HashSet();

    /* renamed from: Z */
    private boolean f3064Z = false;

    /* renamed from: a */
    private ArrayList<String> f3065a = new ArrayList<>();

    public MintegralCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String adFormat, String placement_id, String sdkVersion, String downstreamStruct, boolean playableAd, String packageName) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3612t, id, creativeId, clickUrl, videoUrl, downstreamStruct);
        this.f3030ar = adFormat;
        this.f3003K = placement_id;
        this.f3008Q = sdkVersion;
        this.f3004M = packageName;
        this.f3014W = playableAd;
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (this.f3064Z && !this.f3065a.isEmpty()) {
            b.putStringArrayList(BrandSafetyEvent.f3224u, new ArrayList(this.f3065a));
        }
        return b;
    }

    /* renamed from: a */
    public void mo19454a(String str, Set<String> set) {
        mo19455b(str, set);
        this.f3064Z = true;
    }

    /* renamed from: b */
    public void mo19455b(String str, Set<String> set) {
        Logger.m3601d(f3062aa, "addRecommendations: " + str + ", resourcesList=" + set.toString());
        this.f3065a.add(str);
        for (String u : set) {
            String u2 = mo19440u(u);
            if (!TextUtils.isEmpty(u2)) {
                this.f3063Y.add(u2);
                if (this.f3006O.contains(u2)) {
                    Logger.m3601d(f3062aa, "removing recommendation resource " + u2 + " from WebView resource urls");
                    this.f3006O.remove(u2);
                }
            }
        }
    }

    /* renamed from: q */
    public void mo19432q(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u)) {
            Logger.m3601d(f3062aa, "addDspDomainUrl: " + u + ", recommendationsResources=" + this.f3063Y.toString());
            if (!this.f3063Y.contains(u)) {
                super.mo19432q(u);
            } else {
                this.f3064Z = true;
            }
        }
    }

    /* renamed from: a */
    public void mo19376a(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u)) {
            Logger.m3601d(f3062aa, "addResourceUrl: " + u + ", recommendationsResources=" + this.f3063Y.toString());
            if (!this.f3063Y.contains(u)) {
                super.mo19376a(u);
            } else {
                this.f3064Z = true;
            }
        }
    }
}

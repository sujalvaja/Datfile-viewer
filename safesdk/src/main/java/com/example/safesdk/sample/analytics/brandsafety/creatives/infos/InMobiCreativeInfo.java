package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1317f;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.utils.C1357d;
import java.util.ArrayList;
import java.util.HashSet;

public class InMobiCreativeInfo extends CreativeInfo {

    /* renamed from: aa */
    private static  String f3052aa = "InMobiCreativeInfo";
    private static  long serialVersionUID = 5552604508381236855L;

    /* renamed from: Y */
    private String f3053Y;

    /* renamed from: Z */
    private ArrayList<String> f3054Z = new ArrayList<>();

    /* renamed from: a */
    transient ArrayList<C1317f.C1318a> f3055a;

    public InMobiCreativeInfo(String id, String creativeId, String videoUrl, String clickUrl, String placementId, String appPackageName, String sdkVersion, String downstreamStruct, ArrayList<C1317f.C1318a> vastAdInfos, BrandSafetyUtils.AdType adType, BrandSafetyEvent.AdFormatType adFormat, String eventId) {
        super(adType, C1357d.f3605m, id, creativeId, clickUrl, videoUrl, downstreamStruct);
        this.f3003K = placementId;
        this.f3053Y = id;
        this.f3004M = appPackageName;
        this.f3008Q = sdkVersion;
        this.f3055a = vastAdInfos;
        if (adFormat != null) {
            this.f3030ar = adFormat == BrandSafetyEvent.AdFormatType.LEADER ? BrandSafetyEvent.AdFormatType.BANNER.name() : adFormat.name();
        } else if (adType != null) {
            this.f3030ar = adType == BrandSafetyUtils.AdType.INTERSTITIAL ? BrandSafetyEvent.AdFormatType.INTER.name() : BrandSafetyEvent.AdFormatType.BANNER.name();
        }
        mo19405d(eventId);
    }

    /* renamed from: b */
    public void mo19380b(String str) {
        this.f2998F = str;
    }

    /* renamed from: J */
    public ArrayList<C1317f.C1318a> mo19449J() {
        return this.f3055a;
    }

    /* renamed from: b */
    public void mo19451b(ArrayList<C1317f.C1318a> arrayList) {
        this.f3055a = arrayList;
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (this.f3054Z != null && !this.f3054Z.isEmpty()) {
            b.putStringArrayList(BrandSafetyEvent.f3224u, new ArrayList(this.f3054Z));
        }
        return b;
    }

    /* renamed from: x */
    public void mo19452x(String str) {
        this.f3054Z.add(str);
    }

    /* renamed from: K */
    public synchronized void mo19450K() {
        mo19408e((String) null);
        this.f3002J = null;
        this.f3004M = null;
        this.f3007P = new HashSet();
        this.f3005N = new HashSet();
    }
}

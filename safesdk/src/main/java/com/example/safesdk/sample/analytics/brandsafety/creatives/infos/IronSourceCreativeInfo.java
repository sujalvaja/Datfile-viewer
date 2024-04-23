package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.text.TextUtils;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;


public class IronSourceCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    private static  String f3056Y = "playableAd";

    /* renamed from: Z */
    private static  String f3057Z = "creativeURL&quot;:&quot;";

    /* renamed from: a */
    private static  String f3058a = "cpvi";
    private static  long serialVersionUID = 583040939198244951L;

    /* renamed from: aa */
    private String f3059aa;

    /* renamed from: ab */
    private String f3060ab;

    /* renamed from: ac */
    private String f3061ac;

    public IronSourceCreativeInfo(String id, String creativeId, String clickUrl, String videoUrl, String adType, String playableAd, String adFormat, String placementId, String sdkVersion) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3599g, id, creativeId, clickUrl, videoUrl, adType);
        this.f3059aa = playableAd;
        mo19434r(this.f3059aa);
        this.f3030ar = adFormat;
        this.f3003K = placementId;
        this.f3008Q = sdkVersion;
        this.f3060ab = adType;
        this.f3011T = false;
        this.f3014W = !TextUtils.isEmpty(playableAd);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r4.equals(f3058a) != false) goto L_0x0024;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo19378a() {
        /*
            r6 = this;
            r3 = 1
            r1 = 0
            java.lang.String r0 = r6.mo19447y()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = r6.mo19446x()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0028
        L_0x0016:
            r0 = r3
        L_0x0017:
            if (r0 != 0) goto L_0x0027
            java.lang.String r4 = r6.f3060ab
            r2 = -1
            int r5 = r4.hashCode()
            switch(r5) {
                case 3060704: goto L_0x002a;
                case 1967260497: goto L_0x0033;
                default: goto L_0x0023;
            }
        L_0x0023:
            r1 = r2
        L_0x0024:
            switch(r1) {
                case 0: goto L_0x003d;
                case 1: goto L_0x0044;
                default: goto L_0x0027;
            }
        L_0x0027:
            return r0
        L_0x0028:
            r0 = r1
            goto L_0x0017
        L_0x002a:
            java.lang.String r3 = "cpvi"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0033:
            java.lang.String r1 = "playableAd"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0023
            r1 = r3
            goto L_0x0024
        L_0x003d:
            java.lang.String r0 = r6.f3002J
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            goto L_0x0027
        L_0x0044:
            java.lang.String r0 = r6.f3059aa
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.infos.IronSourceCreativeInfo.mo19378a():boolean");
    }

    /* renamed from: J */
    public String mo19453J() {
        return this.f3061ac;
    }

    /* renamed from: v */
    public void mo19443v(String str) {
        super.mo19443v(str);
        if (str != null && str.indexOf(f3057Z) > -1) {
            this.f3061ac = str.split(f3057Z)[1].split("&quot;,&quot;")[0];
        }
    }
}

package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;


public class AdMobCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    private static String[] f2958Y = {"googleusercontent.com", "/simgad/", "mts0.google.com", "gstatic.com", "pageadimg/imgad"};

    /* renamed from: a */
    private static  String f2959a = "AdMobCreativeInfo";
    private static  long serialVersionUID = -3498860760603370212L;

    public AdMobCreativeInfo(String id, BrandSafetyUtils.AdType adType, String creativeId, String clickUrl, String placementId, String videoUrl, String adFormat, String sdkVersion, String downstreamStruct, String appPackageName) {
        super(adType, C1357d.f3603k, id, creativeId, clickUrl, videoUrl, downstreamStruct);
        this.f3003K = placementId;
        this.f3030ar = adFormat;
        this.f3008Q = sdkVersion;
        if (mo19437t() == null && appPackageName != null) {
            mo19421l(appPackageName);
        }
    }

    /* renamed from: b */
    public static boolean m3244b(String str) {
        boolean z = false;
        String[] strArr = f2958Y;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (str.contains(strArr[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        Logger.m3601d(f2959a, "isAdmobKnownDomainUrl returned " + z + " for " + str);
        return z;
    }

    
    /* renamed from: c */
    public boolean mo19381c(String str) {
        boolean z;
        StringBuilder append = new StringBuilder().append("Is Prefetch Url ?  ");
        if (m3244b(str) || super.mo19381c(str)) {
            z = true;
        } else {
            z = false;
        }
        Logger.m3601d(f2959a, append.append(z).append(" for ").append(str).toString());
        if (m3244b(str) || super.mo19381c(str)) {
            return true;
        }
        return false;
    }
}

package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;

import java.util.Arrays;
import java.util.List;

public class FyberCreativeInfo extends CreativeInfo {

    /* renamed from: Y */
    private static  String f3042Y = "FyberCreativeInfo";

    /* renamed from: Z */
    private static  String f3043Z = "ad_domain";

    /* renamed from: a */
    public static  String f3044a = "buyer_id";

    /* renamed from: aa */
    private static  String f3045aa = "alternative_click_url";

    /* renamed from: ab */
    private static  List<String> f3046ab = Arrays.asList(new String[]{"gif", "jpg", "jpeg", "png"});

    /* renamed from: ac */
    private static  List<String> f3047ac = Arrays.asList(new String[]{"www.serveroute.com/log_string", "column=", "line=", "ad_exchange=inneractive&mraid_version="});
    private static  long serialVersionUID = -5726627304425536096L;

    /* renamed from: ad */
    private String f3048ad;

    /* renamed from: ae */
    private String f3049ae;

    /* renamed from: af */
    private String f3050af;

    /* renamed from: ag */
    private String f3051ag;

    public FyberCreativeInfo(String id, String creativeId, String campaignId, String clickUrl, String videoUrl, String adFormat, String spotId, String sdkVersion, String adNetwork, String adDomain, String alternativeClickUrl) {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, C1357d.f3613u, id, creativeId, clickUrl, videoUrl, "");
        this.f3003K = spotId;
        Logger.m3601d(f3042Y, "FyberCreativeInfo ctor started");
        this.f3030ar = adFormat;
        this.f3048ad = campaignId;
        this.f3008Q = sdkVersion;
        this.f3049ae = adNetwork;
        this.f3050af = adDomain;
        this.f3051ag = alternativeClickUrl;
    }

    /* renamed from: b */
    public void mo19380b(String str) {
        this.f2998F = str;
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return false;
    }

    /* renamed from: b */
    public Bundle mo19379b() {
        Bundle b = super.mo19379b();
        if (!TextUtils.isEmpty(this.f3048ad)) {
            b.putString(CreativeInfo.f2964D, this.f3048ad);
        }
        if (!TextUtils.isEmpty(this.f3049ae)) {
            b.putString("buyer_id", this.f3049ae);
        }
        if (!TextUtils.isEmpty(this.f3050af)) {
            b.putString(f3043Z, this.f3050af);
        }
        if (!TextUtils.isEmpty(this.f3051ag)) {
            b.putString(f3045aa, this.f3051ag);
        }
        return b;
    }

    /* renamed from: b */
    public void mo19397b(List<String> list) {
        Logger.m3601d(f3042Y, "classifyPrefetchUrl started, urlList=" + list);
        if (list != null) {
            for (String u : list) {
                String u2 = mo19440u(u);
                boolean z = false;
                if (!TextUtils.isEmpty(u2)) {
                    if (m3323x(u2)) {
                        mo19432q(u2);
                        z = true;
                    } else if (mo19381c(u2)) {
                        mo19434r(u2);
                        z = true;
                    } else if (mo19430p(u2) && !u2.equals(mo19446x())) {
                        mo19432q(u2);
                        z = true;
                    }
                    if (!z) {
                        Logger.m3601d(f3042Y, "classifyPrefetchUrl url is unclassified and will be dropped : " + u2);
                    }
                }
            }
        }
    }

    /* renamed from: x */
    public static boolean m3323x(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        Logger.m3601d(f3042Y, "extension: " + fileExtensionFromUrl + " for url: " + str);
        if (f3046ab.contains(fileExtensionFromUrl)) {
            Logger.m3601d(f3042Y, "checking for tracking url pattern, extension: " + fileExtensionFromUrl + " for url: " + str);
            if (str.indexOf("?") > 0) {
                return true;
            }
        }
        return false;
    }
}

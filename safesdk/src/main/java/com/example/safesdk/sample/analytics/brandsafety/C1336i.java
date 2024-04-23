package com.example.safesdk.sample.analytics.brandsafety;

import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.i */
public class C1336i {

    /* renamed from: a */
    CreativeInfo f3177a;

    /* renamed from: b */
    String f3178b;

    /* renamed from: c */
    String f3179c;

    public C1336i(CreativeInfo creativeInfo, String str, String str2) {
        this.f3177a = creativeInfo;
        this.f3178b = str;
        this.f3179c = System.currentTimeMillis() + ";" + str2;
    }

    public String toString() {
        return "what?: " + this.f3177a.toString() + " how? " + this.f3178b + " when?: " + this.f3179c;
    }
}

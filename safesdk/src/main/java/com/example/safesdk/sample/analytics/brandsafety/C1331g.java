package com.example.safesdk.sample.analytics.brandsafety;

import android.os.Bundle;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.C1269b;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.g */
public class C1331g {

    /* renamed from: A */
    private static  String f3122A = ".jpg";

    /* renamed from: B */
    private static C1331g f3123B = null;

    /* renamed from: C */
    private static  Object f3124C = new Object();

    /* renamed from: a */
    public static  int f3125a = 2;

    /* renamed from: b */
    public static  String f3126b = "fingerprint";

    /* renamed from: c */
    private static  String f3127c = "ImageUploadManager";

    /* renamed from: d */
    private static  String f3128d = "type";

    /* renamed from: e */
    private static  String f3129e = "hash";

    /* renamed from: f */
    private static  String f3130f = "sdk";

    /* renamed from: g */
    private static  String f3131g = "keys";

    /* renamed from: h */
    private static  String f3132h = "images_to_upload";

    /* renamed from: i */
    private static  String f3133i = "images_to_discard";

    /* renamed from: j */
    private static  String f3134j = "s3_access_tokens";

    /* renamed from: k */
    private static  String f3135k = "resolve_urls";

    /* renamed from: l */
    private static  String f3136l = "url";

    /* renamed from: m */
    private static  String f3137m = "base_url";

    /* renamed from: n */
    private static  String f3138n = "attributes";

    /* renamed from: o */
    private static  String f3139o = "bucket";

    /* renamed from: p */
    private static  String f3140p = "x-amz-date";

    /* renamed from: q */
    private static  String f3141q = "signature";

    /* renamed from: r */
    private static  String f3142r = "AWSAccessKeyId";

    /* renamed from: s */
    private static  String f3143s = "acl";

    /* renamed from: t */
    private static  String f3144t = "x-amz-server-side-encryption";

    /* renamed from: u */
    private static  String f3145u = "x-amz-algorithm";

    /* renamed from: v */
    private static  String f3146v = "x-amz-credential";

    /* renamed from: w */
    private static  String f3147w = "policy";

    /* renamed from: x */
    private static  String f3148x = "s3_key_prefix";

    /* renamed from: y */
    private static  String f3149y = "image_id";

    /* renamed from: z */
    private static  String f3150z = "Content-Type";

    /* renamed from: D */
    private int f3151D = SafeDK.getInstance().mo19151u();

    private C1331g() {
        m3399b();
        Logger.m3601d(f3127c, "Max images to upload = " + this.f3151D);
    }

    /* renamed from: b */
    private void m3399b() {
        AppLovinBridge.registerListener(AppLovinBridge.f2361b, new C1269b() {
            /* renamed from: a */
            public void mo19209a(String str, Bundle bundle) {
                Logger.m3601d(C1331g.f3127c, "Response received");
                C1331g.this.m3397a(bundle);
            }
        });
    }

    /* renamed from: a */
    public void m3397a(Bundle bundle) {
        try {
            synchronized (f3124C) {
                Logger.m3601d(f3127c, "Response from server: " + bundle.toString());
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                if (bundle.containsKey(f3134j)) {
                    Bundle bundle2 = bundle.getBundle(f3134j);
                    Logger.m3601d(f3127c, "s3AccessTokens=" + bundle2.toString());
                    str = bundle2.getString(f3137m);
                    Bundle bundle3 = bundle2.getBundle(f3138n);
                    str2 = bundle3.getString(f3139o);
                    str3 = bundle3.getString(f3140p);
                    str4 = bundle3.getString(f3141q);
                    str5 = bundle3.getString(f3142r);
                    str6 = bundle3.getString(f3143s);
                    str7 = bundle3.getString(f3144t);
                    str8 = bundle3.getString(f3145u);
                    str9 = bundle3.getString(f3146v);
                    str10 = bundle3.getString(f3147w);
                    str11 = bundle3.getString(f3150z);
                    Logger.m3601d(f3127c, "s3 credentials collected");
                }
                ArrayList arrayList = new ArrayList();
                if (bundle.containsKey(f3132h)) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList(f3132h);
                    Logger.m3601d(f3127c, "imagesToUploadArrayList=" + stringArrayList.toString());
                /*    for (int i = 0; i < stringArrayList.size(); i++) {
                        Bundle bundle4 = (Bundle) stringArrayList.get(i);
                        String string = bundle4.getString(f3126b);
                        String string2 = bundle4.getString("image_id");
                        String string3 = bundle4.getString(f3148x);
                        Logger.m3601d(f3127c, "imagesToUploadBundle item : fingerprint=" + string + ", imageId=" + string2 + ", s3KeyPrefix=" + string3);
                        C1333a aVar = new C1333a(str5, str10, str4, string3, str2, str, str5, str6, str8, str3, str7, str9, str11);
                        BrandSafetyUtils.AdType adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                        Logger.m3601d(f3127c, "Image for upload added : " + string3);
                        arrayList.add(new C1334b(adType, string2, aVar, string));
                    }*/
                    int size = arrayList.size() > this.f3151D ? this.f3151D : arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C1334b bVar = (C1334b) arrayList.get(i2);
                        C1319d t = SafeDK.getInstance().mo19150t();
                        if (t != null) {
                            Logger.m3601d(f3127c, "Executing image upload request");
                            t.mo19462a(bVar.f3169c, bVar.f3168b, bVar.f3170d);
                        } else {
                            Logger.m3601d(f3127c, "Upload: Handler not found for ad type " + bVar.f3167a.name());
                        }
                    }
                }
                if (bundle.containsKey(f3135k)) {
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList(f3135k);
                    Logger.m3601d(f3127c, "clickUrlsToResolveArrayList=" + stringArrayList2.toString());
                  /*  for (int i3 = 0; i3 < stringArrayList2.size(); i3++) {
                        Bundle bundle5 = (Bundle) stringArrayList2.get(i3);
                        String string4 = bundle5.getString(f3126b);
                        String string5 = bundle5.getString("url");
                        Logger.m3601d(f3127c, "clickUrlsToResolveBundle item : fingerprint=" + string4 + ", url=" + string5);
                        if (string4 == null || string5 == null) {
                            Logger.m3601d(f3127c, "fingerprint and url are null, skipping");
                        } else {
                            C1324f.m3378a().mo19474a(string5, string4);
                        }
                    }*/
                }
                if (bundle.containsKey(f3133i)) {
                    ArrayList<String> stringArrayList3 = bundle.getStringArrayList(f3133i);
                    Logger.m3601d(f3127c, "Images to discard : " + stringArrayList3.toString());
                    Iterator<String> it = stringArrayList3.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        C1319d t2 = SafeDK.getInstance().mo19150t();
                        if (t2 != null) {
                            Logger.m3601d(f3127c, "Executing image discard request for hash " + next);
                            t2.mo19463a(next);
                        } else {
                            Logger.m3601d(f3127c, "Discard : Handler not found for image id " + next);
                        }
                    }
                }
                if (bundle.isEmpty() || !bundle.containsKey(f3132h)) {
                    m3400c();
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3127c, "Failed to handle response from server", th);
            Logger.printStackTrace();
            new CrashReporter().caughtException(th);
        }
    }

    /* renamed from: c */
    private void m3400c() {
        C1319d t = SafeDK.getInstance().mo19150t();
        if (t != null) {
            Logger.m3601d(f3127c, "Executing image cleanup request");
            t.mo19459a();
            return;
        }
        Logger.m3601d(f3127c, "Upload: Handler not found for image cleanup request");
    }

    /* renamed from: a */
    public static synchronized C1331g m3396a() {
        C1331g gVar;
        synchronized (C1331g.class) {
            if (f3123B == null) {
                f3123B = new C1331g();
            }
            gVar = f3123B;
        }
        return gVar;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.g$a */
    public class C1333a {

        /* renamed from: a */
        String f3153a;

        /* renamed from: b */
        String f3154b;

        /* renamed from: c */
        String f3155c;

        /* renamed from: d */
        String f3156d;

        /* renamed from: e */
        String f3157e;

        /* renamed from: f */
        String f3158f;

        /* renamed from: g */
        String f3159g;

        /* renamed from: h */
        String f3160h;

        /* renamed from: i */
        String f3161i;

        /* renamed from: j */
        String f3162j;

        /* renamed from: k */
        String f3163k;

        /* renamed from: l */
        String f3164l;

        /* renamed from: m */
        String f3165m;

        public C1333a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
            this.f3153a = str;
            this.f3154b = str2;
            this.f3155c = str3;
            this.f3156d = str4;
            this.f3157e = str5;
            this.f3158f = str6;
            this.f3159g = str7;
            this.f3160h = str8;
            this.f3161i = str9;
            this.f3162j = str10;
            this.f3163k = str11;
            this.f3164l = str12;
            this.f3165m = str13;
            Logger.m3601d(C1331g.f3127c, "AwsUploadParams ctor, awsAccessKey=" + str + ", keyPrefix=" + str4 + ", bucket=" + str5);
        }

        /* renamed from: a */
        public String mo19484a() {
            return this.f3153a;
        }

        /* renamed from: b */
        public String mo19485b() {
            return this.f3154b;
        }

        /* renamed from: c */
        public String mo19486c() {
            return this.f3155c;
        }

        /* renamed from: d */
        public String mo19487d() {
            return this.f3156d;
        }

        /* renamed from: e */
        public String mo19488e() {
            return this.f3157e;
        }

        /* renamed from: f */
        public String mo19489f() {
            return this.f3158f;
        }

        /* renamed from: g */
        public String mo19490g() {
            return this.f3160h;
        }

        /* renamed from: h */
        public String mo19491h() {
            return this.f3161i;
        }

        /* renamed from: i */
        public String mo19492i() {
            return this.f3162j;
        }

        /* renamed from: j */
        public String mo19493j() {
            return this.f3163k;
        }

        /* renamed from: k */
        public String mo19494k() {
            return this.f3164l;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BaseUrl=" + this.f3158f + ", keyPrefix = " + this.f3156d);
            return sb.toString();
        }
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.g$b */
    class C1334b implements Comparable {

        /* renamed from: a */
        BrandSafetyUtils.AdType f3167a;

        /* renamed from: b */
        String f3168b;

        /* renamed from: c */
        C1333a f3169c;

        /* renamed from: d */
        String f3170d;

        C1334b(BrandSafetyUtils.AdType adType, String str, C1333a aVar, String str2) {
            this.f3167a = adType;
            this.f3168b = str;
            this.f3169c = aVar;
            this.f3170d = str2;
        }

        public int compareTo(Object compareTo) {
            return this.f3167a.ordinal() - ((C1334b) compareTo).f3167a.ordinal();
        }
    }
}

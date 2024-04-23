package com.example.safesdk.sample.analytics.brandsafety;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.k */
public class C1338k {

    /* renamed from: a */
    private String f3187a;

    /* renamed from: b */
    private String f3188b;

    /* renamed from: c */
    private long f3189c = 0;

    /* renamed from: a */
    public String mo19503a() {
        return this.f3188b;
    }

    /* renamed from: a */
    public void mo19505a(String str) {
        this.f3188b = str;
    }

    /* renamed from: b */
    public long mo19506b() {
        return this.f3189c;
    }

    /* renamed from: a */
    public void mo19504a(long j) {
        this.f3189c = j;
    }

    private C1338k() {
    }

    public C1338k(String str, String str2, long j) {
        this.f3187a = str;
        this.f3188b = str2;
        this.f3189c = j;
    }

    /* renamed from: c */
    public String mo19507c() {
        return m3421a(this.f3187a, this.f3189c);
    }

    /* renamed from: a */
    public static String m3421a(String str, long j) {
        return str + "_" + j;
    }
}

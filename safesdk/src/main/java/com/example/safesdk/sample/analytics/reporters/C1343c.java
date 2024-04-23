package com.example.safesdk.sample.analytics.reporters;

/* renamed from: com.example.safesdk.sample.analytics.reporters.c */
public class C1343c {

    /* renamed from: a */
    public static  String f3334a = "application";

    /* renamed from: b */
    private StackTraceElement f3335b;

    /* renamed from: c */
    private String f3336c;

    /* renamed from: d */
    private String f3337d;

    /* renamed from: e */
    private int f3338e;

    public C1343c(StackTraceElement stackTraceElement, String str) {
        this.f3335b = stackTraceElement;
        this.f3336c = str;
    }

    public C1343c(StackTraceElement stackTraceElement) {
        this.f3335b = stackTraceElement;
        this.f3336c = "application";
    }

    /* renamed from: a */
    public StackTraceElement mo19557a() {
        return this.f3335b;
    }

    /* renamed from: b */
    public String mo19559b() {
        return this.f3336c;
    }

    /* renamed from: c */
    public int mo19560c() {
        return this.f3338e;
    }

    /* renamed from: a */
    public void mo19558a(int i) {
        this.f3338e = i;
    }
}

package com.example.safesdk.sample.internal;


import androidx.annotation.NonNull;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.example.safesdk.sample.internal.e */
public class C1350e extends FileOutputStream implements C1348c {

    /* renamed from: a */
    private static String f3516a = "SafeDKFileOutputStream";

    /* renamed from: b */
    private C1352g f3517b;

    public C1350e(String str, String str2, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(str2);
        this.f3517b = new C1352g(str, str2, fileOutputStream);
        this.f3517b.mo19639a(this);
    }

    public void write(int i) throws IOException {
        this.f3517b.write(i);
    }

    public void write(@NonNull byte[] b) throws IOException {
        this.f3517b.write(b);
    }

    public void write(@NonNull byte[] b, int off, int len) throws IOException {
        this.f3517b.write(b, off, len);
    }

    public void close() throws IOException {
        this.f3517b.close();
    }

    /* renamed from: a */
    public void mo19581a(String str, String str2, String str3) {
        Logger.m3601d(f3516a, "onStreamClose " + this + " sdkPackageName: " + str + ", url: " + str2);
        C1361h.m3694b(f3516a, str3);
        CreativeInfoManager.m3075a(str, str2, str3);
    }

    public void flush() throws IOException {
        this.f3517b.flush();
    }
}

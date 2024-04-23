package com.example.safesdk.sample.internal;


import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.example.safesdk.sample.internal.g */
public class C1352g extends OutputStream implements C1348c {

    /* renamed from: a */
    private static  String f3527a = "SafeDKOutputStream";

    /* renamed from: b */
    private String f3528b;

    /* renamed from: c */
    private OutputStream f3529c;

    /* renamed from: d */
    private String f3530d;

    /* renamed from: e */
    private ByteArrayOutputStream f3531e = new ByteArrayOutputStream();

    /* renamed from: f */
    private C1348c f3532f = this;

    public C1352g(String str, String str2, OutputStream outputStream) {
        this.f3528b = str;
        this.f3530d = str2;
        this.f3529c = outputStream;
    }

    public void write(int i) throws IOException {
        this.f3529c.write(i);
        if (i >= 0) {
            try {
                this.f3531e.write(i);
            } catch (Throwable th) {
            }
        }
    }

    public void write( byte[] b) throws IOException {
        this.f3529c.write(b);
        m3569a(b, 0, b.length);
    }

    public void write( byte[] b, int off, int len) throws IOException {
        this.f3529c.write(b, off, len);
        m3569a(b, off, len);
    }

    public void close() throws IOException {
        this.f3529c.close();
        String byteArrayOutputStream = this.f3531e.toString();
        Logger.m3601d(f3527a, "close " + this + " value:");
        this.f3532f.mo19581a(this.f3528b, this.f3530d, byteArrayOutputStream);
    }

    public void flush() throws IOException {
        this.f3529c.flush();
    }

    /* renamed from: a */
    private void m3569a(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            try {
                this.f3531e.write(bArr, i, i2);
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void mo19639a(C1348c cVar) {
        this.f3532f = cVar;
    }

    /* renamed from: a */
    public void mo19581a(String str, String str2, String str3) {
        Logger.m3601d(f3527a, "onStreamClose " + this + " sdkPackageName: " + str);
        C1361h.m3694b(f3527a, str3);
        CreativeInfoManager.m3088b(str, str2, str3);
    }
}

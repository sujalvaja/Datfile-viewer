package com.example.safesdk.sample.p055a;

import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.example.safesdk.sample.a.e */
public class C1260e {

    /* renamed from: a */
    private static  String f2355a = C1260e.class.getSimpleName();

    /* renamed from: b */
    private HttpURLConnection f2356b;

    public C1260e(URLConnection uRLConnection) {
        this.f2356b = (HttpURLConnection) uRLConnection;
    }

    /* renamed from: a */
    public void mo19176a(boolean z) {
        this.f2356b.setUseCaches(z);
    }

    /* renamed from: a */
    public void mo19174a(String str) throws ProtocolException {
        this.f2356b.setRequestMethod(str);
    }

    /* renamed from: a */
    public void mo19175a(String str, String str2) {
        this.f2356b.setRequestProperty(str, str2);
    }

    /* renamed from: b */
    public void mo19180b(boolean z) {
        this.f2356b.setDoOutput(z);
    }

    /* renamed from: a */
    public OutputStream mo19172a() throws IOException {
        return this.f2356b.getOutputStream();
    }

    /* renamed from: c */
    public void mo19182c(boolean z) {
        this.f2356b.setInstanceFollowRedirects(z);
    }

    /* renamed from: b */
    public int mo19177b() throws IOException {
        return this.f2356b.getResponseCode();
    }

    /* renamed from: c */
    public URL mo19181c() {
        return this.f2356b.getURL();
    }

    /* renamed from: a */
    public void mo19173a(int i) {
        this.f2356b.setConnectTimeout(i);
    }

    /* renamed from: d */
    public void mo19183d() {
        this.f2356b.disconnect();
    }

    /* renamed from: e */
    public InputStream mo19185e() throws IOException {
        return this.f2356b.getInputStream();
    }

    /* renamed from: f */
    public void mo19186f() throws IOException {
        if (SafeDK.getInstance().mo19144m()) {
            Logger.m3603e(f2355a, "SafeDK network activity in offline mode ");
            Logger.printStackTrace();
        }
        this.f2356b.connect();
    }

    /* renamed from: b */
    public String mo19178b(String str) {
        return this.f2356b.getHeaderField(str);
    }

    /* renamed from: g */
    public InputStream mo19187g() {
        return this.f2356b.getErrorStream();
    }

    /* renamed from: d */
    public void mo19184d(boolean z) {
        this.f2356b.setDoInput(z);
    }

    /* renamed from: b */
    public void mo19179b(int i) {
        this.f2356b.setReadTimeout(i);
    }
}

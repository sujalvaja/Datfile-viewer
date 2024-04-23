package com.example.safesdk.sample.p055a;

import com.example.safesdk.sample.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.example.safesdk.sample.a.c */
public class C1258c {

    /* renamed from: a */
    private static  String f2347a = "MultipartUtility";

    /* renamed from: c */
    private static  String f2348c = "\r\n";

    /* renamed from: b */
    private  String f2349b;

    /* renamed from: d */
    private C1260e f2350d;

    /* renamed from: e */
    private String f2351e;

    /* renamed from: f */
    private OutputStream f2352f;

    /* renamed from: g */
    private PrintWriter f2353g;

    /* renamed from: h */
    private int f2354h = 0;

    public C1258c(String str, String str2, String str3, int i, Map<String, String> map) throws IOException {
        this.f2351e = str3;
        this.f2349b = "BOUNDARY-BOUNDARY" + System.currentTimeMillis() + "BOUNDARY";
        this.f2350d = new C1260e(new URL(str2).openConnection());
        this.f2350d.mo19174a(str);
        this.f2350d.mo19176a(false);
        this.f2350d.mo19180b(true);
        this.f2350d.mo19184d(true);
        this.f2350d.mo19175a("Content-Type", "multipart/form-data; boundary=" + this.f2349b);
        this.f2350d.mo19175a("User-Agent", "SafeDK-Client-BrandSafety");
        this.f2350d.mo19175a("Accept-Encoding", "gzip,deflate");
        for (Map.Entry next : map.entrySet()) {
            this.f2350d.mo19175a((String) next.getKey(), (String) next.getValue());
        }
        this.f2350d.mo19173a(i);
        this.f2350d.mo19179b(i);
        this.f2352f = this.f2350d.mo19172a();
        this.f2353g = new PrintWriter(new OutputStreamWriter(this.f2352f, str3), true);
    }

    /* renamed from: a */
    public void mo19166a(String str, String str2) {
        this.f2353g.append("--" + this.f2349b).append(f2348c);
        this.f2353g.append("Content-Disposition: form-data; name=\"" + str + "\"").append(f2348c);
        this.f2353g.append("Content-Type: text/plain; charset=" + this.f2351e).append(f2348c);
        this.f2353g.append(f2348c);
        this.f2353g.append(str2).append(f2348c);
        this.f2353g.flush();
    }

    /* renamed from: a */
    public void mo19165a(String str, File file) throws IOException {
        String name = file.getName();
        this.f2353g.append("--" + this.f2349b).append(f2348c);
        this.f2353g.append("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"").append(f2348c);
        this.f2353g.append("Content-Type: application/octet-stream").append(f2348c);
        this.f2353g.append(f2348c);
        this.f2353g.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                this.f2352f.write(bArr, 0, read);
            } else {
                this.f2352f.flush();
                fileInputStream.close();
                this.f2353g.append(f2348c);
                this.f2353g.flush();
                return;
            }
        }
    }

    /* renamed from: b */
    public void mo19168b(String str, String str2) {
        this.f2353g.append(str + ": " + str2).append(f2348c);
        this.f2353g.flush();
    }

    /* renamed from: a */
    public List<String> mo19164a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.f2353g.append(f2348c).flush();
        this.f2353g.append("--" + this.f2349b + "--").append(f2348c);
        this.f2353g.close();
        this.f2354h = this.f2350d.mo19177b();
        Logger.m3601d(f2347a, "Response code = " + this.f2354h);
        if (this.f2354h < 200 || this.f2354h >= 300) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f2350d.mo19187g()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    Logger.m3603e(f2347a, "Error message: " + sb);
                    throw new IOException("Server returned non-OK status: " + this.f2354h);
                }
            }
        } else {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.f2350d.mo19185e()));
            while (true) {
                String readLine2 = bufferedReader2.readLine();
                if (readLine2 != null) {
                    arrayList.add(readLine2);
                } else {
                    bufferedReader2.close();
                    this.f2350d.mo19183d();
                    return arrayList;
                }
            }
        }
    }

    /* renamed from: b */
    public int mo19167b() {
        return this.f2354h;
    }
}

package com.example.safesdk.sample.p055a;

import com.itextpdf.text.xml.xmp.XmpWriter;
import com.example.safesdk.sample.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/* renamed from: com.example.safesdk.sample.a.b */
public class C1257b implements Runnable {

    /* renamed from: a */
    private static  String f2341a = "ConfigDownload";

    /* renamed from: b */
    private static  int f2342b = 2;

    /* renamed from: c */
    private static  int[] f2343c = {60000, 300000};

    /* renamed from: d */
    private C1259d f2344d = new C1259d();

    /* renamed from: e */
    private  String f2345e;

    /* renamed from: f */
    private  String f2346f;

    public C1257b(C1259d dVar, String str, String str2) {
        this.f2344d = dVar;
        this.f2345e = str;
        this.f2346f = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[Catch:{ InterruptedException -> 0x00b6, all -> 0x00c6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            r8 = 2
            r0 = 0
            r2 = 0
            com.example.safesdk.sample.SafeDK r1 = com.example.safesdk.sample.SafeDK.getInstance()
            java.lang.String r4 = r1.getUserId()
            r3 = r0
        L_0x000c:
            if (r3 > r8) goto L_0x006b
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.lang.String r0 = r9.f2345e     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.lang.String r0 = "ConfigDownload"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            r5.<init>()     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.lang.String r6 = "Config url: "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r5)     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            com.example.safesdk.sample.a.e r0 = new com.example.safesdk.sample.a.e     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00f0, Throwable -> 0x00ed, all -> 0x00ea }
            r1 = 0
            r0.mo19176a((boolean) r1)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            if (r4 == 0) goto L_0x0055
            java.lang.String r1 = "Cookie"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            r2.<init>()     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            java.lang.String r5 = "user_id="
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            r0.mo19175a(r1, r2)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
        L_0x0055:
            java.lang.String r1 = r9.f2346f     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r1 = "If-None-Match"
            java.lang.String r2 = r9.f2346f     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            r0.mo19175a(r1, r2)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
        L_0x0060:
            r0.mo19186f()     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            r9.m2767a((com.example.safesdk.sample.p055a.C1260e) r0)     // Catch:{ Exception -> 0x006c, Throwable -> 0x00d4 }
            if (r0 == 0) goto L_0x006b
            r0.mo19183d()
        L_0x006b:
            return
        L_0x006c:
            r1 = move-exception
        L_0x006d:
            java.lang.String r2 = "ConfigDownload"
            java.lang.String r5 = "Failed to download configuration"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r5, r1)     // Catch:{ all -> 0x00c6 }
            com.example.safesdk.sample.a.d r2 = r9.f2344d     // Catch:{ all -> 0x00c6 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x00c6 }
            r2.mo19171b(r5)     // Catch:{ all -> 0x00c6 }
            if (r3 >= r8) goto L_0x00ce
            boolean r1 = r9.m2769a((java.lang.Exception) r1)     // Catch:{ all -> 0x00c6 }
            if (r1 == 0) goto L_0x00ce
            int r1 = r9.m2766a((int) r3)     // Catch:{ all -> 0x00c6 }
            java.lang.String r2 = "ConfigDownload"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00b6 }
            r5.<init>()     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r6 = "Next retry in "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r6 = " ms"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.String r5 = r5.toString()     // Catch:{ InterruptedException -> 0x00b6 }
            com.example.safesdk.sample.utils.Logger.m3601d(r2, r5)     // Catch:{ InterruptedException -> 0x00b6 }
            long r6 = (long) r1     // Catch:{ InterruptedException -> 0x00b6 }
            java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x00b6 }
        L_0x00ab:
            if (r0 == 0) goto L_0x00b0
            r0.mo19183d()
        L_0x00b0:
            int r1 = r3 + 1
            r3 = r1
            r2 = r0
            goto L_0x000c
        L_0x00b6:
            r1 = move-exception
            java.lang.String r2 = "ConfigDownload"
            java.lang.String r5 = "Thread interrupted while sleeping: "
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r5, r1)     // Catch:{ all -> 0x00c6 }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00c6 }
            r1.interrupt()     // Catch:{ all -> 0x00c6 }
            goto L_0x00ab
        L_0x00c6:
            r1 = move-exception
            r2 = r0
        L_0x00c8:
            if (r2 == 0) goto L_0x00cd
            r2.mo19183d()
        L_0x00cd:
            throw r1
        L_0x00ce:
            if (r0 == 0) goto L_0x006b
            r0.mo19183d()
            goto L_0x006b
        L_0x00d4:
            r1 = move-exception
        L_0x00d5:
            java.lang.String r2 = "ConfigDownload"
            java.lang.String r5 = "Caught exception"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r5, r1)     // Catch:{ all -> 0x00c6 }
            com.example.safesdk.sample.analytics.reporters.CrashReporter r2 = new com.example.safesdk.sample.analytics.reporters.CrashReporter     // Catch:{ all -> 0x00c6 }
            r2.<init>()     // Catch:{ all -> 0x00c6 }
            r2.caughtException(r1)     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x00b0
            r0.mo19183d()
            goto L_0x00b0
        L_0x00ea:
            r0 = move-exception
            r1 = r0
            goto L_0x00c8
        L_0x00ed:
            r1 = move-exception
            r0 = r2
            goto L_0x00d5
        L_0x00f0:
            r1 = move-exception
            r0 = r2
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.p055a.C1257b.run():void");
    }

    /* renamed from: a */
    private String m2768a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, XmpWriter.UTF8);
            char[] cArr = new char[65536];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.m3604e(f2341a, "Failed to read configuration from input stream", e);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private int m2767a(C1260e eVar) throws IOException, HttpRetryException {
        InputStream inputStream = null;
        int b = eVar.mo19177b();
        Logger.m3601d(f2341a, "response code = " + b);
        if (b < 300) {
            try {
                inputStream = eVar.mo19185e();
                String a = m2768a(inputStream);
                Logger.m3601d(f2341a, "response = " + a);
                this.f2344d.mo19170a(a, m2770b(eVar));
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                Logger.m3604e(f2341a, "Failed to get response from server", e);
                this.f2344d.mo19169a("Failed to read data from connection");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } else if (b == 304) {
            this.f2344d.mo19170a((String) null, m2770b(eVar));
        } else {
            InputStream g = eVar.mo19187g();
            String a2 = m2768a(g);
            this.f2344d.mo19169a(a2);
            if (g != null) {
                g.close();
            }
            throw new HttpRetryException(a2, b);
        }
        return b;
    }

    /* renamed from: a */
    private int m2766a(int i) {
        return f2343c[i];
    }

    /* renamed from: a */
    private boolean m2769a(Exception exc) {
        if (exc.getClass().isInstance(InterruptedIOException.class) || exc.getClass().isInstance(UnknownHostException.class) || exc.getClass().isInstance(MalformedURLException.class)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private String m2770b(C1260e eVar) {
        return eVar.mo19178b("ETag");
    }
}

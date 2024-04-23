package com.example.safesdk.sample.internal;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.internal.partials.NetworkBridge;
import com.example.safesdk.sample.utils.C1355b;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.example.safesdk.sample.internal.f */
public class C1351f extends InputStream {

    /* renamed from: a */
    private static  String f3518a = "SafeDKInputStream";

    /* renamed from: b */
    private  boolean f3519b;

    /* renamed from: c */
    private String f3520c;

    /* renamed from: d */
    private String f3521d;

    /* renamed from: e */
    private InputStream f3522e;

    /* renamed from: f */
    private boolean f3523f = false;

    /* renamed from: g */
    private Map<String, List<String>> f3524g;

    /* renamed from: h */
    private ByteArrayOutputStream f3525h = new ByteArrayOutputStream();

    /* renamed from: i */
    private HttpURLConnection f3526i;

    public C1351f(String str, String str2, InputStream inputStream, Map<String, List<String>> map, boolean z) {
        this.f3520c = str;
        this.f3521d = str2;
        this.f3522e = inputStream;
        this.f3524g = map;
        this.f3519b = z;
    }

    /* renamed from: a */
    public void mo19630a(HttpURLConnection httpURLConnection) {
        this.f3526i = httpURLConnection;
    }

    public int read() throws IOException {
        int read = this.f3522e.read();
        if (read >= 0) {
            try {
                this.f3525h.write(read);
            } catch (Throwable th) {
            }
        }
        return read;
    }

    public int read(@NonNull byte[] b) throws IOException {
        int read = this.f3522e.read(b);
        m3561a(b, 0, read);
        return read;
    }

    public int read( byte[] b, int off, int len) throws IOException {
        int read = this.f3522e.read(b, off, len);
        m3561a(b, off, read);
        return read;
    }

    public int available() throws IOException {
        return this.f3522e.available();
    }

    public long skip(long n) throws IOException {
        return this.f3522e.skip(n);
    }

    public synchronized void reset() throws IOException {
        this.f3522e.reset();
    }

    public void close() throws IOException {
        if (this.f3522e != null) {
            this.f3522e.close();
        }
        m3563b();
    }

    public boolean markSupported() {
        return this.f3522e.markSupported();
    }

    /* renamed from: a */
    public void mo19629a() {
        if (!this.f3523f) {
            m3563b();
        }
    }

    /* renamed from: a */
    private void m3561a(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            try {
                this.f3525h.write(bArr, i, i2);
            } catch (Throwable th) {
                return;
            }
        }
        if (m3564b(this.f3524g) && i2 == -1) {
            m3563b();
        }
        if (this.f3519b && this.f3525h != null && m3565c(this.f3524g) && m3566d(this.f3524g) == this.f3525h.size()) {
            m3563b();
        }
    }

    /* renamed from: b */
    private void m3563b() {
        boolean z;
        String byteArrayOutputStream;
        boolean z2 = false;
        try {
            if (!m3564b(this.f3524g) && this.f3525h != null && this.f3525h.size() == 0) {
                Logger.m3601d(f3518a, "handleClose streamData.size()=0, exiting " + this);
            } else if (!this.f3523f) {
                this.f3523f = true;
                Bundle g = CreativeInfoManager.m3105g(this.f3520c);
                if (g != null) {
                    z = g.getBoolean(AdNetworkDiscovery.f2647d);
                } else {
                    z = false;
                }
                Logger.m3601d(f3518a, "sdk " + this.f3520c + " configuration item CONFIGURATION_SUPPORTS_GZIP_CONTENT is " + z);
                if (!z || !m3562a(this.f3524g)) {
                    byteArrayOutputStream = this.f3525h.toString();
                } else {
                    Logger.m3601d(f3518a, "handleClose gzip content detected");
                    byteArrayOutputStream = C1355b.m3621a(this.f3525h.toByteArray());
                }
                if (byteArrayOutputStream == null || (byteArrayOutputStream != null && byteArrayOutputStream.length() == 0)) {
                    z2 = true;
                }
                if (!this.f3520c.equals(C1357d.f3613u) || !z2) {
                    Logger.m3601d(f3518a, "Calling onAdFetched, content size is " + byteArrayOutputStream.length());
                    CreativeInfoManager.m3078a(this.f3520c, this.f3521d, byteArrayOutputStream, this.f3524g);
                } else {
                    Logger.m3601d(f3518a, "Fyber url with empty body, skipping");
                }
                this.f3525h = null;
                this.f3524g = null;
                if (this.f3526i != null) {
                    NetworkBridge.disposeOfConnectionToStreamMapping(this.f3526i);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    private static boolean m3562a(Map<String, List<String>> map) {
        if (map == null || !map.containsKey("Content-Encoding") || map.get("Content-Encoding") == null || map.get("Content-Encoding").size() <= 0 || !map.get("Content-Encoding").contains("gzip")) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m3564b(Map<String, List<String>> map) {
        if (map == null || !map.containsKey("Transfer-Encoding") || map.get("Transfer-Encoding") == null || map.get("Transfer-Encoding").size() <= 0 || !map.get("Transfer-Encoding").contains("chunked")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m3565c(Map<String, List<String>> map) {
        if (map == null || !map.containsKey("Content-Length") || map.get("Content-Length") == null || map.get("Content-Length").size() <= 0) {
            Logger.m3601d(f3518a, "headerContainsContentSize returned false");
            return false;
        }
        Logger.m3601d(f3518a, "headerContainsContentSize returned true");
        return true;
    }

    /* renamed from: d */
    private static int m3566d(Map<String, List<String>> map) {
        if (!m3565c(map)) {
            return -1;
        }
        Logger.m3601d(f3518a, "getHeaderContentSize returned " + ((String) map.get("Content-Length").get(0)) + " for " + map.toString());
        return Integer.parseInt((String) map.get("Content-Length").get(0));
    }
}

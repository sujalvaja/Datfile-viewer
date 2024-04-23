package com.example.safesdk.sample.internal.partials;

import android.webkit.WebView;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1351f;
import com.example.safesdk.sample.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.concurrent.ConcurrentHashMap;

public class NetworkBridge {

    /* renamed from: a */
    public static ConcurrentHashMap<HttpURLConnection, C1351f> f3570a = new ConcurrentHashMap<>();

    /* renamed from: b */
    public static ConcurrentHashMap<Integer, RequestInfo> f3571b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static  String f3572c = "SafeDKNetwork";

    /* renamed from: d */
    private static  String f3573d = "";

    public static class RequestInfo {

        /* renamed from: a */
        private String f3574a = null;

        /* renamed from: b */
        private String f3575b = null;

        /* renamed from: c */
        private String f3576c = null;

        /* renamed from: d */
        private ByteArrayOutputStream f3577d = new ByteArrayOutputStream();

        public RequestInfo(String sdkPackageName, String url) {
            this.f3574a = sdkPackageName;
            this.f3575b = url;
        }

        /* renamed from: a */
        public String mo19666a() {
            return this.f3574a;
        }

        /* renamed from: b */
        public String mo19669b() {
            return this.f3575b;
        }

        /* renamed from: c */
        public String mo19670c() {
            if (this.f3576c == null) {
                this.f3576c = this.f3577d.toString();
            }
            return this.f3576c;
        }

        /* renamed from: a */
        public void mo19668a(byte[] bArr, long j) {
            this.f3577d.write(bArr, 0, (int) j);
        }

        public String toString() {
            return "Info{" + this.f3574a + " " + this.f3575b + "}";
        }

        /* renamed from: a */
        public void mo19667a(String str) {
            this.f3575b = str;
        }
    }

    public static void disposeOfConnectionToStreamMapping(HttpURLConnection connection) {
        try {
            f3570a.remove(connection);
        } catch (Throwable th) {
            Logger.m3604e(f3572c, "Caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static void logWebviewLoadURLRequest(String sdk, WebView webview, String url) {
        try {
            Logger.m3601d("logWebviewLoadURLRequest webview", "loadUrl " + webview.getId() + ", webview class name=" + webview.getClass().getCanonicalName());
            Logger.m3601d(f3572c, "logWebviewLoadURLRequest: " + url);
            if (url != null) {
                BrandSafetyUtils.m2898a(sdk, url, webview);
            }
        } catch (Throwable th) {
            Logger.m3604e(f3572c, "caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    public static Object invokeMethod(String className, String methodName, Object targetInstance, Class[] parametersTypes, Object[] paramaterValues) throws IOException {
        try {
            Method declaredMethod = Class.forName(className).getDeclaredMethod(methodName, parametersTypes);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(targetInstance, paramaterValues);
        } catch (ClassNotFoundException e) {
            throw new IOException("Network access denied", e.getCause());
        } catch (NoSuchMethodException e2) {
            throw new IOException("Network access denied", e2.getCause());
        } catch (InvocationTargetException e3) {
            throw new IOException("Network access denied", e3.getCause());
        } catch (IllegalAccessException e4) {
            throw new IOException("Network access denied", e4.getCause());
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            throw new IOException("error occurred while trying to access network");
        }
    }
}

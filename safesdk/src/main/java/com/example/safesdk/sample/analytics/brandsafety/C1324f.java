package com.example.safesdk.sample.analytics.brandsafety;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.internal.C1346a;
import com.example.safesdk.sample.internal.C1347b;
import com.example.safesdk.sample.p055a.C1260e;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.f */
public class C1324f implements C1346a {

    /* renamed from: a */
    private static  String f3087a = "ClickUrlsManager";

    /* renamed from: b */
    private static  Pattern f3088b = Pattern.compile("[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}\\.[0-9]{2,3}");

    /* renamed from: c */
    private static  int f3089c = 2;

    /* renamed from: d */
    private static  String f3090d = "original_url";

    /* renamed from: e */
    private static  String f3091e = "resolved_url";

    /* renamed from: f */
    private static  String f3092f = "fingerprint";

    /* renamed from: g */
    private static  String f3093g = "package";

    /* renamed from: h */
    private static  String f3094h = "https://play.google.com/store/apps/details?id=%s";

    /* renamed from: i */
    private static C1324f f3095i;

    /* renamed from: o */
    private static  Object f3096o = new Object();

    /* renamed from: p */
    public static AtomicBoolean f3097p = new AtomicBoolean();

    /* renamed from: q */
    private static  ScheduledExecutorService f3098q = Executors.newScheduledThreadPool(0);

    /* renamed from: j */
    private String f3099j = null;

    /* renamed from: k */
    private String f3100k = null;

    /* renamed from: l */
    private Set<String> f3101l = new HashSet();

    /* renamed from: m */
    public AtomicBoolean f3102m = new AtomicBoolean(false);

    /* renamed from: n */
    private AtomicInteger f3103n = new AtomicInteger(0);

    private C1324f() {
        C1347b.getInstance().registerBackgroundForegroundListener(this);
    }

    /* renamed from: a */
    public static C1324f m3378a() {
        C1324f fVar;
        synchronized (f3096o) {
            if (f3095i == null) {
                f3095i = new C1324f();
            }
            fVar = f3095i;
        }
        return fVar;
    }

    /* renamed from: a */
    public static void m3384a(boolean z) {
        synchronized (f3096o) {
            Logger.m3601d(f3087a, "setActiveMode to " + z);
            f3095i = null;
        }
    }

    /* renamed from: c */
    public synchronized void m3388c(String str, String str2) {
        if (this.f3099j == null && !this.f3101l.contains(str)) {
            Logger.m3601d(f3087a, "logging url: " + str + ", fingerprint: " + str2);
            this.f3099j = str;
            this.f3100k = str2;
            if (TextUtils.isEmpty(this.f3100k)) {
                this.f3100k = str;
            }
        }
    }

    /* renamed from: a */
    public static String m3379a(String str) {
        if (C1361h.m3720r(str)) {
            return C1361h.m3722t(str);
        }
        return m3385b(str);
    }

    /* renamed from: b */
    public static String m3385b(String str) {
        try {
            URI uri = new URI(URLEncoder.encode(str, XmpWriter.UTF8));
            String query = uri.getQuery();
            if (TextUtils.isEmpty(query)) {
                return str;
            }
            String str2 = "";
            for (String str3 : query.split("&")) {
                if (!f3088b.matcher(str3).find()) {
                    if (str2.length() > 0) {
                        str2 = str2 + "&";
                    }
                    str2 = str2 + str3;
                }
            }
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str2, uri.getFragment()).toString();
        } catch (Throwable th) {
            Logger.m3609w(f3087a, "Unable to clean url: " + th.getMessage());
            return str;
        }
    }

    /* renamed from: c */
    public static String m3386c(String str) {
        return String.format(Locale.ENGLISH, f3094h, new Object[]{str});
    }

    /* renamed from: b */
    public synchronized String mo19475b() {
        return this.f3100k;
    }

    /* renamed from: f */
    public synchronized void mo19198f() {
        f3097p.set(true);
    }

    /* renamed from: g */
    public synchronized void mo19199g() {
        String str;
        String str2;
        Logger.m3601d(f3087a, "onForeground started");
        f3097p.set(false);
        if (this.f3102m.get()) {
            if (this.f3103n.getAndIncrement() <= 2) {
                synchronized (f3095i) {
                    if (this.f3099j != null) {
                        String str3 = this.f3099j;
                        str = this.f3100k;
                        str2 = str3;
                    } else {
                        str = null;
                        str2 = null;
                    }
                }
                mo19476b(str2, str);
            } else {
                Logger.m3601d(f3087a, "Exhausted2 attempts to resolve URL. Clearing the slot.");
                m3389d();
            }
        }
    }

    /* renamed from: d */
    private void m3389d() {
        synchronized (f3095i) {
            if (this.f3099j != null) {
                String str = this.f3099j;
                this.f3099j = null;
                this.f3100k = null;
                this.f3101l.add(str);
                this.f3102m.set(false);
                this.f3103n.set(0);
            }
        }
    }

    /* renamed from: d */
    private void m3390d(String str, String str2) {
        if (str != null) {
            try {
                C1260e eVar = new C1260e(new URL(str).openConnection());
                eVar.mo19182c(true);
                eVar.mo19173a(SafeDK.getInstance().mo19114E());
                eVar.mo19177b();
                URL c = eVar.mo19181c();
                m3383a(str, c != null ? c.toString() : null, str2, false);
            } catch (MalformedURLException e) {
                Logger.m3602d(f3087a, "Malformed URL", e);
            } catch (IOException e2) {
                Logger.m3602d(f3087a, "Error opening connection", e2);
            } catch (Throwable th) {
                Logger.m3602d(f3087a, "Throwable Error opening connection", th);
            }
        }
    }

    /* renamed from: a */
    public void mo19474a( String str,  String str2) {
        Logger.m3601d(f3087a, "resolveUrl started, url = " + str + ", fingerprint = " + str2);
        if (C1361h.m3720r(str)) {
            m3383a(str, C1361h.m3721s(str), str2, false);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    if (C1324f.f3097p.get()) {
                        C1324f.this.m3388c(str, str2);
                        C1324f.this.f3102m.set(true);
                        Logger.m3601d(C1324f.f3087a, "server asked to resolve but currently in background.");
                        return;
                    }
                    Logger.m3601d(C1324f.f3087a, "not currently in background, try to resolve.");
                    C1324f.this.mo19476b(str, str2);
                }
            }, 500);
        }
    }

    /* renamed from: b */
    public  void mo19476b( String str,  String str2) {
        Logger.m3601d(f3087a, "resolveUrlInternal starting Url resolution");
         AtomicBoolean atomicBoolean = new AtomicBoolean(false);
         WebView webView = new WebView(SafeDK.getInstance().mo19137g());
        /*C13262 r2 = new Runnable() {
            public void run() {
                if (atomicBoolean.get()) {
                    Logger.m3601d(C1324f.f3087a, "Url resolved. no timeout.");
                } else {
                    webView.post(new Runnable() {
                        public void run() {
                            Logger.m3601d(C1324f.f3087a, "Timeout resolving url");
                            webView.stopLoading();
                        }
                    });
                }
            }
        };*/
        AtomicLong atomicLong = new AtomicLong(0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {

            /* renamed from: a */
            AtomicInteger f3111a = new AtomicInteger(0);

            public void onPageStarted(WebView view,  String url, Bitmap favicon) {
                 int incrementAndGet = this.f3111a.incrementAndGet();
                Logger.m3601d(C1324f.f3087a, "onPageStarted started. callbackCounter=" + incrementAndGet + ", url= " + url);
                if (!url.equals(str)) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                           /* if (incrementAndGet == C13283.this.f3111a.get()) {
                                Logger.m3601d(C1324f.f3087a, "onPageFinished never called, assuming last onPageStarted is the landing page.");
                                Logger.m3601d(C1324f.f3087a, "Landing page detected: " + url);
                                atomicBoolean.set(true);
                                C1324f.this.m3383a(str, url, str2, true);
                                return;
                            }
                            Logger.m3601d(C1324f.f3087a, "onPageStarted resolveCounter.get() is not equal to callbackCounter. resolveCounter.get()=" + C13283.this.f3111a.get() + ", callbackCounter=" + incrementAndGet);
                       */ }
                    }, 60000);
                }
                super.onPageStarted(view, url, favicon);
            }

            public void onPageFinished(WebView view,  String url) {
                 int incrementAndGet = this.f3111a.incrementAndGet();
                Logger.m3601d(C1324f.f3087a, "onPageFinished started. callbackCounter=" + incrementAndGet + ", url= " + url);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                       /* if (C13283.this.f3111a.get() == incrementAndGet) {
                            Logger.m3601d(C1324f.f3087a, "Landing page detected: " + url);
                            atomicBoolean.set(true);
                            C1324f.this.m3383a(str, url, str2, true);
                            return;
                        }
                        Logger.m3601d(C1324f.f3087a, "onPageFinished resolveCounter.get() is not equal to callbackCounter. resolveCounter.get()=" + C13283.this.f3111a.get() + ", callbackCounter=" + incrementAndGet);
                   */ }
                }, 5000);
                super.onPageFinished(view, url);
            }
        });
        atomicLong.set(System.currentTimeMillis());
        webView.loadUrl(str);
        Logger.m3601d(f3087a, "Starting resolution, timeout = " + SafeDK.getInstance().mo19114E());
      //  f3098q.schedule(r2, (long) SafeDK.getInstance().mo19114E(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public void m3383a(String str, String str2, String str3, boolean z) {
        try {
            Logger.m3601d(f3087a, "reportResolvedUrlToServer started. originalUrl=" + str + ", resolvedUrl=" + str2 + ", fingerprint=" + str3);
            m3389d();
            if (z && C1361h.m3720r(str2)) {
                str2 = C1361h.m3721s(m3379a(str2));
            }
            Bundle bundle = new Bundle();
            bundle.putString(f3090d, str);
            bundle.putString(f3091e, str2);
            bundle.putString("fingerprint", str3);
            bundle.putString("package", SafeDK.getInstance().mo19137g().getPackageName());
            C1320e.m3370a(bundle);
        } catch (Throwable th) {
            Logger.m3601d(f3087a, "Failed to report url resolve to server");
            new CrashReporter().caughtException(th);
        }
    }
}

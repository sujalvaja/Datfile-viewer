package com.example.safesdk.sample.analytics.brandsafety.creatives;

import android.text.TextUtils;

import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.itextpdf.text.xml.xmp.XmpWriter;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.f */
public class C1317f extends C1307c {

    /* renamed from: A */
    private static  Pattern f2914A = Pattern.compile(m3118a("HTMLResource"), 2);

    /* renamed from: B */
    private static  Pattern f2915B = Pattern.compile(m3118a("AdParameters"), 2);

    /* renamed from: C */
    private static  Pattern f2916C = Pattern.compile("(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)Tracking(?:[\\s]|%20)event(?:\\\\*x3D|%3d|=)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?([\\s\\S]*?)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)([\\s\\S]*?)(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Tracking(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)", 2);

    /* renamed from: D */
    private static  Pattern f2917D = Pattern.compile(m3118a("ClickTracking"), 2);

    /* renamed from: E */
    private static  Pattern f2918E = Pattern.compile(m3118a("CompanionClickTracking"), 2);

    /* renamed from: F */
    private static  Pattern f2919F = Pattern.compile(m3118a("Impression"), 2);

    /* renamed from: G */
    private static  CharSequence f2920G = "acao/yes";

    /* renamed from: n */
    public static  Pattern f2921n = Pattern.compile("(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)Ad(?:(?: +|%20)id(?:\\\\*x3D|%3d|=)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?(.*?)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?)?(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)[\\s\\S]*?(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Ad(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)", 34);

    /* renamed from: o */
    public static  Pattern f2922o = Pattern.compile(m3118a("VAST"), 2);

    /* renamed from: p */
    private static  String f2923p = "VastAdParser";

    /* renamed from: q */
    private static  Pattern f2924q = Pattern.compile("(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)Creative[^s]?(?:id(?:\\\\*x3D|%3d|=)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)([0-9]+)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))?.*?(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)[\\s\\S]*?(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:\\\\*/)Creative(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)", 2);

    /* renamed from: r */
    private static  Pattern f2925r = Pattern.compile(m3118a("AdSystem"), 2);

    /* renamed from: s */
    private static  Pattern f2926s = Pattern.compile(m3118a("ClickThrough"), 2);

    /* renamed from: t */
    private static  Pattern f2927t = Pattern.compile(C1307c.f2810l.replaceFirst("<TAG_NAME>", "MediaFile[^s]").replace("<TAG_NAME>", "MediaFile"), 2);

    /* renamed from: u */
    private static  Pattern f2928u = Pattern.compile("(apiFramework(?:\\\\*x3D|%3d|=)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)VPAID(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|type(?:\\\\*x3D|%3d|=)(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)application/javascript(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;))", 2);

    /* renamed from: v */
    private static  Pattern f2929v = Pattern.compile(m3118a("CompanionClickThrough"), 2);

    /* renamed from: w */
    private static  Pattern f2930w = Pattern.compile(m3118a("VASTAdTagURI"), 2);

    /* renamed from: x */
    private static  Pattern f2931x = Pattern.compile(m3118a("YouTubeVideoId"), 2);

    /* renamed from: y */
    private static  Pattern f2932y = Pattern.compile(m3118a("StaticResource"), 2);

    /* renamed from: z */
    private static  Pattern f2933z = Pattern.compile(m3118a("IFrameResource"), 2);

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.f$a */
    public static class C1318a {

        /* renamed from: a */
        private boolean f2934a = false;

        /* renamed from: b */
        private String f2935b;

        /* renamed from: c */
        private String f2936c;

        /* renamed from: d */
        private String f2937d;

        /* renamed from: e */
        private String f2938e;

        /* renamed from: f */
        private String f2939f;

        /* renamed from: g */
        private String f2940g;

        /* renamed from: h */
        private String f2941h;

        /* renamed from: i */
        private List<String> f2942i;

        /* renamed from: j */
        private List<String> f2943j;

        /* renamed from: k */
        private List<String> f2944k = new ArrayList();

        /* renamed from: l */
        private List<String> f2945l = new ArrayList();

        /* renamed from: m */
        private List<String> f2946m = new ArrayList();

        /* renamed from: n */
        private List<String> f2947n = new ArrayList();

        /* renamed from: o */
        private List<String> f2948o;

        /* renamed from: p */
        private List<String> f2949p;

        /* renamed from: q */
        private List<String> f2950q;

        /* renamed from: r */
        private List<String> f2951r;

        C1318a(String str, String str2, String str3, String str4, ArrayList<String> arrayList, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6, List<String> list7, boolean z, String str5, List<String> list8, String str6, List<String> list9) {
            this.f2937d = str;
            this.f2938e = str2;
            this.f2935b = str3;
            this.f2936c = str4;
            this.f2944k = arrayList;
            this.f2945l = list;
            this.f2946m = list2;
            this.f2947n = list3;
            this.f2948o = list4;
            this.f2949p = list5;
            this.f2950q = list6;
            this.f2951r = list7;
            this.f2934a = z;
            this.f2940g = !z ? null : str5;
            this.f2943j = list8;
            this.f2941h = str6;
            this.f2942i = list9;
            Logger.m3601d(C1317f.f2923p, "Vast ad created . \nclickUrl=" + str3 + "\nvideoUrl=" + str4 + "\nvideoCompletedUrls=" + (list4 != null ? list4.toString() : "null") + "\nprefetchResourceUrls=" + (arrayList != null ? arrayList.toString() : "null") + "\nstaticResourceUrls=" + (list != null ? list.toString() : "null") + "\niframeResourceUrls=" + (list2 != null ? list2.toString() : "null") + "\nhtmlResourceUrls=" + (list3 != null ? list3.toString() : "null") + "\nimpressionUrls=" + (list8 != null ? list8.toString() : "null") + "\nmediaUrlList=" + (list9 != null ? list9.toString() : "null"));
        }

        C1318a(String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
            this.f2937d = str;
            this.f2938e = str2;
            this.f2939f = str3;
            this.f2943j = list;
            this.f2948o = list2;
            this.f2949p = list3;
            this.f2950q = list4;
            this.f2951r = list5;
        }

        /* renamed from: a */
        public String mo19349a() {
            return this.f2935b;
        }

        /* renamed from: b */
        public String mo19352b() {
            return this.f2936c;
        }

        /* renamed from: c */
        public String mo19355c() {
            return this.f2937d;
        }

        /* renamed from: a */
        public void mo19350a(String str) {
            this.f2937d = str;
        }

        /* renamed from: d */
        public String mo19358d() {
            return this.f2938e;
        }

        /* renamed from: b */
        public void mo19353b(String str) {
            this.f2938e = str;
        }

        /* renamed from: e */
        public String mo19360e() {
            return this.f2939f;
        }

        /* renamed from: c */
        public void mo19356c(String str) {
            this.f2939f = str;
        }

        /* renamed from: f */
        public String mo19362f() {
            return this.f2940g;
        }

        /* renamed from: g */
        public String mo19363g() {
            return this.f2941h;
        }

        /* renamed from: h */
        public List<String> mo19364h() {
            return this.f2942i;
        }

        /* renamed from: i */
        public List<String> mo19365i() {
            return this.f2943j;
        }

        /* renamed from: a */
        public void mo19351a(List<String> list) {
            this.f2943j = list;
        }

        /* renamed from: j */
        public List<String> mo19366j() {
            return this.f2944k;
        }

        /* renamed from: k */
        public List<String> mo19367k() {
            return this.f2945l;
        }

        /* renamed from: l */
        public List<String> mo19368l() {
            return this.f2946m;
        }

        /* renamed from: m */
        public List<String> mo19369m() {
            return this.f2947n;
        }

        /* renamed from: n */
        public List<String> mo19370n() {
            return this.f2948o;
        }

        /* renamed from: b */
        public void mo19354b(List<String> list) {
            this.f2948o = list;
        }

        /* renamed from: o */
        public List<String> mo19371o() {
            return this.f2949p;
        }

        /* renamed from: c */
        public void mo19357c(List<String> list) {
            this.f2949p = list;
        }

        /* renamed from: p */
        public List<String> mo19372p() {
            return this.f2950q;
        }

        /* renamed from: d */
        public void mo19359d(List<String> list) {
            this.f2950q = list;
        }

        /* renamed from: q */
        public List<String> mo19373q() {
            return this.f2951r;
        }

        /* renamed from: e */
        public void mo19361e(List<String> list) {
            this.f2951r = list;
        }

        /* renamed from: r */
        public boolean mo19374r() {
            return this.f2934a && !m3212s();
        }

        /* renamed from: s */
        private boolean m3212s() {
            for (String next : this.f2942i) {
                if (C1361h.m3723u(next)) {
                    Logger.m3601d(C1317f.f2923p, "videoFileExists is true " + next);
                    return true;
                }
            }
            C1361h.m3694b(C1317f.f2923p, "videoFileExists is false. urls " + mo19364h().toString());
            return false;
        }

        public String toString() {
            return "vastAdId=" + (this.f2937d == null ? "null" : this.f2937d) + ", adSystem=" + (this.f2938e == null ? "null" : this.f2938e) + ", clickUrl=" + (this.f2935b == null ? "null" : this.f2935b) + ", videoUrl=" + (this.f2936c == null ? "null" : this.f2936c) + ", vastAdUri=" + (this.f2939f == null ? "null" : this.f2939f) + ", mediaUrlList=" + (this.f2942i == null ? "null" : this.f2942i.toString());
        }
    }

    /* renamed from: b */
    public static ArrayList<C1318a> m3209b(String str, boolean z) {
        ArrayList<C1318a> arrayList = new ArrayList<>();
        List<String> a = C1361h.m3681a(f2921n, str);
        if (a.size() == 0) {
            Logger.m3601d(f2923p, "No ad blocks detected, exiting");
            return arrayList;
        }
        for (String c : a) {
            C1318a c2 = m3211c(c, z);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static C1318a m3211c(String str, boolean z) {
        try {
            C1361h.m3694b(f2923p, "VastAdInfo parse started, vastResponse = " + str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<String> a = m3121a(f2921n, str, -1, z);
            if (a.size() == 0) {
                Logger.m3601d(f2923p, "No ad blocks detected, exiting");
                return null;
            }
            String str2 = a.get(0);
            String str3 = null;
            String str4 = null;
            List<String> a2 = m3121a(f2921n, str2, 1, z);
            if (a2.size() > 0) {
                String str5 = a2.get(0);
                Logger.m3601d(f2923p, "Ad ID detected: " + str5);
                str3 = str5;
            }
            List<String> a3 = m3121a(f2925r, str2, 1, z);
            if (a3.size() > 0) {
                String str6 = a3.get(0);
                Logger.m3601d(f2923p, "Ad system detected : " + str6);
                str4 = str6;
            }
            ArrayList arrayList = new ArrayList();
            for (String a4 : m3121a(f2919F, str2, 1, z)) {
                String replace = C1361h.m3710h(URLDecoder.decode(m3119a(a4, z), XmpWriter.UTF8)).replace("\\/", "/");
                arrayList.add(replace);
                Logger.m3601d(f2923p, "impression url identified : " + replace);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (String a5 : m3121a(f2916C, str, -1, z)) {
                List<String> a6 = m3120a(f2916C, a5, 1, 2, z);
                String str7 = a6.get(0);
                String h = C1361h.m3710h(m3119a(a6.get(1), z));
                if (str7.equals("skip") || str7.equals("complete")) {
                    arrayList3.add(h);
                    Logger.m3601d(f2923p, "Video complete url identified : " + h);
                } else {
                    arrayList2.add(h);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            for (String a7 : m3121a(f2917D, str, 1, z)) {
                arrayList4.add(C1361h.m3710h(m3119a(a7, z)));
            }
            ArrayList arrayList5 = new ArrayList();
            for (String a8 : m3121a(f2918E, str, 1, z)) {
                arrayList5.add(C1361h.m3710h(m3119a(a8, z)));
            }
            List<String> a9 = m3121a(f2930w, str2, 1, z);
            if (a9.size() > 0) {
                return m3207a(z, str3, str4, a9, arrayList, arrayList3, arrayList2, arrayList4, arrayList5);
            }
            return m3206a(str, z, str3, str4, str2, arrayList, arrayList3, arrayList2, arrayList4, arrayList5);
        } catch (Throwable th) {
            new CrashReporter().caughtException(th);
            Logger.m3604e(f2923p, "failed to parse vast data", th);
            return null;
        }
    }

    /* renamed from: a */
    private static C1318a m3207a(boolean z, String str, String str2, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, List<String> list6) {
        String h = C1361h.m3710h(m3119a(list.get(0), z));
        Logger.m3601d(f2923p, "vastAdUri=" + h);
        if (h == null) {
            return null;
        }
        Logger.m3601d(f2923p, "vastAdUri uri detected : " + h);
        return new C1318a(str, str2, h, list2, list3, list4, list5, list6);
    }

    /* renamed from: a */
    private static C1318a m3206a(String str, boolean z, String str2, String str3, String str4, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        String str5;
        String str6;
        String str7;
        Logger.m3601d(f2923p, "no VastAdTagUri");
        boolean z2 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        List<String> a = m3121a(f2924q, str4, 0, z);
        Logger.m3601d(f2923p, "Number of creativesXml elements : " + a.size());
        String str12 = null;
        for (String next : a) {
            C1361h.m3694b(f2923p, "Processing <Creative> block : " + next);
            List<String> a2 = m3121a(f2926s, next, 1, false);
            if (a2.size() > 0) {
                Logger.m3601d(f2923p, "clickUrlList = " + a2.toString());
                str11 = m3119a(a2.get(0), z);
                str5 = m3119a(a2.get(0), false);
                for (String a3 : a2) {
                    arrayList.add(m3119a(a3, z));
                }
            } else {
                Logger.m3601d(f2923p, "clickUrlList is empty");
                str5 = str12;
            }
            List<String> a4 = m3121a(f2929v, next, 1, false);
            if (a4.size() > 0) {
                Logger.m3601d(f2923p, "companionClickUrlList = " + a4.toString());
                String a5 = m3119a(a4.get(0), false);
                if (str5 == null) {
                    str5 = a5;
                }
            } else {
                Logger.m3601d(f2923p, "companionClickUrlList is empty");
            }
            if (str5 != null) {
                str8 = str5;
            }
            for (String next2 : m3121a(f2927t, next, -1, z)) {
                List<String> a6 = m3121a(f2928u, next2, -1, z);
                List<String> a7 = m3121a(f2927t, next2, 1, z);
                String a8 = m3119a(a7.get(0), z);
                if (a6.size() > 0) {
                    z2 = true;
                    arrayList.add(a8);
                    Logger.m3601d(f2923p, "containsMediaFileWithJsAppAttribute set to true");
                } else if (a7.size() > 0) {
                    arrayList5.add(a8);
                    Logger.m3601d(f2923p, "Adding media file : " + a8);
                } else {
                    Logger.m3601d(f2923p, "cannot detect media resource in. skipping");
                }
            }
            List<String> a9 = m3121a(f2915B, next, 1, z);
            if (a9.size() > 0) {
                str10 = m3119a(a9.get(0), z);
                if (C1361h.m3718p(str10)) {
                    C1361h.m3694b(f2923p, "AdParameters is JSON : " + str10);
                    ArrayList<String> e = C1361h.m3707e(str10);
                    if (e.size() > 0) {
                        for (String next3 : e) {
                            Logger.m3601d(f2923p, "AdParameters mediaUrl : " + next3);
                            if (C1361h.m3723u(next3)) {
                                Logger.m3601d(f2923p, "AdParameters mediaUrl is video url : " + next3);
                                arrayList5.add(m3119a(next3, z));
                            }
                        }
                    }
                } else {
                    C1361h.m3694b(f2923p, "found AdParameters = " + str10);
                }
            }
            List<String> a10 = m3121a(f2931x, str4, 1, z);
            if (a10.size() > 0) {
                str6 = C1361h.m3698c(a10.get(0));
                Logger.m3601d(f2923p, "found youtube videoUrl : " + str6);
            } else {
                str6 = null;
                Iterator it = arrayList5.iterator();
                while (true) {
                    str7 = str6;
                    if (!it.hasNext()) {
                        str6 = null;
                        break;
                    }
                    str6 = (String) it.next();
                    if (C1361h.m3723u(str6) && str6.contains(f2920G)) {
                        Logger.m3601d(f2923p, "found google videoUrl : " + str6);
                        break;
                    } else if (!C1361h.m3723u(str6) || str7 != null) {
                        str6 = str7;
                    }
                }
                if (str6 == null && str7 != null) {
                    Logger.m3601d(f2923p, "found first MP4 videoUrl : " + str7);
                    str6 = str7;
                }
                if (str6 == null && arrayList5.size() > 0) {
                    str6 = (String) arrayList5.get(0);
                    Logger.m3601d(f2923p, "found first videoUrl : " + str6);
                }
            }
            if (!TextUtils.isEmpty(str6)) {
                if (!arrayList.contains(str6)) {
                    arrayList.add(str6);
                }
                str9 = str6;
            }
            if (str5 != null || str6 != null) {
                Logger.m3601d(f2923p, "VAST ad found clickURL = " + str5 + " videoUrl = " + str6);
            }
            str12 = str5;
        }
        m3208a(str, z, arrayList2, f2932y);
        m3208a(str, z, arrayList3, f2933z);
        m3208a(str, z, arrayList4, f2914A);
        if (str8 != null) {
            try {
                arrayList.remove(URLDecoder.decode(str8, XmpWriter.UTF8));
            } catch (UnsupportedEncodingException e2) {
                Logger.m3601d(f2923p, "extractCdataInfo decode failed: " + str8);
            }
        }
        return new C1318a(str2, str3, str8, str9, arrayList, arrayList2, arrayList3, arrayList4, list2, list3, list4, list5, z2, str10, list, str11, arrayList5);
    }

    /* renamed from: a */
    private static void m3208a(String str, boolean z, List<String> list, Pattern pattern) {
        for (String next : m3121a(pattern, str, 1, z)) {
            try {
                next = URLDecoder.decode(next, XmpWriter.UTF8);
            } catch (Throwable th) {
                Logger.m3602d(f2923p, "Error decoding static url", th);
            }
            List<String> a = m3121a(f2811m, next, 1, z);
            if (a.size() > 0) {
                next = a.get(0);
            }
            try {
                new URL(next);
                list.add(next);
            } catch (MalformedURLException e) {
                Logger.m3601d(f2923p, "resourcesInnerText is malformed. cannot add this url to the resources list");
            }
        }
    }

    /* renamed from: b */
    public static boolean m3210b(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("<vast") && lowerCase.contains("/vast>") && lowerCase.contains("<ad") && lowerCase.contains("/ad>");
    }
}

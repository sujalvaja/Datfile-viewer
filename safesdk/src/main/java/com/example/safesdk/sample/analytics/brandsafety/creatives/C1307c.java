package com.example.safesdk.sample.analytics.brandsafety.creatives;

import com.example.safesdk.sample.utils.C1361h;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.c */
public class C1307c {

    /* renamed from: a */
    public static  String f2799a = "(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)";

    /* renamed from: b */
    public static  String f2800b = "(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)";

    /* renamed from: c */
    public static  String f2801c = "(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:\\\\*/)";

    /* renamed from: d */
    public static  String f2802d = "(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)";

    /* renamed from: e */
    public static  String f2803e = "(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)?";

    /* renamed from: f */
    public static  String f2804f = "(?:\\\\*x3D|%3d|=)";

    /* renamed from: g */
    public static  String f2805g = "[\\s\\S]*?";

    /* renamed from: h */
    public static  String f2806h = "(?:%21|\\\\*x21|!)";

    /* renamed from: i */
    public static  String f2807i = "(?:%5B|\\\\*x5B|\\[)";

    /* renamed from: j */
    public static  String f2808j = "(?:%5D|\\\\*x5D|\\])";

    /* renamed from: k */
    public static  String f2809k = "\\)";

    /* renamed from: l */
    public static  String f2810l = "(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)<TAG_NAME>[\\s\\S]*?(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)([\\s\\S]*?)(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:\\\\*/)<TAG_NAME>(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)";

    /* renamed from: m */
    public static  Pattern f2811m = Pattern.compile("(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)(?:%21|\\\\*x21|!)(?:%5B|\\\\*x5B|\\[)CDATA(?:%5B|\\\\*x5B|\\[)([\\s\\S]*?)(?:%5D|\\\\*x5D|\\])(?:%5D|\\\\*x5D|\\])(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)");

    /* renamed from: n */
    private static  String f2812n = "ParserBase";

    /* renamed from: a */
    public static String m3118a(String str) {
        return f2810l.replace("<TAG_NAME>", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3119a(String r4, boolean r5) {
        /*
            r3 = 0
            if (r5 == 0) goto L_0x003a
            java.lang.String r0 = "UTF-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r4, r0)     // Catch:{ Throwable -> 0x0021 }
        L_0x0009:
            java.util.regex.Pattern r1 = f2811m
            r2 = 1
            java.util.List r0 = m3121a(r1, r0, r2, r3)
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x003c
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
        L_0x001c:
            java.lang.String r0 = r0.trim()
            return r0
        L_0x0021:
            r0 = move-exception
            java.lang.String r0 = "ParserBase"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "extractCdataInfo decode failed: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)
        L_0x003a:
            r0 = r4
            goto L_0x0009
        L_0x003c:
            r0 = r4
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.C1307c.m3119a(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: a */
    public static List<String> m3121a(Pattern pattern, String str, int i, boolean z) {
        String group;
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            if (i >= 0) {
                group = matcher.group(i);
            } else {
                group = matcher.group();
            }
            if (group != null) {
                if (z) {
                    arrayList.add(C1361h.m3710h(group.trim()));
                } else {
                    arrayList.add(group.trim());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m3120a(Pattern pattern, String str, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(i);
            String group2 = matcher.group(i2);
            if (group != null) {
                if (z) {
                    arrayList.add(C1361h.m3710h(group.trim()));
                } else {
                    arrayList.add(group.trim());
                }
            }
            if (group2 != null) {
                if (z) {
                    arrayList.add(C1361h.m3710h(group2.trim()));
                } else {
                    arrayList.add(group2.trim());
                }
            }
        }
        return arrayList;
    }
}

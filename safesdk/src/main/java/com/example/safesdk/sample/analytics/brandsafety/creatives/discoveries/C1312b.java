package com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries;

import com.example.safesdk.sample.analytics.brandsafety.C1324f;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1317f;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.itextpdf.text.xml.xmp.XmpWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.b */
public class C1312b extends C1315d {

    /* renamed from: A */
    private static  String f2832A = "ad_html";

    /* renamed from: B */
    private static  String f2833B = "clickUrl";

    /* renamed from: C */
    private static  String f2834C = "pubid";

    /* renamed from: D */
    private static  String f2835D = "Interstitial";

    /* renamed from: E */
    private static  String f2836E = "Landing+Page+0=";

    /* renamed from: F */
    private static  String f2837F = "&Creative+ID+0=";

    /* renamed from: G */
    private static  String f2838G = "http";

    /* renamed from: H */
    private static  String f2839H = "intent";

    /* renamed from: I */
    private static  String f2840I = "AdGroup+Creative+ID+0";

    /* renamed from: J */
    private static  String f2841J = "afma-sdk-a-v";

    /* renamed from: K */
    private static  String f2842K = "java.util.LinkedHashMap";

    /* renamed from: L */
    private static  String f2843L = "ignore_this_destination";

    /* renamed from: M */
    private static  String f2844M = "question";

    /* renamed from: N */
    private static  String f2845N = "longform_questions";

    /* renamed from: O */
    private static Pattern f2846O = Pattern.compile("<([a-zA-Z0-9]+)(?:\\s*[^>]*)>([^=\\/\\{\\(+]+?)<\\/\\1>");

    /* renamed from: P */
    private static Pattern f2847P = Pattern.compile("survey_payload[\\'\\\"]\\s*:\\s*[\\'\\\"](.*?)[\\'\\\"]");

    /* renamed from: Q */
    private static Pattern f2848Q = Pattern.compile("is_rewarded_html5_playable[^}]*?true");

    /* renamed from: R */
    private static Pattern f2849R = Pattern.compile("<img[^>]*src=[\\\"']([^\\\"^']*)(.*)\\/>|image:url((.*))");

    /* renamed from: S */
    private static Pattern f2850S = Pattern.compile("https://www\\.youtube\\.com/watch\\?v(\\\\x3d)(.*?)(\\\\x26)");

    /* renamed from: T */
    private static String f2851T = null;

    /* renamed from: r */
    private static  String f2852r = "AdMobDiscovery";

    /* renamed from: x */
    private static  String f2853x = "com.google.android.gms";

    /* renamed from: y */
    private static  String f2854y = "java.lang.String";

    /* renamed from: z */
    private static  String f2855z = "org.json.JSONObject";

    public C1312b() {
        super(C1357d.f3603k, f2852r);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x027e A[Catch:{ Throwable -> 0x03b5, all -> 0x03e2, Throwable -> 0x019a }, LOOP:2: B:41:0x0276->B:43:0x027e, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo mo19291a(Object r30) {
        /*
            r29 = this;
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x019a }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Throwable -> 0x019a }
            r9.<init>()     // Catch:{ Throwable -> 0x019a }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Throwable -> 0x019a }
            r7.<init>()     // Catch:{ Throwable -> 0x019a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Throwable -> 0x019a }
            r6.<init>()     // Catch:{ Throwable -> 0x019a }
            java.util.HashSet r8 = new java.util.HashSet     // Catch:{ Throwable -> 0x019a }
            r8.<init>()     // Catch:{ Throwable -> 0x019a }
            r4 = r29
            r5 = r30
            r4.m3141a(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x019a }
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r5.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r6 = "travel time "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Throwable -> 0x019a }
            long r12 = r22 - r10
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r6 = ", info "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r5)     // Catch:{ Throwable -> 0x019a }
            r18 = 1
            r13 = 0
            r15 = 0
            r14 = 0
            r16 = 0
            r20 = 0
            r19 = 0
            java.util.ArrayList r21 = new java.util.ArrayList     // Catch:{ Throwable -> 0x019a }
            r21.<init>()     // Catch:{ Throwable -> 0x019a }
            r8 = 0
            java.util.ArrayList r24 = new java.util.ArrayList     // Catch:{ Throwable -> 0x019a }
            r24.<init>()     // Catch:{ Throwable -> 0x019a }
            r4 = 0
            r6 = 0
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = "b|"
            r0 = r25
            r0.<init>(r5)     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r10)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = "|"
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r1 = r22
            r0.append(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = "|"
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            int r5 = r9.size()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = "|"
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            int r5 = r7.size()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            java.util.HashSet r26 = new java.util.HashSet     // Catch:{ Throwable -> 0x019a }
            r26.<init>()     // Catch:{ Throwable -> 0x019a }
            java.util.Iterator r27 = r7.iterator()     // Catch:{ Throwable -> 0x019a }
            r7 = r4
        L_0x00a9:
            boolean r4 = r27.hasNext()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x0539
            java.lang.Object r4 = r27.next()     // Catch:{ Throwable -> 0x019a }
            r0 = r4
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Throwable -> 0x019a }
            r5 = r0
            java.util.Iterator r28 = r5.keys()     // Catch:{ Throwable -> 0x019a }
            r10 = r19
            r11 = r20
            r12 = r16
            r17 = r13
        L_0x00c3:
            boolean r4 = r28.hasNext()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x052f
            java.lang.Object r4 = r28.next()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x019a }
            java.lang.String r19 = r5.getString(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "AdMobDiscovery"
            java.lang.StringBuilder r16 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r16.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r20 = "found ad part - key: "
            r0 = r16
            r1 = r20
            java.lang.StringBuilder r16 = r0.append(r1)     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            java.lang.StringBuilder r16 = r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r20 = ", value: "
            r0 = r16
            r1 = r20
            java.lang.StringBuilder r16 = r0.append(r1)     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            r1 = r19
            java.lang.StringBuilder r16 = r0.append(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = r16.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            com.example.safesdk.sample.utils.Logger.m3607v(r13, r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "|"
            r0 = r25
            r0.append(r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "->"
            r0 = r25
            r0.append(r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r26
            boolean r13 = r0.contains(r4)     // Catch:{ Throwable -> 0x019a }
            if (r13 != 0) goto L_0x01a6
            r13 = 1
        L_0x0122:
            r0 = r26
            r0.add(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = "ad_html"
            r0 = r16
            boolean r16 = r4.equals(r0)     // Catch:{ Throwable -> 0x019a }
            if (r16 == 0) goto L_0x0429
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.String r7 = "processing ad html"
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r7)     // Catch:{ Throwable -> 0x019a }
            r0 = r29
            r1 = r19
            r2 = r24
            com.example.safesdk.sample.analytics.brandsafety.creatives.f$a r7 = r0.m3140a((java.lang.String) r1, (java.util.List<java.lang.String>) r2)     // Catch:{ Throwable -> 0x019a }
            r18 = 0
            if (r7 == 0) goto L_0x0294
            if (r13 != 0) goto L_0x01a9
            java.lang.String r4 = "sk&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            if (r7 == 0) goto L_0x00c3
            java.lang.String r4 = "vast"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "c="
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = r7.mo19349a()     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "&i="
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = r7.mo19355c()     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x00c3
        L_0x019a:
            r4 = move-exception
            java.lang.String r5 = "AdMobDiscovery"
            java.lang.String r4 = r4.getMessage()
            com.example.safesdk.sample.utils.Logger.m3603e(r5, r4)
            r10 = 0
        L_0x01a5:
            return r10
        L_0x01a6:
            r13 = 0
            goto L_0x0122
        L_0x01a9:
            java.lang.String r10 = "vast"
            r0 = r25
            r0.append(r10)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r7.mo19352b()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x01c9
            java.lang.String r12 = r7.mo19352b()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "dv&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x01c9:
            java.lang.String r4 = r7.mo19349a()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x069b
            java.lang.String r13 = r7.mo19349a()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "dc&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x01da:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = "&c="
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = r7.mo19349a()     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = "&"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r7.mo19355c()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x0214
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.String r8 = "Using ad id from vast"
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r17 = r7.mo19355c()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "debugi&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x0214:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = "&i="
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Throwable -> 0x019a }
            r0 = r17
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = "&"
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            r14 = r17
        L_0x0236:
            java.util.regex.Pattern r4 = f2848Q     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.util.regex.Matcher r4 = r4.matcher(r0)     // Catch:{ Throwable -> 0x019a }
            boolean r4 = r4.find()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x0252
            java.lang.String r6 = "playable"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x0252:
            if (r7 == 0) goto L_0x0694
            java.util.regex.Pattern r4 = com.example.safesdk.sample.analytics.brandsafety.creatives.C1317f.f2921n     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.util.regex.Matcher r4 = r4.matcher(r0)     // Catch:{ Throwable -> 0x019a }
            boolean r8 = r4.find()     // Catch:{ Throwable -> 0x019a }
            if (r8 == 0) goto L_0x0694
            r8 = 0
            java.lang.String r4 = r4.group(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = ""
            r0 = r19
            java.lang.String r4 = r0.replace(r4, r8)     // Catch:{ Throwable -> 0x019a }
        L_0x026f:
            java.util.ArrayList r8 = com.example.safesdk.sample.utils.C1361h.m3704d(r4)     // Catch:{ Throwable -> 0x019a }
            r4 = 0
            r16 = r4
        L_0x0276:
            int r4 = r8.size()     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            if (r0 >= r4) goto L_0x0402
            r0 = r16
            java.lang.Object r4 = r8.get(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = com.example.safesdk.sample.utils.C1361h.m3710h(r4)     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            r8.set(r0, r4)     // Catch:{ Throwable -> 0x019a }
            int r4 = r16 + 1
            r16 = r4
            goto L_0x0276
        L_0x0294:
            java.lang.String r8 = com.example.safesdk.sample.utils.C1361h.m3710h(r19)     // Catch:{ Throwable -> 0x019a }
            java.util.regex.Pattern r4 = f2846O     // Catch:{ Throwable -> 0x019a }
            java.util.regex.Matcher r4 = r4.matcher(r8)     // Catch:{ Throwable -> 0x019a }
        L_0x029e:
            boolean r11 = r4.find()     // Catch:{ Throwable -> 0x019a }
            if (r11 == 0) goto L_0x02fd
            int r6 = r4.groupCount()     // Catch:{ Throwable -> 0x019a }
            r11 = 1
            if (r6 <= r11) goto L_0x02d7
            r6 = 2
            java.lang.String r6 = r4.group(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "<br>"
            java.lang.String r13 = " "
            java.lang.String r6 = r6.replace(r11, r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "AdMobDiscovery"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r13.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = "found ad text "
            r0 = r16
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r13 = r13.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = r13.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r11, r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r21
            r0.add(r6)     // Catch:{ Throwable -> 0x019a }
        L_0x02d7:
            java.lang.String r6 = "text"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "&"
            r0 = r25
            r0.append(r11)     // Catch:{ Throwable -> 0x019a }
            java.util.regex.Pattern r11 = f2849R     // Catch:{ Throwable -> 0x019a }
            boolean r11 = com.example.safesdk.sample.utils.C1361h.m3695b((java.util.regex.Pattern) r11, (java.lang.String) r8)     // Catch:{ Throwable -> 0x019a }
            if (r11 == 0) goto L_0x029e
            java.lang.String r6 = "image"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "&"
            r0 = r25
            r0.append(r11)     // Catch:{ Throwable -> 0x019a }
            goto L_0x029e
        L_0x02fd:
            java.util.regex.Pattern r4 = f2847P     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.util.regex.Matcher r4 = r4.matcher(r0)     // Catch:{ Throwable -> 0x019a }
            boolean r11 = r4.find()     // Catch:{ Throwable -> 0x019a }
            if (r11 == 0) goto L_0x0367
            r6 = 1
            java.lang.String r4 = r4.group(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = com.example.safesdk.sample.utils.C1361h.m3710h(r4)     // Catch:{ Throwable -> 0x019a }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x03b5 }
            r6.<init>(r4)     // Catch:{ Throwable -> 0x03b5 }
            java.lang.String r4 = "longform_questions"
            org.json.JSONArray r6 = r6.getJSONArray(r4)     // Catch:{ Throwable -> 0x03b5 }
            r4 = 0
        L_0x0320:
            int r11 = r6.length()     // Catch:{ Throwable -> 0x03b5 }
            if (r4 >= r11) goto L_0x0358
            org.json.JSONObject r11 = r6.getJSONObject(r4)     // Catch:{ Throwable -> 0x03b5 }
            java.lang.String r13 = "question"
            java.lang.String r11 = r11.getString(r13)     // Catch:{ Throwable -> 0x03b5 }
            java.lang.String r13 = "AdMobDiscovery"
            java.lang.StringBuilder r16 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x03b5 }
            r16.<init>()     // Catch:{ Throwable -> 0x03b5 }
            java.lang.String r20 = "found ad survey text "
            r0 = r16
            r1 = r20
            java.lang.StringBuilder r16 = r0.append(r1)     // Catch:{ Throwable -> 0x03b5 }
            r0 = r16
            java.lang.StringBuilder r16 = r0.append(r11)     // Catch:{ Throwable -> 0x03b5 }
            java.lang.String r16 = r16.toString()     // Catch:{ Throwable -> 0x03b5 }
            r0 = r16
            com.example.safesdk.sample.utils.Logger.m3601d(r13, r0)     // Catch:{ Throwable -> 0x03b5 }
            r0 = r21
            r0.add(r11)     // Catch:{ Throwable -> 0x03b5 }
            int r4 = r4 + 1
            goto L_0x0320
        L_0x0358:
            java.lang.String r6 = "survey"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x0367:
            r0 = r29
            java.lang.String r13 = r0.mo19343j(r8)     // Catch:{ Throwable -> 0x019a }
            if (r13 == 0) goto L_0x0698
            java.lang.String r4 = "dd_c&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x0376:
            r0 = r29
            java.lang.String r11 = r0.mo19344k(r8)     // Catch:{ Throwable -> 0x019a }
            java.util.regex.Pattern r4 = f2850S     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.util.regex.Matcher r4 = r4.matcher(r0)     // Catch:{ Throwable -> 0x019a }
            boolean r8 = r4.find()     // Catch:{ Throwable -> 0x019a }
            if (r8 == 0) goto L_0x03fe
            r8 = 2
            java.lang.String r4 = r4.group(r8)     // Catch:{ Throwable -> 0x019a }
            int r8 = r4.length()     // Catch:{ Throwable -> 0x019a }
            r14 = 20
            if (r8 <= r14) goto L_0x03f3
            java.lang.String r8 = "AdMobDiscovery"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r14.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = "Discarding bad url "
            r0 = r16
            java.lang.StringBuilder r14 = r14.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r14.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r8, r4)     // Catch:{ Throwable -> 0x019a }
            r14 = r17
            goto L_0x0236
        L_0x03b5:
            r4 = move-exception
            java.lang.String r6 = "AdMobDiscovery"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e2 }
            r11.<init>()     // Catch:{ all -> 0x03e2 }
            java.lang.String r13 = "error parsing ad survey text "
            java.lang.StringBuilder r11 = r11.append(r13)     // Catch:{ all -> 0x03e2 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x03e2 }
            java.lang.StringBuilder r4 = r11.append(r4)     // Catch:{ all -> 0x03e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03e2 }
            com.example.safesdk.sample.utils.Logger.m3601d(r6, r4)     // Catch:{ all -> 0x03e2 }
            java.lang.String r6 = "survey"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x0367
        L_0x03e2:
            r4 = move-exception
            java.lang.String r5 = "survey"
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = "&"
            r0 = r25
            r0.append(r5)     // Catch:{ Throwable -> 0x019a }
            throw r4     // Catch:{ Throwable -> 0x019a }
        L_0x03f3:
            java.lang.String r12 = com.example.safesdk.sample.utils.C1361h.m3698c((java.lang.String) r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "du&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
        L_0x03fe:
            r14 = r17
            goto L_0x0236
        L_0x0402:
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.StringBuilder r16 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r16.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r17 = "generateInfo html "
            java.lang.StringBuilder r16 = r16.append(r17)     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            r1 = r19
            java.lang.StringBuilder r16 = r0.append(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = r16.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r16
            com.example.safesdk.sample.utils.C1361h.m3694b((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Throwable -> 0x019a }
            r4 = r6
            r16 = r14
        L_0x0423:
            r6 = r4
            r14 = r13
            r17 = r16
            goto L_0x00c3
        L_0x0429:
            java.lang.String r16 = "pubid"
            r0 = r16
            boolean r16 = r4.equals(r0)     // Catch:{ Throwable -> 0x019a }
            if (r16 == 0) goto L_0x048e
            if (r13 != 0) goto L_0x0452
            java.lang.String r4 = "sk&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            r4 = 0
            r13 = 47
            r0 = r19
            int r13 = r0.lastIndexOf(r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.lang.String r4 = r0.substring(r4, r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x00c3
        L_0x0452:
            r4 = 47
            r0 = r19
            int r4 = r0.lastIndexOf(r4)     // Catch:{ Throwable -> 0x019a }
            r13 = 0
            r0 = r19
            java.lang.String r15 = r0.substring(r13, r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r13.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = "generateInfo placementId "
            r0 = r16
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r13 = r13.append(r15)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = r13.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r13)     // Catch:{ Throwable -> 0x019a }
            r18 = 0
            r0 = r25
            r0.append(r15)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            r4 = r6
            r13 = r14
            r16 = r17
            goto L_0x0423
        L_0x048e:
            java.lang.String r16 = "clickUrl"
            r0 = r16
            boolean r4 = r4.equals(r0)     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x068e
            if (r13 != 0) goto L_0x04e3
            java.lang.String r4 = "sk&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "c="
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r29
            r1 = r19
            java.lang.String r13 = r0.m3143p(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r4.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r13 = "&i="
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            r0 = r29
            r1 = r19
            java.lang.String r13 = r0.m3144q(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r4 = r4.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x00c3
        L_0x04e3:
            java.lang.String r4 = "AdMobDiscovery"
            r0 = r19
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r0)     // Catch:{ Throwable -> 0x019a }
            if (r14 != 0) goto L_0x068b
            r0 = r29
            r1 = r19
            java.lang.String r13 = r0.m3143p(r1)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "dc2&"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r14.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r16 = "generateInfo click url "
            r0 = r16
            java.lang.StringBuilder r14 = r14.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r14 = r14.append(r13)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r14 = r14.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r14)     // Catch:{ Throwable -> 0x019a }
        L_0x0515:
            if (r17 != 0) goto L_0x0687
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.String r14 = "Extracting creativeId"
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r14)     // Catch:{ Throwable -> 0x019a }
            r0 = r29
            r1 = r19
            java.lang.String r14 = r0.m3144q(r1)     // Catch:{ Throwable -> 0x019a }
        L_0x0526:
            r17 = 0
            r4 = r6
            r16 = r14
            r18 = r17
            goto L_0x0423
        L_0x052f:
            r19 = r10
            r20 = r11
            r16 = r12
            r13 = r17
            goto L_0x00a9
        L_0x0539:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r10 = "AdMobDiscovery"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r11.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r12 = "generateInfo: json build time "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Throwable -> 0x019a }
            long r22 = r4 - r22
            r0 = r22
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = r11.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r10, r11)     // Catch:{ Throwable -> 0x019a }
            java.lang.Class r10 = r30.getClass()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r10 = r10.getSimpleName()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "Interstitial"
            boolean r10 = r10.contains(r11)     // Catch:{ Throwable -> 0x019a }
            if (r10 == 0) goto L_0x057b
            com.example.safesdk.sample.analytics.events.BrandSafetyEvent$AdFormatType r10 = com.example.safesdk.sample.analytics.events.BrandSafetyEvent.AdFormatType.INTER     // Catch:{ Throwable -> 0x019a }
            java.lang.String r17 = r10.toString()     // Catch:{ Throwable -> 0x019a }
        L_0x056f:
            if (r18 == 0) goto L_0x0582
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.String r5 = "generateInfo: prefetch is NULL"
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r5)     // Catch:{ Throwable -> 0x019a }
            r10 = 0
            goto L_0x01a5
        L_0x057b:
            com.example.safesdk.sample.analytics.events.BrandSafetyEvent$AdFormatType r10 = com.example.safesdk.sample.analytics.events.BrandSafetyEvent.AdFormatType.REWARD     // Catch:{ Throwable -> 0x019a }
            java.lang.String r17 = r10.toString()     // Catch:{ Throwable -> 0x019a }
            goto L_0x056f
        L_0x0582:
            if (r14 == 0) goto L_0x058d
            java.lang.String r10 = "ignore_this_destination"
            boolean r10 = r14.contains(r10)     // Catch:{ Throwable -> 0x019a }
            if (r10 == 0) goto L_0x058d
            r14 = 0
        L_0x058d:
            if (r19 == 0) goto L_0x061a
            if (r6 == 0) goto L_0x05ab
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r10.<init>()     // Catch:{ Throwable -> 0x019a }
            r0 = r19
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r11 = "|"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r6 = r10.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r19 = r6.toString()     // Catch:{ Throwable -> 0x019a }
        L_0x05ab:
            com.example.safesdk.sample.analytics.brandsafety.creatives.infos.AdMobCreativeInfo r10 = new com.example.safesdk.sample.analytics.brandsafety.creatives.infos.AdMobCreativeInfo     // Catch:{ Throwable -> 0x019a }
            r11 = 0
            com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils$AdType r12 = com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils.AdType.INTERSTITIAL     // Catch:{ Throwable -> 0x019a }
            java.lang.String r18 = f2851T     // Catch:{ Throwable -> 0x019a }
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r6 = "|"
            r0 = r25
            r0.append(r6)     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "|"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            int r4 = r9.size()     // Catch:{ Throwable -> 0x019a }
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "|"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            if (r8 != 0) goto L_0x061d
            java.lang.String r4 = "e"
        L_0x05df:
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "|"
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.util.List r4 = r7.mo19366j()     // Catch:{ Throwable -> 0x019a }
            if (r4 != 0) goto L_0x0626
            java.lang.String r4 = "v"
        L_0x05f5:
            r0 = r25
            r0.append(r4)     // Catch:{ Throwable -> 0x019a }
            r10.mo19397b((java.util.List<java.lang.String>) r9)     // Catch:{ Throwable -> 0x019a }
            r10.mo19397b((java.util.List<java.lang.String>) r8)     // Catch:{ Throwable -> 0x019a }
            r4 = 0
            r0 = r29
            r0.mo19336a(r10, r7, r4)     // Catch:{ Throwable -> 0x019a }
            java.util.Iterator r5 = r24.iterator()     // Catch:{ Throwable -> 0x019a }
        L_0x060a:
            boolean r4 = r5.hasNext()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x0633
            java.lang.Object r4 = r5.next()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x019a }
            r10.mo19438t(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x060a
        L_0x061a:
            r19 = r6
            goto L_0x05ab
        L_0x061d:
            int r4 = r8.size()     // Catch:{ Throwable -> 0x019a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x05df
        L_0x0626:
            java.util.List r4 = r7.mo19366j()     // Catch:{ Throwable -> 0x019a }
            int r4 = r4.size()     // Catch:{ Throwable -> 0x019a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x05f5
        L_0x0633:
            int r4 = r21.size()     // Catch:{ Throwable -> 0x019a }
            r5 = 3
            if (r4 <= r5) goto L_0x0666
            java.util.Iterator r5 = r21.iterator()     // Catch:{ Throwable -> 0x019a }
        L_0x063e:
            boolean r4 = r5.hasNext()     // Catch:{ Throwable -> 0x019a }
            if (r4 == 0) goto L_0x0666
            java.lang.Object r4 = r5.next()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Throwable -> 0x019a }
            java.lang.String r6 = "AdMobDiscovery"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r7.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r8 = "generateInfo ad text "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r7 = r7.append(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r6, r7)     // Catch:{ Throwable -> 0x019a }
            r10.mo19436s(r4)     // Catch:{ Throwable -> 0x019a }
            goto L_0x063e
        L_0x0666:
            java.lang.String r4 = r25.toString()     // Catch:{ Throwable -> 0x019a }
            r10.mo19428o(r4)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r4 = "AdMobDiscovery"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x019a }
            r5.<init>()     // Catch:{ Throwable -> 0x019a }
            java.lang.String r6 = "generateInfo "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ Throwable -> 0x019a }
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch:{ Throwable -> 0x019a }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x019a }
            com.example.safesdk.sample.utils.Logger.m3601d(r4, r5)     // Catch:{ Throwable -> 0x019a }
            goto L_0x01a5
        L_0x0687:
            r14 = r17
            goto L_0x0526
        L_0x068b:
            r13 = r14
            goto L_0x0515
        L_0x068e:
            r4 = r6
            r13 = r14
            r16 = r17
            goto L_0x0423
        L_0x0694:
            r4 = r19
            goto L_0x026f
        L_0x0698:
            r13 = r14
            goto L_0x0376
        L_0x069b:
            r13 = r14
            goto L_0x01da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.C1312b.mo19291a(java.lang.Object):com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo");
    }

    
    /* renamed from: b */
    public List<CreativeInfo> mo19330b(String str, String str2, Map<String, List<String>> map, C1313c.C1314a aVar) throws JSONException {
        return null;
    }

    
    /* renamed from: a */
    public String mo19329a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    
    /* renamed from: g */
    public boolean mo19331g(String str) {
        return false;
    }

    
    /* renamed from: h */
    public boolean mo19332h(String str) {
        return false;
    }

    /* renamed from: a */
    private C1317f.C1318a m3140a(String str, List<String> list) {
        C1317f.C1318a c = C1317f.m3211c(str, true);
        if (c == null) {
            return null;
        }
        String c2 = c.mo19355c();
        String d = c.mo19358d();
        List<String> i = c.mo19365i();
        List<String> o = c.mo19371o();
        List<String> n = c.mo19370n();
        List<String> p = c.mo19372p();
        List<String> q = c.mo19373q();
        Logger.m3601d(f2852r, "GetVastInfoRecursive saved adId: " + c2 + ", adSystem: " + d + " and impressionUrls: " + i);
        C1361h.m3694b(f2852r, "GetVastInfoRecursive vastAdInfo : " + c);
        while (c != null && c.mo19360e() != null) {
            Logger.m3601d(f2852r, "GetVastInfoRecursive fetching vast ad uri " + c.mo19360e());
            list.add(c.mo19360e());
            String o2 = m3142o(c.mo19360e());
            C1361h.m3694b(f2852r, "GetVastInfoRecursive adTagUriContent=" + o2);
            c = C1317f.m3211c(o2, true);
            C1361h.m3694b(f2852r, "GetVastInfoRecursive vastAdInfo (recursive) : " + c);
        }
        if (!(c2 == null || c.mo19355c() == c2)) {
            c.mo19350a(c2);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved adId from outer vast: " + c2);
        }
        if (!(d == null || c.mo19358d() == d)) {
            c.mo19353b(d);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved adSystem from outer vast: " + d);
        }
        if (i != null) {
            c.mo19351a(i);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved impressionUrls from outer vast: " + i);
        }
        if (o != null) {
            c.mo19357c(o);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved videoTrackingEventUrls from outer vast: " + o);
        }
        if (n != null) {
            c.mo19354b(n);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved videoCompletedUrls from outer vast: " + n);
        }
        if (p != null) {
            c.mo19359d(p);
            Logger.m3601d(f2852r, "GetVastInfoRecursive saved clickTrackingUrls from outer vast: " + p);
        }
        if (q == null) {
            return c;
        }
        c.mo19361e(q);
        Logger.m3601d(f2852r, "GetVastInfoRecursive saved companionClickTrackingUrls from outer vast: " + q);
        return c;
    }

    /* renamed from: o */
    private String m3142o(String str) {
        InputStream inputStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            inputStream = new URL(str).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            inputStream.close();
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    /* renamed from: p */
    private String m3143p(String str) {
        int indexOf;
        try {
            int indexOf2 = str.indexOf(f2836E);
            if (indexOf2 != -1) {
                String decode = URLDecoder.decode(str.substring(indexOf2 + f2836E.length(), str.indexOf(38, indexOf2)), XmpWriter.UTF8);
                Logger.m3601d(f2852r, "clickUrl landing page " + decode);
                if (decode.startsWith("http")) {
                    Logger.m3601d(f2852r, "clickUrl landing page url " + decode);
                    return decode;
                } else if (decode.startsWith(f2839H) && (indexOf = decode.indexOf(61)) != -1) {
                    int indexOf3 = decode.indexOf(38, indexOf);
                    if (indexOf3 == -1) {
                        indexOf3 = decode.length();
                    }
                    String substring = decode.substring(indexOf + 1, indexOf3);
                    Logger.m3601d(f2852r, "clickUrl landing page package id " + substring);
                    return C1324f.m3386c(substring);
                }
            }
        } catch (UnsupportedEncodingException e) {
            Logger.m3603e(f2852r, e.getMessage());
        }
        return null;
    }

    /* renamed from: q */
    private String m3144q(String str) {
        int indexOf = str.indexOf(f2837F);
        if (indexOf == -1) {
            return null;
        }
        return str.substring(indexOf + f2837F.length(), str.indexOf(38, f2837F.length() + indexOf));
    }

    /* renamed from: a */
    private void m3141a(Object obj, List<String> list, List<Object> list2, Set<Object> set, List<String> list3) {
        if (obj != null && !set.contains(obj)) {
            set.add(obj);
            Class cls = obj.getClass();
            ArrayList<Field> arrayList = new ArrayList<>();
            do {
                arrayList.addAll(Arrays.asList(cls.getDeclaredFields()));
                cls = cls.getSuperclass();
            } while (cls.getName().startsWith("com.google.android.gms"));
            for (Field field : arrayList) {
                field.setAccessible(true);
                try {
                    Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        if (field.getType().getName().equals("interface") || obj2.getClass().getName().startsWith("com.google.android.gms")) {
                            list.add(field.getName());
                            m3141a(obj2, list, list2, set, list3);
                            list.remove(list.size() - 1);
                        } else if (field.getType().getName().equals(f2855z)) {
                            list.add(field.getName());
                            Logger.m3601d(f2852r, "found prefetch info in path: " + list + ", object: " + obj2);
                            list2.add(obj2);
                            list.remove(list.size() - 1);
                        } else if (obj2.getClass().getName().startsWith(f2854y)) {
                            String str = (String) obj2;
                            if (str != null && str.startsWith(f2840I)) {
                                list.add(field.getName());
                                Logger.m3601d(f2852r, "found prefetch click url in path: " + list + ", object: " + obj2);
                                try {
                                    list2.add(new JSONObject("{ \"clickUrl\" : \"" + str + "\" }"));
                                } catch (JSONException e) {
                                }
                                list.remove(list.size() - 1);
                            } else if (str != null && str.startsWith(f2841J)) {
                                list.add(field.getName());
                                Logger.m3601d(f2852r, "found sdk version in path: " + list + ", object: " + obj2);
                                String[] split = str.split("\\.");
                                if (split.length > 1) {
                                    f2851T = split[1];
                                    if (f2851T != null) {
                                        mo19341e(C1357d.f3603k, f2851T);
                                    }
                                }
                                list.remove(list.size() - 1);
                            }
                        } else if (field.getType().getName().equals(f2842K)) {
                            list.add(field.getName());
                            Logger.m3601d(f2852r, "found resource url in path: " + list);
                            for (Object obj3 : ((LinkedHashMap) obj2).values()) {
                                String r = m3145r(obj3.toString());
                                if (r != null) {
                                    Logger.m3601d(f2852r, "resource url: " + r);
                                    list3.add(r);
                                }
                            }
                            list.remove(list.size() - 1);
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Logger.m3603e(f2852r, e2.getMessage());
                }
            }
        }
    }

    /* renamed from: r */
    private String m3145r(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(34);
        if (indexOf2 <= -1 || (indexOf = str.indexOf(34, indexOf2 + 1)) <= -1) {
            return null;
        }
        return str.substring(indexOf2 + 1, indexOf);
    }

    /* renamed from: c */
    public Set<String> mo19305c() {
        return new HashSet();
    }
}

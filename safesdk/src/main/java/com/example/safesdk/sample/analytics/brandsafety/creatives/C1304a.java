package com.example.safesdk.sample.analytics.brandsafety.creatives;

import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.a */
public class C1304a {

    /* renamed from: b */
    private static  String f2781b = "MraidParser";

    /* renamed from: c */
    private static  String f2782c = "markup";

    /* renamed from: d */
    private static  String f2783d = "advDomain";

    /* renamed from: e */
    private static  String f2784e = "creativeId";

    /* renamed from: f */
    private static  String f2785f = "content";

    /* renamed from: g */
    private static  Pattern f2786g = Pattern.compile("<a.*?id=\"liftoff-link\".*a>", 2);

    /* renamed from: h */
    private static  Pattern f2787h = Pattern.compile("videoSrc:%20%22(.*?)%22", 2);

    /* renamed from: i */
    private static  Pattern f2788i = Pattern.compile("href=\"([^\"]+)\"");

    /* renamed from: a */
    protected JSONObject f2789a;

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.a$a */
    public class C1305a {

        /* renamed from: a */
        public String f2790a;

        /* renamed from: b */
        public String f2791b;

        /* renamed from: c */
        public String f2792c;

        /* renamed from: d */
        public String f2793d;

        /* renamed from: e */
        public String f2794e;

        public C1305a() {
        }
    }

    public C1304a(JSONObject jSONObject) {
        this.f2789a = jSONObject;
    }

    /* renamed from: a */
    public C1305a mo19326a() {
        C1305a aVar = new C1305a();
        if (this.f2789a != null) {
            try {
                String string = this.f2789a.getString("content");
                aVar.f2790a = this.f2789a.getString(f2784e);
                aVar.f2792c = this.f2789a.optString(f2783d, (String) null);
                aVar.f2793d = mo19327a(new JSONObject(string));
                Logger.m3601d(f2781b, "mraid Markup (url encoded)=" + aVar.f2793d);
                aVar.f2791b = m3110a(aVar.f2793d);
                Logger.m3601d(f2781b, "mraid clickURL = " + aVar.f2791b);
                aVar.f2794e = m3111b(aVar.f2793d);
                Logger.m3601d(f2781b, "mraid videoUrl = " + aVar.f2794e);
            } catch (JSONException e) {
                Logger.m3601d(f2781b, "mraid error " + e.getMessage() + " parsing" + this.f2789a.toString());
            }
        }
        return aVar;
    }

    
    /* renamed from: a */
    public String mo19327a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getString("markup");
    }

    /* renamed from: a */
    private String m3110a(String str) {
        Matcher matcher = f2786g.matcher(str);
        if (matcher.find()) {
            return m3112c(matcher.group(0));
        }
        return null;
    }

    /* renamed from: b */
    private String m3111b(String str) {
        Matcher matcher = f2787h.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* renamed from: c */
    private String m3112c(String str) {
        String c = C1361h.m3700c(f2788i, str);
        Logger.m3601d(f2781b, "found click url: " + c);
        return c;
    }
}

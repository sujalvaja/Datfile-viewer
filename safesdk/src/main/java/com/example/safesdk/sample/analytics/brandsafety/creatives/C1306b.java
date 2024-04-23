package com.example.safesdk.sample.analytics.brandsafety.creatives;

import com.example.safesdk.sample.analytics.brandsafety.creatives.C1304a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.b */
public class C1306b extends C1304a {

    /* renamed from: b */
    private static  String f2796b = "bundleId";

    /* renamed from: c */
    private static  String f2797c = "dynamicMarkup";

    /* renamed from: d */
    private static  Pattern f2798d = Pattern.compile("ad_click_dest[\\s].*?=[\\s].*?\\\"([\\S].*?)\\\"");

    public C1306b(JSONObject jSONObject) {
        super(jSONObject);
    }

    /* renamed from: a */
    public C1304a.C1305a mo19326a() {
        C1304a.C1305a a = super.mo19326a();
        if (this.f2789a.optString(f2796b, (String) null) == null) {
            a.f2791b = m3115a(a.f2793d);
        }
        return a;
    }

    
    /* renamed from: a */
    public String mo19327a(JSONObject jSONObject) throws JSONException {
        return jSONObject.getString(f2797c);
    }

    /* renamed from: a */
    private String m3115a(String str) {
        Matcher matcher = f2798d.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            return null;
        }
        return matcher.group(1);
    }
}

package com.example.safesdk.sample.analytics.reporters;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.safesdk.sample.*;
import com.example.safesdk.sample.utils.C1356c;
import com.example.safesdk.sample.utils.C1361h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.analytics.reporters.b */
public abstract class C1342b {
    Object AppMeasurementSdk;
    /* renamed from: a */
    public static  String f3324a = "exceptions";

    /* renamed from: b */
    public static  String f3325b = "type";

    /* renamed from: c */
    public static  String f3326c = "message";

    /* renamed from: d */
    public static  String f3327d = "lines";

    /* renamed from: e */
    public static  String f3328e = "proguard_map_uuid";

    /* renamed from: g */
    private static  String f3329g = "build_params";

    /* renamed from: h */
    private static  String f3330h = "crash_stacktrace";

    /* renamed from: i */
    private static  String f3331i = "threads_traces";

    /* renamed from: j */
    private static  String f3332j = "is_low_memory";

    /* renamed from: f */
    protected Context f3333f = null;

    public C1342b() {
        if (SafeDK.getInstance() != null) {
            this.f3333f = SafeDK.getInstance().mo19137g();
        }
    }

    public C1342b(Context context) {
        this.f3333f = context;
    }

    
    /* renamed from: a */
    public JSONObject mo19556a(Throwable th, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f3329g, C1361h.m3683a(m3486a()));
        jSONObject.put(f3332j, C1356c.m3632b(this.f3333f));
        jSONObject.put(f3330h, mo19555a(th));
        if (z) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                jSONArray.put(mo19554a((Thread) next.getKey(), (StackTraceElement[]) next.getValue()));
            }
            jSONObject.put(f3331i, jSONArray);
        }
        String proguardMD5 = SafeDK.getProguardMD5();
        if (!TextUtils.isEmpty(proguardMD5)) {
            jSONObject.put(f3328e, proguardMD5);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private Bundle m3486a() {
        Bundle bundle = new Bundle();
        m3487a(Build.class, "", bundle);
        m3487a(Build.VERSION.class, "VERSION", bundle);
        return bundle;
    }

    /* renamed from: a */
    private void m3487a(Class<?> cls, String str, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (Field field : cls.getFields()) {
            StringBuilder sb2 = new StringBuilder();
            if (str != null && str.length() > 0) {
                sb2.append(str).append('.');
            }
            sb2.append(field.getName());
            try {
                Object obj = field.get((Object) null);
                if (obj != null) {
                    if (field.getType().isArray()) {
                        bundle.putParcelableArrayList(sb2.toString(), (ArrayList) Arrays.asList(new Object[]{obj}));
                    } else {
                        bundle.putString(sb2.toString(), obj.toString());
                    }
                }
            } catch (IllegalArgumentException e) {
                sb.append("N/A");
            } catch (IllegalAccessException e2) {
                sb.append("N/A");
            } catch (Exception e3) {
            }
        }
    }

    
    /* renamed from: a */
    public JSONObject mo19555a(Throwable th) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONObject.put(f3324a, jSONArray);
        m3488a(th, jSONArray);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            m3488a(cause, jSONArray);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m3488a(Throwable th, JSONArray jSONArray) throws JSONException {
        if (th != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", th.getClass());
            jSONObject.put(f3326c, th.getMessage());
            m3489a(jSONObject, th.getStackTrace());
            jSONArray.put(jSONObject);
        }
    }

    /* renamed from: a */
    private void m3489a(JSONObject jSONObject, StackTraceElement[] stackTraceElementArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("c", stackTraceElement.getClassName());
            jSONObject2.put("m", stackTraceElement.getMethodName());
            jSONObject2.put("f", stackTraceElement.getFileName());
            jSONObject2.put("l", stackTraceElement.getLineNumber());
            jSONObject2.put("n", stackTraceElement.isNativeMethod());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put(f3327d, jSONArray);
    }

    
    /* renamed from: a */
    public JSONObject mo19554a(Thread thread, StackTraceElement[] stackTraceElementArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();


        m3489a(jSONObject, stackTraceElementArr);
        return jSONObject;
    }
}

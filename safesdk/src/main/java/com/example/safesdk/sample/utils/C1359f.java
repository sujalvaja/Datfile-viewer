package com.example.safesdk.sample.utils;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.google.android.gms.common.util.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.example.safesdk.sample.utils.f */
public class C1359f {

    /* renamed from: a */
    public static  String f3620a = "sdk_key";

    /* renamed from: b */
    public static  String f3621b = "userUUID";

    /* renamed from: c */
    public static  String f3622c = "configuration";

    /* renamed from: d */
    public static  String f3623d = "last_reported_device_at";

    /* renamed from: e */
    public static  String f3624e = "last_reported_version";

    /* renamed from: f */
    public static  String f3625f = "configETag";

    /* renamed from: g */
    public static  String f3626g = "sdk_version";

    /* renamed from: h */
    public static  String f3627h = "versionCode";

    /* renamed from: i */
    public static  String f3628i = "randomToken";

    /* renamed from: j */
    public static  int f3629j = -1;

    /* renamed from: k */
    public static  String f3630k = "";

    /* renamed from: l */
    private static  String f3631l = "SharedPreferencesUtils";

    /* renamed from: m */
    private static  String f3632m = "offlineMode";

    /* renamed from: n */
    private static  String f3633n = "age";

    /* renamed from: o */
    private static  String f3634o = "region";

    /* renamed from: p */
    private static  String f3635p = "last_foreground_time";

    /* renamed from: q */
    private static  String f3636q = "last_foreground_report";

    /* renamed from: r */
    private static  String f3637r = "sdk_versions";

    /* renamed from: s */
    private static  String f3638s = "is_reported";

    /* renamed from: w */
    private static  String f3639w = "safedk_stored_version";

    /* renamed from: x */
    private static  String f3640x = "§§";

    /* renamed from: t */
    private  SharedPreferences f3641t;

    /* renamed from: u */
    private boolean f3642u;

    /* renamed from: v */
    private JSONObject f3643v;

    public C1359f(SharedPreferences sharedPreferences, boolean z) {
        this.f3641t = sharedPreferences;
        this.f3642u = z;
    }

    /* renamed from: a */
    private void m3639a(Map<String, String> map) {
        try {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(str);
                Logger.m3601d(f3631l, "addDiscoveredVersionsToVersionsJson sdkPackage=" + str + ", version=" + str2 + ", uuid=" + sdkUUIDByPackage);
                if (sdkUUIDByPackage != null) {
                    if (sdkUUIDByPackage.length() > 0 && str2 != null && str2.length() > 0) {
                        this.f3643v.put(sdkUUIDByPackage, str2);
                    }
                }
                Logger.m3601d(f3631l, "UUID for sdkPackage " + str + "is empty and will not be added to sdkVersionsJson");
            }
            m3640a(this.f3643v);
        } catch (JSONException e) {
            Logger.m3602d(f3631l, "error in addDiscoveredVersionsToVersionsJson", e);
        } catch (Throwable th) {
            Logger.m3604e(f3631l, "Exception in addDiscoveredVersionsToVersionsJson", th);
        }
    }

    /* renamed from: a */
    private void m3640a(JSONObject jSONObject) {
        SharedPreferences.Editor edit = this.f3641t.edit();
        edit.putString(f3637r, jSONObject.toString());
        Logger.m3601d(f3631l, "saveSdkVersions saved (" + jSONObject.length() + " items) : " + jSONObject.toString());
        edit.commit();
    }

    /* renamed from: a */
    public String mo19681a() {
        return this.f3641t.getString(f3621b, (String) null);
    }

    /* renamed from: b */
    public boolean mo19686b() {
        return this.f3641t.getBoolean(f3632m, this.f3642u);
    }

    /* renamed from: c */
    public Integer mo19687c() {
        int i = this.f3641t.getInt(f3633n, -1);
        if (i < 0) {
            return null;
        }
        return new Integer(i);
    }

    /* renamed from: d */
    public String mo19689d() {
        return this.f3641t.getString(f3634o, (String) null);
    }

    /* renamed from: e */
    public Bundle mo19690e() {
        Logger.m3601d(f3631l, "getConfiguration started");
        return m3636a(this.f3641t, f3622c);
    }

    /* renamed from: f */
    public long mo19691f() {
        return this.f3641t.getLong(f3623d, 0);
    }

    /* renamed from: g */
    public int mo19692g() {
        return this.f3641t.getInt(f3624e, 0);
    }

    /* renamed from: h */
    public long mo19693h() {
        return this.f3641t.getLong(f3635p, 0);
    }

    /* renamed from: i */
    public long mo19694i() {
        return this.f3641t.getLong(f3636q, 0);
    }

    /* renamed from: j */
    public JSONObject mo19695j() {
        return this.f3643v;
    }

    /* renamed from: a */
    public void mo19682a(long j) {
        SharedPreferences.Editor edit = this.f3641t.edit();
        edit.putLong(f3635p, j);
        edit.commit();
    }

    /* renamed from: k */
    public String mo19696k() {
        return this.f3641t.getString(f3625f, (String) null);
    }

    /* renamed from: a */
    public boolean mo19685a(String str) {
        SharedPreferences.Editor edit = this.f3641t.edit();
        edit.putString(f3621b, str);
        return edit.commit();
    }

    /* renamed from: l */
    public boolean mo19697l() {
        return this.f3641t.contains(f3622c);
    }

    /* renamed from: a */
    public boolean mo19684a(Bundle bundle) {
        try {
            SharedPreferences.Editor edit = this.f3641t.edit();
            String p = mo19701p();
            edit.clear();
            m3638a(edit, f3622c, bundle);
            if (p != null) {
                edit.putString(f3639w, p);
            }
            return edit.commit();
        } catch (Throwable th) {
            Logger.m3604e(f3631l, "Caught exception", th);
            new CrashReporter().caughtException(th);
            return false;
        }
    }

    /* renamed from: a */
    public static void m3638a(SharedPreferences.Editor editor, String str, Bundle bundle) {
        String str2 = str + f3640x;
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj == null) {
                editor.remove(str2 + str3);
            } else if (obj instanceof Integer) {
                editor.putInt(str2 + str3, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str2 + str3, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                editor.putBoolean(str2 + str3, ((Boolean) obj).booleanValue());
            } else if (obj instanceof CharSequence) {
                editor.putString(str2 + str3, ((CharSequence) obj).toString());
            } else if ((obj instanceof ArrayList) && ((ArrayList) obj).size() > 0 && (((ArrayList) obj).get(0) instanceof String)) {
                editor.putStringSet(str2 + str3, new HashSet((ArrayList) obj));
            } else if (obj instanceof Bundle) {
                m3638a(editor, str2 + str3, (Bundle) obj);
            }
        }
    }

    /* renamed from: a */
    public static Bundle m3636a(SharedPreferences sharedPreferences, String str) {
        Logger.m3601d(f3631l, "loadPreferencesBundle started, key=" + str);
        Bundle bundle = new Bundle();
        Map<String, ?> all = sharedPreferences.getAll();
        String str2 = str + f3640x;
        HashSet<String> hashSet = new HashSet<>();
        for (String next : all.keySet()) {
            if (next.startsWith(str2)) {
                String b = m3641b(next, str2);
                if (!b.contains(f3640x)) {
                    Object obj = all.get(next);
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            bundle.putInt(b, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(b, ((Long) obj).longValue());
                        } else if (obj instanceof Boolean) {
                            bundle.putBoolean(b, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof CharSequence) {
                            bundle.putString(b, ((CharSequence) obj).toString());
                        } else if (obj instanceof HashSet) {
                            bundle.putStringArrayList(b, new ArrayList((HashSet) obj));
                        }
                    }
                } else {
                    hashSet.add(m3637a(b, f3640x));
                }
            }
        }
        for (String str3 : hashSet) {
            bundle.putBundle(str3, m3636a(sharedPreferences, str2 + str3));
        }
        return bundle;
    }

    /* renamed from: a */
    public static String m3637a(String str, String str2) {
        if (m3642b(str) || str2 == null) {
            return str;
        }
        if (str2.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: b */
    public static boolean m3642b(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static String m3641b(String str, String str2) {
        if (m3642b(str) || m3642b(str2) || !str.startsWith(str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    /* renamed from: a */
    public boolean mo19683a(int i, String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f3641t.edit();
            edit.putInt(f3627h, i);
            edit.putString(f3628i, str);
            edit.putString("sdk_key", str2);
            Logger.m3601d(f3631l, "save sdk key " + str2 + ", token " + str + ", version code " + i);
            return edit.commit();
        } catch (Throwable th) {
            Logger.m3602d(f3631l, "Caught exception", th);
            new CrashReporter().caughtException(th);
            return false;
        }
    }

    /* renamed from: m */
    public String mo19698m() {
        String string = this.f3641t.getString("sdk_key", (String) null);
        Logger.m3601d(f3631l, "read sdk key " + string);
        return string;
    }

    /* renamed from: n */
    public int mo19699n() {
        int i = this.f3641t.getInt(f3627h, 0);
        Logger.m3601d(f3631l, "read version code " + i);
        return i;
    }

    /* renamed from: o */
    public String mo19700o() {
        String string = this.f3641t.getString(f3628i, (String) null);
        Logger.m3601d(f3631l, "read token " + string);
        return string;
    }

    /* renamed from: c */
    public boolean mo19688c(String str) {
        SharedPreferences.Editor edit = this.f3641t.edit();
        edit.putString(f3639w, str);
        return edit.commit();
    }

    /* renamed from: p */
    public String mo19701p() {
        return this.f3641t.getString(f3639w, (String) null);
    }
}

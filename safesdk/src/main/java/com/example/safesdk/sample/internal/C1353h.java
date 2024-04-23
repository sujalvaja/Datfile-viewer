package com.example.safesdk.sample.internal;

import android.os.Bundle;
import com.example.safesdk.sample.analytics.reporters.CrashReporter;
import com.example.safesdk.sample.utils.Logger;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.internal.h */
public class C1353h {

    /* renamed from: a */
    public static  String f3533a = "master";

    /* renamed from: b */
    public static  String f3534b = "collect_host_urls";

    /* renamed from: c */
    private static  String f3535c = "SafeDKToggles";

    /* renamed from: d */
    private static  String f3536d = "network";

    /* renamed from: e */
    private static  String f3537e = "location";

    /* renamed from: f */
    private static  String f3538f = "calllog";

    /* renamed from: g */
    private static  String f3539g = "accounts";

    /* renamed from: h */
    private static  String f3540h = "contacts";

    /* renamed from: i */
    private static  String f3541i = "calendar";

    /* renamed from: j */
    private static  String f3542j = "browser";

    /* renamed from: k */
    private static  String f3543k = "sms";

    /* renamed from: l */
    private static  String f3544l = "files";

    /* renamed from: m */
    private static  String f3545m = "camera";

    /* renamed from: n */
    private static  String f3546n = "microphone";

    /* renamed from: o */
    private static  String f3547o = "accelerometer";

    /* renamed from: p */
    private static  String f3548p = "notifications";

    /* renamed from: q */
    private static  String f3549q = "packagemanager";

    /* renamed from: r */
    private static  String f3550r = "advertising_identifier";

    /* renamed from: A */
    private boolean f3551A = true;

    /* renamed from: B */
    private boolean f3552B = true;

    /* renamed from: C */
    private boolean f3553C = true;

    /* renamed from: D */
    private boolean f3554D = true;

    /* renamed from: E */
    private boolean f3555E = true;

    /* renamed from: F */
    private boolean f3556F = true;

    /* renamed from: G */
    private boolean f3557G = true;

    /* renamed from: H */
    private boolean f3558H = true;

    /* renamed from: I */
    private boolean f3559I = false;

    /* renamed from: s */
    private boolean f3560s = true;

    /* renamed from: t */
    private boolean f3561t = true;

    /* renamed from: u */
    private boolean f3562u = true;

    /* renamed from: v */
    private boolean f3563v = true;

    /* renamed from: w */
    private boolean f3564w = true;

    /* renamed from: x */
    private boolean f3565x = true;

    /* renamed from: y */
    private boolean f3566y = true;

    /* renamed from: z */
    private boolean f3567z = true;

    public C1353h(boolean z) {
        m3573b(z);
    }

    /* renamed from: b */
    private void m3573b(boolean z) {
        this.f3558H = z;
        this.f3557G = z;
        this.f3556F = z;
        this.f3555E = z;
        this.f3554D = z;
        this.f3553C = z;
        this.f3552B = z;
        this.f3551A = z;
        this.f3567z = z;
        this.f3566y = z;
        this.f3565x = z;
        this.f3564w = z;
        this.f3563v = z;
        this.f3562u = z;
        this.f3561t = z;
        this.f3560s = z;
        this.f3559I = false;
    }

    public C1353h(String str) {
        m3572a(str);
    }

    public C1353h(JSONObject jSONObject) {
        mo19647a(jSONObject);
    }

    /* renamed from: s */
    private Bundle m3574s() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(f3533a, this.f3560s);
        bundle.putBoolean("network", this.f3561t);
        bundle.putBoolean(f3537e, this.f3562u);
        bundle.putBoolean(f3539g, this.f3564w);
        bundle.putBoolean(f3538f, this.f3563v);
        bundle.putBoolean(f3540h, this.f3565x);
        bundle.putBoolean(f3541i, this.f3566y);
        bundle.putBoolean(f3542j, this.f3567z);
        bundle.putBoolean(f3543k, this.f3551A);
        bundle.putBoolean(f3544l, this.f3552B);
        bundle.putBoolean(f3545m, this.f3553C);
        bundle.putBoolean(f3546n, this.f3554D);
        bundle.putBoolean(f3547o, this.f3555E);
        bundle.putBoolean(f3548p, this.f3556F);
        bundle.putBoolean(f3549q, this.f3557G);
        bundle.putBoolean(f3550r, this.f3558H);
        bundle.putBoolean(f3534b, this.f3559I);
        return bundle;
    }

    /* renamed from: a */
    private void m3572a(String str) {
        try {
            mo19647a(new JSONObject(str));
        } catch (JSONException e) {
            Logger.m3604e(f3535c, "Failed to convert toggles to json", e);
        }
    }

    /* renamed from: a */
    public void mo19647a(JSONObject jSONObject) {
        try {
            if (jSONObject.has(f3533a)) {
                this.f3560s = jSONObject.getBoolean(f3533a);
            }
            if (jSONObject.has("network")) {
                this.f3561t = jSONObject.getBoolean("network");
            }
            if (jSONObject.has(f3537e)) {
                this.f3562u = jSONObject.getBoolean(f3537e);
            }
            if (jSONObject.has(f3539g)) {
                this.f3564w = jSONObject.getBoolean(f3539g);
            }
            if (jSONObject.has(f3538f)) {
                this.f3563v = jSONObject.getBoolean(f3538f);
            }
            if (jSONObject.has(f3540h)) {
                this.f3565x = jSONObject.getBoolean(f3540h);
            }
            if (jSONObject.has(f3541i)) {
                this.f3566y = jSONObject.getBoolean(f3541i);
            }
            if (jSONObject.has(f3542j)) {
                this.f3567z = jSONObject.getBoolean(f3542j);
            }
            if (jSONObject.has(f3543k)) {
                this.f3551A = jSONObject.getBoolean(f3543k);
            }
            if (jSONObject.has(f3544l)) {
                this.f3552B = jSONObject.getBoolean(f3544l);
            }
            if (jSONObject.has(f3545m)) {
                this.f3553C = jSONObject.getBoolean(f3545m);
            }
            if (jSONObject.has(f3546n)) {
                this.f3554D = jSONObject.getBoolean(f3546n);
            }
            if (jSONObject.has(f3547o)) {
                this.f3555E = jSONObject.getBoolean(f3547o);
            }
            if (jSONObject.has(f3548p)) {
                this.f3556F = jSONObject.getBoolean(f3548p);
            }
            if (jSONObject.has(f3549q)) {
                this.f3557G = jSONObject.getBoolean(f3549q);
            }
            if (jSONObject.has(f3550r)) {
                this.f3558H = jSONObject.getBoolean(f3550r);
            }
            if (jSONObject.has(f3534b)) {
                this.f3559I = jSONObject.getBoolean(f3534b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            Logger.m3604e(f3535c, "Failed to parse toggles: " + (jSONObject == null ? "null" : jSONObject.toString()), th2);
            new CrashReporter().caughtException(th2);
            m3573b(true);
        }
    }

    /* renamed from: a */
    public ArrayList<String> mo19645a() {
        return mo19646a(true);
    }

    /* renamed from: a */
    public ArrayList<String> mo19646a(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Bundle s = m3574s();
            for (String str : s.keySet()) {
                if (!str.equals(f3534b) && !s.getBoolean(str)) {
                    arrayList.add(str);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3535c, "caught exception", th);
            if (z) {
                new CrashReporter().caughtException(th);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean mo19648b() {
        return this.f3560s;
    }

    /* renamed from: c */
    public boolean mo19649c() {
        return this.f3561t;
    }

    /* renamed from: d */
    public boolean mo19650d() {
        return this.f3562u;
    }

    /* renamed from: e */
    public boolean mo19651e() {
        return this.f3564w;
    }

    /* renamed from: f */
    public boolean mo19652f() {
        return this.f3563v;
    }

    /* renamed from: g */
    public boolean mo19653g() {
        return this.f3565x;
    }

    /* renamed from: h */
    public boolean mo19654h() {
        return this.f3566y;
    }

    /* renamed from: i */
    public boolean mo19655i() {
        return this.f3567z;
    }

    /* renamed from: j */
    public boolean mo19656j() {
        return this.f3551A;
    }

    /* renamed from: k */
    public boolean mo19657k() {
        return this.f3552B;
    }

    /* renamed from: l */
    public boolean mo19658l() {
        return this.f3553C;
    }

    /* renamed from: m */
    public boolean mo19659m() {
        return this.f3554D;
    }

    /* renamed from: n */
    public boolean mo19660n() {
        return this.f3555E;
    }

    /* renamed from: o */
    public boolean mo19661o() {
        return this.f3556F;
    }

    /* renamed from: p */
    public boolean mo19662p() {
        return this.f3557G;
    }

    /* renamed from: q */
    public boolean mo19663q() {
        return this.f3558H;
    }

    /* renamed from: r */
    public boolean mo19664r() {
        return this.f3559I;
    }

    public String toString() {
        return "SafeDKToggles: master=" + this.f3560s + "; network=" + this.f3561t + "; location=" + this.f3562u + "; ; accounts=" + this.f3564w + "; call_log=" + this.f3563v + "; contacts=" + this.f3565x + "; calendar=" + this.f3566y + "; browser=" + this.f3567z + "; sms_mms=" + this.f3551A + "; files=" + this.f3552B + "; camera=" + this.f3553C + "; microphone=" + this.f3554D + "; accelerometer=" + this.f3555E + "; notifications=" + this.f3556F + "; packageManager=" + this.f3557G + "; advertisingId=" + this.f3558H;
    }
}

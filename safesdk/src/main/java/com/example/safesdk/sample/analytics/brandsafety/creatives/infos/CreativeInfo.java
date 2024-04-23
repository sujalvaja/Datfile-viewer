package com.example.safesdk.sample.analytics.brandsafety.creatives.infos;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.internal.C1349d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.itextpdf.text.xml.xmp.XmpWriter;

import java.io.Serializable;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CreativeInfo implements Serializable {

    /* renamed from: A */
    public static  String f2961A = "details?id=";

    /* renamed from: B */
    public static  String f2962B = "isVideoAd";

    /* renamed from: C */
    public static  String f2963C = "isPlayable";

    /* renamed from: D */
    public static  String f2964D = "campaign_id";

    /* renamed from: L */
    public static  String f2965L = "dsp_creative_id";

    /* renamed from: a */
    private static  String f2966a = "CreativeInfo";

    /* renamed from: ak */
    public static  String f2967ak = "buyer_id";

    /* renamed from: al */
    public static  String f2968al = "ad_system";

    /* renamed from: am */
    public static  String f2969am = "vast_ad_tag_uris";

    /* renamed from: an */
    public static  String f2970an = "webviewAddress";

    /* renamed from: ao */
    public static  String f2971ao = "text:";

    /* renamed from: b */
    public static  String f2972b = "prefetchTimestamp";

    /* renamed from: c */
    public static  String f2973c = "requestId";

    /* renamed from: d */
    public static  String f2974d = "creative_id";

    /* renamed from: e */
    public static  String f2975e = "video_url";

    /* renamed from: f */
    public static  String f2976f = "ci_matching_method";

    /* renamed from: g */
    public static  String f2977g = "ci_debug_info";

    /* renamed from: h */
    public static  String f2978h = "exact_";

    /* renamed from: i */
    public static  String f2979i = "exact_fbLabel";

    /* renamed from: j */
    public static  String f2980j = "exact_markup";

    /* renamed from: k */
    public static  String f2981k = "exact_video";

    /* renamed from: l */
    public static  String f2982l = "exact_resource";

    /* renamed from: m */
    public static  String f2983m = "exact_ad_id";

    /* renamed from: n */
    public static  String f2984n = "exact_ad_object";

    /* renamed from: o */
    public static  String f2985o = "heuristic_mediation";

    /* renamed from: p */
    public static  String f2986p = "heuristic_pending";

    /* renamed from: q */
    public static  String f2987q = "downstream_struct";

    /* renamed from: r */
    public static  String f2988r = "vast";

    /* renamed from: s */
    public static  String f2989s = "survey";
    private static  long serialVersionUID = 4107472620437040927L;

    /* renamed from: t */
    public static  String f2990t = "text";

    /* renamed from: u */
    public static  String f2991u = "playable";

    /* renamed from: v */
    public static  String f2992v = "image";

    /* renamed from: w */
    public static  String f2993w = "mraid";

    /* renamed from: x */
    public static  String f2994x = "max_creative_id";

    /* renamed from: y */
    public static  String f2995y = "webview_resource_urls";

    /* renamed from: z */
    public static  String f2996z = "prefetch_resource_urls";

    /* renamed from: E */
    protected BrandSafetyUtils.AdType f2997E;

    /* renamed from: F */
    protected String f2998F;

    /* renamed from: G */
    protected boolean f2999G = false;

    /* renamed from: H */
    protected boolean f3000H = false;

    /* renamed from: I */
    protected boolean f3001I;

    /* renamed from: J */
    protected String f3002J;

    /* renamed from: K */
    protected String f3003K;

    /* renamed from: M */
    protected String f3004M;

    /* renamed from: N */
    protected HashSet<String> f3005N = new HashSet<>();

    /* renamed from: O */
    protected HashSet<String> f3006O = new HashSet<>();

    /* renamed from: P */
    protected HashSet<String> f3007P = new HashSet<>();

    /* renamed from: Q */
    protected String f3008Q;

    /* renamed from: R */
    Timestamp f3009R = new Timestamp(System.currentTimeMillis() + new C1349d().mo19590I());

    /* renamed from: S */
    protected String f3010S = null;

    /* renamed from: T */
    boolean f3011T = false;

    /* renamed from: U */
    boolean f3012U = false;

    /* renamed from: V */
    boolean f3013V = false;

    /* renamed from: W */
    boolean f3014W = false;

    /* renamed from: X */
    protected String f3015X;

    /* renamed from: Y */
    private String f3016Y;

    /* renamed from: Z */
    private boolean f3017Z = false;

    /* renamed from: aa */
    private String f3018aa;

    /* renamed from: ab */
    private long f3019ab = 0;

    /* renamed from: ac */
    private String f3020ac;

    /* renamed from: ad */
    private String f3021ad;

    /* renamed from: ae */
    private int f3022ae;

    /* renamed from: af */
    private String f3023af;

    /* renamed from: ag */
    private boolean f3024ag = false;

    /* renamed from: ah */
    private String f3025ah;

    /* renamed from: ai */
    private String f3026ai;

    /* renamed from: aj */
    private List<String> f3027aj;

    /* renamed from: ap */
    protected String f3028ap;

    /* renamed from: aq */
    protected String f3029aq;

    /* renamed from: ar */
    protected String f3030ar;

    /* renamed from: as */
    protected HashSet<String> f3031as = new HashSet<>();

    /* renamed from: at */
    boolean f3032at = false;

    /* renamed from: au */
    private String f3033au;

    /* renamed from: av */
    private String f3034av;

    /* renamed from: c */
    public boolean mo19402c() {
        return this.f3017Z;
    }

    /* renamed from: d */
    public String mo19404d() {
        return this.f2998F;
    }

    /* renamed from: e */
    public String mo19407e() {
        return this.f3023af;
    }

    /* renamed from: f */
    public String mo19410f() {
        return this.f3034av;
    }

    /* renamed from: d */
    public void mo19405d(String str) {
        this.f3034av = str;
        if (str != null) {
            mo19428o("eid:" + str);
        }
    }

    /* renamed from: g */
    public HashSet<String> mo19412g() {
        return this.f3005N;
    }

    /* renamed from: h */
    public HashSet<String> mo19414h() {
        return this.f3006O;
    }

    /* renamed from: i */
    public HashSet<String> mo19416i() {
        return this.f3007P;
    }

    /* renamed from: a */
    public void mo19395a(boolean z) {
        this.f3013V = z;
    }

    /* renamed from: b */
    public void mo19398b(boolean z) {
        this.f3032at = z;
    }

    /* renamed from: j */
    public boolean mo19418j() {
        return this.f3011T || this.f3013V;
    }

    /* renamed from: k */
    public boolean mo19420k() {
        return this.f3014W;
    }

    /* renamed from: c */
    public void mo19401c(boolean z) {
        Logger.m3601d(f2966a, "VideoAd property has been set to " + z);
        this.f3011T = z;
    }

    /* renamed from: l */
    public boolean mo19422l() {
        return this.f3012U;
    }

    /* renamed from: d */
    public void mo19406d(boolean z) {
        this.f3012U = z;
    }

    /* renamed from: m */
    public boolean mo19424m() {
        return this.f3013V;
    }

    /* renamed from: n */
    public boolean mo19426n() {
        return this.f3032at;
    }

    public CreativeInfo() {
    }

    public CreativeInfo(BrandSafetyUtils.AdType adType, String sdk, String id, String creativeId, String clickUrl, String videoUrl, String downstreamStruct) {
        boolean z = true;
        this.f2997E = adType;
        this.f3018aa = sdk;
        this.f3016Y = id;
        mo19428o("id:" + id);
        mo19408e(creativeId);
        mo19425n(clickUrl);
        mo19417j(videoUrl);
        this.f3024ag = true;
        this.f3019ab = C1361h.m3690b(System.currentTimeMillis());
        this.f2998F = downstreamStruct;
        this.f3011T = TextUtils.isEmpty(videoUrl) ? false : z;
    }

    /* renamed from: e */
    public void mo19408e(String str) {
        this.f3020ac = str;
    }

    /* renamed from: f */
    public void mo19411f(String str) {
        this.f3033au = str;
    }

    /* renamed from: g */
    public void mo19413g(String str) {
        this.f3028ap = str;
    }

    /* renamed from: h */
    public void mo19415h(String str) {
        this.f3029aq = str;
    }

    /* renamed from: i */
    public static CreativeInfo m3249i(String str) {
        CreativeInfo creativeInfo = new CreativeInfo();
        creativeInfo.f3016Y = str;
        return creativeInfo;
    }

    /* renamed from: o */
    public CreativeInfo mo19427o() {
        return this;
    }

    /* renamed from: p */
    public String mo19429p() {
        return this.f3003K;
    }

    /* renamed from: q */
    public String mo19431q() {
        StringBuilder sb = new StringBuilder();
        if (this.f2999G) {
            sb.append(this.f3016Y);
        }
        sb.append(this.f3020ac);
        sb.append(this.f3002J);
        return sb.toString();
    }

    /* renamed from: r */
    public String mo19433r() {
        return this.f3002J;
    }

    /* renamed from: j */
    public void mo19417j(String str) {
        this.f3002J = mo19440u(str);
        mo19434r(this.f3002J);
    }

    /* renamed from: s */
    public String mo19435s() {
        return this.f3030ar;
    }

    /* renamed from: k */
    public void mo19419k(String str) {
        this.f3030ar = str;
    }

    /* renamed from: t */
    public String mo19437t() {
        return this.f3004M;
    }

    /* renamed from: l */
    public void mo19421l(String str) {
        this.f3004M = str;
    }

    /* renamed from: b */
    public synchronized Bundle mo19379b() {
        Bundle bundle;
        Logger.m3601d(f2966a, "generateExtraFields started");
        bundle = new Bundle();
        if (this.f2999G) {
            bundle.putString(f2973c, this.f3016Y);
        }
        if (this.f3000H) {
            bundle.putLong(f2972b, this.f3019ab);
        }
        if (!TextUtils.isEmpty(this.f3020ac)) {
            bundle.putString("creative_id", this.f3020ac);
        }
        if (!TextUtils.isEmpty(this.f3033au)) {
            bundle.putString(f2965L, this.f3033au);
        }
        if (!TextUtils.isEmpty(this.f3028ap)) {
            bundle.putString("buyer_id", this.f3028ap);
        }
        if (!TextUtils.isEmpty(this.f3029aq)) {
            bundle.putString(f2968al, this.f3029aq);
        }
        if (!TextUtils.isEmpty(this.f3002J)) {
            bundle.putString(f2975e, this.f3002J);
        }
        if (!TextUtils.isEmpty(this.f3025ah)) {
            bundle.putString(f2976f, this.f3025ah);
        }
        if (!TextUtils.isEmpty(this.f3026ai)) {
            bundle.putString(f2977g, this.f3026ai);
        }
        if (!TextUtils.isEmpty(this.f2998F)) {
            bundle.putString(f2987q, this.f2998F);
        }
        if (!TextUtils.isEmpty(this.f3003K)) {
            bundle.putString(BrandSafetyEvent.f3209f, this.f3003K);
        }
        bundle.putString("ad_format_type", this.f3030ar);
        if (!TextUtils.isEmpty(this.f3004M)) {
            bundle.putString(BrandSafetyEvent.f3210g, this.f3004M);
        }
        if (this.f3005N != null && !this.f3005N.isEmpty()) {
            bundle.putStringArrayList(BrandSafetyEvent.f3211h, new ArrayList(this.f3005N));
        }
        bundle.putString("sdk_version", this.f3008Q);
        if (this.f3006O != null && !this.f3006O.isEmpty()) {
            bundle.putStringArrayList(f2995y, new ArrayList(this.f3006O));
        }
        if (this.f3007P != null && !this.f3007P.isEmpty()) {
            bundle.putStringArrayList(f2996z, new ArrayList(this.f3007P));
        }
        if (!this.f3031as.isEmpty()) {
            bundle.putStringArrayList(f2969am, new ArrayList(this.f3031as));
        }
        bundle.putString(f2994x, this.f3010S);
        return bundle;
    }

    /* renamed from: a */
    public boolean mo19378a() {
        return this.f3020ac == null;
    }

    /* renamed from: u */
    public boolean mo19441u() {
        return !this.f3024ag;
    }

    /* renamed from: v */
    public Object mo19442v() {
        return this.f2997E;
    }

    /* renamed from: w */
    public String mo19444w() {
        return this.f3016Y;
    }

    /* renamed from: x */
    public String mo19446x() {
        return this.f3021ad;
    }

    /* renamed from: y */
    public String mo19447y() {
        return this.f3020ac;
    }

    /* renamed from: z */
    public String mo19448z() {
        return this.f3033au;
    }

    /* renamed from: A */
    public String mo19382A() {
        return this.f3028ap;
    }

    /* renamed from: B */
    public String mo19383B() {
        return this.f3018aa;
    }

    /* renamed from: C */
    public int mo19384C() {
        return this.f3022ae;
    }

    /* renamed from: a */
    public void mo19391a(int i) {
        this.f3022ae = i;
    }

    /* renamed from: m */
    public void mo19423m(String str) {
        this.f3023af = str;
    }

    /* renamed from: n */
    public void mo19425n(String str) {
        this.f3021ad = str;
        if (TextUtils.isEmpty(this.f3004M)) {
            this.f3004M = mo19380b(mo19440u(str));
        }
    }

    /* renamed from: e */
    public void mo19409e(boolean z) {
        this.f3001I = z;
    }

    /* renamed from: a */
    public void mo19392a(String str, String str2) {
        this.f3025ah = str;
        mo19428o("mi:" + str2);
    }

    /* renamed from: o */
    public void mo19428o(String str) {
        if (str == null) {
            return;
        }
        if (this.f3026ai == null) {
            this.f3026ai = str;
        } else {
            this.f3026ai += "||" + str;
        }
    }

    /* renamed from: D */
    public String mo19385D() {
        return this.f3025ah;
    }

    /* renamed from: E */
    public String mo19386E() {
        return this.f3026ai;
    }

    /* renamed from: a */
    public synchronized boolean mo19396a(Map<Integer, CreativeInfo> map) {
        boolean z;
        if (this.f3022ae == 0) {
            z = false;
        } else {
            map.put(Integer.valueOf(this.f3022ae), this);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public synchronized boolean mo19399b(Map<Integer, CreativeInfo> map) {
        boolean z = false;
        synchronized (this) {
            if (this.f3022ae != 0) {
                if (map.remove(Integer.valueOf(this.f3022ae)) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    public synchronized boolean mo19403c(Map<String, CreativeInfo> map) {
        boolean z = false;
        synchronized (this) {
            if (this.f3023af != null) {
                if (map.remove(this.f3023af) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo19394a(List<String> list) {
        this.f3027aj = list;
    }

    /* renamed from: F */
    public List<String> mo19387F() {
        return this.f3027aj;
    }

    /* renamed from: b */
    public synchronized void mo19397b(List<String> list) {
        if (list != null) {
            C1361h.m3694b(f2966a, "Classifying prefetch urls : " + list.toString());
            for (String next : list) {
                Logger.m3601d(f2966a, "Classifying prefetch url " + next);
                String u = mo19440u(next);
                if (!TextUtils.isEmpty(u)) {
                    if (mo19381c(next) || mo19381c(u)) {
                        Logger.m3601d(f2966a, "url is a prefetch url " + next);
                        mo19434r(u);
                    } else if (mo19430p(u) && !u.equals(this.f3021ad)) {
                        Logger.m3601d(f2966a, "url is a dsp url " + next);
                        mo19432q(u);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized void mo19400c(List<String> list) {
        if (list != null) {
            C1361h.m3694b(f2966a, "add prefetch urls : " + list.toString());
            for (String r : list) {
                mo19434r(r);
            }
        }
    }

    
    /* renamed from: p */
    public boolean mo19430p(String str) {
        return C1308d.m3131a(this.f3018aa, str);
    }

    
    /* renamed from: c */
    public boolean mo19381c(String str) {
        return C1361h.m3687a(str, (Map<String, String>) null);
    }

    /* renamed from: q */
    public synchronized void mo19432q(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u) && !this.f3031as.contains(u)) {
            this.f3005N.add(u);
        }
    }

    /* renamed from: a */
    public synchronized void mo19376a(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u)) {
            this.f3006O.add(u);
        }
    }

    /* renamed from: a */
    public synchronized void mo19393a(ArrayList<String> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    mo19376a(it.next());
                }
            }
        }
    }

    
    /* renamed from: r */
    public synchronized void mo19434r(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u)) {
            this.f3007P.add(u);
        }
    }

    /* renamed from: s */
    public synchronized void mo19436s(String str) {
        if (str != null) {
            this.f3007P.add(f2971ao + str);
        }
    }

    /* renamed from: t */
    public synchronized void mo19438t(String str) {
        String u = mo19440u(str);
        if (!TextUtils.isEmpty(u)) {
            this.f3031as.add(u);
        }
        this.f3005N.remove(u);
    }

    public String toString() {
        Bundle b = mo19379b();
        b.putString(f2973c, this.f3016Y);
        b.putBoolean(f2962B, this.f3011T | this.f3013V);
        b.putBoolean(f2963C, this.f3014W);
        if (this.f3023af != null) {
            b.putString(f2970an, this.f3023af);
        }
        return b.toString();
    }

    /* renamed from: b */
    private String mo19380b(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(f2961A)) == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf + f2961A.length(), indexOf2);
    }

    /* renamed from: G */
    public Timestamp mo19388G() {
        return this.f3009R;
    }

    
    /* renamed from: u */
    public String mo19440u(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = URLDecoder.decode(str, XmpWriter.UTF8);
        } catch (Throwable th) {
            Logger.m3601d(f2966a, "Failure in decodeUrl. This url will be sent as is in the next event. " + th.getMessage() + ". Url=" + str);
        }
        return C1361h.m3710h(str);
    }

    /* renamed from: H */
    public void mo19389H() {
        this.f3017Z = true;
    }

    /* renamed from: v */
    public void mo19443v(String str) {
        this.f3015X = str;
    }

    /* renamed from: I */
    public String mo19390I() {
        return this.f3010S;
    }

    /* renamed from: w */
    public void mo19445w(String str) {
        this.f3010S = str;
    }
}

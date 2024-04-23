package com.example.safesdk.sample.internal;

import android.os.Bundle;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.AppLovinBridge;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.internal.d */
public class C1349d {

    /* renamed from: A */
    public static  String f3406A = "videoMimeTypesList";

    /* renamed from: B */
    public static  String f3407B = "audioMimeTypesList";

    /* renamed from: C */
    public static  String f3408C = "maxBannerUniformPixelsPercentageToStopSampling";

    /* renamed from: D */
    public static  String f3409D = "minBannerUniformPixelsPercentageForUniformImage";

    /* renamed from: E */
    public static  String f3410E = "maxAttemptsToCaptureBannerImage";

    /* renamed from: F */
    public static  String f3411F = "bannerImageSamplingInterval";

    /* renamed from: G */
    public static  String f3412G = "isBannersEnabled";

    /* renamed from: H */
    public static  String f3413H = "https://edge.safedk.com";

    /* renamed from: I */
    public static  String f3414I = "https://edge.safedk.com";

    /* renamed from: J */
    public static  String f3415J = "apng;bmp;gif;x-icon;x-icon;png;svg+xml;tiff";

    /* renamed from: K */
    public static  String f3416K = "wave;wav;x-wav;x-pn-wav;webm;ogg;";

    /* renamed from: L */
    private static  String f3417L = "SafeDKConfiguration";

    /* renamed from: M */
    private static  String f3418M = "settings";

    /* renamed from: N */
    private static  String f3419N = "android";

    /* renamed from: O */
    private static  String f3420O = "images";

    /* renamed from: P */
    private static  String f3421P = "banners";

    /* renamed from: Q */
    private static  String f3422Q = "adCaching";

    /* renamed from: R */
    private static  String f3423R = "general";

    /* renamed from: S */
    private static  String f3424S = "timers";

    /* renamed from: T */
    private static  String f3425T = "redirectClickTimeout";

    /* renamed from: U */
    private static  int f3426U = 30000;

    /* renamed from: a */
    public static  int f3427a = 300;

    /* renamed from: aA */
    private static  int f3428aA = 15000;

    /* renamed from: aC */
    private static  int f3429aC = 15000;

    /* renamed from: aZ */
    private static  int f3430aZ = 480;

    /* renamed from: ak */
    private static  int f3431ak = 8192;

    /* renamed from: am */
    private static  int f3432am = 540;

    /* renamed from: ao */
    private static  float f3433ao = 40.0f;

    /* renamed from: aq */
    private static  float f3434aq = 90.0f;

    /* renamed from: as */
    private static  int f3435as = 5;

    /* renamed from: au */
    private static  int f3436au = 25000;

    /* renamed from: aw */
    private static  boolean f3437aw = false;

    /* renamed from: ay */
    private static  int f3438ay = 10000;

    /* renamed from: b */
    public static  int f3439b = 5000;

    /* renamed from: c */
    public static  int f3440c = 500;

    /* renamed from: d */
    public static  String f3441d = "minValidImageSize";

    /* renamed from: e */
    public static  String f3442e = "interstitialDimensionsMaxSize";

    /* renamed from: f */
    public static  String f3443f = "maxUniformPixelsPercentageToStopSampling";

    /* renamed from: g */
    public static  String f3444g = "maxImagesToStoreOnDevice";

    /* renamed from: h */
    public static  String f3445h = "minImageSizeToStopSampling";

    /* renamed from: i */
    public static  String f3446i = "minUniformPixelsPercentageForUniformImage";

    /* renamed from: j */
    public static  String f3447j = "awsUploadTimeout";

    /* renamed from: k */
    public static  String f3448k = "resolveUrlTimeout";

    /* renamed from: l */
    public static  String f3449l = "clickValidityTimeout";

    /* renamed from: m */
    public static  String f3450m = "interstitialActivitiesToInclude";

    /* renamed from: n */
    public static  String f3451n = "interstitialActivitiesToExclude";

    /* renamed from: o */
    public static  String f3452o = "edgeServerUrl";

    /* renamed from: p */
    public static  String f3453p = "backupEdgeServerUrl";

    /* renamed from: q */
    public static  String f3454q = "devicesWithDebugLog";

    /* renamed from: r */
    public static  String f3455r = "cachedCreativeInfoMaxAge";

    /* renamed from: s */
    public static  String f3456s = "cachedMaxNumberOfItems";

    /* renamed from: t */
    public static  String f3457t = "cacheSupportingSdkUUIDs";

    /* renamed from: u */
    public static  String f3458u = "safeDKDeactivation";

    /* renamed from: v */
    public static  String f3459v = "activePercentage";

    /* renamed from: w */
    public static  String f3460w = "deactivated";

    /* renamed from: x */
    public static  String f3461x = "alwaysTakeScreenshot";

    /* renamed from: y */
    public static  String f3462y = "disableWebViewTracking";

    /* renamed from: z */
    public static  String f3463z = "imageMimeTypesList";

    /* renamed from: V */
    private boolean f3464V = false;

    /* renamed from: W */
    private int f3465W = 300;

    /* renamed from: X */
    private boolean f3466X = false;

    /* renamed from: Y */
    private int f3467Y = f3439b;

    /* renamed from: Z */
    private int f3468Z = f3440c;

    /* renamed from: aB */
    private int f3469aB = 15000;

    /* renamed from: aD */
    private int f3470aD = 15000;

    /* renamed from: aE */
    private ArrayList<String> f3471aE = new ArrayList<>();

    /* renamed from: aF */
    private ArrayList<String> f3472aF = new ArrayList<>();

    /* renamed from: aG */
    private String f3473aG = "https://edge.safedk.com";

    /* renamed from: aH */
    private String f3474aH = "https://edge.safedk.com";

    /* renamed from: aI */
    private ArrayList<String> f3475aI = new ArrayList<>();

    /* renamed from: aJ */
    private ArrayList<String> f3476aJ = new ArrayList<>();

    /* renamed from: aK */
    private  long f3477aK = 604800000;

    /* renamed from: aL */
    private long f3478aL = 604800000;

    /* renamed from: aM */
    private  int f3479aM = 50;

    /* renamed from: aN */
    private int f3480aN = 50;

    /* renamed from: aO */
    private  int f3481aO = 100;

    /* renamed from: aP */
    private int f3482aP = 100;

    /* renamed from: aQ */
    private  boolean f3483aQ = false;

    /* renamed from: aR */
    private float f3484aR = f3433ao;

    /* renamed from: aS */
    private float f3485aS = this.f3484aR;

    /* renamed from: aT */
    private float f3486aT = f3434aq;

    /* renamed from: aU */
    private float f3487aU = this.f3486aT;

    /* renamed from: aV */
    private int f3488aV = 5;

    /* renamed from: aW */
    private int f3489aW = this.f3488aV;

    /* renamed from: aX */
    private int f3490aX = 1;

    /* renamed from: aY */
    private int f3491aY = this.f3490aX;

    /* renamed from: aa */
    private int f3492aa = 30000;

    /* renamed from: ab */
    private boolean f3493ab = false;

    /* renamed from: ac */
    private int f3494ac = 2;

    /* renamed from: ad */
    private boolean f3495ad = true;

    /* renamed from: ae */
    private boolean f3496ae = false;

    /* renamed from: af */
    private boolean f3497af = false;

    /* renamed from: ag */
    private JSONObject f3498ag = new JSONObject();

    /* renamed from: ah */
    private JSONObject f3499ah = new JSONObject();

    /* renamed from: ai */
    private ArrayList<String> f3500ai = new ArrayList<>(Arrays.asList(new String[]{C1357d.f3596d, C1357d.f3612t, C1357d.f3594b}));

    /* renamed from: aj */
    private boolean f3501aj = false;

    /* renamed from: al */
    private int f3502al = 8192;

    /* renamed from: an */
    private int f3503an = f3432am;

    /* renamed from: ap */
    private float f3504ap = f3433ao;

    /* renamed from: ar */
    private float f3505ar = f3434aq;

    /* renamed from: at */
    private int f3506at = 5;

    /* renamed from: av */
    private long f3507av = 25000;

    /* renamed from: ax */
    private boolean f3508ax = false;

    /* renamed from: az */
    private int f3509az = f3438ay;

    /* renamed from: ba */
    private int f3510ba = f3430aZ;

    /* renamed from: bb */
    private boolean f3511bb = true;

    /* renamed from: bc */
    private boolean f3512bc = this.f3511bb;

    /* renamed from: bd */
    private List<String> f3513bd = Arrays.asList(f3415J.split(";"));

    /* renamed from: be */
    private List<String> f3514be = Arrays.asList(f3416K.split(";"));

    /* renamed from: bf */
    private boolean f3515bf = false;

    /* renamed from: a */
    public int mo19593a() {
        return this.f3492aa;
    }

    /* renamed from: b */
    public boolean mo19599b() {
        return this.f3501aj;
    }

    /* renamed from: c */
    public int mo19600c() {
        return this.f3502al;
    }

    /* renamed from: d */
    public int mo19601d() {
        return this.f3503an;
    }

    /* renamed from: e */
    public float mo19602e() {
        return this.f3504ap;
    }

    /* renamed from: f */
    public float mo19603f() {
        return this.f3505ar;
    }

    /* renamed from: g */
    public boolean mo19604g() {
        return this.f3508ax;
    }

    /* renamed from: h */
    public int mo19605h() {
        return this.f3506at;
    }

    /* renamed from: i */
    public long mo19606i() {
        return this.f3507av;
    }

    /* renamed from: j */
    public int mo19607j() {
        return this.f3509az;
    }

    /* renamed from: k */
    public int mo19608k() {
        return this.f3469aB;
    }

    /* renamed from: l */
    public int mo19609l() {
        return this.f3470aD;
    }

    /* renamed from: m */
    public float mo19610m() {
        return this.f3485aS;
    }

    /* renamed from: n */
    public float mo19611n() {
        return this.f3487aU;
    }

    /* renamed from: o */
    public int mo19612o() {
        return this.f3489aW;
    }

    /* renamed from: p */
    public int mo19613p() {
        return this.f3491aY;
    }

    /* renamed from: q */
    public int mo19614q() {
        return this.f3510ba;
    }

    /* renamed from: r */
    public boolean mo19615r() {
        return this.f3512bc;
    }

    /* renamed from: s */
    public List<String> mo19616s() {
        return this.f3513bd;
    }

    /* renamed from: t */
    public List<String> mo19617t() {
        return this.f3514be;
    }

    /* renamed from: a */
    public void mo19595a(boolean z) {
        this.f3515bf = z;
    }

    /* renamed from: u */
    public boolean mo19618u() {
        return this.f3497af;
    }

    /* renamed from: v */
    public boolean mo19619v() {
        return !this.f3515bf;
    }

    /* renamed from: b */
    public void mo19598b(boolean z) {
        this.f3464V = z;
    }

    /* renamed from: w */
    public boolean mo19620w() {
        return this.f3464V;
    }

    /* renamed from: x */
    public int mo19621x() {
        return this.f3465W;
    }

    /* renamed from: a */
    public void mo19594a(int i) {
        this.f3467Y = i;
    }

    /* renamed from: b */
    public void mo19597b(int i) {
        this.f3468Z = i;
    }

    /* renamed from: y */
    public boolean mo19622y() {
        return this.f3493ab;
    }

    /* renamed from: z */
    public int mo19623z() {
        return this.f3494ac;
    }

    /* renamed from: A */
    public boolean mo19582A() {
        return this.f3466X;
    }

    /* renamed from: B */
    public int mo19583B() {
        return this.f3467Y;
    }

    /* renamed from: C */
    public int mo19584C() {
        return this.f3468Z;
    }

    /* renamed from: D */
    public JSONObject mo19585D() {
        return this.f3498ag;
    }

    /* renamed from: E */
    public JSONObject mo19586E() {
        return this.f3499ah;
    }

    /* renamed from: F */
    public Set<String> mo19587F() {
        return new HashSet(this.f3475aI);
    }

    /* renamed from: G */
    public boolean mo19588G() {
        return this.f3496ae;
    }

    /* renamed from: H */
    public int mo19589H() {
        return this.f3482aP;
    }

    /* renamed from: a */
    public boolean mo19596a(Bundle bundle, boolean z) {
        boolean z2;
        Logger.m3601d(f3417L, "parseSettings started , bundle : " + (bundle == null ? "null" : bundle.toString()));
        Bundle bundle2 = bundle.getBundle(f3418M);
        if (bundle2 != null) {
            Logger.m3601d(f3417L, "parseSettings starting DEACTIVATION");
            if (bundle2.containsKey(f3458u)) {
                Bundle bundle3 = bundle2.getBundle(f3458u);
                if (bundle3.containsKey(f3460w)) {
                    this.f3515bf = bundle3.getBoolean(f3460w, false);
                    Logger.m3601d(f3417L, "parseSettings deactivated " + this.f3515bf);
                } else {
                    this.f3515bf = false;
                }
                if (bundle3.containsKey(f3459v)) {
                    this.f3482aP = (int) bundle3.getDouble(f3459v, 100.0d);
                    Logger.m3601d(f3417L, "parseSettings activePercentage " + this.f3482aP);
                } else {
                    this.f3482aP = 100;
                }
                if (!this.f3515bf && this.f3482aP != 100) {
                    Logger.m3601d(f3417L, "Checking active percentage");
                    if (!m3517a(Double.valueOf((double) this.f3482aP), SafeDK.getInstance().getUserId())) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f3515bf = z2;
                    Logger.m3601d(f3417L, "After active percentage deactivated=" + this.f3515bf);
                }
            } else {
                this.f3515bf = false;
                this.f3482aP = 100;
                Logger.m3601d(f3417L, "parseSettings SAFE_DK_DEACTIVATION settings block does not exist. Default configuration values will be used.");
            }
            Logger.m3601d(f3417L, "parseSettings starting IMAGES");
            if (bundle2 == null || !bundle2.containsKey(f3420O)) {
                this.f3502al = 8192;
                this.f3503an = f3432am;
                this.f3504ap = f3433ao;
                this.f3506at = 5;
                this.f3507av = 25000;
                this.f3505ar = f3434aq;
                this.f3508ax = false;
                Logger.m3601d(f3417L, "parseSettings IMAGES settings block does not exist. Default configuration values will be used.");
            } else {
                Bundle bundle4 = bundle2.getBundle(f3420O);
                if (bundle4.containsKey(f3441d)) {
                    this.f3502al = bundle4.getInt(f3441d, 8192);
                    Logger.m3601d(f3417L, "parseSettings minValidImageSize " + this.f3502al);
                } else {
                    this.f3502al = 8192;
                }
                if (bundle4.containsKey(f3442e)) {
                    this.f3503an = bundle4.getInt(f3442e, f3432am);
                    Logger.m3601d(f3417L, "parseSettings interstitialDimensionsMaxSize " + this.f3503an);
                } else {
                    this.f3503an = f3432am;
                }
                if (bundle4.containsKey(f3443f)) {
                    this.f3504ap = (float) bundle4.getDouble(f3443f, 40.0d);
                    Logger.m3601d(f3417L, "parseSettings maxUniformPixelsPercentageToStopSampling " + this.f3504ap);
                } else {
                    this.f3504ap = f3433ao;
                }
                if (bundle4.containsKey(f3444g)) {
                    this.f3506at = bundle4.getInt(f3444g, 5);
                    Logger.m3601d(f3417L, "parseSettings maxImagesToStoreOnDevice " + this.f3506at);
                } else {
                    this.f3506at = 5;
                }
                if (bundle4.containsKey(f3445h)) {
                    this.f3507av = (long) bundle4.getInt(f3445h, f3436au);
                    Logger.m3601d(f3417L, "parseSettings minImageSizeToStopSampling " + this.f3507av);
                } else {
                    this.f3507av = 25000;
                }
                if (bundle4.containsKey(f3446i)) {
                    this.f3505ar = (float) bundle4.getDouble(f3446i, 90.0d);
                    Logger.m3601d(f3417L, "parseSettings minUniformPixelsPercentageForUniformImage " + this.f3505ar);
                } else {
                    this.f3505ar = f3434aq;
                }
                if (bundle4.containsKey(f3461x)) {
                    this.f3508ax = bundle4.getBoolean(f3461x, false);
                    Logger.m3601d(f3417L, "parseSettings alwaysTakeScreenshot " + this.f3508ax);
                } else {
                    this.f3508ax = false;
                }
            }
            Logger.m3601d(f3417L, "parseSettings starting BANNERS");
            if (bundle2 == null || !bundle2.containsKey(f3421P)) {
                this.f3485aS = this.f3484aR;
                this.f3487aU = this.f3486aT;
                this.f3489aW = this.f3488aV;
                this.f3491aY = this.f3490aX;
                this.f3512bc = this.f3511bb;
                Logger.m3601d(f3417L, "parseSettings BANNERS settings block does not exist. Default configuration values will be used.");
            } else {
                Bundle bundle5 = bundle2.getBundle(f3421P);
                if (bundle5.containsKey(f3408C)) {
                    this.f3485aS = (float) bundle5.getDouble(f3408C, (double) this.f3484aR);
                    Logger.m3601d(f3417L, "parseSettings maxBannerUniformPixelsPercentageToStopSampling " + this.f3485aS);
                } else {
                    this.f3485aS = this.f3484aR;
                }
                if (bundle5.containsKey(f3409D)) {
                    this.f3487aU = (float) bundle5.getDouble(f3409D, (double) this.f3486aT);
                    Logger.m3601d(f3417L, "parseSettings minBannerUniformPixelsPercentageForUniformImage " + this.f3487aU);
                } else {
                    this.f3487aU = this.f3486aT;
                }
                if (bundle5.containsKey(f3410E)) {
                    this.f3489aW = bundle5.getInt(f3410E, this.f3488aV);
                    Logger.m3601d(f3417L, "parseSettings maxAttemptsToCaptureBannerImage " + this.f3489aW);
                } else {
                    this.f3489aW = this.f3488aV;
                }
                if (bundle5.containsKey(f3411F)) {
                    this.f3491aY = bundle5.getInt(f3411F, this.f3490aX);
                    Logger.m3601d(f3417L, "parseSettings bannerImageSamplingInterval " + this.f3491aY);
                } else {
                    this.f3491aY = this.f3490aX;
                }
                if (bundle5.containsKey(f3412G)) {
                    this.f3512bc = bundle5.getBoolean(f3412G, this.f3511bb);
                    Logger.m3601d(f3417L, "parseSettings bannerIsEnabled " + this.f3512bc);
                } else {
                    this.f3512bc = this.f3511bb;
                }
            }
            Logger.m3601d(f3417L, "parseSettings starting TIMERS");
            if (bundle2.containsKey(f3424S)) {
                Bundle bundle6 = bundle2.getBundle(f3424S);
                if (bundle6.containsKey(f3447j)) {
                    this.f3509az = (int) bundle6.getDouble(f3447j, 10000.0d);
                    if (z) {
                        this.f3509az *= 1000;
                    }
                    Logger.m3601d(f3417L, "parseSettings awsUploadTimeout (ms) " + this.f3509az);
                } else {
                    this.f3509az = f3438ay;
                }
                if (bundle6.containsKey(f3448k)) {
                    this.f3469aB = (int) bundle6.getDouble(f3448k, 15000.0d);
                    if (z) {
                        this.f3469aB *= 1000;
                    }
                    Logger.m3601d(f3417L, "parseSettings resolveUrlTimeout (ms) " + this.f3469aB);
                } else {
                    this.f3469aB = 15000;
                }
                if (bundle6.containsKey(f3449l)) {
                    this.f3470aD = ((int) bundle6.getDouble(f3449l, 15000.0d)) * 1000;
                    if (z) {
                        this.f3470aD *= 1000;
                    }
                    Logger.m3601d(f3417L, "parseSettings clickValidityTimeout (ms) " + this.f3470aD);
                } else {
                    this.f3470aD = 15000;
                }
                if (bundle6.containsKey(f3425T)) {
                    this.f3492aa = bundle6.getInt(f3425T, 30) * 1000;
                    Logger.m3601d(f3417L, "parseSettings redirectClickTimeout (ms) value is " + this.f3492aa + ", isFromServer=" + z);
                } else {
                    this.f3492aa = 30000;
                }
            } else {
                this.f3509az = f3438ay;
                this.f3469aB = 15000;
                this.f3470aD = 15000;
                this.f3492aa = 30000;
                Logger.m3601d(f3417L, "parseSettings TIMERS settings block does not exist. Default configuration values will be used.");
            }
            Logger.m3601d(f3417L, "parseSettings starting ANDROID");
            if (bundle2.containsKey("android")) {
                Bundle bundle7 = bundle2.getBundle("android");
                if (bundle7.containsKey(f3450m)) {
                    this.f3471aE = bundle7.getStringArrayList(f3450m);
                    Logger.m3601d(f3417L, "parseSettings interstitialActivitiesToInclude " + this.f3471aE);
                }
                if (bundle7.containsKey(f3451n)) {
                    this.f3472aF = bundle7.getStringArrayList(f3451n);
                    Logger.m3601d(f3417L, "parseSettings interstitialActivitiesToExclude " + this.f3472aF);
                }
                if ((this.f3471aE != null && this.f3471aE.size() > 0) || (this.f3472aF != null && this.f3472aF.size() > 0)) {
                    Iterator<String> it = this.f3471aE.iterator();
                    while (it.hasNext()) {
                        BrandSafetyUtils.m2920h(it.next());
                    }
                    Iterator<String> it2 = this.f3472aF.iterator();
                    while (it2.hasNext()) {
                        BrandSafetyUtils.m2921i(it2.next());
                    }
                }
                if (bundle7.containsKey(f3462y)) {
                    this.f3501aj = bundle7.getBoolean(f3462y, false);
                    Logger.m3601d(f3417L, "parseSettings disableWebViewTracking " + this.f3501aj);
                }
            } else {
                Logger.m3601d(f3417L, "parseSettings ANDROID settings block does not exist. Default configuration values will be used.");
            }
            Logger.m3601d(f3417L, "parseSettings starting GENERAL");
            if (bundle2.containsKey(f3423R)) {
                Bundle bundle8 = bundle2.getBundle(f3423R);
                if (bundle8.containsKey(f3452o)) {
                    this.f3473aG = bundle8.getString(f3452o, "https://edge.safedk.com");
                    this.f3473aG = m3514a(this.f3473aG);
                    Logger.m3601d(f3417L, "parseSettings edgeServerUrl " + this.f3473aG);
                } else {
                    this.f3473aG = "https://edge.safedk.com";
                }
                if (bundle8.containsKey(f3453p)) {
                    this.f3474aH = bundle8.getString(f3453p, "https://edge.safedk.com");
                    this.f3474aH = m3514a(this.f3474aH);
                    Logger.m3601d(f3417L, "parseSettings backupEdgeServerUrl " + this.f3474aH);
                } else {
                    this.f3474aH = "https://edge.safedk.com";
                }
                AppLovinBridge.receiveEdgeUrls(this.f3473aG, this.f3474aH);
                if (bundle8.containsKey(f3454q)) {
                    this.f3475aI = bundle8.getStringArrayList(f3454q);
                    Logger.m3601d(f3417L, "parseSettings devicesWithDebugLog " + this.f3475aI);
                }
            } else {
                Logger.m3601d(f3417L, "parseSettings GENERAL settings block does not exist. Default configuration values will be used.");
            }
            Logger.m3601d(f3417L, "parseSettings starting Ad CACHING");
            if (bundle2.containsKey(f3422Q)) {
                Bundle bundle9 = bundle2.getBundle(f3422Q);
                if (bundle9.containsKey(f3455r)) {
                    this.f3478aL = (long) ((int) bundle9.getDouble(f3455r, 6.048E8d));
                    Logger.m3601d(f3417L, "parseSettings cachedCreativeInfoMaxAge " + this.f3478aL);
                } else {
                    this.f3478aL = 604800000;
                }
                if (bundle9.containsKey(f3456s)) {
                    this.f3480aN = bundle9.getInt(f3456s);
                    Logger.m3601d(f3417L, "parseSettings cachedMaxNumberOfItems " + this.f3480aN);
                } else {
                    this.f3480aN = 50;
                }
                if (bundle9.containsKey(f3457t)) {
                    this.f3476aJ = bundle9.getStringArrayList(f3457t);
                    Logger.m3601d(f3417L, "parseSettings cacheSupportingSdkUUIDs " + this.f3476aJ);
                }
                if (this.f3476aJ != null && this.f3476aJ.size() > 0) {
                    m3516a(this.f3476aJ);
                }
            } else {
                this.f3478aL = 604800000;
                this.f3480aN = 50;
                Logger.m3601d(f3417L, "parseSettings AD_CACHING settings block does not exist. Default configuration values will be used.");
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            Logger.m3603e(f3417L, "Settings bundle is null, cannot parse settings. Saved settings will be used");
            return false;
        }
    }

    /* renamed from: a */
    private void m3515a(Bundle bundle) {
        Logger.m3601d(f3417L, "processSdkVersionsBundle started, bundle=" + bundle.toString());
    }

    /* renamed from: a */
    private void m3516a(ArrayList<String> arrayList) {
        this.f3500ai.clear();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Logger.m3601d(f3417L, "Adding cacheSupportingSDKUUID " + next + " to cacheSupportedSdk List");
            this.f3500ai.add(next);
        }
    }

    /* renamed from: a */
    private String m3514a(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        try {
            URL url = new URL(str);
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            if (port == -1) {
                return String.format("%s://%s", new Object[]{protocol, host});
            }
            return String.format("%s://%s:%d", new Object[]{protocol, host, Integer.valueOf(port)});
        } catch (MalformedURLException e) {
            Logger.m3604e(f3417L, "Exception sanitizing server url:" + e.getMessage(), e);
            return str;
        }
    }

    /* renamed from: a */
    private boolean m3517a(Double d, String str) {
        Logger.m3601d(f3417L, "checkActivePercent started, activePercent=" + d + ", userId=" + str);
        float a = DeviceData.m3497a("", str);
        Logger.m3601d(f3417L, "checkActivePercent hashValue ==" + a);
        if (((double) a) <= d.doubleValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: I */
    public long mo19590I() {
        return this.f3478aL;
    }

    /* renamed from: J */
    public int mo19591J() {
        return this.f3480aN;
    }

    /* renamed from: K */
    public ArrayList<String> mo19592K() {
        return this.f3500ai;
    }
}

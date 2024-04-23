package com.example.safesdk.sample.analytics.events;

import android.os.Bundle;
import android.text.TextUtils;

import com.example.safesdk.sample.analytics.StatsCollector;
import com.example.safesdk.sample.analytics.brandsafety.BannerFinder;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.C1324f;
import com.example.safesdk.sample.analytics.brandsafety.InterstitialFinder;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BrandSafetyEvent extends StatsEvent implements Serializable {

    /* renamed from: a */
    public static  String f3195a = "click_url";

    /* renamed from: a_ */
    private static  String f3196a_ = "BrandSafetyEvent";

    /* renamed from: ab */
    private static  Set<String> f3197ab = new HashSet(Arrays.asList(new String[]{"ad_format_type", StatsEvent.f3300z, "sdk_uuid"}));

    /* renamed from: ac */
    public static  String f3198ac = "is_first_session";

    /* renamed from: ad */
    public static  String f3199ad = "will_display_received";

    /* renamed from: ae */
    public static  String f3200ae = "is_banner_view_detected";

    /* renamed from: af */
    public static  String f3201af = "image_slot";

    /* renamed from: ag */
    public static  String f3202ag = "interval_between_display_messages";

    /* renamed from: ah */
    public static  String f3203ah = "detected_view_proportions";

    /* renamed from: ao */
    public static  String f3204ao = "device_orientation";

    /* renamed from: b */
    public static  String f3205b = "foreground_activity";

    /* renamed from: c */
    public static  String f3206c = "impression_id";

    /* renamed from: d */
    public static  String f3207d = "viewing_time";

    /* renamed from: e */
    public static  String f3208e = "slot_number";

    /* renamed from: f */
    public static  String f3209f = "zone_id";

    /* renamed from: g */
    public static  String f3210g = "app_package_name";

    /* renamed from: h */
    public static  String f3211h = "dsp_domains";

    /* renamed from: i */
    public static  String f3212i = "ad_format";

    /* renamed from: j */
    public static  String f3213j = "ad_format_type";

    /* renamed from: k */
    public static  String f3214k = "third_party_ad_placement_id";

    /* renamed from: l */
    public static  String f3215l = "max_ad_unit_id";

    /* renamed from: m */
    public static  String f3216m = "sdk_version";

    /* renamed from: n */
    public static  String f3217n = "impression";

    /* renamed from: o */
    public static  String f3218o = "image_file_size";

    /* renamed from: p */
    public static  String f3219p = "image_uniformity";

    /* renamed from: q */
    public static  String f3220q = "image_id";

    /* renamed from: r */
    public static  String f3221r = "image_orientation";

    /* renamed from: s */
    public static  String f3222s = "is_animated";
    private static  long serialVersionUID = 0;

    /* renamed from: t */
    public static  String f3223t = "is_clicked";

    /* renamed from: u */
    public static  String f3224u = "ad_recommendations";

    /* renamed from: v */
    public static  String f3225v = "is_next_session";

    /* renamed from: L */
    private int f3226L;

    /* renamed from: M */
    private String f3227M;

    /* renamed from: N */
    private String f3228N;

    /* renamed from: O */
    private transient Bundle f3229O;

    /* renamed from: P */
    private  String f3230P;

    /* renamed from: Q */
    private  String f3231Q;

    /* renamed from: R */
    private long f3232R;

    /* renamed from: S */
    private String f3233S;

    /* renamed from: T */
    private String f3234T;

    /* renamed from: U */
    private String f3235U;

    /* renamed from: V */
    private boolean f3236V;

    /* renamed from: W */
    private String f3237W;

    /* renamed from: X */
    private boolean f3238X;

    /* renamed from: Y */
    private long f3239Y;

    /* renamed from: Z */
    private float f3240Z;

    /* renamed from: aa */
    private BrandSafetyUtils.ScreenShotOrientation f3241aa;

    /* renamed from: ai */
    boolean f3242ai;

    /* renamed from: aj */
    boolean f3243aj;

    /* renamed from: ak */
    int f3244ak;

    /* renamed from: al */
    long f3245al;

    /* renamed from: am */
    float f3246am;

    /* renamed from: an */
    String f3247an;

    /* renamed from: ap */
    boolean f3248ap;

    public enum AdFormatType {
        INTER,
        REWARD,
        BANNER,
        LEADER
    }

    /* renamed from: a */
    public String mo19509a() {
        return this.f3237W;
    }

    public BrandSafetyEvent(String sdk, int slotNumber, String hashValue, boolean clicked, String clickUrl, CreativeInfo creativeInfo, long timestamp, String foregroundActivityName, String impressionMd5, long viewingTime, boolean isMature, Bundle applovinData, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean isAnimated, long imageFileSize, float imageUniformity, int imageSlot, boolean isFirstSession) {
        super(sdk, StatsCollector.EventType.BrandSafety);
        this.f3236V = false;
        this.f3237W = null;
        this.f3238X = false;
        this.f3248ap = false;
        this.f3242ai = false;
        this.f3243aj = false;
        this.f3244ak = 0;
        this.f3245al = 0;
        this.f3246am = 0.0f;
        this.f3247an = null;
        this.f3226L = slotNumber;
        if (timestamp > 0) {
            this.f3305G = C1361h.m3690b(timestamp);
        }
        Logger.m3601d(f3196a_, "creative info: " + creativeInfo);
        if (creativeInfo != null) {
            if (creativeInfo.mo19383B().equals(sdk)) {
                Logger.m3601d(f3196a_, "creative info sdk is equal to event SDK");
                this.f3228N = creativeInfo.mo19431q();
                this.f3229O = creativeInfo.mo19379b();
                Logger.m3601d(f3196a_, "addedCreativeInfoValues " + this.f3229O);
                if (clickUrl == null) {
                    Logger.m3601d(f3196a_, "self click url is null, setting creative info click url");
                    clickUrl = creativeInfo.mo19446x();
                }
            } else {
                Logger.m3601d(f3196a_, "creative info sdk != sdk.");
                Logger.m3601d(f3196a_, "creative info sdk: " + creativeInfo.mo19383B());
                Logger.m3601d(f3196a_, "sdk: " + sdk);
            }
        }
        if (clickUrl != null && !clickUrl.isEmpty()) {
            clickUrl = C1324f.m3379a(clickUrl);
        }
        this.f3227M = clickUrl;
        this.f3236V = clicked;
        this.f3230P = foregroundActivityName;
        this.f3231Q = impressionMd5;
        this.f3232R = viewingTime;
        if (applovinData != null) {
            this.f3233S = applovinData.getString(f3215l);
            this.f3234T = m3428a(applovinData.getString("ad_format"));
            this.f3235U = applovinData.getString(f3214k);
        }
        this.f3307I = isMature;
        this.f3237W = hashValue;
        this.f3241aa = screenShotOrientation;
        if (isAnimated) {
            this.f3238X = isAnimated;
        }
        if (hashValue != null) {
            this.f3239Y = imageFileSize;
            this.f3240Z = imageUniformity;
            this.f3244ak = imageSlot;
        }
        this.f3310aq = isFirstSession;
    }

    public BrandSafetyEvent(String sdk, int slotNumber, String hashValue, boolean clicked, String clickUrl, CreativeInfo creativeInfo, long timestamp, String foregroundActivityName, String impressionMd5, long viewingTime, boolean isMature, Bundle applovinData, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean isAnimated, long image_file_size, float imageUniformity, int imageSlot, boolean willDisplayReceived, boolean isBannerViewDetected, long intervalBetweenDisplayMessages, float detectedViewProportions, String deviceOrientation, boolean isFirstSession) {
        this(sdk, slotNumber, hashValue, clicked, clickUrl, creativeInfo, timestamp, foregroundActivityName, impressionMd5, viewingTime, isMature, applovinData, screenShotOrientation, isAnimated, image_file_size, imageUniformity, imageSlot, isFirstSession);
        this.f3248ap = true;
        this.f3242ai = willDisplayReceived;
        this.f3243aj = isBannerViewDetected;
        this.f3245al = intervalBetweenDisplayMessages;
        this.f3246am = detectedViewProportions;
        this.f3247an = deviceOrientation;
    }

    /* renamed from: b */
    public StatsCollector.EventType mo19511b() {
        return StatsCollector.EventType.BrandSafety;
    }

    /* renamed from: c */
    public String mo19512c() {
        return this.f3231Q;
    }

    /* renamed from: a */
    public void mo19510a(StatsEvent statsEvent) {
        BrandSafetyEvent brandSafetyEvent = (BrandSafetyEvent) statsEvent;
        Bundle bundle = brandSafetyEvent.f3229O;
        if (bundle != null) {
            Logger.m3601d(f3196a_, "Aggregating downstream struct. eventCreativeValues=" + bundle);
            this.f3229O = bundle;
            this.f3228N = brandSafetyEvent.f3228N;
        }
        String str = brandSafetyEvent.f3227M;
        if (!TextUtils.isEmpty(str)) {
            this.f3227M = str;
        }
        long i = statsEvent.mo19548i();
        if (i != 0 && i < this.f3305G) {
            this.f3305G = i;
        }
        long j = brandSafetyEvent.f3232R;
        if (j > 0 && j > this.f3232R) {
            this.f3232R = j;
        }
        if (brandSafetyEvent.f3237W != null) {
            Logger.m3601d(f3196a_, "doAggregation updating screenShotHashValue to '" + brandSafetyEvent.f3237W + "' , image_file_size to " + brandSafetyEvent.f3239Y + " and image_max_uniform_pixels to " + brandSafetyEvent.f3240Z);
            this.f3237W = brandSafetyEvent.f3237W;
            this.f3239Y = brandSafetyEvent.f3239Y;
            this.f3240Z = brandSafetyEvent.f3240Z;
            this.f3244ak = brandSafetyEvent.f3244ak;
            BrandSafetyUtils.ScreenShotOrientation screenShotOrientation = brandSafetyEvent.f3241aa;
            if (!(screenShotOrientation == null || screenShotOrientation == BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED)) {
                Logger.m3601d(f3196a_, "doAggregation updating screenShotOrientation to '" + screenShotOrientation + "'");
                this.f3241aa = screenShotOrientation;
            }
        } else {
            Logger.m3601d(f3196a_, "doAggregation updating image hash to null");
            this.f3237W = null;
            this.f3239Y = 0;
            this.f3244ak = 0;
            this.f3241aa = null;
            this.f3240Z = 0.0f;
        }
        boolean z = brandSafetyEvent.f3236V;
        if (z) {
            Logger.m3601d(f3196a_, "doAggregation updating clicked to " + z);
            this.f3236V = z;
        }
        this.f3238X = brandSafetyEvent.f3238X;
    }

    /* renamed from: d */
    public Bundle mo19513d() {
        Bundle d = super.mo19513d();
        if (this.f3226L > 0) {
            d.putInt(f3208e, this.f3226L);
        }
        if (!TextUtils.isEmpty(this.f3227M)) {
            d.putString(f3195a, this.f3227M);
        }
        if (this.f3229O != null) {
            d.putAll(this.f3229O);
        }
        if (!TextUtils.isEmpty(this.f3230P)) {
            d.putString("foreground_activity", this.f3230P);
        }
        d.putString(f3206c, this.f3231Q);
        if (this.f3232R > 0) {
            d.putLong(f3207d, this.f3232R);
        }
        if (this.f3233S != null) {
            d.putString(f3215l, this.f3233S);
        }
        if (this.f3301C != null) {
            if (d.getString("ad_format_type") == null || C1357d.f3608p.equals(this.f3301C) || C1357d.f3613u.equals(this.f3301C)) {
                d.putString("ad_format_type", this.f3234T);
            }
            if (d.getString(f3209f) == null || C1357d.f3608p.equals(this.f3301C) || C1357d.f3613u.equals(this.f3301C)) {
                d.putString(f3209f, this.f3235U);
            }
        } else {
            Logger.m3601d(f3196a_, "Sdk field value is null.");
        }
        d.putString(StatsEvent.f3300z, "impression");
        if (this.f3237W != null) {
            d.putString("image_id", this.f3237W);
            if (this.f3248ap) {
                d.putBoolean(f3222s, this.f3238X);
            }
            if (this.f3241aa != null) {
                d.putString("image_orientation", this.f3241aa.name().toLowerCase());
            }
            d.putLong(f3218o, this.f3239Y);
            d.putFloat(f3219p, this.f3240Z);
            d.putInt(f3201af, this.f3244ak);
        }
        d.putBoolean(f3223t, this.f3236V);
        d.putBoolean(f3225v, this.f3308J);
        if (this.f3248ap) {
            d.putBoolean(f3199ad, this.f3242ai);
            d.putBoolean(f3200ae, this.f3243aj);
            d.putLong(f3202ag, this.f3245al);
            if (this.f3246am > 0.0f) {
                d.putFloat(f3203ah, this.f3246am);
            }
            d.putString(f3204ao, this.f3247an);
        }
        d.putBoolean(f3198ac, this.f3310aq);
        C1361h.m3694b(f3196a_, "bundle=" + d.toString());
        return d;
    }

    /* renamed from: e */
    public Set<String> mo19514e() {
        HashSet hashSet = new HashSet(f3197ab);
        if (this.f3301C != null && this.f3301C.equals(C1357d.f3603k)) {
            hashSet.add(f3195a);
        }
        return hashSet;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.f3229O != null) {
            objectOutputStream.writeObject(m3429a(this.f3229O));
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        try {
            Map map = (Map) objectInputStream.readObject();
            if (map != null) {
                this.f3229O = m3427a((Map<String, Object>) map);
            }
        } catch (OptionalDataException e) {
        }
    }

    /* renamed from: a */
    private static Map<String, Object> m3429a(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Bundle m3427a(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof ArrayList) {
                bundle.putStringArrayList(next, (ArrayList) obj);
            }
        }
        return bundle;
    }

    /* renamed from: a */
    private String m3428a(String str) {
        Logger.m3601d(f3196a_, "getAdFormatTypeFromMaxAdFormType called, input=" + str);
        String str2 = null;
        if (InterstitialFinder.f2538a.equals(str)) {
            str2 = AdFormatType.INTER.toString();
        } else if (InterstitialFinder.f2539b.equals(str)) {
            str2 = AdFormatType.REWARD.toString();
        } else if (BannerFinder.f2439a.equals(str)) {
            str2 = AdFormatType.BANNER.toString();
        } else if (BannerFinder.f2440b.equals(str)) {
            str2 = AdFormatType.LEADER.toString();
        }
        Logger.m3601d(f3196a_, "getAdFormatTypeFromMaxAdFormType returned  " + str2);
        return str2;
    }
}

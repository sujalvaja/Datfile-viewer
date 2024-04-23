package com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.AppLovinCreativeInfo;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.BrandSafetyEvent;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.PersistentConcurrentHashMap;
import com.example.safesdk.sample.utils.SdksMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.c */
public class C1313c extends C1315d {

    /* renamed from: A */
    private static  String f2856A = "BANNER";

    /* renamed from: B */
    private static  String f2857B = "MREC";

    /* renamed from: C */
    private static  String f2858C = "INTER";

    /* renamed from: D */
    private static  String f2859D = "ad_type";

    /* renamed from: E */
    private static  String f2860E = "REGULAR";

    /* renamed from: F */
    private static  String f2861F = "VIDEOA";

    /* renamed from: G */
    private static  String f2862G = "zone_id";

    /* renamed from: H */
    private static  String f2863H = "event_id";

    /* renamed from: I */
    private static  String f2864I = "clcodes";

    /* renamed from: J */
    private static  String f2865J = "dsp_name";

    /* renamed from: K */
    private static  String f2866K = "html";

    /* renamed from: L */
    private static  String f2867L = "html_template";

    /* renamed from: M */
    private static  String f2868M = "status";

    /* renamed from: N */
    private static  String f2869N = "ads";

    /* renamed from: O */
    private static  String f2870O = "click_url";

    /* renamed from: P */
    private static  String f2871P = "video";

    /* renamed from: Q */
    private static  String f2872Q = "ad_id";

    /* renamed from: R */
    private static  String f2873R = "clcode";

    /* renamed from: S */
    private static  String f2874S = "bid_response";

    /* renamed from: T */
    private static  String f2875T = "third_party_ad_placement_id";

    /* renamed from: U */
    private static  String f2876U = "xml";

    /* renamed from: V */
    private static  String f2877V = "stream_url";

    /* renamed from: W */
    private static  String f2878W = "HOSTED_HTML_UNIVERSAL_VIDEO";

    /* renamed from: X */
    private static  String f2879X = "HOSTED_HTML_UNIVERSAL_REWARD";

    /* renamed from: Y */
    private static  String f2880Y = "HOSTED_HTML_UNIVERSAL";

    /* renamed from: Z */
    private static  String f2881Z = "APPLOVIN_NETWORK";

    /* renamed from: aa */
    private static  String f2882aa = "name";

    /* renamed from: ab */
    private static  int f2883ab = 200;

    /* renamed from: ac */
    private static  Pattern f2884ac = Pattern.compile("clickUrl: '([^']+)'");

    /* renamed from: ad */
    private static  Pattern f2885ad = Pattern.compile("(market:[^'\"]+)['\"]");

    /* renamed from: ae */
    private static  Pattern f2886ae = Pattern.compile("!--(.*?)--");

    /* renamed from: af */
    private static  Pattern f2887af = Pattern.compile("<span class=\"banner-title\">(.*?)</span>");

    /* renamed from: ag */
    private static  Pattern f2888ag = Pattern.compile("<span class=\"banner-description\">(.*?)</span>");

    /* renamed from: ah */
    private static String f2889ah = null;

    /* renamed from: ak */
    private static  String f2890ak = "&current_retry_attempt=";

    /* renamed from: al */
    private static  String f2891al = "(function(){var log=function(message){try{console.log(message);window.webkit.messageHandlers.safedkDebug.postMessage(message)}catch(error){}};var addObservers=function(){try{var privacyElement=document.getElementById(\"al_bigAdInfo\");if(privacyElement&&privacyElement.style){var displayState=privacyElement.style.display;if(displayState!=\"none\"&&displayState!=\"\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(\"\")}else{if(privacyElement.safedkPrivacyDialogObserver!=true){privacyElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":log(\"getComputedStyle(mutation.target)=\"+getComputedStyle(mutation.target));if(getComputedStyle(mutation.target).visibility==\"visible\"||getComputedStyle(mutation.target).display!=\"none\"&&displayState!=\"\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(\"\")}break}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"style\"]};observer.observe(privacyElement,config)}catch(error){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}}}}}catch(error){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}};addObservers();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){addObservers()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}})();\n";

    /* renamed from: r */
    public static  String f2892r = "com.applovin.mediation.adapters.AppLovinMediationAdapter";

    /* renamed from: x */
    private static String f2893x = "AppLovinDiscovery";

    /* renamed from: y */
    private static  String f2894y = "ad_size";

    /* renamed from: z */
    private static  String f2895z = "ad_format";

    /* renamed from: ai */
    private PersistentConcurrentHashMap<String, CreativeInfo> f2896ai = new PersistentConcurrentHashMap<>();

    /* renamed from: aj */
    private Map<String, C1314a> f2897aj = new HashMap();

    public C1313c() {
        super(C1357d.f3593a, f2893x);
        f2889ah = C1361h.m3670a();
        SdksMapping.init();
        mo19341e(f2892r, f2889ah);
    }

    /* renamed from: a */
    public List<CreativeInfo> mo19293a(String str, String str2, Map<String, List<String>> map, C1314a aVar) {
        int indexOf = str.indexOf(f2890ak);
        if (indexOf > -1) {
            str = str.substring(0, indexOf);
        }
        return super.mo19293a(str, str2, map, aVar);
    }

    /* renamed from: b */
    public List<CreativeInfo> mo19330b(String str, String str2, Map<String, List<String>> map, C1314a aVar) throws JSONException {
        String str3;
        ArrayList<String> arrayList;
        String name;
        if (!C1361h.m3718p(str2)) {
            Logger.m3601d(f2893x, "buffer is not a JSON String, skipping.");
            return new ArrayList();
        }
        JSONObject jSONObject = new JSONObject(str2);
        Logger.m3601d(f2893x, "AppLovinDiscovery generateInfo url: " + str + " , buffer : " + str2);
        if (jSONObject == null || !jSONObject.has(f2869N)) {
            Logger.m3601d(f2893x, "no ads element in Json, skipping.");
            return new ArrayList();
        }
        JSONArray jSONArray = jSONObject.getJSONArray(f2869N);
        if (jSONArray.length() == 0 || jSONObject.getInt("status") != 200) {
            return null;
        }
        String optString = jSONObject.optString(f2873R);
        if (TextUtils.isEmpty(optString)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(f2864I);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                C1314a aVar2 = new C1314a(jSONObject.optString(f2863H), jSONObject.optString("ad_format"));
                Logger.m3601d(f2893x, "Max prefetch parameters: eventId=" + aVar2.f2898a + ", adFormat=" + aVar2.f2899b);
                return m3152a(str, map, jSONArray, aVar2);
            }
            optString = optJSONArray.getString(0);
        }
        String string = jSONObject.getString(f2894y);
        if (string.equals(f2857B)) {
            return null;
        }
        BrandSafetyUtils.AdType adType = (string.equals("INTER") || string.equals(f2860E)) ? BrandSafetyUtils.AdType.INTERSTITIAL : BrandSafetyUtils.AdType.BANNER;
        Logger.m3601d(f2893x, "Ad type is " + adType);
        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
        String optString2 = jSONObject2.optString(f2866K);
        if (TextUtils.isEmpty(optString2)) {
            str3 = jSONObject2.optString(f2867L);
        } else {
            str3 = optString2;
        }
        String optString3 = jSONObject2.optString("click_url", (String) null);
        if (optString3 == null && !TextUtils.isEmpty(str3)) {
            optString3 = mo19343j(str3);
            if (optString3 == null) {
                optString3 = mo19335a(f2885ad, str3);
            }
            if (optString3 == null) {
                optString3 = mo19335a(f2884ac, str3);
            }
        }
        String k = mo19344k(str3);
        String optString4 = jSONObject2.optString(f2877V, (String) null);
        String optString5 = jSONObject2.optString(f2871P, (String) null);
        boolean z = (optString5 == null && optString4 == null) ? false : true;
        String a = mo19335a(f2886ae, str3);
        if (a != null) {
            a = a.trim();
        }
        if (str.contains("a.applovin.com/4.0/ad")) {
            arrayList = m3153o(str3);
        } else {
            arrayList = null;
        }
        String optString6 = jSONObject2.optString(f2872Q);
        String string2 = jSONObject.getString(f2859D);
        String string3 = jSONObject.getString("zone_id");
        String optString7 = jSONObject.optString(f2863H, (String) null);
        if (aVar != null) {
            Logger.m3601d(f2893x, "got MAX prefetch parameters: " + aVar);
            name = aVar.f2899b.name();
            optString7 = aVar.f2898a;
        } else {
            name = adType == BrandSafetyUtils.AdType.INTERSTITIAL ? BrandSafetyEvent.AdFormatType.INTER.name() : BrandSafetyEvent.AdFormatType.BANNER.name();
            C1314a remove = this.f2897aj.remove(optString);
            if (remove != null) {
                Logger.m3601d(f2893x, "find MAX prefetch parameters: " + remove);
                optString7 = remove.f2898a;
                if (string3 == null || string3.isEmpty()) {
                    string3 = remove.f2900c;
                }
            } else {
                Logger.m3601d(f2893x, "no MAX prefetch parameters found for adId: " + optString + ", eventId: " + optString7);
            }
        }
        if (string2.equals(f2861F)) {
            name = BrandSafetyEvent.AdFormatType.REWARD.name();
        }
        AppLovinCreativeInfo appLovinCreativeInfo = new AppLovinCreativeInfo(adType, optString, optString6, optString3, optString5, name, string3, f2889ah, a, jSONObject.optString(f2865J), optString7, k, z, false);
        if (adType.equals(BrandSafetyUtils.AdType.BANNER)) {
            this.f2896ai.put(string3 + "_" + optString7 + "_" + C1357d.f3593a, appLovinCreativeInfo);
        }
        String optString8 = jSONObject2.optString(f2876U);
        if (!TextUtils.isEmpty(optString8)) {
            mo19337a((CreativeInfo) appLovinCreativeInfo, str, optString8, true);
        }
        appLovinCreativeInfo.mo19397b((List<String>) C1361h.m3704d(str3));
        if (!TextUtils.isEmpty(str3)) {
            appLovinCreativeInfo.mo19391a(optString.hashCode());
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Logger.m3601d(f2893x, "generateInfo ad text " + next);
                appLovinCreativeInfo.mo19436s(next);
            }
        }
        C1361h.m3694b(f2893x, "Added creative info " + appLovinCreativeInfo);
        return Arrays.asList(new CreativeInfo[]{appLovinCreativeInfo});
    }

    /* renamed from: o */
    private ArrayList<String> m3153o(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String a = mo19335a(f2887af, str);
        String a2 = mo19335a(f2888ag, str);
        Logger.m3601d(f2893x, "found ad text: title=" + a + ", description=" + a2);
        arrayList.add(a);
        arrayList.add(a2);
        return arrayList;
    }

    /* renamed from: a */
    private List<CreativeInfo> m3152a(String str, Map<String, List<String>> map, JSONArray jSONArray, C1314a aVar) throws JSONException {
        int i = 0;
        while (true) {
            if (i >= jSONArray.length()) {
                break;
            }
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("name");
            String optString = jSONObject.optString(f2874S, (String) null);
            aVar.f2900c = jSONObject.optString("third_party_ad_placement_id");
            if (!f2881Z.equals(string)) {
                if (optString != null) {
                    Logger.m3601d(f2893x, string + " " + aVar.f2899b + " bidResponse is " + optString);
                    CreativeInfoManager.m3079a(string, str, optString, map, aVar);
                } else {
                    Logger.m3601d(f2893x, string + " " + aVar.f2899b + " bidResponse empty.");
                }
                i++;
            } else if (optString != null) {
                String[] split = optString.split("!");
                if (split.length == 2) {
                    Logger.m3601d(f2893x, string + " " + aVar.f2899b + " base64 bidResponse is " + optString);
                    return mo19330b(str, new String(Base64.decode(split[1], 0)), map, aVar);
                }
                Logger.m3601d(f2893x, string + " bidder " + aVar.f2899b + ", bidResponse is clcode " + optString);
                this.f2897aj.put(optString, aVar);
            }
        }
        return null;
    }

    
    /* renamed from: a */
    public String mo19329a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    
    /* renamed from: g */
    public boolean mo19331g(String str) {
        Logger.m3601d(f2893x, "shouldFollowGetUrlImpl " + str);
        return str.contains("4.0/ad");
    }

    
    /* renamed from: h */
    public boolean mo19332h(String str) {
        boolean z = false;
        Logger.m3601d(f2893x, "shouldFollowInputStreamImpl " + str);
        int indexOf = str.indexOf(f2890ak);
        if (indexOf > -1) {
            str = mo19347n(str.substring(0, indexOf));
            if (this.f2909s.containsKey(str)) {
                return true;
            }
        }
        if (str.contains("4.0/ad") || CreativeInfoManager.m3102e(str)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public String mo19292a(String str, String str2) {
        Logger.m3601d(f2893x, "getAdIdFromResource started , value = " + str);
        try {
            String[] split = str2.split("clcode=");
            if (split.length > 0) {
                String[] split2 = split[1].split("\"|\\&|&");
                if (split2.length > 0) {
                    return split2[0];
                }
                return null;
            }
            Logger.m3601d(f2893x, "cant split string by clcode. string: " + str2);
            return null;
        } catch (Exception e) {
            Logger.m3601d(f2893x, "cant extract ad id from: " + str2);
            return null;
        }
    }

    /* renamed from: d */
    public int mo19307d(String str) {
        String a = mo19292a(str, str);
        if (a == null) {
            return 0;
        }
        Logger.m3601d(f2893x, String.format("ad id %s, hashcode: %s, from webview html: %s, ", new Object[]{a, Integer.valueOf(a.hashCode()), str}));
        return a.hashCode();
    }

    /* renamed from: b */
    public AdNetworkDiscovery.WebViewResourceMatchingMethod mo19300b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    /* renamed from: c */
    public Set<String> mo19305c() {
        return new HashSet();
    }

    /* renamed from: d */
    public Bundle mo19308d() {
        Bundle d = super.mo19308d();
        d.putBoolean(AdNetworkDiscovery.f2656m, true);
        d.putBoolean(AdNetworkDiscovery.f2657n, true);
        d.putString(AdNetworkDiscovery.f2658o, f2891al);
        d.putBoolean(AdNetworkDiscovery.f2648e, true);
        return d;
    }

    /* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.c$a */
    public class C1314a {

        /* renamed from: a */
        public String f2898a;

        /* renamed from: b */
        public BrandSafetyEvent.AdFormatType f2899b;

        /* renamed from: c */
        public String f2900c;

        public C1314a(String str, String str2) {
            this.f2898a = str;
            this.f2899b = BrandSafetyEvent.AdFormatType.valueOf(str2);
        }

        public String toString() {
            return "{eventId=" + this.f2898a + ", adFormat=" + this.f2899b + ", placementId=" + this.f2900c + '}';
        }
    }

    /* renamed from: a */
    public CreativeInfo mo19291a(Object obj) {
        String str = (String) obj;
        Logger.m3601d(f2893x, "generateInfo started complexKey = " + str + " , bannerCreativeInfos.keySet() = " + this.f2896ai.keySet());
        if (!this.f2896ai.containsKey(str)) {
            return null;
        }
        Logger.m3601d(f2893x, "generateInfo found ci : " + this.f2896ai.get(str));
        return this.f2896ai.remove(str);
    }
}

package com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.util.Pair;

import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;
import com.example.safesdk.sample.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1317f;
import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.utils.C1361h;
import com.example.safesdk.sample.utils.Logger;
import com.example.safesdk.sample.utils.PersistentConcurrentHashMap;
import com.example.safesdk.sample.utils.SdksMapping;
import com.itextpdf.text.xml.xmp.XmpWriter;

import org.json.JSONException;
import org.objectweb.asm.signature.SignatureVisitor;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.d */
public abstract class C1315d  {

    /* renamed from: A */
    private static String f2902A = null;

    /* renamed from: r */
    private static  String f2903r = "Liftoff.init";

    /* renamed from: u */
    protected static  Set<String> f2904u = new HashSet(Arrays.asList(new String[]{"sdk3p", "dc_osd", "dc_sdk_apis", "dc_omid_p", "osd"}));

    /* renamed from: x */
    private static  Pattern f2905x = Pattern.compile("pinpoint_url\\\":\\\"([^\\\"]+)\"");

    /* renamed from: y */
    private static  Pattern f2906y = Pattern.compile("click_config\\\":\\{\\\"clickthrough_url\\\":\\{\\\"url\\\":\\\"([^\\\"]+)\\\"");

    /* renamed from: z */
    private static  Pattern f2907z = Pattern.compile("bidBundle\\\":\\\"([^\\\"]+)\\\"");

    /* renamed from: B */
    private String f2908B;

    /* renamed from: s */
    protected Map<String, CreativeInfo> f2909s = null;

    /* renamed from: t */
    protected Map<String, CreativeInfo> f2910t = null;

    /* renamed from: v */
    protected Set<String> f2911v = new HashSet();

    /* renamed from: w */
    protected Set<String> f2912w = new HashSet();

    
    /* renamed from: a */
    public abstract String mo19329a(String str, CreativeInfo creativeInfo);

    
    /* renamed from: b */
    public abstract List<CreativeInfo> mo19330b(String str, String str2, Map<String, List<String>> map, C1313c.C1314a aVar) throws JSONException;

    
    /* renamed from: g */
    public abstract boolean mo19331g(String str);

    
    /* renamed from: h */
    public abstract boolean mo19332h(String str);

    /* renamed from: a */
    public boolean mo19299a(String str) {
        boolean containsKey = this.f2909s.containsKey(str);
        boolean z = containsKey || mo19332h(str);
        Logger.m3601d(this.f2908B, "shouldFollowInputStream " + z + ", vast=" + containsKey + " url=" + str);
        return z;
    }

    /* renamed from: b */
    public boolean mo19303b(String str) {
        return false;
    }

    /* renamed from: c */
    public boolean mo19306c(String str) {
        mo19342i(str);
        boolean containsKey = this.f2910t.containsKey(str);
        boolean z = containsKey || mo19331g(str);
        Logger.m3601d(this.f2908B, "shouldFollowGetUrl " + z + ", vast=" + containsKey + " url=" + str);
        return z;
    }

    
    /* renamed from: i */
    public void mo19342i(String str) {
        SafeDK instance;
        Logger.m3601d(this.f2908B, "triggerVideoCompletedEventIfNeeded event url=" + str);
        Set<String> c = mo19339c(str, mo19305c());
        if (c != null && c.size() > 0) {
            str = mo19334a(str, c);
        }
        if (this.f2911v.remove(str) && (instance = SafeDK.getInstance()) != null && instance.mo19148r() != null) {
            instance.mo19148r().mo19248b();
        }
    }

    /* renamed from: a */
    public List<CreativeInfo> mo19293a(String str, String str2, Map<String, List<String>> map, C1313c.C1314a aVar) {
        CreativeInfo creativeInfo;
        if (str2 != null) {
            try {
                if (str2.length() != 0) {
                    if (str2.length() <= 307200) {
                        C1361h.m3694b(this.f2908B, "BaseDiscovery generateInfo url: " + str + (mo19346m(str) ? "" : ", bufferValue: " + str2));
                    } else {
                        C1361h.m3694b(this.f2908B, "BaseDiscovery generateInfo url: " + str);
                    }
                    C1361h.m3694b(this.f2908B, "BaseDiscovery generateInfo vastUrlsToFollow: " + this.f2909s.toString());
                    if (this.f2909s.containsKey(str)) {
                        Logger.m3601d(this.f2908B, "Vasts redirect url found: " + str);
                        creativeInfo = this.f2909s.remove(str);
                        mo19345l(str);
                    } else {
                        creativeInfo = null;
                    }
                    String n = mo19347n(str);
                    Logger.m3601d(this.f2908B, "decodedUrl : " + n);
                    if (creativeInfo == null && this.f2909s.containsKey(n)) {
                        Logger.m3601d(this.f2908B, "Vasts redirect url found: " + str);
                        creativeInfo = this.f2909s.remove(n);
                        mo19345l(n);
                    }
                    String replace = n.replace(SignatureVisitor.EXTENDS, ' ');
                    Logger.m3601d(this.f2908B, "decodedUrlWithSpaces : " + replace);
                    if (creativeInfo == null && this.f2909s.containsKey(replace)) {
                        Logger.m3601d(this.f2908B, "Vasts redirect url found: " + str);
                        creativeInfo = this.f2909s.remove(replace);
                        mo19345l(replace);
                    }
                    if (creativeInfo == null) {
                        String b = mo19338b(n, f2904u);
                        Logger.m3601d(this.f2908B, "urlWithExcludedQueryParams : " + b);
                        if (this.f2909s.containsKey(b)) {
                            Logger.m3601d(this.f2908B, "Vasts redirect url found : " + str);
                            creativeInfo = this.f2909s.remove(b);
                            mo19345l(b);
                        }
                    }
                    CreativeInfo creativeInfo2 = creativeInfo;
                    if (creativeInfo2 != null) {
                        C1361h.m3694b(this.f2908B, "found vast url. url : " + str + ", ci: " + creativeInfo2 + ", content = " + str2);
                        mo19337a(creativeInfo2, str, str2, true);
                        Logger.m3601d(this.f2908B, "Vast processing was done in BaseDiscovery.");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(creativeInfo2);
                        return arrayList;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    List<CreativeInfo> b2 = mo19330b(str, str2, map, aVar);
                    if (b2 != null) {
                        for (CreativeInfo next : b2) {
                            if (BrandSafetyUtils.AdType.INTERSTITIAL.equals(next.mo19442v()) || BrandSafetyUtils.AdType.BANNER.equals(next.mo19442v())) {
                                arrayList2.add(next);
                            }
                        }
                    }
                    return arrayList2;
                }
            } catch (Throwable th) {
                Logger.m3602d(this.f2908B, "generateInfo error parsing. msg: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public CreativeInfo mo19291a(Object obj) {
        return null;
    }

    /* renamed from: a */
    public String mo19292a(String str, String str2) {
        return null;
    }

    /* renamed from: a */
    public Pair<String, List<String>> mo19290a(Set<String> set) {
        return null;
    }

    /* renamed from: d */
    public int mo19307d(String str) {
        return 0;
    }

    /* renamed from: b */
    public void mo19302b(String str, String str2) {
    }

    /* renamed from: a */
    public void mo19295a(FileInputStream fileInputStream, String str) {
    }

    /* renamed from: a */
    public boolean mo19298a() {
        return false;
    }

    /* renamed from: a */
    public void mo19296a(Object obj, Object obj2) {
    }

    /* renamed from: b */
    public String mo19301b(Object obj) {
        return null;
    }

    /* renamed from: a */
    public void mo19294a(FileInputStream fileInputStream, FileDescriptor fileDescriptor) {
    }

    /* renamed from: c */
    public String mo19304c(String str, String str2) {
        return null;
    }

    /* renamed from: b */
    public AdNetworkDiscovery.WebViewResourceMatchingMethod mo19300b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
    }

    /* renamed from: e */
    public String mo19309e(String str) {
        return null;
    }

    
    /* renamed from: j */
    public String mo19343j(String str) {
        if (!str.contains(f2903r)) {
            return null;
        }
        String a = mo19335a(f2905x, str);
        if (a == null) {
            return mo19335a(f2906y, str);
        }
        return a;
    }

    
    /* renamed from: k */
    public String mo19344k(String str) {
        if (str.contains(f2903r)) {
            return mo19335a(f2907z, str);
        }
        return null;
    }

    
    /* renamed from: a */
    public String mo19335a(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            Logger.m3601d(this.f2908B, "extractSubstringViaPattern found pattern=" + pattern);
            if (matcher.groupCount() > 0) {
                return matcher.group(1);
            }
        }
        return null;
    }

    
    /* renamed from: a */
    public boolean mo19336a(CreativeInfo creativeInfo, C1317f.C1318a aVar, String str) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        C1361h.m3694b(this.f2908B, "Updating vast creative info, ci= " + creativeInfo.toString() + ",  vastAdInfo = " + aVar.toString());
        if (!creativeInfo.mo19426n()) {
            z = true;
        }
        creativeInfo.mo19398b(true);
        if (z) {
            String c = aVar.mo19355c();
            if (c != null) {
                creativeInfo.mo19411f(c);
            }
            String d = aVar.mo19358d();
            if (d != null) {
                creativeInfo.mo19415h(d);
            }
            List<String> i = aVar.mo19365i();
            if (i != null) {
                for (String next : i) {
                    if (C1308d.m3131a(creativeInfo.mo19383B(), next)) {
                        Logger.m3601d(this.f2908B, "adding impression url to dsp domains : " + next);
                        creativeInfo.mo19432q(next);
                    }
                }
            } else {
                Logger.m3601d(this.f2908B, "impression list is empty");
            }
            List<String> n = aVar.mo19370n();
            if (n != null) {
                for (String next2 : n) {
                    Set<String> c2 = mo19339c(next2, mo19305c());
                    if (c2 != null && c2.size() > 0) {
                        next2 = mo19334a(next2, c2);
                    }
                    this.f2911v.add(next2);
                    this.f2912w.addAll(c2);
                }
                creativeInfo.mo19395a(true);
            } else {
                Logger.m3601d(this.f2908B, "videoCompletedTracking is empty");
            }
            List<String> o = aVar.mo19371o();
            if (o != null) {
                for (String next3 : o) {
                    if (C1308d.m3131a(creativeInfo.mo19383B(), next3)) {
                        creativeInfo.mo19432q(next3);
                    }
                }
            } else {
                Logger.m3601d(this.f2908B, "videoTrackingEvents is empty");
            }
            List<String> p = aVar.mo19372p();
            if (p != null) {
                for (String next4 : p) {
                    if (C1308d.m3131a(creativeInfo.mo19383B(), next4)) {
                        creativeInfo.mo19432q(next4);
                    }
                }
            } else {
                Logger.m3601d(this.f2908B, "clickTrackingUrls is empty");
            }
            List<String> q = aVar.mo19373q();
            if (q != null) {
                for (String next5 : q) {
                    if (C1308d.m3131a(creativeInfo.mo19383B(), next5)) {
                        creativeInfo.mo19432q(next5);
                    }
                }
            } else {
                Logger.m3601d(this.f2908B, "companionClickTrackingUrls is empty");
            }
        } else {
            Logger.m3601d(this.f2908B, "Inner Vast - don't update dspCreativeId, ad system, impression URLs and tracking URLs in CI");
        }
        String e = aVar.mo19360e();
        if (e != null) {
            String b = mo19338b(e, f2904u);
            Logger.m3601d(this.f2908B, "Following vast uri: " + e + ", urlWithExcludedQueryParams: " + b);
            this.f2909s.put(b, creativeInfo);
            mo19340d(str, b);
            Logger.m3601d(this.f2908B, "Adding VastAdUri url to ci to VastAdUri list. url: " + e + ", ci: " + creativeInfo);
            creativeInfo.mo19438t(e);
            return true;
        }
        String a = aVar.mo19349a();
        String b2 = aVar.mo19352b();
        if (a != null) {
            creativeInfo.mo19425n(a);
            Logger.m3601d(this.f2908B, "will update clickUrl: " + a);
        } else {
            Logger.m3601d(this.f2908B, "clickUrl is empty");
        }
        if (b2 == null || aVar.mo19374r()) {
            Logger.m3601d(this.f2908B, "videoUrl is empty");
        } else {
            creativeInfo.mo19417j(b2);
            Logger.m3601d(this.f2908B, "will update videoUrl : " + b2);
            if (C1361h.m3713k(b2)) {
                String l = C1361h.m3714l(b2);
                Logger.m3601d(this.f2908B, "Google video added : " + l);
                this.f2910t.put(l, creativeInfo);
            } else {
                Logger.m3601d(this.f2908B, "video added : " + b2);
                this.f2910t.put(b2, creativeInfo);
            }
        }
        List<String> j = aVar.mo19366j();
        if (j != null) {
            for (String a2 : j) {
                String a3 = mo19329a(a2, creativeInfo);
                if (a3 != null) {
                    Logger.m3601d(this.f2908B, "will add followUrl : " + a3);
                    this.f2910t.put(a3, creativeInfo);
                }
            }
            creativeInfo.mo19397b(j);
        } else {
            Logger.m3601d(this.f2908B, "prefetchResourceUrls is empty");
        }
        List<String> k = aVar.mo19367k();
        creativeInfo.mo19400c(k);
        Logger.m3601d(this.f2908B, "added static resource : " + k);
        List<String> l2 = aVar.mo19368l();
        creativeInfo.mo19400c(l2);
        Logger.m3601d(this.f2908B, "added iframe resource : " + l2);
        List<String> m = aVar.mo19369m();
        creativeInfo.mo19400c(m);
        Logger.m3601d(this.f2908B, "added html resource : " + m);
        if (aVar.mo19374r()) {
            creativeInfo.mo19389H();
            Logger.m3601d(this.f2908B, "set params " + aVar.mo19362f());
            creativeInfo.mo19443v(aVar.mo19362f());
        }
        List<String> h = aVar.mo19364h();
        if (h != null) {
            Logger.m3601d(this.f2908B, "Vast media list contains " + h.toString());
            for (String a4 : h) {
                String a5 = mo19329a(a4, creativeInfo);
                if (a5 != null) {
                    Logger.m3601d(this.f2908B, "will add followUrl : " + a5);
                    this.f2910t.put(a5, creativeInfo);
                }
            }
            creativeInfo.mo19400c(h);
        } else {
            Logger.m3601d(this.f2908B, "prefetchResourceUrls is empty");
        }
        Logger.m3601d(this.f2908B, "updated vast ci = " + creativeInfo);
        return true;
    }

    
    /* renamed from: d */
    public void mo19340d(String str, String str2) {
    }

    
    /* renamed from: l */
    public void mo19345l(String str) {
    }

    
    /* renamed from: a */
    public String mo19334a(String str, Set<String> set) {
        if (set != null && set.size() > 0) {
            for (String e : set) {
                str = C1361h.m3706e(str, e);
            }
        }
        return str;
    }

    
    /* renamed from: b */
    public String mo19338b(String str, Set<String> set) {
        if (str == null) {
            return str;
        }
        if (set != null && set.size() > 0) {
            for (String next : set) {
                str = m3165f(m3165f(str, next), next);
            }
        }
        String trim = str.trim();
        if (trim.endsWith(";") || trim.endsWith("&")) {
            return trim.substring(0, trim.length() - 1);
        }
        return trim;
    }

    /* renamed from: f */
    private static String m3165f(String str, String str2) {
        return str.replaceAll("([?&;]+)(" + str2 + "=.*?)(&|$|;)", "$1");
    }

    
    /* renamed from: c */
    public Set<String> mo19339c(String str, Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Map<String, String> a = C1361h.m3682a(str, false);
        if (a != null) {
            for (Map.Entry next : a.entrySet()) {
                if (set.contains(next.getValue())) {
                    Logger.m3601d(this.f2908B, "Identified macro : " + ((String) next.getValue()));
                    hashSet.add(next.getKey());
                }
            }
        }
        Logger.m3601d(this.f2908B, "query params to ignore are " + hashSet.toString());
        return hashSet;
    }

    
    /* renamed from: a */
    public boolean mo19337a(CreativeInfo creativeInfo, String str, String str2, boolean z) {
        Logger.m3607v(this.f2908B, "Updating vast creative info, ci=" + creativeInfo.toString() + ", vastXml=" + str2 + ", scanForResources=" + z);
        C1361h.m3694b(this.f2908B, "vast xml : " + str2);
        boolean z2 = CreativeInfoManager.m3105g(creativeInfo.mo19383B()).getBoolean(AdNetworkDiscovery.f2645b);
        Logger.m3601d(this.f2908B, "sdk " + creativeInfo.mo19383B() + " config item CONFIGURATION_SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST is " + z2);
        return mo19336a(creativeInfo, C1317f.m3211c(str2, z2), str);
    }

    
    /* renamed from: e */
    public void mo19341e(String str, String str2) {
        SdksMapping.updateSdkVersionIfNeeded(str, str2);
    }

    /* renamed from: c */
    public Set<String> mo19305c() {
        HashSet hashSet = new HashSet();
        hashSet.add("CONTENTCAT");
        hashSet.add("PLAYBACKMETHODS");
        hashSet.add("STOREID");
        hashSet.add("STOREURL");
        hashSet.add("CACHEBUSTING");
        hashSet.add("TIMESTAMP");
        hashSet.add("ADCATEGORIES");
        hashSet.add("ADCOUNT");
        hashSet.add("ADTYPE");
        hashSet.add("BLOCKEDADCATEGORIES");
        hashSet.add("BREAKMAXADLENGTH");
        hashSet.add("BREAKMAXADS");
        hashSet.add("BREAKMAXDURATION");
        hashSet.add("BREAKMINADLENGTH");
        hashSet.add("BREAKPOSITION");
        hashSet.add("CONTENTPLAYHEAD");
        hashSet.add("MEDIAPLAYHEAD");
        hashSet.add("PLACEMENTTYPE");
        hashSet.add("TRANSACTIONID");
        hashSet.add("UNIVERSALADID");
        hashSet.add("CLIENTUA");
        hashSet.add("DEVICEIP");
        hashSet.add("DEVICEUA");
        hashSet.add("IFA");
        hashSet.add("IFATYPE");
        hashSet.add("LATLONG");
        hashSet.add("SERVERSIDE");
        hashSet.add("SERVERUA");
        hashSet.add("APPBUNDLE");
        hashSet.add("DOMAIN");
        hashSet.add("PAGEURL");
        hashSet.add("APIFRAMEWORKS");
        hashSet.add("CLICKTYPE");
        hashSet.add("EXTENSIONS");
        hashSet.add("MEDIAMIME");
        hashSet.add("OMIDPARTNER");
        hashSet.add("PLAYERCAPABILITIES");
        hashSet.add("VASTVERSIONS");
        hashSet.add("VERIFICATIONVENDORS");
        hashSet.add("ADPLAYHEAD");
        hashSet.add("ADSERVINGID");
        hashSet.add("ASvastMacroQueryParams.RI");
        hashSet.add("CONTENTID");
        hashSet.add("CONTENTURI");
        hashSet.add("INVENTORYSTATE");
        hashSet.add("PLAYERSIZE");
        hashSet.add("PLAYERSTATE");
        hashSet.add("PODSEQUENCE");
        hashSet.add("CLICKPOS");
        hashSet.add("ERRORCODE");
        hashSet.add("REASON");
        hashSet.add("GDPRCONSENT");
        hashSet.add("LIMITADTRACKING");
        hashSet.add("REGULATIONS");
        return hashSet;
    }

    /* renamed from: d */
    public Bundle mo19308d() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(AdNetworkDiscovery.f2644a, false);
        bundle.putBoolean(AdNetworkDiscovery.f2645b, true);
        bundle.putBoolean(AdNetworkDiscovery.f2646c, true);
        bundle.putBoolean(AdNetworkDiscovery.f2647d, false);
        bundle.putBoolean(AdNetworkDiscovery.f2648e, false);
        bundle.putFloat("CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT", 0.15f);
        bundle.putFloat(AdNetworkDiscovery.f2650g, 0.15f);
        bundle.putFloat("CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT", 0.15f);
        bundle.putFloat(AdNetworkDiscovery.f2652i, 0.15f);
        bundle.putBoolean(AdNetworkDiscovery.f2653j, false);
        bundle.putBoolean(AdNetworkDiscovery.f2654k, false);
        bundle.putBoolean(AdNetworkDiscovery.f2655l, false);
        bundle.putBoolean(AdNetworkDiscovery.f2656m, false);
        bundle.putBoolean(AdNetworkDiscovery.f2657n, false);
        bundle.putBoolean(AdNetworkDiscovery.f2659p, false);
        return bundle;
    }

    protected C1315d(String str, String str2) {
        f2902A = str;
        this.f2908B = str2;
        try {
            this.f2909s = new PersistentConcurrentHashMap(this.f2908B + "_vastAdTagUriUrlsToFollow");
            Logger.m3601d(this.f2908B, "vastAdTagUriUrlsToFollow loaded, keyset=" + this.f2909s.keySet());
            this.f2910t = new PersistentConcurrentHashMap(this.f2908B + "_vastMediaUrlsToFollow");
            Logger.m3601d(this.f2908B, "vastMediaUrlsToFollow loaded, keyset=" + this.f2910t.keySet());
        } catch (InvalidParameterException e) {
            Logger.m3604e(this.f2908B, "Error initializing caching will not be available", e);
        }
    }

    private C1315d() {
    }

    
    /* renamed from: m */
    public boolean mo19346m(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(".mp4") || lowerCase.endsWith(".webm") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".webp");
    }

    /* renamed from: n */
    public String mo19347n(String str) {
        try {
            return URLDecoder.decode(str, XmpWriter.UTF8);
        } catch (UnsupportedEncodingException e) {
            Logger.m3601d(this.f2908B, "Exception decoding url. msg=" + e.getMessage() + ". url=" + str);
            return str;
        } catch (Throwable th) {
            Logger.m3601d(this.f2908B, "Exception decoding url. msg=" + th.getMessage() + ". url=" + str);
            return str;
        }
    }

    /* renamed from: a */
    public void mo19297a(String str, String str2, String str3, String str4) {
    }

    /* renamed from: f */
    public boolean mo19310f(String str) {
        return this.f2909s.containsKey(str);
    }
}

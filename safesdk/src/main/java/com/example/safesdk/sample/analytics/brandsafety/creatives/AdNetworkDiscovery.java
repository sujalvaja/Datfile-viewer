package com.example.safesdk.sample.analytics.brandsafety.creatives;

import android.os.Bundle;
import android.util.Pair;
import com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.C1313c;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AdNetworkDiscovery {

    /* renamed from: a */
    public static  String f2644a = "CONFIGURATION_SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN";

    /* renamed from: b */
    public static  String f2645b = "CONFIGURATION_SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST";

    /* renamed from: c */
    public static  String f2646c = "CONFIGURATION_SHOULD_UPDATE_CREATIVE_INFO_FROM_VAST";

    /* renamed from: d */
    public static  String f2647d = "CONFIGURATION_SUPPORTS_GZIP_CONTENT";

    /* renamed from: e */
    public static  String f2648e = "CONFIGURATION_SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION";

    /* renamed from: f */
    public static  String f2649f = "CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT";

    /* renamed from: g */
    public static  String f2650g = "CONFIGURATION_BITMAP_SCAN_RIGHT_MARGIN_PERCENT";

    /* renamed from: h */
    public static  String f2651h = "CONFIGURATION_BITMAP_SCAN_TOP_MARGIN_PERCENT";

    /* renamed from: i */
    public static  String f2652i = "CONFIGURATION_BITMAP_SCAN_LEFT_MARGIN_PERCENT";

    /* renamed from: j */
    public static  String f2653j = "CONFIGURATION_BITMAP_SCAN_SHOULD_CHECK_ADDITIONAL_BITMAP_ATTRIBUTES";

    /* renamed from: k */
    public static  String f2654k = "CONFIGURATION_ENFORCE_CLOSE_INPUT_STREAM_VAST_IN_VAST";

    /* renamed from: l */
    public static  String f2655l = "CONFIGURATION_ENFORCE_CLOSE_INPUT_STREAM";

    /* renamed from: m */
    public static  String f2656m = "CONFIGURATION_SUPPORTS_BANNER_IMPRESSION_COLLECTION";

    /* renamed from: n */
    public static  String f2657n = "CONFIGURATION_SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION";

    /* renamed from: o */
    public static  String f2658o = "CONFIGURATION_JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT";

    /* renamed from: p */
    public static  String f2659p = "CONFIGURATION_SHOULD_MATCH_PENDING_CI_USING_PLACEMENT_ID";

    /* renamed from: q */
    public static  float f2660q = 0.15f;

    public enum WebViewResourceMatchingMethod {
        DEFAULT,
        DIRECT_CREATIVE_INFO,
        WEBVIEW_LOOKUP
    }

    /* renamed from: a */
    Pair<String, List<String>> mo19290a(Set<String> set);

    /* renamed from: a */
    CreativeInfo mo19291a(Object obj);

    /* renamed from: a */
    String mo19292a(String str, String str2);

    /* renamed from: a */
    List<CreativeInfo> mo19293a(String str, String str2, Map<String, List<String>> map, C1313c.C1314a aVar);

    /* renamed from: a */
    void mo19294a(FileInputStream fileInputStream, FileDescriptor fileDescriptor);

    /* renamed from: a */
    void mo19295a(FileInputStream fileInputStream, String str);

    /* renamed from: a */
    void mo19296a(Object obj, Object obj2);

    /* renamed from: a */
    void mo19297a(String str, String str2, String str3, String str4);

    /* renamed from: a */
    boolean mo19298a();

    /* renamed from: a */
    boolean mo19299a(String str);

    /* renamed from: b */
    WebViewResourceMatchingMethod mo19300b();

    /* renamed from: b */
    String mo19301b(Object obj);

    /* renamed from: b */
    void mo19302b(String str, String str2);

    /* renamed from: b */
    boolean mo19303b(String str);

    /* renamed from: c */
    String mo19304c(String str, String str2);

    /* renamed from: c */
    Set<String> mo19305c();

    /* renamed from: c */
    boolean mo19306c(String str);

    /* renamed from: d */
    int mo19307d(String str);

    /* renamed from: d */
    Bundle mo19308d();

    /* renamed from: e */
    String mo19309e(String str);

    /* renamed from: f */
    boolean mo19310f(String str);
}

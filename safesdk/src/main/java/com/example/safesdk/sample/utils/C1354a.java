package com.example.safesdk.sample.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.example.safesdk.sample.analytics.brandsafety.BrandSafetyUtils;

/* renamed from: com.example.safesdk.sample.utils.a */
public class C1354a {

    /* renamed from: a */
    private static  String f3584a = "DebugUtils";

    /* renamed from: a */
    public static void m3619a(String str, ViewGroup viewGroup, String str2, String str3) {
        try {
            int childCount = viewGroup.getChildCount();
            int length = (childCount + "").length();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                String str4 = childAt.getClass().getSimpleName() + " " + Integer.toHexString(childAt.getId());
                String str5 = "|— %0" + length + "d/%0" + length + "d %s";
                Logger.m3601d(str, str2 + String.format(str5, new Object[]{Integer.valueOf(i + 1), Integer.valueOf(childCount), str4}));
                if (childAt instanceof WebView) {
                    Logger.m3601d(f3584a, "WebView found, address = " + BrandSafetyUtils.m2922j(((WebView) childAt).toString()));
                }
                if (childAt instanceof ViewGroup) {
                    m3619a(str, (ViewGroup) childAt, str2 + "  ", str3);
                }
            }
        } catch (Throwable th) {
            Logger.m3604e(f3584a, "Exception in printViewHierarchy", th);
        }
    }

    /* renamed from: a */
    public static void m3618a(View view) {
        try {
            Logger.m3601d(f3584a, "getViewDetails started, View type is " + view.getClass().getName() + ", Id=" + Integer.toHexString(view.getId()));
            if (view.getParent() == null) {
                return;
            }
            if (view.getParent() instanceof View) {
                m3618a((View) view.getParent());
            } else {
                Log.d(f3584a, "getViewDetails parent is ViewParent, view : " + view.getId() + ", View type is " + view.getClass().getName());
            }
        } catch (Throwable th) {
            Logger.m3604e(f3584a, "Exception in getViewDetails", th);
        }
    }
}

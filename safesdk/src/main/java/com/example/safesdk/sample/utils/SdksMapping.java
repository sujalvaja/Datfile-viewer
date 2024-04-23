package com.example.safesdk.sample.utils;

import android.os.Bundle;

import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.creatives.discoveries.C1313c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SdksMapping {
    private static  String AD_COLONY_ADAPTER_CLASS_NAME = "com.applovin.mediation.adapters.AdColonyMediationAdapter";
    public static  String KEY_INSTALLED_MEDIATION_ADAPTERS = "installed_mediation_adapters";
    public static  String KEY_INSTALLED_MEDIATION_ADAPTERS_CLASS = "class";
    public static  String KEY_INSTALLED_MEDIATION_ADAPTERS_SDK_VERSION = "sdk_version";
    public static  String KEY_INSTALLED_MEDIATION_ADAPTERS_VERSION = "version";
    private static  String TAG = "SdksMapping";
    private static Set<String> redirectSupportedSdks;
    private static TreeMap<String, String> sdkAdaptersUUID = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackageToName = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackageToUUID = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackageUUIDToVersion = new TreeMap<>(Collections.reverseOrder());
    private static TreeMap<String, String> sdkPackages = new TreeMap<>(Collections.reverseOrder());
    private static boolean topicSdkVersionsUpdated;

    static {
        sdkPackageToName.put(C1357d.f3603k, "AdMob");
      //  sdkPackages.put("com.google.android.gms.internal.ads", C1357d.f3603k);
       // sdkPackages.put(MobileAds.ERROR_DOMAIN, C1357d.f3603k);
        sdkPackageToUUID.put(C1357d.f3603k, "29015bbfcc182d80e7f75bd2c38e4521");
        sdkPackages.put(C1357d.f3603k, C1357d.f3603k);
        sdkAdaptersUUID.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "29015bbfcc182d80e7f75bd2c38e4521");
        sdkPackageToName.put(C1357d.f3593a, "AppLovin");
        sdkPackageToUUID.put(C1357d.f3593a, "74616804a7dc29147dfb0afe122a9fd2");
        sdkPackages.put(C1357d.f3593a, C1357d.f3593a);
        sdkAdaptersUUID.put(C1313c.f2892r, "74616804a7dc29147dfb0afe122a9fd2");
    }

    public static TreeMap<String, String> getSdkAdaptersUUID() {
        return sdkAdaptersUUID;
    }

    public static void setTopicSdkVersionsUpdated() {
        topicSdkVersionsUpdated = true;
        Logger.m3601d(TAG, "setTopicSdkVersionsUpdated SdkUUIDByPackage=" + sdkPackageToUUID.toString());
        Logger.m3601d(TAG, "setTopicSdkVersionsUpdated redirectSupprotedSdks=" + redirectSupportedSdks.toString());
    }

    public static boolean isTopicSdkVersionsUpdated() {
        Logger.m3601d(TAG, "isTopicSdkVersionsUpdated=" + topicSdkVersionsUpdated);
        return topicSdkVersionsUpdated;
    }

    public static void init() {
        printAllSdkVersions();
    }

    public static String getSdkPackageByClass(String className) {
        for (String next : sdkPackages.keySet()) {
            if (className.startsWith(next)) {
                return sdkPackages.get(next);
            }
        }
        return null;
    }

    public static String getSdkNameByPackage(String packageName) {
        return sdkPackageToName.get(packageName);
    }

    public static String getSdkUUIDByPackage(String packageName) {
        if (SafeDK.f2298a.equals(packageName)) {
            return packageName;
        }
        return sdkPackageToUUID.get(packageName);
    }

    public static String getSdkVersionByPackage(String packageName) {
        String sdkUUIDByPackage = getSdkUUIDByPackage(packageName);
        if (sdkUUIDByPackage != null) {
            return sdkPackageUUIDToVersion.get(sdkUUIDByPackage);
        }
        return null;
    }

    public static Set<String> getAllSdkNames() {
        return new HashSet(sdkPackageToName.values());
    }

    public static Map<String, String> getAllSdkVersionsMap() {
        return sdkPackageUUIDToVersion;
    }

    public static void printAllSdkVersions() {
        Logger.m3601d(TAG, "printAllSdkVersions sdkPackages=" + sdkPackages.toString());
        Logger.m3601d(TAG, "printAllSdkVersions sdkPackageToName=" + sdkPackageToName.toString());
        Logger.m3601d(TAG, "printAllSdkVersions sdkPackageToUUID=" + sdkPackageToUUID.toString());
        Logger.m3601d(TAG, "printAllSdkVersions sdkPackageUUIDToVersion=" + sdkPackageUUIDToVersion.toString());
        Logger.m3601d(TAG, "printAllSdkVersions sdkAdaptersUUID=" + sdkAdaptersUUID.toString());
        Logger.m3601d(TAG, "printAllSdkVersions sdks detected: " + sdkPackageToName.entrySet().size() + " sdks with versions: " + sdkPackageUUIDToVersion.entrySet().size());
        for (Map.Entry<String, String> key : sdkPackageToName.entrySet()) {
            String str = (String) key.getKey();
            Logger.m3601d(TAG, String.format("printAllSdkVersions sdkPackage: %s, version: %s", new Object[]{str, sdkPackageUUIDToVersion.get(str)}));
        }
    }

    public static Set<String> getAllSdkPackages() {
        return sdkPackageToName.keySet();
    }

    public static boolean isSameSdkByPackages(String package1, String package2) {
        if (package1 == null || package2 == null) {
            return false;
        }
        String sdkNameByPackage = getSdkNameByPackage(package1);
        String sdkNameByPackage2 = getSdkNameByPackage(package2);
        if (sdkNameByPackage == null || sdkNameByPackage2 == null) {
            return false;
        }
        if (sdkNameByPackage.equals(sdkNameByPackage2)) {
            return true;
        }
        if (sdkNameByPackage.regionMatches(false, 0, sdkNameByPackage2, 0, 5)) {
            return true;
        }
        return false;
    }

    public static void updateSdkVersionIfNeeded(String className, String version) {
        Logger.m3601d(TAG, "updateSdkVersionIfNeeded started, sdk=" + className + " , version=" + version);
        if (isTopicSdkVersionsUpdated()) {
            Logger.m3601d(TAG, "updateSdkVersionIfNeeded Sdk configuration already updated. exiting");
        } else if (sdkAdaptersUUID.containsKey(className)) {
            String str = sdkAdaptersUUID.get(className);
            Logger.m3601d(TAG, "UUID for class " + className + " is " + str);
            if (!sdkPackageUUIDToVersion.containsKey(str) || (sdkPackageUUIDToVersion.containsKey(str) && version != null && version.length() > 0 && !sdkPackageUUIDToVersion.get(str).equals(version))) {
                sdkPackageUUIDToVersion.put(str, version);
                Logger.m3601d(TAG, "updateSdkVersionIfNeeded sdkPackageToVersion for class " + className + " (uuid " + str + ") updated to " + version);
            }
            if (redirectSupportedSdks == null) {
                redirectSupportedSdks = new HashSet();
            }
            if (sdkAdaptersUUID.values().contains(str)) {
                Logger.m3601d(TAG, "Adding " + className + " , packageUUID " + str + " to redirect supported sdks");
                redirectSupportedSdks.add(str);
            } else {
                Logger.m3601d(TAG, "Not Adding " + className + " , packageUUID " + str + " to redirect supported sdks");
            }
            Logger.m3601d(TAG, "getRedirectSupportedSdks : " + getRedirectSupportedSdks().toString());
        } else {
            Logger.m3601d(TAG, "Cannot find UUID for package " + className);
        }
    }

    public static void setMaxAdapterVersions(Bundle bundle) {
        try {
            Logger.m3601d(TAG, "getMaxAdapterVersions started, Bundle = " + bundle);
            init();
            if (bundle.containsKey(KEY_INSTALLED_MEDIATION_ADAPTERS)) {
                Logger.m3601d(TAG, "getMaxAdapterVersions processing " + KEY_INSTALLED_MEDIATION_ADAPTERS.toUpperCase());
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_INSTALLED_MEDIATION_ADAPTERS);
                if (parcelableArrayList != null) {
                    Iterator it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        Bundle bundle2 = (Bundle) it.next();
                        String string = bundle2.getString("class");
                        String string2 = bundle2.getString("sdk_version");
                        Logger.m3601d(TAG, "getMaxAdapterVersions className = " + string);
                        Logger.m3601d(TAG, "getMaxAdapterVersions classVersion = " + string2);
                        if (string2 != null && string2.length() > 0) {
                            updateSdkVersionIfNeeded(string, string2);
                        } else if (string.equals(AD_COLONY_ADAPTER_CLASS_NAME)) {
                            String string3 = bundle2.getString(KEY_INSTALLED_MEDIATION_ADAPTERS_VERSION);
                            Logger.m3601d(TAG, "getMaxAdapterVersions ad colony adapter version special handling. version is " + string3);
                            updateSdkVersionIfNeeded(string, string3);
                        } else {
                            Logger.m3601d(TAG, "getMaxAdapterVersions adapter sdk_version field is empty for class " + string);
                        }
                        Logger.m3601d(TAG, "getRedirectSupportedSdks for className " + string + " : " + getRedirectSupportedSdks().contains(string));
                    }
                    setTopicSdkVersionsUpdated();
                } else {
                    Logger.m3601d(TAG, "extracting value for key installed_mediation_adapters produced null value, skipping");
                }
                printAllSdkVersions();
                return;
            }
            Logger.m3601d(TAG, "getMaxAdapterVersions No adapter class version received from MAX");
        } catch (Throwable th) {
            Logger.m3604e(TAG, "getMaxAdapterVersions Exception extracting " + KEY_INSTALLED_MEDIATION_ADAPTERS.toUpperCase(), th);
        }
    }

    public static Set<String> getRedirectSupportedSdks() {
        Logger.m3601d(TAG, "getRedirectSupportedSdks started,sdkAdaptersUUID=" + sdkAdaptersUUID.values());
        if (!isTopicSdkVersionsUpdated()) {
            return new HashSet(sdkAdaptersUUID.values());
        }
        return redirectSupportedSdks;
    }
}

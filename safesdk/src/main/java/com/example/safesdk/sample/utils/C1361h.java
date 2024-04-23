package com.example.safesdk.sample.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.webkit.MimeTypeMap;

import com.itextpdf.text.xml.xmp.XmpWriter;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.creatives.C1308d;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.example.safesdk.sample.utils.h */
public class C1361h {

    /* renamed from: a */
    public static  String f3646a = "UNKNOWN_PROCESS";

    /* renamed from: b */
    public static  String f3647b = "Accept";

    /* renamed from: c */
    static Map<String, String> f3648c = new Utils$1();

    /* renamed from: d */
    private static  String f3649d = "Utils";

    /* renamed from: e */
    private static boolean f3650e = false;

    /* renamed from: f */
    private static boolean f3651f = false;

    /* renamed from: g */
    private static  String f3652g = "com.applovin.sdk.AppLovinSdk";

    /* renamed from: h */
    private static  String f3653h = "VERSION";

    /* renamed from: i */
    private static  String f3654i = "video/";

    /* renamed from: j */
    private static  String[] f3655j = {"jpg", "jpeg", "gif", "png", "mp4", "m4v", "js", "css", "html", "mkv", "3gp", "3gpp", "webm", "mp3", "htm", "svg", "3g2", "avi", "mpg", "mpeg", "mov", "qt", "zip", "webp"};

    /* renamed from: k */
    private static  HashSet<String> f3656k = new HashSet<>(Arrays.asList(f3655j));

    /* renamed from: l */
    private static  String[] f3657l = {CreativeInfo.f2992v};

    /* renamed from: m */
    private static  HashSet<String> f3658m = new HashSet<>(Arrays.asList(f3657l));

    /* renamed from: n */
    private static  String f3659n = "https://www.youtube.com/watch?v=";

    /* renamed from: o */
    private static  Pattern f3660o = Pattern.compile("(https?:\\\\?\\/\\\\?\\/.*?)(?:;frame-src|(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)|(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)|(?:%5B|\\\\*x5B|\\[)|(?:%5D|\\\\*x5D|\\])|\\))");

    /* renamed from: p */
    private static  Pattern f3661p = Pattern.compile("(https?:\\\\?\\/\\\\?\\/.*?)(?:;frame-src|(?:\\\\*x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)|(?:%3C|\\\\*x3c|<|&lt;|&amp;lt;)|(?:%3E|\\\\*x3e|>|&gt;|&amp;gt;)|\\s?(?:%5D|\\\\*x5D|\\]){2})");

    /* renamed from: q */
    private static  Pattern f3662q = Pattern.compile("(https?:\\/\\/.*?).googlevideo.com\\/videoplayback");

    /* renamed from: r */
    private static  Pattern f3663r = Pattern.compile("data:([a-zA-Z]*\\/[a-zA-Z1-9]*);?([\\s\\S]*?;)base64,([^\\\"\\')]*)");

    /* renamed from: s */
    private static String f3664s;

    /* renamed from: t */
    private static  String[] f3665t = {"expire", "ei", "sig", "lsig", "mt", "lmt", "cpn"};

    /* renamed from: u */
    private static  String[] f3666u = {"mp4", "m4v", "mkv", "3gp", "3gpp", "webm", "mov", "webp"};

    /* renamed from: v */
    private static  String[] f3667v = {"jpg", "jpeg", "gif", "png", "mp4", "m4v", "mkv", "3gp", "3gpp", "webm", "mp3", "htm", "svg", "3g2", "avi", "mpg", "mpeg", "mov", "qt", "zip", "webp"};

    /* renamed from: w */
    private static  Map<String, String> f3668w = new HashMap();

    static {
        f3668w.put("market://details?id=", "https://play.google.com/store/apps/details?id=");
        f3668w.put("amzn://apps/android?p=", "https://www.amazon.com/gp/mas/dl/android?p=");
        f3668w.put("samsungapps://ProductDetail/", "https://www.samsungapps.com/appquery/appDetail.as?appId=");
        f3668w.put("http://play.google.com/store/apps/details?id=", "http://play.google.com/store/apps/details?id=");
    }

    /* renamed from: a */
    public static String m3670a() {
        if (f3664s == null) {
            f3664s = m3675a(f3652g, f3653h);
        }
        return f3664s;
    }

    /* renamed from: a */
    public static Object m3669a(Object obj, String str) {
        Object obj2 = null;
        try {
            Field a = m3680a((Class) obj.getClass(), str);
            a.setAccessible(true);
            obj2 = a.get(obj);
            Logger.m3601d("reflection", str + " = " + obj2);
            return obj2;
        } catch (NoSuchFieldException e) {
            Logger.m3609w(f3649d, "Failed to get reflection field:" + str);
            return obj2;
        } catch (Exception e2) {
            Logger.m3604e(f3649d, "Failed to get reflection field value", e2);
            return obj2;
        }
    }

    /* renamed from: b */
    public static Object m3691b(Object obj, String str) {
        try {
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            if (declaredFields == null) {
                return null;
            }
            for (Field field : declaredFields) {
                if (field.getType().getName().contains(str)) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    Logger.m3601d("reflection", field.getName() + "," + field.getType().getName() + " = " + obj2);
                    return obj2;
                }
            }
            return null;
        } catch (Exception e) {
            Logger.m3604e(f3649d, "Failed to get reflection field value", e);
            return null;
        }
    }

    /* renamed from: a */
    private static Field m3680a(Class cls, String str) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                return m3680a(superclass, str);
            }
            throw e;
        }
    }

    /* renamed from: a */
    public static String m3675a(String str, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            if (declaredField.isAccessible()) {
                return (String) declaredField.get((Object) null);
            }
            return "";
        } catch (NoSuchFieldException e) {
            Logger.m3604e(f3649d, "Error retrieving field value. Class name :" + str + ", field name :" + str2, e);
            return null;
        } catch (SecurityException e2) {
            Logger.m3604e(f3649d, "Error retrieving field value. Class name :" + str + ", field name :" + str2, e2);
            return null;
        } catch (IllegalArgumentException e3) {
            Logger.m3604e(f3649d, "Error retrieving field value. Class name :" + str + ", field name :" + str2, e3);
            return null;
        } catch (IllegalAccessException e4) {
            Logger.m3604e(f3649d, "Error retrieving field value. Class name :" + str + ", field name :" + str2, e4);
            return null;
        } catch (ClassNotFoundException e5) {
            Logger.m3602d(f3649d, "Error retrieving field value. Class name :" + str + ", field name :" + str2, e5);
            return null;
        }
    }

    /* renamed from: c */
    public static Object m3697c(Object obj, String str) {
        Object obj2 = null;
        try {
            Method method = obj.getClass().getMethod(str, new Class[0]);
            method.setAccessible(true);
            obj2 = method.invoke(obj, new Object[0]);
            Logger.m3601d("reflection", str + " " + obj2);
            return obj2;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return obj2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return obj2;
        }
    }

    /* renamed from: b */
    public static long m3689b() {
        return m3666a(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static long m3666a(long j) {
        return (j / 60000) * 60;
    }

    /* renamed from: b */
    public static long m3690b(long j) {
        return j / 1000;
    }

    /* renamed from: a */
    public static boolean m3688a(ArrayList<StatsEvent> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            StatsEvent statsEvent = arrayList.get(i);
            StatsEvent statsEvent2 = arrayList.get(i + 1);
            int c = statsEvent.compareTo(statsEvent2);
            if (c > 0) {
                Logger.m3603e(f3649d, "failed sort. first: " + statsEvent + " second: " + statsEvent2);
                Logger.m3603e(f3649d, "compare score: " + c);
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m3673a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, XmpWriter.UTF8);
            char[] cArr = new char[65536];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.m3604e(f3649d, "Failed to read configuration from input stream", e);
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static long m3696c(long j) {
        return (j / 60) * 60000;
    }

    /* renamed from: a */
    public static String m3671a(Context context) {
        String str;
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
        }
        str = "";
        if (str.equals("")) {
            return f3646a;
        }
        return str;
    }

    /* renamed from: a */
    public static String m3674a(String str) {
        String str2 = f3648c.get(str);
        if (TextUtils.isEmpty(str2)) {
            return m3726x(str);
        }
        return str2;
    }

    /* renamed from: x */
    private static String m3726x(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    /* renamed from: a */
    public static DisplayMetrics m3667a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        } catch (Throwable th) {
            Logger.m3603e(f3649d, "error during display metrics extraction");
        }
        return displayMetrics;
    }

    /* renamed from: b */
    public static Map<String, String> m3693b(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, (String) jSONObject.get(next));
                }
            } catch (JSONException e) {
                Logger.m3604e(f3649d, "exception while parsing json string to map", e);
                return null;
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m3684a(Map<String, String> map) {
        try {
            return new JSONObject(map.toString());
        } catch (JSONException e) {
            Logger.m3604e(f3649d, "exception while parsing map to JSON object", e);
            return null;
        }
    }

    /* renamed from: b */
    public static void m3694b(String str, String str2) {
        int length = str2.length() / 4000;
        for (int i = 0; i <= length; i++) {
            int i2 = (i + 1) * 4000;
            if (i2 >= str2.length()) {
                i2 = str2.length();
            }
            Logger.m3607v(str, str2.substring(i * 4000, i2));
        }
    }

    /* renamed from: c */
    public static String m3699c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Map<String, String> a = m3682a(str, true);
            if (a == null || !a.containsKey(str2)) {
                Logger.m3601d(f3649d, "map is null or does not contain param  " + str2 + ", url = " + str);
                return null;
            }
            Logger.m3601d(f3649d, "param " + str2 + " value is " + a.get(str2));
            return a.get(str2);
        } catch (Throwable th) {
            Logger.m3604e(f3649d, "Exception in getQueryParamDecoded : " + th.getMessage(), th);
        }
        return str;
    }

    /* renamed from: d */
    public static String m3703d(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, String> a = m3682a(str, true);
        if (a == null || !a.containsKey(str2)) {
            Logger.m3601d(f3649d, "map is null or does not contain param  " + str2 + ", url = " + str);
            return null;
        }
        Logger.m3601d(f3649d, "param " + str2 + " value is " + a.get(str2));
        return a.get(str2);
    }

    /* renamed from: a */
/*
    public static Map<String, String> m3682a(String str, boolean z) {
        LinkedHashMap linkedHashMap;
        String str2;
        String str3;
        try {
            if (!str.contains("?")) {
                return null;
            }
            linkedHashMap = new LinkedHashMap();
            try {
                for (String str4 : str.substring(str.indexOf("?") + 1).split("&")) {
                    int indexOf = str4.indexOf("=");
                    if (indexOf != -1) {
                        String substring = str4.substring(0, indexOf);
                        if (z) {
                            str2 = URLDecoder.decode(substring, XmpWriter.UTF8);
                        } else {
                            str2 = substring;
                        }
                        if (indexOf + 1 < str4.length()) {
                            str3 = str4.substring(indexOf + 1);
                            if (z) {
                                str3 = URLDecoder.decode(str3, XmpWriter.UTF8);
                            }
                        } else {
                            str3 = null;
                        }
                        linkedHashMap.put(str2, str3);
                    }
                }
                return linkedHashMap;
            } catch (UnsupportedEncodingException e) {
                e = e;
                Logger.m3604e(f3649d, "UnsupportedEncodingException in splitQuery, url = " + str, e);
                return linkedHashMap;
            } catch (Throwable th) {
                th = th;
                Logger.m3604e(f3649d, "Exception in splitQuery, url = " + str, th);
                return linkedHashMap;
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            linkedHashMap = null;
            Logger.m3604e(f3649d, "UnsupportedEncodingException in splitQuery, url = " + str, e);
            return linkedHashMap;
        } catch (Throwable th2) {
            th = th2;
            linkedHashMap = null;
            Logger.m3604e(f3649d, "Exception in splitQuery, url = " + str, th);
            return linkedHashMap;
        }
    }
*/

    /* renamed from: a */
    public static boolean m3687a(String str, Map<String, String> map) {
        Logger.m3601d(f3649d, "shouldIncludeResourceUrl resource=" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        Logger.m3601d(f3649d, "shouldIncludeResourceUrl extension: " + fileExtensionFromUrl + " for url: " + str);
        if (f3656k.contains(fileExtensionFromUrl) || str.toLowerCase().startsWith(f3659n.toLowerCase())) {
            Logger.m3601d(f3649d, "shouldIncludeResourceUrl resourceUrl extension match :" + str);
            return true;
        } else if (str.startsWith("data:") || str.startsWith("about:")) {
            Logger.m3601d(f3649d, "shouldIncludeResourceUrl resourceUrl excluded :" + str);
            return false;
        } else if (map == null) {
            return false;
        } else {
            Logger.m3601d(f3649d, "shouldIncludeResourceUrl requestHeaders=" + map.keySet());
            if (map.containsKey(f3647b)) {
                String str2 = map.get(f3647b);
                Logger.m3601d(f3649d, "shouldIncludeResourceUrl 'Accept' header value is " + str2);
                if (str2 == null || str2.length() <= 0) {
                    Logger.m3601d(f3649d, "shouldIncludeResourceUrl 'accept' header is empty");
                    return false;
                } else if (!str2.contains(f3654i) && !m3728z(str2) && !m3664A(str2)) {
                    return false;
                } else {
                    Logger.m3601d(f3649d, "shouldIncludeResourceUrl 'Accept' header contains resource mime types. url=" + str + " , Accept header value =" + str2);
                    return !m3727y(str);
                }
            } else {
                Logger.m3601d(f3649d, "shouldIncludeResourceUrl 'accept' header not found");
                return false;
            }
        }
    }

    /* renamed from: y */
    private static boolean m3727y(String str) {
        for (String contains : C1308d.m3122a().get(C1308d.f2815c)) {
            if (str.contains(contains)) {
                Logger.m3601d(f3649d, "shouldUrlBeExcluded url will be excluded (GENERAL_EXCLUSION_LIST) : " + str);
                return true;
            }
        }
        for (String contains2 : C1308d.m3122a().get(C1308d.f2814b)) {
            if (str.contains(contains2)) {
                Logger.m3601d(f3649d, "shouldUrlBeExcluded url will be excluded (ATTRIBUTION_URLS): " + str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    private static boolean m3728z(String str) {
        Logger.m3601d(f3649d, "headerContainsImageMimeType SafeDK.getInstance().getImageMimeTypesList()=" + SafeDK.getInstance().mo19145o().toString());
        for (String next : SafeDK.getInstance().mo19145o()) {
            Logger.m3601d(f3649d, "headerContainsImageMimeType checking if header value '" + str + "' contains the mime type 'image/" + next);
            if (str.contains("image/" + next)) {
                Logger.m3601d(f3649d, "headerContainsImageMimeType header contains the mime type");
                return true;
            }
        }
        Logger.m3601d(f3649d, "headerContainsImageMimeType header DOES NOT contain the mime type");
        return false;
    }

    /* renamed from: A */
    private static boolean m3664A(String str) {
        Logger.m3601d(f3649d, "headerContainsAudioMimeType SafeDK.getInstance().getAudioMimeTypesList()=" + SafeDK.getInstance().mo19146p().toString());
        for (String next : SafeDK.getInstance().mo19146p()) {
            Logger.m3601d(f3649d, "headerContainsAudioMimeType checking if header value '" + str + "' contains the mime type 'audio/" + next);
            if (str.contains("audio/" + next)) {
                Logger.m3601d(f3649d, "headerContainsAudioMimeType header contains the mime type");
                return true;
            }
        }
        Logger.m3601d(f3649d, "headerContainsAudioMimeType header DOES NOT contain the mime type");
        return false;
    }

    /* renamed from: c */
    public static String m3698c(String str) {
        return String.format(Locale.ENGLISH, "https://www.youtube.com/watch?v=%s", new Object[]{str});
    }

    /* renamed from: d */
    public static ArrayList<String> m3704d(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            m3694b(f3649d, "extractUrlsFromHtml " + f3660o + ", source: " + str);
            Matcher matcher = f3660o.matcher(str);
            while (matcher.find()) {
                String replace = matcher.group(1).replace("\\/", "/");
                Logger.m3607v(f3649d, "extractUrlsFromHtml found " + replace);
                arrayList.add(replace);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static ArrayList<String> m3707e(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            m3694b(f3649d, "extractUrlsFromSourceWithSpecialChars " + f3661p + ", source: " + str);
            Matcher matcher = f3661p.matcher(str);
            while (matcher.find()) {
                String replace = matcher.group(1).replace("\\/", "/");
                Logger.m3607v(f3649d, "extractUrlsFromSourceWithSpecialChars found " + replace);
                arrayList.add(replace);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public static ArrayList<String> m3708f(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null) {
            try {
                Logger.m3607v(f3649d, "extractBase64EncodedResourceFromSource. regex pattern : " + f3663r);
                Matcher matcher = f3663r.matcher(str);
                while (matcher.find()) {
                    String group = matcher.group(2);
                    int B = m3665B(group);
                    Logger.m3607v(f3649d, "extractBase64EncodedResourceFromSource found. Hash =  " + B + " , resource = " + group);
                    arrayList.add(matcher.group(1) + ":" + B);
                }
            } catch (Throwable th) {
                Logger.m3601d(f3649d, "Exception in extractBase64EncodedResourceFromSource " + th.getMessage());
            }
        }
        return arrayList;
    }

    /* renamed from: B */
    private static int m3665B(String str) {
        int i = 0;
        if (str.length() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= str.length()) {
                return i3;
            }
            i = (str.charAt(i2) + ((i3 << 5) - i3)) | 0;
            i2++;
        }
    }

    /* renamed from: g */
    public static String m3709g(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            if (charAt != '\\' || i >= str.length()) {
                sb.append(charAt);
            } else {
                char charAt2 = str.charAt(i);
                i++;
                if (charAt2 == '\\' || charAt2 == '/' || charAt2 == '\"' || charAt2 == '\'') {
                    sb.append(charAt2);
                } else if (charAt2 == 'n') {
                    sb.append(10);
                } else if (charAt2 == 'r') {
                    sb.append(13);
                } else if (charAt2 == 't') {
                    sb.append(9);
                } else if (charAt2 == 'b') {
                    sb.append(8);
                } else if (charAt2 == 'f') {
                    sb.append(12);
                } else if (charAt2 == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    if (i + 4 > str.length()) {
                        throw new RuntimeException("Not enough unicode digits! ");
                    }
                    for (char c : str.substring(i, i + 4).toCharArray()) {
                        if (!Character.isLetterOrDigit(c)) {
                            throw new RuntimeException("Bad character in unicode escape.");
                        }
                        sb2.append(Character.toLowerCase(c));
                    }
                    i += 4;
                    sb.append((char) Integer.parseInt(sb2.toString(), 16));
                } else {
                    throw new RuntimeException("Illegal escape sequence: \\" + charAt2);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: h */
    public static String m3710h(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String replace = m3711i(str).replace("\\\\x21", "!").replace("\\\\x23", "#").replace("\\\\x24", "$").replace("\\\\x26", "&").replace("\\\\x27", "'").replace("\\\\x28", "(").replace("\\\\x29", ")").replace("\\\\x2a", "*").replace("\\\\x2b", "+").replace("\\\\x2c", ",").replace("\\\\x2f", "/").replace("\\\\x3a", ":").replace("\\\\x3b", ";").replace("\\\\x3c", "<").replace("\\\\x3d", "=").replace("\\\\x3e", ">").replace("\\\\x3f", "?").replace("\\\\x40", "@").replace("\\\\x5b", "[").replace("\\\\x5d", "]").replace("\\\\x22", "\"").replace("\\x21", "!").replace("\\x23", "#").replace("\\x24", "$").replace("\\x26", "&").replace("\\x27", "'").replace("\\x28", "(").replace("\\x29", ")").replace("\\x2a", "*").replace("\\x2b", "+").replace("\\x2c", ",").replace("\\x2f", "/").replace("\\x3a", ":").replace("\\x3b", ";").replace("\\x3c", "<").replace("\\x3d", "=").replace("\\x3e", ">").replace("\\x3f", "?").replace("\\x40", "@").replace("\\x5b", "[").replace("\\x5d", "]").replace("\\x22", "\"").replace("&amp;", "&").replace("\\/", "/").replace("&amp;", "&");
            int lastIndexOf = replace.lastIndexOf("&quot;");
            if (lastIndexOf != -1 && !replace.substring(lastIndexOf).contains("[CDATA[")) {
                replace = replace.substring(0, lastIndexOf);
            }
            StringBuilder append = new StringBuilder().append("selectiveDecode input=");
            if (str.length() > 500) {
                str2 = "(too long)";
            } else {
                str2 = str;
            }
            Logger.m3607v(f3649d, append.append(str2).append(", result=").append(replace.length() > 500 ? "(too long)" : replace).toString());
            return replace;
        } catch (Throwable th) {
            Logger.m3603e(f3649d, "exception in selectiveDecode. input param is " + str + "' , error : " + th.getMessage());
            return str;
        }
    }

    /* renamed from: i */
    public static String m3711i(String str) {
        Matcher matcher = Pattern.compile("\\\\u([0-9a-f]{4})").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf((char) Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m3678a(Pattern pattern, String str, int i) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() < i) {
            return null;
        }
        String group = matcher.group(i);
        Logger.m3601d(f3649d, "getMatchForPattern match: " + group);
        return group;
    }

    /* renamed from: b */
    public static List<String> m3692b(Pattern pattern, String str, int i) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(i));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m3681a(Pattern pattern, String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    /* renamed from: b */
    public static boolean m3695b(Pattern pattern, String str) {
        Logger.m3601d(f3649d, "matchExistsForPattern pattern=" + pattern.pattern());
        return pattern.matcher(str).find();
    }

    /* renamed from: c */
    public static String m3700c(Pattern pattern, String str) {
        Logger.m3601d(f3649d, "getMatchForPattern pattern=" + pattern.pattern());
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            return null;
        }
        String group = matcher.group(1);
        Logger.m3601d(f3649d, "getMatchForPattern match: " + group);
        return group;
    }

    /* renamed from: e */
    public static String m3706e(String str, String str2) {
        return !str.contains("?") ? str : str.replaceFirst("&?" + str2 + "=(.*?)(&|$)", "");
    }

    /* renamed from: j */
    public static String m3712j(String str) {
        return str.split("\\?")[0];
    }

    /* renamed from: k */
    public static boolean m3713k(String str) {
        return m3695b(f3662q, str);
    }

    /* renamed from: l */
    public static String m3714l(String str) {
        if (m3713k(str)) {
            for (String e : f3665t) {
                str = m3706e(str, e);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static View m3668a(View view) {
        View view2;
        try {
            if (view.getParent() == null) {
                return view;
            }
            ViewParent parent = view.getParent();
            while (parent.getParent() != null) {
                parent = parent.getParent();
            }
            view2 = (View) parent;
            return view2;
        } catch (Throwable th) {
            Logger.m3603e(f3649d, "exception in getAbsoluteParent (input param is " + view + "' , error : " + th.getMessage());
            view2 = view;
        }
        return view2;
    }

    /* renamed from: a */
    public static void m3686a(SortedMap<Integer, List<String>> sortedMap, int i, String str) {
        if (!sortedMap.containsKey(Integer.valueOf(i))) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            sortedMap.put(Integer.valueOf(i), arrayList);
            return;
        }
        ((List) sortedMap.get(Integer.valueOf(i))).add(str);
    }

    /* renamed from: m */
    public static boolean m3715m(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: n */
    public static boolean m3716n(String str) {
        if (str == null) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: o */
    public static boolean m3717o(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.contains("<div") && lowerCase.contains("</div>")) || (lowerCase.contains("<script>") && lowerCase.contains("</script>"));
    }

    /* renamed from: a */
    public static String m3679a(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, XmpWriter.UTF8));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
/*
    public static void m3685a(List<OnGlobalImpressionDataListener> list, Object obj, Type type, int i, List<Object> list2) throws IllegalArgumentException {
        int i2;
        if (obj != null) {
            if (i > 2) {
                try {
                    Logger.m3601d(f3649d, "searchForObjectInClassHierarchy cannot go beyond level " + i);
                } catch (Throwable th) {
                    Logger.m3604e(f3649d, "searchForObjectInClassHierarchy Exception, stopping", th);
                }
            } else {
                Field[] declaredFields = obj.getClass().getDeclaredFields();
                int length = declaredFields.length;
                int i3 = 0;
                int i4 = i;
                while (i3 < length) {
                    Field field = declaredFields[i3];
                    field.setAccessible(true);
                    if (field.getType().equals(type)) {
                        Logger.m3601d(f3649d, "searchForObjectInClassHierarchy Found a " + type.getClass().getName() + " object in level " + i4);
                        if (field.get(obj) != null) {
                            Logger.m3601d(f3649d, "searchForObjectInClassHierarchy Found a " + type.getClass().getName() + " object which is not null");
                            list.add((OnGlobalImpressionDataListener) field.get(obj));
                        } else {
                            Logger.m3601d(f3649d, "searchForObjectInClassHierarchy Found a " + type.getClass().getName() + " object which is null");
                        }
                    }
                    if (field.getType().isPrimitive() || field.get(obj) == null || list2.contains(field.get(obj)) || field.get(obj) == null) {
                        i2 = i4;
                    } else {
                        i2 = i4 + 1;
                        m3685a(list, field.get(obj), type, i4, list2);
                    }
                    i3++;
                    i4 = i2;
                }
            }
        }
    }
*/

    /* renamed from: c */
    public static boolean m3701c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: a */
    public static JSONObject m3683a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    jSONObject.put(str, m3683a((Bundle) obj));
                } else {
                    jSONObject.put(str, obj);
                }
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static String m3672a(Intent intent) {
        if (intent == null) {
            return "";
        }
        StringBuilder append = new StringBuilder("action: ").append(intent.getAction()).append(" data: ").append(intent.getDataString()).append(" extras: ");
        if (intent.getExtras() != null) {
            for (String str : intent.getExtras().keySet()) {
                append.append(str).append("=").append(intent.getExtras().get(str)).append(" ");
            }
        }
        return append.toString();
    }

    /* renamed from: p */
    public static boolean m3718p(String str) {
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            try {
                new JSONArray(str);
            } catch (JSONException e2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m3676a(String str, Set<String> set) {
        if (set == null) {
            return str;
        }
        String str2 = str;
        for (String next : set) {
            Logger.m3601d(f3649d, "removing query param '" + next + "' from url " + str);
            str2 = m3706e(str2, next);
        }
        return str2;
    }

    /* renamed from: q */
    public static List<String> m3719q(String str) {
        Logger.m3601d(f3649d, "getFileListFromZipFile started, path = " + str);
        ArrayList arrayList = new ArrayList();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                } else if (!nextEntry.isDirectory()) {
                    arrayList.add(nextEntry.getName());
                }
            }
        } catch (Throwable th) {
            Logger.m3602d(f3649d, "Exception in getFileListFromZipFile : " + th.getMessage(), th);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* renamed from: r */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m3720r(String r4) {
        /*
            r1 = 0
            if (r4 != 0) goto L_0x0005
            r0 = r1
        L_0x0004:
            return r0
        L_0x0005:
            java.util.Map<java.lang.String, java.lang.String> r0 = f3668w
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r2 = r0.iterator()
        L_0x000f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0031
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r4.startsWith(r0)
            if (r3 != 0) goto L_0x002f
            java.util.Map<java.lang.String, java.lang.String> r3 = f3668w
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L_0x000f
        L_0x002f:
            r0 = 1
            goto L_0x0004
        L_0x0031:
            r0 = r1
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.utils.C1361h.m3720r(java.lang.String):boolean");
    }

    /* renamed from: s */
    public static String m3721s(String str) {
        for (String next : f3668w.keySet()) {
            if (str.startsWith(next)) {
                return str.replace(next, f3668w.get(next));
            }
        }
        return str;
    }

    /* renamed from: t */
    public static String m3722t(String str) {
        int indexOf;
        for (String next : f3668w.keySet()) {
            if (str.startsWith(next)) {
                String replace = str.replace(next, "");
                int indexOf2 = replace.indexOf(63);
                if (indexOf2 < 0) {
                    indexOf2 = replace.indexOf(38);
                }
                return indexOf2 > 0 ? next + replace.substring(0, indexOf2) : str;
            } else if (str.startsWith(f3668w.get(next)) && (indexOf = str.indexOf(38)) > 0) {
                str = str.substring(0, indexOf);
            }
        }
        return str;
    }

    /* renamed from: u */
    public static boolean m3723u(String str) {
        boolean z = false;
        for (String endsWith : f3666u) {
            if (str.endsWith(endsWith)) {
                z = true;
            }
        }
        Logger.m3601d(f3649d, "isVideoMediaUri returned " + z + " for url = " + str);
        return z;
    }

    /* renamed from: v */
    public static boolean m3724v(String str) {
        boolean z = false;
        for (String endsWith : f3667v) {
            if (str.endsWith(endsWith)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: d */
    public static String m3702d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
    }

    /* renamed from: e */
    public static String m3705e() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
    }

    /* renamed from: a */
    public static String m3677a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(date);
    }

    /* renamed from: w */
    public static String m3725w(String str) {
        try {
            Date date = new Date(new File(str).lastModified());
            if (date != null) {
                return m3677a(date);
            }
        } catch (Throwable th) {
            Logger.m3602d(f3649d, "Error extracting file last modified date from file " + str + " : " + th.getMessage(), th);
        }
        return "NA";
    }

    public static Map<String, String> m3682a(String str, boolean b) {
        return null;

    }
}

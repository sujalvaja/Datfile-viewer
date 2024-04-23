package com.example.safesdk.sample.utils;

import android.content.SharedPreferences;
import android.os.Build;
import com.example.safesdk.sample.SafeDK;
import com.example.safesdk.sample.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.example.safesdk.sample.analytics.events.base.StatsEvent;
import java.io.InvalidClassException;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

public class PersistentConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /* renamed from: a */
    public static  String f3580a = "SafeDKCache";

    /* renamed from: d */
    private static  String f3581d = "PersistentConcurrentHashMap";

    /* renamed from: b */
    public String f3582b;

    /* renamed from: c */
    public boolean f3583c = true;

    public PersistentConcurrentHashMap(String sharePreafsKey) {
        if (sharePreafsKey == null || (sharePreafsKey != null && sharePreafsKey.length() == 0)) {
            throw new InvalidParameterException("argument sharePreafsKey cannot be empty");
        }
        this.f3582b = sharePreafsKey;
        Logger.m3601d(f3581d, "PersistentConcurrentHashMap instance created, filename = " + m3612b());
        m3615e();
    }

    public PersistentConcurrentHashMap() {
    }

    private PersistentConcurrentHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    private PersistentConcurrentHashMap(Map m) {
        super(m);
    }

    private PersistentConcurrentHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    private PersistentConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) {
        super(initialCapacity, loadFactor, concurrencyLevel);
    }

    public synchronized void putAll(Map map) {
        Logger.m3607v(f3581d, "putAll started");
        super.putAll(map);
        if (this.f3583c) {
            m3613c();
        }
    }

    public synchronized V put(K key, V value) {
        if (keySet().contains(key)) {
            super.remove(key);
        }
        super.put(key, value);
        if (this.f3583c) {
            m3613c();
        }
        return value;
    }

    public boolean remove(Object key, Object value) {
        return remove(key) != null;
    }

    public synchronized V remove(Object key) {
        V remove;
        if (key == null) {
            Logger.m3601d(f3581d, "key is null, exiting");
            remove = null;
        } else {
            remove = super.remove(key);
            if (this.f3583c) {
                m3613c();
            }
        }
        return remove;
    }

    public synchronized boolean replace(K key, V oldValue, V newValue) {
        boolean replace;
        replace = super.replace(key, oldValue, newValue);
        if (this.f3583c) {
            m3613c();
        }
        return replace;
    }

    public synchronized V replace(K key, V value) {
        V replace;
        replace = super.replace(key, value);
        if (this.f3583c) {
            m3613c();
        }
        return replace;
    }

    public synchronized void replaceAll(BiFunction function) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.replaceAll(function);
            if (this.f3583c) {
                m3613c();
            }
        }
    }

    /* renamed from: b */
    private synchronized String m3612b() {
        return "SafeDKCache_" + this.f3582b;
    }

    /* renamed from: a */
    public boolean mo19673a() {
        return this.f3583c;
    }

    /* renamed from: a */
    public void mo19672a(boolean z) {
        this.f3583c = z;
        if (this.f3583c) {
            m3613c();
        }
    }

    /* renamed from: c */
    private void m3613c() {
        Logger.m3607v(f3581d, "saveMap started, map key=" + m3612b() + ", size before filtering=" + entrySet().size());
        try {
            SharedPreferences sharedPreferences = SafeDK.getInstance().mo19137g().getSharedPreferences(m3612b(), 0);
            if (sharedPreferences != null) {
                String a = C1358e.m3635a((Object) m3614d());
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(this.f3582b).apply();
                edit.putString(this.f3582b, a);
                edit.apply();
                Logger.m3607v(f3581d, "Map saved, content length=" + a.length());
                return;
            }
            Logger.m3607v(f3581d, "saveMap cannot get share prefs object");
        } catch (Exception e) {
            Logger.m3602d(f3581d, "Exception while saving map data", e);
        }
    }

    /* renamed from: d */
    private ConcurrentHashMap<K, V> m3614d() {
        Logger.m3607v(f3581d, "filtering items for saving started, key=" + this.f3582b + ", max items=" + SafeDK.getInstance().mo19118I() + ", max age=" + SafeDK.getInstance().mo19117H());
        ConcurrentHashMap<K, V> concurrentHashMap = new ConcurrentHashMap<>();
/*
        for (Entry entry : entrySet()) {
            if (entry.getValue() instanceof CreativeInfo) {
                CreativeInfo creativeInfo = (CreativeInfo) entry.getValue();
                if (concurrentHashMap.size() > SafeDK.getInstance().mo19118I()) {
                } else if (SafeDK.getInstance().mo19119J().contains(creativeInfo.mo19383B()) && !creativeInfo.mo19388G().before(new Timestamp(System.currentTimeMillis()))) {
                    concurrentHashMap.put(entry.getKey(), entry.getValue());
                }
            } else if (concurrentHashMap.size() <= SafeDK.getInstance().mo19118I()) {
                Logger.m3607v(f3581d, "filtering items for saving Value of not of type CreativeInfo, adding item");
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            } else {
                Logger.m3607v(f3581d, "filtering items for saving ignored current map size is " + concurrentHashMap.size());
            }
        }
*/
        Logger.m3601d(f3581d, "filtering items for saving Filtered map contains " + concurrentHashMap.size() + " items, key=" + this.f3582b);
        return concurrentHashMap;
    }

    /* renamed from: e */
    private void m3615e() {
   /*     Logger.m3601d(f3581d, "loadMap started, map key=" + m3612b());
        try {
            SharedPreferences sharedPreferences = SafeDK.getInstance().mo19137g().getSharedPreferences(m3612b(), 0);
            new ConcurrentHashMap();
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString(this.f3582b, (String) null);
                if (string != null) {
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) C1358e.m3634a(string);
                    Logger.m3607v(f3581d, "loadMap (" + m3612b() + ") content length = " + string.length() + ", concurrentHashMap size = " + concurrentHashMap.size());
                    this.f3583c = false;
                    for (Entry entry : concurrentHashMap.entrySet()) {
                        if (entry.getValue() instanceof CreativeInfo) {
                            CreativeInfo creativeInfo = (CreativeInfo) entry.getValue();
                            if (!(creativeInfo == null || creativeInfo.mo19388G() == null)) {
                                if (creativeInfo.mo19388G().before(new Timestamp(System.currentTimeMillis()))) {
                                    Logger.m3607v(f3581d, "loadMap ignoring item " + creativeInfo.mo19444w() + " , item is too old");
                                } else {
                                    put(entry.getKey(), entry.getValue());
                                }
                            }
                        } else if (entry.getValue() instanceof Boolean) {
                            Boolean bool = (Boolean) entry.getValue();
                            put(entry.getKey(), entry.getValue());
                        } else if (entry.getValue() instanceof StatsEvent) {
                            StatsEvent statsEvent = (StatsEvent) entry.getValue();
                            put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    Logger.m3607v(f3581d, "map is null");
                }
                Logger.m3607v(f3581d, "loadMap loading map.  " + size() + " items");
            } else {
                Logger.m3607v(f3581d, "loadMap cannot get share prefs object, file will be cleared.");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().clear().commit();
                }
            }
        } catch (InvalidClassException e) {
            Logger.m3602d(f3581d, "Error loading Map from file : " + e.getMessage(), e);
        } catch (Throwable th) {
            Logger.m3604e(f3581d, "Error loading Map from file", th);
        } ly {
            this.f3583c = true;
            m3613c();
        }*/
    }
}

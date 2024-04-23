package com.example.safesdk.sample.utils;

import android.widget.Toast;
import com.example.safesdk.sample.SafeDK;

/* renamed from: com.example.safesdk.sample.utils.g */
public class C1360g implements Runnable {

    /* renamed from: a */
    String f3644a;

    /* renamed from: b */
    String f3645b;

    public C1360g(String str) {
        this(str, (String) null);
    }

    public C1360g(String str, String str2) {
        this.f3644a = str;
        this.f3645b = str2;
    }

    public void run() {
        Toast.makeText(SafeDK.getInstance().mo19137g(), "SDK '" + this.f3644a + "' " + (this.f3645b == null ? "" : "Toggle '" + this.f3645b + "'") + " blocked by SafeDK", 0).show();
    }
}

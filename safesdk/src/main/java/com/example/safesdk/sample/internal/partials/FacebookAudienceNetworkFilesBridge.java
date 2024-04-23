package com.example.safesdk.sample.internal.partials;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: FacebookAudienceNetworkSourceFile */
public class FacebookAudienceNetworkFilesBridge {
    public static FileOutputStream fileOutputStreamCtor(String path) throws FileNotFoundException {
        Logger.m3600d("FacebookAudienceNetworkFiles|SafeDK: Partial-Files> Lcom/safedk/android/internal/partials/FacebookAudienceNetworkFilesBridge;->fileOutputStreamCtor(Ljava/lang/String;)Ljava/io/FileOutputStream;");
        return CreativeInfoManager.m3063a("com.facebook.ads", path, new FileOutputStream(path));
    }
}

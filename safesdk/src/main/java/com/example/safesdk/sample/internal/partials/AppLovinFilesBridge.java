package com.example.safesdk.sample.internal.partials;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.C1357d;
import com.example.safesdk.sample.utils.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: AppLovinSourceFile */
public class AppLovinFilesBridge {
    public static FileOutputStream fileOutputStreamCtor(File file) throws FileNotFoundException {
        Logger.m3600d("AppLovinFiles|SafeDK: Partial-Files> Lcom/safedk/android/internal/partials/AppLovinFilesBridge;->fileOutputStreamCtor(Ljava/io/File;)Ljava/io/FileOutputStream;");
        return CreativeInfoManager.m3063a(C1357d.f3593a, file.getPath(), new FileOutputStream(file));
    }
}

package com.example.safesdk.sample.internal.partials;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: ObjenesisSourceFile */
public class ObjenesisFilesBridge {
    public static FileOutputStream fileOutputStreamCtor(String path) throws FileNotFoundException {
        Logger.m3600d("ObjenesisFiles|SafeDK: Partial-Files> Lcom/safedk/android/internal/partials/ObjenesisFilesBridge;->fileOutputStreamCtor(Ljava/lang/String;)Ljava/io/FileOutputStream;");
        return CreativeInfoManager.m3063a("org.objenesis", path, new FileOutputStream(path));
    }
}

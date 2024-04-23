package com.example.safesdk.sample.internal.partials;

import com.example.safesdk.sample.analytics.brandsafety.creatives.CreativeInfoManager;
import com.example.safesdk.sample.utils.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import io.paperdb.BuildConfig;

/* compiled from: PaperSourceFile */
public class PaperFilesBridge {
    public static FileOutputStream fileOutputStreamCtor(File file) throws FileNotFoundException {
        Logger.m3600d("PaperFiles|SafeDK: Partial-Files> Lcom/safedk/android/internal/partials/PaperFilesBridge;->fileOutputStreamCtor(Ljava/io/File;)Ljava/io/FileOutputStream;");
        return CreativeInfoManager.m3063a(BuildConfig.LIBRARY_PACKAGE_NAME, file.getPath(), new FileOutputStream(file));
    }
}

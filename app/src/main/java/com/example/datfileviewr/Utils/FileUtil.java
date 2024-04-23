package com.example.datfileviewr.Utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.Annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class FileUtil {
    public static  mstaicfun mstaicfun = new mstaicfun((DefaultConstructorMarker) null);
    private static  int DEFAULT_BUFFER_SIZE = 4096;
    private static  int EOF = -1;

    public static class mstaicfun {
        public mstaicfun(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private mstaicfun() {
        }

        public File from(Context context, Uri uri) throws IOException {
            String str;
            FileOutputStream fileOutputStream;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            String fileName = getFileName(context, uri);
            Log.d("TAG", "from:" + fileName);
            String[] splitFileName = splitFileName(fileName);
            String str2 = splitFileName[0];
            Intrinsics.checkNotNull(str2);
            if (str2.length() < 4) {
                str = splitFileName[0] + "tayyabkhan";
            } else {
                str = String.valueOf(splitFileName[0]);
            }
            File createTempFile = File.createTempFile(str, splitFileName[1]);
            File rename = rename(createTempFile, fileName);
            rename.deleteOnExit();
            try {
                fileOutputStream = new FileOutputStream(rename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileOutputStream = null;
            }
            if (openInputStream != null) {
                copy(openInputStream, fileOutputStream);
                openInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return rename;
        }

        public String[] splitFileName(String str) {
            String str2;
            Intrinsics.checkNotNull(str);
            int lastIndexOf$default = StringsKt.lastIndexOf((CharSequence) str, ".", 0, false);
            if (lastIndexOf$default != -1) {
                String substring = str.substring(0, lastIndexOf$default);
                String substring2 = str.substring(lastIndexOf$default);
                str2 = substring2;
                str = substring;
            } else {
                str2 = "";
            }
            return new String[]{str, str2};
        }


        public String getFileName(Context r9, Uri r10) {
            Toast.makeText(r9, "please select dat file " + r10, Toast.LENGTH_SHORT).show();
            return null;
        }

        public File rename(File file, String str) {
            Intrinsics.checkNotNullParameter(file, Annotation.FILE);
            File file2 = new File(file.getParent(), str);
            if (!Intrinsics.areEqual((Object) file2, (Object) file)) {
                if (file2.exists() && file2.delete()) {
                    Log.d("FileUtil", "Delete old " + str + " file");
                }
                if (file.renameTo(file2)) {
                    Log.d("FileUtil", "Rename file to " + str);
                }
            }
            return file2;
        }

        public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "input");
            byte[] bArr = new byte[4096];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                Unit unit = Unit.INSTANCE;
                if (-1 == read) {
                    return j;
                }
                Intrinsics.checkNotNull(outputStream);
                outputStream.write(bArr, 0, read);
                j += (long) read;
            }
        }
    }
}

package com.example.safesdk.sample.p055a;

import androidx.browser.trusted.sharing.ShareTarget;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.example.safesdk.sample.analytics.brandsafety.C1331g;
import com.example.safesdk.sample.utils.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: com.example.safesdk.sample.a.a */
public class C1255a {

    /* renamed from: b */
    private static  String f2332b = "AwsS3UploadImage";

    /* renamed from: a */
    C1331g.C1333a f2333a;

    /* renamed from: c */
    private int f2334c;

    /* renamed from: d */
    private String f2335d;

    /* renamed from: e */
    private String f2336e;

    public C1255a(String str, String str2, int i, C1331g.C1333a aVar) {
        this.f2334c = i;
        this.f2335d = str;
        this.f2336e = str2;
        this.f2333a = aVar;
        Logger.m3601d(f2332b, "AwsS3UploadImage object created, Image path=" + str + ", hash=" + str2 + ", params =" + aVar.toString());
    }

    /* renamed from: a */
    public C1256a mo19159a() {
        try {
            String str = this.f2333a.mo19489f() + "/";
            Logger.m3601d(f2332b, "About to upload image to " + str + ", prefix=" + this.f2333a.mo19487d() + ",Image path: " + this.f2335d);
            C1258c cVar = new C1258c(ShareTarget.METHOD_POST, str, XmpWriter.UTF8, this.f2334c, new HashMap());
            File file = new File(this.f2335d);
            if (!file.exists()) {
                Logger.m3601d(f2332b, "Image file to upload not found " + this.f2335d);
                return null;
            }
            cVar.mo19166a("key", this.f2333a.mo19487d() + "/" + this.f2336e + ".jpg");
            cVar.mo19166a("AWSAccessKeyId", this.f2333a.mo19484a());
            cVar.mo19166a("acl", this.f2333a.mo19490g());
            cVar.mo19166a("Content-Type", "image/jpeg");
            cVar.mo19166a("policy", this.f2333a.mo19485b());
            cVar.mo19166a("signature", this.f2333a.mo19486c());
            cVar.mo19166a("x-amz-server-side-encryption", this.f2333a.mo19493j());
            cVar.mo19166a("X-Amz-Credential", this.f2333a.mo19494k());
            cVar.mo19166a("X-Amz-Algorithm", this.f2333a.mo19491h());
            cVar.mo19166a("X-Amz-Date", this.f2333a.mo19492i());
            cVar.mo19165a(Annotation.FILE, file);
            cVar.mo19164a();
            String str2 = this.f2333a.mo19489f() + "/" + this.f2333a.mo19487d() + "/" + this.f2336e + ".jpg";
            Logger.m3601d(f2332b, "Image uploaded successfully");
            return new C1256a(str2, cVar.mo19167b(), this.f2336e);
        } catch (IOException e) {
            Logger.m3604e(f2332b, "IOException when uploading image file " + this.f2335d, e);
            return null;
        } catch (Throwable th) {
            Logger.m3604e(f2332b, "Failed to upload image file " + this.f2335d, th);
            return null;
        }
    }

    /* renamed from: com.example.safesdk.sample.a.a$a */
    public class C1256a {

        /* renamed from: b */
        private String f2338b;

        /* renamed from: c */
        private int f2339c;

        /* renamed from: d */
        private String f2340d;

        C1256a(String str, int i, String str2) {
            this.f2338b = str;
            this.f2339c = i;
            this.f2340d = str2;
        }

        /* renamed from: a */
        public String mo19160a() {
            return this.f2338b;
        }

        /* renamed from: b */
        public int mo19161b() {
            return this.f2339c;
        }

        /* renamed from: c */
        public String mo19162c() {
            return this.f2340d;
        }
    }
}

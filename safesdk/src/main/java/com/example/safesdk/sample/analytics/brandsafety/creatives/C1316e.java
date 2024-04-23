package com.example.safesdk.sample.analytics.brandsafety.creatives;

/* renamed from: com.example.safesdk.sample.analytics.brandsafety.creatives.e */
public class C1316e {

    /* renamed from: a */
    private static  String f2913a = "ScreenshotHelper";

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap mo19348a(android.view.View r8, int r9) {
        /*
            r7 = this;
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0010
            int r0 = r8.getWidth()
            if (r0 <= 0) goto L_0x0010
            int r0 = r8.getHeight()
            if (r0 > 0) goto L_0x0019
        L_0x0010:
            java.lang.String r0 = "ScreenshotHelper"
            java.lang.String r1 = "Cannot save view to bitmap!"
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)
            r0 = 0
        L_0x0018:
            return r0
        L_0x0019:
            int r0 = r8.getWidth()
            float r3 = (float) r0
            int r0 = r8.getHeight()
            float r2 = (float) r0
            if (r9 <= 0) goto L_0x00a5
            int r0 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            java.lang.String r0 = "ScreenshotHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Taking screenshot of landscape view "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.example.safesdk.sample.utils.Logger.m3607v(r0, r4)
            float r0 = (float) r9
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            float r0 = (float) r9
            float r0 = r3 / r0
            float r4 = (float) r9
            float r2 = r2 * r4
            float r2 = r2 / r3
            float r3 = (float) r9
        L_0x004d:
            java.lang.String r4 = "ScreenshotHelper"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "scale size = "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.example.safesdk.sample.utils.Logger.m3607v(r4, r5)
            int r3 = (int) r3
            int r2 = (int) r2
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r3, r2, r4)
            if (r2 == 0) goto L_0x007e
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r2)
            float r4 = r1 / r0
            float r0 = r1 / r0
            r3.scale(r4, r0)
            r8.draw(r3)
        L_0x007e:
            r0 = r2
            goto L_0x0018
        L_0x0080:
            java.lang.String r0 = "ScreenshotHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Taking screenshot of portrait view "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.example.safesdk.sample.utils.Logger.m3607v(r0, r4)
            float r0 = (float) r9
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            float r0 = (float) r9
            float r0 = r2 / r0
            float r4 = (float) r9
            float r3 = r3 * r4
            float r3 = r3 / r2
            float r2 = (float) r9
            goto L_0x004d
        L_0x00a5:
            r0 = r1
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.analytics.brandsafety.creatives.C1316e.mo19348a(android.view.View, int):android.graphics.Bitmap");
    }
}

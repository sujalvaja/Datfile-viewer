package com.example.safesdk.sample.utils;

/* renamed from: com.example.safesdk.sample.utils.b */
public class C1355b {

    /* renamed from: a */
    private static  String f3585a = "GzipUtil";

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084 A[SYNTHETIC, Splitter:B:25:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089 A[Catch:{ IOException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008e A[Catch:{ IOException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093 A[Catch:{ IOException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3621a(byte[] r10) {
        /*
            r2 = 0
            if (r10 == 0) goto L_0x0006
            int r0 = r10.length
            if (r0 != 0) goto L_0x000e
        L_0x0006:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot unzip null or empty bytes"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            java.lang.String r0 = "GzipUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "unzip started, input size is "
            java.lang.StringBuilder r1 = r1.append(r3)
            int r3 = r10.length
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)
            boolean r0 = m3622b(r10)
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = "GzipUtil"
            java.lang.String r1 = "unzip started, input is not compressed"
            com.example.safesdk.sample.utils.Logger.m3601d(r0, r1)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r10)
        L_0x003b:
            return r0
        L_0x003c:
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c3 }
            r5.<init>(r10)     // Catch:{ IOException -> 0x00df, Throwable -> 0x00c3 }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00d1 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00e5, Throwable -> 0x00d1 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ea, Throwable -> 0x00d6 }
            java.lang.String r0 = "UTF-8"
            r3.<init>(r4, r0)     // Catch:{ IOException -> 0x00ea, Throwable -> 0x00d6 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ee, Throwable -> 0x00da }
            r1.<init>(r3)     // Catch:{ IOException -> 0x00ee, Throwable -> 0x00da }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            r0.<init>()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
        L_0x0057:
            java.lang.String r6 = r1.readLine()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            if (r6 == 0) goto L_0x00a0
            r0.append(r6)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r7 = "GzipUtil"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            r8.<init>()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r9 = "appending line "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            com.example.safesdk.sample.utils.C1361h.m3694b((java.lang.String) r7, (java.lang.String) r6)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            goto L_0x0057
        L_0x0079:
            r0 = move-exception
        L_0x007a:
            java.lang.String r6 = "GzipUtil"
            java.lang.String r7 = "Exception in unzip"
            com.example.safesdk.sample.utils.Logger.m3604e(r6, r7, r0)
            r0 = r2
        L_0x0082:
            if (r1 == 0) goto L_0x0087
            r1.close()     // Catch:{ IOException -> 0x0097 }
        L_0x0087:
            if (r3 == 0) goto L_0x008c
            r3.close()     // Catch:{ IOException -> 0x0097 }
        L_0x008c:
            if (r4 == 0) goto L_0x0091
            r4.close()     // Catch:{ IOException -> 0x0097 }
        L_0x0091:
            if (r5 == 0) goto L_0x003b
            r5.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x003b
        L_0x0097:
            r1 = move-exception
            java.lang.String r2 = "GzipUtil"
            java.lang.String r3 = "Exception in unzip ly block"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r1)
            goto L_0x003b
        L_0x00a0:
            java.lang.String r6 = "GzipUtil"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            r7.<init>()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r8 = "unzip started, output size is "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            int r8 = r0.length()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            com.example.safesdk.sample.utils.Logger.m3601d(r6, r7)     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            java.lang.String r2 = r0.toString()     // Catch:{ IOException -> 0x0079, Throwable -> 0x00dd }
            r0 = r2
            goto L_0x0082
        L_0x00c3:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r2
        L_0x00c8:
            java.lang.String r6 = "GzipUtil"
            java.lang.String r7 = "Exception in unzip"
            com.example.safesdk.sample.utils.Logger.m3604e(r6, r7, r0)
            r0 = r2
            goto L_0x0082
        L_0x00d1:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            goto L_0x00c8
        L_0x00d6:
            r0 = move-exception
            r1 = r2
            r3 = r2
            goto L_0x00c8
        L_0x00da:
            r0 = move-exception
            r1 = r2
            goto L_0x00c8
        L_0x00dd:
            r0 = move-exception
            goto L_0x00c8
        L_0x00df:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            r5 = r2
            goto L_0x007a
        L_0x00e5:
            r0 = move-exception
            r1 = r2
            r3 = r2
            r4 = r2
            goto L_0x007a
        L_0x00ea:
            r0 = move-exception
            r1 = r2
            r3 = r2
            goto L_0x007a
        L_0x00ee:
            r0 = move-exception
            r1 = r2
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.utils.C1355b.m3621a(byte[]):java.lang.String");
    }

    /* renamed from: a */
    public static int m3620a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] c = m3623c(bArr2);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= bArr.length) {
                return -1;
            }
            i = i3;
            while (i > 0 && bArr2[i] != bArr[i2]) {
                i = c[i - 1];
            }
            if (bArr2[i] == bArr[i2]) {
                i++;
            }
            if (i == bArr2.length) {
                return (i2 - bArr2.length) + 1;
            }
            i2++;
        }
    }

    /* renamed from: c */
    private static int[] m3623c(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i = 0;
        int i2 = 1;
        while (i2 < bArr.length) {
            while (i > 0 && bArr[i] != bArr[i2]) {
                i = iArr[i - 1];
            }
            if (bArr[i] == bArr[i2]) {
                i++;
            }
            iArr[i2] = i;
            i2++;
        }
        return iArr;
    }

    /* renamed from: b */
    public static boolean m3622b(byte[] bArr) {
        return bArr[0] == 31 && bArr[1] == -117;
    }
}

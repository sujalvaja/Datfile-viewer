package com.example.safesdk.sample.utils;

/* renamed from: com.example.safesdk.sample.utils.e */
public class C1358e {

    /* renamed from: a */
    private static  String f3619a = C1358e.class.getSimpleName();

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c A[SYNTHETIC, Splitter:B:23:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[Catch:{ IOException -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5 A[SYNTHETIC, Splitter:B:33:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba A[Catch:{ IOException -> 0x00be }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m3635a(Object r7) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0061, all -> 0x00b0 }
            r3.<init>()     // Catch:{ IOException -> 0x0061, all -> 0x00b0 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x00dd, all -> 0x00d8 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00dd, all -> 0x00d8 }
            r2.writeObject(r7)     // Catch:{ IOException -> 0x00e0 }
            r2.flush()     // Catch:{ IOException -> 0x00e0 }
            byte[] r1 = r3.toByteArray()     // Catch:{ IOException -> 0x00e0 }
            r4 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r1, r4)     // Catch:{ IOException -> 0x00e0 }
            if (r2 == 0) goto L_0x001f
            r2.close()     // Catch:{ IOException -> 0x0025 }
        L_0x001f:
            if (r3 == 0) goto L_0x0024
            r3.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0024:
            return r0
        L_0x0025:
            r1 = move-exception
            java.lang.String r2 = f3619a     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x003f }
            r3.<init>()     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = "failed during closing serialization streams with object: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ Throwable -> 0x003f }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x003f }
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r1)     // Catch:{ Throwable -> 0x003f }
            goto L_0x0024
        L_0x003f:
            r1 = move-exception
            java.lang.String r2 = f3619a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "failed during serializing object: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r3 = r3.toString()
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r1)
            com.example.safesdk.sample.analytics.reporters.CrashReporter r2 = new com.example.safesdk.sample.analytics.reporters.CrashReporter
            r2.<init>()
            r2.caughtException(r1)
            goto L_0x0024
        L_0x0061:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L_0x0064:
            java.lang.String r4 = f3619a     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "failed during serialization object: "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ all -> 0x00db }
            java.lang.String r6 = " : "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r6 = r1.getMessage()     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00db }
            com.example.safesdk.sample.utils.Logger.m3604e(r4, r5, r1)     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x008f
            r2.close()     // Catch:{ IOException -> 0x0095 }
        L_0x008f:
            if (r3 == 0) goto L_0x0024
            r3.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0024
        L_0x0095:
            r1 = move-exception
            java.lang.String r2 = f3619a     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x003f }
            r3.<init>()     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = "failed during closing serialization streams with object: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ Throwable -> 0x003f }
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x003f }
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r1)     // Catch:{ Throwable -> 0x003f }
            goto L_0x0024
        L_0x00b0:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L_0x00b3:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ IOException -> 0x00be }
        L_0x00b8:
            if (r3 == 0) goto L_0x00bd
            r3.close()     // Catch:{ IOException -> 0x00be }
        L_0x00bd:
            throw r1     // Catch:{ Throwable -> 0x003f }
        L_0x00be:
            r2 = move-exception
            java.lang.String r3 = f3619a     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x003f }
            r4.<init>()     // Catch:{ Throwable -> 0x003f }
            java.lang.String r5 = "failed during closing serialization streams with object: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x003f }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ Throwable -> 0x003f }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x003f }
            com.example.safesdk.sample.utils.Logger.m3604e(r3, r4, r2)     // Catch:{ Throwable -> 0x003f }
            goto L_0x00bd
        L_0x00d8:
            r1 = move-exception
            r2 = r0
            goto L_0x00b3
        L_0x00db:
            r1 = move-exception
            goto L_0x00b3
        L_0x00dd:
            r1 = move-exception
            r2 = r0
            goto L_0x0064
        L_0x00e0:
            r1 = move-exception
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.utils.C1358e.m3635a(java.lang.Object):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[SYNTHETIC, Splitter:B:18:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A[Catch:{ IOException -> 0x0036 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object m3634a(String r4) throws ClassNotFoundException, java.io.IOException {
        /*
            r2 = 0
            r0 = 2
            byte[] r0 = android.util.Base64.decode(r4, r0)     // Catch:{ all -> 0x0028 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0028 }
            r1.<init>(r0)     // Catch:{ all -> 0x0028 }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ all -> 0x003f }
            r3.<init>(r1)     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r3.readObject()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0019
            r3.close()     // Catch:{ IOException -> 0x001f }
        L_0x0019:
            if (r1 == 0) goto L_0x001e
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001e:
            return r2
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = f3619a
            java.lang.String r3 = "failed while closing serialization stream"
            com.example.safesdk.sample.utils.Logger.m3604e(r1, r3, r0)
            goto L_0x001e
        L_0x0028:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x002b:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0035:
            throw r0
        L_0x0036:
            r1 = move-exception
            java.lang.String r2 = f3619a
            java.lang.String r3 = "failed while closing serialization stream"
            com.example.safesdk.sample.utils.Logger.m3604e(r2, r3, r1)
            goto L_0x0035
        L_0x003f:
            r0 = move-exception
            r3 = r2
            goto L_0x002b
        L_0x0042:
            r0 = move-exception
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.safesdk.sample.utils.C1358e.m3634a(java.lang.String):java.lang.Object");
    }
}

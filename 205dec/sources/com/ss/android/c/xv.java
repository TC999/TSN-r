package com.ss.android.c;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f48152c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private int f48153c;
        private long sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private int f48154w;
        private int xv;

        private c() {
        }
    }

    public static String c(File file) {
        return c(file, 9, 8192L);
    }

    private static String w(File file, int i4, long j4) throws Exception {
        return c(new com.ss.android.c.c(file), i4, j4);
    }

    public static String c(File file, int i4, long j4) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return w(file, i4, j4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static long w(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static int c(String str, File file) {
        return c(str, file, (w) null);
    }

    public static int c(String str, File file, w wVar) {
        String w3;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (wVar != null) {
                if (wVar.c() <= 0) {
                    try {
                        wVar.w();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i4 = -1;
            long j4 = -1;
            try {
                c c4 = c(str);
                if (c4 != null) {
                    if (c4.f48153c > 1) {
                        return 3;
                    }
                    i4 = c4.xv;
                    j4 = c4.sr;
                }
                c cVar = null;
                if (wVar != null) {
                    w3 = c(wVar, i4, j4);
                } else {
                    w3 = w(file, i4, j4);
                }
                if (w3 != null && w3.length() != 0) {
                    if (c4 != null && (c4.f48153c != 1 || c4.f48154w != 1)) {
                        if (c4.ux != null) {
                            try {
                                cVar = c(w3);
                            } catch (Throwable unused2) {
                            }
                            if (cVar != null && c4.xv == cVar.xv && c4.sr == cVar.sr && c4.ux.equals(cVar.ux)) {
                                return 0;
                            }
                        }
                    }
                    return w3.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:43:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x009c, TryCatch #2 {all -> 0x009c, blocks: (B:6:0x000d, B:10:0x001a, B:15:0x002e, B:17:0x0040, B:19:0x004d, B:21:0x0064, B:22:0x006e, B:28:0x0080), top: B:43:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(com.ss.android.c.w r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.c()     // Catch: java.lang.Throwable -> L9c
            r11 = 1
            if (r0 <= 0) goto L2c
            r2 = 0
            int r4 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r4 <= 0) goto L2c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r23
            r4 = 8
            long r4 = r4 * r9
            r6 = 10
            long r4 = r4 / r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L29
            goto L2c
        L29:
            r12 = r23
            goto L2e
        L2c:
            r12 = r9
            r0 = 1
        L2e:
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r14 = new byte[r2]     // Catch: java.lang.Throwable -> L9c
            r15 = 0
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r7 = r12
            c(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            r2 = 2
            if (r0 <= r2) goto L62
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L9c
            long r2 = r2 * r12
            long r2 = r9 - r2
            int r7 = r0 + (-1)
            long r4 = (long) r7     // Catch: java.lang.Throwable -> L9c
            long r17 = r2 / r4
            r8 = 1
        L4b:
            if (r8 >= r7) goto L62
            long r2 = r12 + r17
            long r15 = r15 + r2
            r2 = r21
            r3 = r1
            r4 = r14
            r5 = r15
            r19 = r7
            r20 = r8
            r7 = r12
            c(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
            int r8 = r20 + 1
            r7 = r19
            goto L4b
        L62:
            if (r0 <= r11) goto L6e
            long r5 = r9 - r12
            r2 = r21
            r3 = r1
            r4 = r14
            r7 = r12
            c(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
        L6e:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = c(r1)     // Catch: java.lang.Throwable -> L9c
            if (r0 != r11) goto L80
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L80
            r21.w()     // Catch: java.lang.Throwable -> L7f
        L7f:
            return r1
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = c(r0, r12)     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            r21.w()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        L9c:
            r0 = move-exception
            r21.w()     // Catch: java.lang.Throwable -> La0
        La0:
            goto La2
        La1:
            throw r0
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.c.xv.c(com.ss.android.c.w, int, long):java.lang.String");
    }

    private static void c(w wVar, MessageDigest messageDigest, byte[] bArr, long j4, long j5) throws IOException {
        wVar.c(j4, j5);
        long j6 = 0;
        while (j6 < j5) {
            int c4 = wVar.c(bArr, 0, (int) Math.min(j5 - j6, bArr.length));
            if (c4 > 0) {
                messageDigest.update(bArr, 0, c4);
                j6 += c4;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + c4 + ", readTotalCount = " + j6 + ", sampleSize = " + j5);
            }
        }
    }

    private static String c(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i4 = length * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = bArr[i6 + 0] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = f48152c;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String c(int i4, long j4) {
        return "ttmd5:1:1:" + c(i4) + "g" + c(j4);
    }

    private static c c(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            c cVar = new c();
            cVar.f48153c = Integer.parseInt(split2[1]);
            if (cVar.f48153c > 1) {
                return cVar;
            }
            cVar.f48154w = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            cVar.xv = (int) w(split3[0]);
            cVar.sr = w(split3[1]);
            cVar.ux = split[1];
            return cVar;
        }
        return null;
    }

    private static String c(long j4) {
        return Long.toHexString((j4 << 4) + 31);
    }
}

package com.ss.android.ok;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {
    private static final char[] ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private int f49012a;
        private int bl;

        /* renamed from: n  reason: collision with root package name */
        private String f49013n;
        private int ok;

        /* renamed from: s  reason: collision with root package name */
        private long f49014s;

        private ok() {
        }
    }

    private static String a(File file, int i4, long j4) throws Exception {
        return ok(new com.ss.android.ok.ok(file), i4, j4);
    }

    public static String ok(File file) {
        return ok(file, 9, 8192L);
    }

    private static long a(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String ok(File file, int i4, long j4) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return a(file, i4, j4);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static int ok(String str, File file) {
        return ok(str, file, (a) null);
    }

    public static int ok(String str, File file, a aVar) {
        String a4;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (aVar != null) {
                if (aVar.ok() <= 0) {
                    try {
                        aVar.a();
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
                ok ok2 = ok(str);
                if (ok2 != null) {
                    if (ok2.ok > 1) {
                        return 3;
                    }
                    i4 = ok2.bl;
                    j4 = ok2.f49014s;
                }
                ok okVar = null;
                if (aVar != null) {
                    a4 = ok(aVar, i4, j4);
                } else {
                    a4 = a(file, i4, j4);
                }
                if (a4 != null && a4.length() != 0) {
                    if (ok2 != null && (ok2.ok != 1 || ok2.f49012a != 1)) {
                        if (ok2.f49013n != null) {
                            try {
                                okVar = ok(a4);
                            } catch (Throwable unused2) {
                            }
                            if (okVar != null && ok2.bl == okVar.bl && ok2.f49014s == okVar.f49014s && ok2.f49013n.equals(okVar.f49013n)) {
                                return 0;
                            }
                        }
                    }
                    return a4.equals(str) ? 0 : 1;
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
    private static java.lang.String ok(com.ss.android.ok.a r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.ok()     // Catch: java.lang.Throwable -> L9c
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
            ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
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
            ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
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
            ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
        L6e:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = ok(r1)     // Catch: java.lang.Throwable -> L9c
            if (r0 != r11) goto L80
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L80
            r21.a()     // Catch: java.lang.Throwable -> L7f
        L7f:
            return r1
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ok(r0, r12)     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            r21.a()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        L9c:
            r0 = move-exception
            r21.a()     // Catch: java.lang.Throwable -> La0
        La0:
            goto La2
        La1:
            throw r0
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.ok.bl.ok(com.ss.android.ok.a, int, long):java.lang.String");
    }

    private static void ok(a aVar, MessageDigest messageDigest, byte[] bArr, long j4, long j5) throws IOException {
        aVar.ok(j4, j5);
        long j6 = 0;
        while (j6 < j5) {
            int ok2 = aVar.ok(bArr, 0, (int) Math.min(j5 - j6, bArr.length));
            if (ok2 > 0) {
                messageDigest.update(bArr, 0, ok2);
                j6 += ok2;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + ok2 + ", readTotalCount = " + j6 + ", sampleSize = " + j5);
            }
        }
    }

    private static String ok(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i4 = length * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = bArr[i6 + 0] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = ok;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String ok(int i4, long j4) {
        return "ttmd5:1:1:" + ok(i4) + "g" + ok(j4);
    }

    private static ok ok(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            ok okVar = new ok();
            okVar.ok = Integer.parseInt(split2[1]);
            if (okVar.ok > 1) {
                return okVar;
            }
            okVar.f49012a = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            okVar.bl = (int) a(split3[0]);
            okVar.f49014s = a(split3[1]);
            okVar.f49013n = split[1];
            return okVar;
        }
        return null;
    }

    private static String ok(long j4) {
        return Long.toHexString((j4 << 4) + 31);
    }
}

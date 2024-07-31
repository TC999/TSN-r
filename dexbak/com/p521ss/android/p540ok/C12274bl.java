package com.p521ss.android.p540ok;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.ss.android.ok.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12274bl {

    /* renamed from: ok */
    private static final char[] f34614ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.ok.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12276ok {

        /* renamed from: a */
        private int f34615a;

        /* renamed from: bl */
        private int f34616bl;

        /* renamed from: n */
        private String f34617n;

        /* renamed from: ok */
        private int f34618ok;

        /* renamed from: s */
        private long f34619s;

        private C12276ok() {
        }
    }

    /* renamed from: a */
    private static String m18518a(File file, int i, long j) throws Exception {
        return m18514ok(new C12277ok(file), i, j);
    }

    /* renamed from: ok */
    public static String m18512ok(File file) {
        return m18511ok(file, 9, 8192L);
    }

    /* renamed from: a */
    private static long m18517a(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    /* renamed from: ok */
    public static String m18511ok(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return m18518a(file, i, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    /* renamed from: ok */
    public static int m18509ok(String str, File file) {
        return m18508ok(str, file, (InterfaceC12273a) null);
    }

    /* renamed from: ok */
    public static int m18508ok(String str, File file, InterfaceC12273a interfaceC12273a) {
        String m18518a;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (interfaceC12273a != null) {
                if (interfaceC12273a.mo18495ok() <= 0) {
                    try {
                        interfaceC12273a.mo18496a();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i = -1;
            long j = -1;
            try {
                C12276ok m18510ok = m18510ok(str);
                if (m18510ok != null) {
                    if (m18510ok.f34618ok > 1) {
                        return 3;
                    }
                    i = m18510ok.f34616bl;
                    j = m18510ok.f34619s;
                }
                C12276ok c12276ok = null;
                if (interfaceC12273a != null) {
                    m18518a = m18514ok(interfaceC12273a, i, j);
                } else {
                    m18518a = m18518a(file, i, j);
                }
                if (m18518a != null && m18518a.length() != 0) {
                    if (m18510ok != null && (m18510ok.f34618ok != 1 || m18510ok.f34615a != 1)) {
                        if (m18510ok.f34617n != null) {
                            try {
                                c12276ok = m18510ok(m18518a);
                            } catch (Throwable unused2) {
                            }
                            if (c12276ok != null && m18510ok.f34616bl == c12276ok.f34616bl && m18510ok.f34619s == c12276ok.f34619s && m18510ok.f34617n.equals(c12276ok.f34617n)) {
                                return 0;
                            }
                        }
                    }
                    return m18518a.equals(str) ? 0 : 1;
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m18514ok(com.p521ss.android.p540ok.InterfaceC12273a r21, int r22, long r23) throws java.lang.Exception {
        /*
            r0 = r22
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            if (r1 != 0) goto Ld
            java.lang.String r0 = ""
            return r0
        Ld:
            long r9 = r21.mo18495ok()     // Catch: java.lang.Throwable -> L9c
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
            m18513ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
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
            m18513ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
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
            m18513ok(r2, r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L9c
        L6e:
            byte[] r1 = r1.digest()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = m18507ok(r1)     // Catch: java.lang.Throwable -> L9c
            if (r0 != r11) goto L80
            int r2 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r2 != 0) goto L80
            r21.mo18496a()     // Catch: java.lang.Throwable -> L7f
        L7f:
            return r1
        L80:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r2.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = m18516ok(r0, r12)     // Catch: java.lang.Throwable -> L9c
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ";"
            r2.append(r0)     // Catch: java.lang.Throwable -> L9c
            r2.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L9c
            r21.mo18496a()     // Catch: java.lang.Throwable -> L9b
        L9b:
            return r0
        L9c:
            r0 = move-exception
            r21.mo18496a()     // Catch: java.lang.Throwable -> La0
        La0:
            goto La2
        La1:
            throw r0
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.p540ok.C12274bl.m18514ok(com.ss.android.ok.a, int, long):java.lang.String");
    }

    /* renamed from: ok */
    private static void m18513ok(InterfaceC12273a interfaceC12273a, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        interfaceC12273a.mo18494ok(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int mo18493ok = interfaceC12273a.mo18493ok(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (mo18493ok > 0) {
                messageDigest.update(bArr, 0, mo18493ok);
                j3 += mo18493ok;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + mo18493ok + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    /* renamed from: ok */
    private static String m18507ok(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & UByte.f41242c;
                int i5 = i2 + 1;
                char[] cArr2 = f34614ok;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: ok */
    private static String m18516ok(int i, long j) {
        return "ttmd5:1:1:" + m18515ok(i) + "g" + m18515ok(j);
    }

    /* renamed from: ok */
    private static C12276ok m18510ok(String str) throws Exception {
        if (str.startsWith("ttmd5:")) {
            String[] split = str.split(";");
            String[] split2 = split[0].split(":");
            C12276ok c12276ok = new C12276ok();
            c12276ok.f34618ok = Integer.parseInt(split2[1]);
            if (c12276ok.f34618ok > 1) {
                return c12276ok;
            }
            c12276ok.f34615a = Integer.parseInt(split2[2]);
            String[] split3 = split2[3].split("g");
            c12276ok.f34616bl = (int) m18517a(split3[0]);
            c12276ok.f34619s = m18517a(split3[1]);
            c12276ok.f34617n = split[1];
            return c12276ok;
        }
        return null;
    }

    /* renamed from: ok */
    private static String m18515ok(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}

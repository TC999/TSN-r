package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Serpens {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Serpens$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public int f52171a;

        /* renamed from: b  reason: collision with root package name */
        public int f52172b;

        /* renamed from: c  reason: collision with root package name */
        public int f52173c;

        /* renamed from: d  reason: collision with root package name */
        public String f52174d;

        /* renamed from: e  reason: collision with root package name */
        public int f52175e;

        public Cdo(int i4, int i5, String str, int i6, String str2, int i7) {
            this.f52174d = "";
            this.f52171a = i4;
            this.f52172b = i5;
            this.f52174d = str;
            this.f52173c = i6;
            this.f52175e = i7;
        }

        public String toString() {
            String format = String.format("% 6d", Integer.valueOf(this.f52171a));
            String format2 = String.format("% 6d", Integer.valueOf(this.f52172b));
            String format3 = String.format("% 6d", Integer.valueOf(this.f52173c));
            return "" + format + "    " + format2 + "    " + format3 + "    " + this.f52174d;
        }
    }

    public static String a(int i4) {
        try {
            byte[] a4 = Ccontinue.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/cmdline", Integer.valueOf(i4)), 100);
            String str = a4 != null ? new String(a4, 0, a(a4, 0, (char) 0)) : "";
            if (TextUtils.isEmpty(str)) {
                byte[] a5 = Ccontinue.a(String.format(Locale.SIMPLIFIED_CHINESE, "/proc/%d/status", Integer.valueOf(i4)), 150);
                if (a5 != null) {
                    int a6 = a(a5, 7, '\n');
                    return a6 == 0 ? "" : new String(a5, 6, a6 - 6);
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingfd.sdk.ams.au.Serpens.Cdo b(int r12) {
        /*
            r0 = 0
            r1 = -1
            java.lang.String r2 = a(r12)     // Catch: java.lang.Throwable -> L96
            r3 = 1
            r4 = 0
            if (r12 == r1) goto L24
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "/proc/%d/status"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L97
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L97
            r8[r4] = r9     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L97
            byte[] r6 = com.tencent.turingfd.sdk.ams.au.Ccontinue.a(r6)     // Catch: java.lang.Throwable -> L97
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L97
            goto L37
        L24:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "/proc/self/status"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L97
            byte[] r6 = com.tencent.turingfd.sdk.ams.au.Ccontinue.a(r6)     // Catch: java.lang.Throwable -> L97
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L97
        L37:
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "\n"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L97
            int r7 = r5.length     // Catch: java.lang.Throwable -> L97
            r8 = 0
        L44:
            if (r8 >= r7) goto L65
            r9 = r5[r8]     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = ":"
            java.lang.String[] r9 = r9.split(r10)     // Catch: java.lang.Throwable -> L97
            int r10 = r9.length     // Catch: java.lang.Throwable -> L97
            r11 = 2
            if (r10 >= r11) goto L53
            goto L62
        L53:
            r10 = r9[r4]     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = r10.trim()     // Catch: java.lang.Throwable -> L97
            r9 = r9[r3]     // Catch: java.lang.Throwable -> L97
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> L97
            r6.put(r10, r9)     // Catch: java.lang.Throwable -> L97
        L62:
            int r8 = r8 + 1
            goto L44
        L65:
            java.lang.String r3 = "PPid"
            java.lang.Object r3 = r6.get(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L97
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r5 = "Uid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L98
            java.lang.String r7 = "\\s+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L98
            r4 = r5[r4]     // Catch: java.lang.Throwable -> L98
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "TracerPid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L99
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> L99
            r8 = r2
            r7 = r3
            r9 = r4
            r11 = r5
            goto L9d
        L96:
            r2 = r0
        L97:
            r3 = -1
        L98:
            r4 = -1
        L99:
            r8 = r2
            r7 = r3
            r9 = r4
            r11 = -1
        L9d:
            if (r8 == 0) goto Lac
            if (r7 == r1) goto Lac
            if (r9 != r1) goto La4
            goto Lac
        La4:
            com.tencent.turingfd.sdk.ams.au.Serpens$do r0 = new com.tencent.turingfd.sdk.ams.au.Serpens$do
            r10 = 0
            r5 = r0
            r6 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Serpens.b(int):com.tencent.turingfd.sdk.ams.au.Serpens$do");
    }

    public static int a(byte[] bArr, int i4, char c4) {
        int i5;
        int i6 = i4 - 1;
        while (true) {
            i5 = i6 + 1;
            if (i6 >= bArr.length) {
                return 0;
            }
            if (i5 == bArr.length || bArr[i5] == c4) {
                break;
            }
            i6 = i5;
        }
        return i5;
    }
}

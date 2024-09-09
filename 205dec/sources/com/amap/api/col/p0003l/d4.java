package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AESMD5Util.java */
/* renamed from: com.amap.api.col.3l.d4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d4 {

    /* renamed from: a  reason: collision with root package name */
    private static int f7422a = 6;

    private static byte[] a() {
        try {
            return b("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            u5.p(th, "AMU", "grk");
            return null;
        }
    }

    private static byte[] b(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                bArr[i4] = Byte.parseByte(split[i4]);
            }
            String[] split2 = new StringBuffer(new String(i5.c(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i5 = 0; i5 < split2.length; i5++) {
                bArr2[i5] = Byte.parseByte(split2[i5]);
            }
            return bArr2;
        } catch (Throwable th) {
            u5.p(th, "AMU", "rcs");
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            return j4.h(a(), bArr, d());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    private static byte[] d() {
        try {
            return b("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            u5.p(th, "AMU", "giv");
            return null;
        }
    }

    public static byte[] e(byte[] bArr) {
        try {
            return j4.e(a(), bArr, d());
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}

package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.d4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AESMD5Util {

    /* renamed from: a */
    private static int f3867a = 6;

    /* renamed from: a */
    private static byte[] m55299a() {
        try {
            return m55298b("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMU", "grk");
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m55298b(String str) {
        try {
            String[] split = new StringBuffer(str).reverse().toString().split(",");
            int length = split.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(Base64Util.m54754c(new String(bArr)), "UTF-8")).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMU", "rcs");
            return null;
        }
    }

    /* renamed from: c */
    public static byte[] m55297c(byte[] bArr) {
        try {
            return Encrypt.m54717h(m55299a(), bArr, m55296d());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    /* renamed from: d */
    private static byte[] m55296d() {
        try {
            return m55298b("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "AMU", "giv");
            return null;
        }
    }

    /* renamed from: e */
    public static byte[] m55295e(byte[] bArr) {
        try {
            return Encrypt.m54720e(m55299a(), bArr, m55296d());
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}

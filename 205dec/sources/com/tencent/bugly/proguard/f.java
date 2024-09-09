package com.tencent.bugly.proguard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class f {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f51232b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f51231a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 * 2;
            char[] cArr2 = f51232b;
            cArr[i5 + 1] = cArr2[b4 & 15];
            cArr[i5 + 0] = cArr2[((byte) (b4 >>> 4)) & 15];
        }
        return new String(cArr);
    }
}

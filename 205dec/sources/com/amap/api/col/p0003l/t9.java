package com.amap.api.col.p0003l;

import java.text.SimpleDateFormat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DataTypeUtil.java */
/* renamed from: com.amap.api.col.3l.t9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t9 {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f9108a;

    /* renamed from: b  reason: collision with root package name */
    private static String f9109b;

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            String hexString = Integer.toHexString(bArr[i4] & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            if (str.length() > 0 && i4 < bArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static byte[] b(long j4) {
        byte[] bArr = new byte[6];
        for (int i4 = 0; i4 < 6; i4++) {
            bArr[i4] = (byte) ((j4 >> (((6 - i4) - 1) * 8)) & 255);
        }
        return bArr;
    }
}

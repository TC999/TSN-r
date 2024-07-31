package com.amap.api.col.p0463l;

import java.text.SimpleDateFormat;
import kotlin.UByte;

/* renamed from: com.amap.api.col.3l.s9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DataTypeUtil {

    /* renamed from: a */
    private static SimpleDateFormat f5329a;

    /* renamed from: b */
    private static String f5330b;

    /* renamed from: a */
    public static String m53904a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & UByte.f41242c);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            if (str.length() > 0 && i < bArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static byte[] m53903b(long j) {
        byte[] bArr = new byte[6];
        for (int i = 0; i < 6; i++) {
            bArr[i] = (byte) ((j >> (((6 - i) - 1) * 8)) & 255);
        }
        return bArr;
    }
}

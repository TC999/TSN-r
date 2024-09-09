package com.beizi.ad.internal.utilities;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Hex {
    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i4 = 0; i4 < length; i4 += 2) {
            bArr[i4 / 2] = (byte) ((Character.digit(str.charAt(i4), 16) << 4) + Character.digit(str.charAt(i4 + 1), 16));
        }
        return bArr;
    }
}

package com.beizi.p051ad.internal.utilities;

/* renamed from: com.beizi.ad.internal.utilities.Hex */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Hex {
    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}

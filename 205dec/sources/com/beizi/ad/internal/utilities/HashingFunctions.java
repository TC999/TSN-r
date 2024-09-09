package com.beizi.ad.internal.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HashingFunctions {
    private static String byteToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b4 : bArr) {
            int i4 = (b4 >>> 4) & 15;
            int i5 = 0;
            while (true) {
                sb.append((char) ((i4 < 0 || i4 > 9) ? (i4 - 10) + 97 : i4 + 48));
                i4 = b4 & 15;
                int i6 = i5 + 1;
                if (i5 >= 1) {
                    break;
                }
                i5 = i6;
            }
        }
        return sb.toString();
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String sha1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            return byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}

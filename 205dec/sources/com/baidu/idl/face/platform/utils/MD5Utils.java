package com.baidu.idl.face.platform.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MD5Utils {
    public static String encryption(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i4));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return "";
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }
}

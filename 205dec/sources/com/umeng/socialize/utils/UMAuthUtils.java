package com.umeng.socialize.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMAuthUtils {
    public static String decrypt(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bytes = str2.getBytes();
        int i4 = 32;
        if (bytes.length < 16) {
            bytes = new byte[16];
            Arrays.fill(bytes, (byte) 1);
            System.arraycopy(bytes, 0, str2.getBytes(), 0, str2.length());
            i4 = 16;
        } else if (bytes.length <= 32) {
            if (bytes.length % 8 != 0) {
                i4 = bytes.length - (bytes.length % 8);
            } else {
                i4 = bytes.length;
            }
        }
        cipher.init(2, new SecretKeySpec(bytes, 0, i4, "AES"), new IvParameterSpec(Arrays.copyOfRange(bytes, 0, 16)));
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }

    public static String encrypt(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bytes = str2.getBytes();
        int i4 = 32;
        if (bytes.length < 16) {
            bytes = new byte[16];
            Arrays.fill(bytes, (byte) 1);
            System.arraycopy(bytes, 0, str2.getBytes(), 0, str2.length());
            i4 = 16;
        } else if (bytes.length <= 32) {
            if (bytes.length % 8 != 0) {
                i4 = bytes.length - (bytes.length % 8);
            } else {
                i4 = bytes.length;
            }
        }
        cipher.init(1, new SecretKeySpec(bytes, 0, i4, "AES"), new IvParameterSpec(Arrays.copyOfRange(bytes, 0, 16)));
        return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
    }
}

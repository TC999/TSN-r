package xyz.adscope.common.tool.security;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AesUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f65047a = decryptStr("\u007f}{y<usqomkigeca");

    public static String decrypt(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f65047a.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(Base64.decode(str2, 0)));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptByte(byte[] bArr) {
        return decryptByte(KeyGenerator.generateAesKey(), f65047a, bArr);
    }

    public static String decryptStr(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            for (int i4 = 0; i4 < sb.length(); i4++) {
                sb.setCharAt(i4, (char) (sb.charAt(i4) - i4));
            }
            return sb.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f65047a.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str2.getBytes()), 2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptByte(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptByte(byte[] bArr) {
        return encryptByte(KeyGenerator.generateAesKey(), f65047a, bArr);
    }

    public static String encryptStr(String str) {
        try {
            StringBuilder sb = new StringBuilder(str);
            for (int i4 = 0; i4 < sb.length(); i4++) {
                sb.setCharAt(i4, (char) (sb.charAt(i4) + i4));
            }
            sb.reverse();
            return sb.toString();
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}

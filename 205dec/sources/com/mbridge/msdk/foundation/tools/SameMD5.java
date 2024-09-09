package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.system.NoProGuard;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SameMD5 implements NoProGuard {
    public static final String TAG = "MD5";

    public static String ByteArrayToHexString(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length * 2;
        byte[] bArr2 = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr2[i4] = 48;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        bArr3[0] = 0;
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] bytes = new BigInteger(bArr3).toString(16).getBytes();
        System.arraycopy(bytes, 0, bArr2, length - bytes.length, bytes.length);
        return new String(bArr2);
    }

    private static String HexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append(Integer.toHexString((b4 & 240) >>> 4));
            sb.append(Integer.toHexString(b4 & 15));
        }
        return sb.toString().toLowerCase(Locale.US);
    }

    private static String UpHexEncode(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append(Integer.toHexString((b4 & 240) >>> 4));
            sb.append(Integer.toHexString(b4 & 15));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    public static String getMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            x.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return HexEncode(messageDigest.digest());
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String getQftJSMD5(String str) {
        try {
            byte[] qftJSMD5Bytes = getQftJSMD5Bytes(str);
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(qftJSMD5Bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i4 = 0;
            for (byte b4 : digest) {
                int i5 = i4 + 1;
                cArr2[i4] = cArr[(b4 >>> 4) & 15];
                i4 = i5 + 1;
                cArr2[i5] = cArr[b4 & 15];
            }
            return new String(cArr2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static byte[] getQftJSMD5Bytes(String str) throws UnsupportedEncodingException {
        int length = str.length();
        byte[] bytes = str.getBytes("UTF-16LE");
        x.b("----", "b = " + ByteArrayToHexString(bytes));
        byte[] bArr = new byte[length];
        int i4 = 0;
        for (int i5 = 0; i5 < bytes.length; i5 += 2) {
            if (bytes[i5] != -1 && bytes[i5] != -2) {
                bArr[i4] = bytes[i5];
                i4++;
                if (i4 == length) {
                    break;
                }
            }
        }
        x.b("----", "source = " + ByteArrayToHexString(bArr));
        return bArr;
    }

    public static String getUPMD5(String str) {
        try {
            x.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return UpHexEncode(messageDigest.digest());
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return "";
        }
    }
}

package xyz.adscope.common.network.secure;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Encryption {
    public static String byteArrayToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 : bArr) {
            while (i4 < 0) {
                i4 += 256;
            }
            if (i4 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(i4, 16));
        }
        return sb.toString();
    }

    public static Secret createSecret(String str) {
        try {
            return new AESSecret(str);
        } catch (GeneralSecurityException unused) {
            return new SafeSecret();
        }
    }

    public static String getMD5ForString(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int length = digest.length;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = digest[i4];
                if (i5 < 0) {
                    i5 += 256;
                }
                if (i5 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i5));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static byte[] hexToByteArray(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length / 2];
        for (int i4 = 0; i4 < length; i4 += 2) {
            bArr[i4 / 2] = (byte) Integer.parseInt(new String(bytes, i4, 2), 16);
        }
        return bArr;
    }
}

package com.amap.api.col.s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Encrypt.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f9753a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f9754b = new byte[128];

    static {
        for (int i4 = 0; i4 < 128; i4++) {
            f9754b[i4] = -1;
        }
        for (int i5 = 65; i5 <= 90; i5++) {
            f9754b[i5] = (byte) (i5 - 65);
        }
        for (int i6 = 97; i6 <= 122; i6++) {
            f9754b[i6] = (byte) ((i6 - 97) + 26);
        }
        for (int i7 = 48; i7 <= 57; i7++) {
            f9754b[i7] = (byte) ((i7 - 48) + 52);
        }
        byte[] bArr = f9754b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return j1.g(g(str));
    }

    public static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(j1.t("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey w3 = j1.w();
        if (w3 == null) {
            return null;
        }
        byte[] c4 = c(encoded, w3);
        byte[] d4 = d(encoded, bArr);
        byte[] bArr2 = new byte[c4.length + d4.length];
        System.arraycopy(c4, 0, bArr2, 0, c4.length);
        System.arraycopy(d4, 0, bArr2, c4.length, d4.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(j1.t("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return j(bArr, bArr2, j1.u());
        } catch (Throwable th) {
            d2.e(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, j1.t("EQUVT"));
        Cipher cipher = Cipher.getInstance(j1.t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String f(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            d2.e(th, "er", "e64");
            return null;
        }
    }

    public static byte[] g(String str) {
        int i4;
        byte b4;
        int i5;
        byte b5;
        int i6 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] o4 = j1.o(str);
        int length = o4.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i6 < length) {
            while (true) {
                i4 = i6 + 1;
                b4 = f9754b[o4[i6]];
                if (i4 >= length || b4 != -1) {
                    break;
                }
                i6 = i4;
            }
            if (b4 == -1) {
                break;
            }
            while (true) {
                i5 = i4 + 1;
                b5 = f9754b[o4[i4]];
                if (i5 >= length || b5 != -1) {
                    break;
                }
                i4 = i5;
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write((b4 << 2) | ((b5 & 48) >>> 4));
            while (i5 != length) {
                int i7 = i5 + 1;
                byte b6 = o4[i5];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b7 = f9754b[b6];
                if (i7 >= length || b7 != -1) {
                    if (b7 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b5 & 15) << 4) | ((b7 & 60) >>> 2));
                    while (i7 != length) {
                        int i8 = i7 + 1;
                        byte b8 = o4[i7];
                        if (b8 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b9 = f9754b[b8];
                        if (i8 < length && b9 == -1) {
                            i7 = i8;
                        } else if (b9 == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(b9 | ((b7 & 3) << 6));
                            i6 = i8;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i5 = i7;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return j(bArr, bArr2, bArr3);
    }

    public static String i(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, j1.t("EQUVT"));
        Cipher cipher = Cipher.getInstance(j1.t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    private static String k(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            int i5 = i4 + 1;
            int i6 = bArr[i4] & 255;
            if (i5 == length) {
                char[] cArr = f9753a;
                stringBuffer.append(cArr[i6 >>> 2]);
                stringBuffer.append(cArr[(i6 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            if (i7 == length) {
                char[] cArr2 = f9753a;
                stringBuffer.append(cArr2[i6 >>> 2]);
                stringBuffer.append(cArr2[((i6 & 3) << 4) | ((i8 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i8 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i9 = i7 + 1;
            int i10 = bArr[i7] & 255;
            char[] cArr3 = f9753a;
            stringBuffer.append(cArr3[i6 >>> 2]);
            stringBuffer.append(cArr3[((i6 & 3) << 4) | ((i8 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i8 & 15) << 2) | ((i10 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i10 & 63]);
            i4 = i9;
        }
        return stringBuffer.toString();
    }
}

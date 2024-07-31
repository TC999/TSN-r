package com.amap.api.col.p047s;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
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
import kotlin.UByte;
import okio.Utf8;

/* compiled from: Encrypt.java */
/* renamed from: com.amap.api.col.s.d1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2040d1 {

    /* renamed from: a */
    private static final char[] f6025a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b */
    private static final byte[] f6026b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f6026b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f6026b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f6026b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f6026b[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = f6026b;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    /* renamed from: a */
    public static String m53096a(String str) {
        return C2079j1.m52870g(m53090g(str));
    }

    /* renamed from: b */
    public static byte[] m53095b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(C2079j1.m52857t("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey m52854w = C2079j1.m52854w();
        if (m52854w == null) {
            return null;
        }
        byte[] m53094c = m53094c(encoded, m52854w);
        byte[] m53093d = m53093d(encoded, bArr);
        byte[] bArr2 = new byte[m53094c.length + m53093d.length];
        System.arraycopy(m53094c, 0, bArr2, 0, m53094c.length);
        System.arraycopy(m53093d, 0, bArr2, m53094c.length, m53093d.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static byte[] m53094c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(C2079j1.m52857t("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    /* renamed from: d */
    private static byte[] m53093d(byte[] bArr, byte[] bArr2) {
        try {
            return m53087j(bArr, bArr2, C2079j1.m52856u());
        } catch (Throwable th) {
            C2041d2.m53085e(th, "er", "asEn");
            return null;
        }
    }

    /* renamed from: e */
    public static byte[] m53092e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, C2079j1.m52857t("EQUVT"));
        Cipher cipher = Cipher.getInstance(C2079j1.m52857t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    /* renamed from: f */
    public static String m53091f(byte[] bArr) {
        try {
            return m53086k(bArr);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "er", "e64");
            return null;
        }
    }

    /* renamed from: g */
    public static byte[] m53090g(String str) {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] m52862o = C2079j1.m52862o(str);
        int length = m52862o.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b = f6026b[m52862o[i3]];
                if (i >= length || b != -1) {
                    break;
                }
                i3 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = f6026b[m52862o[i]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (i2 != length) {
                int i4 = i2 + 1;
                byte b3 = m52862o[i2];
                if (b3 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b4 = f6026b[b3];
                if (i4 >= length || b4 != -1) {
                    if (b4 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b4 & 60) >>> 2));
                    while (i4 != length) {
                        int i5 = i4 + 1;
                        byte b5 = m52862o[i4];
                        if (b5 == 61) {
                            return byteArrayOutputStream.toByteArray();
                        }
                        byte b6 = f6026b[b5];
                        if (i5 < length && b6 == -1) {
                            i4 = i5;
                        } else if (b6 == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(b6 | ((b4 & 3) << 6));
                            i3 = i5;
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                }
                i2 = i4;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: h */
    public static byte[] m53089h(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return m53087j(bArr, bArr2, bArr3);
    }

    /* renamed from: i */
    public static String m53088i(byte[] bArr) {
        try {
            return m53086k(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: j */
    private static byte[] m53087j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, C2079j1.m52857t("EQUVT"));
        Cipher cipher = Cipher.getInstance(C2079j1.m52857t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    /* renamed from: k */
    private static String m53086k(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & UByte.f41242c;
            if (i2 == length) {
                char[] cArr = f6025a;
                stringBuffer.append(cArr[i3 >>> 2]);
                stringBuffer.append(cArr[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & UByte.f41242c;
            if (i4 == length) {
                char[] cArr2 = f6025a;
                stringBuffer.append(cArr2[i3 >>> 2]);
                stringBuffer.append(cArr2[((i3 & 3) << 4) | ((i5 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
                stringBuffer.append(cArr2[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & UByte.f41242c;
            char[] cArr3 = f6025a;
            stringBuffer.append(cArr3[i3 >>> 2]);
            stringBuffer.append(cArr3[((i3 & 3) << 4) | ((i5 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
            stringBuffer.append(cArr3[((i5 & 15) << 2) | ((i7 & Opcodes.CHECKCAST) >>> 6)]);
            stringBuffer.append(cArr3[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }
}

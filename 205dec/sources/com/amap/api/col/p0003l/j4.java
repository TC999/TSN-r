package com.amap.api.col.p0003l;

import android.content.Context;
import com.stub.StubApp;
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
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Encrypt.java */
/* renamed from: com.amap.api.col.3l.j4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class j4 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f8210a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f8211b = new byte[128];

    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.j4$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static j4 f8212a = new j4();
    }

    static {
        for (int i4 = 0; i4 < 128; i4++) {
            f8211b[i4] = -1;
        }
        for (int i5 = 65; i5 <= 90; i5++) {
            f8211b[i5] = (byte) (i5 - 65);
        }
        for (int i6 = 97; i6 <= 122; i6++) {
            f8211b[i6] = (byte) ((i6 - 97) + 26);
        }
        for (int i7 = 48; i7 <= 57; i7++) {
            f8211b[i7] = (byte) ((i7 - 48) + 52);
        }
        byte[] bArr = f8211b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static String a(String str) {
        return q4.g(g(str));
    }

    public static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(q4.u("EQUVT"));
        if (keyGenerator == null) {
            return null;
        }
        keyGenerator.init(256);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        PublicKey x3 = q4.x();
        if (x3 == null) {
            return null;
        }
        byte[] c4 = c(encoded, x3);
        byte[] d4 = d(encoded, bArr);
        byte[] bArr2 = new byte[c4.length + d4.length];
        System.arraycopy(c4, 0, bArr2, 0, c4.length);
        System.arraycopy(d4, 0, bArr2, c4.length, d4.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(q4.u("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        try {
            return j(bArr, bArr2, q4.v());
        } catch (Throwable th) {
            q5.e(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, q4.u("EQUVT"));
        Cipher cipher = Cipher.getInstance(q4.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String f(byte[] bArr) {
        try {
            return k(bArr);
        } catch (Throwable th) {
            q5.e(th, "er", "e64");
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
        byte[] o4 = q4.o(str);
        int length = o4.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i6 < length) {
            while (true) {
                i4 = i6 + 1;
                b4 = f8211b[o4[i6]];
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
                b5 = f8211b[o4[i4]];
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
                byte b7 = f8211b[b6];
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
                        byte b9 = f8211b[b8];
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
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, q4.u("EQUVT"));
        Cipher cipher = Cipher.getInstance(q4.u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
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
                char[] cArr = f8210a;
                stringBuffer.append(cArr[i6 >>> 2]);
                stringBuffer.append(cArr[(i6 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            if (i7 == length) {
                char[] cArr2 = f8210a;
                stringBuffer.append(cArr2[i6 >>> 2]);
                stringBuffer.append(cArr2[((i6 & 3) << 4) | ((i8 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i8 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i9 = i7 + 1;
            int i10 = bArr[i7] & 255;
            char[] cArr3 = f8210a;
            stringBuffer.append(cArr3[i6 >>> 2]);
            stringBuffer.append(cArr3[((i6 & 3) << 4) | ((i8 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i8 & 15) << 2) | ((i10 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i10 & 63]);
            i4 = i9;
        }
        return stringBuffer.toString();
    }

    /* compiled from: HttpsDecisionUtil.java */
    /* renamed from: com.amap.api.col.3l.j4$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private int f8213a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f8214b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f8215c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8216d;

        private b() {
            this.f8213a = 0;
            this.f8214b = true;
            this.f8215c = true;
            this.f8216d = false;
        }

        public final void a(Context context) {
            if (context != null && this.f8213a <= 0) {
                this.f8213a = StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z3) {
            this.f8214b = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() {
            /*
                r5 = this;
                boolean r0 = r5.f8216d
                r1 = 1
                if (r0 != 0) goto L2f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                boolean r4 = r5.f8214b
                if (r4 == 0) goto L23
                int r4 = r5.f8213a
                if (r4 > 0) goto L19
                r4 = 28
            L19:
                if (r4 < r2) goto L1d
                r2 = 1
                goto L1e
            L1d:
                r2 = 0
            L1e:
                if (r2 == 0) goto L21
                goto L23
            L21:
                r2 = 0
                goto L24
            L23:
                r2 = 1
            L24:
                if (r0 == 0) goto L2a
                if (r2 == 0) goto L2a
                r0 = 1
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L2e
                goto L2f
            L2e:
                return r3
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.j4.b.c():boolean");
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }
}

package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.security.MessageDigest;

/* compiled from: DigestUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f649a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String a(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                int i6 = i5 * 2;
                char[] cArr = new char[i6];
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = bArr[i8 + i4] & 255;
                    int i10 = i7 + 1;
                    char[] cArr2 = f649a;
                    cArr[i7] = cArr2[i9 >> 4];
                    i7 = i10 + 1;
                    cArr[i10] = cArr2[i9 & 15];
                }
                return new String(cArr, 0, i6);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return a(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DigestUtils {

    /* renamed from: a */
    private static final char[] f656a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m59204a(byte[] bArr) {
        if (bArr != null) {
            return m59203a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m59203a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i >= 0 && i + i2 <= bArr.length) {
                int i3 = i2 * 2;
                char[] cArr = new char[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = bArr[i5 + i] & UByte.f41242c;
                    int i7 = i4 + 1;
                    char[] cArr2 = f656a;
                    cArr[i4] = cArr2[i6 >> 4];
                    i4 = i7 + 1;
                    cArr[i7] = cArr2[i6 & 15];
                }
                return new String(cArr, 0, i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m59205a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return m59204a(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

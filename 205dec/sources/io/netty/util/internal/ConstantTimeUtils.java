package io.netty.util.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ConstantTimeUtils {
    private ConstantTimeUtils() {
    }

    public static int equalsConstantTime(int i4, int i5) {
        int i6 = (i4 ^ i5) ^ (-1);
        int i7 = i6 & (i6 >> 16);
        int i8 = i7 & (i7 >> 8);
        int i9 = i8 & (i8 >> 4);
        int i10 = i9 & (i9 >> 2);
        return i10 & (i10 >> 1) & 1;
    }

    public static int equalsConstantTime(long j4, long j5) {
        long j6 = (j4 ^ j5) ^ (-1);
        long j7 = j6 & (j6 >> 32);
        long j8 = j7 & (j7 >> 16);
        long j9 = j8 & (j8 >> 8);
        long j10 = j9 & (j9 >> 4);
        long j11 = j10 & (j10 >> 2);
        return (int) (j11 & (j11 >> 1) & 1);
    }

    public static int equalsConstantTime(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        int i7 = i6 + i4;
        int i8 = 0;
        while (i4 < i7) {
            i8 |= bArr[i4] ^ bArr2[i5];
            i4++;
            i5++;
        }
        return equalsConstantTime(i8, 0);
    }

    public static int equalsConstantTime(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            i4 |= charSequence.charAt(i5) ^ charSequence2.charAt(i5);
        }
        return equalsConstantTime(i4, 0);
    }
}

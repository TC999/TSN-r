package io.netty.util.internal;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ConstantTimeUtils {
    private ConstantTimeUtils() {
    }

    public static int equalsConstantTime(int i, int i2) {
        int i3 = (i ^ i2) ^ (-1);
        int i4 = i3 & (i3 >> 16);
        int i5 = i4 & (i4 >> 8);
        int i6 = i5 & (i5 >> 4);
        int i7 = i6 & (i6 >> 2);
        return i7 & (i7 >> 1) & 1;
    }

    public static int equalsConstantTime(long j, long j2) {
        long j3 = (j ^ j2) ^ (-1);
        long j4 = j3 & (j3 >> 32);
        long j5 = j4 & (j4 >> 16);
        long j6 = j5 & (j5 >> 8);
        long j7 = j6 & (j6 >> 4);
        long j8 = j7 & (j7 >> 2);
        return (int) (j8 & (j8 >> 1) & 1);
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i3 + i;
        int i5 = 0;
        while (i < i4) {
            i5 |= bArr[i] ^ bArr2[i2];
            i++;
            i2++;
        }
        return equalsConstantTime(i5, 0);
    }

    public static int equalsConstantTime(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i |= charSequence.charAt(i2) ^ charSequence2.charAt(i2);
        }
        return equalsConstantTime(i, 0);
    }
}

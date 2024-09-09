package io.netty.util.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MathUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private MathUtil() {
    }

    public static int compare(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        return i4 > i5 ? 1 : 0;
    }

    public static int compare(long j4, long j5) {
        if (j4 < j5) {
            return -1;
        }
        return j4 > j5 ? 1 : 0;
    }

    public static int findNextPositivePowerOfTwo(int i4) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
    }

    public static boolean isOutOfBounds(int i4, int i5, int i6) {
        int i7 = i4 | i5;
        int i8 = i4 + i5;
        return ((i7 | i8) | (i6 - i8)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i4) {
        if (i4 <= 0) {
            return 1;
        }
        if (i4 >= 1073741824) {
            return 1073741824;
        }
        return findNextPositivePowerOfTwo(i4);
    }
}

package io.netty.util.internal.shaded.org.jctools.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j4, int i4) {
        int i5;
        if (isPowerOfTwo(i4)) {
            return (j4 + (i4 - 1)) & (i5 ^ (-1));
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i4);
    }

    public static boolean isPowerOfTwo(int i4) {
        return (i4 & (i4 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i4) {
        if (i4 > 1073741824) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i4 + " since it exceeds 2^31.");
        } else if (i4 >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
        } else {
            throw new IllegalArgumentException("Given value:" + i4 + ". Expecting value >= 0.");
        }
    }
}

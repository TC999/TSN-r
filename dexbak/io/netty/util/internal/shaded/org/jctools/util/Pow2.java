package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    private Pow2() {
    }

    public static long align(long j, int i) {
        int i2;
        if (isPowerOfTwo(i)) {
            return (j + (i - 1)) & (i2 ^ (-1));
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i);
    }

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        if (i <= 1073741824) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i + " since it exceeds 2^31.");
    }
}

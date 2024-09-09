package io.netty.util.internal.shaded.org.jctools.util;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RangeUtil {
    public static int checkGreaterThanOrEqual(int i4, int i5, String str) {
        if (i4 >= i5) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: >= " + i5 + ')');
    }

    public static int checkLessThan(int i4, int i5, String str) {
        if (i4 < i5) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: < " + i5 + ')');
    }

    public static int checkLessThanOrEqual(int i4, long j4, String str) {
        if (i4 <= j4) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: <= " + j4 + ')');
    }

    public static long checkPositive(long j4, String str) {
        if (j4 > 0) {
            return j4;
        }
        throw new IllegalArgumentException(str + ": " + j4 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i4, String str) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: >= 0)");
    }
}

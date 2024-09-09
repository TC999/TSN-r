package io.netty.util.internal;

import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObjectUtil {
    private ObjectUtil() {
    }

    public static <T> T[] checkNonEmpty(T[] tArr, String str) {
        checkNotNull(tArr, str);
        int length = tArr.length;
        checkPositive(length, str + ".length");
        return tArr;
    }

    public static <T> T checkNotNull(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    public static int checkPositive(int i4, String str) {
        if (i4 > 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i4, String str) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + ": " + i4 + " (expected: >= 0)");
    }

    public static int intValue(Integer num, int i4) {
        return num != null ? num.intValue() : i4;
    }

    public static long longValue(Long l4, long j4) {
        return l4 != null ? l4.longValue() : j4;
    }

    public static long checkPositive(long j4, String str) {
        if (j4 > 0) {
            return j4;
        }
        throw new IllegalArgumentException(str + ": " + j4 + " (expected: > 0)");
    }

    public static long checkPositiveOrZero(long j4, String str) {
        if (j4 >= 0) {
            return j4;
        }
        throw new IllegalArgumentException(str + ": " + j4 + " (expected: >= 0)");
    }

    public static <T extends Collection<?>> T checkNonEmpty(T t3, String str) {
        checkNotNull(t3, str);
        int size = t3.size();
        checkPositive(size, str + ".size");
        return t3;
    }
}

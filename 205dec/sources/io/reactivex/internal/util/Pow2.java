package io.reactivex.internal.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int i4) {
        return (i4 & (i4 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i4) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i4 - 1));
    }
}

package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BackpressureHelper {
    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long add(AtomicLong atomicLong, long j4) {
        long j5;
        do {
            j5 = atomicLong.get();
            if (j5 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j5, addCap(j5, j4)));
        return j5;
    }

    public static long addCancel(AtomicLong atomicLong, long j4) {
        long j5;
        do {
            j5 = atomicLong.get();
            if (j5 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j5 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j5, addCap(j5, j4)));
        return j5;
    }

    public static long addCap(long j4, long j5) {
        long j6 = j4 + j5;
        if (j6 < 0) {
            return Long.MAX_VALUE;
        }
        return j6;
    }

    public static long multiplyCap(long j4, long j5) {
        long j6 = j4 * j5;
        if (((j4 | j5) >>> 31) == 0 || j6 / j4 == j5) {
            return j6;
        }
        return Long.MAX_VALUE;
    }

    public static long produced(AtomicLong atomicLong, long j4) {
        long j5;
        long j6;
        do {
            j5 = atomicLong.get();
            if (j5 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j6 = j5 - j4;
            if (j6 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j6));
                j6 = 0L;
            }
        } while (!atomicLong.compareAndSet(j5, j6));
        return j6;
    }

    public static long producedCancel(AtomicLong atomicLong, long j4) {
        long j5;
        long j6;
        do {
            j5 = atomicLong.get();
            if (j5 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j5 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j6 = j5 - j4;
            if (j6 < 0) {
                RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j6));
                j6 = 0L;
            }
        } while (!atomicLong.compareAndSet(j5, j6));
        return j6;
    }
}

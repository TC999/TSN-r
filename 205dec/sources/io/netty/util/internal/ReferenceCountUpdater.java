package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class ReferenceCountUpdater<T extends ReferenceCounted> {
    public static long getUnsafeOffset(Class<? extends ReferenceCounted> cls, String str) {
        try {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.objectFieldOffset(cls.getDeclaredField(str));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private boolean nonFinalRelease0(T t3, int i4, int i5, int i6) {
        if (i4 >= i6 || !updater().compareAndSet(t3, i5, i5 - (i4 << 1))) {
            return retryRelease0(t3, i4);
        }
        return false;
    }

    private int nonVolatileRawCnt(T t3) {
        long unsafeOffset = unsafeOffset();
        return unsafeOffset != -1 ? PlatformDependent.getInt(t3, unsafeOffset) : updater().get(t3);
    }

    private static int realRefCnt(int i4) {
        if (i4 == 2 || i4 == 4 || (i4 & 1) == 0) {
            return i4 >>> 1;
        }
        return 0;
    }

    private T retain0(T t3, int i4, int i5) {
        int andAdd = updater().getAndAdd(t3, i5);
        if (andAdd == 2 || andAdd == 4 || (andAdd & 1) == 0) {
            if ((andAdd > 0 || andAdd + i5 < 0) && (andAdd < 0 || andAdd + i5 >= andAdd)) {
                return t3;
            }
            updater().getAndAdd(t3, -i5);
            throw new IllegalReferenceCountException(realRefCnt(andAdd), i4);
        }
        throw new IllegalReferenceCountException(0, i4);
    }

    private boolean retryRelease0(T t3, int i4) {
        while (true) {
            int i5 = updater().get(t3);
            int liveRealRefCnt = toLiveRealRefCnt(i5, i4);
            if (i4 == liveRealRefCnt) {
                if (tryFinalRelease0(t3, i5)) {
                    return true;
                }
            } else if (i4 < liveRealRefCnt) {
                if (updater().compareAndSet(t3, i5, i5 - (i4 << 1))) {
                    return false;
                }
            } else {
                throw new IllegalReferenceCountException(liveRealRefCnt, -i4);
            }
            Thread.yield();
        }
    }

    private static int toLiveRealRefCnt(int i4, int i5) {
        if (i4 == 2 || i4 == 4 || (i4 & 1) == 0) {
            return i4 >>> 1;
        }
        throw new IllegalReferenceCountException(0, -i5);
    }

    private boolean tryFinalRelease0(T t3, int i4) {
        return updater().compareAndSet(t3, i4, 1);
    }

    public final int initialValue() {
        return 2;
    }

    public final boolean isLiveNonVolatile(T t3) {
        long unsafeOffset = unsafeOffset();
        int i4 = unsafeOffset != -1 ? PlatformDependent.getInt(t3, unsafeOffset) : updater().get(t3);
        return i4 == 2 || i4 == 4 || i4 == 6 || i4 == 8 || (i4 & 1) == 0;
    }

    public final int refCnt(T t3) {
        return realRefCnt(updater().get(t3));
    }

    public final boolean release(T t3) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t3);
        if (nonVolatileRawCnt == 2) {
            return tryFinalRelease0(t3, 2) || retryRelease0(t3, 1);
        }
        return nonFinalRelease0(t3, 1, nonVolatileRawCnt, toLiveRealRefCnt(nonVolatileRawCnt, 1));
    }

    public final void resetRefCnt(T t3) {
        updater().set(t3, initialValue());
    }

    public final T retain(T t3) {
        return retain0(t3, 1, 2);
    }

    public final void setRefCnt(T t3, int i4) {
        updater().set(t3, i4 > 0 ? i4 << 1 : 1);
    }

    protected abstract long unsafeOffset();

    protected abstract AtomicIntegerFieldUpdater<T> updater();

    public final T retain(T t3, int i4) {
        return retain0(t3, i4, ObjectUtil.checkPositive(i4, "increment") << 1);
    }

    public final boolean release(T t3, int i4) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t3);
        int liveRealRefCnt = toLiveRealRefCnt(nonVolatileRawCnt, ObjectUtil.checkPositive(i4, "decrement"));
        if (i4 == liveRealRefCnt) {
            return tryFinalRelease0(t3, nonVolatileRawCnt) || retryRelease0(t3, i4);
        }
        return nonFinalRelease0(t3, i4, nonVolatileRawCnt, liveRealRefCnt);
    }
}

package io.netty.util.internal.chmv8;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public abstract class CountedCompleter<T> extends ForkJoinTask<T> {
    private static final long PENDING;
    private static final Unsafe U;
    private static final long serialVersionUID = 5232453752276485070L;
    final CountedCompleter<?> completer;
    volatile int pending;

    static {
        try {
            Unsafe unsafe = getUnsafe();
            U = unsafe;
            PENDING = unsafe.objectFieldOffset(CountedCompleter.class.getDeclaredField("pending"));
        } catch (Exception e4) {
            throw new Error(e4);
        }
    }

    protected CountedCompleter(CountedCompleter<?> countedCompleter, int i4) {
        this.completer = countedCompleter;
        this.pending = i4;
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.CountedCompleter.1
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        Field[] declaredFields;
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e4) {
            throw new RuntimeException("Could not initialize intrinsics", e4.getCause());
        }
    }

    public final void addToPendingCount(int i4) {
        Unsafe unsafe;
        long j4;
        int i5;
        do {
            unsafe = U;
            j4 = PENDING;
            i5 = this.pending;
        } while (!unsafe.compareAndSwapInt(this, j4, i5, i5 + i4));
    }

    public final boolean compareAndSetPendingCount(int i4, int i5) {
        return U.compareAndSwapInt(this, PENDING, i4, i5);
    }

    @Override // io.netty.util.internal.chmv8.ForkJoinTask
    public void complete(T t3) {
        setRawResult(t3);
        onCompletion(this);
        quietlyComplete();
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            countedCompleter.tryComplete();
        }
    }

    public abstract void compute();

    public final int decrementPendingCountUnlessZero() {
        int i4;
        do {
            i4 = this.pending;
            if (i4 == 0) {
                break;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i4, i4 - 1));
        return i4;
    }

    @Override // io.netty.util.internal.chmv8.ForkJoinTask
    protected final boolean exec() {
        compute();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> firstComplete() {
        int i4;
        do {
            i4 = this.pending;
            if (i4 == 0) {
                return this;
            }
        } while (!U.compareAndSwapInt(this, PENDING, i4, i4 - 1));
        return null;
    }

    public final CountedCompleter<?> getCompleter() {
        return this.completer;
    }

    public final int getPendingCount() {
        return this.pending;
    }

    @Override // io.netty.util.internal.chmv8.ForkJoinTask
    public T getRawResult() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> getRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                return countedCompleter;
            }
            countedCompleter = countedCompleter2;
        }
    }

    @Override // io.netty.util.internal.chmv8.ForkJoinTask
    void internalPropagateException(Throwable th) {
        CountedCompleter<?> countedCompleter;
        CountedCompleter<?> countedCompleter2 = this;
        CountedCompleter<?> countedCompleter3 = countedCompleter2;
        while (countedCompleter2.onExceptionalCompletion(th, countedCompleter3) && (countedCompleter = countedCompleter2.completer) != null && countedCompleter.status >= 0 && countedCompleter.recordExceptionalCompletion(th) == Integer.MIN_VALUE) {
            countedCompleter3 = countedCompleter2;
            countedCompleter2 = countedCompleter;
        }
    }

    public final CountedCompleter<?> nextComplete() {
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            return countedCompleter.firstComplete();
        }
        quietlyComplete();
        return null;
    }

    public void onCompletion(CountedCompleter<?> countedCompleter) {
    }

    public boolean onExceptionalCompletion(Throwable th, CountedCompleter<?> countedCompleter) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void propagateCompletion() {
        CountedCompleter countedCompleter = this;
        while (true) {
            int i4 = countedCompleter.pending;
            if (i4 == 0) {
                CountedCompleter countedCompleter2 = countedCompleter.completer;
                if (countedCompleter2 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                }
                countedCompleter = countedCompleter2;
            } else {
                if (U.compareAndSwapInt(countedCompleter, PENDING, i4, i4 - 1)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void quietlyCompleteRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                countedCompleter.quietlyComplete();
                return;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void setPendingCount(int i4) {
        this.pending = i4;
    }

    @Override // io.netty.util.internal.chmv8.ForkJoinTask
    protected void setRawResult(T t3) {
    }

    public final void tryComplete() {
        CountedCompleter<?> countedCompleter = this;
        CountedCompleter<?> countedCompleter2 = countedCompleter;
        while (true) {
            int i4 = countedCompleter.pending;
            if (i4 == 0) {
                countedCompleter.onCompletion(countedCompleter2);
                CountedCompleter<?> countedCompleter3 = countedCompleter.completer;
                if (countedCompleter3 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                } else {
                    countedCompleter2 = countedCompleter;
                    countedCompleter = countedCompleter3;
                }
            } else {
                if (U.compareAndSwapInt(countedCompleter, PENDING, i4, i4 - 1)) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CountedCompleter(CountedCompleter<?> countedCompleter) {
        this.completer = countedCompleter;
    }

    protected CountedCompleter() {
        this.completer = null;
    }
}

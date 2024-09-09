package io.netty.util.internal.chmv8;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0  reason: collision with root package name */
        volatile long f54816p0;

        /* renamed from: p1  reason: collision with root package name */
        volatile long f54817p1;

        /* renamed from: p2  reason: collision with root package name */
        volatile long f54818p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;

        /* renamed from: q0  reason: collision with root package name */
        volatile long f54819q0;

        /* renamed from: q1  reason: collision with root package name */
        volatile long f54820q1;

        /* renamed from: q2  reason: collision with root package name */
        volatile long f54821q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        static {
            try {
                Unsafe access$000 = Striped64.access$000();
                UNSAFE = access$000;
                valueOffset = access$000.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e4) {
                throw new Error(e4);
            }
        }

        Cell(long j4) {
            this.value = j4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean cas(long j4, long j5) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j4, j5);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e4) {
            throw new Error(e4);
        }
    }

    static /* synthetic */ Unsafe access$000() {
        return getUnsafe();
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.Striped64.1
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casBase(long j4, long j5) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j4, j5);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long j4, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalReset(long j4) {
        Cell[] cellArr = this.cells;
        this.base = j4;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void retryUpdate(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.Striped64.retryUpdate(long, int[], boolean):void");
    }
}

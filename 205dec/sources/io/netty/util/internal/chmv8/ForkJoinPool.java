package io.netty.util.internal.chmv8;

import io.netty.util.internal.ThreadLocalRandom;
import io.netty.util.internal.a;
import io.netty.util.internal.chmv8.ForkJoinTask;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class ForkJoinPool extends AbstractExecutorService {
    private static final int ABASE;
    private static final long AC_MASK = -281474976710656L;
    private static final int AC_SHIFT = 48;
    private static final long AC_UNIT = 281474976710656L;
    private static final int ASHIFT;
    private static final long CTL;
    private static final int EC_SHIFT = 16;
    private static final int EVENMASK = 65534;
    private static final int E_MASK = Integer.MAX_VALUE;
    private static final int E_SEQ = 65536;
    private static final long FAST_IDLE_TIMEOUT = 200000000;
    static final int FIFO_QUEUE = 1;
    private static final long IDLE_TIMEOUT = 2000000000;
    private static final long INDEXSEED;
    private static final int INT_SIGN = Integer.MIN_VALUE;
    static final int LIFO_QUEUE = 0;
    private static final int MAX_CAP = 32767;
    private static final int MAX_HELP = 64;
    private static final long PARKBLOCKER;
    private static final long PLOCK;
    private static final int PL_LOCK = 2;
    private static final int PL_SIGNAL = 1;
    private static final int PL_SPINS = 256;
    private static final long QBASE;
    private static final long QLOCK;
    private static final int SEED_INCREMENT = 1640531527;
    static final int SHARED_QUEUE = -1;
    private static final int SHORT_SIGN = 32768;
    private static final int SHUTDOWN = Integer.MIN_VALUE;
    private static final int SMASK = 65535;
    private static final int SQMASK = 126;
    private static final long STEALCOUNT;
    private static final long STOP_BIT = 2147483648L;
    private static final int ST_SHIFT = 31;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    private static final long TIMEOUT_SLOP = 2000000;
    private static final Unsafe U;
    private static final int UAC_MASK = -65536;
    private static final int UAC_SHIFT = 16;
    private static final int UAC_UNIT = 65536;
    private static final int UTC_MASK = 65535;
    private static final int UTC_SHIFT = 0;
    private static final int UTC_UNIT = 1;
    static final ForkJoinPool common;
    static final int commonParallelism;
    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
    private static final RuntimePermission modifyThreadPermission;
    private static int poolNumberSequence;
    static final ThreadLocal<int[]> submitters;
    volatile long ctl;
    final ForkJoinWorkerThreadFactory factory;
    volatile int indexSeed;
    final short mode;
    volatile long pad00;
    volatile long pad01;
    volatile long pad02;
    volatile long pad03;
    volatile long pad04;
    volatile long pad05;
    volatile long pad06;
    volatile Object pad10;
    volatile Object pad11;
    volatile Object pad12;
    volatile Object pad13;
    volatile Object pad14;
    volatile Object pad15;
    volatile Object pad16;
    volatile Object pad17;
    volatile Object pad18;
    volatile Object pad19;
    volatile Object pad1a;
    volatile Object pad1b;
    final short parallelism;
    volatile int plock;
    volatile long stealCount;
    final Thread.UncaughtExceptionHandler ueh;
    WorkQueue[] workQueues;
    final String workerNamePrefix;

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        DefaultForkJoinWorkerThreadFactory() {
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
            return new ForkJoinWorkerThread(forkJoinPool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class EmptyTask extends ForkJoinTask<Void> {
        private static final long serialVersionUID = -7721805057305804111L;

        EmptyTask() {
            this.status = -268435456;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r12) {
        }
    }

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface ForkJoinWorkerThreadFactory {
        ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool);
    }

    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public interface ManagedBlocker {
        boolean block() throws InterruptedException;

        boolean isReleasable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class WorkQueue {
        private static final int ABASE;
        private static final int ASHIFT;
        static final int INITIAL_QUEUE_CAPACITY = 8192;
        static final int MAXIMUM_QUEUE_CAPACITY = 67108864;
        private static final long QBASE;
        private static final long QLOCK;
        private static final Unsafe U;
        ForkJoinTask<?>[] array;
        volatile ForkJoinTask<?> currentJoin;
        ForkJoinTask<?> currentSteal;
        volatile int eventCount;
        int hint;
        final short mode;
        int nextWait;
        int nsteals;
        final ForkJoinWorkerThread owner;
        volatile long pad00;
        volatile long pad01;
        volatile long pad02;
        volatile long pad03;
        volatile long pad04;
        volatile long pad05;
        volatile long pad06;
        volatile Object pad10;
        volatile Object pad11;
        volatile Object pad12;
        volatile Object pad13;
        volatile Object pad14;
        volatile Object pad15;
        volatile Object pad16;
        volatile Object pad17;
        volatile Object pad18;
        volatile Object pad19;
        volatile Object pad1a;
        volatile Object pad1b;
        volatile Object pad1c;
        volatile Object pad1d;
        volatile Thread parker;
        final ForkJoinPool pool;
        short poolIndex;
        volatile int qlock;

        /* renamed from: top  reason: collision with root package name */
        int f54815top = 4096;
        volatile int base = 4096;

        static {
            try {
                Unsafe access$000 = ForkJoinPool.access$000();
                U = access$000;
                QBASE = access$000.objectFieldOffset(WorkQueue.class.getDeclaredField("base"));
                QLOCK = access$000.objectFieldOffset(WorkQueue.class.getDeclaredField("qlock"));
                ABASE = access$000.arrayBaseOffset(ForkJoinTask[].class);
                int arrayIndexScale = access$000.arrayIndexScale(ForkJoinTask[].class);
                if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                    ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                    return;
                }
                throw new Error("data type scale not a power of two");
            } catch (Exception e4) {
                throw new Error(e4);
            }
        }

        WorkQueue(ForkJoinPool forkJoinPool, ForkJoinWorkerThread forkJoinWorkerThread, int i4, int i5) {
            this.pool = forkJoinPool;
            this.owner = forkJoinWorkerThread;
            this.mode = (short) i4;
            this.hint = i5;
        }

        final void cancelAll() {
            ForkJoinTask.cancelIgnoringExceptions(this.currentJoin);
            ForkJoinTask.cancelIgnoringExceptions(this.currentSteal);
            while (true) {
                ForkJoinTask<?> poll = poll();
                if (poll == null) {
                    return;
                }
                ForkJoinTask.cancelIgnoringExceptions(poll);
            }
        }

        final boolean externalPopAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i4 = this.base;
            int i5 = this.f54815top;
            if (i4 - i5 < 0 && (forkJoinTaskArr = this.array) != null) {
                int i6 = i5 - 1;
                long length = (((forkJoinTaskArr.length - 1) & i6) << ASHIFT) + ABASE;
                Object object = U.getObject(forkJoinTaskArr, length);
                if (object instanceof CountedCompleter) {
                    CountedCompleter<?> countedCompleter2 = (CountedCompleter) object;
                    CountedCompleter<?> countedCompleter3 = countedCompleter2;
                    while (countedCompleter3 != countedCompleter) {
                        int i7 = i6;
                        countedCompleter3 = countedCompleter3.completer;
                        if (countedCompleter3 != null) {
                            i6 = i7;
                        }
                    }
                    Unsafe unsafe = U;
                    if (unsafe.compareAndSwapInt(this, QLOCK, 0, 1)) {
                        if (this.f54815top == i5 && this.array == forkJoinTaskArr) {
                            int i8 = i6;
                            if (a.a(unsafe, forkJoinTaskArr, length, countedCompleter2, null)) {
                                this.f54815top = i8;
                                this.qlock = 0;
                                countedCompleter2.doExec();
                            }
                        }
                        this.qlock = 0;
                    }
                    return true;
                }
            }
            return false;
        }

        final ForkJoinTask<?>[] growArray() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            int length2 = forkJoinTaskArr != null ? forkJoinTaskArr.length << 1 : 8192;
            if (length2 <= 67108864) {
                ForkJoinTask<?>[] forkJoinTaskArr2 = new ForkJoinTask[length2];
                this.array = forkJoinTaskArr2;
                if (forkJoinTaskArr != null && forkJoinTaskArr.length - 1 >= 0) {
                    int i4 = this.f54815top;
                    int i5 = this.base;
                    if (i4 - i5 > 0) {
                        int i6 = length2 - 1;
                        int i7 = i5;
                        do {
                            int i8 = ASHIFT;
                            int i9 = ABASE;
                            int i10 = ((i7 & i6) << i8) + i9;
                            Unsafe unsafe = U;
                            long j4 = ((i7 & length) << i8) + i9;
                            ForkJoinTask forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j4);
                            if (forkJoinTask != null && a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask, null)) {
                                unsafe.putObjectVolatile(forkJoinTaskArr2, i10, forkJoinTask);
                            }
                            i7++;
                        } while (i7 != i4);
                    }
                }
                return forkJoinTaskArr2;
            }
            throw new RejectedExecutionException("Queue capacity exceeded");
        }

        final boolean internalPopAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i4 = this.base;
            int i5 = this.f54815top;
            if (i4 - i5 >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            int i6 = i5 - 1;
            long length = (((forkJoinTaskArr.length - 1) & i6) << ASHIFT) + ABASE;
            Object object = U.getObject(forkJoinTaskArr, length);
            if (object instanceof CountedCompleter) {
                CountedCompleter<?> countedCompleter2 = (CountedCompleter) object;
                CountedCompleter<?> countedCompleter3 = countedCompleter2;
                while (countedCompleter3 != countedCompleter) {
                    countedCompleter3 = countedCompleter3.completer;
                    if (countedCompleter3 == null) {
                        return false;
                    }
                }
                if (a.a(U, forkJoinTaskArr, length, countedCompleter2, null)) {
                    this.f54815top = i6;
                    countedCompleter2.doExec();
                }
                return true;
            }
            return false;
        }

        final boolean isApparentlyUnblocked() {
            ForkJoinWorkerThread forkJoinWorkerThread;
            Thread.State state;
            return (this.eventCount < 0 || (forkJoinWorkerThread = this.owner) == null || (state = forkJoinWorkerThread.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) ? false : true;
        }

        final boolean isEmpty() {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int length;
            int i4 = this.base;
            int i5 = this.f54815top;
            int i6 = i4 - i5;
            if (i6 < 0) {
                return i6 == -1 && ((forkJoinTaskArr = this.array) == null || (length = forkJoinTaskArr.length - 1) < 0 || U.getObject(forkJoinTaskArr, ((long) (((i5 - 1) & length) << ASHIFT)) + ((long) ABASE)) == null);
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> nextLocalTask() {
            return this.mode == 0 ? pop() : poll();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> peek() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || forkJoinTaskArr.length - 1 < 0) {
                return null;
            }
            return (ForkJoinTask) U.getObjectVolatile(forkJoinTaskArr, ((length & (this.mode == 0 ? this.f54815top - 1 : this.base)) << ASHIFT) + ABASE);
        }

        final ForkJoinTask<?> poll() {
            ForkJoinTask<?>[] forkJoinTaskArr;
            while (true) {
                int i4 = this.base;
                if (i4 - this.f54815top >= 0 || (forkJoinTaskArr = this.array) == null) {
                    return null;
                }
                Unsafe unsafe = U;
                long length = (((forkJoinTaskArr.length - 1) & i4) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, length);
                if (forkJoinTask != null) {
                    if (a.a(unsafe, forkJoinTaskArr, length, forkJoinTask, null)) {
                        unsafe.putOrderedInt(this, QBASE, i4 + 1);
                        return forkJoinTask;
                    }
                } else if (this.base != i4) {
                    continue;
                } else if (i4 + 1 == this.f54815top) {
                    return null;
                } else {
                    Thread.yield();
                }
            }
        }

        final void pollAndExecAll() {
            while (true) {
                ForkJoinTask<?> poll = poll();
                if (poll == null) {
                    return;
                }
                poll.doExec();
            }
        }

        final boolean pollAndExecCC(CountedCompleter<?> countedCompleter) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i4 = this.base;
            if (i4 - this.f54815top >= 0 || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            long length = (((forkJoinTaskArr.length - 1) & i4) << ASHIFT) + ABASE;
            Object objectVolatile = U.getObjectVolatile(forkJoinTaskArr, length);
            if (objectVolatile == null) {
                return true;
            }
            if (objectVolatile instanceof CountedCompleter) {
                CountedCompleter<?> countedCompleter2 = (CountedCompleter) objectVolatile;
                CountedCompleter<?> countedCompleter3 = countedCompleter2;
                while (countedCompleter3 != countedCompleter) {
                    countedCompleter3 = countedCompleter3.completer;
                    if (countedCompleter3 == null) {
                        return false;
                    }
                }
                if (this.base == i4) {
                    Unsafe unsafe = U;
                    if (a.a(unsafe, forkJoinTaskArr, length, countedCompleter2, null)) {
                        unsafe.putOrderedInt(this, QBASE, i4 + 1);
                        countedCompleter2.doExec();
                    }
                }
                return true;
            }
            return false;
        }

        final ForkJoinTask<?> pollAt(int i4) {
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr != null) {
                Unsafe unsafe = U;
                long length = (((forkJoinTaskArr.length - 1) & i4) << ASHIFT) + ABASE;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, length);
                if (forkJoinTask != null && this.base == i4 && a.a(unsafe, forkJoinTaskArr, length, forkJoinTask, null)) {
                    unsafe.putOrderedInt(this, QBASE, i4 + 1);
                    return forkJoinTask;
                }
                return null;
            }
            return null;
        }

        final ForkJoinTask<?> pop() {
            int length;
            int i4;
            long j4;
            Unsafe unsafe;
            ForkJoinTask<?> forkJoinTask;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || forkJoinTaskArr.length - 1 < 0) {
                return null;
            }
            do {
                i4 = this.f54815top - 1;
                if (i4 - this.base < 0) {
                    return null;
                }
                j4 = ((length & i4) << ASHIFT) + ABASE;
                unsafe = U;
                forkJoinTask = (ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j4);
                if (forkJoinTask == null) {
                    return null;
                }
            } while (!a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask, null));
            this.f54815top = i4;
            return forkJoinTask;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void push(ForkJoinTask<?> forkJoinTask) {
            int i4 = this.f54815top;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr != null) {
                int length = forkJoinTaskArr.length - 1;
                U.putOrderedObject(forkJoinTaskArr, ((length & i4) << ASHIFT) + ABASE, forkJoinTask);
                int i5 = i4 + 1;
                this.f54815top = i5;
                int i6 = i5 - this.base;
                if (i6 <= 2) {
                    ForkJoinPool forkJoinPool = this.pool;
                    forkJoinPool.signalWork(forkJoinPool.workQueues, this);
                } else if (i6 >= length) {
                    growArray();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int queueSize() {
            int i4 = this.base - this.f54815top;
            if (i4 >= 0) {
                return 0;
            }
            return -i4;
        }

        final void runTask(ForkJoinTask<?> forkJoinTask) {
            this.currentSteal = forkJoinTask;
            if (forkJoinTask == null) {
                return;
            }
            forkJoinTask.doExec();
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            short s3 = this.mode;
            this.nsteals++;
            this.currentSteal = null;
            if (s3 != 0) {
                pollAndExecAll();
            } else if (forkJoinTaskArr == null) {
            } else {
                int length = forkJoinTaskArr.length - 1;
                while (true) {
                    int i4 = this.f54815top - 1;
                    if (i4 - this.base < 0) {
                        return;
                    }
                    long j4 = ((length & i4) << ASHIFT) + ABASE;
                    Unsafe unsafe = U;
                    ForkJoinTask forkJoinTask2 = (ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j4);
                    if (forkJoinTask2 == null) {
                        return;
                    }
                    if (a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask2, null)) {
                        this.f54815top = i4;
                        forkJoinTask2.doExec();
                    }
                }
            }
        }

        final boolean tryRemoveAndExec(ForkJoinTask<?> forkJoinTask) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int i4;
            int i5;
            boolean z3 = false;
            if (forkJoinTask == null || (forkJoinTaskArr = this.array) == null) {
                return false;
            }
            boolean z4 = true;
            int length = forkJoinTaskArr.length - 1;
            if (length < 0 || (r5 = (i4 = this.f54815top) - (i5 = this.base)) <= 0) {
                return false;
            }
            boolean z5 = true;
            while (true) {
                int i6 = i4 - 1;
                long j4 = ((i6 & length) << ASHIFT) + ABASE;
                Unsafe unsafe = U;
                ForkJoinTask<?> forkJoinTask2 = (ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j4);
                if (forkJoinTask2 == null) {
                    break;
                } else if (forkJoinTask2 == forkJoinTask) {
                    if (i6 + 1 == this.f54815top) {
                        if (a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask, null)) {
                            this.f54815top = i6;
                            z3 = true;
                        }
                    } else if (this.base == i5) {
                        z3 = a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask, new EmptyTask());
                    }
                } else {
                    if (forkJoinTask2.status >= 0) {
                        z5 = false;
                    } else if (i6 + 1 == this.f54815top) {
                        if (a.a(unsafe, forkJoinTaskArr, j4, forkJoinTask2, null)) {
                            this.f54815top = i6;
                        }
                    }
                    int i7 = i7 - 1;
                    if (i7 != 0) {
                        i4 = i6;
                    } else if (!z5 && this.base == i5) {
                        z4 = false;
                    }
                }
            }
            if (z3) {
                forkJoinTask.doExec();
            }
            return z4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean tryUnpush(ForkJoinTask<?> forkJoinTask) {
            int i4;
            ForkJoinTask<?>[] forkJoinTaskArr = this.array;
            if (forkJoinTaskArr == null || (i4 = this.f54815top) == this.base) {
                return false;
            }
            int i5 = i4 - 1;
            if (a.a(U, forkJoinTaskArr, (((forkJoinTaskArr.length - 1) & i5) << ASHIFT) + ABASE, forkJoinTask, null)) {
                this.f54815top = i5;
                return true;
            }
            return false;
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            U = unsafe;
            CTL = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("ctl"));
            STEALCOUNT = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("stealCount"));
            PLOCK = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("plock"));
            INDEXSEED = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("indexSeed"));
            PARKBLOCKER = unsafe.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker"));
            QBASE = unsafe.objectFieldOffset(WorkQueue.class.getDeclaredField("base"));
            QLOCK = unsafe.objectFieldOffset(WorkQueue.class.getDeclaredField("qlock"));
            ABASE = unsafe.arrayBaseOffset(ForkJoinTask[].class);
            int arrayIndexScale = unsafe.arrayIndexScale(ForkJoinTask[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                ASHIFT = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                submitters = new ThreadLocal<>();
                defaultForkJoinWorkerThreadFactory = new DefaultForkJoinWorkerThreadFactory();
                modifyThreadPermission = new RuntimePermission("modifyThread");
                ForkJoinPool forkJoinPool = (ForkJoinPool) AccessController.doPrivileged(new PrivilegedAction<ForkJoinPool>() { // from class: io.netty.util.internal.chmv8.ForkJoinPool.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedAction
                    public ForkJoinPool run() {
                        return ForkJoinPool.access$100();
                    }
                });
                common = forkJoinPool;
                short s3 = forkJoinPool.parallelism;
                if (s3 <= 0) {
                    s3 = 1;
                }
                commonParallelism = s3;
                return;
            }
            throw new Error("data type scale not a power of two");
        } catch (Exception e4) {
            throw new Error(e4);
        }
    }

    public ForkJoinPool() {
        this(Math.min((int) MAX_CAP, Runtime.getRuntime().availableProcessors()), defaultForkJoinWorkerThreadFactory, null, false);
    }

    static /* synthetic */ Unsafe access$000() {
        return getUnsafe();
    }

    static /* synthetic */ ForkJoinPool access$100() {
        return makeCommonPool();
    }

    private int acquirePlock() {
        int i4 = 256;
        while (true) {
            int i5 = this.plock;
            if ((i5 & 2) == 0) {
                int i6 = i5 + 2;
                if (U.compareAndSwapInt(this, PLOCK, i5, i6)) {
                    return i6;
                }
            }
            if (i4 >= 0) {
                if (ThreadLocalRandom.current().nextInt() >= 0) {
                    i4--;
                }
            } else if (U.compareAndSwapInt(this, PLOCK, i5, i5 | 1)) {
                synchronized (this) {
                    if ((this.plock & 1) != 0) {
                        try {
                            try {
                                wait();
                            } catch (SecurityException unused) {
                            }
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        notifyAll();
                    }
                }
            } else {
                continue;
            }
        }
    }

    private final int awaitWork(WorkQueue workQueue, long j4, int i4) {
        long j5;
        long j6;
        int i5;
        Unsafe unsafe;
        long j7;
        long j8;
        int i6 = workQueue.qlock;
        if (i6 < 0 || workQueue.eventCount != i4 || this.ctl != j4 || Thread.interrupted()) {
            return i6;
        }
        int i7 = (int) j4;
        int i8 = (int) (j4 >>> 32);
        int i9 = (i8 >> 16) + this.parallelism;
        if (i7 >= 0 && (i9 > 0 || !tryTerminate(false, false))) {
            int i10 = workQueue.nsteals;
            if (i10 != 0) {
                workQueue.nsteals = 0;
                do {
                    unsafe = U;
                    j7 = STEALCOUNT;
                    j8 = this.stealCount;
                } while (!unsafe.compareAndSwapLong(this, j7, j8, i10 + j8));
                return i6;
            }
            long j9 = (i9 > 0 || i4 != (i7 | Integer.MIN_VALUE)) ? 0L : ((65536 + i8) << 32) | (workQueue.nextWait & Integer.MAX_VALUE);
            if (j9 != 0) {
                j5 = (-((short) i8)) < 0 ? FAST_IDLE_TIMEOUT : (i5 + 1) * IDLE_TIMEOUT;
                j6 = (System.nanoTime() + j5) - TIMEOUT_SLOP;
            } else {
                j5 = 0;
                j6 = 0;
            }
            if (workQueue.eventCount != i4) {
                return i6;
            }
            long j10 = j9;
            if (this.ctl != j4) {
                return i6;
            }
            Thread currentThread = Thread.currentThread();
            Unsafe unsafe2 = U;
            long j11 = PARKBLOCKER;
            unsafe2.putObject(currentThread, j11, this);
            workQueue.parker = currentThread;
            if (workQueue.eventCount == i4 && this.ctl == j4) {
                unsafe2.park(false, j5);
            }
            workQueue.parker = null;
            unsafe2.putObject(currentThread, j11, (Object) null);
            if (j5 == 0 || this.ctl != j4 || j6 - System.nanoTime() > 0 || !unsafe2.compareAndSwapLong(this, CTL, j4, j10)) {
                return i6;
            }
            workQueue.qlock = -1;
        } else {
            workQueue.qlock = -1;
        }
        return -1;
    }

    private static ForkJoinWorkerThreadFactory checkFactory(ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) {
        forkJoinWorkerThreadFactory.getClass();
        return forkJoinWorkerThreadFactory;
    }

    private static int checkParallelism(int i4) {
        if (i4 <= 0 || i4 > MAX_CAP) {
            throw new IllegalArgumentException();
        }
        return i4;
    }

    private static void checkPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(modifyThreadPermission);
        }
    }

    public static ForkJoinPool commonPool() {
        return common;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WorkQueue commonSubmitterQueue() {
        ForkJoinPool forkJoinPool;
        WorkQueue[] workQueueArr;
        int length;
        int[] iArr = submitters.get();
        if (iArr == null || (forkJoinPool = common) == null || (workQueueArr = forkJoinPool.workQueues) == null || workQueueArr.length - 1 < 0) {
            return null;
        }
        return workQueueArr[iArr[0] & length & 126];
    }

    private WorkQueue findNonEmptyStealQueue() {
        int i4;
        int length;
        int nextInt = ThreadLocalRandom.current().nextInt();
        do {
            i4 = this.plock;
            WorkQueue[] workQueueArr = this.workQueues;
            if (workQueueArr != null && workQueueArr.length - 1 >= 0) {
                for (int i5 = (length + 1) << 2; i5 >= 0; i5--) {
                    WorkQueue workQueue = workQueueArr[(((nextInt - i5) << 1) | 1) & length];
                    if (workQueue != null && workQueue.base - workQueue.f54815top < 0) {
                        return workQueue;
                    }
                }
            }
        } while (this.plock != i4);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
        if (r4.length <= ((r5 + 1) - r3.base)) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fullExternalPush(io.netty.util.internal.chmv8.ForkJoinTask<?> r21) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.fullExternalPush(io.netty.util.internal.chmv8.ForkJoinTask):void");
    }

    public static int getCommonPoolParallelism() {
        return commonParallelism;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSurplusQueuedTaskCount() {
        Thread currentThread = Thread.currentThread();
        int i4 = 0;
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            ForkJoinPool forkJoinPool = forkJoinWorkerThread.pool;
            short s3 = forkJoinPool.parallelism;
            WorkQueue workQueue = forkJoinWorkerThread.workQueue;
            int i5 = workQueue.f54815top - workQueue.base;
            int i6 = ((int) (forkJoinPool.ctl >> 48)) + s3;
            int i7 = s3 >>> 1;
            if (i6 <= i7) {
                int i8 = i7 >>> 1;
                if (i6 > i8) {
                    i4 = 1;
                } else {
                    int i9 = i8 >>> 1;
                    i4 = i6 > i9 ? 2 : i6 > (i9 >>> 1) ? 4 : 8;
                }
            }
            return i5 - i4;
        }
        return 0;
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ForkJoinPool.2
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

    private int helpComplete(WorkQueue workQueue, CountedCompleter<?> countedCompleter) {
        int length;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null || workQueueArr.length - 1 < 0 || workQueue == null || countedCompleter == null) {
            return 0;
        }
        int i4 = workQueue.poolIndex;
        int i5 = length + length + 1;
        long j4 = 0;
        int i6 = i5;
        while (true) {
            int i7 = countedCompleter.status;
            if (i7 < 0) {
                return i7;
            }
            if (!workQueue.internalPopAndExecCC(countedCompleter)) {
                int i8 = countedCompleter.status;
                if (i8 < 0) {
                    return i8;
                }
                WorkQueue workQueue2 = workQueueArr[i4 & length];
                if (workQueue2 == null || !workQueue2.pollAndExecCC(countedCompleter)) {
                    i6--;
                    if (i6 < 0) {
                        long j5 = this.ctl;
                        if (j4 == j5) {
                            return i8;
                        }
                        i6 = i5;
                        j4 = j5;
                    } else {
                        continue;
                    }
                    i4 += 2;
                }
            }
            i6 = i5;
            i4 += 2;
        }
    }

    private final void helpRelease(long j4, WorkQueue[] workQueueArr, WorkQueue workQueue, WorkQueue workQueue2, int i4) {
        int i5;
        int i6;
        WorkQueue workQueue3;
        if (workQueue == null || workQueue.eventCount >= 0 || (i5 = (int) j4) <= 0 || workQueueArr == null || workQueueArr.length <= (i6 = 65535 & i5) || (workQueue3 = workQueueArr[i6]) == null) {
            return;
        }
        if (this.ctl == j4) {
            long j5 = (workQueue3.nextWait & Integer.MAX_VALUE) | ((((int) (j4 >>> 32)) + 65536) << 32);
            int i7 = (65536 + i5) & Integer.MAX_VALUE;
            if (workQueue2 == null || workQueue2.base != i4 || workQueue.eventCount >= 0 || workQueue3.eventCount != (Integer.MIN_VALUE | i5)) {
                return;
            }
            Unsafe unsafe = U;
            if (unsafe.compareAndSwapLong(this, CTL, j4, j5)) {
                workQueue3.eventCount = i7;
                Thread thread = workQueue3.parker;
                if (thread != null) {
                    unsafe.unpark(thread);
                }
            }
        }
    }

    private static ForkJoinPool makeCommonPool() {
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = defaultForkJoinWorkerThreadFactory;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
        try {
            String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            String property2 = System.getProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            String property3 = System.getProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            r1 = property != null ? Integer.parseInt(property) : -1;
            if (property2 != null) {
                forkJoinWorkerThreadFactory = (ForkJoinWorkerThreadFactory) ClassLoader.getSystemClassLoader().loadClass(property2).newInstance();
            }
            if (property3 != null) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) ClassLoader.getSystemClassLoader().loadClass(property3).newInstance();
            }
        } catch (Exception unused) {
        }
        ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory2 = forkJoinWorkerThreadFactory;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
        if (r1 < 0 && Runtime.getRuntime().availableProcessors() - 1 < 0) {
            r1 = 0;
        }
        return new ForkJoinPool(r1 > MAX_CAP ? MAX_CAP : r1, forkJoinWorkerThreadFactory2, uncaughtExceptionHandler2, 0, "ForkJoinPool.commonPool-worker-");
    }

    public static void managedBlock(ManagedBlocker managedBlocker) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinPool forkJoinPool = ((ForkJoinWorkerThread) currentThread).pool;
            while (!managedBlocker.isReleasable()) {
                if (forkJoinPool.tryCompensate(forkJoinPool.ctl)) {
                    do {
                        try {
                            if (managedBlocker.isReleasable()) {
                                break;
                            }
                        } finally {
                            forkJoinPool.incrementActiveCount();
                        }
                    } while (!managedBlocker.block());
                    return;
                }
            }
            return;
        }
        while (!managedBlocker.isReleasable() && !managedBlocker.block()) {
        }
    }

    private static final synchronized int nextPoolId() {
        int i4;
        synchronized (ForkJoinPool.class) {
            i4 = poolNumberSequence + 1;
            poolNumberSequence = i4;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void quiesceCommonPool() {
        common.awaitQuiescence(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private void releasePlock(int i4) {
        this.plock = i4;
        synchronized (this) {
            notifyAll();
        }
    }

    private final int scan(WorkQueue workQueue, int i4) {
        int length;
        ForkJoinTask<?>[] forkJoinTaskArr;
        long j4 = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr == null || workQueueArr.length - 1 < 0 || workQueue == null) {
            return 0;
        }
        int i5 = length + length + 1;
        int i6 = workQueue.eventCount;
        do {
            WorkQueue workQueue2 = workQueueArr[(i4 - i5) & length];
            if (workQueue2 != null) {
                int i7 = workQueue2.base;
                if (i7 - workQueue2.f54815top < 0 && (forkJoinTaskArr = workQueue2.array) != null) {
                    long length2 = (((forkJoinTaskArr.length - 1) & i7) << ASHIFT) + ABASE;
                    Unsafe unsafe = U;
                    ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, length2);
                    if (forkJoinTask != null) {
                        if (i6 < 0) {
                            helpRelease(j4, workQueueArr, workQueue, workQueue2, i7);
                            return 0;
                        } else if (workQueue2.base == i7 && a.a(unsafe, forkJoinTaskArr, length2, forkJoinTask, null)) {
                            int i8 = i7 + 1;
                            unsafe.putOrderedInt(workQueue2, QBASE, i8);
                            if (i8 - workQueue2.f54815top < 0) {
                                signalWork(workQueueArr, workQueue2);
                            }
                            workQueue.runTask(forkJoinTask);
                            return 0;
                        } else {
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            i5--;
        } while (i5 >= 0);
        int i9 = (int) j4;
        if ((i6 | i9) < 0) {
            return awaitWork(workQueue, j4, i6);
        }
        if (this.ctl == j4) {
            long j5 = (j4 - AC_UNIT) & (-4294967296L);
            workQueue.nextWait = i9;
            workQueue.eventCount = Integer.MIN_VALUE | i6;
            if (U.compareAndSwapLong(this, CTL, j4, j5 | i6)) {
                return 0;
            }
            workQueue.eventCount = i6;
            return 0;
        }
        return 0;
    }

    private void tryAddWorker() {
        long j4;
        int i4;
        int i5;
        ForkJoinWorkerThread forkJoinWorkerThread;
        do {
            j4 = this.ctl;
            i4 = (int) (j4 >>> 32);
            if (i4 >= 0 || (32768 & i4) == 0 || (i5 = (int) j4) < 0) {
                return;
            }
        } while (!U.compareAndSwapLong(this, CTL, j4, ((((i4 + 65536) & (-65536)) | ((i4 + 1) & 65535)) << 32) | i5));
        Throwable th = null;
        try {
            ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
            if (forkJoinWorkerThreadFactory != null) {
                forkJoinWorkerThread = forkJoinWorkerThreadFactory.newThread(this);
                if (forkJoinWorkerThread != null) {
                    try {
                        forkJoinWorkerThread.start();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } else {
                forkJoinWorkerThread = null;
            }
        } catch (Throwable th3) {
            forkJoinWorkerThread = null;
            th = th3;
        }
        deregisterWorker(forkJoinWorkerThread, th);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b2, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0012, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int tryHelpStealer(io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue r19, io.netty.util.internal.chmv8.ForkJoinTask<?> r20) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.tryHelpStealer(io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue, io.netty.util.internal.chmv8.ForkJoinTask):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0090, code lost:
        signalWork(r3, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean tryTerminate(boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.tryTerminate(boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int awaitJoin(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        Unsafe unsafe;
        long j4;
        long j5;
        if (forkJoinTask != null) {
            int i4 = forkJoinTask.status;
            if (i4 < 0 || workQueue == null) {
                return i4;
            }
            ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
            workQueue.currentJoin = forkJoinTask;
            while (workQueue.tryRemoveAndExec(forkJoinTask) && (i4 = forkJoinTask.status) >= 0) {
            }
            if (i4 >= 0 && (forkJoinTask instanceof CountedCompleter)) {
                i4 = helpComplete(workQueue, (CountedCompleter) forkJoinTask);
            }
            long j6 = 0;
            while (i4 >= 0) {
                i4 = forkJoinTask.status;
                if (i4 < 0) {
                    break;
                }
                i4 = tryHelpStealer(workQueue, forkJoinTask);
                if (i4 == 0 && (i4 = forkJoinTask.status) >= 0) {
                    if (!tryCompensate(j6)) {
                        j6 = this.ctl;
                    } else {
                        if (forkJoinTask.trySetSignal() && (i4 = forkJoinTask.status) >= 0) {
                            synchronized (forkJoinTask) {
                                if (forkJoinTask.status >= 0) {
                                    try {
                                        forkJoinTask.wait();
                                    } catch (InterruptedException unused) {
                                    }
                                } else {
                                    forkJoinTask.notifyAll();
                                }
                            }
                        }
                        int i5 = i4;
                        do {
                            unsafe = U;
                            j4 = CTL;
                            j5 = this.ctl;
                        } while (!unsafe.compareAndSwapLong(this, j4, j5, (281474976710655L & j5) | ((AC_MASK & j5) + AC_UNIT)));
                        i4 = i5;
                    }
                }
            }
            workQueue.currentJoin = forkJoinTask2;
            return i4;
        }
        return 0;
    }

    public boolean awaitQuiescence(long j4, TimeUnit timeUnit) {
        WorkQueue[] workQueueArr;
        int length;
        long nanos = timeUnit.toNanos(j4);
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            if (forkJoinWorkerThread.pool == this) {
                helpQuiescePool(forkJoinWorkerThread.workQueue);
                return true;
            }
        }
        long nanoTime = System.nanoTime();
        boolean z3 = true;
        int i4 = 0;
        while (!isQuiescent() && (workQueueArr = this.workQueues) != null && (length = workQueueArr.length - 1) >= 0) {
            if (!z3) {
                if (System.nanoTime() - nanoTime > nanos) {
                    return false;
                }
                Thread.yield();
            }
            int i5 = (length + 1) << 2;
            while (true) {
                if (i5 < 0) {
                    z3 = false;
                    break;
                }
                int i6 = i4 + 1;
                WorkQueue workQueue = workQueueArr[i4 & length];
                if (workQueue != null) {
                    int i7 = workQueue.base;
                    if (i7 - workQueue.f54815top < 0) {
                        ForkJoinTask<?> pollAt = workQueue.pollAt(i7);
                        if (pollAt != null) {
                            pollAt.doExec();
                        }
                        i4 = i6;
                        z3 = true;
                    }
                }
                i5--;
                i4 = i6;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        if (!Thread.interrupted()) {
            if (this == common) {
                awaitQuiescence(j4, timeUnit);
                return false;
            }
            long nanos = timeUnit.toNanos(j4);
            if (isTerminated()) {
                return true;
            }
            if (nanos <= 0) {
                return false;
            }
            long nanoTime = System.nanoTime() + nanos;
            synchronized (this) {
                while (!isTerminated()) {
                    if (nanos <= 0) {
                        return false;
                    }
                    long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
                    if (millis <= 0) {
                        millis = 1;
                    }
                    wait(millis);
                    nanos = nanoTime - System.nanoTime();
                }
                return true;
            }
        }
        throw new InterruptedException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x010b, code lost:
        io.netty.util.internal.chmv8.ForkJoinTask.helpExpungeStaleExceptions();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void deregisterWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread r18, java.lang.Throwable r19) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.deregisterWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread, java.lang.Throwable):void");
    }

    protected int drainTasksTo(Collection<? super ForkJoinTask<?>> collection) {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int i4 = 0;
            for (WorkQueue workQueue : workQueueArr) {
                if (workQueue != null) {
                    while (true) {
                        ForkJoinTask<?> poll = workQueue.poll();
                        if (poll != null) {
                            collection.add(poll);
                            i4++;
                        }
                    }
                }
            }
            return i4;
        }
        return 0;
    }

    public void execute(ForkJoinTask<?> forkJoinTask) {
        forkJoinTask.getClass();
        externalPush(forkJoinTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int externalHelpComplete(CountedCompleter<?> countedCompleter) {
        int length;
        int i4;
        int[] iArr = submitters.get();
        WorkQueue[] workQueueArr = this.workQueues;
        if (iArr == null || workQueueArr == null || workQueueArr.length - 1 < 0) {
            return 0;
        }
        int i5 = iArr[0];
        WorkQueue workQueue = workQueueArr[i5 & length & 126];
        if (workQueue == null || countedCompleter == null) {
            return 0;
        }
        int i6 = length + length + 1;
        long j4 = 0;
        int i7 = i5 | 1;
        int i8 = i6;
        while (true) {
            i4 = countedCompleter.status;
            if (i4 < 0) {
                break;
            }
            if (!workQueue.externalPopAndExecCC(countedCompleter)) {
                i4 = countedCompleter.status;
                if (i4 < 0) {
                    break;
                }
                WorkQueue workQueue2 = workQueueArr[i7 & length];
                if (workQueue2 == null || !workQueue2.pollAndExecCC(countedCompleter)) {
                    i8--;
                    if (i8 < 0) {
                        long j5 = this.ctl;
                        if (j4 == j5) {
                            break;
                        }
                        i8 = i6;
                        j4 = j5;
                    } else {
                        continue;
                    }
                    i7 += 2;
                }
            }
            i8 = i6;
            i7 += 2;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void externalPush(ForkJoinTask<?> forkJoinTask) {
        int length;
        int length2;
        int i4;
        int i5;
        int[] iArr = submitters.get();
        int i6 = this.plock;
        WorkQueue[] workQueueArr = this.workQueues;
        if (iArr != null && i6 > 0 && workQueueArr != null && (length = workQueueArr.length - 1) >= 0) {
            int i7 = iArr[0];
            WorkQueue workQueue = workQueueArr[length & i7 & 126];
            if (workQueue != null && i7 != 0) {
                Unsafe unsafe = U;
                if (unsafe.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
                    ForkJoinTask<?>[] forkJoinTaskArr = workQueue.array;
                    if (forkJoinTaskArr != null && (length2 = forkJoinTaskArr.length - 1) > (i5 = (i4 = workQueue.f54815top) - workQueue.base)) {
                        unsafe.putOrderedObject(forkJoinTaskArr, ((length2 & i4) << ASHIFT) + ABASE, forkJoinTask);
                        workQueue.f54815top = i4 + 1;
                        workQueue.qlock = 0;
                        if (i5 <= 1) {
                            signalWork(workQueueArr, workQueue);
                            return;
                        }
                        return;
                    }
                    workQueue.qlock = 0;
                }
            }
        }
        fullExternalPush(forkJoinTask);
    }

    public int getActiveThreadCount() {
        int i4 = this.parallelism + ((int) (this.ctl >> 48));
        if (i4 <= 0) {
            return 0;
        }
        return i4;
    }

    public boolean getAsyncMode() {
        return this.mode == 1;
    }

    public ForkJoinWorkerThreadFactory getFactory() {
        return this.factory;
    }

    public int getParallelism() {
        short s3 = this.parallelism;
        if (s3 > 0) {
            return s3;
        }
        return 1;
    }

    public int getPoolSize() {
        return this.parallelism + ((short) (this.ctl >>> 32));
    }

    public int getQueuedSubmissionCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            int i4 = 0;
            for (int i5 = 0; i5 < workQueueArr.length; i5 += 2) {
                WorkQueue workQueue = workQueueArr[i5];
                if (workQueue != null) {
                    i4 += workQueue.queueSize();
                }
            }
            return i4;
        }
        return 0;
    }

    public long getQueuedTaskCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        long j4 = 0;
        if (workQueueArr != null) {
            for (int i4 = 1; i4 < workQueueArr.length; i4 += 2) {
                WorkQueue workQueue = workQueueArr[i4];
                if (workQueue != null) {
                    j4 += workQueue.queueSize();
                }
            }
        }
        return j4;
    }

    public int getRunningThreadCount() {
        WorkQueue[] workQueueArr = this.workQueues;
        int i4 = 0;
        if (workQueueArr != null) {
            for (int i5 = 1; i5 < workQueueArr.length; i5 += 2) {
                WorkQueue workQueue = workQueueArr[i5];
                if (workQueue != null && workQueue.isApparentlyUnblocked()) {
                    i4++;
                }
            }
        }
        return i4;
    }

    public long getStealCount() {
        long j4 = this.stealCount;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i4 = 1; i4 < workQueueArr.length; i4 += 2) {
                WorkQueue workQueue = workQueueArr[i4];
                if (workQueue != null) {
                    j4 += workQueue.nsteals;
                }
            }
        }
        return j4;
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.ueh;
    }

    public boolean hasQueuedSubmissions() {
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i4 = 0; i4 < workQueueArr.length; i4 += 2) {
                WorkQueue workQueue = workQueueArr[i4];
                if (workQueue != null && !workQueue.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void helpJoinOnce(WorkQueue workQueue, ForkJoinTask<?> forkJoinTask) {
        int i4;
        if (workQueue == null || forkJoinTask == null || (i4 = forkJoinTask.status) < 0) {
            return;
        }
        ForkJoinTask<?> forkJoinTask2 = workQueue.currentJoin;
        workQueue.currentJoin = forkJoinTask;
        while (workQueue.tryRemoveAndExec(forkJoinTask) && (i4 = forkJoinTask.status) >= 0) {
        }
        if (i4 >= 0) {
            if (forkJoinTask instanceof CountedCompleter) {
                helpComplete(workQueue, (CountedCompleter) forkJoinTask);
            }
            while (forkJoinTask.status >= 0 && tryHelpStealer(workQueue, forkJoinTask) > 0) {
            }
        }
        workQueue.currentJoin = forkJoinTask2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void helpQuiescePool(WorkQueue workQueue) {
        ForkJoinTask<?> pollAt;
        Unsafe unsafe;
        long j4;
        long j5;
        ForkJoinTask<?> forkJoinTask = workQueue.currentSteal;
        boolean z3 = true;
        while (true) {
            ForkJoinTask<?> nextLocalTask = workQueue.nextLocalTask();
            if (nextLocalTask != null) {
                nextLocalTask.doExec();
            } else {
                WorkQueue findNonEmptyStealQueue = findNonEmptyStealQueue();
                if (findNonEmptyStealQueue != null) {
                    if (!z3) {
                        do {
                            unsafe = U;
                            j4 = CTL;
                            j5 = this.ctl;
                        } while (!unsafe.compareAndSwapLong(this, j4, j5, (j5 & 281474976710655L) | ((j5 & AC_MASK) + AC_UNIT)));
                        z3 = true;
                    }
                    int i4 = findNonEmptyStealQueue.base;
                    if (i4 - findNonEmptyStealQueue.f54815top < 0 && (pollAt = findNonEmptyStealQueue.pollAt(i4)) != null) {
                        workQueue.currentSteal = pollAt;
                        pollAt.doExec();
                        workQueue.currentSteal = forkJoinTask;
                    }
                } else if (z3) {
                    long j6 = this.ctl;
                    long j7 = ((j6 & AC_MASK) - AC_UNIT) | (j6 & 281474976710655L);
                    if (((int) (j7 >> 48)) + this.parallelism == 0) {
                        return;
                    }
                    if (U.compareAndSwapLong(this, CTL, j6, j7)) {
                        z3 = false;
                    }
                } else {
                    long j8 = this.ctl;
                    if (((int) (j8 >> 48)) + this.parallelism <= 0 && U.compareAndSwapLong(this, CTL, j8, (j8 & 281474976710655L) | ((j8 & AC_MASK) + AC_UNIT))) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void incrementActiveCount() {
        Unsafe unsafe;
        long j4;
        long j5;
        do {
            unsafe = U;
            j4 = CTL;
            j5 = this.ctl;
        } while (!unsafe.compareAndSwapLong(this, j4, j5, (281474976710655L & j5) | ((AC_MASK & j5) + AC_UNIT)));
    }

    public <T> T invoke(ForkJoinTask<T> forkJoinTask) {
        forkJoinTask.getClass();
        externalPush(forkJoinTask);
        return forkJoinTask.join();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            for (Callable<T> callable : collection) {
                ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
                arrayList.add(adaptedCallable);
                externalPush(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((ForkJoinTask) arrayList.get(i4)).quietlyJoin();
            }
            return arrayList;
        } catch (Throwable th) {
            int size2 = arrayList.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ((Future) arrayList.get(i5)).cancel(false);
            }
            throw th;
        }
    }

    public boolean isQuiescent() {
        return this.parallelism + ((int) (this.ctl >> 48)) <= 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.plock < 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        long j4 = this.ctl;
        return (2147483648L & j4) != 0 && ((short) ((int) (j4 >>> 32))) + this.parallelism <= 0;
    }

    public boolean isTerminating() {
        long j4 = this.ctl;
        return (2147483648L & j4) != 0 && ((short) ((int) (j4 >>> 32))) + this.parallelism > 0;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t3) {
        return new ForkJoinTask.AdaptedRunnable(runnable, t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ForkJoinTask<?> nextTaskFor(WorkQueue workQueue) {
        ForkJoinTask<?> pollAt;
        while (true) {
            ForkJoinTask<?> nextLocalTask = workQueue.nextLocalTask();
            if (nextLocalTask != null) {
                return nextLocalTask;
            }
            WorkQueue findNonEmptyStealQueue = findNonEmptyStealQueue();
            if (findNonEmptyStealQueue == null) {
                return null;
            }
            int i4 = findNonEmptyStealQueue.base;
            if (i4 - findNonEmptyStealQueue.f54815top < 0 && (pollAt = findNonEmptyStealQueue.pollAt(i4)) != null) {
                return pollAt;
            }
        }
    }

    protected ForkJoinTask<?> pollSubmission() {
        ForkJoinTask<?> poll;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            for (int i4 = 0; i4 < workQueueArr.length; i4 += 2) {
                WorkQueue workQueue = workQueueArr[i4];
                if (workQueue != null && (poll = workQueue.poll()) != null) {
                    return poll;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r1.compareAndSwapInt(r12, io.netty.util.internal.chmv8.ForkJoinPool.PLOCK, r6, r10) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue registerWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread r13) {
        /*
            r12 = this;
            r0 = 1
            r13.setDaemon(r0)
            java.lang.Thread$UncaughtExceptionHandler r1 = r12.ueh
            if (r1 == 0) goto Lb
            r13.setUncaughtExceptionHandler(r1)
        Lb:
            sun.misc.Unsafe r1 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r4 = io.netty.util.internal.chmv8.ForkJoinPool.INDEXSEED
            int r6 = r12.indexSeed
            r2 = 1640531527(0x61c88647, float:4.6237806E20)
            int r8 = r6 + r2
            r2 = r1
            r3 = r12
            r7 = r8
            boolean r2 = r2.compareAndSwapInt(r3, r4, r6, r7)
            if (r2 == 0) goto Lb
            if (r8 == 0) goto Lb
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue r9 = new io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue
            short r2 = r12.mode
            r9.<init>(r12, r13, r2, r8)
            int r6 = r12.plock
            r2 = r6 & 2
            if (r2 != 0) goto L3b
            long r4 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            int r10 = r6 + 2
            r2 = r1
            r3 = r12
            r7 = r10
            boolean r1 = r2.compareAndSwapInt(r3, r4, r6, r7)
            if (r1 != 0) goto L3f
        L3b:
            int r10 = r12.acquirePlock()
        L3f:
            r5 = r10
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r5
            int r2 = r5 + 2
            r3 = 2147483647(0x7fffffff, float:NaN)
            r2 = r2 & r3
            r7 = r1 | r2
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r1 = r12.workQueues     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L85
            int r2 = r1.length     // Catch: java.lang.Throwable -> La6
            int r3 = r2 + (-1)
            int r4 = r8 << 1
            r4 = r4 | r0
            r4 = r4 & r3
            r6 = r1[r4]     // Catch: java.lang.Throwable -> La6
            if (r6 == 0) goto L7e
            r6 = 4
            r8 = 2
            if (r2 > r6) goto L5f
            goto L66
        L5f:
            int r6 = r2 >>> 1
            r10 = 65534(0xfffe, float:9.1833E-41)
            r6 = r6 & r10
            int r8 = r8 + r6
        L66:
            r6 = 0
        L67:
            r10 = 0
        L68:
            int r4 = r4 + r8
            r4 = r4 & r3
            r11 = r1[r4]     // Catch: java.lang.Throwable -> La6
            if (r11 == 0) goto L7e
            int r10 = r10 + r0
            if (r10 < r2) goto L68
            int r2 = r2 << 1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r2)     // Catch: java.lang.Throwable -> La6
            io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue[] r1 = (io.netty.util.internal.chmv8.ForkJoinPool.WorkQueue[]) r1     // Catch: java.lang.Throwable -> La6
            r12.workQueues = r1     // Catch: java.lang.Throwable -> La6
            int r3 = r2 + (-1)
            goto L67
        L7e:
            short r2 = (short) r4     // Catch: java.lang.Throwable -> La6
            r9.poolIndex = r2     // Catch: java.lang.Throwable -> La6
            r9.eventCount = r4     // Catch: java.lang.Throwable -> La6
            r1[r4] = r9     // Catch: java.lang.Throwable -> La6
        L85:
            sun.misc.Unsafe r1 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r3 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            r2 = r12
            r6 = r7
            boolean r1 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r1 != 0) goto L94
            r12.releasePlock(r7)
        L94:
            java.lang.String r1 = r12.workerNamePrefix
            short r2 = r9.poolIndex
            int r0 = r2 >>> 1
            java.lang.String r0 = java.lang.Integer.toString(r0)
            java.lang.String r0 = r1.concat(r0)
            r13.setName(r0)
            return r9
        La6:
            r13 = move-exception
            sun.misc.Unsafe r1 = io.netty.util.internal.chmv8.ForkJoinPool.U
            long r3 = io.netty.util.internal.chmv8.ForkJoinPool.PLOCK
            r2 = r12
            r6 = r7
            boolean r0 = r1.compareAndSwapInt(r2, r3, r5, r6)
            if (r0 != 0) goto Lb6
            r12.releasePlock(r7)
        Lb6:
            goto Lb8
        Lb7:
            throw r13
        Lb8:
            goto Lb7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.registerWorker(io.netty.util.internal.chmv8.ForkJoinWorkerThread):io.netty.util.internal.chmv8.ForkJoinPool$WorkQueue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runWorker(WorkQueue workQueue) {
        workQueue.growArray();
        int i4 = workQueue.hint;
        while (scan(workQueue, i4) == 0) {
            int i5 = i4 ^ (i4 << 13);
            int i6 = i5 ^ (i5 >>> 17);
            i4 = i6 ^ (i6 << 5);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        tryTerminate(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        checkPermission();
        tryTerminate(true, true);
        return Collections.emptyList();
    }

    final void signalWork(WorkQueue[] workQueueArr, WorkQueue workQueue) {
        int i4;
        WorkQueue workQueue2;
        while (true) {
            long j4 = this.ctl;
            int i5 = (int) (j4 >>> 32);
            if (i5 >= 0) {
                return;
            }
            int i6 = (int) j4;
            if (i6 <= 0) {
                if (((short) i5) < 0) {
                    tryAddWorker();
                    return;
                }
                return;
            } else if (workQueueArr == null || workQueueArr.length <= (i4 = 65535 & i6) || (workQueue2 = workQueueArr[i4]) == null) {
                return;
            } else {
                long j5 = (workQueue2.nextWait & Integer.MAX_VALUE) | ((i5 + 65536) << 32);
                int i7 = (65536 + i6) & Integer.MAX_VALUE;
                if (workQueue2.eventCount == (i6 | Integer.MIN_VALUE)) {
                    Unsafe unsafe = U;
                    if (unsafe.compareAndSwapLong(this, CTL, j4, j5)) {
                        workQueue2.eventCount = i7;
                        Thread thread = workQueue2.parker;
                        if (thread != null) {
                            unsafe.unpark(thread);
                            return;
                        }
                        return;
                    }
                }
                if (workQueue != null && workQueue.base >= workQueue.f54815top) {
                    return;
                }
            }
        }
    }

    public String toString() {
        long j4;
        long j5;
        int i4;
        String str;
        long j6 = this.stealCount;
        long j7 = this.ctl;
        WorkQueue[] workQueueArr = this.workQueues;
        if (workQueueArr != null) {
            j4 = 0;
            j5 = 0;
            i4 = 0;
            for (int i5 = 0; i5 < workQueueArr.length; i5++) {
                WorkQueue workQueue = workQueueArr[i5];
                if (workQueue != null) {
                    int queueSize = workQueue.queueSize();
                    if ((i5 & 1) == 0) {
                        j5 += queueSize;
                    } else {
                        j4 += queueSize;
                        j6 += workQueue.nsteals;
                        if (workQueue.isApparentlyUnblocked()) {
                            i4++;
                        }
                    }
                }
            }
        } else {
            j4 = 0;
            j5 = 0;
            i4 = 0;
        }
        short s3 = this.parallelism;
        int i6 = ((short) (j7 >>> 32)) + s3;
        int i7 = ((int) (j7 >> 48)) + s3;
        if (i7 < 0) {
            i7 = 0;
        }
        if ((j7 & 2147483648L) != 0) {
            str = i6 == 0 ? "Terminated" : "Terminating";
        } else {
            str = this.plock < 0 ? "Shutting down" : "Running";
        }
        return super.toString() + "[" + str + ", parallelism = " + ((int) s3) + ", size = " + i6 + ", active = " + i7 + ", running = " + i4 + ", steals = " + j6 + ", tasks = " + j4 + ", submissions = " + j5 + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tryCompensate(long j4) {
        int length;
        ForkJoinWorkerThread forkJoinWorkerThread;
        WorkQueue[] workQueueArr = this.workQueues;
        short s3 = this.parallelism;
        int i4 = (int) j4;
        if (workQueueArr == null || (length = workQueueArr.length - 1) < 0 || i4 < 0 || this.ctl != j4) {
            return false;
        }
        WorkQueue workQueue = workQueueArr[length & i4];
        if (i4 != 0 && workQueue != null) {
            long j5 = (workQueue.nextWait & Integer.MAX_VALUE) | ((-4294967296L) & j4);
            int i5 = (65536 + i4) & Integer.MAX_VALUE;
            if (workQueue.eventCount == (i4 | Integer.MIN_VALUE)) {
                Unsafe unsafe = U;
                if (unsafe.compareAndSwapLong(this, CTL, j4, j5)) {
                    workQueue.eventCount = i5;
                    Thread thread = workQueue.parker;
                    if (thread != null) {
                        unsafe.unpark(thread);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        short s4 = (short) (j4 >>> 32);
        if (s4 >= 0 && ((int) (j4 >> 48)) + s3 > 1) {
            return U.compareAndSwapLong(this, CTL, j4, ((j4 - AC_UNIT) & AC_MASK) | (281474976710655L & j4));
        } else if (s4 + s3 < MAX_CAP) {
            if (U.compareAndSwapLong(this, CTL, j4, ((4294967296L + j4) & TC_MASK) | ((-281470681743361L) & j4))) {
                Throwable th = null;
                try {
                    ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory = this.factory;
                    if (forkJoinWorkerThreadFactory != null) {
                        forkJoinWorkerThread = forkJoinWorkerThreadFactory.newThread(this);
                        if (forkJoinWorkerThread != null) {
                            try {
                                forkJoinWorkerThread.start();
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                deregisterWorker(forkJoinWorkerThread, th);
                                return false;
                            }
                        }
                    } else {
                        forkJoinWorkerThread = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    forkJoinWorkerThread = null;
                }
                deregisterWorker(forkJoinWorkerThread, th);
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean tryExternalUnpush(ForkJoinTask<?> forkJoinTask) {
        WorkQueue workQueue;
        ForkJoinTask<?>[] forkJoinTaskArr;
        int[] iArr = submitters.get();
        WorkQueue[] workQueueArr = this.workQueues;
        if (iArr == null || workQueueArr == null) {
            return false;
        }
        boolean z3 = true;
        int length = workQueueArr.length - 1;
        if (length < 0 || (workQueue = workQueueArr[iArr[0] & length & 126]) == null) {
            return false;
        }
        int i4 = workQueue.base;
        int i5 = workQueue.f54815top;
        if (i4 == i5 || (forkJoinTaskArr = workQueue.array) == null) {
            return false;
        }
        int i6 = i5 - 1;
        long length2 = (((forkJoinTaskArr.length - 1) & i6) << ASHIFT) + ABASE;
        Unsafe unsafe = U;
        if (unsafe.getObject(forkJoinTaskArr, length2) == forkJoinTask && unsafe.compareAndSwapInt(workQueue, QLOCK, 0, 1)) {
            if (workQueue.f54815top == i5 && workQueue.array == forkJoinTaskArr && a.a(unsafe, forkJoinTaskArr, length2, forkJoinTask, null)) {
                workQueue.f54815top = i6;
            } else {
                z3 = false;
            }
            workQueue.qlock = 0;
            return z3;
        }
        return false;
    }

    public ForkJoinPool(int i4) {
        this(i4, defaultForkJoinWorkerThreadFactory, null, false);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ForkJoinPool(int r7, io.netty.util.internal.chmv8.ForkJoinPool.ForkJoinWorkerThreadFactory r8, java.lang.Thread.UncaughtExceptionHandler r9, boolean r10) {
        /*
            r6 = this;
            int r1 = checkParallelism(r7)
            io.netty.util.internal.chmv8.ForkJoinPool$ForkJoinWorkerThreadFactory r2 = checkFactory(r8)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "ForkJoinPool-"
            r7.append(r8)
            int r8 = nextPoolId()
            r7.append(r8)
            java.lang.String r8 = "-worker-"
            r7.append(r8)
            java.lang.String r5 = r7.toString()
            r0 = r6
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            checkPermission()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinPool.<init>(int, io.netty.util.internal.chmv8.ForkJoinPool$ForkJoinWorkerThreadFactory, java.lang.Thread$UncaughtExceptionHandler, boolean):void");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ForkJoinTask<?> runnableExecuteAction;
        runnable.getClass();
        if (runnable instanceof ForkJoinTask) {
            runnableExecuteAction = (ForkJoinTask) runnable;
        } else {
            runnableExecuteAction = new ForkJoinTask.RunnableExecuteAction(runnable);
        }
        externalPush(runnableExecuteAction);
    }

    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> forkJoinTask) {
        forkJoinTask.getClass();
        externalPush(forkJoinTask);
        return forkJoinTask;
    }

    private ForkJoinPool(int i4, ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, int i5, String str) {
        this.workerNamePrefix = str;
        this.factory = forkJoinWorkerThreadFactory;
        this.ueh = uncaughtExceptionHandler;
        this.mode = (short) i5;
        this.parallelism = (short) i4;
        long j4 = -i4;
        this.ctl = ((j4 << 32) & TC_MASK) | ((j4 << 48) & AC_MASK);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Callable<T> callable) {
        ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
        externalPush(adaptedCallable);
        return adaptedCallable;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Runnable runnable, T t3) {
        ForkJoinTask.AdaptedRunnable adaptedRunnable = new ForkJoinTask.AdaptedRunnable(runnable, t3);
        externalPush(adaptedRunnable);
        return adaptedRunnable;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ForkJoinTask<?> submit(Runnable runnable) {
        ForkJoinTask<?> adaptedRunnableAction;
        runnable.getClass();
        if (runnable instanceof ForkJoinTask) {
            adaptedRunnableAction = (ForkJoinTask) runnable;
        } else {
            adaptedRunnableAction = new ForkJoinTask.AdaptedRunnableAction(runnable);
        }
        externalPush(adaptedRunnableAction);
        return adaptedRunnableAction;
    }
}

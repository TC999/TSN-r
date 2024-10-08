package io.netty.util.internal.chmv8;

import io.netty.util.internal.chmv8.ForkJoinPool;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    private static final int EXCEPTION_MAP_CAPACITY = 32;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;
    private static final long STATUS;

    /* renamed from: U */
    private static final Unsafe f40316U;
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;
    private static final ReentrantLock exceptionTableLock = new ReentrantLock();
    private static final ReferenceQueue<Object> exceptionTableRefQueue = new ReferenceQueue<>();
    private static final ExceptionNode[] exceptionTable = new ExceptionNode[32];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class AdaptedCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedCallable(Callable<? extends T> callable) {
            callable.getClass();
            this.callable = callable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = this.callable.call();
                return true;
            } catch (Error e) {
                throw e;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class AdaptedRunnable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnable(Runnable runnable, T t) {
            runnable.getClass();
            this.runnable = runnable;
            this.result = t;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class AdaptedRunnableAction extends ForkJoinTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdaptedRunnableAction(Runnable runnable) {
            runnable.getClass();
            this.runnable = runnable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class ExceptionNode extends WeakReference<ForkJoinTask<?>> {

        /* renamed from: ex */
        final Throwable f40317ex;
        ExceptionNode next;
        final long thrower;

        ExceptionNode(ForkJoinTask<?> forkJoinTask, Throwable th, ExceptionNode exceptionNode) {
            super(forkJoinTask, ForkJoinTask.exceptionTableRefQueue);
            this.f40317ex = th;
            this.next = exceptionNode;
            this.thrower = Thread.currentThread().getId();
        }
    }

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class RunnableExecuteAction extends ForkJoinTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableExecuteAction(Runnable runnable) {
            runnable.getClass();
            this.runnable = runnable;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        void internalPropagateException(Throwable th) {
            ForkJoinTask.rethrow(th);
        }

        @Override // io.netty.util.internal.chmv8.ForkJoinTask
        public final void setRawResult(Void r1) {
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            f40316U = unsafe;
            STATUS = unsafe.objectFieldOffset(ForkJoinTask.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void cancelIgnoringExceptions(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask == null || forkJoinTask.status < 0) {
            return;
        }
        try {
            forkJoinTask.cancel(false);
        } catch (Throwable unused) {
        }
    }

    private void clearExceptionalCompletion() {
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            int length = identityHashCode & (exceptionNodeArr.length - 1);
            ExceptionNode exceptionNode = exceptionNodeArr[length];
            ExceptionNode exceptionNode2 = null;
            while (true) {
                if (exceptionNode == null) {
                    break;
                }
                ExceptionNode exceptionNode3 = exceptionNode.next;
                if (exceptionNode.get() != this) {
                    exceptionNode2 = exceptionNode;
                    exceptionNode = exceptionNode3;
                } else if (exceptionNode2 == null) {
                    exceptionNodeArr[length] = exceptionNode3;
                } else {
                    exceptionNode2.next = exceptionNode3;
                }
            }
            expungeStaleExceptions();
            this.status = 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    private int doInvoke() {
        int doExec = doExec();
        if (doExec < 0) {
            return doExec;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            return forkJoinWorkerThread.pool.awaitJoin(forkJoinWorkerThread.workQueue, this);
        }
        return externalAwaitDone();
    }

    private int doJoin() {
        int doExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            ForkJoinPool.WorkQueue workQueue = forkJoinWorkerThread.workQueue;
            return (!workQueue.tryUnpush(this) || (doExec = doExec()) >= 0) ? forkJoinWorkerThread.pool.awaitJoin(workQueue, this) : doExec;
        }
        return externalAwaitDone();
    }

    private static void expungeStaleExceptions() {
        while (true) {
            Reference<? extends Object> poll = exceptionTableRefQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof ExceptionNode) {
                ExceptionNode[] exceptionNodeArr = exceptionTable;
                int identityHashCode = System.identityHashCode(((ExceptionNode) poll).get()) & (exceptionNodeArr.length - 1);
                ExceptionNode exceptionNode = exceptionNodeArr[identityHashCode];
                ExceptionNode exceptionNode2 = null;
                while (true) {
                    if (exceptionNode != null) {
                        ExceptionNode exceptionNode3 = exceptionNode.next;
                        if (exceptionNode != poll) {
                            exceptionNode2 = exceptionNode;
                            exceptionNode = exceptionNode3;
                        } else if (exceptionNode2 == null) {
                            exceptionNodeArr[identityHashCode] = exceptionNode3;
                        } else {
                            exceptionNode2.next = exceptionNode3;
                        }
                    }
                }
            }
        }
    }

    private int externalAwaitDone() {
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        int i = this.status;
        if (i >= 0) {
            if (forkJoinPool != null) {
                if (this instanceof CountedCompleter) {
                    i = forkJoinPool.externalHelpComplete((CountedCompleter) this);
                } else if (forkJoinPool.tryExternalUnpush(this)) {
                    i = doExec();
                }
            }
            if (i >= 0) {
                int i2 = this.status;
                if (i2 >= 0) {
                    boolean z = false;
                    int i3 = i2;
                    do {
                        if (f40316U.compareAndSwapInt(this, STATUS, i3, i3 | 65536)) {
                            synchronized (this) {
                                if (this.status >= 0) {
                                    try {
                                        wait();
                                    } catch (InterruptedException unused) {
                                        z = true;
                                    }
                                } else {
                                    notifyAll();
                                }
                            }
                        }
                        i3 = this.status;
                    } while (i3 >= 0);
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return i3;
                }
                return i2;
            }
            return i;
        }
        return i;
    }

    private int externalInterruptibleAwaitDone() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.common;
        if (!Thread.interrupted()) {
            if (this.status >= 0 && forkJoinPool != null) {
                if (this instanceof CountedCompleter) {
                    forkJoinPool.externalHelpComplete((CountedCompleter) this);
                } else if (forkJoinPool.tryExternalUnpush(this)) {
                    doExec();
                }
            }
            while (true) {
                int i = this.status;
                if (i < 0) {
                    return i;
                }
                if (f40316U.compareAndSwapInt(this, STATUS, i, i | 65536)) {
                    synchronized (this) {
                        if (this.status >= 0) {
                            wait();
                        } else {
                            notifyAll();
                        }
                    }
                }
            }
        } else {
            throw new InterruptedException();
        }
    }

    public static ForkJoinPool getPool() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).pool;
        }
        return null;
    }

    public static int getQueuedTaskCount() {
        ForkJoinPool.WorkQueue commonSubmitterQueue;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            commonSubmitterQueue = ((ForkJoinWorkerThread) currentThread).workQueue;
        } else {
            commonSubmitterQueue = ForkJoinPool.commonSubmitterQueue();
        }
        if (commonSubmitterQueue == null) {
            return 0;
        }
        return commonSubmitterQueue.queueSize();
    }

    public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.getSurplusQueuedTaskCount();
    }

    private Throwable getThrowableException() {
        Throwable th;
        if ((this.status & (-268435456)) != Integer.MIN_VALUE) {
            return null;
        }
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = exceptionTableLock;
        reentrantLock.lock();
        try {
            expungeStaleExceptions();
            ExceptionNode[] exceptionNodeArr = exceptionTable;
            ExceptionNode exceptionNode = exceptionNodeArr[identityHashCode & (exceptionNodeArr.length - 1)];
            while (exceptionNode != null) {
                if (exceptionNode.get() == this) {
                    break;
                }
                exceptionNode = exceptionNode.next;
            }
            if (exceptionNode == null || (th = exceptionNode.f40317ex) == null) {
                return null;
            }
            return th;
        } finally {
            reentrantLock.unlock();
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.internal.chmv8.ForkJoinTask.1
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
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void helpExpungeStaleExceptions() {
        ReentrantLock reentrantLock = exceptionTableLock;
        if (reentrantLock.tryLock()) {
            try {
                expungeStaleExceptions();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void helpQuiesce() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            forkJoinWorkerThread.pool.helpQuiescePool(forkJoinWorkerThread.workQueue);
            return;
        }
        ForkJoinPool.quiesceCommonPool();
    }

    public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    public static void invokeAll(ForkJoinTask<?> forkJoinTask, ForkJoinTask<?> forkJoinTask2) {
        forkJoinTask2.fork();
        int doInvoke = forkJoinTask.doInvoke() & (-268435456);
        if (doInvoke != -268435456) {
            forkJoinTask.reportException(doInvoke);
        }
        int doJoin = forkJoinTask2.doJoin() & (-268435456);
        if (doJoin != -268435456) {
            forkJoinTask2.reportException(doJoin);
        }
    }

    protected static ForkJoinTask<?> peekNextLocalTask() {
        ForkJoinPool.WorkQueue commonSubmitterQueue;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            commonSubmitterQueue = ((ForkJoinWorkerThread) currentThread).workQueue;
        } else {
            commonSubmitterQueue = ForkJoinPool.commonSubmitterQueue();
        }
        if (commonSubmitterQueue == null) {
            return null;
        }
        return commonSubmitterQueue.peek();
    }

    protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).workQueue.nextLocalTask();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollTask() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread forkJoinWorkerThread = (ForkJoinWorkerThread) currentThread;
            return forkJoinWorkerThread.pool.nextTaskFor(forkJoinWorkerThread.workQueue);
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        if (readObject != null) {
            setExceptionalCompletion((Throwable) readObject);
        }
    }

    private void reportException(int i) {
        if (i == CANCELLED) {
            throw new CancellationException();
        }
        if (i == Integer.MIN_VALUE) {
            rethrow(getThrowableException());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rethrow(Throwable th) {
        if (th != null) {
            uncheckedThrow(th);
        }
    }

    private int setCompletion(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!f40316U.compareAndSwapInt(this, STATUS, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    private int setExceptionalCompletion(Throwable th) {
        int recordExceptionalCompletion = recordExceptionalCompletion(th);
        if (((-268435456) & recordExceptionalCompletion) == Integer.MIN_VALUE) {
            internalPropagateException(th);
        }
        return recordExceptionalCompletion;
    }

    static <T extends Throwable> void uncheckedThrow(Throwable th) throws Throwable {
        throw th;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (setCompletion(CANCELLED) & (-268435456)) == CANCELLED;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!f40316U.compareAndSwapInt(this, STATUS, i, (65535 & s2) | ((-65536) & i)));
        return true;
    }

    public void complete(V v) {
        try {
            setRawResult(v);
            setCompletion(-268435456);
        } catch (Throwable th) {
            setExceptionalCompletion(th);
        }
    }

    public void completeExceptionally(Throwable th) {
        if (!(th instanceof RuntimeException) && !(th instanceof Error)) {
            th = new RuntimeException(th);
        }
        setExceptionalCompletion(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int doExec() {
        int i = this.status;
        if (i >= 0) {
            try {
                return exec() ? setCompletion(-268435456) : i;
            } catch (Throwable th) {
                return setExceptionalCompletion(th);
            }
        }
        return i;
    }

    protected abstract boolean exec();

    public final ForkJoinTask<V> fork() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ((ForkJoinWorkerThread) currentThread).workQueue.push(this);
        } else {
            ForkJoinPool.common.externalPush(this);
        }
        return this;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Throwable throwableException;
        int doJoin = (Thread.currentThread() instanceof ForkJoinWorkerThread ? doJoin() : externalInterruptibleAwaitDone()) & (-268435456);
        if (doJoin != CANCELLED) {
            if (doJoin == Integer.MIN_VALUE && (throwableException = getThrowableException()) != null) {
                throw new ExecutionException(throwableException);
            }
            return getRawResult();
        }
        throw new CancellationException();
    }

    public final Throwable getException() {
        int i = this.status & (-268435456);
        if (i >= -268435456) {
            return null;
        }
        return i == CANCELLED ? new CancellationException() : getThrowableException();
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public abstract V getRawResult();

    void internalPropagateException(Throwable th) {
    }

    public final V invoke() {
        int doInvoke = doInvoke() & (-268435456);
        if (doInvoke != -268435456) {
            reportException(doInvoke);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & (-268435456)) == CANCELLED;
    }

    public final boolean isCompletedAbnormally() {
        return this.status < -268435456;
    }

    public final boolean isCompletedNormally() {
        return (this.status & (-268435456)) == -268435456;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    public final V join() {
        int doJoin = doJoin() & (-268435456);
        if (doJoin != -268435456) {
            reportException(doJoin);
        }
        return getRawResult();
    }

    public final void quietlyComplete() {
        setCompletion(-268435456);
    }

    public final void quietlyInvoke() {
        doInvoke();
    }

    public final void quietlyJoin() {
        doJoin();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        r2[r0] = new io.netty.util.internal.chmv8.ForkJoinTask.ExceptionNode(r5, r6, r2[r0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int recordExceptionalCompletion(java.lang.Throwable r6) {
        /*
            r5 = this;
            int r0 = r5.status
            if (r0 < 0) goto L3c
            int r0 = java.lang.System.identityHashCode(r5)
            java.util.concurrent.locks.ReentrantLock r1 = io.netty.util.internal.chmv8.ForkJoinTask.exceptionTableLock
            r1.lock()
            expungeStaleExceptions()     // Catch: java.lang.Throwable -> L37
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode[] r2 = io.netty.util.internal.chmv8.ForkJoinTask.exceptionTable     // Catch: java.lang.Throwable -> L37
            int r3 = r2.length     // Catch: java.lang.Throwable -> L37
            int r3 = r3 + (-1)
            r0 = r0 & r3
            r3 = r2[r0]     // Catch: java.lang.Throwable -> L37
        L18:
            if (r3 != 0) goto L24
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode r3 = new io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode     // Catch: java.lang.Throwable -> L37
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L37
            r3.<init>(r5, r6, r4)     // Catch: java.lang.Throwable -> L37
            r2[r0] = r3     // Catch: java.lang.Throwable -> L37
            goto L2a
        L24:
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L37
            if (r4 != r5) goto L34
        L2a:
            r1.unlock()
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r5.setCompletion(r6)
            goto L3c
        L34:
            io.netty.util.internal.chmv8.ForkJoinTask$ExceptionNode r3 = r3.next     // Catch: java.lang.Throwable -> L37
            goto L18
        L37:
            r6 = move-exception
            r1.unlock()
            throw r6
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinTask.recordExceptionalCompletion(java.lang.Throwable):int");
    }

    public void reinitialize() {
        if ((this.status & (-268435456)) == Integer.MIN_VALUE) {
            clearExceptionalCompletion();
        } else {
            this.status = 0;
        }
    }

    public final short setForkJoinTaskTag(short s) {
        Unsafe unsafe;
        long j;
        int i;
        do {
            unsafe = f40316U;
            j = STATUS;
            i = this.status;
        } while (!unsafe.compareAndSwapInt(this, j, i, ((-65536) & i) | (65535 & s)));
        return (short) i;
    }

    protected abstract void setRawResult(V v);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean trySetSignal() {
        int i = this.status;
        return i >= 0 && f40316U.compareAndSwapInt(this, STATUS, i, i | 65536);
    }

    public boolean tryUnfork() {
        Thread currentThread = Thread.currentThread();
        return currentThread instanceof ForkJoinWorkerThread ? ((ForkJoinWorkerThread) currentThread).workQueue.tryUnpush(this) : ForkJoinPool.common.tryExternalUnpush(this);
    }

    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T t) {
        return new AdaptedRunnable(runnable, t);
    }

    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable(callable);
    }

    public static void invokeAll(ForkJoinTask<?>... forkJoinTaskArr) {
        int length = forkJoinTaskArr.length - 1;
        Throwable th = null;
        for (int i = length; i >= 0; i--) {
            ForkJoinTask<?> forkJoinTask = forkJoinTaskArr[i];
            if (forkJoinTask == null) {
                if (th == null) {
                    th = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.doInvoke() < -268435456 && th == null) {
                th = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= length; i2++) {
            ForkJoinTask<?> forkJoinTask2 = forkJoinTaskArr[i2];
            if (forkJoinTask2 != null) {
                if (th != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.doJoin() < -268435456) {
                    th = forkJoinTask2.getException();
                }
            }
        }
        if (th != null) {
            rethrow(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bb, code lost:
        r2 = r0;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(long r20, java.util.concurrent.TimeUnit r22) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.chmv8.ForkJoinTask.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> collection) {
        if ((collection instanceof RandomAccess) && (collection instanceof List)) {
            List list = (List) collection;
            Throwable th = null;
            int size = list.size() - 1;
            for (int i = size; i >= 0; i--) {
                ForkJoinTask forkJoinTask = (ForkJoinTask) list.get(i);
                if (forkJoinTask == null) {
                    if (th == null) {
                        th = new NullPointerException();
                    }
                } else if (i != 0) {
                    forkJoinTask.fork();
                } else if (forkJoinTask.doInvoke() < -268435456 && th == null) {
                    th = forkJoinTask.getException();
                }
            }
            for (int i2 = 1; i2 <= size; i2++) {
                ForkJoinTask forkJoinTask2 = (ForkJoinTask) list.get(i2);
                if (forkJoinTask2 != null) {
                    if (th != null) {
                        forkJoinTask2.cancel(false);
                    } else if (forkJoinTask2.doJoin() < -268435456) {
                        th = forkJoinTask2.getException();
                    }
                }
            }
            if (th != null) {
                rethrow(th);
            }
            return collection;
        }
        invokeAll((ForkJoinTask[]) collection.toArray(new ForkJoinTask[collection.size()]));
        return collection;
    }
}

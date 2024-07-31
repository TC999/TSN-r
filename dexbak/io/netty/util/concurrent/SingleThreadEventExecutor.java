package io.netty.util.concurrent;

import io.netty.channel.C13675a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER;
    private static final long SCHEDULE_PURGE_INTERVAL;
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_STARTED = 2;
    private static final int ST_TERMINATED = 5;
    private final boolean addTaskWakesUp;
    private final Executor executor;
    private volatile long gracefulShutdownQuietPeriod;
    private long gracefulShutdownStartTime;
    private volatile long gracefulShutdownTimeout;
    private volatile boolean interrupted;
    private long lastExecutionTime;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private final Set<Runnable> shutdownHooks;
    private volatile int state;
    private final Queue<Runnable> taskQueue;
    private final Promise<?> terminationFuture;
    private volatile Thread thread;
    private final Semaphore threadLock;
    private volatile ThreadProperties threadProperties;
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(SingleThreadEventExecutor.class);
    private static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private static final Runnable NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class DefaultThreadProperties implements ThreadProperties {

        /* renamed from: t */
        private final Thread f40296t;

        DefaultThreadProperties(Thread thread) {
            this.f40296t = thread;
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        /* renamed from: id */
        public long mo12680id() {
            return this.f40296t.getId();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.f40296t.isAlive();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.f40296t.isDaemon();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.f40296t.isInterrupted();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.f40296t.getName();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.f40296t.getPriority();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.f40296t.getStackTrace();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.f40296t.getState();
        }
    }

    static {
        AtomicIntegerFieldUpdater<SingleThreadEventExecutor> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(SingleThreadEventExecutor.class, "state");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
        }
        STATE_UPDATER = newAtomicIntegerFieldUpdater;
        AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> newAtomicReferenceFieldUpdater = PlatformDependent.newAtomicReferenceFieldUpdater(SingleThreadEventExecutor.class, "threadProperties");
        if (newAtomicReferenceFieldUpdater == null) {
            newAtomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
        }
        PROPERTIES_UPDATER = newAtomicReferenceFieldUpdater;
        SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z);
    }

    static /* synthetic */ Thread access$100(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.thread;
    }

    static /* synthetic */ Thread access$102(SingleThreadEventExecutor singleThreadEventExecutor, Thread thread) {
        singleThreadEventExecutor.thread = thread;
        return thread;
    }

    static /* synthetic */ boolean access$200(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.interrupted;
    }

    static /* synthetic */ InternalLogger access$300() {
        return logger;
    }

    static /* synthetic */ AtomicIntegerFieldUpdater access$400() {
        return STATE_UPDATER;
    }

    static /* synthetic */ long access$500(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.gracefulShutdownStartTime;
    }

    static /* synthetic */ Semaphore access$600(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.threadLock;
    }

    static /* synthetic */ Queue access$700(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.taskQueue;
    }

    static /* synthetic */ Promise access$800(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.terminationFuture;
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.5
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 230
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:59)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instructions count: 1125
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.RunnableC140635.run():void");
            }
        });
    }

    private boolean fetchFromScheduledTaskQueue() {
        long nanoTime = AbstractScheduledEventExecutor.nanoTime();
        Runnable pollScheduledTask = pollScheduledTask(nanoTime);
        while (pollScheduledTask != null) {
            if (!this.taskQueue.offer(pollScheduledTask)) {
                scheduledTaskQueue().add((ScheduledFutureTask) pollScheduledTask);
                return false;
            }
            pollScheduledTask = pollScheduledTask(nanoTime);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private boolean runShutdownHooks() {
        boolean z = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList<Runnable> arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            for (Runnable runnable : arrayList) {
                try {
                    runnable.run();
                } finally {
                    z = true;
                }
                z = true;
            }
        }
        if (z) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return z;
    }

    private void startThread() {
        AtomicIntegerFieldUpdater<SingleThreadEventExecutor> atomicIntegerFieldUpdater = STATE_UPDATER;
        if (atomicIntegerFieldUpdater.get(this) == 1 && atomicIntegerFieldUpdater.compareAndSet(this, 1, 2)) {
            doStartThread();
        }
    }

    private void throwIfInEventLoop(String str) {
        if (inEventLoop()) {
            throw new RejectedExecutionException("Calling " + str + " from within the EventLoop is not allowed");
        }
    }

    public void addShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.add(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(runnable);
                }
            });
        }
    }

    protected void addTask(Runnable runnable) {
        if (runnable != null) {
            if (offerTask(runnable)) {
                return;
            }
            reject(runnable);
            return;
        }
        throw new NullPointerException("task");
    }

    protected void afterRunningAllTasks() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit != null) {
            if (!inEventLoop()) {
                if (this.threadLock.tryAcquire(j, timeUnit)) {
                    this.threadLock.release();
                }
                return isTerminated();
            }
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        throw new NullPointerException("unit");
    }

    protected void cleanup() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean confirmShutdown() {
        if (isShuttingDown()) {
            if (inEventLoop()) {
                cancelScheduledTasks();
                if (this.gracefulShutdownStartTime == 0) {
                    this.gracefulShutdownStartTime = ScheduledFutureTask.nanoTime();
                }
                if (!runAllTasks() && !runShutdownHooks()) {
                    long nanoTime = ScheduledFutureTask.nanoTime();
                    if (isShutdown() || nanoTime - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || nanoTime - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
                        return true;
                    }
                    wakeup(true);
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                    return false;
                } else if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
                    return true;
                } else {
                    wakeup(true);
                    return false;
                }
            }
            throw new IllegalStateException("must be invoked from an event loop");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long delayNanos(long j) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.delayNanos(j);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            boolean inEventLoop = inEventLoop();
            if (inEventLoop) {
                addTask(runnable);
            } else {
                startThread();
                addTask(runnable);
                if (isShutdown() && removeTask(runnable)) {
                    reject();
                }
            }
            if (this.addTaskWakesUp || !wakesUpForTask(runnable)) {
                return;
            }
            wakeup(inEventLoop);
            return;
        }
        throw new NullPointerException("task");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasTasks() {
        return !this.taskQueue.isEmpty();
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    protected void interruptThread() {
        Thread thread = this.thread;
        if (thread == null) {
            this.interrupted = true;
        } else {
            thread.interrupt();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return STATE_UPDATER.get(this) >= 4;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return STATE_UPDATER.get(this) >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return STATE_UPDATER.get(this) == 5;
    }

    @Deprecated
    protected Queue<Runnable> newTaskQueue() {
        return newTaskQueue(this.maxPendingTasks);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean offerTask(Runnable runnable) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(runnable);
    }

    protected Runnable peekTask() {
        return this.taskQueue.peek();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Runnable pollTask() {
        return pollTaskFrom(this.taskQueue);
    }

    protected final Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable poll;
        do {
            poll = queue.poll();
        } while (poll == WAKEUP_TASK);
        return poll;
    }

    public void removeShutdownHook(final Runnable runnable) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(runnable);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(runnable);
                }
            });
        }
    }

    protected boolean removeTask(Runnable runnable) {
        if (runnable != null) {
            return this.taskQueue.remove(runnable);
        }
        throw new NullPointerException("task");
    }

    protected abstract void run();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runAllTasks() {
        boolean fetchFromScheduledTaskQueue;
        boolean z = false;
        do {
            fetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z = true;
                continue;
            }
        } while (!fetchFromScheduledTaskQueue);
        if (z) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        afterRunningAllTasks();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean runAllTasksFrom(Queue<Runnable> queue) {
        Runnable pollTaskFrom = pollTaskFrom(queue);
        if (pollTaskFrom == null) {
            return false;
        }
        do {
            AbstractEventExecutor.safeExecute(pollTaskFrom);
            pollTaskFrom = pollTaskFrom(queue);
        } while (pollTaskFrom != null);
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        boolean z;
        if (isShutdown()) {
            return;
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            AtomicIntegerFieldUpdater<SingleThreadEventExecutor> atomicIntegerFieldUpdater = STATE_UPDATER;
            int i = atomicIntegerFieldUpdater.get(this);
            int i2 = 4;
            if (inEventLoop || i == 1 || i == 2 || i == 3) {
                z = true;
            } else {
                i2 = i;
                z = false;
            }
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i2)) {
                if (i == 1) {
                    doStartThread();
                }
                if (z) {
                    wakeup(inEventLoop);
                    return;
                }
                return;
            }
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("quietPeriod: " + j + " (expected >= 0)");
        } else if (j2 < j) {
            throw new IllegalArgumentException("timeout: " + j2 + " (expected >= quietPeriod (" + j + "))");
        } else if (timeUnit != null) {
            if (isShuttingDown()) {
                return terminationFuture();
            }
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                AtomicIntegerFieldUpdater<SingleThreadEventExecutor> atomicIntegerFieldUpdater = STATE_UPDATER;
                int i = atomicIntegerFieldUpdater.get(this);
                int i2 = 3;
                if (inEventLoop || i == 1 || i == 2) {
                    z = true;
                } else {
                    i2 = i;
                    z = false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i2)) {
                    this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j);
                    this.gracefulShutdownTimeout = timeUnit.toNanos(j2);
                    if (i == 1) {
                        doStartThread();
                    }
                    if (z) {
                        wakeup(inEventLoop);
                    }
                    return terminationFuture();
                }
            }
            return terminationFuture();
        } else {
            throw new NullPointerException("unit");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Runnable takeTask() {
        Runnable runnable;
        Queue<Runnable> queue = this.taskQueue;
        if (queue instanceof BlockingQueue) {
            BlockingQueue blockingQueue = (BlockingQueue) queue;
            do {
                ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
                runnable = null;
                if (peekScheduledTask == null) {
                    try {
                        Runnable runnable2 = (Runnable) blockingQueue.take();
                        try {
                            if (runnable2 == WAKEUP_TASK) {
                                return null;
                            }
                        } catch (InterruptedException unused) {
                        }
                        return runnable2;
                    } catch (InterruptedException unused2) {
                        return null;
                    }
                }
                long delayNanos = peekScheduledTask.delayNanos();
                if (delayNanos > 0) {
                    try {
                        runnable = (Runnable) blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException unused3) {
                        return null;
                    }
                }
                if (runnable == null) {
                    fetchFromScheduledTaskQueue();
                    runnable = (Runnable) blockingQueue.poll();
                    continue;
                }
            } while (runnable == null);
            return runnable;
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties = this.threadProperties;
        if (threadProperties == null) {
            Thread thread = this.thread;
            if (thread == null) {
                submit(NOOP_TASK).syncUninterruptibly();
                thread = this.thread;
            }
            DefaultThreadProperties defaultThreadProperties = new DefaultThreadProperties(thread);
            return !C13675a.m12692a(PROPERTIES_UPDATER, this, null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
        }
        return threadProperties;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLastExecutionTime() {
        this.lastExecutionTime = ScheduledFutureTask.nanoTime();
    }

    protected boolean wakesUpForTask(Runnable runnable) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wakeup(boolean z) {
        if (!z || STATE_UPDATER.get(this) == 3) {
            this.taskQueue.offer(WAKEUP_TASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z, i, rejectedExecutionHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Queue<Runnable> newTaskQueue(int i) {
        return new LinkedBlockingQueue(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z) {
        this(eventExecutorGroup, executor, z, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection, j, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new Semaphore(0);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z;
        int max = Math.max(16, i);
        this.maxPendingTasks = max;
        this.executor = (Executor) ObjectUtil.checkNotNull(executor, "executor");
        this.taskQueue = newTaskQueue(max);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runAllTasks(long j) {
        long nanoTime;
        fetchFromScheduledTaskQueue();
        Runnable pollTask = pollTask();
        if (pollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long nanoTime2 = ScheduledFutureTask.nanoTime() + j;
        long j2 = 0;
        while (true) {
            AbstractEventExecutor.safeExecute(pollTask);
            j2++;
            if ((63 & j2) == 0) {
                nanoTime = ScheduledFutureTask.nanoTime();
                if (nanoTime >= nanoTime2) {
                    break;
                }
            }
            pollTask = pollTask();
            if (pollTask == null) {
                nanoTime = ScheduledFutureTask.nanoTime();
                break;
            }
        }
        afterRunningAllTasks();
        this.lastExecutionTime = nanoTime;
        return true;
    }
}

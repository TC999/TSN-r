package io.netty.util.concurrent;

import io.netty.channel.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
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
    private final CountDownLatch threadLock;
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
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
    private static final long SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class DefaultThreadProperties implements ThreadProperties {

        /* renamed from: t  reason: collision with root package name */
        private final Thread f54808t;

        DefaultThreadProperties(Thread thread) {
            this.f54808t = thread;
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public long id() {
            return this.f54808t.getId();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.f54808t.isAlive();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.f54808t.isDaemon();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.f54808t.isInterrupted();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.f54808t.getName();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.f54808t.getPriority();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.f54808t.getStackTrace();
        }

        @Override // io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.f54808t.getState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z3) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z3);
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

    static /* synthetic */ int access$400(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.state;
    }

    static /* synthetic */ AtomicIntegerFieldUpdater access$500() {
        return STATE_UPDATER;
    }

    static /* synthetic */ long access$600(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.gracefulShutdownStartTime;
    }

    static /* synthetic */ CountDownLatch access$700(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.threadLock;
    }

    static /* synthetic */ Queue access$800(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.taskQueue;
    }

    static /* synthetic */ Promise access$900(SingleThreadEventExecutor singleThreadEventExecutor) {
        return singleThreadEventExecutor.terminationFuture;
    }

    private void doStartThread() {
        this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.5
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 256
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:59)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instructions count: 1274
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.SingleThreadEventExecutor.AnonymousClass5.run():void");
            }
        });
    }

    private boolean ensureThreadStarted(int i4) {
        if (i4 == 1) {
            try {
                doStartThread();
                return false;
            } catch (Throwable th) {
                STATE_UPDATER.set(this, 5);
                this.terminationFuture.tryFailure(th);
                if (!(th instanceof Exception)) {
                    PlatformDependent.throwException(th);
                }
                return true;
            }
        }
        return false;
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

    protected static Runnable pollTaskFrom(Queue<Runnable> queue) {
        Runnable poll;
        do {
            poll = queue.poll();
        } while (poll == WAKEUP_TASK);
        return poll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    private boolean runShutdownHooks() {
        boolean z3 = false;
        while (!this.shutdownHooks.isEmpty()) {
            ArrayList<Runnable> arrayList = new ArrayList(this.shutdownHooks);
            this.shutdownHooks.clear();
            for (Runnable runnable : arrayList) {
                try {
                    runnable.run();
                } finally {
                    z3 = true;
                }
                z3 = true;
            }
        }
        if (z3) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        return z3;
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            try {
                doStartThread();
            } catch (Throwable th) {
                STATE_UPDATER.compareAndSet(this, 2, 1);
                throw th;
            }
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
    public boolean awaitTermination(long j4, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit != null) {
            if (!inEventLoop()) {
                this.threadLock.await(j4, timeUnit);
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

    protected long deadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return AbstractScheduledEventExecutor.nanoTime() + SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.deadlineNanos();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long delayNanos(long j4) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return peekScheduledTask.delayNanos(j4);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            boolean inEventLoop = inEventLoop();
            addTask(runnable);
            if (!inEventLoop) {
                startThread();
                if (isShutdown()) {
                    boolean z3 = false;
                    try {
                        z3 = removeTask(runnable);
                    } catch (UnsupportedOperationException unused) {
                    }
                    if (z3) {
                        reject();
                    }
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
        return this.state >= 4;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.state == 5;
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
        boolean z3 = false;
        do {
            fetchFromScheduledTaskQueue = fetchFromScheduledTaskQueue();
            if (runAllTasksFrom(this.taskQueue)) {
                z3 = true;
                continue;
            }
        } while (!fetchFromScheduledTaskQueue);
        if (z3) {
            this.lastExecutionTime = ScheduledFutureTask.nanoTime();
        }
        afterRunningAllTasks();
        return z3;
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
        if (isShutdown()) {
            return;
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            int i4 = this.state;
            int i5 = 4;
            boolean z3 = true;
            if (!inEventLoop && i4 != 1 && i4 != 2 && i4 != 3) {
                z3 = false;
                i5 = i4;
            }
            if (STATE_UPDATER.compareAndSet(this, i4, i5)) {
                if (!ensureThreadStarted(i4) && z3) {
                    wakeup(inEventLoop);
                    return;
                }
                return;
            }
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j4, long j5, TimeUnit timeUnit) {
        if (j4 < 0) {
            throw new IllegalArgumentException("quietPeriod: " + j4 + " (expected >= 0)");
        } else if (j5 < j4) {
            throw new IllegalArgumentException("timeout: " + j5 + " (expected >= quietPeriod (" + j4 + "))");
        } else if (timeUnit != null) {
            if (isShuttingDown()) {
                return terminationFuture();
            }
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                int i4 = this.state;
                int i5 = 3;
                boolean z3 = true;
                if (!inEventLoop && i4 != 1 && i4 != 2) {
                    z3 = false;
                    i5 = i4;
                }
                if (STATE_UPDATER.compareAndSet(this, i4, i5)) {
                    this.gracefulShutdownQuietPeriod = timeUnit.toNanos(j4);
                    this.gracefulShutdownTimeout = timeUnit.toNanos(j5);
                    if (ensureThreadStarted(i4)) {
                        return this.terminationFuture;
                    }
                    if (z3) {
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
            return !a.a(PROPERTIES_UPDATER, this, null, defaultThreadProperties) ? this.threadProperties : defaultThreadProperties;
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
    public void wakeup(boolean z3) {
        if (!z3 || this.state == 3) {
            this.taskQueue.offer(WAKEUP_TASK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, ThreadFactory threadFactory, boolean z3, int i4, RejectedExecutionHandler rejectedExecutionHandler) {
        this(eventExecutorGroup, new ThreadPerTaskExecutor(threadFactory), z3, i4, rejectedExecutionHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Queue<Runnable> newTaskQueue(int i4) {
        return new LinkedBlockingQueue(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reject(Runnable runnable) {
        this.rejectedExecutionHandler.rejected(runnable, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z3) {
        this(eventExecutorGroup, executor, z3, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return super.invokeAll(collection, j4, timeUnit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return (T) super.invokeAny(collection, j4, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z3, int i4, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z3;
        int max = Math.max(16, i4);
        this.maxPendingTasks = max;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = newTaskQueue(max);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean runAllTasks(long j4) {
        long nanoTime;
        fetchFromScheduledTaskQueue();
        Runnable pollTask = pollTask();
        if (pollTask == null) {
            afterRunningAllTasks();
            return false;
        }
        long nanoTime2 = ScheduledFutureTask.nanoTime() + j4;
        long j5 = 0;
        while (true) {
            AbstractEventExecutor.safeExecute(pollTask);
            j5++;
            if ((63 & j5) == 0) {
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

    protected SingleThreadEventExecutor(EventExecutorGroup eventExecutorGroup, Executor executor, boolean z3, Queue<Runnable> queue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(eventExecutorGroup);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = z3;
        this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = (Queue) ObjectUtil.checkNotNull(queue, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedExecutionHandler, "rejectedHandler");
    }
}

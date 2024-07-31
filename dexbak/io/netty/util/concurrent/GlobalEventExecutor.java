package io.netty.util.concurrent;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class GlobalEventExecutor extends AbstractScheduledEventExecutor {
    final ScheduledFutureTask<Void> quietPeriodTask;
    private final AtomicBoolean started;
    final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    private final TaskRunner taskRunner;
    private final Future<?> terminationFuture;
    volatile Thread thread;
    final ThreadFactory threadFactory;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalEventExecutor.class);
    private static final long SCHEDULE_QUIET_PERIOD_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    public static final GlobalEventExecutor INSTANCE = new GlobalEventExecutor();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class TaskRunner implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        TaskRunner() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                Runnable takeTask = GlobalEventExecutor.this.takeTask();
                if (takeTask != null) {
                    try {
                        takeTask.run();
                    } catch (Throwable th) {
                        GlobalEventExecutor.logger.warn("Unexpected exception from the global event executor: ", th);
                    }
                    if (takeTask != GlobalEventExecutor.this.quietPeriodTask) {
                        continue;
                    }
                }
                GlobalEventExecutor globalEventExecutor = GlobalEventExecutor.this;
                Queue<ScheduledFutureTask<?>> queue = globalEventExecutor.scheduledTaskQueue;
                if (globalEventExecutor.taskQueue.isEmpty() && (queue == null || queue.size() == 1)) {
                    GlobalEventExecutor.this.started.compareAndSet(true, false);
                    if ((GlobalEventExecutor.this.taskQueue.isEmpty() && (queue == null || queue.size() == 1)) || !GlobalEventExecutor.this.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    private GlobalEventExecutor() {
        Callable callable = Executors.callable(new Runnable() { // from class: io.netty.util.concurrent.GlobalEventExecutor.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, null);
        long j = SCHEDULE_QUIET_PERIOD_INTERVAL;
        ScheduledFutureTask<Void> scheduledFutureTask = new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(j), -j);
        this.quietPeriodTask = scheduledFutureTask;
        this.threadFactory = new DefaultThreadFactory(DefaultThreadFactory.toPoolName(GlobalEventExecutor.class), false, 5, null);
        this.taskRunner = new TaskRunner();
        this.started = new AtomicBoolean();
        this.terminationFuture = new FailedFuture(this, new UnsupportedOperationException());
        scheduledTaskQueue().add(scheduledFutureTask);
    }

    private void addTask(Runnable runnable) {
        if (runnable != null) {
            this.taskQueue.add(runnable);
            return;
        }
        throw new NullPointerException("task");
    }

    private void fetchFromScheduledTaskQueue() {
        long nanoTime = AbstractScheduledEventExecutor.nanoTime();
        Runnable pollScheduledTask = pollScheduledTask(nanoTime);
        while (pollScheduledTask != null) {
            this.taskQueue.add(pollScheduledTask);
            pollScheduledTask = pollScheduledTask(nanoTime);
        }
    }

    private void startThread() {
        if (this.started.compareAndSet(false, true)) {
            Thread newThread = this.threadFactory.newThread(this.taskRunner);
            this.thread = newThread;
            newThread.start();
        }
    }

    public boolean awaitInactivity(long j, TimeUnit timeUnit) throws InterruptedException {
        if (timeUnit != null) {
            Thread thread = this.thread;
            if (thread != null) {
                thread.join(timeUnit.toMillis(j));
                return !thread.isAlive();
            }
            throw new IllegalStateException("thread was not started");
        }
        throw new NullPointerException("unit");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            addTask(runnable);
            if (inEventLoop()) {
                return;
            }
            startThread();
            return;
        }
        throw new NullPointerException("task");
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        return terminationFuture();
    }

    Runnable takeTask() {
        Runnable poll;
        BlockingQueue<Runnable> blockingQueue = this.taskQueue;
        do {
            ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
            if (peekScheduledTask == null) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            long delayNanos = peekScheduledTask.delayNanos();
            if (delayNanos > 0) {
                try {
                    poll = blockingQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused2) {
                    return null;
                }
            } else {
                poll = blockingQueue.poll();
            }
            if (poll == null) {
                fetchFromScheduledTaskQueue();
                poll = blockingQueue.poll();
                continue;
            }
        } while (poll == null);
        return poll;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }
}

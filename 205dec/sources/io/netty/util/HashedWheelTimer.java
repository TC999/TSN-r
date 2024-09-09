package io.netty.util;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class HashedWheelTimer implements Timer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INSTANCE_COUNT_LIMIT = 64;
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    private final Queue<HashedWheelTimeout> cancelledTimeouts;
    private final ResourceLeakTracker<HashedWheelTimer> leak;
    private final int mask;
    private final long maxPendingTimeouts;
    private final AtomicLong pendingTimeouts;
    private volatile long startTime;
    private final CountDownLatch startTimeInitialized;
    private final long tickDuration;
    private final Queue<HashedWheelTimeout> timeouts;
    private final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;
    static final InternalLogger logger = InternalLoggerFactory.getInstance(HashedWheelTimer.class);
    private static final AtomicInteger INSTANCE_COUNTER = new AtomicInteger();
    private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
    private static final long MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1);
    private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class HashedWheelBucket {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;

        private HashedWheelBucket() {
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            if (hashedWheelTimeout == null) {
                return null;
            }
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            if (hashedWheelTimeout2 == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = hashedWheelTimeout2;
                hashedWheelTimeout2.prev = null;
            }
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.bucket = null;
            return hashedWheelTimeout;
        }

        public void addTimeout(HashedWheelTimeout hashedWheelTimeout) {
            hashedWheelTimeout.bucket = this;
            if (this.head == null) {
                this.tail = hashedWheelTimeout;
                this.head = hashedWheelTimeout;
                return;
            }
            HashedWheelTimeout hashedWheelTimeout2 = this.tail;
            hashedWheelTimeout2.next = hashedWheelTimeout;
            hashedWheelTimeout.prev = hashedWheelTimeout2;
            this.tail = hashedWheelTimeout;
        }

        public void clearTimeouts(Set<Timeout> set) {
            while (true) {
                HashedWheelTimeout pollTimeout = pollTimeout();
                if (pollTimeout == null) {
                    return;
                }
                if (!pollTimeout.isExpired() && !pollTimeout.isCancelled()) {
                    set.add(pollTimeout);
                }
            }
        }

        public void expireTimeouts(long j4) {
            HashedWheelTimeout hashedWheelTimeout = this.head;
            while (hashedWheelTimeout != null) {
                HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
                if (hashedWheelTimeout.remainingRounds <= 0) {
                    hashedWheelTimeout2 = remove(hashedWheelTimeout);
                    if (hashedWheelTimeout.deadline <= j4) {
                        hashedWheelTimeout.expire();
                    } else {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", Long.valueOf(hashedWheelTimeout.deadline), Long.valueOf(j4)));
                    }
                } else if (hashedWheelTimeout.isCancelled()) {
                    hashedWheelTimeout = remove(hashedWheelTimeout);
                } else {
                    hashedWheelTimeout.remainingRounds--;
                }
                hashedWheelTimeout = hashedWheelTimeout2;
            }
        }

        public HashedWheelTimeout remove(HashedWheelTimeout hashedWheelTimeout) {
            HashedWheelTimeout hashedWheelTimeout2 = hashedWheelTimeout.next;
            HashedWheelTimeout hashedWheelTimeout3 = hashedWheelTimeout.prev;
            if (hashedWheelTimeout3 != null) {
                hashedWheelTimeout3.next = hashedWheelTimeout2;
            }
            HashedWheelTimeout hashedWheelTimeout4 = hashedWheelTimeout.next;
            if (hashedWheelTimeout4 != null) {
                hashedWheelTimeout4.prev = hashedWheelTimeout3;
            }
            if (hashedWheelTimeout == this.head) {
                if (hashedWheelTimeout == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = hashedWheelTimeout2;
                }
            } else if (hashedWheelTimeout == this.tail) {
                this.tail = hashedWheelTimeout.prev;
            }
            hashedWheelTimeout.prev = null;
            hashedWheelTimeout.next = null;
            hashedWheelTimeout.bucket = null;
            hashedWheelTimeout.timer.pendingTimeouts.decrementAndGet();
            return hashedWheelTimeout2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class HashedWheelTimeout implements Timeout {
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final int ST_INIT = 0;
        HashedWheelBucket bucket;
        private final long deadline;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        long remainingRounds;
        private volatile int state = 0;
        private final TimerTask task;
        private final HashedWheelTimer timer;

        HashedWheelTimeout(HashedWheelTimer hashedWheelTimer, TimerTask timerTask, long j4) {
            this.timer = hashedWheelTimer;
            this.task = timerTask;
            this.deadline = j4;
        }

        @Override // io.netty.util.Timeout
        public boolean cancel() {
            if (compareAndSetState(0, 1)) {
                this.timer.cancelledTimeouts.add(this);
                return true;
            }
            return false;
        }

        public boolean compareAndSetState(int i4, int i5) {
            return STATE_UPDATER.compareAndSet(this, i4, i5);
        }

        public void expire() {
            if (compareAndSetState(0, 2)) {
                try {
                    this.task.run(this);
                } catch (Throwable th) {
                    InternalLogger internalLogger = HashedWheelTimer.logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception was thrown by " + TimerTask.class.getSimpleName() + '.', th);
                    }
                }
            }
        }

        @Override // io.netty.util.Timeout
        public boolean isCancelled() {
            return state() == 1;
        }

        @Override // io.netty.util.Timeout
        public boolean isExpired() {
            return state() == 2;
        }

        void remove() {
            HashedWheelBucket hashedWheelBucket = this.bucket;
            if (hashedWheelBucket != null) {
                hashedWheelBucket.remove(this);
            } else {
                this.timer.pendingTimeouts.decrementAndGet();
            }
        }

        public int state() {
            return this.state;
        }

        @Override // io.netty.util.Timeout
        public TimerTask task() {
            return this.task;
        }

        @Override // io.netty.util.Timeout
        public Timer timer() {
            return this.timer;
        }

        public String toString() {
            long nanoTime = (this.deadline - System.nanoTime()) + this.timer.startTime;
            StringBuilder sb = new StringBuilder(192);
            sb.append(StringUtil.simpleClassName(this));
            sb.append('(');
            sb.append("deadline: ");
            if (nanoTime > 0) {
                sb.append(nanoTime);
                sb.append(" ns later");
            } else if (nanoTime < 0) {
                sb.append(-nanoTime);
                sb.append(" ns ago");
            } else {
                sb.append("now");
            }
            if (isCancelled()) {
                sb.append(", cancelled");
            }
            sb.append(", task: ");
            sb.append(task());
            sb.append(')');
            return sb.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class Worker implements Runnable {
        private long tick;
        private final Set<Timeout> unprocessedTimeouts;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        private void processCancelledTasks() {
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.cancelledTimeouts.poll();
                if (hashedWheelTimeout == null) {
                    return;
                }
                try {
                    hashedWheelTimeout.remove();
                } catch (Throwable th) {
                    if (HashedWheelTimer.logger.isWarnEnabled()) {
                        HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", th);
                    }
                }
            }
        }

        private void transferTimeoutsToBuckets() {
            HashedWheelTimeout hashedWheelTimeout;
            for (int i4 = 0; i4 < 100000 && (hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i4++) {
                if (hashedWheelTimeout.state() != 1) {
                    long j4 = hashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimeout.remainingRounds = (j4 - this.tick) / HashedWheelTimer.this.wheel.length;
                    HashedWheelTimer.this.wheel[(int) (Math.max(j4, this.tick) & HashedWheelTimer.this.mask)].addTimeout(hashedWheelTimeout);
                }
            }
        }

        private long waitForNextTick() {
            long j4 = HashedWheelTimer.this.tickDuration * (this.tick + 1);
            while (true) {
                long nanoTime = System.nanoTime() - HashedWheelTimer.this.startTime;
                long j5 = ((j4 - nanoTime) + 999999) / C.MICROS_PER_SECOND;
                if (j5 <= 0) {
                    if (nanoTime == Long.MIN_VALUE) {
                        return -9223372036854775807L;
                    }
                    return nanoTime;
                }
                if (PlatformDependent.isWindows()) {
                    j5 = (j5 / 10) * 10;
                }
                try {
                    Thread.sleep(j5);
                } catch (InterruptedException unused) {
                    if (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 2) {
                        return Long.MIN_VALUE;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            HashedWheelTimer.this.startTime = System.nanoTime();
            if (HashedWheelTimer.this.startTime == 0) {
                HashedWheelTimer.this.startTime = 1L;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long waitForNextTick = waitForNextTick();
                if (waitForNextTick > 0) {
                    int i4 = (int) (this.tick & HashedWheelTimer.this.mask);
                    processCancelledTasks();
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimer.this.wheel[i4];
                    transferTimeoutsToBuckets();
                    hashedWheelBucket.expireTimeouts(waitForNextTick);
                    this.tick++;
                }
            } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            for (HashedWheelBucket hashedWheelBucket2 : HashedWheelTimer.this.wheel) {
                hashedWheelBucket2.clearTimeouts(this.unprocessedTimeouts);
            }
            while (true) {
                HashedWheelTimeout hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll();
                if (hashedWheelTimeout == null) {
                    processCancelledTasks();
                    return;
                } else if (!hashedWheelTimeout.isCancelled()) {
                    this.unprocessedTimeouts.add(hashedWheelTimeout);
                }
            }
        }

        public Set<Timeout> unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    private static HashedWheelBucket[] createWheel(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i4);
        } else if (i4 <= 1073741824) {
            int normalizeTicksPerWheel = normalizeTicksPerWheel(i4);
            HashedWheelBucket[] hashedWheelBucketArr = new HashedWheelBucket[normalizeTicksPerWheel];
            for (int i5 = 0; i5 < normalizeTicksPerWheel; i5++) {
                hashedWheelBucketArr[i5] = new HashedWheelBucket();
            }
            return hashedWheelBucketArr;
        } else {
            throw new IllegalArgumentException("ticksPerWheel may not be greater than 2^30: " + i4);
        }
    }

    private static int normalizeTicksPerWheel(int i4) {
        int i5 = 1;
        while (i5 < i4) {
            i5 <<= 1;
        }
        return i5;
    }

    private static void reportTooManyInstances() {
        InternalLogger internalLogger = logger;
        if (internalLogger.isErrorEnabled()) {
            String simpleClassName = StringUtil.simpleClassName((Class<?>) HashedWheelTimer.class);
            internalLogger.error("You are creating too many " + simpleClassName + " instances. " + simpleClassName + " is a shared resource that must be reused across the JVM,so that only a few instances are created.");
        }
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                INSTANCE_COUNTER.decrementAndGet();
            }
        }
    }

    @Override // io.netty.util.Timer
    public Timeout newTimeout(TimerTask timerTask, long j4, TimeUnit timeUnit) {
        if (timerTask != null) {
            if (timeUnit != null) {
                long incrementAndGet = this.pendingTimeouts.incrementAndGet();
                long j5 = this.maxPendingTimeouts;
                if (j5 > 0 && incrementAndGet > j5) {
                    this.pendingTimeouts.decrementAndGet();
                    throw new RejectedExecutionException("Number of pending timeouts (" + incrementAndGet + ") is greater than or equal to maximum allowed pending timeouts (" + this.maxPendingTimeouts + ")");
                }
                start();
                long nanoTime = (System.nanoTime() + timeUnit.toNanos(j4)) - this.startTime;
                if (j4 > 0 && nanoTime < 0) {
                    nanoTime = Long.MAX_VALUE;
                }
                HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(this, timerTask, nanoTime);
                this.timeouts.add(hashedWheelTimeout);
                return hashedWheelTimeout;
            }
            throw new NullPointerException("unit");
        }
        throw new NullPointerException("task");
    }

    public long pendingTimeouts() {
        return this.pendingTimeouts.get();
    }

    public void start() {
        AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
        int i4 = atomicIntegerFieldUpdater.get(this);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new Error("Invalid WorkerState");
                }
                throw new IllegalStateException("cannot be started once stopped");
            }
        } else if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
            this.workerThread.start();
        }
        while (this.startTime == 0) {
            try {
                this.startTimeInitialized.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // io.netty.util.Timer
    public Set<Timeout> stop() {
        if (Thread.currentThread() != this.workerThread) {
            AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 1, 2)) {
                if (atomicIntegerFieldUpdater.getAndSet(this, 2) != 2) {
                }
                return Collections.emptySet();
            }
            boolean z3 = false;
            while (this.workerThread.isAlive()) {
                try {
                    this.workerThread.interrupt();
                    try {
                        this.workerThread.join(100L);
                    } catch (InterruptedException unused) {
                        z3 = true;
                    }
                } finally {
                    INSTANCE_COUNTER.decrementAndGet();
                    ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker = this.leak;
                    if (resourceLeakTracker != null) {
                        resourceLeakTracker.close(this);
                    }
                }
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
            INSTANCE_COUNTER.decrementAndGet();
            ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker2 = this.leak;
            if (resourceLeakTracker2 != null) {
                resourceLeakTracker2.close(this);
            }
            return this.worker.unprocessedTimeouts();
        }
        throw new IllegalStateException(HashedWheelTimer.class.getSimpleName() + ".stop() cannot be called from " + TimerTask.class.getSimpleName());
    }

    public HashedWheelTimer(long j4, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j4, timeUnit);
    }

    public HashedWheelTimer(long j4, TimeUnit timeUnit, int i4) {
        this(Executors.defaultThreadFactory(), j4, timeUnit, i4);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100L, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j4, TimeUnit timeUnit) {
        this(threadFactory, j4, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j4, TimeUnit timeUnit, int i4) {
        this(threadFactory, j4, timeUnit, i4, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j4, TimeUnit timeUnit, int i4, boolean z3) {
        this(threadFactory, j4, timeUnit, i4, z3, -1L);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j4, TimeUnit timeUnit, int i4, boolean z3, long j5) {
        ResourceLeakTracker<HashedWheelTimer> resourceLeakTracker = null;
        Worker worker = new Worker();
        this.worker = worker;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        this.pendingTimeouts = new AtomicLong(0L);
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + j4);
        } else if (i4 > 0) {
            HashedWheelBucket[] createWheel = createWheel(i4);
            this.wheel = createWheel;
            this.mask = createWheel.length - 1;
            long nanos = timeUnit.toNanos(j4);
            if (nanos < Long.MAX_VALUE / createWheel.length) {
                long j6 = MILLISECOND_NANOS;
                if (nanos < j6) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("Configured tickDuration %d smaller then %d, using 1ms.", Long.valueOf(j4), Long.valueOf(j6));
                    }
                    this.tickDuration = j6;
                } else {
                    this.tickDuration = nanos;
                }
                Thread newThread = threadFactory.newThread(worker);
                this.workerThread = newThread;
                this.leak = (z3 || !newThread.isDaemon()) ? leakDetector.track(this) : resourceLeakTracker;
                this.maxPendingTimeouts = j5;
                if (INSTANCE_COUNTER.incrementAndGet() <= 64 || !WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true)) {
                    return;
                }
                reportTooManyInstances();
                return;
            }
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", Long.valueOf(j4), Long.valueOf(Long.MAX_VALUE / createWheel.length)));
        } else {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i4);
        }
    }
}

package io.netty.util;

import com.alibaba.fastjson.asm.Opcodes;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class HashedWheelTimer implements Timer {
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    public static final int WORKER_STATE_STARTED = 1;
    private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER;
    private final Queue<HashedWheelTimeout> cancelledTimeouts;
    private final ResourceLeak leak;
    private final int mask;
    private volatile long startTime;
    private final CountDownLatch startTimeInitialized;
    private final long tickDuration;
    private final Queue<HashedWheelTimeout> timeouts;
    private final HashedWheelBucket[] wheel;
    private final Worker worker;
    private volatile int workerState;
    private final Thread workerThread;
    static final InternalLogger logger = InternalLoggerFactory.getInstance(HashedWheelTimer.class);
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1, Runtime.getRuntime().availableProcessors() * 4);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void expireTimeouts(long r9) {
            /*
                r8 = this;
                io.netty.util.HashedWheelTimer$HashedWheelTimeout r0 = r8.head
            L2:
                if (r0 == 0) goto L51
                long r1 = r0.remainingRounds
                r3 = 0
                r5 = 0
                r6 = 1
                int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r7 > 0) goto L39
                long r1 = io.netty.util.HashedWheelTimer.HashedWheelTimeout.access$800(r0)
                int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
                if (r3 > 0) goto L1a
                r0.expire()
                goto L3f
            L1a:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                long r3 = io.netty.util.HashedWheelTimer.HashedWheelTimeout.access$800(r0)
                java.lang.Long r0 = java.lang.Long.valueOf(r3)
                r2[r5] = r0
                java.lang.Long r9 = java.lang.Long.valueOf(r9)
                r2[r6] = r9
                java.lang.String r9 = "timeout.deadline (%d) > deadline (%d)"
                java.lang.String r9 = java.lang.String.format(r9, r2)
                r1.<init>(r9)
                throw r1
            L39:
                boolean r1 = r0.isCancelled()
                if (r1 == 0) goto L41
            L3f:
                r5 = 1
                goto L48
            L41:
                long r1 = r0.remainingRounds
                r3 = 1
                long r1 = r1 - r3
                r0.remainingRounds = r1
            L48:
                io.netty.util.HashedWheelTimer$HashedWheelTimeout r1 = r0.next
                if (r5 == 0) goto L4f
                r8.remove(r0)
            L4f:
                r0 = r1
                goto L2
            L51:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.HashedWheelTimer.HashedWheelBucket.expireTimeouts(long):void");
        }

        public void remove(HashedWheelTimeout hashedWheelTimeout) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class HashedWheelTimeout implements Timeout {
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER;
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

        static {
            AtomicIntegerFieldUpdater<HashedWheelTimeout> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(HashedWheelTimeout.class, "state");
            if (newAtomicIntegerFieldUpdater == null) {
                newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, "state");
            }
            STATE_UPDATER = newAtomicIntegerFieldUpdater;
        }

        HashedWheelTimeout(HashedWheelTimer hashedWheelTimer, TimerTask timerTask, long j) {
            this.timer = hashedWheelTimer;
            this.task = timerTask;
            this.deadline = j;
        }

        @Override // io.netty.util.Timeout
        public boolean cancel() {
            if (compareAndSetState(0, 1)) {
                this.timer.cancelledTimeouts.add(this);
                return true;
            }
            return false;
        }

        public boolean compareAndSetState(int i, int i2) {
            return STATE_UPDATER.compareAndSet(this, i, i2);
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
            StringBuilder sb = new StringBuilder((int) Opcodes.CHECKCAST);
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

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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
            for (int i = 0; i < 100000 && (hashedWheelTimeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i++) {
                if (hashedWheelTimeout.state() != 1) {
                    long j = hashedWheelTimeout.deadline / HashedWheelTimer.this.tickDuration;
                    hashedWheelTimeout.remainingRounds = (j - this.tick) / HashedWheelTimer.this.wheel.length;
                    HashedWheelTimer.this.wheel[(int) (Math.max(j, this.tick) & HashedWheelTimer.this.mask)].addTimeout(hashedWheelTimeout);
                }
            }
        }

        private long waitForNextTick() {
            long j = HashedWheelTimer.this.tickDuration * (this.tick + 1);
            while (true) {
                long nanoTime = System.nanoTime() - HashedWheelTimer.this.startTime;
                long j2 = ((j - nanoTime) + 999999) / 1000000;
                if (j2 <= 0) {
                    if (nanoTime == Long.MIN_VALUE) {
                        return -9223372036854775807L;
                    }
                    return nanoTime;
                }
                if (PlatformDependent.isWindows()) {
                    j2 = (j2 / 10) * 10;
                }
                try {
                    Thread.sleep(j2);
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
                    int i = (int) (this.tick & HashedWheelTimer.this.mask);
                    processCancelledTasks();
                    HashedWheelBucket hashedWheelBucket = HashedWheelTimer.this.wheel[i];
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

    static {
        AtomicIntegerFieldUpdater<HashedWheelTimer> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(HashedWheelTimer.class, "workerState");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");
        }
        WORKER_STATE_UPDATER = newAtomicIntegerFieldUpdater;
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    private static HashedWheelBucket[] createWheel(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i);
        } else if (i <= 1073741824) {
            int normalizeTicksPerWheel = normalizeTicksPerWheel(i);
            HashedWheelBucket[] hashedWheelBucketArr = new HashedWheelBucket[normalizeTicksPerWheel];
            for (int i2 = 0; i2 < normalizeTicksPerWheel; i2++) {
                hashedWheelBucketArr[i2] = new HashedWheelBucket();
            }
            return hashedWheelBucketArr;
        } else {
            throw new IllegalArgumentException("ticksPerWheel may not be greater than 2^30: " + i);
        }
    }

    private static int normalizeTicksPerWheel(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        return i2;
    }

    @Override // io.netty.util.Timer
    public Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit) {
        if (timerTask != null) {
            if (timeUnit != null) {
                start();
                HashedWheelTimeout hashedWheelTimeout = new HashedWheelTimeout(this, timerTask, (System.nanoTime() + timeUnit.toNanos(j)) - this.startTime);
                this.timeouts.add(hashedWheelTimeout);
                return hashedWheelTimeout;
            }
            throw new NullPointerException("unit");
        }
        throw new NullPointerException("task");
    }

    public void start() {
        AtomicIntegerFieldUpdater<HashedWheelTimer> atomicIntegerFieldUpdater = WORKER_STATE_UPDATER;
        int i = atomicIntegerFieldUpdater.get(this);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
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
                atomicIntegerFieldUpdater.set(this, 2);
                ResourceLeak resourceLeak = this.leak;
                if (resourceLeak != null) {
                    resourceLeak.close();
                }
                return Collections.emptySet();
            }
            boolean z = false;
            while (this.workerThread.isAlive()) {
                this.workerThread.interrupt();
                try {
                    this.workerThread.join(100L);
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            ResourceLeak resourceLeak2 = this.leak;
            if (resourceLeak2 != null) {
                resourceLeak2.close();
            }
            return this.worker.unprocessedTimeouts();
        }
        throw new IllegalStateException(HashedWheelTimer.class.getSimpleName() + ".stop() cannot be called from " + TimerTask.class.getSimpleName());
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit) {
        this(Executors.defaultThreadFactory(), j, timeUnit);
    }

    public HashedWheelTimer(long j, TimeUnit timeUnit, int i) {
        this(Executors.defaultThreadFactory(), j, timeUnit, i);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100L, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
        this(threadFactory, j, timeUnit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i) {
        this(threadFactory, j, timeUnit, i, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long j, TimeUnit timeUnit, int i, boolean z) {
        ResourceLeak resourceLeak = null;
        Worker worker = new Worker();
        this.worker = worker;
        this.workerState = 0;
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("tickDuration must be greater than 0: " + j);
        } else if (i > 0) {
            HashedWheelBucket[] createWheel = createWheel(i);
            this.wheel = createWheel;
            this.mask = createWheel.length - 1;
            long nanos = timeUnit.toNanos(j);
            this.tickDuration = nanos;
            if (nanos < Long.MAX_VALUE / createWheel.length) {
                Thread newThread = threadFactory.newThread(worker);
                this.workerThread = newThread;
                this.leak = (z || !newThread.isDaemon()) ? leakDetector.open(this) : resourceLeak;
                return;
            }
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", Long.valueOf(j), Long.valueOf(Long.MAX_VALUE / createWheel.length)));
        } else {
            throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + i);
        }
    }
}

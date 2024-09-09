package io.netty.handler.traffic;

import com.bykv.vk.component.ttvideo.player.C;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class TrafficCounter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(TrafficCounter.class);
    final ScheduledExecutorService executor;
    private long lastCumulativeTime;
    private volatile long lastReadBytes;
    private long lastReadThroughput;
    private volatile long lastReadingTime;
    private long lastWriteThroughput;
    private volatile long lastWritingTime;
    private volatile long lastWrittenBytes;
    Runnable monitor;
    volatile boolean monitorActive;
    final String name;
    private long readingTime;
    private long realWriteThroughput;
    volatile ScheduledFuture<?> scheduledFuture;
    final AbstractTrafficShapingHandler trafficShapingHandler;
    private long writingTime;
    private final AtomicLong currentWrittenBytes = new AtomicLong();
    private final AtomicLong currentReadBytes = new AtomicLong();
    private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
    private final AtomicLong cumulativeReadBytes = new AtomicLong();
    final AtomicLong lastTime = new AtomicLong();
    private final AtomicLong realWrittenBytes = new AtomicLong();
    final AtomicLong checkInterval = new AtomicLong(1000);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class TrafficMonitoringTask implements Runnable {
        private TrafficMonitoringTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TrafficCounter.this.monitorActive) {
                TrafficCounter.this.resetAccounting(TrafficCounter.milliSecondFromNano());
                TrafficCounter trafficCounter = TrafficCounter.this;
                AbstractTrafficShapingHandler abstractTrafficShapingHandler = trafficCounter.trafficShapingHandler;
                if (abstractTrafficShapingHandler != null) {
                    abstractTrafficShapingHandler.doAccounting(trafficCounter);
                }
            }
        }
    }

    public TrafficCounter(ScheduledExecutorService scheduledExecutorService, String str, long j4) {
        if (str != null) {
            this.trafficShapingHandler = null;
            this.executor = scheduledExecutorService;
            this.name = str;
            init(j4);
            return;
        }
        throw new NullPointerException("name");
    }

    private void init(long j4) {
        this.lastCumulativeTime = System.currentTimeMillis();
        long milliSecondFromNano = milliSecondFromNano();
        this.writingTime = milliSecondFromNano;
        this.readingTime = milliSecondFromNano;
        this.lastWritingTime = milliSecondFromNano;
        this.lastReadingTime = this.writingTime;
        configure(j4);
    }

    public static long milliSecondFromNano() {
        return System.nanoTime() / C.MICROS_PER_SECOND;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bytesRealWriteFlowControl(long j4) {
        this.realWrittenBytes.addAndGet(j4);
    }

    void bytesRecvFlowControl(long j4) {
        this.currentReadBytes.addAndGet(j4);
        this.cumulativeReadBytes.addAndGet(j4);
    }

    void bytesWriteFlowControl(long j4) {
        this.currentWrittenBytes.addAndGet(j4);
        this.cumulativeWrittenBytes.addAndGet(j4);
    }

    public long checkInterval() {
        return this.checkInterval.get();
    }

    public void configure(long j4) {
        long j5 = (j4 / 10) * 10;
        if (this.checkInterval.getAndSet(j5) != j5) {
            if (j5 <= 0) {
                stop();
                this.lastTime.set(milliSecondFromNano());
                return;
            }
            stop();
            start();
        }
    }

    public long cumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public long cumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long currentReadBytes() {
        return this.currentReadBytes.get();
    }

    public long currentWrittenBytes() {
        return this.currentWrittenBytes.get();
    }

    public long getRealWriteThroughput() {
        return this.realWriteThroughput;
    }

    public AtomicLong getRealWrittenBytes() {
        return this.realWrittenBytes;
    }

    public long lastCumulativeTime() {
        return this.lastCumulativeTime;
    }

    public long lastReadBytes() {
        return this.lastReadBytes;
    }

    public long lastReadThroughput() {
        return this.lastReadThroughput;
    }

    public long lastTime() {
        return this.lastTime.get();
    }

    public long lastWriteThroughput() {
        return this.lastWriteThroughput;
    }

    public long lastWrittenBytes() {
        return this.lastWrittenBytes;
    }

    public String name() {
        return this.name;
    }

    @Deprecated
    public long readTimeToWait(long j4, long j5, long j6) {
        return readTimeToWait(j4, j5, j6, milliSecondFromNano());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void resetAccounting(long j4) {
        long andSet = j4 - this.lastTime.getAndSet(j4);
        if (andSet == 0) {
            return;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled() && andSet > (checkInterval() << 1)) {
            internalLogger.debug("Acct schedule not ok: " + andSet + " > 2*" + checkInterval() + " from " + this.name);
        }
        this.lastReadBytes = this.currentReadBytes.getAndSet(0L);
        this.lastWrittenBytes = this.currentWrittenBytes.getAndSet(0L);
        this.lastReadThroughput = (this.lastReadBytes * 1000) / andSet;
        this.lastWriteThroughput = (this.lastWrittenBytes * 1000) / andSet;
        this.realWriteThroughput = (this.realWrittenBytes.getAndSet(0L) * 1000) / andSet;
        this.lastWritingTime = Math.max(this.lastWritingTime, this.writingTime);
        this.lastReadingTime = Math.max(this.lastReadingTime, this.readingTime);
    }

    public void resetCumulativeTime() {
        this.lastCumulativeTime = System.currentTimeMillis();
        this.cumulativeReadBytes.set(0L);
        this.cumulativeWrittenBytes.set(0L);
    }

    public synchronized void start() {
        if (this.monitorActive) {
            return;
        }
        this.lastTime.set(milliSecondFromNano());
        long j4 = this.checkInterval.get();
        if (j4 > 0 && this.executor != null) {
            this.monitorActive = true;
            TrafficMonitoringTask trafficMonitoringTask = new TrafficMonitoringTask();
            this.monitor = trafficMonitoringTask;
            this.scheduledFuture = this.executor.scheduleAtFixedRate(trafficMonitoringTask, 0L, j4, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void stop() {
        if (this.monitorActive) {
            this.monitorActive = false;
            resetAccounting(milliSecondFromNano());
            AbstractTrafficShapingHandler abstractTrafficShapingHandler = this.trafficShapingHandler;
            if (abstractTrafficShapingHandler != null) {
                abstractTrafficShapingHandler.doAccounting(this);
            }
            if (this.scheduledFuture != null) {
                this.scheduledFuture.cancel(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(165);
        sb.append("Monitor ");
        sb.append(this.name);
        sb.append(" Current Speed Read: ");
        sb.append(this.lastReadThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Asked Write: ");
        sb.append(this.lastWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Real Write: ");
        sb.append(this.realWriteThroughput >> 10);
        sb.append(" KB/s, ");
        sb.append("Current Read: ");
        sb.append(this.currentReadBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current asked Write: ");
        sb.append(this.currentWrittenBytes.get() >> 10);
        sb.append(" KB, ");
        sb.append("Current real Write: ");
        sb.append(this.realWrittenBytes.get() >> 10);
        sb.append(" KB");
        return sb.toString();
    }

    @Deprecated
    public long writeTimeToWait(long j4, long j5, long j6) {
        return writeTimeToWait(j4, j5, j6, milliSecondFromNano());
    }

    public long readTimeToWait(long j4, long j5, long j6, long j7) {
        bytesRecvFlowControl(j4);
        if (j4 == 0 || j5 == 0) {
            return 0L;
        }
        long j8 = this.lastTime.get();
        long j9 = this.currentReadBytes.get();
        long j10 = this.readingTime;
        long j11 = this.lastReadBytes;
        long j12 = j7 - j8;
        long max = Math.max(this.lastReadingTime - j8, 0L);
        if (j12 > 10) {
            long j13 = (((1000 * j9) / j5) - j12) + max;
            if (j13 > 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Time: " + j13 + ':' + j9 + ':' + j12 + ':' + max);
                }
                if (j13 > j6 && (j7 + j13) - j10 > j6) {
                    j13 = j6;
                }
                this.readingTime = Math.max(j10, j7 + j13);
                return j13;
            }
            this.readingTime = Math.max(j10, j7);
            return 0L;
        }
        long j14 = j9 + j11;
        long j15 = j12 + this.checkInterval.get();
        long j16 = (((1000 * j14) / j5) - j15) + max;
        if (j16 > 10) {
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("Time: " + j16 + ':' + j14 + ':' + j15 + ':' + max);
            }
            if (j16 > j6 && (j7 + j16) - j10 > j6) {
                j16 = j6;
            }
            this.readingTime = Math.max(j10, j7 + j16);
            return j16;
        }
        this.readingTime = Math.max(j10, j7);
        return 0L;
    }

    public long writeTimeToWait(long j4, long j5, long j6, long j7) {
        bytesWriteFlowControl(j4);
        if (j4 == 0 || j5 == 0) {
            return 0L;
        }
        long j8 = this.lastTime.get();
        long j9 = this.currentWrittenBytes.get();
        long j10 = this.lastWrittenBytes;
        long j11 = this.writingTime;
        long max = Math.max(this.lastWritingTime - j8, 0L);
        long j12 = j7 - j8;
        if (j12 > 10) {
            long j13 = (((1000 * j9) / j5) - j12) + max;
            if (j13 > 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Time: " + j13 + ':' + j9 + ':' + j12 + ':' + max);
                }
                if (j13 > j6 && (j7 + j13) - j11 > j6) {
                    j13 = j6;
                }
                this.writingTime = Math.max(j11, j7 + j13);
                return j13;
            }
            this.writingTime = Math.max(j11, j7);
            return 0L;
        }
        long j14 = j9 + j10;
        long j15 = j12 + this.checkInterval.get();
        long j16 = (((1000 * j14) / j5) - j15) + max;
        if (j16 > 10) {
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("Time: " + j16 + ':' + j14 + ':' + j15 + ':' + max);
            }
            if (j16 > j6 && (j7 + j16) - j11 > j6) {
                j16 = j6;
            }
            this.writingTime = Math.max(j11, j7 + j16);
            return j16;
        }
        this.writingTime = Math.max(j11, j7);
        return 0L;
    }

    public TrafficCounter(AbstractTrafficShapingHandler abstractTrafficShapingHandler, ScheduledExecutorService scheduledExecutorService, String str, long j4) {
        if (abstractTrafficShapingHandler == null) {
            throw new IllegalArgumentException("trafficShapingHandler");
        }
        if (str != null) {
            this.trafficShapingHandler = abstractTrafficShapingHandler;
            this.executor = scheduledExecutorService;
            this.name = str;
            init(j4);
            return;
        }
        throw new NullPointerException("name");
    }
}

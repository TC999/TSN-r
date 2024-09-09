package io.netty.handler.traffic;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import io.netty.util.Attribute;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class GlobalChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private static final float DEFAULT_ACCELERATION = -0.1f;
    private static final float DEFAULT_DEVIATION = 0.1f;
    private static final float DEFAULT_SLOWDOWN = 0.4f;
    private static final float MAX_DEVIATION = 0.4f;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalChannelTrafficShapingHandler.class);
    private volatile float accelerationFactor;
    final ConcurrentMap<Integer, PerChannel> channelQueues;
    private final AtomicLong cumulativeReadBytes;
    private final AtomicLong cumulativeWrittenBytes;
    private volatile float maxDeviation;
    volatile long maxGlobalWriteSize;
    private final AtomicLong queuesSize;
    private volatile long readChannelLimit;
    private volatile boolean readDeviationActive;
    private volatile float slowDownFactor;
    private volatile long writeChannelLimit;
    private volatile boolean writeDeviationActive;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class PerChannel {
        TrafficCounter channelTrafficCounter;
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        PerChannel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final long size;
        final Object toSend;

        private ToSend(long j4, Object obj, long j5, ChannelPromise channelPromise) {
            this.relativeTimeAction = j4;
            this.toSend = obj;
            this.size = j5;
            this.promise = channelPromise;
        }
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5, long j6, long j7, long j8, long j9) {
        super(j4, j5, j8, j9);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
        this.writeChannelLimit = j6;
        this.readChannelLimit = j7;
    }

    private long computeBalancedWait(float f4, float f5, long j4) {
        float f6;
        if (f5 == 0.0f) {
            return j4;
        }
        float f7 = f4 / f5;
        if (f7 > this.maxDeviation) {
            if (f7 < 1.0f - this.maxDeviation) {
                return j4;
            }
            f6 = this.slowDownFactor;
            if (j4 < 10) {
                j4 = 10;
            }
        } else {
            f6 = this.accelerationFactor;
        }
        return ((float) j4) * f6;
    }

    private void computeDeviationCumulativeBytes() {
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        long j6 = 0;
        long j7 = Long.MAX_VALUE;
        for (PerChannel perChannel : this.channelQueues.values()) {
            long cumulativeWrittenBytes = perChannel.channelTrafficCounter.cumulativeWrittenBytes();
            if (j5 < cumulativeWrittenBytes) {
                j5 = cumulativeWrittenBytes;
            }
            if (j4 > cumulativeWrittenBytes) {
                j4 = cumulativeWrittenBytes;
            }
            long cumulativeReadBytes = perChannel.channelTrafficCounter.cumulativeReadBytes();
            if (j6 < cumulativeReadBytes) {
                j6 = cumulativeReadBytes;
            }
            if (j7 > cumulativeReadBytes) {
                j7 = cumulativeReadBytes;
            }
        }
        boolean z3 = false;
        boolean z4 = this.channelQueues.size() > 1;
        this.readDeviationActive = z4 && j7 < j6 / 2;
        if (z4 && j4 < j5 / 2) {
            z3 = true;
        }
        this.writeDeviationActive = z3;
        this.cumulativeWrittenBytes.set(j5);
        this.cumulativeReadBytes.set(j6);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer valueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(valueOf);
        if (perChannel == null) {
            PerChannel perChannel2 = new PerChannel();
            perChannel2.messagesQueue = new ArrayDeque<>();
            perChannel2.channelTrafficCounter = new TrafficCounter(this, null, "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
            perChannel2.queueSize = 0L;
            long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
            perChannel2.lastReadTimestamp = milliSecondFromNano;
            perChannel2.lastWriteTimestamp = milliSecondFromNano;
            this.channelQueues.put(valueOf, perChannel2);
            return perChannel2;
        }
        return perChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, PerChannel perChannel, long j4) {
        synchronized (perChannel) {
            ToSend pollFirst = perChannel.messagesQueue.pollFirst();
            while (true) {
                if (pollFirst != null) {
                    if (pollFirst.relativeTimeAction <= j4) {
                        long j5 = pollFirst.size;
                        this.trafficCounter.bytesRealWriteFlowControl(j5);
                        perChannel.channelTrafficCounter.bytesRealWriteFlowControl(j5);
                        perChannel.queueSize -= j5;
                        this.queuesSize.addAndGet(-j5);
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        perChannel.lastWriteTimestamp = j4;
                        pollFirst = perChannel.messagesQueue.pollFirst();
                    } else {
                        perChannel.messagesQueue.addFirst(pollFirst);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (perChannel.messagesQueue.isEmpty()) {
                releaseWriteSuspended(channelHandlerContext);
            }
        }
        channelHandlerContext.flush();
    }

    public float accelerationFactor() {
        return this.accelerationFactor;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        long j4;
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long readTimeToWait = this.trafficCounter.readTimeToWait(calculateSize, getReadLimit(), this.maxTime, milliSecondFromNano);
            PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
            if (perChannel != null) {
                long readTimeToWait2 = perChannel.channelTrafficCounter.readTimeToWait(calculateSize, this.readChannelLimit, this.maxTime, milliSecondFromNano);
                if (this.readDeviationActive) {
                    long cumulativeReadBytes = perChannel.channelTrafficCounter.cumulativeReadBytes();
                    long j5 = this.cumulativeReadBytes.get();
                    r2 = cumulativeReadBytes > 0 ? cumulativeReadBytes : 0L;
                    if (j5 < r2) {
                        j5 = r2;
                    }
                    r2 = computeBalancedWait((float) r2, (float) j5, readTimeToWait2);
                } else {
                    r2 = readTimeToWait2;
                }
            }
            if (r2 < readTimeToWait) {
                r2 = readTimeToWait;
            }
            j4 = milliSecondFromNano;
            long checkWaitReadTime = checkWaitReadTime(channelHandlerContext, r2, milliSecondFromNano);
            if (checkWaitReadTime >= 10) {
                Channel channel = channelHandlerContext.channel();
                ChannelConfig config = channel.config();
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Read Suspend: " + checkWaitReadTime + ':' + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext));
                }
                if (config.isAutoRead() && AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext)) {
                    config.setAutoRead(false);
                    channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(Boolean.TRUE);
                    Attribute attr = channel.attr(AbstractTrafficShapingHandler.REOPEN_TASK);
                    Runnable runnable = (Runnable) attr.get();
                    if (runnable == null) {
                        runnable = new AbstractTrafficShapingHandler.ReopenReadTimerTask(channelHandlerContext);
                        attr.set(runnable);
                    }
                    channelHandlerContext.executor().schedule(runnable, checkWaitReadTime, TimeUnit.MILLISECONDS);
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Suspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext) + " will reopened at: " + checkWaitReadTime);
                    }
                }
            }
        } else {
            j4 = milliSecondFromNano;
        }
        informReadOperation(channelHandlerContext, j4);
        channelHandlerContext.fireChannelRead(obj);
    }

    public Collection<TrafficCounter> channelTrafficCounters() {
        return new AbstractCollection<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<TrafficCounter> iterator() {
                return new Iterator<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1.1
                    final Iterator<PerChannel> iter;

                    {
                        this.iter = GlobalChannelTrafficShapingHandler.this.channelQueues.values().iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public TrafficCounter next() {
                        return this.iter.next().channelTrafficCounter;
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return GlobalChannelTrafficShapingHandler.this.channelQueues.size();
            }
        };
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j4, long j5) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        return (perChannel == null || j4 <= this.maxTime || (j5 + j4) - perChannel.lastReadTimestamp <= this.maxTime) ? j4 : this.maxTime;
    }

    public void configureChannel(long j4, long j5) {
        this.writeChannelLimit = j4;
        this.readChannelLimit = j5;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        setMaxDeviation(0.1f, 0.4f, -0.1f);
        if (scheduledExecutorService != null) {
            GlobalChannelTrafficCounter globalChannelTrafficCounter = new GlobalChannelTrafficCounter(this, scheduledExecutorService, "GlobalChannelTC", this.checkInterval);
            setTrafficCounter(globalChannelTrafficCounter);
            globalChannelTrafficCounter.start();
            return;
        }
        throw new IllegalArgumentException("Executor must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void doAccounting(TrafficCounter trafficCounter) {
        computeDeviationCumulativeBytes();
        super.doAccounting(trafficCounter);
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public long getReadChannelLimit() {
        return this.readChannelLimit;
    }

    public long getWriteChannelLimit() {
        return this.writeChannelLimit;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        this.trafficCounter.resetCumulativeTime();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.resetCumulativeTime();
        Channel channel = channelHandlerContext.channel();
        PerChannel remove = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (remove != null) {
            synchronized (remove) {
                if (channel.isActive()) {
                    Iterator<ToSend> it = remove.messagesQueue.iterator();
                    while (it.hasNext()) {
                        ToSend next = it.next();
                        long calculateSize = calculateSize(next.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        remove.channelTrafficCounter.bytesRealWriteFlowControl(calculateSize);
                        remove.queueSize -= calculateSize;
                        this.queuesSize.addAndGet(-calculateSize);
                        channelHandlerContext.write(next.toSend, next.promise);
                    }
                } else {
                    this.queuesSize.addAndGet(-remove.queueSize);
                    Iterator<ToSend> it2 = remove.messagesQueue.iterator();
                    while (it2.hasNext()) {
                        Object obj = it2.next().toSend;
                        if (obj instanceof ByteBuf) {
                            ((ByteBuf) obj).release();
                        }
                    }
                }
                remove.messagesQueue.clear();
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void informReadOperation(ChannelHandlerContext channelHandlerContext, long j4) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j4;
        }
    }

    public float maxDeviation() {
        return this.maxDeviation;
    }

    protected long maximumCumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    protected long maximumCumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxDeviation(float f4, float f5, float f6) {
        if (f4 > 0.4f) {
            throw new IllegalArgumentException("maxDeviation must be <= 0.4");
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("slowDownFactor must be >= 0");
        }
        if (f6 <= 0.0f) {
            this.maxDeviation = f4;
            this.accelerationFactor = f6 + 1.0f;
            this.slowDownFactor = f5 + 1.0f;
            return;
        }
        throw new IllegalArgumentException("accelerationFactor must be <= 0");
    }

    public void setMaxGlobalWriteSize(long j4) {
        if (j4 > 0) {
            this.maxGlobalWriteSize = j4;
            return;
        }
        throw new IllegalArgumentException("maxGlobalWriteSize must be positive");
    }

    public void setReadChannelLimit(long j4) {
        this.readChannelLimit = j4;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    public void setWriteChannelLimit(long j4) {
        this.writeChannelLimit = j4;
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(milliSecondFromNano);
        }
    }

    public float slowDownFactor() {
        return this.slowDownFactor;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j4, long j5, long j6, ChannelPromise channelPromise) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel == null) {
            perChannel = getOrSetPerChannel(channelHandlerContext);
        }
        final PerChannel perChannel2 = perChannel;
        synchronized (perChannel2) {
            if (j5 == 0) {
                if (perChannel2.messagesQueue.isEmpty()) {
                    this.trafficCounter.bytesRealWriteFlowControl(j4);
                    perChannel2.channelTrafficCounter.bytesRealWriteFlowControl(j4);
                    channelHandlerContext.write(obj, channelPromise);
                    perChannel2.lastWriteTimestamp = j6;
                    return;
                }
            }
            long j7 = (j5 <= this.maxTime || (j6 + j5) - perChannel2.lastWriteTimestamp <= this.maxTime) ? j5 : this.maxTime;
            ToSend toSend = new ToSend(j7 + j6, obj, j4, channelPromise);
            perChannel2.messagesQueue.addLast(toSend);
            perChannel2.queueSize += j4;
            this.queuesSize.addAndGet(j4);
            checkWriteSuspend(channelHandlerContext, j7, perChannel2.queueSize);
            boolean z3 = this.queuesSize.get() > this.maxGlobalWriteSize;
            if (z3) {
                setUserDefinedWritability(channelHandlerContext, false);
            }
            final long j8 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    GlobalChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel2, j8);
                }
            }, j7, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public String toString() {
        StringBuilder sb = new StringBuilder((int) MediaPlayer.MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO);
        sb.append(super.toString());
        sb.append(" Write Channel Limit: ");
        sb.append(this.writeChannelLimit);
        sb.append(" Read Channel Limit: ");
        sb.append(this.readChannelLimit);
        return sb.toString();
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected int userDefinedWritabilityIndex() {
        return 3;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        long calculateSize = calculateSize(obj);
        long milliSecondFromNano = TrafficCounter.milliSecondFromNano();
        if (calculateSize > 0) {
            long writeTimeToWait = this.trafficCounter.writeTimeToWait(calculateSize, getWriteLimit(), this.maxTime, milliSecondFromNano);
            PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
            if (perChannel != null) {
                long writeTimeToWait2 = perChannel.channelTrafficCounter.writeTimeToWait(calculateSize, this.writeChannelLimit, this.maxTime, milliSecondFromNano);
                if (this.writeDeviationActive) {
                    long cumulativeWrittenBytes = perChannel.channelTrafficCounter.cumulativeWrittenBytes();
                    long j4 = this.cumulativeWrittenBytes.get();
                    r0 = cumulativeWrittenBytes > 0 ? cumulativeWrittenBytes : 0L;
                    r0 = computeBalancedWait((float) r0, (float) (j4 < r0 ? r0 : j4), writeTimeToWait2);
                } else {
                    r0 = writeTimeToWait2;
                }
            }
            if (r0 >= writeTimeToWait) {
                writeTimeToWait = r0;
            }
            if (writeTimeToWait >= 10) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Write suspend: " + writeTimeToWait + ':' + channelHandlerContext.channel().config().isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(channelHandlerContext));
                }
                submitWrite(channelHandlerContext, obj, calculateSize, writeTimeToWait, milliSecondFromNano, channelPromise);
                return;
            }
        }
        submitWrite(channelHandlerContext, obj, calculateSize, 0L, milliSecondFromNano, channelPromise);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5, long j6, long j7, long j8) {
        super(j4, j5, j8);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        this.writeChannelLimit = j6;
        this.readChannelLimit = j7;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5, long j6, long j7) {
        super(j4, j5);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        this.writeChannelLimit = j6;
        this.readChannelLimit = j7;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4) {
        super(j4);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.cumulativeWrittenBytes = new AtomicLong();
        this.cumulativeReadBytes = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }
}

package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayDeque;
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
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues;
    long maxGlobalWriteSize;
    private final AtomicLong queuesSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class PerChannel {
        long lastReadTimestamp;
        long lastWriteTimestamp;
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;

        private PerChannel() {
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

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5, long j6, long j7) {
        super(j4, j5, j6, j7);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext channelHandlerContext) {
        Integer valueOf = Integer.valueOf(channelHandlerContext.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(valueOf);
        if (perChannel == null) {
            PerChannel perChannel2 = new PerChannel();
            perChannel2.messagesQueue = new ArrayDeque<>();
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

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    long checkWaitReadTime(ChannelHandlerContext channelHandlerContext, long j4, long j5) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        return (perChannel == null || j4 <= this.maxTime || (j5 + j4) - perChannel.lastReadTimestamp <= this.maxTime) ? j4 : this.maxTime;
    }

    void createGlobalTrafficCounter(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            TrafficCounter trafficCounter = new TrafficCounter(this, scheduledExecutorService, "GlobalTC", this.checkInterval);
            setTrafficCounter(trafficCounter);
            trafficCounter.start();
            return;
        }
        throw new NullPointerException("executor");
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        getOrSetPerChannel(channelHandlerContext);
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
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
    void informReadOperation(ChannelHandlerContext channelHandlerContext, long j4) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = j4;
        }
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    public void setMaxGlobalWriteSize(long j4) {
        this.maxGlobalWriteSize = j4;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j4, long j5, long j6, ChannelPromise channelPromise) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(channelHandlerContext.channel().hashCode()));
        if (perChannel == null) {
            perChannel = getOrSetPerChannel(channelHandlerContext);
        }
        final PerChannel perChannel2 = perChannel;
        synchronized (perChannel2) {
            if (j5 == 0) {
                if (perChannel2.messagesQueue.isEmpty()) {
                    this.trafficCounter.bytesRealWriteFlowControl(j4);
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
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.GlobalTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalTrafficShapingHandler.this.sendAllValid(channelHandlerContext, perChannel2, j8);
                }
            }, j7, TimeUnit.MILLISECONDS);
        }
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected int userDefinedWritabilityIndex() {
        return 2;
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5, long j6) {
        super(j4, j5, j6);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4, long j5) {
        super(j4, j5);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService scheduledExecutorService, long j4) {
        super(j4);
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(scheduledExecutorService);
    }

    public GlobalTrafficShapingHandler(EventExecutor eventExecutor) {
        this.channelQueues = PlatformDependent.newConcurrentHashMap();
        this.queuesSize = new AtomicLong();
        this.maxGlobalWriteSize = 419430400L;
        createGlobalTrafficCounter(eventExecutor);
    }
}

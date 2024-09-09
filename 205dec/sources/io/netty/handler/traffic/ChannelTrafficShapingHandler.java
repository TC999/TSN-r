package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue;
    private long queueSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long j4, Object obj, ChannelPromise channelPromise) {
            this.relativeTimeAction = j4;
            this.toSend = obj;
            this.promise = channelPromise;
        }
    }

    public ChannelTrafficShapingHandler(long j4, long j5, long j6, long j7) {
        super(j4, j5, j6, j7);
        this.messagesQueue = new ArrayDeque<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, long j4) {
        synchronized (this) {
            ToSend pollFirst = this.messagesQueue.pollFirst();
            while (true) {
                if (pollFirst != null) {
                    if (pollFirst.relativeTimeAction <= j4) {
                        long calculateSize = calculateSize(pollFirst.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                        this.queueSize -= calculateSize;
                        channelHandlerContext.write(pollFirst.toSend, pollFirst.promise);
                        pollFirst = this.messagesQueue.pollFirst();
                    } else {
                        this.messagesQueue.addFirst(pollFirst);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.messagesQueue.isEmpty()) {
                releaseWriteSuspended(channelHandlerContext);
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        EventExecutor executor = channelHandlerContext.executor();
        TrafficCounter trafficCounter = new TrafficCounter(this, executor, "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.trafficCounter.stop();
        synchronized (this) {
            if (channelHandlerContext.channel().isActive()) {
                Iterator<ToSend> it = this.messagesQueue.iterator();
                while (it.hasNext()) {
                    ToSend next = it.next();
                    long calculateSize = calculateSize(next.toSend);
                    this.trafficCounter.bytesRealWriteFlowControl(calculateSize);
                    this.queueSize -= calculateSize;
                    channelHandlerContext.write(next.toSend, next.promise);
                }
            } else {
                Iterator<ToSend> it2 = this.messagesQueue.iterator();
                while (it2.hasNext()) {
                    Object obj = it2.next().toSend;
                    if (obj instanceof ByteBuf) {
                        ((ByteBuf) obj).release();
                    }
                }
            }
            this.messagesQueue.clear();
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public long queueSize() {
        return this.queueSize;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j4, long j5, long j6, ChannelPromise channelPromise) {
        synchronized (this) {
            if (j5 == 0) {
                if (this.messagesQueue.isEmpty()) {
                    this.trafficCounter.bytesRealWriteFlowControl(j4);
                    channelHandlerContext.write(obj, channelPromise);
                    return;
                }
            }
            ToSend toSend = new ToSend(j5 + j6, obj, channelPromise);
            this.messagesQueue.addLast(toSend);
            long j7 = this.queueSize + j4;
            this.queueSize = j7;
            checkWriteSuspend(channelHandlerContext, j5, j7);
            final long j8 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.ChannelTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, j8);
                }
            }, j5, TimeUnit.MILLISECONDS);
        }
    }

    public ChannelTrafficShapingHandler(long j4, long j5, long j6) {
        super(j4, j5, j6);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j4, long j5) {
        super(j4, j5);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j4) {
        super(j4);
        this.messagesQueue = new ArrayDeque<>();
    }
}

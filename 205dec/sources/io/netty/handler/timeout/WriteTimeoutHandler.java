package io.netty.handler.timeout;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class WriteTimeoutHandler extends ChannelOutboundHandlerAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private boolean closed;
    private WriteTimeoutTask lastTask;
    private final long timeoutNanos;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class WriteTimeoutTask implements Runnable, ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        WriteTimeoutTask next;
        WriteTimeoutTask prev;
        private final ChannelPromise promise;
        ScheduledFuture<?> scheduledFuture;

        WriteTimeoutTask(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.promise.isDone()) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                } catch (Throwable th) {
                    this.ctx.fireExceptionCaught(th);
                }
            }
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            this.scheduledFuture.cancel(false);
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }
    }

    public WriteTimeoutHandler(int i4) {
        this(i4, TimeUnit.SECONDS);
    }

    private void addWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask2 != null) {
            writeTimeoutTask2.next = writeTimeoutTask;
            writeTimeoutTask.prev = writeTimeoutTask2;
        }
        this.lastTask = writeTimeoutTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWriteTimeoutTask(WriteTimeoutTask writeTimeoutTask) {
        WriteTimeoutTask writeTimeoutTask2 = this.lastTask;
        if (writeTimeoutTask == writeTimeoutTask2) {
            WriteTimeoutTask writeTimeoutTask3 = writeTimeoutTask2.prev;
            this.lastTask = writeTimeoutTask3;
            if (writeTimeoutTask3 != null) {
                writeTimeoutTask3.next = null;
            }
        } else {
            WriteTimeoutTask writeTimeoutTask4 = writeTimeoutTask.prev;
            if (writeTimeoutTask4 == null && writeTimeoutTask.next == null) {
                return;
            }
            if (writeTimeoutTask4 == null) {
                writeTimeoutTask.next.prev = null;
            } else {
                writeTimeoutTask4.next = writeTimeoutTask.next;
                writeTimeoutTask.next.prev = writeTimeoutTask4;
            }
        }
        writeTimeoutTask.prev = null;
        writeTimeoutTask.next = null;
    }

    private void scheduleTimeout(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        WriteTimeoutTask writeTimeoutTask = new WriteTimeoutTask(channelHandlerContext, channelPromise);
        io.netty.util.concurrent.ScheduledFuture<?> schedule = channelHandlerContext.executor().schedule((Runnable) writeTimeoutTask, this.timeoutNanos, TimeUnit.NANOSECONDS);
        writeTimeoutTask.scheduledFuture = schedule;
        if (schedule.isDone()) {
            return;
        }
        addWriteTimeoutTask(writeTimeoutTask);
        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) writeTimeoutTask);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        WriteTimeoutTask writeTimeoutTask = this.lastTask;
        this.lastTask = null;
        while (writeTimeoutTask != null) {
            writeTimeoutTask.scheduledFuture.cancel(false);
            WriteTimeoutTask writeTimeoutTask2 = writeTimeoutTask.prev;
            writeTimeoutTask.prev = null;
            writeTimeoutTask.next = null;
            writeTimeoutTask = writeTimeoutTask2;
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.timeoutNanos > 0) {
            channelPromise = channelPromise.unvoid();
            scheduleTimeout(channelHandlerContext, channelPromise);
        }
        channelHandlerContext.write(obj, channelPromise);
    }

    protected void writeTimedOut(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.closed) {
            return;
        }
        channelHandlerContext.fireExceptionCaught((Throwable) WriteTimeoutException.INSTANCE);
        channelHandlerContext.close();
        this.closed = true;
    }

    public WriteTimeoutHandler(long j4, TimeUnit timeUnit) {
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j4 <= 0) {
            this.timeoutNanos = 0L;
        } else {
            this.timeoutNanos = Math.max(timeUnit.toNanos(j4), MIN_TIMEOUT_NANOS);
        }
    }
}

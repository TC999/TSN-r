package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private final long allIdleTimeNanos;
    private ScheduledFuture<?> allIdleTimeout;
    private boolean firstAllIdleEvent;
    private boolean firstReaderIdleEvent;
    private boolean firstWriterIdleEvent;
    private long lastChangeCheckTimeStamp;
    private long lastFlushProgress;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    private long lastReadTime;
    private long lastWriteTime;
    private final boolean observeOutput;
    private final long readerIdleTimeNanos;
    private ScheduledFuture<?> readerIdleTimeout;
    private boolean reading;
    private byte state;
    private final ChannelFutureListener writeListener;
    private final long writerIdleTimeNanos;
    private ScheduledFuture<?> writerIdleTimeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$timeout$IdleState;

        static {
            int[] iArr = new int[IdleState.values().length];
            $SwitchMap$io$netty$handler$timeout$IdleState = iArr;
            try {
                iArr[IdleState.ALL_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.READER_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$timeout$IdleState[IdleState.WRITER_IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        AbstractIdleTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                run(this.ctx);
            }
        }

        protected abstract void run(ChannelHandlerContext channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class AllIdleTimeoutTask extends AbstractIdleTask {
        AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long j4 = IdleStateHandler.this.allIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                j4 -= IdleStateHandler.this.ticksInNanos() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
            }
            long j5 = j4;
            if (j5 <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.allIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.allIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean z3 = IdleStateHandler.this.firstAllIdleEvent;
                IdleStateHandler.this.firstAllIdleEvent = false;
                try {
                    if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z3)) {
                        return;
                    }
                    IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, z3));
                    return;
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                    return;
                }
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.allIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, j5, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long j4 = IdleStateHandler.this.readerIdleTimeNanos;
            if (!IdleStateHandler.this.reading) {
                j4 -= IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastReadTime;
            }
            long j5 = j4;
            if (j5 <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.readerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean z3 = IdleStateHandler.this.firstReaderIdleEvent;
                IdleStateHandler.this.firstReaderIdleEvent = false;
                try {
                    IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.READER_IDLE, z3));
                    return;
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                    return;
                }
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.readerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, j5, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class WriterIdleTimeoutTask extends AbstractIdleTask {
        WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            super(channelHandlerContext);
        }

        @Override // io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext channelHandlerContext) {
            long ticksInNanos = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastWriteTime);
            if (ticksInNanos <= 0) {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.writerIdleTimeout = idleStateHandler.schedule(channelHandlerContext, this, idleStateHandler.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean z3 = IdleStateHandler.this.firstWriterIdleEvent;
                IdleStateHandler.this.firstWriterIdleEvent = false;
                try {
                    if (IdleStateHandler.this.hasOutputChanged(channelHandlerContext, z3)) {
                        return;
                    }
                    IdleStateHandler.this.channelIdle(channelHandlerContext, IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, z3));
                    return;
                } catch (Throwable th) {
                    channelHandlerContext.fireExceptionCaught(th);
                    return;
                }
            }
            IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
            idleStateHandler2.writerIdleTimeout = idleStateHandler2.schedule(channelHandlerContext, this, ticksInNanos, TimeUnit.NANOSECONDS);
        }
    }

    public IdleStateHandler(int i4, int i5, int i6) {
        this(i4, i5, i6, TimeUnit.SECONDS);
    }

    private void destroy() {
        this.state = (byte) 2;
        ScheduledFuture<?> scheduledFuture = this.readerIdleTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.readerIdleTimeout = null;
        }
        ScheduledFuture<?> scheduledFuture2 = this.writerIdleTimeout;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
            this.writerIdleTimeout = null;
        }
        ScheduledFuture<?> scheduledFuture3 = this.allIdleTimeout;
        if (scheduledFuture3 != null) {
            scheduledFuture3.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasOutputChanged(ChannelHandlerContext channelHandlerContext, boolean z3) {
        if (this.observeOutput) {
            long j4 = this.lastChangeCheckTimeStamp;
            long j5 = this.lastWriteTime;
            if (j4 != j5) {
                this.lastChangeCheckTimeStamp = j5;
                if (!z3) {
                    return true;
                }
            }
            ChannelOutboundBuffer outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer();
            if (outboundBuffer != null) {
                int identityHashCode = System.identityHashCode(outboundBuffer.current());
                long j6 = outboundBuffer.totalPendingWriteBytes();
                if (identityHashCode != this.lastMessageHashCode || j6 != this.lastPendingWriteBytes) {
                    this.lastMessageHashCode = identityHashCode;
                    this.lastPendingWriteBytes = j6;
                    if (!z3) {
                        return true;
                    }
                }
                long currentProgress = outboundBuffer.currentProgress();
                if (currentProgress != this.lastFlushProgress) {
                    this.lastFlushProgress = currentProgress;
                    return !z3;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void initOutputChanged(ChannelHandlerContext channelHandlerContext) {
        ChannelOutboundBuffer outboundBuffer;
        if (!this.observeOutput || (outboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer()) == null) {
            return;
        }
        this.lastMessageHashCode = System.identityHashCode(outboundBuffer.current());
        this.lastPendingWriteBytes = outboundBuffer.totalPendingWriteBytes();
        this.lastFlushProgress = outboundBuffer.currentProgress();
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        byte b4 = this.state;
        if (b4 == 1 || b4 == 2) {
            return;
        }
        this.state = (byte) 1;
        initOutputChanged(channelHandlerContext);
        long ticksInNanos = ticksInNanos();
        this.lastWriteTime = ticksInNanos;
        this.lastReadTime = ticksInNanos;
        if (this.readerIdleTimeNanos > 0) {
            this.readerIdleTimeout = schedule(channelHandlerContext, new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.writerIdleTimeNanos > 0) {
            this.writerIdleTimeout = schedule(channelHandlerContext, new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.allIdleTimeNanos > 0) {
            this.allIdleTimeout = schedule(channelHandlerContext, new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        initialize(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    protected void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) throws Exception {
        channelHandlerContext.fireUserEventTriggered((Object) idleStateEvent);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if ((this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) && this.reading) {
            this.lastReadTime = ticksInNanos();
            this.reading = false;
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive()) {
            initialize(channelHandlerContext);
        }
        super.channelRegistered(channelHandlerContext);
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive() && channelHandlerContext.channel().isRegistered()) {
            initialize(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
    }

    protected IdleStateEvent newIdleStateEvent(IdleState idleState, boolean z3) {
        int i4 = AnonymousClass2.$SwitchMap$io$netty$handler$timeout$IdleState[idleState.ordinal()];
        if (i4 == 1) {
            return z3 ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
        } else if (i4 == 2) {
            return z3 ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
        } else if (i4 == 3) {
            return z3 ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
        } else {
            throw new IllegalArgumentException("Unhandled: state=" + idleState + ", first=" + z3);
        }
    }

    ScheduledFuture<?> schedule(ChannelHandlerContext channelHandlerContext, Runnable runnable, long j4, TimeUnit timeUnit) {
        return channelHandlerContext.executor().schedule(runnable, j4, timeUnit);
    }

    long ticksInNanos() {
        return System.nanoTime();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.writerIdleTimeNanos <= 0 && this.allIdleTimeNanos <= 0) {
            channelHandlerContext.write(obj, channelPromise);
        } else {
            channelHandlerContext.write(obj, channelPromise.unvoid()).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
        }
    }

    public IdleStateHandler(long j4, long j5, long j6, TimeUnit timeUnit) {
        this(false, j4, j5, j6, timeUnit);
    }

    public IdleStateHandler(boolean z3, long j4, long j5, long j6, TimeUnit timeUnit) {
        this.writeListener = new ChannelFutureListener() { // from class: io.netty.handler.timeout.IdleStateHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.lastWriteTime = idleStateHandler.ticksInNanos();
                IdleStateHandler idleStateHandler2 = IdleStateHandler.this;
                idleStateHandler2.firstWriterIdleEvent = idleStateHandler2.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        if (timeUnit != null) {
            this.observeOutput = z3;
            if (j4 <= 0) {
                this.readerIdleTimeNanos = 0L;
            } else {
                this.readerIdleTimeNanos = Math.max(timeUnit.toNanos(j4), MIN_TIMEOUT_NANOS);
            }
            if (j5 <= 0) {
                this.writerIdleTimeNanos = 0L;
            } else {
                this.writerIdleTimeNanos = Math.max(timeUnit.toNanos(j5), MIN_TIMEOUT_NANOS);
            }
            if (j6 <= 0) {
                this.allIdleTimeNanos = 0L;
                return;
            } else {
                this.allIdleTimeNanos = Math.max(timeUnit.toNanos(j6), MIN_TIMEOUT_NANOS);
                return;
            }
        }
        throw new NullPointerException("unit");
    }
}

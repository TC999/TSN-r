package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private final long allIdleTimeNanos;
    volatile ScheduledFuture<?> allIdleTimeout;
    private boolean firstAllIdleEvent;
    private boolean firstReaderIdleEvent;
    private boolean firstWriterIdleEvent;
    volatile long lastReadTime;
    volatile long lastWriteTime;
    private final long readerIdleTimeNanos;
    volatile ScheduledFuture<?> readerIdleTimeout;
    private volatile boolean reading;
    private volatile int state;
    private final ChannelFutureListener writeListener;
    private final long writerIdleTimeNanos;
    volatile ScheduledFuture<?> writerIdleTimeout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$2 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C139682 {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class AllIdleTimeoutTask implements Runnable {
        private final ChannelHandlerContext ctx;

        AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                long j = IdleStateHandler.this.allIdleTimeNanos;
                if (!IdleStateHandler.this.reading) {
                    j -= System.nanoTime() - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
                }
                if (j <= 0) {
                    IdleStateHandler.this.allIdleTimeout = this.ctx.executor().schedule((Runnable) this, IdleStateHandler.this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
                    try {
                        IdleStateHandler idleStateHandler = IdleStateHandler.this;
                        IdleStateEvent newIdleStateEvent = idleStateHandler.newIdleStateEvent(IdleState.ALL_IDLE, idleStateHandler.firstAllIdleEvent);
                        if (IdleStateHandler.this.firstAllIdleEvent) {
                            IdleStateHandler.this.firstAllIdleEvent = false;
                        }
                        IdleStateHandler.this.channelIdle(this.ctx, newIdleStateEvent);
                        return;
                    } catch (Throwable th) {
                        this.ctx.fireExceptionCaught(th);
                        return;
                    }
                }
                IdleStateHandler.this.allIdleTimeout = this.ctx.executor().schedule((Runnable) this, j, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class ReaderIdleTimeoutTask implements Runnable {
        private final ChannelHandlerContext ctx;

        ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                long j = IdleStateHandler.this.readerIdleTimeNanos;
                if (!IdleStateHandler.this.reading) {
                    j -= System.nanoTime() - IdleStateHandler.this.lastReadTime;
                }
                if (j <= 0) {
                    IdleStateHandler.this.readerIdleTimeout = this.ctx.executor().schedule((Runnable) this, IdleStateHandler.this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
                    try {
                        IdleStateHandler idleStateHandler = IdleStateHandler.this;
                        IdleStateEvent newIdleStateEvent = idleStateHandler.newIdleStateEvent(IdleState.READER_IDLE, idleStateHandler.firstReaderIdleEvent);
                        if (IdleStateHandler.this.firstReaderIdleEvent) {
                            IdleStateHandler.this.firstReaderIdleEvent = false;
                        }
                        IdleStateHandler.this.channelIdle(this.ctx, newIdleStateEvent);
                        return;
                    } catch (Throwable th) {
                        this.ctx.fireExceptionCaught(th);
                        return;
                    }
                }
                IdleStateHandler.this.readerIdleTimeout = this.ctx.executor().schedule((Runnable) this, j, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class WriterIdleTimeoutTask implements Runnable {
        private final ChannelHandlerContext ctx;

        WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                long nanoTime = IdleStateHandler.this.writerIdleTimeNanos - (System.nanoTime() - IdleStateHandler.this.lastWriteTime);
                if (nanoTime <= 0) {
                    IdleStateHandler.this.writerIdleTimeout = this.ctx.executor().schedule((Runnable) this, IdleStateHandler.this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                    try {
                        IdleStateHandler idleStateHandler = IdleStateHandler.this;
                        IdleStateEvent newIdleStateEvent = idleStateHandler.newIdleStateEvent(IdleState.WRITER_IDLE, idleStateHandler.firstWriterIdleEvent);
                        if (IdleStateHandler.this.firstWriterIdleEvent) {
                            IdleStateHandler.this.firstWriterIdleEvent = false;
                        }
                        IdleStateHandler.this.channelIdle(this.ctx, newIdleStateEvent);
                        return;
                    } catch (Throwable th) {
                        this.ctx.fireExceptionCaught(th);
                        return;
                    }
                }
                IdleStateHandler.this.writerIdleTimeout = this.ctx.executor().schedule((Runnable) this, nanoTime, TimeUnit.NANOSECONDS);
            }
        }
    }

    public IdleStateHandler(int i, int i2, int i3) {
        this(i, i2, i3, TimeUnit.SECONDS);
    }

    private void destroy() {
        this.state = 2;
        if (this.readerIdleTimeout != null) {
            this.readerIdleTimeout.cancel(false);
            this.readerIdleTimeout = null;
        }
        if (this.writerIdleTimeout != null) {
            this.writerIdleTimeout.cancel(false);
            this.writerIdleTimeout = null;
        }
        if (this.allIdleTimeout != null) {
            this.allIdleTimeout.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        int i = this.state;
        if (i == 1 || i == 2) {
            return;
        }
        this.state = 1;
        EventExecutor executor = channelHandlerContext.executor();
        long nanoTime = System.nanoTime();
        this.lastWriteTime = nanoTime;
        this.lastReadTime = nanoTime;
        if (this.readerIdleTimeNanos > 0) {
            this.readerIdleTimeout = executor.schedule((Runnable) new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.writerIdleTimeNanos > 0) {
            this.writerIdleTimeout = executor.schedule((Runnable) new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
        }
        if (this.allIdleTimeNanos > 0) {
            this.allIdleTimeout = executor.schedule((Runnable) new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
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
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.lastReadTime = System.nanoTime();
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

    protected IdleStateEvent newIdleStateEvent(IdleState idleState, boolean z) {
        int i = C139682.$SwitchMap$io$netty$handler$timeout$IdleState[idleState.ordinal()];
        if (i == 1) {
            return z ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
        } else if (i == 2) {
            return z ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
        } else if (i == 3) {
            return z ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (this.writerIdleTimeNanos <= 0 && this.allIdleTimeNanos <= 0) {
            channelHandlerContext.write(obj, channelPromise);
            return;
        }
        ChannelPromise unvoid = channelPromise.unvoid();
        unvoid.addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
        channelHandlerContext.write(obj, unvoid);
    }

    public IdleStateHandler(long j, long j2, long j3, TimeUnit timeUnit) {
        this.writeListener = new ChannelFutureListener() { // from class: io.netty.handler.timeout.IdleStateHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                IdleStateHandler.this.lastWriteTime = System.nanoTime();
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                idleStateHandler.firstWriterIdleEvent = idleStateHandler.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        if (timeUnit == null) {
            throw new NullPointerException("unit");
        }
        if (j <= 0) {
            this.readerIdleTimeNanos = 0L;
        } else {
            this.readerIdleTimeNanos = Math.max(timeUnit.toNanos(j), MIN_TIMEOUT_NANOS);
        }
        if (j2 <= 0) {
            this.writerIdleTimeNanos = 0L;
        } else {
            this.writerIdleTimeNanos = Math.max(timeUnit.toNanos(j2), MIN_TIMEOUT_NANOS);
        }
        if (j3 <= 0) {
            this.allIdleTimeNanos = 0L;
        } else {
            this.allIdleTimeNanos = Math.max(timeUnit.toNanos(j3), MIN_TIMEOUT_NANOS);
        }
    }
}

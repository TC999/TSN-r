package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    private volatile ChannelHandlerContext ctx;
    private PendingWrite currentWrite;
    private final Queue<PendingWrite> queue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        PendingWrite(Object obj, ChannelPromise channelPromise) {
            this.msg = obj;
            this.promise = channelPromise;
        }

        void fail(Throwable th) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(th);
        }

        void progress(long j, long j2) {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j, j2);
            }
        }

        void success(long j) {
            if (this.promise.isDone()) {
                return;
            }
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j, j);
            }
            this.promise.trySuccess();
        }
    }

    public ChunkedWriteHandler() {
    }

    static void closeInput(ChunkedInput<?> chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a chunked input.", th);
            }
        }
    }

    private void discard(Throwable th) {
        while (true) {
            PendingWrite pendingWrite = this.currentWrite;
            if (pendingWrite == null) {
                pendingWrite = this.queue.poll();
            } else {
                this.currentWrite = null;
            }
            if (pendingWrite == null) {
                return;
            }
            Object obj = pendingWrite.msg;
            if (obj instanceof ChunkedInput) {
                ChunkedInput chunkedInput = (ChunkedInput) obj;
                try {
                    if (!chunkedInput.isEndOfInput()) {
                        if (th == null) {
                            th = new ClosedChannelException();
                        }
                        pendingWrite.fail(th);
                    } else {
                        pendingWrite.success(chunkedInput.length());
                    }
                    closeInput(chunkedInput);
                } catch (Exception e) {
                    pendingWrite.fail(e);
                    InternalLogger internalLogger = logger;
                    internalLogger.warn(ChunkedInput.class.getSimpleName() + ".isEndOfInput() failed", (Throwable) e);
                    closeInput(chunkedInput);
                }
            } else {
                if (th == null) {
                    th = new ClosedChannelException();
                }
                pendingWrite.fail(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doFlush(ChannelHandlerContext channelHandlerContext) throws Exception {
        Object obj;
        final Channel channel = channelHandlerContext.channel();
        if (!channel.isActive()) {
            discard(null);
            return false;
        }
        ByteBufAllocator alloc = channelHandlerContext.alloc();
        boolean z = false;
        while (channel.isWritable()) {
            if (this.currentWrite == null) {
                this.currentWrite = this.queue.poll();
            }
            final PendingWrite pendingWrite = this.currentWrite;
            if (pendingWrite == null) {
                break;
            }
            final Object obj2 = pendingWrite.msg;
            if (obj2 instanceof ChunkedInput) {
                final ChunkedInput chunkedInput = (ChunkedInput) obj2;
                try {
                    obj = chunkedInput.readChunk(alloc);
                } catch (Throwable th) {
                    th = th;
                    obj = null;
                }
                try {
                    boolean isEndOfInput = chunkedInput.isEndOfInput();
                    if (obj == null ? !isEndOfInput : false) {
                        break;
                    }
                    if (obj == null) {
                        obj = Unpooled.EMPTY_BUFFER;
                    }
                    ChannelFuture write = channelHandlerContext.write(obj);
                    if (isEndOfInput) {
                        this.currentWrite = null;
                        write.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                pendingWrite.progress(chunkedInput.progress(), chunkedInput.length());
                                pendingWrite.success(chunkedInput.length());
                                ChunkedWriteHandler.closeInput(chunkedInput);
                            }
                        });
                    } else if (channel.isWritable()) {
                        write.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.3
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (!channelFuture.isSuccess()) {
                                    ChunkedWriteHandler.closeInput((ChunkedInput) obj2);
                                    pendingWrite.fail(channelFuture.cause());
                                    return;
                                }
                                pendingWrite.progress(chunkedInput.progress(), chunkedInput.length());
                            }
                        });
                    } else {
                        write.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.4
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (!channelFuture.isSuccess()) {
                                    ChunkedWriteHandler.closeInput((ChunkedInput) obj2);
                                    pendingWrite.fail(channelFuture.cause());
                                    return;
                                }
                                pendingWrite.progress(chunkedInput.progress(), chunkedInput.length());
                                if (channel.isWritable()) {
                                    ChunkedWriteHandler.this.resumeTransfer();
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.currentWrite = null;
                    if (obj != null) {
                        ReferenceCountUtil.release(obj);
                    }
                    pendingWrite.fail(th);
                    closeInput(chunkedInput);
                    return z;
                }
            } else {
                channelHandlerContext.write(obj2, pendingWrite.promise);
                this.currentWrite = null;
            }
            channelHandlerContext.flush();
            if (!channel.isActive()) {
                discard(new ClosedChannelException());
                return true;
            }
            z = true;
        }
        return z;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        doFlush(channelHandlerContext);
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isWritable()) {
            doFlush(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (doFlush(channelHandlerContext)) {
            return;
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void resumeTransfer() {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            return;
        }
        if (channelHandlerContext.executor().inEventLoop()) {
            try {
                doFlush(channelHandlerContext);
                return;
            } catch (Exception e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Unexpected exception while sending chunks.", (Throwable) e);
                    return;
                }
                return;
            }
        }
        channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ChunkedWriteHandler.this.doFlush(channelHandlerContext);
                } catch (Exception e2) {
                    if (ChunkedWriteHandler.logger.isWarnEnabled()) {
                        ChunkedWriteHandler.logger.warn("Unexpected exception while sending chunks.", (Throwable) e2);
                    }
                }
            }
        });
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.queue.add(new PendingWrite(obj, channelPromise));
    }

    @Deprecated
    public ChunkedWriteHandler(int i) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException("maxPendingWrites: " + i + " (expected: > 0)");
    }
}

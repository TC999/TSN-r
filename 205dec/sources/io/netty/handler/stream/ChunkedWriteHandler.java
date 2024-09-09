package io.netty.handler.stream;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    private volatile ChannelHandlerContext ctx;
    private PendingWrite currentWrite;
    private final Queue<PendingWrite> queue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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

        void progress(long j4, long j5) {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j4, j5);
            }
        }

        void success(long j4) {
            if (this.promise.isDone()) {
                return;
            }
            progress(j4, j4);
            this.promise.trySuccess();
        }
    }

    public ChunkedWriteHandler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeInput(ChunkedInput<?> chunkedInput) {
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
                    boolean isEndOfInput = chunkedInput.isEndOfInput();
                    long length = chunkedInput.length();
                    closeInput(chunkedInput);
                    if (!isEndOfInput) {
                        if (th == null) {
                            th = new ClosedChannelException();
                        }
                        pendingWrite.fail(th);
                    } else {
                        pendingWrite.success(length);
                    }
                } catch (Exception e4) {
                    closeInput(chunkedInput);
                    pendingWrite.fail(e4);
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn(ChunkedInput.class.getSimpleName() + " failed", (Throwable) e4);
                    }
                }
            } else {
                if (th == null) {
                    th = new ClosedChannelException();
                }
                pendingWrite.fail(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doFlush(io.netty.channel.ChannelHandlerContext r12) {
        /*
            r11 = this;
            io.netty.channel.Channel r0 = r12.channel()
            boolean r1 = r0.isActive()
            r2 = 0
            if (r1 != 0) goto Lf
            r11.discard(r2)
            return
        Lf:
            io.netty.buffer.ByteBufAllocator r1 = r12.alloc()
            r3 = 1
            r4 = 1
        L15:
            boolean r5 = r0.isWritable()
            if (r5 == 0) goto Laf
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r5 = r11.currentWrite
            if (r5 != 0) goto L29
            java.util.Queue<io.netty.handler.stream.ChunkedWriteHandler$PendingWrite> r5 = r11.queue
            java.lang.Object r5 = r5.poll()
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r5 = (io.netty.handler.stream.ChunkedWriteHandler.PendingWrite) r5
            r11.currentWrite = r5
        L29:
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r5 = r11.currentWrite
            if (r5 != 0) goto L2f
            goto Laf
        L2f:
            io.netty.channel.ChannelPromise r5 = r5.promise
            boolean r5 = r5.isDone()
            if (r5 == 0) goto L3a
            r11.currentWrite = r2
            goto L15
        L3a:
            io.netty.handler.stream.ChunkedWriteHandler$PendingWrite r5 = r11.currentWrite
            java.lang.Object r6 = r5.msg
            boolean r7 = r6 instanceof io.netty.handler.stream.ChunkedInput
            r8 = 0
            if (r7 == 0) goto L99
            io.netty.handler.stream.ChunkedInput r6 = (io.netty.handler.stream.ChunkedInput) r6
            java.lang.Object r7 = r6.readChunk(r1)     // Catch: java.lang.Throwable -> L89
            boolean r9 = r6.isEndOfInput()     // Catch: java.lang.Throwable -> L87
            if (r7 != 0) goto L52
            r10 = r9 ^ 1
            goto L53
        L52:
            r10 = 0
        L53:
            if (r10 == 0) goto L56
            goto Laf
        L56:
            if (r7 != 0) goto L5a
            io.netty.buffer.ByteBuf r7 = io.netty.buffer.Unpooled.EMPTY_BUFFER
        L5a:
            io.netty.channel.ChannelFuture r4 = r12.write(r7)
            if (r9 == 0) goto L6b
            r11.currentWrite = r2
            io.netty.handler.stream.ChunkedWriteHandler$2 r7 = new io.netty.handler.stream.ChunkedWriteHandler$2
            r7.<init>()
            r4.addListener(r7)
            goto L82
        L6b:
            boolean r7 = r0.isWritable()
            if (r7 == 0) goto L7a
            io.netty.handler.stream.ChunkedWriteHandler$3 r7 = new io.netty.handler.stream.ChunkedWriteHandler$3
            r7.<init>()
            r4.addListener(r7)
            goto L82
        L7a:
            io.netty.handler.stream.ChunkedWriteHandler$4 r7 = new io.netty.handler.stream.ChunkedWriteHandler$4
            r7.<init>()
            r4.addListener(r7)
        L82:
            r12.flush()
            r4 = 0
            goto La1
        L87:
            r0 = move-exception
            goto L8b
        L89:
            r0 = move-exception
            r7 = r2
        L8b:
            r11.currentWrite = r2
            if (r7 == 0) goto L92
            io.netty.util.ReferenceCountUtil.release(r7)
        L92:
            closeInput(r6)
            r5.fail(r0)
            goto Laf
        L99:
            r11.currentWrite = r2
            io.netty.channel.ChannelPromise r4 = r5.promise
            r12.write(r6, r4)
            r4 = 1
        La1:
            boolean r5 = r0.isActive()
            if (r5 != 0) goto L15
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException
            r0.<init>()
            r11.discard(r0)
        Laf:
            if (r4 == 0) goto Lb4
            r12.flush()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.stream.ChunkedWriteHandler.doFlush(io.netty.channel.ChannelHandlerContext):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTransfer0(ChannelHandlerContext channelHandlerContext) {
        try {
            doFlush(channelHandlerContext);
        } catch (Exception e4) {
            if (logger.isWarnEnabled()) {
                logger.warn("Unexpected exception while sending chunks.", (Throwable) e4);
            }
        }
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
        doFlush(channelHandlerContext);
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
            resumeTransfer0(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChunkedWriteHandler.this.resumeTransfer0(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.queue.add(new PendingWrite(obj, channelPromise));
    }

    @Deprecated
    public ChunkedWriteHandler(int i4) {
        if (i4 > 0) {
            return;
        }
        throw new IllegalArgumentException("maxPendingWrites: " + i4 + " (expected: > 0)");
    }
}

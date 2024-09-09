package io.netty.handler.flush;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FlushConsolidationHandler extends ChannelDuplexHandler {
    private final int explicitFlushAfterFlushes;
    private int flushPendingCount;
    private boolean readInprogess;

    /* renamed from: io.netty.handler.flush.FlushConsolidationHandler$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FlushConsolidationHandler.access$000(FlushConsolidationHandler.this) <= 0 || FlushConsolidationHandler.access$100(FlushConsolidationHandler.this)) {
                return;
            }
            FlushConsolidationHandler.access$002(FlushConsolidationHandler.this, 0);
            FlushConsolidationHandler.access$200(FlushConsolidationHandler.this).flush();
            FlushConsolidationHandler.access$302(FlushConsolidationHandler.this, null);
        }
    }

    public FlushConsolidationHandler() {
        this(256);
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (this.flushPendingCount > 0) {
            this.flushPendingCount = 0;
            channelHandlerContext.flush();
        }
    }

    private void resetReadAndFlushIfNeeded(ChannelHandlerContext channelHandlerContext) {
        this.readInprogess = false;
        flushIfNeeded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.readInprogess = true;
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!channelHandlerContext.channel().isWritable()) {
            flushIfNeeded(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        resetReadAndFlushIfNeeded(channelHandlerContext);
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.readInprogess) {
            int i4 = this.flushPendingCount + 1;
            this.flushPendingCount = i4;
            if (i4 == this.explicitFlushAfterFlushes) {
                this.flushPendingCount = 0;
                channelHandlerContext.flush();
                return;
            }
            return;
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        flushIfNeeded(channelHandlerContext);
    }

    public FlushConsolidationHandler(int i4) {
        this.explicitFlushAfterFlushes = ObjectUtil.checkPositive(i4, "explicitFlushAfterFlushes");
    }
}

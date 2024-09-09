package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CombinedChannelDuplexHandler.class);
    private volatile boolean handlerAdded;
    private DelegatingChannelHandlerContext inboundCtx;
    private I inboundHandler;
    private DelegatingChannelHandlerContext outboundCtx;
    private O outboundHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        DelegatingChannelHandlerContext(ChannelHandlerContext channelHandlerContext, ChannelHandler channelHandler) {
            this.ctx = channelHandlerContext;
            this.handler = channelHandler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove0() {
            if (this.removed) {
                return;
            }
            this.removed = true;
            try {
                this.handler.handlerRemoved(this);
            } catch (Throwable th) {
                fireExceptionCaught((Throwable) new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", th));
            }
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
            return this.ctx.attr(attributeKey);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress) {
            return this.ctx.bind(socketAddress);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress) {
            return this.ctx.connect(socketAddress);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister() {
            return this.ctx.deregister();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect() {
            return this.ctx.disconnect();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
            return this.ctx.hasAttr(attributeKey);
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public String name() {
            return this.ctx.name();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newFailedFuture(Throwable th) {
            return this.ctx.newFailedFuture(th);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelProgressivePromise newProgressivePromise() {
            return this.ctx.newProgressivePromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newSucceededFuture() {
            return this.ctx.newSucceededFuture();
        }

        @Override // io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        final void remove() {
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                remove0();
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj) {
            return this.ctx.write(obj);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
            return this.ctx.writeAndFlush(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.bind(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise channelPromise) {
            return this.ctx.close(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
            return this.ctx.connect(socketAddress, socketAddress2);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister(ChannelPromise channelPromise) {
            return this.ctx.deregister(channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect(ChannelPromise channelPromise) {
            return this.ctx.disconnect(channelPromise);
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRead(Object obj) {
            this.ctx.fireChannelRead(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireExceptionCaught(Throwable th) {
            this.ctx.fireExceptionCaught(th);
            return this;
        }

        @Override // io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireUserEventTriggered(Object obj) {
            this.ctx.fireUserEventTriggered(obj);
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
            return this.ctx.write(obj, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object obj) {
            return this.ctx.writeAndFlush(obj);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, channelPromise);
        }

        @Override // io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            return this.ctx.connect(socketAddress, socketAddress2, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CombinedChannelDuplexHandler() {
    }

    private void checkAdded() {
        if (!this.handlerAdded) {
            throw new IllegalStateException("handler not added to pipeline yet");
        }
    }

    private void validate(I i4, O o4) {
        if (this.inboundHandler != null) {
            throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
        } else if (i4 == null) {
            throw new NullPointerException("inboundHandler");
        } else {
            if (o4 != null) {
                if (!(i4 instanceof ChannelOutboundHandler)) {
                    if (o4 instanceof ChannelInboundHandler) {
                        throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
                    }
                    return;
                }
                throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
            }
            throw new NullPointerException("outboundHandler");
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.bind(delegatingChannelHandlerContext, socketAddress, channelPromise);
        } else {
            delegatingChannelHandlerContext.bind(socketAddress, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelActive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelActive();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelInactive(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelInactive();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRead(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireChannelRead(obj);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelReadComplete(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelReadComplete();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelRegistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelRegistered();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelUnregistered(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelUnregistered();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.channelWritabilityChanged(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.fireChannelWritabilityChanged();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.close(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.close(channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.connect(delegatingChannelHandlerContext, socketAddress, socketAddress2, channelPromise);
        } else {
            delegatingChannelHandlerContext.connect(socketAddress2, channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.deregister(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.deregister(channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.disconnect(delegatingChannelHandlerContext, channelPromise);
        } else {
            delegatingChannelHandlerContext.disconnect(channelPromise);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.exceptionCaught(delegatingChannelHandlerContext, th);
        } else {
            delegatingChannelHandlerContext.fireExceptionCaught(th);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.flush(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.flush();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.inboundHandler != null) {
            this.outboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.outboundHandler);
            this.inboundCtx = new DelegatingChannelHandlerContext(channelHandlerContext, this.inboundHandler) { // from class: io.netty.channel.CombinedChannelDuplexHandler.1
                @Override // io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext, io.netty.channel.ChannelInboundInvoker
                public ChannelHandlerContext fireExceptionCaught(Throwable th) {
                    if (!CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                        try {
                            CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, th);
                        } catch (Throwable th2) {
                            if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                                CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                            } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                                CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                            }
                        }
                    } else {
                        super.fireExceptionCaught(th);
                    }
                    return this;
                }
            };
            this.handlerAdded = true;
            try {
                this.inboundHandler.handlerAdded(this.inboundCtx);
                return;
            } finally {
                this.outboundHandler.handlerAdded(this.outboundCtx);
            }
        }
        throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final I inboundHandler() {
        return this.inboundHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void init(I i4, O o4) {
        validate(i4, o4);
        this.inboundHandler = i4;
        this.outboundHandler = o4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final O outboundHandler() {
        return this.outboundHandler;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.read(delegatingChannelHandlerContext);
        } else {
            delegatingChannelHandlerContext.read();
        }
    }

    public final void removeInboundHandler() {
        checkAdded();
        this.inboundCtx.remove();
    }

    public final void removeOutboundHandler() {
        checkAdded();
        this.outboundCtx.remove();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.inboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.inboundHandler.userEventTriggered(delegatingChannelHandlerContext, obj);
        } else {
            delegatingChannelHandlerContext.fireUserEventTriggered(obj);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        DelegatingChannelHandlerContext delegatingChannelHandlerContext = this.outboundCtx;
        if (!delegatingChannelHandlerContext.removed) {
            this.outboundHandler.write(delegatingChannelHandlerContext, obj, channelPromise);
        } else {
            delegatingChannelHandlerContext.write(obj, channelPromise);
        }
    }

    public CombinedChannelDuplexHandler(I i4, O o4) {
        init(i4, o4);
    }
}

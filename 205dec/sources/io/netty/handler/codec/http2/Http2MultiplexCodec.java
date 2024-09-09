package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameCodec;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Http2MultiplexCodec extends ChannelDuplexHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2MultiplexCodec.class);
    private final List<Http2StreamChannel> channelsToFireChildReadComplete = new ArrayList();
    private final IntObjectMap<Http2StreamChannel> childChannels = new IntObjectHashMap();
    private ChannelHandlerContext ctx;
    private volatile Runnable flushTask;
    private final boolean server;
    private final EventLoopGroup streamGroup;
    private final ChannelHandler streamHandler;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class Http2MultiplexCodecStreamChannel extends AbstractHttp2StreamChannel {
        Http2MultiplexCodecStreamChannel(Http2FrameCodec.DefaultHttp2FrameStream defaultHttp2FrameStream, ChannelHandler channelHandler) {
            super(defaultHttp2FrameStream, Http2MultiplexCodec.access$004(Http2MultiplexCodec.this), channelHandler);
        }

        protected void addChannelToReadCompletePendingQueue() {
            while (!Http2MultiplexCodec.access$200(Http2MultiplexCodec.this).offer(this)) {
                Http2MultiplexCodec.access$300(Http2MultiplexCodec.this);
            }
        }

        protected void flush0(ChannelHandlerContext channelHandlerContext) {
            Http2MultiplexCodec.this.flush0(channelHandlerContext);
        }

        protected boolean isParentReadInProgress() {
            return Http2MultiplexCodec.this.ctx;
        }

        protected ChannelHandlerContext parentContext() {
            return Http2MultiplexCodec.this.ctx;
        }

        protected ChannelFuture write0(ChannelHandlerContext channelHandlerContext, Object obj) {
            ChannelPromise newPromise = channelHandlerContext.newPromise();
            Http2MultiplexCodec.this.write(channelHandlerContext, obj, newPromise);
            return newPromise;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public final class Http2StreamChannel extends AbstractHttp2StreamChannel {
        boolean inStreamsToFireChildReadComplete;
        boolean onStreamClosedFired;
        private final int streamId;

        Http2StreamChannel(int i4) {
            super(Http2MultiplexCodec.this.ctx.channel());
            this.streamId = i4;
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected void bytesConsumed(int i4) {
            Http2MultiplexCodec.this.ctx.write(new DefaultHttp2WindowUpdateFrame(i4).setStreamId(this.streamId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel, io.netty.channel.AbstractChannel
        public void doClose() throws Exception {
            if (!this.onStreamClosedFired) {
                Http2MultiplexCodec.this.writeFromStreamChannel(new DefaultHttp2ResetFrame(Http2Error.CANCEL).setStreamId(this.streamId), true);
            }
            super.doClose();
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected void doWrite(Object obj) {
            if (obj instanceof Http2StreamFrame) {
                Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
                if (http2StreamFrame.streamId() == -1) {
                    http2StreamFrame.setStreamId(this.streamId);
                    Http2MultiplexCodec.this.writeFromStreamChannel(obj, false);
                    return;
                }
                ReferenceCountUtil.release(http2StreamFrame);
                throw new IllegalArgumentException("Stream must not be set on the frame");
            }
            ReferenceCountUtil.release(obj);
            throw new IllegalArgumentException("Message must be an Http2StreamFrame: " + obj);
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected void doWriteComplete() {
            Http2MultiplexCodec.this.flushFromStreamChannel();
        }

        @Override // io.netty.handler.codec.http2.AbstractHttp2StreamChannel
        protected EventExecutor preferredEventExecutor() {
            return Http2MultiplexCodec.this.ctx.executor();
        }
    }

    public Http2MultiplexCodec(boolean z3, EventLoopGroup eventLoopGroup, ChannelHandler channelHandler) {
        if (channelHandler.getClass().isAnnotationPresent(ChannelHandler.Sharable.class)) {
            this.server = z3;
            this.streamHandler = channelHandler;
            this.streamGroup = eventLoopGroup;
            return;
        }
        throw new IllegalArgumentException("streamHandler must be Sharable");
    }

    private ChannelFuture createStreamChannel(ChannelHandlerContext channelHandlerContext, int i4, ChannelHandler channelHandler) {
        EventLoopGroup eventLoopGroup = this.streamGroup;
        if (eventLoopGroup == null) {
            eventLoopGroup = channelHandlerContext.channel().eventLoop();
        }
        Http2StreamChannel http2StreamChannel = new Http2StreamChannel(i4);
        http2StreamChannel.pipeline().addLast(channelHandler);
        ChannelFuture register = eventLoopGroup.register(http2StreamChannel);
        if (register.cause() != null) {
            if (http2StreamChannel.isRegistered()) {
                http2StreamChannel.close();
            } else {
                http2StreamChannel.unsafe().closeForcibly();
            }
        }
        return register;
    }

    private void fireChildReadAndRegister(Http2StreamChannel http2StreamChannel, Http2StreamFrame http2StreamFrame) {
        http2StreamChannel.fireChildRead(http2StreamFrame);
        if (http2StreamChannel.inStreamsToFireChildReadComplete) {
            return;
        }
        this.channelsToFireChildReadComplete.add(http2StreamChannel);
        http2StreamChannel.inStreamsToFireChildReadComplete = true;
    }

    private boolean isLocalStream(int i4) {
        return i4 > 0 && this.server == ((i4 & 1) == 0);
    }

    private void onStreamActive(int i4) {
        this.childChannels.put(i4, (int) ((Http2StreamChannel) createStreamChannel(this.ctx, i4, this.streamHandler).channel()));
    }

    private void onStreamClosed(int i4) {
        final Http2StreamChannel remove = this.childChannels.remove(i4);
        if (remove != null) {
            EventLoop eventLoop = remove.eventLoop();
            if (eventLoop.inEventLoop()) {
                onStreamClosed0(remove);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.handler.codec.http2.Http2MultiplexCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Http2MultiplexCodec.this.onStreamClosed0(remove);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStreamClosed0(Http2StreamChannel http2StreamChannel) {
        http2StreamChannel.onStreamClosedFired = true;
        http2StreamChannel.fireChildRead(AbstractHttp2StreamChannel.CLOSE_MESSAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeFromStreamChannel0(Object obj, boolean z3, ChannelPromise channelPromise) {
        try {
            write(this.ctx, obj, channelPromise);
        } catch (Throwable th) {
            channelPromise.tryFailure(th);
        }
        if (z3) {
            flush(this.ctx);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof Http2Frame)) {
            channelHandlerContext.fireChannelRead(obj);
        } else if (obj instanceof Http2StreamFrame) {
            Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
            int streamId = http2StreamFrame.streamId();
            Http2StreamChannel http2StreamChannel = this.childChannels.get(streamId);
            if (http2StreamChannel != null) {
                fireChildReadAndRegister(http2StreamChannel, http2StreamFrame);
            } else {
                ReferenceCountUtil.release(obj);
                throw new Http2Exception.StreamException(streamId, Http2Error.STREAM_CLOSED, String.format("Received %s frame for an unknown stream %d", http2StreamFrame.name(), Integer.valueOf(streamId)));
            }
        } else if (obj instanceof Http2GoAwayFrame) {
            Http2GoAwayFrame http2GoAwayFrame = (Http2GoAwayFrame) obj;
            for (IntObjectMap.PrimitiveEntry<Http2StreamChannel> primitiveEntry : this.childChannels.entries()) {
                Http2StreamChannel value = primitiveEntry.value();
                int key = primitiveEntry.key();
                if (key > http2GoAwayFrame.lastStreamId() && isLocalStream(key)) {
                    value.pipeline().fireUserEventTriggered((Object) http2GoAwayFrame.retainedDuplicate());
                }
            }
            http2GoAwayFrame.release();
        } else {
            ReferenceCountUtil.release(obj);
            throw new UnsupportedMessageTypeException(obj, new Class[0]);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        for (int i4 = 0; i4 < this.channelsToFireChildReadComplete.size(); i4++) {
            Http2StreamChannel http2StreamChannel = this.channelsToFireChildReadComplete.get(i4);
            http2StreamChannel.inStreamsToFireChildReadComplete = false;
            http2StreamChannel.fireChildReadComplete();
        }
        this.channelsToFireChildReadComplete.clear();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (!(th instanceof Http2Exception.StreamException)) {
            channelHandlerContext.fireExceptionCaught(th);
            return;
        }
        Http2Exception.StreamException streamException = (Http2Exception.StreamException) th;
        try {
            Http2StreamChannel http2StreamChannel = this.childChannels.get(streamException.streamId());
            if (http2StreamChannel != null) {
                http2StreamChannel.pipeline().fireExceptionCaught((Throwable) streamException);
            } else {
                logger.warn(String.format("Exception caught for unknown HTTP/2 stream '%d'", Integer.valueOf(streamException.streamId())), (Throwable) streamException);
            }
        } finally {
            onStreamClosed(streamException.streamId());
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    void flushFromStreamChannel() {
        EventExecutor executor = this.ctx.executor();
        if (executor.inEventLoop()) {
            flush(this.ctx);
            return;
        }
        Runnable runnable = this.flushTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.handler.codec.http2.Http2MultiplexCodec.2
                @Override // java.lang.Runnable
                public void run() {
                    Http2MultiplexCodec http2MultiplexCodec = Http2MultiplexCodec.this;
                    http2MultiplexCodec.flush(http2MultiplexCodec.ctx);
                }
            };
            this.flushTask = runnable;
        }
        executor.execute(runnable);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof Http2StreamStateEvent)) {
            channelHandlerContext.fireUserEventTriggered(obj);
            return;
        }
        try {
            int streamId = ((Http2StreamStateEvent) obj).streamId();
            if (obj instanceof Http2StreamActiveEvent) {
                onStreamActive(streamId);
            } else if (obj instanceof Http2StreamClosedEvent) {
                onStreamClosed(streamId);
            } else {
                throw new UnsupportedMessageTypeException(obj, new Class[0]);
            }
        } finally {
            ReferenceCountUtil.release(obj);
        }
    }

    void writeFromStreamChannel(final Object obj, final boolean z3) {
        final ChannelPromise newPromise = this.ctx.newPromise();
        EventExecutor executor = this.ctx.executor();
        if (executor.inEventLoop()) {
            writeFromStreamChannel0(obj, z3, newPromise);
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.netty.handler.codec.http2.Http2MultiplexCodec.3
                @Override // java.lang.Runnable
                public void run() {
                    Http2MultiplexCodec.this.writeFromStreamChannel0(obj, z3, newPromise);
                }
            });
        } catch (Throwable th) {
            newPromise.setFailure(th);
        }
    }
}

package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.util.ReferenceCountUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Http2FrameCodec extends ChannelDuplexHandler {
    private static final Http2FrameLogger HTTP2_FRAME_LOGGER = new Http2FrameLogger(LogLevel.INFO, Http2FrameCodec.class);
    private ChannelHandlerContext ctx;
    private final Http2ConnectionHandler http2Handler;
    private ChannelHandlerContext http2HandlerCtx;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class ConnectionListener extends Http2ConnectionAdapter {
        private ConnectionListener() {
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onGoAwayReceived(int i, long j, ByteBuf byteBuf) {
            Http2FrameCodec.this.ctx.fireChannelRead((Object) new DefaultHttp2GoAwayFrame(i, j, byteBuf));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamActive(Http2Stream http2Stream) {
            if (Http2FrameCodec.this.ctx == null) {
                return;
            }
            Http2FrameCodec.this.ctx.fireUserEventTriggered((Object) new Http2StreamActiveEvent(http2Stream.mo12684id()));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamClosed(Http2Stream http2Stream) {
            Http2FrameCodec.this.ctx.fireUserEventTriggered((Object) new Http2StreamClosedEvent(http2Stream.mo12684id()));
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class FrameListener extends Http2FrameAdapter {
        private FrameListener() {
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) {
            DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(byteBuf.retain(), z, i2);
            defaultHttp2DataFrame.setStreamId(i);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2DataFrame);
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) {
            onHeadersRead(channelHandlerContext, i, http2Headers, i3, z2);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) {
            DefaultHttp2ResetFrame defaultHttp2ResetFrame = new DefaultHttp2ResetFrame(j);
            defaultHttp2ResetFrame.setStreamId(i);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2ResetFrame);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) {
            DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(http2Headers, z, i2);
            defaultHttp2HeadersFrame.setStreamId(i);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2HeadersFrame);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class InternalHttp2ConnectionHandler extends Http2ConnectionHandler {
        InternalHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
            super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
        public void onStreamError(ChannelHandlerContext channelHandlerContext, Throwable th, Http2Exception.StreamException streamException) {
            try {
                if (connection().stream(streamException.streamId()) == null) {
                    return;
                }
                channelHandlerContext.fireExceptionCaught((Throwable) streamException);
            } finally {
                super.onStreamError(channelHandlerContext, th, streamException);
            }
        }
    }

    public Http2FrameCodec(boolean z) {
        this(z, new DefaultHttp2FrameWriter());
    }

    private void consumeBytes(int i, int i2, ChannelPromise channelPromise) {
        try {
            this.http2Handler.connection().local().flowController().consumeBytes(this.http2Handler.connection().stream(i), i2);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    private void writeGoAwayFrame(Http2GoAwayFrame http2GoAwayFrame, ChannelPromise channelPromise) {
        if (http2GoAwayFrame.lastStreamId() <= -1) {
            int lastStreamCreated = this.http2Handler.connection().remote().lastStreamCreated();
            int extraStreamIds = (http2GoAwayFrame.extraStreamIds() * 2) + lastStreamCreated;
            this.http2Handler.goAway(this.http2HandlerCtx, extraStreamIds < lastStreamCreated ? Integer.MAX_VALUE : extraStreamIds, http2GoAwayFrame.errorCode(), http2GoAwayFrame.content().retain(), channelPromise);
            return;
        }
        throw new IllegalArgumentException("Last stream id must not be set on GOAWAY frame");
    }

    private void writeStreamFrame(Http2StreamFrame http2StreamFrame, ChannelPromise channelPromise) {
        int streamId = http2StreamFrame.streamId();
        if (http2StreamFrame instanceof Http2DataFrame) {
            Http2DataFrame http2DataFrame = (Http2DataFrame) http2StreamFrame;
            this.http2Handler.encoder().writeData(this.http2HandlerCtx, streamId, http2DataFrame.content().retain(), http2DataFrame.padding(), http2DataFrame.isEndStream(), channelPromise);
        } else if (http2StreamFrame instanceof Http2HeadersFrame) {
            Http2HeadersFrame http2HeadersFrame = (Http2HeadersFrame) http2StreamFrame;
            this.http2Handler.encoder().writeHeaders(this.http2HandlerCtx, streamId, http2HeadersFrame.headers(), http2HeadersFrame.padding(), http2HeadersFrame.isEndStream(), channelPromise);
        } else if (http2StreamFrame instanceof Http2ResetFrame) {
            this.http2Handler.resetStream(this.http2HandlerCtx, streamId, ((Http2ResetFrame) http2StreamFrame).errorCode(), channelPromise);
        } else {
            throw new UnsupportedMessageTypeException(http2StreamFrame, new Class[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2ConnectionHandler connectionHandler() {
        return this.http2Handler;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.executor(), channelHandlerContext.name(), null, this.http2Handler);
        this.http2HandlerCtx = channelHandlerContext.pipeline().context(this.http2Handler);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().remove(this.http2Handler);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof HttpServerUpgradeHandler.UpgradeEvent)) {
            super.userEventTriggered(channelHandlerContext, obj);
            return;
        }
        HttpServerUpgradeHandler.UpgradeEvent upgradeEvent = (HttpServerUpgradeHandler.UpgradeEvent) obj;
        channelHandlerContext.fireUserEventTriggered((Object) upgradeEvent.retain());
        try {
            new ConnectionListener().onStreamActive(this.http2Handler.connection().stream(1));
            upgradeEvent.upgradeRequest().headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), 1);
            new InboundHttpToHttp2Adapter(this.http2Handler.connection(), this.http2Handler.decoder().frameListener()).channelRead(channelHandlerContext, upgradeEvent.upgradeRequest().retain());
        } finally {
            upgradeEvent.release();
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (!(obj instanceof Http2Frame)) {
            channelHandlerContext.write(obj, channelPromise);
            return;
        }
        try {
            if (obj instanceof Http2WindowUpdateFrame) {
                Http2WindowUpdateFrame http2WindowUpdateFrame = (Http2WindowUpdateFrame) obj;
                consumeBytes(http2WindowUpdateFrame.streamId(), http2WindowUpdateFrame.windowSizeIncrement(), channelPromise);
            } else if (obj instanceof Http2StreamFrame) {
                writeStreamFrame((Http2StreamFrame) obj, channelPromise);
            } else if (obj instanceof Http2GoAwayFrame) {
                writeGoAwayFrame((Http2GoAwayFrame) obj, channelPromise);
            } else {
                throw new UnsupportedMessageTypeException(obj, new Class[0]);
            }
        } finally {
            ReferenceCountUtil.release(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2FrameCodec(boolean z, Http2FrameWriter http2FrameWriter) {
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(z);
        Http2FrameLogger http2FrameLogger = HTTP2_FRAME_LOGGER;
        DefaultHttp2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, new Http2OutboundFrameLogger(http2FrameWriter, http2FrameLogger));
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, defaultHttp2ConnectionEncoder, new Http2InboundFrameLogger(new DefaultHttp2FrameReader(), http2FrameLogger));
        defaultHttp2ConnectionDecoder.frameListener(new FrameListener());
        InternalHttp2ConnectionHandler internalHttp2ConnectionHandler = new InternalHttp2ConnectionHandler(defaultHttp2ConnectionDecoder, defaultHttp2ConnectionEncoder, new Http2Settings());
        this.http2Handler = internalHttp2ConnectionHandler;
        internalHttp2ConnectionHandler.connection().addListener(new ConnectionListener());
    }
}

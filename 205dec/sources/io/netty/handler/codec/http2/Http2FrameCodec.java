package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.util.ReferenceCountUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Http2FrameCodec extends ChannelDuplexHandler {
    private static final Http2FrameLogger HTTP2_FRAME_LOGGER = new Http2FrameLogger(LogLevel.INFO, Http2FrameCodec.class);
    private ChannelHandlerContext ctx;
    private final Http2ConnectionHandler http2Handler;
    private ChannelHandlerContext http2HandlerCtx;

    /* renamed from: io.netty.handler.codec.http2.Http2FrameCodec$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass2 implements Http2StreamVisitor {
        final /* synthetic */ Http2FrameStreamVisitor val$streamVisitor;

        AnonymousClass2(Http2FrameStreamVisitor http2FrameStreamVisitor) {
            this.val$streamVisitor = http2FrameStreamVisitor;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [io.netty.handler.codec.http2.Http2FrameCodec, io.netty.handler.codec.http2.Http2ConnectionHandler] */
        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) {
            try {
                return this.val$streamVisitor.visit((Http2FrameStream) http2Stream.getProperty(Http2FrameCodec.this.streamKey));
            } catch (Throwable th) {
                ?? r02 = Http2FrameCodec.this;
                r02.onError(((Http2FrameCodec) r02).ctx, false, th);
                return false;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class ConnectionListener extends Http2ConnectionAdapter {
        private ConnectionListener() {
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onGoAwayReceived(int i4, long j4, ByteBuf byteBuf) {
            Http2FrameCodec.this.ctx.fireChannelRead((Object) new DefaultHttp2GoAwayFrame(i4, j4, byteBuf));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamActive(Http2Stream http2Stream) {
            if (Http2FrameCodec.this.ctx == null) {
                return;
            }
            Http2FrameCodec.this.ctx.fireUserEventTriggered((Object) new Http2StreamActiveEvent(http2Stream.id()));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamClosed(Http2Stream http2Stream) {
            Http2FrameCodec.this.ctx.fireUserEventTriggered((Object) new Http2StreamClosedEvent(http2Stream.id()));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class DefaultHttp2FrameStream implements Http2FrameStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        Channel attachment;
        volatile Http2Stream stream;
        private volatile int id = -1;
        final Http2FrameStreamEvent stateChanged = Http2FrameStreamEvent.stateChanged(this);
        final Http2FrameStreamEvent writabilityChanged = Http2FrameStreamEvent.writabilityChanged(this);

        DefaultHttp2FrameStream() {
        }

        @Override // io.netty.handler.codec.http2.Http2FrameStream
        public int id() {
            Http2Stream http2Stream = this.stream;
            return http2Stream == null ? this.id : http2Stream.id();
        }

        DefaultHttp2FrameStream setStreamAndProperty(Http2Connection.PropertyKey propertyKey, Http2Stream http2Stream) {
            this.stream = http2Stream;
            http2Stream.setProperty(propertyKey, this);
            return this;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameStream
        public Http2Stream.State state() {
            Http2Stream http2Stream = this.stream;
            return http2Stream == null ? Http2Stream.State.IDLE : http2Stream.state();
        }

        public String toString() {
            return String.valueOf(id());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class FrameListener extends Http2FrameAdapter {
        private FrameListener() {
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i4, ByteBuf byteBuf, int i5, boolean z3) {
            DefaultHttp2DataFrame defaultHttp2DataFrame = new DefaultHttp2DataFrame(byteBuf.retain(), z3, i5);
            defaultHttp2DataFrame.setStreamId(i4);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2DataFrame);
            return 0;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, short s3, boolean z3, int i6, boolean z4) {
            onHeadersRead(channelHandlerContext, i4, http2Headers, i6, z4);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i4, long j4) {
            DefaultHttp2ResetFrame defaultHttp2ResetFrame = new DefaultHttp2ResetFrame(j4);
            defaultHttp2ResetFrame.setStreamId(i4);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2ResetFrame);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i4, Http2Headers http2Headers, int i5, boolean z3) {
            DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = new DefaultHttp2HeadersFrame(http2Headers, z3, i5);
            defaultHttp2HeadersFrame.setStreamId(i4);
            channelHandlerContext.fireChannelRead((Object) defaultHttp2HeadersFrame);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private final class Http2RemoteFlowControllerListener implements Http2RemoteFlowController.Listener {
        private Http2RemoteFlowControllerListener() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [io.netty.handler.codec.http2.Http2FrameCodec, io.netty.handler.codec.http2.Http2ConnectionHandler] */
        @Override // io.netty.handler.codec.http2.Http2RemoteFlowController.Listener
        public void writabilityChanged(Http2Stream http2Stream) {
            DefaultHttp2FrameStream defaultHttp2FrameStream = (DefaultHttp2FrameStream) http2Stream.getProperty(Http2FrameCodec.this.streamKey);
            if (defaultHttp2FrameStream == null) {
                return;
            }
            ?? r12 = Http2FrameCodec.this;
            Http2FrameCodec.access$700(r12, ((Http2FrameCodec) r12).ctx, defaultHttp2FrameStream, r12.connection().remote().flowController().isWritable(http2Stream));
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    public Http2FrameCodec(boolean z3) {
        this(z3, new DefaultHttp2FrameWriter());
    }

    private void consumeBytes(int i4, int i5, ChannelPromise channelPromise) {
        try {
            this.http2Handler.connection().local().flowController().consumeBytes(this.http2Handler.connection().stream(i4), i5);
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
    public Http2FrameCodec(boolean z3, Http2FrameWriter http2FrameWriter) {
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(z3);
        Http2FrameLogger http2FrameLogger = HTTP2_FRAME_LOGGER;
        DefaultHttp2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, new Http2OutboundFrameLogger(http2FrameWriter, http2FrameLogger));
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, defaultHttp2ConnectionEncoder, new Http2InboundFrameLogger(new DefaultHttp2FrameReader(), http2FrameLogger));
        defaultHttp2ConnectionDecoder.frameListener(new FrameListener());
        InternalHttp2ConnectionHandler internalHttp2ConnectionHandler = new InternalHttp2ConnectionHandler(defaultHttp2ConnectionDecoder, defaultHttp2ConnectionEncoder, new Http2Settings());
        this.http2Handler = internalHttp2ConnectionHandler;
        internalHttp2ConnectionHandler.connection().addListener(new ConnectionListener());
    }
}

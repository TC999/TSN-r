package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Http2ConnectionHandler extends ByteToMessageDecoder implements Http2LifecycleManager, ChannelOutboundHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2ConnectionHandler.class);
    private BaseDecoder byteDecoder;
    private ChannelFutureListener closeListener;
    private final Http2ConnectionDecoder decoder;
    private final Http2ConnectionEncoder encoder;
    private long gracefulShutdownTimeoutMillis;
    private final Http2Settings initialSettings;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.Http2ConnectionHandler$4 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138604 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$http2$Http2Exception$ShutdownHint */
        static final /* synthetic */ int[] f40236x6c636e3a;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Exception.ShutdownHint.values().length];
            f40236x6c636e3a = iArr;
            try {
                iArr[Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr2;
            try {
                iArr2[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public abstract class BaseDecoder {
        private BaseDecoder() {
        }

        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            Http2ConnectionHandler.this.encoder().close();
            Http2ConnectionHandler.this.decoder().close();
            Http2ConnectionHandler.this.connection().close(channelHandlerContext.voidPromise());
        }

        public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        }

        public boolean prefaceSent() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ClosingChannelFutureListener implements ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;
        private final ScheduledFuture<?> timeoutTask;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = null;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            ScheduledFuture<?> scheduledFuture = this.timeoutTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.ctx.close(this.promise);
        }

        ClosingChannelFutureListener(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise, long j, TimeUnit timeUnit) {
            this.ctx = channelHandlerContext;
            this.promise = channelPromise;
            this.timeoutTask = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.ClosingChannelFutureListener.1
                @Override // java.lang.Runnable
                public void run() {
                    channelHandlerContext.close(channelPromise);
                }
            }, j, timeUnit);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class FrameDecoder extends BaseDecoder {
        private FrameDecoder() {
            super();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                Http2ConnectionHandler.this.decoder.decodeFrame(channelHandlerContext, byteBuf, list);
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, th);
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class PrefaceDecoder extends BaseDecoder {
        private ByteBuf clientPrefaceString;
        private boolean prefaceSent;

        public PrefaceDecoder(ChannelHandlerContext channelHandlerContext) {
            super();
            this.clientPrefaceString = Http2ConnectionHandler.clientPrefaceString(Http2ConnectionHandler.this.encoder.connection());
            sendPreface(channelHandlerContext);
        }

        private void cleanup() {
            ByteBuf byteBuf = this.clientPrefaceString;
            if (byteBuf != null) {
                byteBuf.release();
                this.clientPrefaceString = null;
            }
        }

        private boolean readClientPrefaceString(ByteBuf byteBuf) throws Http2Exception {
            ByteBuf byteBuf2 = this.clientPrefaceString;
            if (byteBuf2 == null) {
                return true;
            }
            int min = Math.min(byteBuf.readableBytes(), byteBuf2.readableBytes());
            if (min != 0) {
                int readerIndex = byteBuf.readerIndex();
                ByteBuf byteBuf3 = this.clientPrefaceString;
                if (ByteBufUtil.equals(byteBuf, readerIndex, byteBuf3, byteBuf3.readerIndex(), min)) {
                    byteBuf.skipBytes(min);
                    this.clientPrefaceString.skipBytes(min);
                    if (this.clientPrefaceString.isReadable()) {
                        return false;
                    }
                    this.clientPrefaceString.release();
                    this.clientPrefaceString = null;
                    return true;
                }
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP/2 client preface string missing or corrupt. Hex dump for received bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), Math.min(byteBuf.readableBytes(), this.clientPrefaceString.readableBytes())));
        }

        private void sendPreface(ChannelHandlerContext channelHandlerContext) {
            if (this.prefaceSent || !channelHandlerContext.channel().isActive()) {
                return;
            }
            this.prefaceSent = true;
            if (!Http2ConnectionHandler.this.connection().isServer()) {
                channelHandlerContext.write(Http2CodecUtil.connectionPrefaceBuf()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
            }
            Http2ConnectionHandler.this.encoder.writeSettings(channelHandlerContext, Http2ConnectionHandler.this.initialSettings, channelHandlerContext.newPromise()).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
        }

        private boolean verifyFirstFrameIsSettings(ByteBuf byteBuf) throws Http2Exception {
            if (byteBuf.readableBytes() < 5) {
                return false;
            }
            short unsignedByte = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 3);
            short unsignedByte2 = byteBuf.getUnsignedByte(byteBuf.readerIndex() + 4);
            if (unsignedByte == 4 && (unsignedByte2 & 1) == 0) {
                return true;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "First received frame was not SETTINGS. Hex dump for first 5 bytes: %s", ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), 5));
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            sendPreface(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
            super.channelInactive(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            try {
                if (channelHandlerContext.channel().isActive() && readClientPrefaceString(byteBuf) && verifyFirstFrameIsSettings(byteBuf)) {
                    Http2ConnectionHandler http2ConnectionHandler = Http2ConnectionHandler.this;
                    http2ConnectionHandler.byteDecoder = new FrameDecoder();
                    Http2ConnectionHandler.this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
                }
            } catch (Throwable th) {
                Http2ConnectionHandler.this.onError(channelHandlerContext, th);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
            cleanup();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionHandler.BaseDecoder
        public boolean prefaceSent() {
            return this.prefaceSent;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Http2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "initialSettings");
        this.decoder = (Http2ConnectionDecoder) ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        if (http2ConnectionEncoder.connection() != http2ConnectionDecoder.connection()) {
            throw new IllegalArgumentException("Encoder and Decoder do not share the same connection object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCloseConnection(ChannelFuture channelFuture) {
        if (this.closeListener == null || !isGracefulShutdownComplete()) {
            return;
        }
        ChannelFutureListener channelFutureListener = this.closeListener;
        this.closeListener = null;
        try {
            channelFutureListener.operationComplete(channelFuture);
        } catch (Exception e) {
            throw new IllegalStateException("Close listener threw an unexpected exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteBuf clientPrefaceString(Http2Connection http2Connection) {
        if (http2Connection.isServer()) {
            return Http2CodecUtil.connectionPrefaceBuf();
        }
        return null;
    }

    private void doGracefulShutdown(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, ChannelPromise channelPromise) {
        if (isGracefulShutdownComplete()) {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ClosingChannelFutureListener(channelHandlerContext, channelPromise));
        } else {
            this.closeListener = new ClosingChannelFutureListener(channelHandlerContext, channelPromise, this.gracefulShutdownTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private boolean prefaceSent() {
        BaseDecoder baseDecoder = this.byteDecoder;
        return baseDecoder != null && baseDecoder.prefaceSent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processGoAwayWriteResult(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelFuture channelFuture) {
        try {
            if (channelFuture.isSuccess()) {
                if (j != Http2Error.NO_ERROR.code()) {
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("{} Sent GOAWAY: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                    }
                    channelHandlerContext.close();
                }
            } else {
                InternalLogger internalLogger2 = logger;
                if (internalLogger2.isDebugEnabled()) {
                    internalLogger2.debug("{} Sending GOAWAY failed: lastStreamId '{}', errorCode '{}', debugData '{}'. Forcing shutdown of the connection.", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j), byteBuf.toString(CharsetUtil.UTF_8), channelFuture.cause());
                }
                channelHandlerContext.close();
            }
        } finally {
            byteBuf.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRstStreamWriteResult(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, ChannelFuture channelFuture) {
        if (channelFuture.isSuccess()) {
            closeStream(http2Stream, channelFuture);
        } else {
            onConnectionError(channelHandlerContext, channelFuture.cause(), null);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.byteDecoder == null) {
            this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
        }
        this.byteDecoder.channelActive(channelHandlerContext);
        super.channelActive(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelInactive(channelHandlerContext);
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.channelInactive(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            flush(channelHandlerContext);
        } finally {
            super.channelReadComplete(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            if (channelHandlerContext.channel().isWritable()) {
                flush(channelHandlerContext);
            }
            this.encoder.flowController().channelWritabilityChanged();
        } finally {
            super.channelWritabilityChanged(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        if (!channelHandlerContext.channel().isActive()) {
            channelHandlerContext.close(channelPromise);
            return;
        }
        ChannelFuture write = connection().goAwaySent() ? channelHandlerContext.write(Unpooled.EMPTY_BUFFER) : goAway(channelHandlerContext, null);
        channelHandlerContext.flush();
        doGracefulShutdown(channelHandlerContext, write, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStream(Http2Stream http2Stream, ChannelFuture channelFuture) {
        http2Stream.close();
        if (channelFuture.isDone()) {
            checkCloseConnection(channelFuture);
        } else {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    Http2ConnectionHandler.this.checkCloseConnection(channelFuture2);
                }
            });
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i = C138604.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i != 1 && i != 2) {
            closeStream(http2Stream, channelFuture);
        } else {
            http2Stream.closeLocalSide();
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture) {
        int i = C138604.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
        if (i != 2 && i != 3) {
            closeStream(http2Stream, channelFuture);
        } else {
            http2Stream.closeRemoteSide();
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public Http2Connection connection() {
        return this.encoder.connection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        this.byteDecoder.decode(channelHandlerContext, byteBuf, list);
    }

    public Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th) != null) {
            onError(channelHandlerContext, th);
        } else {
            super.exceptionCaught(channelHandlerContext, th);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.encoder.flowController().writePendingBytes();
        try {
            channelHandlerContext.flush();
        } catch (Throwable th) {
            throw new Http2Exception(Http2Error.INTERNAL_ERROR, "Error flushing", th);
        }
    }

    protected Http2FrameWriter frameWriter() {
        return encoder().frameWriter();
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture goAway(final ChannelHandlerContext channelHandlerContext, final int i, final long j, final ByteBuf byteBuf, ChannelPromise channelPromise) {
        try {
            Http2Connection connection = connection();
            if (connection.goAwaySent() && i > connection.remote().lastStreamKnownByPeer()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Last stream identifier must not increase between sending multiple GOAWAY frames (was '%d', is '%d').", Integer.valueOf(connection.remote().lastStreamKnownByPeer()), Integer.valueOf(i));
            }
            connection.goAwaySent(i, j, byteBuf);
            byteBuf.retain();
            ChannelFuture writeGoAway = frameWriter().writeGoAway(channelHandlerContext, i, j, byteBuf, channelPromise);
            if (writeGoAway.isDone()) {
                processGoAwayWriteResult(channelHandlerContext, i, j, byteBuf, writeGoAway);
            } else {
                writeGoAway.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        Http2ConnectionHandler.processGoAwayWriteResult(channelHandlerContext, i, j, byteBuf, channelFuture);
                    }
                });
            }
            return writeGoAway;
        } catch (Throwable th) {
            byteBuf.release();
            return channelPromise.setFailure(th);
        }
    }

    public long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.lifecycleManager(this);
        this.decoder.lifecycleManager(this);
        this.encoder.flowController().channelHandlerContext(channelHandlerContext);
        this.decoder.flowController().channelHandlerContext(channelHandlerContext);
        this.byteDecoder = new PrefaceDecoder(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        BaseDecoder baseDecoder = this.byteDecoder;
        if (baseDecoder != null) {
            baseDecoder.handlerRemoved(channelHandlerContext);
            this.byteDecoder = null;
        }
    }

    protected boolean isGracefulShutdownComplete() {
        return connection().numActiveStreams() == 0;
    }

    protected void onConnectionError(ChannelHandlerContext channelHandlerContext, Throwable th, Http2Exception http2Exception) {
        if (http2Exception == null) {
            http2Exception = new Http2Exception(Http2Error.INTERNAL_ERROR, th.getMessage(), th);
        }
        ChannelPromise newPromise = channelHandlerContext.newPromise();
        ChannelFuture goAway = goAway(channelHandlerContext, http2Exception);
        if (C138604.f40236x6c636e3a[http2Exception.shutdownHint().ordinal()] != 1) {
            goAway.addListener((GenericFutureListener<? extends Future<? super Void>>) new ClosingChannelFutureListener(channelHandlerContext, newPromise));
        } else {
            doGracefulShutdown(channelHandlerContext, goAway, newPromise);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public void onError(ChannelHandlerContext channelHandlerContext, Throwable th) {
        Http2Exception embeddedHttp2Exception = Http2CodecUtil.getEmbeddedHttp2Exception(th);
        if (Http2Exception.isStreamError(embeddedHttp2Exception)) {
            onStreamError(channelHandlerContext, th, (Http2Exception.StreamException) embeddedHttp2Exception);
        } else if (embeddedHttp2Exception instanceof Http2Exception.CompositeStreamException) {
            Iterator<Http2Exception.StreamException> it = ((Http2Exception.CompositeStreamException) embeddedHttp2Exception).iterator();
            while (it.hasNext()) {
                onStreamError(channelHandlerContext, th, it.next());
            }
        } else {
            onConnectionError(channelHandlerContext, th, embeddedHttp2Exception);
        }
        channelHandlerContext.flush();
    }

    public void onHttpClientUpgrade() throws Http2Exception {
        if (!connection().isServer()) {
            if (!prefaceSent() && !this.decoder.prefaceReceived()) {
                connection().local().createStream(1, true);
                return;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is sent or received", new Object[0]);
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Client-side HTTP upgrade requested for a server", new Object[0]);
    }

    public void onHttpServerUpgrade(Http2Settings http2Settings) throws Http2Exception {
        if (connection().isServer()) {
            if (!prefaceSent() && !this.decoder.prefaceReceived()) {
                this.encoder.remoteSettings(http2Settings);
                connection().remote().createStream(1, true);
                return;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "HTTP upgrade must occur before HTTP/2 preface is sent or received", new Object[0]);
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server-side HTTP upgrade requested for a client", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStreamError(ChannelHandlerContext channelHandlerContext, Throwable th, Http2Exception.StreamException streamException) {
        resetStream(channelHandlerContext, streamException.streamId(), streamException.error().code(), channelHandlerContext.newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.read();
    }

    @Override // io.netty.handler.codec.http2.Http2LifecycleManager
    public ChannelFuture resetStream(final ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        ChannelFuture writeRstStream;
        final Http2Stream stream = connection().stream(i);
        if (stream != null && !stream.isResetSent()) {
            if (stream.state() == Http2Stream.State.IDLE) {
                writeRstStream = channelPromise.setSuccess();
            } else {
                writeRstStream = frameWriter().writeRstStream(channelHandlerContext, i, j, channelPromise);
            }
            stream.resetSent();
            if (writeRstStream.isDone()) {
                processRstStreamWriteResult(channelHandlerContext, stream, writeRstStream);
            } else {
                writeRstStream.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2ConnectionHandler.2
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        Http2ConnectionHandler.this.processRstStreamWriteResult(channelHandlerContext, stream, channelFuture);
                    }
                });
            }
            return writeRstStream;
        }
        return channelPromise.setSuccess();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }

    public void gracefulShutdownTimeoutMillis(long j) {
        if (j >= 0) {
            this.gracefulShutdownTimeoutMillis = j;
            return;
        }
        throw new IllegalArgumentException("gracefulShutdownTimeoutMillis: " + j + " (expected: >= 0)");
    }

    private ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, Http2Exception http2Exception) {
        return goAway(channelHandlerContext, connection().remote().lastStreamCreated(), (http2Exception != null ? http2Exception.error() : Http2Error.NO_ERROR).code(), Http2CodecUtil.toByteBuf(channelHandlerContext, http2Exception), channelHandlerContext.newPromise());
    }
}

package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultHttp2ConnectionDecoder implements Http2ConnectionDecoder {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultHttp2ConnectionDecoder.class);
    private final Http2Connection connection;
    private final Http2ConnectionEncoder encoder;
    private final Http2FrameReader frameReader;
    private Http2FrameListener internalFrameListener;
    private Http2LifecycleManager lifecycleManager;
    private Http2FrameListener listener;
    private final Http2PromisedRequestVerifier requestVerifier;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138391 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State;

        static {
            int[] iArr = new int[Http2Stream.State.values().length];
            $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State = iArr;
            try {
                iArr[Http2Stream.State.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.HALF_CLOSED_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.RESERVED_REMOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[Http2Stream.State.IDLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class FrameReadListener implements Http2FrameListener {
        private FrameReadListener() {
        }

        private void applyLocalSettings(Http2Settings http2Settings) throws Http2Exception {
            Boolean pushEnabled = http2Settings.pushEnabled();
            Http2FrameReader.Configuration configuration = DefaultHttp2ConnectionDecoder.this.frameReader.configuration();
            Http2HeaderTable headerTable = configuration.headerTable();
            Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
            if (pushEnabled != null) {
                if (!DefaultHttp2ConnectionDecoder.this.connection.isServer()) {
                    DefaultHttp2ConnectionDecoder.this.connection.local().allowPushTo(pushEnabled.booleanValue());
                } else {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Server sending SETTINGS frame with ENABLE_PUSH specified", new Object[0]);
                }
            }
            Long maxConcurrentStreams = http2Settings.maxConcurrentStreams();
            if (maxConcurrentStreams != null) {
                int min = (int) Math.min(maxConcurrentStreams.longValue(), 2147483647L);
                DefaultHttp2ConnectionDecoder.this.connection.remote().maxStreams(min, calculateMaxStreams(min));
            }
            Long headerTableSize = http2Settings.headerTableSize();
            if (headerTableSize != null) {
                headerTable.maxHeaderTableSize((int) Math.min(headerTableSize.longValue(), 2147483647L));
            }
            Integer maxHeaderListSize = http2Settings.maxHeaderListSize();
            if (maxHeaderListSize != null) {
                headerTable.maxHeaderListSize(maxHeaderListSize.intValue());
            }
            Integer maxFrameSize = http2Settings.maxFrameSize();
            if (maxFrameSize != null) {
                frameSizePolicy.maxFrameSize(maxFrameSize.intValue());
            }
            Integer initialWindowSize = http2Settings.initialWindowSize();
            if (initialWindowSize != null) {
                DefaultHttp2ConnectionDecoder.this.flowController().initialWindowSize(initialWindowSize.intValue());
            }
        }

        private boolean shouldIgnoreHeadersOrDataFrame(ChannelHandlerContext channelHandlerContext, int i, Http2Stream http2Stream, String str) throws Http2Exception {
            String str2;
            if (http2Stream == null) {
                if (streamCreatedAfterGoAwaySent(i)) {
                    DefaultHttp2ConnectionDecoder.logger.info("{} ignoring {} frame for stream {}. Stream sent after GOAWAY sent", channelHandlerContext.channel(), str, Integer.valueOf(i));
                    return true;
                }
                throw Http2Exception.streamError(i, Http2Error.STREAM_CLOSED, "Received %s frame for an unknown stream %d", str, Integer.valueOf(i));
            } else if (http2Stream.isResetSent() || streamCreatedAfterGoAwaySent(i)) {
                if (DefaultHttp2ConnectionDecoder.logger.isInfoEnabled()) {
                    InternalLogger internalLogger = DefaultHttp2ConnectionDecoder.logger;
                    Object[] objArr = new Object[3];
                    objArr[0] = channelHandlerContext.channel();
                    objArr[1] = str;
                    if (http2Stream.isResetSent()) {
                        str2 = "RST_STREAM sent.";
                    } else {
                        str2 = "Stream created after GOAWAY sent. Last known stream by peer " + DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer();
                    }
                    objArr[2] = str2;
                    internalLogger.info("{} ignoring {} frame for stream {} {}", objArr);
                }
                return true;
            } else {
                return false;
            }
        }

        private boolean streamCreatedAfterGoAwaySent(int i) {
            Http2Connection.Endpoint<Http2RemoteFlowController> remote = DefaultHttp2ConnectionDecoder.this.connection.remote();
            return DefaultHttp2ConnectionDecoder.this.connection.goAwaySent() && remote.isValidStreamId(i) && i > remote.lastStreamKnownByPeer();
        }

        private void verifyStreamMayHaveExisted(int i) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i));
            }
        }

        protected int calculateMaxStreams(int i) {
            int i2 = i + 100;
            if (i2 < 0) {
                return Integer.MAX_VALUE;
            }
            return i2;
        }

        /* JADX WARN: Finally extract failed */
        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            int unconsumedBytes;
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            Http2LocalFlowController flowController = DefaultHttp2ConnectionDecoder.this.flowController();
            int readableBytes = byteBuf.readableBytes() + i2;
            try {
                if (!shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, stream, "DATA")) {
                    Http2Exception http2Exception = null;
                    int i3 = C138391.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3 && i3 != 4) {
                            http2Exception = Http2Exception.streamError(stream.mo12684id(), Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(stream.mo12684id()), stream.state());
                        } else {
                            http2Exception = Http2Exception.streamError(stream.mo12684id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(stream.mo12684id()), stream.state());
                        }
                    }
                    int unconsumedBytes2 = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                    try {
                        try {
                            flowController.receiveFlowControlledFrame(stream, byteBuf, i2, z);
                            unconsumedBytes = DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream);
                        } catch (Http2Exception e) {
                            e = e;
                        } catch (RuntimeException e2) {
                            e = e2;
                        }
                        try {
                            if (http2Exception == null) {
                                int onDataRead = DefaultHttp2ConnectionDecoder.this.listener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
                                flowController.consumeBytes(stream, onDataRead);
                                if (z) {
                                    DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(stream, channelHandlerContext.newSucceededFuture());
                                }
                                return onDataRead;
                            }
                            throw http2Exception;
                        } catch (Http2Exception e3) {
                            e = e3;
                            unconsumedBytes2 = unconsumedBytes;
                            int unconsumedBytes3 = readableBytes - (unconsumedBytes2 - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                            throw e;
                        } catch (RuntimeException e4) {
                            e = e4;
                            unconsumedBytes2 = unconsumedBytes;
                            int unconsumedBytes4 = readableBytes - (unconsumedBytes2 - DefaultHttp2ConnectionDecoder.this.unconsumedBytes(stream));
                            throw e;
                        }
                    } catch (Throwable th) {
                        flowController.consumeBytes(stream, readableBytes);
                        if (z) {
                            DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(stream, channelHandlerContext.newSucceededFuture());
                        }
                        throw th;
                    }
                }
            } catch (Throwable unused) {
            }
            flowController.receiveFlowControlledFrame(stream, byteBuf, i2, z);
            flowController.consumeBytes(stream, readableBytes);
            verifyStreamMayHaveExisted(i);
            return readableBytes;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            onHeadersRead(channelHandlerContext, i, http2Headers, 0, (short) 16, false, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.listener.onPingAckRead(channelHandlerContext, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.encoder.writePing(channelHandlerContext, true, byteBuf.retainedSlice(), channelHandlerContext.newPromise());
            DefaultHttp2ConnectionDecoder.this.listener.onPingRead(channelHandlerContext, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            try {
                if (stream == null) {
                    if (DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                        DefaultHttp2ConnectionDecoder.logger.info("{} ignoring PRIORITY frame for stream {}. Stream doesn't exist but may  have existed", channelHandlerContext.channel(), Integer.valueOf(i));
                        return;
                    }
                    stream = DefaultHttp2ConnectionDecoder.this.connection.remote().createIdleStream(i);
                } else if (streamCreatedAfterGoAwaySent(i)) {
                    DefaultHttp2ConnectionDecoder.logger.info("{} ignoring PRIORITY frame for stream {}. Stream created after GOAWAY sent. Last known stream by peer {}", channelHandlerContext.channel(), Integer.valueOf(i), Integer.valueOf(DefaultHttp2ConnectionDecoder.this.connection.remote().lastStreamKnownByPeer()));
                    return;
                }
                stream.setPriority(i2, s, z);
            } catch (Http2Exception.ClosedStreamCreationException unused) {
            }
            DefaultHttp2ConnectionDecoder.this.listener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, stream, "PUSH_PROMISE")) {
                return;
            }
            if (stream == null) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d does not exist", Integer.valueOf(i));
            }
            int i4 = C138391.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
            if (i4 != 1 && i4 != 2) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state for receiving push promise: %s", Integer.valueOf(stream.mo12684id()), stream.state());
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isAuthoritative(channelHandlerContext, http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not authoritative", Integer.valueOf(i), Integer.valueOf(i2));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isCacheable(http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be cacheable", Integer.valueOf(i), Integer.valueOf(i2));
            }
            if (!DefaultHttp2ConnectionDecoder.this.requestVerifier.isSafe(http2Headers)) {
                throw Http2Exception.streamError(i2, Http2Error.PROTOCOL_ERROR, "Promised request on stream %d for promised stream %d is not known to be safe", Integer.valueOf(i), Integer.valueOf(i2));
            }
            DefaultHttp2ConnectionDecoder.this.connection.remote().reservePushStream(i2, stream);
            DefaultHttp2ConnectionDecoder.this.listener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i3);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (stream == null) {
                verifyStreamMayHaveExisted(i);
                return;
            }
            int i2 = C138391.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[stream.state().ordinal()];
            if (i2 != 4) {
                if (i2 == 6) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "RST_STREAM received for IDLE stream %d", Integer.valueOf(i));
                }
                DefaultHttp2ConnectionDecoder.this.listener.onRstStreamRead(channelHandlerContext, i, j);
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStream(stream, channelHandlerContext.newSucceededFuture());
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            Http2Settings pollSentSettings = DefaultHttp2ConnectionDecoder.this.encoder.pollSentSettings();
            if (pollSentSettings != null) {
                applyLocalSettings(pollSentSettings);
            }
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.encoder.remoteSettings(http2Settings);
            DefaultHttp2ConnectionDecoder.this.encoder.writeSettingsAck(channelHandlerContext, channelHandlerContext.newPromise());
            DefaultHttp2ConnectionDecoder.this.listener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (stream != null && stream.state() != Http2Stream.State.CLOSED && !streamCreatedAfterGoAwaySent(i)) {
                DefaultHttp2ConnectionDecoder.this.encoder.flowController().incrementWindowSize(stream, i2);
                DefaultHttp2ConnectionDecoder.this.listener.onWindowUpdateRead(channelHandlerContext, i, i2);
                return;
            }
            verifyStreamMayHaveExisted(i);
        }

        /* synthetic */ FrameReadListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, C138391 c138391) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
            Http2Stream http2Stream;
            boolean z3;
            Http2Stream stream = DefaultHttp2ConnectionDecoder.this.connection.stream(i);
            if (stream != null || DefaultHttp2ConnectionDecoder.this.connection.streamMayHaveExisted(i)) {
                http2Stream = stream;
                z3 = false;
            } else {
                Http2Stream createStream = DefaultHttp2ConnectionDecoder.this.connection.remote().createStream(i, z2);
                z3 = createStream.state() == Http2Stream.State.HALF_CLOSED_REMOTE;
                http2Stream = createStream;
            }
            if (shouldIgnoreHeadersOrDataFrame(channelHandlerContext, i, http2Stream, "HEADERS")) {
                return;
            }
            int i4 = C138391.$SwitchMap$io$netty$handler$codec$http2$Http2Stream$State[http2Stream.state().ordinal()];
            if (i4 != 1 && i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        throw Http2Exception.streamError(http2Stream.mo12684id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo12684id()), http2Stream.state());
                    }
                    if (i4 != 5) {
                        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo12684id()), http2Stream.state());
                    }
                    http2Stream.open(z2);
                } else if (!z3) {
                    throw Http2Exception.streamError(http2Stream.mo12684id(), Http2Error.STREAM_CLOSED, "Stream %d in unexpected state: %s", Integer.valueOf(http2Stream.mo12684id()), http2Stream.state());
                }
            }
            try {
                http2Stream.setPriority(i2, s, z);
            } catch (Http2Exception.ClosedStreamCreationException unused) {
            }
            DefaultHttp2ConnectionDecoder.this.listener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
            if (z2) {
                DefaultHttp2ConnectionDecoder.this.lifecycleManager.closeStreamRemote(http2Stream, channelHandlerContext.newSucceededFuture());
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class PrefaceFrameListener implements Http2FrameListener {
        private PrefaceFrameListener() {
        }

        private void verifyPrefaceReceived() throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received non-SETTINGS as first frame.", new Object[0]);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            return DefaultHttp2ConnectionDecoder.this.internalFrameListener.onDataRead(channelHandlerContext, i, byteBuf, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onGoAwayRead0(channelHandlerContext, i, j, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingAckRead(channelHandlerContext, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPingRead(channelHandlerContext, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPriorityRead(channelHandlerContext, i, i2, s, z);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onPushPromiseRead(channelHandlerContext, i, i2, http2Headers, i3);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onRstStreamRead(channelHandlerContext, i, j);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsAckRead(channelHandlerContext);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
            if (!DefaultHttp2ConnectionDecoder.this.prefaceReceived()) {
                DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = DefaultHttp2ConnectionDecoder.this;
                defaultHttp2ConnectionDecoder.internalFrameListener = new FrameReadListener(defaultHttp2ConnectionDecoder, null);
            }
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onSettingsRead(channelHandlerContext, http2Settings);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
            DefaultHttp2ConnectionDecoder.this.onUnknownFrame0(channelHandlerContext, b, i, http2Flags, byteBuf);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onWindowUpdateRead(channelHandlerContext, i, i2);
        }

        /* synthetic */ PrefaceFrameListener(DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder, C138391 c138391) {
            this();
        }

        @Override // io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) throws Http2Exception {
            verifyPrefaceReceived();
            DefaultHttp2ConnectionDecoder.this.internalFrameListener.onHeadersRead(channelHandlerContext, i, http2Headers, i2, s, z, i3, z2);
        }
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader) {
        this(http2Connection, http2ConnectionEncoder, http2FrameReader, Http2PromisedRequestVerifier.ALWAYS_VERIFY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int unconsumedBytes(Http2Stream http2Stream) {
        return flowController().unconsumedBytes(http2Stream);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.frameReader.close();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Connection connection() {
        return this.connection;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Http2Exception {
        this.frameReader.readFrame(channelHandlerContext, byteBuf, this.internalFrameListener);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public final Http2LocalFlowController flowController() {
        return this.connection.local().flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void frameListener(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "listener");
    }

    Http2FrameListener internalFrameListener() {
        return this.internalFrameListener;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.lifecycleManager = (Http2LifecycleManager) ObjectUtil.checkNotNull(http2LifecycleManager, "lifecycleManager");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2Settings localSettings() {
        Http2Settings http2Settings = new Http2Settings();
        Http2FrameReader.Configuration configuration = this.frameReader.configuration();
        Http2HeaderTable headerTable = configuration.headerTable();
        Http2FrameSizePolicy frameSizePolicy = configuration.frameSizePolicy();
        http2Settings.initialWindowSize(flowController().initialWindowSize());
        http2Settings.maxConcurrentStreams(this.connection.remote().maxActiveStreams());
        http2Settings.headerTableSize(headerTable.maxHeaderTableSize());
        http2Settings.maxFrameSize(frameSizePolicy.maxFrameSize());
        http2Settings.maxHeaderListSize(headerTable.maxHeaderListSize());
        if (!this.connection.isServer()) {
            http2Settings.pushEnabled(this.connection.local().allowPushTo());
        }
        return http2Settings;
    }

    void onGoAwayRead0(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) throws Http2Exception {
        if (this.connection.goAwayReceived() && this.connection.local().lastStreamKnownByPeer() < i) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "lastStreamId MUST NOT increase. Current value: %d new value: %d", Integer.valueOf(this.connection.local().lastStreamKnownByPeer()), Integer.valueOf(i));
        }
        this.listener.onGoAwayRead(channelHandlerContext, i, j, byteBuf);
        this.connection.goAwayReceived(i, j, byteBuf);
    }

    void onUnknownFrame0(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b, i, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public boolean prefaceReceived() {
        return FrameReadListener.class == this.internalFrameListener.getClass();
    }

    public DefaultHttp2ConnectionDecoder(Http2Connection http2Connection, Http2ConnectionEncoder http2ConnectionEncoder, Http2FrameReader http2FrameReader, Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        this.internalFrameListener = new PrefaceFrameListener(this, null);
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.frameReader = (Http2FrameReader) ObjectUtil.checkNotNull(http2FrameReader, "frameReader");
        this.encoder = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        this.requestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "requestVerifier");
        if (http2Connection.local().flowController() == null) {
            http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection));
        }
        http2Connection.local().flowController().frameWriter(http2ConnectionEncoder.frameWriter());
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionDecoder
    public Http2FrameListener frameListener() {
        return this.listener;
    }
}
